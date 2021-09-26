package user_microservice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_microservice.user.DAO.DAOUser;
import user_microservice.user.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private DAOUser daoUser;

    public List<User> findAllUsers() {return daoUser.findAll();}

    public Optional<User> findUserById(Long id) {return daoUser.findById(id);}

    public Optional<User> findUserByName(String name) {return daoUser.findUsersByName(name);}

    public Optional<User> findUserByEmail(String email) {return daoUser.findUsersByEmail(email);}
}
