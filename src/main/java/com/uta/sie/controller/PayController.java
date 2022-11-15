package com.uta.sie.controller;

import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Pay;

import com.uta.sie.service.PayService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payment")
@RestController
@AllArgsConstructor
@Slf4j
public class PayController {
    private final PayService payService;

    @PostMapping("/pay")
    public ResponseResult<String> check(@RequestBody Pay pay) {
        System.out.println("hahaha");
        return payService.check(pay);
    }

}
