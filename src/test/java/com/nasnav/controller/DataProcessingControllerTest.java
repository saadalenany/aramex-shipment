package com.nasnav.controller;

import com.nasnav.utils.BaseTest;
import org.junit.Test;

public class DataProcessingControllerTest extends BaseTest {

    private final String upload = "/dataprocess/loadxls";

    private final String download = "/dataprocess/getcsv";

    @Test
    public void testUploadXls_success() throws Exception {
//        MockMultipartFile file = new MockMultipartFile("file","dataprocess.xlsx", MediaType.MULTIPART_FORM_DATA_VALUE, );
//        mockMvc.perform(MockMvcRequestBuilders.multipart("/loadFile/")
//                .file(file)
//                .characterEncoding("UTF-8"))
//                .andExpect(status().isOk());
    }
}
