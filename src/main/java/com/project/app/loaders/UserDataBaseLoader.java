package com.project.app.loaders;

import com.project.app.entities.Role;
import com.project.app.entities.User;
import com.project.app.repostiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDataBaseLoader implements CommandLineRunner {
    UserRepository userRepository;

    @Autowired
    public UserDataBaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userRepository.save(new User("admin@gmail.com", "first", "second", bCryptPasswordEncoder.encode("admin"), Role.ADMIN));
        userRepository.save(new User("user@gmail.com", "first", "second", bCryptPasswordEncoder.encode("user"), Role.USER));

    }
}
