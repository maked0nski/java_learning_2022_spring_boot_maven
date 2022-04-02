package com.example.java_learning_2022.services;

import com.example.java_learning_2022.models.dto.UserDTO;
import com.example.java_learning_2022.models.entity.User;

import java.util.List;

public interface IUserService {

    List<UserDTO> findAllUser();

    List<UserDTO> findAllUserPagin(int page, int size);

    UserDTO findUserById(int id);

    UserDTO updateUser(int id, UserDTO user);

    UserDTO createUser(UserDTO user);

    List<UserDTO> createUsers(List<User> users);

    void deleteUser(int id);

}
