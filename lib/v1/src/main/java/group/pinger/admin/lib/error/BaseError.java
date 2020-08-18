package group.pinger.admin.lib.error;

import group.pinger.admin.lib.enums.ClientType;
import group.pinger.admin.lib.enums.ErrorType;

import javax.json.bind.annotation.JsonbProperty;
import java.util.Date;

public class BaseError {
    
    public static final String FIELD_ID = "_id";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_TIMESTAMP = "timestamp";
    public static final String FIELD_MESSAGE = "message";
    public static final String FIELD_DATA = "data";
    
    public static final String FIELD_CLIENT_TYPE = "clientType";
    public static final String FIELD_CLIENT_NAME = "clientName";
    
    public static final String FIELD_ENV = "environment";
    
    @JsonbProperty("id")
    protected String id;
    
    @JsonbProperty("type")
    protected ErrorType type;
    
    @JsonbProperty("timestamp")
    protected Date timestamp;
    
    @JsonbProperty("message")
    protected String message;
    
    @JsonbProperty("data")
    protected String data;
    
    @JsonbProperty(value = "clientType", nillable = true)
    protected ClientType clientType;
    
    @JsonbProperty(value = "clientName", nillable = true)
    protected String clientName;
    
    @JsonbProperty(value = "environment", nillable = true)
    protected String environment;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public ErrorType getType() {
        return type;
    }
    
    public void setType(ErrorType type) {
        this.type = type;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public ClientType getClientType() {
        return clientType;
    }
    
    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    public String getEnvironment() {
        return environment;
    }
    
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
