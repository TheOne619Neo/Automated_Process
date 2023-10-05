package com.example.demo.services;

import com.example.demo.services.network.EndpointController;
import org.springframework.stereotype.Service;

@Service
public class MainController {
    private final ReportServices reportServices = new ReportServices(this);
    private final CollectionServices collectionServices = new CollectionServices(this);
    private final AccountServices accountServices = new AccountServices();
    private final EndpointController controller = new EndpointController(this);

    public AccountServices getAccountServices() {
        return accountServices;
    }
    public CollectionServices getCollectionServices() {
        return collectionServices;
    }
}
