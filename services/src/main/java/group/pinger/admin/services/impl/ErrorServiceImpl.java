package group.pinger.admin.services.impl;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.mjamsek.rest.dto.EntityList;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import group.pinger.admin.lib.error.BaseError;
import group.pinger.admin.mappers.ErrorMapper;
import group.pinger.admin.persistence.config.CollectionsConfig;
import group.pinger.admin.persistence.config.DocumentManager;
import group.pinger.admin.services.ErrorService;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class ErrorServiceImpl implements ErrorService {
    
    private static final Logger LOG = LogManager.getLogger(ErrorServiceImpl.class.getSimpleName());
    
    @Inject
    private DocumentManager documentManager;
    
    @Override
    public void persistError(BaseError error) {
        CompletableFuture.runAsync(() -> {
            
            error.setTimestamp(new Date());
            Document document = ErrorMapper.toDocument(error);
            
            try {
                documentManager.insertDocument(document, CollectionsConfig.ERRORS);
            } catch (MongoException e) {
                LOG.error("Exception thrown when persisting error log!");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    @Override
    public EntityList<BaseError> getErrors(QueryParameters queryParameters, String base64Query) {
        String regexQuery = decodeBase64(base64Query);
        
        MongoCollection<Document> collection = documentManager.getDatabase().getCollection(CollectionsConfig.ERRORS);
        
        FindIterable<Document> documents;
        long count;
        
        if (regexQuery == null) {
            documents = collection
                .find()
                .skip(Math.toIntExact(queryParameters.getOffset()))
                .limit(Math.toIntExact(queryParameters.getLimit()));
            count = collection.countDocuments();
        } else {
            Bson queryFilter = Filters.or(
                Filters.regex("message", regexQuery),
                Filters.regex("data", regexQuery)
            );
            
            documents = collection
                .find(queryFilter)
                .skip(Math.toIntExact(queryParameters.getOffset()))
                .limit(Math.toIntExact(queryParameters.getLimit()));
            
            count = collection.countDocuments(queryFilter);
        }
        
        List<BaseError> errors = new ArrayList<>();
        
        for (Document document : documents) {
            errors.add(ErrorMapper.fromDocument(document));
        }
        
        return new EntityList<>(errors, count);
    }
    
    private String decodeBase64(String encodedBase64) {
        if (encodedBase64 == null) {
            return null;
        }
        return new String(Base64.getDecoder().decode(encodedBase64));
    }
}
