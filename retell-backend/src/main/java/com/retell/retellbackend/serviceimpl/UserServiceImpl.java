package com.retell.retellbackend.serviceimpl;


import com.retell.retellbackend.repository.UserRepository;
import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private JdbcTemplate jdbc;

    @Resource
    private UserRepository userRepository;

    public Boolean checkUserName(String username) {
        UserEntity user = userRepository.getUserByName(username);
        if ( user == null) {
            System.out.print(user);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public void createUser(UserEntity user) {
        userRepository.save(user);
    }

    public UserEntity getUserByName(String name) {
        UserEntity user = userRepository.getUserByName(name);
//        System.out.print(user);
        return user;
    }

    public List getAllUser() {
        String sql = "select * from user";
        List<UserEntity> users = userRepository.getAllUsers();

        return users;
    }

    public Integer getIDByName(String username) {
        Integer id = userRepository.getIDByName(username);
        return id;
    }

    public void banUser(String username) {
        userRepository.banUser(username);
        return;
    }

    public void rebanUser(String username) {
        userRepository.rebanUser(username);
        return;
    }
}
