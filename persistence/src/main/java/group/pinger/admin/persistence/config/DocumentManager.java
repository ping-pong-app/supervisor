package group.pinger.admin.persistence.config;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class DocumentManager {
    
    private static final Logger LOG = LogManager.getLogger(DocumentManager.class.getName());
    
    private static final AtomicReference<MongoDatabase> database = new AtomicReference<>();
    
    private static final AtomicReference<MongoClient> client = new AtomicReference<>();
    
    @Inject
    private MongoConfig config;
    
    public void openConnection() {
        LOG.info("Connecting to document database on address {}...", String.format("%s:%d", config.getHost(), config.getPort()));
        MongoCredential credential = MongoCredential.createCredential(config.getUsername(), config.getDatabase(), config.getPassword().toCharArray());
        client.set(MongoClients.create(
            MongoClientSettings.builder()
                .applyToClusterSettings(builder -> {
                    builder.hosts(Collections.singletonList(new ServerAddress(config.getHost(), config.getPort())));
                })
                .credential(credential)
                .build()
            )
        );
        database.set(client.get().getDatabase(config.getDatabase()));
        LOG.info("Connected to document database!");
    }
    
    @PreDestroy
    private void onDestroy() {
        client.get().close();
    }
    
    public synchronized MongoDatabase getDatabase() {
        return database.get();
    }
    
    public void insertDocument(Document document, String collection) {
        if (document == null) {
            return;
        }
        getDatabase().getCollection(collection).insertOne(document);
    }
    
    public void removeDocument(Document document, String collection) {
        getDatabase().getCollection(collection).deleteOne(document);
    }
    
    public void healtcheck() {
        getDatabase().getCollection("healthcheck").find(new Document()).limit(1);
    }
    
}
