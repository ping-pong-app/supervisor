package group.pinger.admin.mappers;

import group.pinger.admin.lib.enums.ErrorType;
import group.pinger.admin.lib.error.BaseError;
import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorMapper {
    
    public static BaseError fromDocument(Document document) {
        BaseError error = new BaseError();
        error.setId(document.getObjectId(BaseError.FIELD_ID).toString());
        
        if (document.containsKey(BaseError.FIELD_TIMESTAMP)) {
            Date timestamp = document.getDate(BaseError.FIELD_TIMESTAMP);
            if (timestamp != null) {
                error.setTimestamp(timestamp);
            }
        }
        
        error.setType(ErrorType.valueOf(document.getString(BaseError.FIELD_TYPE)));
        error.setMessage(document.getString(BaseError.FIELD_MESSAGE));
        error.setData(document.getString(BaseError.FIELD_DATA));
        
        return error;
    }
    
    public static Document toDocument(BaseError error) {
        Document doc = new Document();
        
        doc.put(BaseError.FIELD_TYPE, error.getType().name());
        doc.put(BaseError.FIELD_MESSAGE, error.getMessage());
        doc.put(BaseError.FIELD_TIMESTAMP, error.getTimestamp());
        doc.put(BaseError.FIELD_DATA, error.getData());
        
        switch (error.getType()) {
            case CLIENT -> {
                doc.put(BaseError.FIELD_CLIENT_NAME, error.getClientName());
                doc.put(BaseError.FIELD_CLIENT_TYPE, error.getClientType().name());
            }
            case SERVER -> {
                doc.put(BaseError.FIELD_ENV, error.getEnvironment());
            }
            default -> {
                throw new IllegalArgumentException("Invalid error type!");
            }
        }
        
        return doc;
    }
    
    private static Date parseDate(String value) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        try {
            return dateFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }
    
}
