package com.gatherProject.GatherBackend.Services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FBInitialize {
    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream(System.getenv("GATHER_SERVICE_ACCOUNT_KEY"));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(System.getenv("GATHER_DATABASE_URL"))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

