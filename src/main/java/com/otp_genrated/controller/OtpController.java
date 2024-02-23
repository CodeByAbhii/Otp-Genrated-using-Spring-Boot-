package com.otp_genrated.controller;


import com.otp_genrated.entity.Otp;
import com.otp_genrated.services.EmailService;
import com.otp_genrated.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OtpController {

    @Autowired
    private OtpService otpService;

    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<Otp> userRegister(@RequestBody Otp otp){
        Otp registerOtp = otpService.userRegister(otp);


        emailService.sendOtpEmail(otp.getEmail());
        return null;

    }
}
