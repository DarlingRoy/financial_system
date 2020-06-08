package com.example.financial_system.config.service;

import com.example.financial_system.entity.Operation;
import com.example.financial_system.entity.User;
import com.example.financial_system.service.OperationService;
import com.example.financial_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private OperationService operationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username==null||"".equals(username)){
            throw new RuntimeException("用户名不能为空");
        }

        //根据用户名查询用户
        User user = userService.queryByUsername(username);
        if(user==null){
            throw new RuntimeException("用户不存在");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //获取该用户所拥有的权限
        List<Operation> operations = operationService.queryByUserId(user.getId());
        //声明用户授权
        operations.forEach(operation -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(operation.getName());
            grantedAuthorities.add(grantedAuthority);
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}
