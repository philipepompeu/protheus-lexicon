package com.philipepompeu.protheus_lexicon_backend.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StorageServiceFactory {

    private final S3Service s3StorageService;
    private final GCPService googleBlobService;

    @Autowired
    public StorageServiceFactory(S3Service s3Service, GCPService gcpService){

        this.s3StorageService = s3Service;
        this.googleBlobService = gcpService;
    }

    public StorageService getStorageService(){
        //return this.s3StorageService;
        System.out.println("Deveria retornar um GCPService");
        return this.googleBlobService;
    }

}
