package com.bank.Security.Userinfoget;

import com.bank.Repository.SignUp.SignUpRepository;
import com.bank.SignUp.CustomersSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    SignUpRepository signUpRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomersSignUp> customersSignUp = signUpRepository.findByName(username);
        return customersSignUp
                .map(UserDetailsInfo::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException("user not found " + username));

    }
}
