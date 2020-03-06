package com.fairy.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author deyong_tong
 */
@Controller
public class PageController {

    @GetMapping("/postwoman")
    public String postwoman(){
        return "index.html";
    }
}
