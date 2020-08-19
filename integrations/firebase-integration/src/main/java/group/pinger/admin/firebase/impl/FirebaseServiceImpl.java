package group.pinger.admin.firebase.impl;

import com.google.firebase.auth.*;
import com.kumuluz.ee.rest.beans.QueryParameters;
import group.pinger.admin.firebase.FirebaseService;
import group.pinger.admin.firebase.mappers.UserMapper;
import group.pinger.admin.firebase.models.FirebaseEntityList;
import group.pinger.admin.firebase.models.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FirebaseServiceImpl implements FirebaseService {
    
    @Override
    public FirebaseEntityList<User> getUsers(QueryParameters queryParameters, String pageToken) {
        List<User> users = new ArrayList<>();
        try {
            ListUsersPage page = FirebaseAuth.getInstance().listUsers(pageToken, Math.toIntExact(queryParameters.getLimit()));
            page.getValues().forEach(user -> users.add(UserMapper.fromRecord(user)));
            return new FirebaseEntityList<>(users, page.getNextPageToken());
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            throw new RuntimeException("exception");
        }
    }
    
    @Override
    public User searchByEmail(String email) {
        try {
            UserRecord record = FirebaseAuth.getInstance().getUserByEmail(email);
            return UserMapper.fromRecord(record);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    @Override
    public User searchById(String userId) {
        try {
            UserRecord record = FirebaseAuth.getInstance().getUser(userId);
            return UserMapper.fromRecord(record);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    @Override
    public User disableUser(String userId) {
        return updateUserStatus(userId, true);
    }
    
    @Override
    public User enableUser(String userId) {
        return updateUserStatus(userId, false);
    }
    
    @Override
    public User setAsTrustedUser(String userId) {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(userId)
            .setEmailVerified(true)
            .setDisabled(false);
        
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().updateUser(request);
            return UserMapper.fromRecord(userRecord);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    private User updateUserStatus(String userId, boolean disabled) {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(userId).setDisabled(disabled);
        
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().updateUser(request);
            return UserMapper.fromRecord(userRecord);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
