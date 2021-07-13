package com.lw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/29
 * @Description: com.lw.controller
 * @version: 1.0
 */
@RestController
public class OKController {

    @GetMapping("/OK")
    public Object ok(){
        return "ok";
    }

}
