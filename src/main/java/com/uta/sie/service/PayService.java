package com.uta.sie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Pay;

public interface PayService extends IService<Pay> {
    ResponseResult<String> check(Pay pay);
}
