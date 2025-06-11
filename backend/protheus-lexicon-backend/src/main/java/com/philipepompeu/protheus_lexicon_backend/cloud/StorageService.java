package com.philipepompeu.protheus_lexicon_backend.cloud;

import java.io.File;

public interface StorageService {

    String uploadFile(File file);
    String generateUrl(String fileId);
    void deleteFile(String fileId);    
}
