package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;



    @Resource
    private RestTemplate  restTemplate;


    @GetMapping("insert")
    public void test() {
        testService.test();
    }

    @GetMapping("sendSMS")
    public void sendSMS() throws UnsupportedEncodingException {


        singleSend("f024d5aaabe704e904e8fbb8431fc6d9", "5112722", "13622284683");


    }

    public void singleSend(String apikey, String text, String mobile) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept","application/json;charset=utf-8");
        headers.set("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.put("apikey", Collections.singletonList(apikey));
        params.put("tpl_id", Collections.singletonList(text));
        params.put("mobile", Collections.singletonList(mobile));
        HttpEntity< MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://sms.yunpian.com/v2/sms/tpl_single_send.json", httpEntity, String.class);
        System.out.println("Response:" +responseEntity.getStatusCode());
        System.out.println("Response:" +responseEntity.getBody());
        System.out.println("Response:" +responseEntity.getStatusCodeValue());

    }
}
