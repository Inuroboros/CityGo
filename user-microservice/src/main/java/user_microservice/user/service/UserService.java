package user_microservice.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user_microservice.user.DAO.UserDAO;
import user_microservice.user.model.User;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getUserNameByIdFallback",
            threadPoolKey = "getUserNameById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public User getUserNameById(Long id){
        return restTemplate.getForObject("http://userapplication/users/names/" + id, User.class);
    }

    public List<User> findAllUsers() {return userDAO.findAll();}

    public Optional<User> findUserById(Long id) {
        return userDAO.findById(id);
    }

    public Optional<User> findUserByName(String name) {
        return userDAO.findUsersByName(name);
    }

    public Optional<User> findUserByEmail(String email) {return userDAO.findUsersByEmail(email);}

    public User getUserNameByIdFallback(Long id){
        User user = new User();
        user.setId(101);
        user.setName("Name is not available");
        return user;
    }

    public void createUser(User user) {
        userDAO.save(user);
    }

    public void updateUser(User user) {
        User originalUser = userDAO.getById((long) user.getId());
        if(originalUser != null) {
            userDAO.save(user);
        }
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }

}
