package ru.gmyrkin.springboot.spring_boot_new_bali_3_1_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gmyrkin.springboot.spring_boot_new_bali_3_1_1.model.User;
import ru.gmyrkin.springboot.spring_boot_new_bali_3_1_1.repository.UserRepository;

import java.util.List;

@Service // данный класс компонент Spring
public class UserService {

    //инициализация (старый способ @Autowired)
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById (Long id){
        return userRepository.getOne(id);

    }

    public List<User> findAll(){
        return userRepository.findAll();

    }

    public User saveUser(User user){
      return userRepository.save(user);

    }

    public void deleteById (Long id){
        userRepository.deleteById(id);

    }



}