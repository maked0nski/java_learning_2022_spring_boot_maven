package com.example.java_learning_2022.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.example.java_learning_2022.models.entity.User;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.java_learning_2022.dao.UserDAO;
import com.example.java_learning_2022.models.dto.UserDTO;
import com.example.java_learning_2022.services.IUserService;


@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserDAO userDAO;

    @Override
    public List<UserDTO> findAllUser() {
        return userDAO.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findAllUserPagin(int page, int size) {
        PageRequest request = PageRequest.of(page, size);
        return userDAO.findAll(request).getContent().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(int id) {
        return null;
    }

    @Override
    public UserDTO updateUser(int id, UserDTO user) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return null;
    }

    @Override
    public List<UserDTO> createUsers(List<User> users) {
        return userDAO.saveAll(users).stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int id) {

    }
}
