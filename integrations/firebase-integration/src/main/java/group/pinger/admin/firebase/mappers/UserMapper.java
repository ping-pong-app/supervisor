package group.pinger.admin.firebase.mappers;

import com.google.firebase.auth.UserRecord;
import group.pinger.admin.firebase.models.User;

import java.util.Date;

public class UserMapper {
    
    public static User fromRecord(UserRecord record) {
        User user = new User();
        
        user.setId(record.getUid());
        user.setDisplayName(record.getDisplayName());
        user.setEmail(record.getEmail());
        user.setPhotoUrl(record.getPhotoUrl());
        user.setEmailVerified(record.isEmailVerified());
        user.setDisabled(record.isDisabled());
        user.setClaims(record.getCustomClaims());
        
        long lastSignInTimestamp = record.getUserMetadata().getLastSignInTimestamp();
        // Date lastSignInDate = new Date(TimeUnit.SECONDS.toMillis(lastSignInTimestamp));
        Date lastSignInDate = new Date(lastSignInTimestamp);
        user.setLastSignIn(lastSignInDate);
        
        long registeredTimestamp = record.getUserMetadata().getCreationTimestamp();
        Date registeredDate = new Date(registeredTimestamp);
        user.setRegistered(registeredDate);
        
        return user;
    }
    
}
