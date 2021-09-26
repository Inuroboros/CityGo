package company_microservice.company.service;

import company_microservice.company.DAO.DAOCompany;
import company_microservice.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private DAOCompany daoCompany;

    public List<Company> findAllCompany() {return daoCompany.findAll();}

    public Optional<Company> findCompanyById(Long id){return daoCompany.findById(id);}

    public Optional<Company> findCompanyByName(String companyName){return daoCompany.findCompanyByName(companyName);}

    public Optional<Company> findCompanyByBIK(String bik){return daoCompany.findCompanyByBIK(bik);}

    public Optional<Company> findCompanyByAddress(String address){return daoCompany.findCompanyByAddress(address);}

    public void createCompany(Company company){daoCompany.save(company);}

    public void deleteCompany(Long id){daoCompany.deleteById(id);}
}
