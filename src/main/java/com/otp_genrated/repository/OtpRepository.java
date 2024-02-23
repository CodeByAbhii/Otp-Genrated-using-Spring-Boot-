package com.otp_genrated.repository;

import com.otp_genrated.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp , Long> {

     Otp findByEmail(String email);
}
