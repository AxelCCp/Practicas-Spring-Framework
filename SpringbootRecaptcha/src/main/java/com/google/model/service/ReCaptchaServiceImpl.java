package com.google.model.service;

import com.google.controller.response.RecaptchaResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ReCaptchaServiceImpl implements ReCaptchaService{

    @Override
    public boolean validateRecaptcha(String captcha) {

        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("secret", RECAPTCHA_SECRET);
        request.add("response", captcha);
        RecaptchaResponse apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, request, RecaptchaResponse.class);

        if(apiResponse==null){
            return false;
        }

        return Boolean.TRUE.equals(apiResponse.getSuccess());
    }

    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
    private final String RECAPTCHA_SECRET = "6LfKJeAmAAAAAAxaZgRToYjrvj8b3Z9r09jdx6U2";



}
