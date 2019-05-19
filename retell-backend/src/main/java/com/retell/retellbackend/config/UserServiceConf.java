package com.retell.retellbackend.config;

import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceConf implements UserDetailsService {
    @Autowired
    UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = service.getUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        if (user.getStatus().equals(0)) {
//            logger.debug("Banned user "+username+" tried to login");
            throw new UsernameNotFoundException("User Is Banned");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(username));
        System.out.print(username);
        return new User(user.getUsername(),
                user.getPassword(),getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(UserEntity user) {

        Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();

        String username = user.getUsername();

        System.out.print(user.getRole());
        if (user.getRole().equals("ADMIN")) {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        else if (user.getRole().equals("USER")) {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return grantedAuthority;
    }

}
