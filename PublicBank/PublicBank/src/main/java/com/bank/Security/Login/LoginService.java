package com.bank.Security.Login;

import com.bank.Repository.SignUp.SignUpRepository;
import com.bank.Security.SecurityConfig;
import com.bank.SignUp.CustomersSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    SignUpRepository signUpRepository;

    @Autowired
    SecurityConfig securityConfig;

    public String customersSignUp(CustomersSignUp customersSignUp){
        customersSignUp.setPassword(securityConfig.passwordEncoder().encode(customersSignUp.getPassword()));
        signUpRepository.save(customersSignUp);

        return "User Added";
    }

}
