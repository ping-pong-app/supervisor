package group.pinger.admin.api.endpoints;

import com.fasterxml.jackson.databind.JsonNode;
import group.pinger.admin.services.WebClientConfigurationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/web-config")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WebClientConfigEndpoint {
    
    @Inject
    private WebClientConfigurationService webClientService;
    
    @GET
    public Response getWebClientConfig() {
        String configuration = webClientService.generateWebClientConfiguration();
        
        return Response.ok(configuration).build();
    }
    
}
