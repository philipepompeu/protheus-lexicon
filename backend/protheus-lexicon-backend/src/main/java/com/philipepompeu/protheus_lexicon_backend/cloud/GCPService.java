package com.philipepompeu.protheus_lexicon_backend.cloud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;


import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Service
public class GCPService implements StorageService {

    private final String bucketName = "protheus-lexicon-gcp";
   
    private String credentialsPath = "/gcp-credentials.json";

    private final Storage storage;

    public GCPService() throws FileNotFoundException, IOException{

        InputStream credentialsStream = new ClassPathResource(credentialsPath).getInputStream();

        this.storage = StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(credentialsStream))
                .build()
                .getService();
    }

    @Override
    public String uploadFile(File file) {
        String fileName = "pdfs/" + file.getName();
        
        try {
            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/pdf").build();            
            
            storage.create(blobInfo, new FileInputStream(file));            

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao fazer upload para o GCP Storage", e);
        }
    }

    @Override
    public String generateUrl(String fileKey) {
        BlobId blobId = BlobId.of(bucketName, fileKey);
        Blob blob = storage.get(blobId);

        if (blob == null) {
            throw new RuntimeException("Arquivo não encontrado: " + fileKey);
        }

        URL signedUrl = blob.signUrl(1, TimeUnit.HOURS);
        return signedUrl.toString();
    }

    @Override
    public void deleteFile(String fileId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFile'");
    }

}
