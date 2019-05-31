package com.egopulse.profile.service.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class LoggerConfiguration {

    private static final Logger log = LoggerFactory.getLogger(LoggerConfiguration.class);

    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    private static final String LOGBACK_CONFIGURATION = "application.yml";


    @EventListener
    void onStartup(ServiceStartedEvent event) {
        log.info("====================================================================");
        log.info("====================================================================");
        log.info("====================================================================");
        log.info("====================================================================");

        try {
            // creating JoranConfigurator
//            JoranConfigurator joranConfigurator = new JoranConfigurator();
//
//            // setting logger context for JoranConfiguratior
//            joranConfigurator.setContext(loggerContext);
//
//            // resetting context, override default configuration
//            loggerContext.reset();
//
//            // configuring Logback with resource
//            joranConfigurator.doConfigure(LOGBACK_CONFIGURATION);
        } catch (Exception exception) {
            // exception handling
        }
    }

//    @PostConstruct
//    void loggerConfig() {
//
//
//    }
}
