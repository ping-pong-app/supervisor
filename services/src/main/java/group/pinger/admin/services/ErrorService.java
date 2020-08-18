package group.pinger.admin.services;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.mjamsek.rest.dto.EntityList;
import group.pinger.admin.lib.error.BaseError;

public interface ErrorService {
    
    void persistError(BaseError error);
    
    EntityList<BaseError> getErrors(QueryParameters queryParameters, String regexQuery);
    
}
