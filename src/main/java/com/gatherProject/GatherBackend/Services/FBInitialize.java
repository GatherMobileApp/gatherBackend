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
                    new FileInputStream("C:\\Users\\charl\\Downloads\\service-account-key.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://fir-db-for-spring-boot-fa4de.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

