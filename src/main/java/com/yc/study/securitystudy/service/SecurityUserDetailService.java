package com.yc.study.securitystudy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yc.study.securitystudy.entity.TUsers;
import com.yc.study.securitystudy.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service("userDetailsService")
public class SecurityUserDetailService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<TUsers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        TUsers tUsers = usersMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(tUsers)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale");
        return new User(tUsers.getUsername(), new BCryptPasswordEncoder().encode(tUsers.getPassword()), authorityList);
    }
}
