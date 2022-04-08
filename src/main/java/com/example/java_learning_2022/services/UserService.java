package com.example.java_learning_2022.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.java_learning_2022.dao.UserDAO;
import com.example.java_learning_2022.models.dto.UserDTO;
import com.example.java_learning_2022.models.entitty.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor
public class UserService {

    private UserDAO userDAO;
    private MailSendService mailSendService;

    public void saveUser(UserDTO userDTO) {
        userDAO.save(new User(userDTO));
    }

    public void saveUser(String name, MultipartFile avatar) throws IOException {
        userDAO.save(new User(name, avatar.getOriginalFilename()));
        String path = System.getProperty("user.home") + File.separator + "avatars" + File.separator;
        avatar.transferTo(new File(path + avatar.getOriginalFilename()));

    }

    public void saveUser(String name, MultipartFile avatar, String email) throws IOException {
        User user = new User(name, avatar.getOriginalFilename(), email);
        userDAO.save(user);
        String path = System.getProperty("user.home") + File.separator + "avatars" + File.separator;
        avatar.transferTo(new File(path + avatar.getOriginalFilename()));
        mailSendService.send(user, avatar);
    }

    public String getUserAvatar(int id) {
        return userDAO.findById(id).get().getAvatar();
    }
//
//    public String getUserAvatar(String avataName){
//        return userDAO.findById(id).get().getAvatar();
//    }

}
