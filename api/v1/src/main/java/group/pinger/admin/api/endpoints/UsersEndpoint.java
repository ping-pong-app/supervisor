package group.pinger.admin.api.endpoints;

import com.google.firebase.auth.UserRecord;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.QueryStringDefaults;
import group.pinger.admin.firebase.FirebaseService;
import group.pinger.admin.firebase.models.FirebaseEntityList;
import group.pinger.admin.firebase.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@RequestScoped
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersEndpoint {
    
    @Context
    protected UriInfo uriInfo;
    
    @Inject
    private QueryStringDefaults queryStringDefaults;
    
    @Inject
    private FirebaseService firebaseService;
    
    @GET
    public Response getUsers(@HeaderParam("X-Page-Token") String pageToken) {
        QueryParameters queryParameters = queryStringDefaults.builder().queryEncoded(uriInfo.getRequestUri().getQuery()).build();
        
        FirebaseEntityList<User> list = firebaseService.getUsers(queryParameters, pageToken);
        
        return Response
            .ok(list.getEntityList())
            .header("X-Page-Token", list.getPageToken())
            .header("X-Limit", queryParameters.getLimit())
            .build();
    }
    
}
