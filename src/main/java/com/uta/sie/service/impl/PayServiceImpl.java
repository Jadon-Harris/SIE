package com.uta.sie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Pay;
import com.uta.sie.mapper.PayMapper;
import com.uta.sie.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayServiceImpl extends ServiceImpl<PayMapper,Pay> implements PayService {

    private final PayMapper payMapper;
    @Override
    public ResponseResult<String> check(Pay pay){

        if(pay.getNumber().matches("[0-9]{16}")){
            return new ResponseResult<>(HttpStatus.OK.value(), "Payment succeeded.");
        }
        else{
            return new ResponseResult<>(HttpStatus.OK.value(), "Credit card number is incorrect, please try again.");
        }
    }
}
