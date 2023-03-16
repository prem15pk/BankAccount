package com.bank.Controller;


import com.bank.ErrorHandler.ErrorMessage;
import com.bank.Security.Login.LoginService;
import com.bank.SignUp.CustomersSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/save/")
public class SignUpController {

    @Autowired
    LoginService loginService;

    @PostMapping("/saveUser")
    public ResponseEntity<Object> saveUserDetails(@RequestBody CustomersSignUp customersSignUp){
        String signUp = loginService.customersSignUp(customersSignUp);
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Error While Creating");
        if(signUp!=null){
            return  new ResponseEntity<>(signUp , HttpStatus.ACCEPTED);
        }
        else return new ResponseEntity<>(new ErrorMessage(),HttpStatus.NOT_FOUND);
    }
}
