package com.uta.sie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Merchandise;
import com.uta.sie.entity.User;
import com.uta.sie.entity.dto.MerchandiseDto;

import java.util.List;

public interface MerchandiseService extends IService<Merchandise> {
    ResponseResult<List<Merchandise>> getAllMerchandise(User user);
    ResponseResult<List<Merchandise>> exchange(User user);

    ResponseResult<Integer> buyMerchandise( Merchandise merchandise);

    ResponseResult<String> sellMerchandise(Merchandise merchandise);

    ResponseResult<List<MerchandiseDto>> getMerchandiseBySeller(Merchandise merchandise);

    ResponseResult<Integer> addMerchandise(Merchandise merchandise);

}
