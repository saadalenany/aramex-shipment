package com.nasnav.services.api;

import com.nasnav.models.data_process.ColumnEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface DataProcessor {

    public String uploadXlsx(MultipartFile multipartFile);

    public File returnCsv(String uuid);

    public File assignColumn(String uuid, ColumnEnum name, Integer index);
}
