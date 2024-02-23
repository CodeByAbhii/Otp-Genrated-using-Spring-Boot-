package com.otp_genrated.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import  static  com.otp_genrated.services.EmailVerificationService.emailOtpMapping;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    private OtpService otpService;

    public EmailService(JavaMailSender javaMailSender, OtpService otpService) {
        this.javaMailSender = javaMailSender;
        this.otpService = otpService;
    }


    public  String genrateOtp(){
        return String.format("%06d", new java.util.Random().nextInt(100000));
    }


    public void sendOtpEmail(String email){

        String otp = genrateOtp();

        // Send Otp tothe user's eamil
        sendEmail(email , "Otp for Email Verification", "Your otp is: " + otp);

    }
    private void sendEmail(String to  , String subject , String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(("abhishekcs188@gmail.com"));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
