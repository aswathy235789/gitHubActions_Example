package com.HealthInsuranceClaims.webservices.HealthInsuranceClaims.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class memberService {

    @Autowired
    private memberRepository memberRepository;

    public memberService(com.HealthInsuranceClaims.webservices.HealthInsuranceClaims.registration.memberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public member saveRegistration(member registration) {
        return memberRepository.save(registration);
    }

    public List<member> findByFirstName(String firstName) {
        return memberRepository.findByFirstName(firstName);
    }

    // add more methods here as needed
}
