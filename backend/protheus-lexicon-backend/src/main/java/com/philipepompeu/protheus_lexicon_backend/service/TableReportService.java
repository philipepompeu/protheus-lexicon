package com.philipepompeu.protheus_lexicon_backend.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.hibernate.annotations.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.DTO.DownloadFile;
import com.philipepompeu.protheus_lexicon_backend.DTO.TableDto;
import com.philipepompeu.protheus_lexicon_backend.cloud.StorageService;
import com.philipepompeu.protheus_lexicon_backend.cloud.StorageServiceFactory;
import com.philipepompeu.protheus_lexicon_backend.domain.FieldEntity;

@Service
public class TableReportService {

    private static final Logger logger = LoggerFactory.getLogger(TableReportService.class);
    
    private final FieldService fieldService;
    private final StorageService storageService;

    public TableReportService(FieldService fieldService, StorageServiceFactory storageFactory){
        this.fieldService = fieldService;
        this.storageService = storageFactory.getStorageService();

        TableReportService.logger.debug(String.format("StorageService[ %s ]", storageService.getClass().getName()));       
        
    }


    @Cacheable(value="printReport", key="#table.id" , unless="#result == null")
    public DownloadFile printReport(TableDto table){
        List<FieldEntity> fields = fieldService.getFieldsByTableId(table.getId());
        
        String filePath = String.format("tabela-%s-%s.pdf", table.getId(), UUID.randomUUID().toString());

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            
            contentStream.showText(table.getDescription());
            contentStream.endText();

            // Desenhar tabela
            float margin = 100;
            float yStart = 650;
            float tableWidth = 400;
            float rowHeight = 20;
            float yPosition = yStart;

            String[] headers = {"Campo", "Titulo", "Tipo"};

            // Cabeçalhos
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
            for (String header : headers) {
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(header);
                contentStream.endText();
                margin += 130;
            }

            // Dados
            margin = 100;
            yPosition -= rowHeight;
            contentStream.setFont(PDType1Font.HELVETICA, 10);

            for (FieldEntity field : fields) {

                
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(field.getField());
                contentStream.endText();
                margin += 130;

                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(field.getDescription());
                contentStream.endText();
                margin += 130;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(field.getType());
                contentStream.endText();
                margin += 130;
                
                margin = 100;
                yPosition -= rowHeight;
            }            

            contentStream.close();
            document.save(filePath);             
            
            File pdfFile = new File(filePath);
            
            String s3FileKey = storageService.uploadFile(pdfFile);
            String url = storageService.generateUrl(s3FileKey);

            pdfFile.delete();

            logger.info("PDF gerado com sucesso: " + filePath);

            return new DownloadFile(filePath, url);
        } catch (Exception e) {
            logger.error("Falha na geração do pdf.", e);
        }
        
        return null;

    }
    
}
