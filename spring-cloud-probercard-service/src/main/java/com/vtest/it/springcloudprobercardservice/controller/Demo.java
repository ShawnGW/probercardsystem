package com.vtest.it.springcloudprobercardservice.controller;

import com.vtest.it.springcloudprobercardservice.service.probercard.ProberCardOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Demo {
    @Autowired
    private ProberCardOperator proberCardOperator;

    @GetMapping("/test")
    public String getInformation() {
        return "";
    }
}
