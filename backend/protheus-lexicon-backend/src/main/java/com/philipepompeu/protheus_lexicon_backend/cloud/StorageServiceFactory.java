package com.philipepompeu.protheus_lexicon_backend.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StorageServiceFactory {

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceFactory.class);

    private final S3Service s3StorageService; //AWS
    private final GCPService googleBlobService;//Google Cloud PLatform

    @Autowired
    public StorageServiceFactory(S3Service s3Service, GCPService gcpService){

        this.s3StorageService = s3Service;
        this.googleBlobService = gcpService;
    }

    public StorageService getStorageService(){

        StorageService service = this.s3StorageService;        
        
        logger.info(String.format("CloudStorage selected [ %s ]", service.getClass().getName()));

        return service;
    }

}
