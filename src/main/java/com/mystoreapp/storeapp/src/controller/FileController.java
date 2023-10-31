package com.mystoreapp.storeapp.src.controller;


import com.mystoreapp.storeapp.src.helper.FileSystemStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/file")
public class FileController {

    private final FileSystemStorage storage;
    @GetMapping("/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable String fileName){
        var resource = storage.loadAsResource(fileName);
        if(resource==null)
        {
            throw new RuntimeException("Failed to load the file");
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
