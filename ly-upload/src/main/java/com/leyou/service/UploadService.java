package com.leyou.service;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zwb
 * @Date: 2019-07-02 9:49
 */
@Slf4j
@Service
public class UploadService {

    private static final List<String> ALLOWS_TYPES = Arrays.asList("image/jpeg","image/png","image/bmp");

    public String uploadImage(MultipartFile file) {
        try {
            String contentType = file.getContentType();
            if (!ALLOWS_TYPES.contains(contentType)){
                throw new LyException(ExceptionEnums.ILLEGAL_FILE_TYPE);
            }
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null){
                throw new LyException(ExceptionEnums.ILLEGAL_FILE_TYPE);
            }
            //准备目标路径
            File dest = new File("E:\\IdeaProjects\\leyou\\upload", file.getOriginalFilename());
            // 保存文件到本地
            file.transferTo(dest);
            //返回路径
            return "http://image.leyou.com/upload/" + file.getOriginalFilename();
        } catch (IOException e) {
            log.error("文件上传失败", e);
            throw new LyException(ExceptionEnums.UPLOAD_IMAGE_ERROR);
        }
    }
}
