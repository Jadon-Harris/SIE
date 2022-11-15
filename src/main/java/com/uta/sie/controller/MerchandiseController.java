package com.uta.sie.controller;


import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Merchandise;
import com.uta.sie.entity.User;
import com.uta.sie.entity.dto.MerchandiseDto;
import com.uta.sie.service.MerchandiseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RequestMapping("/transaction")
@RestController
@AllArgsConstructor
@Slf4j
public class MerchandiseController {

    private final MerchandiseService merchandiseService;


    private final String merchandisePicPath="D:/merchandise/upload";//图片储存位置 yml配置注入

    @PostMapping("/show")
    public ResponseResult<List<Merchandise>> getAllMerchandise(@RequestBody User user) {
        return merchandiseService.getAllMerchandise(user);
    }
    @PostMapping("/exchange")
    public ResponseResult<List<Merchandise>> exchange(@RequestBody User user) {
        return merchandiseService.exchange(user);
    }
    @PostMapping("/buy")
    public ResponseResult<Integer> buyMerchandise(@RequestBody Merchandise merchandise) {
        return merchandiseService.buyMerchandise(merchandise);
    }
    @PostMapping("/mysale")
    public ResponseResult<List<MerchandiseDto>> getMerchandiseBySeller(@RequestBody Merchandise merchandise) {
        return merchandiseService.getMerchandiseBySeller(merchandise);
    }
    @PostMapping("/add")
    public ResponseResult<Integer> addMerchandise(@RequestParam("photo") MultipartFile mf,
                                                  @RequestParam("name") String name,
                                                  @RequestParam("description") String description,
                                                  @RequestParam("price")BigDecimal price,
                                                  @RequestParam("sellerId") Long sellerId,
                                                  @RequestParam("state") int state){
        //图片重命名 确保唯一
        String	newFilename = UUID.randomUUID().toString().replaceAll("-", "")+
                "_"+mf.getOriginalFilename();
        //磁盘上存放图片的文件夹的路径，如果有这个文件夹，就用，没有就创建
        File path = new File(this.merchandisePicPath);
        if(!path.exists()) {
            System.out.println("exist");
            path.mkdir();
        }
        //将图片存入磁盘
        try {
            mf.transferTo(new File(this.merchandisePicPath+"/"+newFilename));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Merchandise merchandise=new Merchandise(name,price,description,newFilename,sellerId,null,state);
        return merchandiseService.addMerchandise(merchandise);
    }
}
