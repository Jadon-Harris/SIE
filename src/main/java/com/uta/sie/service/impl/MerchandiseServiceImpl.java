package com.uta.sie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Merchandise;
import com.uta.sie.entity.User;
import com.uta.sie.entity.dto.MerchandiseDto;
import com.uta.sie.mapper.MerchandiseMapper;
import com.uta.sie.mapper.UserMapper;
import com.uta.sie.service.MerchandiseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MerchandiseServiceImpl extends ServiceImpl<MerchandiseMapper, Merchandise> implements MerchandiseService {
    private final MerchandiseMapper merchandiseMapper;
    private final UserMapper userMapper;

    @Override
    public ResponseResult<List<Merchandise>> getAllMerchandise(User user){
        final LambdaQueryWrapper<Merchandise> merchandiseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        merchandiseLambdaQueryWrapper.eq(true, Merchandise::getState, 1);
        merchandiseLambdaQueryWrapper.ne(true, Merchandise::getSellerId, user.getId());
        List<Merchandise> mList = merchandiseMapper.selectList(merchandiseLambdaQueryWrapper);
        return new ResponseResult<>(HttpStatus.OK.value(), "merchandise got", mList);
    }
    @Override
    public ResponseResult<List<Merchandise>> exchange(User user){
        final LambdaQueryWrapper<Merchandise> merchandiseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        merchandiseLambdaQueryWrapper.eq(true, Merchandise::getState, 5);
        merchandiseLambdaQueryWrapper.ne(true, Merchandise::getSellerId, user.getId());
        List<Merchandise> mList = merchandiseMapper.selectList(merchandiseLambdaQueryWrapper);
        return new ResponseResult<>(HttpStatus.OK.value(), "merchandise got", mList);
    }

    @Override
    public ResponseResult<Integer> buyMerchandise( Merchandise merchandise){
        final LambdaUpdateWrapper<Merchandise> merchandiseLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        merchandiseLambdaUpdateWrapper.set(Merchandise::getState,merchandise.getState());
        merchandiseLambdaUpdateWrapper.set(Merchandise::getBuyId,merchandise.getBuyId());
        merchandiseLambdaUpdateWrapper.eq(Merchandise::getId,merchandise.getId());
        merchandiseMapper.update(merchandise,merchandiseLambdaUpdateWrapper);
        System.out.println("aaaaaaaaaaaaa");
        return new ResponseResult<>(HttpStatus.OK.value(), "update successful",1);
    }

    public ResponseResult<String> sellMerchandise( Merchandise merchandise){
        return new ResponseResult<>(HttpStatus.OK.value(), "password has been updated");
    }

    @Override
    public ResponseResult<List<MerchandiseDto>> getMerchandiseBySeller(Merchandise merchandise){
        LambdaQueryWrapper<Merchandise> merchandiseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        merchandiseLambdaQueryWrapper.eq(!Objects.isNull(merchandise.getSellerId()),Merchandise::getSellerId,merchandise.getSellerId());
        merchandiseLambdaQueryWrapper.eq(!Objects.isNull(merchandise.getState()),Merchandise::getState,merchandise.getState());
        List<Merchandise> merchandises = merchandiseMapper.selectList(merchandiseLambdaQueryWrapper);

        List<MerchandiseDto> merchandiseDtos = merchandises.stream().map(mer -> {
            User user = userMapper.selectById(mer.getBuyId());
            MerchandiseDto merchandiseDto = new MerchandiseDto();
            BeanUtils.copyProperties(mer, merchandiseDto);
            merchandiseDto.setBuyers(user);
            return merchandiseDto;
        }).collect(Collectors.toList());
        return new ResponseResult<>(HttpStatus.OK.value(), "xxx",merchandiseDtos);
    }

    @Override
    public ResponseResult<Integer> addMerchandise(Merchandise merchandise){
        merchandiseMapper.insert(merchandise);
        return new ResponseResult<>(HttpStatus.OK.value(), "insert successful",1);
    }
}
