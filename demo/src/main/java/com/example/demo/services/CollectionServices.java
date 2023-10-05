package com.example.demo.services;

import com.example.demo.core.Investor;
import com.example.demo.core.Product;
import com.example.demo.services.network.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollectionServices {

//    @Autowired
//    private ProductRepository productRepository;

//    @Autowired
//    private InvestorRepository investorRepository;

    private Map<Investor, Set<Product>> investorProducts;
    private MainController app;

    public CollectionServices(MainController baseApp) {
        this.app = baseApp;
    }

//    public ProductRepository getProductRepository() {
//        return productRepository;
//    }

//    public InvestorRepository getInvestorRepository() {
//        return investorRepository;
//    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        investorProducts.values().forEach(products::addAll);

        return Collections.unmodifiableList(products);
    }

    public List<Investor> getAllInvestors() {
        return investorProducts.keySet().stream().toList();
    }

    public void saveProduct(Product product, Investor investor){
        Set<Product> set = new HashSet<>();
        set.add(product);

        investorProducts.computeIfPresent(investor, (key, value) -> {
           value.add(product);
           return value;
        });

    }

    public void saveInvestor(Investor investor){
        investorProducts.putIfAbsent(investor, new HashSet<>());
    }

    public Optional<Investor> getInvestor(Integer id) {

        return investorProducts.keySet()
                .stream()
                .filter(investor -> investor.getId().equals(id))
                .findAny();
    }

    public Optional<Product> getProduct(String id) {
        return investorProducts.values().forEach(products -> products.forEach());
    }
}
