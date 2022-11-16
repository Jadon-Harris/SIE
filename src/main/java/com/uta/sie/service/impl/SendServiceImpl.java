package com.uta.sie.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.entity.Send;
import com.uta.sie.mapper.SendMapper;
import com.uta.sie.service.SendService;
import org.springframework.stereotype.Service;

@Service
public class SendServiceImpl extends ServiceImpl<SendMapper, Send> implements SendService {
}
