package group.pinger.admin.api.endpoints;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.QueryStringDefaults;
import com.mjamsek.rest.common.HttpHeaders;
import com.mjamsek.rest.dto.EntityList;
import group.pinger.admin.lib.error.BaseError;
import group.pinger.admin.services.ErrorService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@RequestScoped
@Path("/errors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ErrorEndpoint {
    
    @Context
    protected UriInfo uriInfo;
    
    @Inject
    private QueryStringDefaults queryStringDefaults;
    
    @Inject
    private ErrorService errorService;
    
    @GET
    public Response getErrors(@QueryParam("query") String query) {
        QueryParameters queryParameters = queryStringDefaults.builder().queryEncoded(uriInfo.getRequestUri().getQuery()).build();
        EntityList<BaseError> errors = errorService.getErrors(queryParameters, query);
        return Response
            .ok(errors.getEntityList())
            .header(HttpHeaders.X_TOTAL_COUNT, errors.getCount())
            .header("X-Limit", queryParameters.getLimit())
            .header("X-Offset", queryParameters.getOffset())
            .build();
    }
    
    @POST
    public Response persistError(BaseError error) {
        errorService.persistError(error);
        return Response.accepted().build();
    }
    
}
