package com.example.java_learning_2022.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.example.java_learning_2022.models.entity.User;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.java_learning_2022.dao.UserDAO;
import com.example.java_learning_2022.models.dto.UserDTO;
import com.example.java_learning_2022.services.IUserService;


@Service
@AllArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private UserDAO userDAO;

    @Override
    public List<UserDTO> findAllUser() {
        log.info("Вивели список користувачів");
        List<UserDTO> userDTOList = userDAO.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
        return userDTOList;
    }

    @Override
    public List<UserDTO> findAllUserPagin(int page, int size) {
        PageRequest request = PageRequest.of(page, size);
        return userDAO.findAll(request).getContent().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(int id) {
        User user = userDAO.findById(id).orElse(new User());
        if (user.getId() == 0) {
            return null;
        }
        return new UserDTO(user);
    }

    @Override
    public UserDTO updateUser(int id, User user) {
        user.setId(id);
        userDAO.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO createUser(User user) {
        return new UserDTO(userDAO.save(user));
    }

    @Override
    public List<UserDTO> createUsers(List<User> users) {
        return userDAO.saveAll(users).stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteById(id);
    }
}
