package org.amuji.ninja.cart.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory-instances")
public class InventoryInstancesController {
    @Autowired
    private LoadBalancerClient lbClient;

    @GetMapping("any")
    public String any() {
        ServiceInstance instance = lbClient.choose("ninja-inventory-service");
        return String.format("%s:%s", instance.getHost(), instance.getPort());
    }
}
