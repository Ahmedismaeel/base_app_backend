package com.mystoreapp.storeapp.src.helper;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileNameHelper {
    static String getCurrentDateForFileName() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }
    public static String getFileName(MultipartFile file){
        return getCurrentDateForFileName() + "-" + UUID.randomUUID()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
    }

}
