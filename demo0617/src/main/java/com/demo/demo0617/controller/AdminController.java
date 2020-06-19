package com.demo.demo0617.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class AdminController {

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin/index";
    }








}
