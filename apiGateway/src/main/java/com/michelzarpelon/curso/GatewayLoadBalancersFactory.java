package com.michelzarpelon.curso;

import io.micronaut.context.annotation.Factory;
import io.micronaut.http.client.LoadBalancer;
import io.micronaut.http.client.loadbalance.DiscoveryClientLoadBalancerFactory;
import jakarta.inject.Singleton;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Factory
public class GatewayLoadBalancersFactory {

    @Singleton
    public Map<String, LoadBalancer> serviceLoadBalancers(GatewayProperties gatewayProperties,
                                                          DiscoveryClientLoadBalancerFactory factory){
        Set<String> services = gatewayProperties.getServices();
        Map<String, LoadBalancer> loadBalancers =  new HashMap<>();
        services.forEach(s -> loadBalancers.put(s, factory.create(s)));
        return Collections.unmodifiableMap(loadBalancers);
    }

}
