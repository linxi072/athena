package com.mezo.athena.controller;

import com.mezo.athena.service.MagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("magic")
public class MagicController {

    @Autowired(required = false)
    private MagicService magicService;
    @GetMapping("/get")
    public String magic() {
        return magicService.info();
    }
}
