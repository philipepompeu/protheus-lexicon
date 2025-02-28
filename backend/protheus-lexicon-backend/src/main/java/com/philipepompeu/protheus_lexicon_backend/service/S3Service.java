package com.philipepompeu.protheus_lexicon_backend.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;


@Service
@Getter
@Setter
public class S3Service {

    //@Value("${aws.s3.bucket}")
    //private String bucketName;

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
                        .bucket("protheus-lexicon")
                        .key(s3Key)
                        .contentType("application/pdf")
                        .build(),
                RequestBody.fromFile(file)
        );

        return s3Key;
    }
}
