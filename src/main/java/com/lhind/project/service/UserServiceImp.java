package com.lhind.project.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.lhind.project.model.Role;
import com.lhind.project.model.User;
import com.lhind.project.repository.RoleRepository;
import com.lhind.project.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    final BCryptPasswordEncoder encoder;
    final RoleRepository roleRepository;
    final UserRepository userRepository;

    public UserServiceImp(BCryptPasswordEncoder encoder, RoleRepository roleRepository, UserRepository userRepository) {
        this.encoder = encoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public boolean isUserAlreadyPresent(User user) {
        boolean alreadyExists = false;
        User existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser != null){
            alreadyExists = true;
        }
        return alreadyExists;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }
}
