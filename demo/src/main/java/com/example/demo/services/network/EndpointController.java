package com.example.demo.services.network;

import com.example.demo.core.Product;
import com.example.demo.core.Investor;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.MainController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class EndpointController {
    private MainController app;
    public EndpointController(MainController app){
        this.app = app;
    }
    @RequestMapping("/")
    public String home(){
        return "Interview Application";
    }

    @GetMapping("/AllProducts")
    public List<Product> getAllProducts(){
        return app.getCollectionServices()
                .getAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable String id){
        return app.getCollectionServices().getProduct(id);
    }

    @RequestMapping("/saveInvestor")
    public String saveInvestor(@RequestBody Investor investor) {

        app.getCollectionServices().saveInvestor(investor);

        return "SAVED";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(@RequestBody Product product, @PathVariable Integer id) {
        Optional<Investor> investorOpt = app.getCollectionServices().getInvestor(id);

        investorOpt.ifPresent(investor -> app.getCollectionServices().saveProduct(product, investor));

        return "OK";
    }

//    @GetMapping("/AllProducts/{investor}")
//    public List<Product> getAllProductsByInvestor(@RequestBody Investor investor){
//        return app.getCollectionServices().getProductRepository().findByInvestor(investor);
//    }

//    @PostMapping("/createSavings/{investorId}")
//    public String createSavings(@RequestBody Savings savings, @PathVariable String investor){
//        Optional<Investor> investorOpt = app.getCollectionServices().getInvestorRepository().findById(Integer.getInteger(investor));
//
//        investorOpt.ifPresent(savings::setInvestor);
//
//        app.getCollectionServices().getProductRepository().save(savings);
//        return "Savings Product Created " + savings.getBalance();
//    }
//
//    @PostMapping("/createRetirements/{investorId}")
//    public String createRetirements(@RequestBody Retirement retirement, @PathVariable String investor){
//        Optional<Investor> investorOpt = app.getCollectionServices().getInvestorRepository().findById(Integer.getInteger(investor));
//
//        investorOpt.ifPresent(retirement::setInvestor);
//
//        app.getCollectionServices().getProductRepository().save(retirement);
//        return "Retirements Product Created " + retirement.getBalance();
//    }

    @PostMapping("/newInvestor")
    public String createNewInvestor(@RequestBody Investor investor){
        app.getCollectionServices().saveInvestor(investor);
//        app.getCollectionServices().getInvestorRepository().save(investor);
        return "Welcome " + investor.getName();
    }

//    @PutMapping("/withdraw/{amount}")
//    public String withdraw(@PathVariable String id ,@PathVariable String amount){
//
//        Optional<Product> productOpt = app.getCollectionServices().getProductRepository().findById(id);
//
//       if( app.getAccountServices().startWithdrawalProcess(productOpt, amount)){
//           return "withdrawing successful";
//       } else {
//           return "failed";
//       }
//
//    }

}
