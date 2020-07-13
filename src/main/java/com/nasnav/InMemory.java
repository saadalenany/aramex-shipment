package com.nasnav;

import com.nasnav.models.data_process.DataInfo;

import java.util.HashMap;
import java.util.Map;

public class InMemory {

    private static Map<String, DataInfo> dataProcessList;

    public static Map<String, DataInfo> getDataProcess() {
        if (dataProcessList == null) {
            dataProcessList = new HashMap<>();
        }
        return dataProcessList;
    }
}
