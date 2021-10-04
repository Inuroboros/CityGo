package company_microservice.company.service;

import company_microservice.company.DAO.CompanyDAO;
import company_microservice.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    public List<Company> findAllCompany() {return companyDAO.findAll();}

    public Optional<Company> findCompanyById(Long id){return companyDAO.findById(id);}

    public Optional<Company> findCompanyByName(String companyName){return companyDAO.findCompanyByCompanyName(companyName);}

    public Optional<Company> findCompanyByBIK(String bik){return companyDAO.findCompanyByBIK(bik);}

    public Optional<Company> findCompanyByAddress(String address){return companyDAO.findCompanyByAddress(address);}

    public void createCompany(Company company){
        companyDAO.save(company);}

    public void deleteCompany(Long id){
        companyDAO.deleteById(id);}
}
