package group.pinger.admin.api.producers;

import com.kumuluz.ee.rest.utils.QueryStringDefaults;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class RestProducer {
    
    @Produces
    @ApplicationScoped
    public QueryStringDefaults getQueryStringDefaults() {
        return new QueryStringDefaults()
            .maxLimit(100)
            .defaultLimit(25)
            .defaultOffset(0);
    }
    
}
