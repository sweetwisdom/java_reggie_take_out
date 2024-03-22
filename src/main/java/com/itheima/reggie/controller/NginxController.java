package com.itheima.reggie.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/nginx")
@Slf4j
public class NginxController {


    @GetMapping("/one")
    public R<String> getOne() {
        return R.success("getOne");
    }

    @GetMapping("/find")
    public R<Object> findOne(@RequestParam Map<String, String> allParams) {
        log.info(allParams.toString());
        ObjectMapper objectMapper = new ObjectMapper();

        for (String key : allParams.keySet()) {
            log.info("key:" + key);
            log.info("value:" + allParams.get(key));
        }
        try {

            // json转换为object
            Object object = objectMapper.convertValue(allParams, Object.class);
            return R.success(object);
        } catch (Exception e) {
            log.error("json转换失败", e);
           return R.error("内部错误");

        }

        // return R.success("111");
        // 返回 allParams转换为object


    }

}

