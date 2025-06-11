package com.philipepompeu.protheus_lexicon_backend.cloud;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;

public class AwsCloudWatchConfig {
    
     public static AwsCredentialsProvider getCredentials() {        
        return ProfileCredentialsProvider.create();
    }
}
