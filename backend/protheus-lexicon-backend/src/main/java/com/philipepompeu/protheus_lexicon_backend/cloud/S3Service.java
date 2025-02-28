package com.philipepompeu.protheus_lexicon_backend.cloud;

import java.io.File;
import java.time.Duration;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.core.sync.RequestBody;


@Service
@Getter
@Setter
public class S3Service implements StorageService {
    
    private final String bucketName = "protheus-lexicon";

    private final S3Client s3Client;

    public S3Service() {
        this.s3Client = S3Client.builder()
                .region(Region.SA_EAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }

    public String uploadFile(File file) {     
        
        String s3Key = "pdfs/" + file.getName();

        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(this.bucketName)
                        .key(s3Key)
                        .contentType("application/pdf")
                        .build(),
                RequestBody.fromFile(file)
        );

        return s3Key;
    }

    public String generateUrl(String s3Key) {

        
        try (S3Presigner presigner = S3Presigner.builder()
                                                .region(Region.SA_EAST_1)
                                                .build()
        ) {
            
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(this.bucketName)
                    .key(s3Key)
                    .build();
    
            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofHours(1)) // Expira em 1 hora
                    .getObjectRequest(getObjectRequest)
                    .build();
    
            return presigner.presignGetObject(presignRequest).url().toString();
        }
    }

    @Override
    public void deleteFile(String fileId) {     
        
        s3Client.deleteObject(DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(fileId)
                .build());
    }

}
