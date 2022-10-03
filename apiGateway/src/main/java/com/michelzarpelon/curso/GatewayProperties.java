package com.michelzarpelon.curso;

import io.micronaut.context.annotation.ConfigurationProperties;
import java.util.Set;

@ConfigurationProperties("gateway")
public class GatewayProperties {
    private Set<String> services;

    public Set<String> getServices() {
        return services;
    }

    public void setServices(Set<String> services) {
        this.services = services;
    }
}
