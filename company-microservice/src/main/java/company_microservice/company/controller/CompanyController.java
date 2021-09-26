package company_microservice.company.controller;

import company_microservice.company.model.Company;
import company_microservice.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public List<Company> findAllCompanies(){return companyService.findAllCompany();}

    @GetMapping("/{id}")
    public Optional<Company> findCompanyById(@PathVariable Long id){return companyService.findCompanyById(id);}

    @GetMapping("/companyName/{companyName}")
    public Optional<Company> findCompanyByName(@PathVariable String companyName){return companyService.findCompanyByName(companyName);}

    @GetMapping("/bik/{bik}")
    public Optional<Company> findCompanyByBIK(@PathVariable String bik){return companyService.findCompanyByBIK(bik);}

    @GetMapping("/address/{address}")
    public Optional<Company> findCompanyByAddress(@PathVariable String address){return companyService.findCompanyByAddress(address);}

    @PostMapping("/create")
    public void createCompany(@RequestBody Company company){companyService.createCompany(company);}

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id){companyService.deleteCompany(id);}
}
