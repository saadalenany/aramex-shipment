package com.nasnav;

import com.nasnav.models.data_process.DataProcess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemory {

    private static Map<String, List<DataProcess>> dataProcessList;

    public static Map<String, List<DataProcess>> getDataProcess() {
        if (dataProcessList == null) {
            dataProcessList = new HashMap<>();
        }
        return dataProcessList;
    }
}
