package net.dni.restcontrollerlogging;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.dni.restcontrollerlogging.handler.LoggingHandlerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingHandlerInterceptor());
    }

    @Bean
    public FilterRegistrationBean<ServletContextRequestLoggingFilter> filterRegistrationBean(
            ServletContextRequestLoggingFilter servletContextRequestLoggingFilter) {
        FilterRegistrationBean<ServletContextRequestLoggingFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(servletContextRequestLoggingFilter);
        registration.addUrlPatterns("/*");
        registration.setName("servletContextRequestLoggingFilter");
        return registration;
    }

    @Bean
    public ServletContextRequestLoggingFilter servletContextRequestLoggingFilter() {
        ServletContextRequestLoggingFilter loggingFilter = new ServletContextRequestLoggingFilter();
        loggingFilter.setBeforeMessagePrefix("{\"before\":\"");
        loggingFilter.setBeforeMessageSuffix("\"}");
        loggingFilter.setAfterMessagePrefix("{\"after\":\"");
        loggingFilter.setAfterMessageSuffix("\"}");
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(true);
        return loggingFilter;
    }

}
