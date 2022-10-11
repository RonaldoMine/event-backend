package com.event.service;

import com.event.model.Enterprise;
import com.event.model.User;
import com.event.repository.SettingRepository;
import com.event.repository.UserRepository;
import com.event.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SettingRepository settingRepository;

    public List<User> getUsers(Long setting_id) {
        return userRepository.findAllByEnterpriseId(setting_id);
    }

    public User store(UserRequest userRequest, Long enterprise_id) {
        User user = new User();
        Enterprise enterprise = settingRepository.findById(enterprise_id).get();
        user.setName(userRequest.getName());
        user.setLast_name(userRequest.getLast_name());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setEnterprise(enterprise);
        user.setPassword(BCrypt.hashpw(userRequest.getPassword(), BCrypt.gensalt()));
        return userRepository.save(user);
    }

    public User update(UserRequest userRequest, Long id) {
        User user = userRepository.findById(id).get();
        user.setName(userRequest.getName());
        user.setLast_name(userRequest.getLast_name());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setPassword(BCrypt.hashpw(userRequest.getPassword(), BCrypt.gensalt()));
        return userRepository.save(user);
    }

    public HttpStatus delete(Long id) {
        userRepository.delete(userRepository.findById(id).get());
        return HttpStatus.OK;
    }
}
