package group.pinger.admin.firebase.models;

import java.util.Date;
import java.util.Map;

public class User {
    
    private String id;
    
    private String email;
    
    private String displayName;
    
    private boolean emailVerified;
    
    private String photoUrl;
    
    private boolean disabled;
    
    private Date lastSignIn;
    
    private Date registered;
    
    private Map<String, Object> claims;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public boolean isEmailVerified() {
        return emailVerified;
    }
    
    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }
    
    public String getPhotoUrl() {
        return photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
    public boolean isDisabled() {
        return disabled;
    }
    
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    
    public Date getLastSignIn() {
        return lastSignIn;
    }
    
    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
    
    public Date getRegistered() {
        return registered;
    }
    
    public void setRegistered(Date registered) {
        this.registered = registered;
    }
    
    public Map<String, Object> getClaims() {
        return claims;
    }
    
    public void setClaims(Map<String, Object> claims) {
        this.claims = claims;
    }
}
