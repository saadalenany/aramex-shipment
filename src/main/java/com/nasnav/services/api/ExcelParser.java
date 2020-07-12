package com.nasnav.services.api;

import java.io.InputStream;
import java.util.List;

public interface ExcelParser {

    List<String[]> parseExcelToList(InputStream inputStream);
}
