package com.leyou.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.config.UploadProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties prop;

    public String uploadImage(MultipartFile file) {
        try {
            // 验证文件类型
            String contentType = file.getContentType();
            if (!prop.getAllowsTypes().contains(contentType)){
                throw new LyException(ExceptionEnums.ILLEGAL_FILE_TYPE);
            }
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null){
                throw new LyException(ExceptionEnums.ILLEGAL_FILE_TYPE);
            }
            //上传fdfs
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            return prop.getBasrUrl() + storePath.getFullPath() ;
        } catch (IOException e) {
            log.error("文件上传失败", e);
            throw new LyException(ExceptionEnums.UPLOAD_IMAGE_ERROR);
        }
    }
}
