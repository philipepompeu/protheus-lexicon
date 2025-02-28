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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.DTO.DownloadFile;
import com.philipepompeu.protheus_lexicon_backend.DTO.TableDto;
import com.philipepompeu.protheus_lexicon_backend.domain.FieldEntity;

@Service
public class TableReportService {

    private static final Logger logger = LoggerFactory.getLogger(TableReportService.class);
    
    private final FieldService fieldService;
    private final S3Service s3Service;

    public TableReportService(FieldService fieldService, S3Service s3Service){
        this.fieldService = fieldService;
        this.s3Service = s3Service;
    }


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

            DownloadFile fileS3 = new DownloadFile(filePath, filePath);
            
            File pdfFile = new File(filePath);
            
            String s3FileKey = s3Service.uploadFile(pdfFile);
            String url = s3Service.generatePresignedUrl(s3FileKey);

            pdfFile.delete();

            logger.info("PDF gerado com sucesso: " + filePath);

            return new DownloadFile(filePath, url);
        } catch (IOException e) {
            logger.error("Falha na geração do pdf.", e);
        }
        
        return null;

    }
    
}
