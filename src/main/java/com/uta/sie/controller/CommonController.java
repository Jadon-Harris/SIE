package com.uta.sie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uta.sie.common.ResponseResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 图片上传和下载。
 *
 * @author Jadon
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${sie.path}")
    private String basePath;

    @PostMapping("/upload")
    public ResponseResult<String> upload(MultipartFile file) {
        final String originalFilename = file.getOriginalFilename();
        final String prefix = UUID.randomUUID().toString();
        assert originalFilename != null;
        final String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = prefix + suffix;

        try {
            file.transferTo((new File(basePath + fileName)).getAbsoluteFile());
        } catch (IOException e) {
            log.error(e.toString());
        }
        return new ResponseResult<>(HttpStatus.OK.value(), "image upload success.", fileName);
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response, String name) {
        try {
            final String filePath = new File(basePath + name).getAbsolutePath();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ServletOutputStream servletOutputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                servletOutputStream.write(bytes, 0, len);
                servletOutputStream.flush();
            }
            servletOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
