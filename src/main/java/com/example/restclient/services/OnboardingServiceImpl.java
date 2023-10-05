package com.example.restclient.services;

import com.example.restclient.requests.OnboardingRequest;
import com.example.restclient.responses.OnboardingServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OnboardingServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    public OnboardingServiceResponse getOnboardingStatus(OnboardingRequest onboardingRequest){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_XML);
        HttpEntity httpEntity = new HttpEntity<>(onboardingRequest.toString(), header);
        ResponseEntity<OnboardingServiceResponse> response = restTemplate.exchange("http://localhost:8081/external-service/onboarding", HttpMethod.POST,httpEntity,OnboardingServiceResponse.class);
        return response.getBody();
    }
}
