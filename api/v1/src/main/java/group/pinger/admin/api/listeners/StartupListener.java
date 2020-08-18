package group.pinger.admin.api.listeners;

import group.pinger.admin.persistence.config.DocumentManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@ApplicationScoped
public class StartupListener implements ServletContextListener {
    
    @Inject
    private DocumentManager documentManager;
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        documentManager.openConnection();
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    
    }
}
