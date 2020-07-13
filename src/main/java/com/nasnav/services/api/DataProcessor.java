package com.nasnav.services.api;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface DataProcessor {

    String uploadXlsx(MultipartFile multipartFile);

    File returnCsv(String uuid);

    File assignColumn(String uuid, String name, Integer index);
}
