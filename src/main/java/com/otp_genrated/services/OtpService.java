package com.otp_genrated.services;

import com.otp_genrated.entity.Otp;
import com.otp_genrated.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    public OtpService(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public Otp userRegister(Otp otp){
        return otpRepository.save(otp);
    }


}
