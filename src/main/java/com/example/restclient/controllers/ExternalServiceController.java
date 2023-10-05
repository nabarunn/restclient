package com.example.restclient.controllers;

import com.example.restclient.requests.OnboardingRequest;
import com.example.restclient.responses.OnboardingServiceResponse;
import com.example.restclient.services.OnboardingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resttemplate")
public class ExternalServiceController {

    @Autowired
    OnboardingServiceImpl onboardingService;

    @PostMapping(path = "/onboarding")
    public ResponseEntity<OnboardingServiceResponse> getOnboardingResponse(@RequestBody OnboardingRequest onboardingRequest){
        return ResponseEntity.ok().body(onboardingService.getOnboardingStatus(onboardingRequest));
    }


}
