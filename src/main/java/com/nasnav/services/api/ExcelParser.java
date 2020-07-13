package com.nasnav.services.api;

import com.nasnav.models.data_process.DataInfo;

import java.io.InputStream;

public interface ExcelParser {

    DataInfo parseExcelToList(InputStream inputStream);
}
