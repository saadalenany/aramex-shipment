package com.nasnav;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemory {

    private static Map<String, List<String[]>> dataProcessList;

    public static Map<String, List<String[]>> getDataProcess() {
        if (dataProcessList == null) {
            dataProcessList = new HashMap<>();
        }
        return dataProcessList;
    }
}
