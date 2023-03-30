package com.HealthInsuranceClaims.webservices.HealthInsuranceClaims.registration;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface memberRepository  extends JpaRepository<member, Long> {

    List<member> findByFirstName(String firstName);

    List<member> findByLastName(String lastName);

    List<member> findByGender(String gender);

    List<member> findByState(String state);

    List<member> findByCity(String city);

    List<member> findByGovernmentId(String governmentId);

    List<member> findByEmail(String email);

    Optional<member> findByIdNumber(String idNumber);
    member save(member member);
}

