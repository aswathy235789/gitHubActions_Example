package com.HealthInsuranceClaims.webservices.HealthInsuranceClaims.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api")
//public class memberController {
//
//
//
//
//    @Autowired
//    private memberService registrationService;
//
////    @PostMapping("/register")
////    public ResponseEntity<member> register(@RequestBody member member) {
////        try {
////            member savedRegistration = registrationService.saveRegistration(member);
////            return new ResponseEntity<>(savedRegistration, HttpStatus.CREATED);
////        } catch (Exception e) {
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
////    @GetMapping("/registrations/{firstName}")
////    public ResponseEntity<List<member>> getRegistrationsByFirstName(@PathVariable String firstName) {
////        List<member> registrations = registrationService.findByFirstName(firstName);
////
////        if (registrations.isEmpty()) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        } else {
////            return new ResponseEntity<>(registrations, HttpStatus.OK);
////        }
////    }
//
//    @PostMapping("/register")
//    public ResponseEntity<member> register(@RequestBody member member) {
//        try {
//            member savedMember = registrationService.saveRegistration(member);
//            return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/registrations/{firstName}")
//    public ResponseEntity<List<member>> getRegistrationsByFirstName(@PathVariable String firstName) {
//        List<member> registrations = registrationService.findByFirstName(firstName);
//
//        if (registrations.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(registrations, HttpStatus.OK);
//        }
//    }
//
//
//
//}

@RestController
@RequestMapping("/api")
public class memberController {

    private final memberService memberService;

    @Autowired
    public memberController(memberService memberService) {
        this.memberService = memberService;
    }

    // Register a member
    @PostMapping("/register")
    public ResponseEntity<member> register(@RequestBody member newMember) {
        try {
            member savedMember = memberService.saveRegistration(newMember);
            return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get registrations by first name
    @GetMapping("/registrations/{firstName}")
    public ResponseEntity<List<member>> getRegistrationsByFirstName(@PathVariable String firstName) {
        try {
            List<member> registrations = memberService.findByFirstName(firstName);

            if (registrations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(registrations, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

