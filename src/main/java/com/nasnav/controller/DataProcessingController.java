package com.nasnav.controller;

import com.nasnav.services.api.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller
@RequestMapping("/dataprocess")
public class DataProcessingController {

    @Autowired
    private DataProcessor dataProcessor;

    @PostMapping(value = "/loadxls", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> loadXLS(@RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            // throw an exception: the file is not allowed to be empty
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataProcessor.uploadXlsx(multipartFile));
    }

    @GetMapping("/getcsv")
    public ResponseEntity<Resource> getCSV(@RequestParam("uid") String uid) {
        final File file = dataProcessor.returnCsv(uid);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());

        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
