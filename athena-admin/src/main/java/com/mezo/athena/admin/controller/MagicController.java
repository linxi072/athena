package com.mezo.athena.admin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mezo.athena.admin.demain.AthenaUser;
import com.mezo.athena.admin.service.MagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("magic")
public class MagicController {

    @Autowired(required = false)
    private MagicService magicService;

    @GetMapping("/get")
    public String magic() {
        List<AthenaUser> list = new ArrayList<>();
        Page<Object> page = PageHelper.startPage(1, 10);
        PageInfo<AthenaUser> info = new PageInfo<>(list);
        return magicService.info();
    }
}
