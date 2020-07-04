package com.nasnav.services.api;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface DataProcessor {

    public String uploadXlsx(MultipartFile multipartFile);

    public File returnCsv(String uuid);
}
