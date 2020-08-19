package group.pinger.admin.firebase;

import com.kumuluz.ee.rest.beans.QueryParameters;
import group.pinger.admin.firebase.models.FirebaseEntityList;
import group.pinger.admin.firebase.models.User;

public interface FirebaseService {
    
    FirebaseEntityList<User> getUsers(QueryParameters queryParameters, String pageToken);
    
    User searchByEmail(String email);
    
    User searchById(String userId);
    
    User disableUser(String userId);
    
    User enableUser(String userId);
    
    User setAsTrustedUser(String userId);
}
