package com.example.bookstore.web;

import com.example.bookstore.domain.AppUser;
import com.example.bookstore.domain.AppUserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public UserDetailServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = appUserRepository.findByUsername(username);
        UserDetails user = new User(username, currentUser.getPasswordHash(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(currentUser.getRole()));
        return user;
    }
}
