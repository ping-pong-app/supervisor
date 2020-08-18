package group.pinger.admin.api.health;

import group.pinger.admin.persistence.config.DocumentManager;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Readiness
public class MongoHealthCheck implements HealthCheck {
    
    private static final String HEALTHCHECK_NAME = "MongoHealthCheck";
    
    @Inject
    private DocumentManager documentManager;
    
    @Override
    public HealthCheckResponse call() {
        try {
            documentManager.healtcheck();
        } catch (Exception e) {
            return HealthCheckResponse.named(HEALTHCHECK_NAME).down().build();
        }
        return HealthCheckResponse.named(HEALTHCHECK_NAME).up().build();
    }
}
