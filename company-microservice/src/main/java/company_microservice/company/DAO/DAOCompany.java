package company_microservice.company.DAO;

import company_microservice.company.model.Company;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface DAOCompany extends JpaRepository<Company, Long> {

}
