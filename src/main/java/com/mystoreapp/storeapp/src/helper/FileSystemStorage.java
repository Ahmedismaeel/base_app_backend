package com.mystoreapp.storeapp.src.helper;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class FileSystemStorage {

    static final String rootLocation = "C:/files" + "/";
    private final HashSet<String> imageType = new HashSet<>(List.of("jpeg","jpg","png","gif"));

    private boolean isImage(String ext){
        return imageType.contains(ext);
    }

    private void createThumbnail(MultipartFile file, Integer width,String nameAndExt) throws IOException{
        Path location = Paths.get(rootLocation);
        BufferedImage thumbImg = null;
        BufferedImage img = ImageIO.read(file.getInputStream());
        thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, Scalr.OP_ANTIALIAS);
        ImageIO.write(thumbImg, FilenameUtils.getExtension(file.getOriginalFilename()) ,new File(rootLocation,"thumb_"+nameAndExt));
    }

    public void store(MultipartFile file, String nameAndExt) {
        Path location = Paths.get(rootLocation);

        try {

        Files.createDirectories(location);
        if (file.isEmpty()) {
            throw new RuntimeException("The file is empty");
        }
        if (nameAndExt.contains("..")) {
            // This is a security check
            throw new RuntimeException("Invalid file name ");
        }

        try (InputStream inputStream = file.getInputStream()) {
//                String detectedFileType = tika.detect(inputStream);
//                if(!allowedFileType.contains(detectedFileType)){
//                    log.error("[VALIDATION ERROR] store : file type not allowed");
//                    return OP_STATUS_FILETYPE_NOT_ALLOWED;
//                }

            Files.copy(inputStream, location.resolve(nameAndExt),
                    StandardCopyOption.REPLACE_EXISTING);


        }
            if(isImage(FilenameUtils.getExtension(file.getOriginalFilename()))){
                createThumbnail(file,150,nameAndExt);
            }
        }catch (Exception e){
            throw new RuntimeException("Failed to save the file ");
        }

        //change the message status to ready


    }
    public static Path load(String filename,Path location) {
        return location.resolve(filename);
    }
    public static Resource loadAsResource(String filename) {
       try {
            Path location = Paths.get(rootLocation+"/");
            Path file = load(filename,location);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                return null;
            }
        } catch (MalformedURLException e) {

            return null;
        }
    }
}
