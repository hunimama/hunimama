package com.hkt.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkt.security.entity.Users;
import com.hkt.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author 794073612@qq.com
 * @time 15:47 2022/6/11
 **/
@Service("userDetailService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userMapper.selectOne(new QueryWrapper<Users>().lambda().eq(Users::getUsername, username));
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        } else {
            List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_sale");
            return new User(users.getUsername(), new BCryptPasswordEncoder().encode("root"), auths);
        }
    }
}
