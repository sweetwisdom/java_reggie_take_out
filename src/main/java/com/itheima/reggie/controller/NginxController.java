package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nginx")
public class NginxController {


    @GetMapping("/one")
    public R<String> getOne() {
        return R.success("getOne");
    }
    @GetMapping("/find")
    public R<String> findOne() {
        return R.success("findOne");

    }

}

