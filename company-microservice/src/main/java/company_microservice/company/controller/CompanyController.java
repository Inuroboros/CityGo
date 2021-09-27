package company_microservice.company.controller;

import company_microservice.company.model.Company;
import company_microservice.company.model.Log;
import company_microservice.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("")
    public List<Company> findAllCompanies(){
        Log log = new Log(1, "CompanyService", "GET", "List of companies");

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://localhost:8085/logs", request, Log.class);

        System.out.println(log.toString());

        return companyService.findAllCompany();

    }

    @GetMapping("/{id}")
    public Optional<Company> findCompanyById(@PathVariable Long id){
        Log log = new Log(1, "CompanyService", "GET", companyService.findCompanyById(id).toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://localhost:8085/logs", request, Log.class);
        System.out.println(log.toString());

        return companyService.findCompanyById(id);
    }
/*
    @GetMapping("/companyName/{companyName}")
    public Optional<Company> findCompanyByName(@PathVariable String companyName){
        return companyService.findCompanyByName(companyName);
    }

    @GetMapping("/bik/{bik}")
    public Optional<Company> findCompanyByBIK(@PathVariable String bik){
        return companyService.findCompanyByBIK(bik);
    }

    @GetMapping("/address/{address}")
    public Optional<Company> findCompanyByAddress(@PathVariable String address){
        return companyService.findCompanyByAddress(address);
    }
*/
    @PostMapping("/create")
    public void createCompany(@RequestBody Company company){
        Log log = new Log(1, "CompanyService", "POST", company.toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://localhost:8085/logs", request, Log.class);
        System.out.println(log.toString());

        companyService.createCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id){
        Log log = new Log(1, "CompanyService", "DELETE", companyService.findCompanyById(id).toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://localhost:8085/logs", request, Log.class);
        System.out.println(log.toString());

        companyService.deleteCompany(id);
    }
}
