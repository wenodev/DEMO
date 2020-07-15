package com.demo.demo0617.controller.api;


import com.demo.demo0617.domain.AjaxTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxTestApiController {

    @PostMapping("/ajaxTest")
    public ResponseEntity<?> ajaxTest(@RequestBody AjaxTest ajaxTest){

        System.out.println("ajaxTest.getId() : " + ajaxTest.getId());
        System.out.println("ajaxTest.getTemp1() : " + ajaxTest.getTemp1());
        System.out.println("ajaxTest.getTemp2() : " + ajaxTest.getTemp2());

        return ResponseEntity.ok(ajaxTest);

    }




}
