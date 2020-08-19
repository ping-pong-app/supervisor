package group.pinger.admin.firebase.models;

import com.mjamsek.rest.dto.EntityList;

import java.util.List;

public class FirebaseEntityList<T> extends EntityList<T> {
    
    private String pageToken;
    
    public FirebaseEntityList(List<T> entities, String pageToken) {
        super(entities, 0);
        this.pageToken = pageToken;
    }
    
    public String getPageToken() {
        return pageToken;
    }
    
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
}
