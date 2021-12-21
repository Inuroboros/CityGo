package company_microservice.company.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import company_microservice.company.DAO.CompanyDAO;
import company_microservice.company.model.Company;
import company_microservice.company.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
=======
import org.springframework.http.HttpEntity;
>>>>>>> zuultry
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@EnableHystrixDashboard
@EnableHystrix
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

<<<<<<< HEAD
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCompanyBIKByIdFallBack")
    public String getCompanyBIKById(Long id){
        return restTemplate.getForObject("http://companyapplication/company/bik/" + id, String.class);
    }

    @HystrixCommand(
            fallbackMethod = "getCompanyNameByIdFallback",
            threadPoolKey = "getCompanyNameById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5")
            }
    )
    public Company getCompanyNameById(Long id){
        return restTemplate.getForObject("http://companyapplication/company/companyName/" + id, Company.class);
    }

    public List<Company> findAllCompany() {return companyDAO.findAll();}
=======
    @Autowired
    private RestTemplate restTemplate;

    public void createLog(Long userId, String action, String description){
        Log log = new Log(userId, "CompanyService", action, description);
        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);
        System.out.println(log.toString());
    }


//    @HystrixCommand(
//            fallbackMethod = "getChallengeDtoByIdFallback"
//    )
>>>>>>> zuultry


    public List<Company> findAllCompany() {
        createLog(1L, "GET", "List of companies");
        return companyDAO.findAll();
    }

    public Company getCompanyById(Long id){
        createLog(1L, "GET", "Get company, id = " + id);
        return companyDAO.getById(id);
    }

    public Optional<Company> findCompanyByName(String companyName){
        createLog(1L, "GET", "Get company, name = " + companyName);
        return companyDAO.findCompanyByCompanyName(companyName);
    }

    public Optional<Company> findCompanyByBIK(String bik){
        createLog(1L, "GET", "Get company, bik = " + bik);
        return companyDAO.findCompanyByBIK(bik);
    }

    public Optional<Company> findCompanyByAddress(String address){
        createLog(1L, "GET", "Get company, address = " + address);
        return companyDAO.findCompanyByAddress(address);
    }

    public String getCompanyBIKByIdFallBack(Long id){
        return "BIK is not available";
    }

    public Company getCompanyNameByIdFallback(Long id){
        Company company = new Company();
        company.setId(101);
        company.setCompanyName("Name is not available");
        return company;
    }

    public void createCompany(Company company){
        createLog(1L, "POST", "Created: " + company.toString() );
        companyDAO.save(company);
    }

    public void deleteCompany(Long id){
        createLog(1L, "DELETE", "Delete company, id = " + id);
        companyDAO.deleteById(id);
    }

<<<<<<< HEAD
    public List<Company> getAllCompany(){
        List<Company> companyList = new ArrayList<>();
        List<Long> companyIds = new ArrayList<>();
        for (Long id : companyIds){
            Company company = getCompanyNameById(id);
            String BIK = getCompanyBIKById(id);
            company.setBIK(BIK);
            companyList.add(company);
        }
        return companyList;
=======
    public Optional<Company> findById(Long id) {
        createLog(1L, "GET", "Get company, id = " + id);
        return companyDAO.findById(id);
>>>>>>> master
    }
}
