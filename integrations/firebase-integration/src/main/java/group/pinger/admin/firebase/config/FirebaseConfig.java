package group.pinger.admin.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class FirebaseConfig {
    
    private static final Logger LOG = LogManager.getLogger(FirebaseConfig.class.getName());
    
    public void initializeFirebase() {
        try {
            LOG.info("Initializing Firebase services...");
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();
    
            FirebaseApp.initializeApp(options);
            LOG.info("Firebase initialization complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
