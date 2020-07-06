package com.nasnav.controller;

import com.nasnav.ErrorMessage;
import com.nasnav.utils.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DataProcessingControllerTest extends BaseTest {

    private final String UPLOAD_PATH = "/dataprocess/loadxls";

    private final String DOWNLOAD_PATH = "/dataprocess/getcsv";

    private final String RESOURCES_PATH = "src/test/resources/";

    @Test
    public void testUploadXlsx_success() throws Exception {
        String xlsxFile = "dataprocess.xlsx";
        MockMultipartFile multipartFile = new MockMultipartFile("file", xlsxFile,
                MediaType.MULTIPART_FORM_DATA_VALUE, Files.readAllBytes(Paths.get(RESOURCES_PATH + xlsxFile)));
        final String uuid = uploadFile(multipartFile, UPLOAD_PATH);

        String expectedUUID = UUID.nameUUIDFromBytes(xlsxFile.getBytes()).toString();

        assertNotNull(uuid);
        assertEquals(expectedUUID, uuid);
    }

    @Test
    public void testUploadXls_success() throws Exception {
        String xlsFile = "dataprocess.xls";
        MockMultipartFile multipartFile = new MockMultipartFile("file", xlsFile,
                MediaType.MULTIPART_FORM_DATA_VALUE, Files.readAllBytes(Paths.get(RESOURCES_PATH + xlsFile)));
        final String uuid = uploadFile(multipartFile, UPLOAD_PATH);

        String expectedUUID = UUID.nameUUIDFromBytes(xlsFile.getBytes()).toString();

        assertNotNull(uuid);
        assertEquals(expectedUUID, uuid);
    }

    @Test
    public void testUploadUnknown() throws Exception {
        String unknown = "unknown";
        MockMultipartFile multipartFile = new MockMultipartFile("file", unknown,
                MediaType.MULTIPART_FORM_DATA_VALUE, Files.readAllBytes(Paths.get(RESOURCES_PATH + unknown)));
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.multipart(UPLOAD_PATH)
                .file(multipartFile)
                .characterEncoding("UTF-8"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse();

        assertNotNull(response);
        assertEquals(404, response.getStatus());
    }

    @Test
    public void testDownload_success() throws Exception {
        //-------------UPLOAD FILE-------------
        String xlsxFile = "dataprocess.xlsx";
        MockMultipartFile multipartFile = new MockMultipartFile("file", xlsxFile,
                MediaType.MULTIPART_FORM_DATA_VALUE, Files.readAllBytes(Paths.get(RESOURCES_PATH + xlsxFile)));
        final String uuid = uploadFile(multipartFile, UPLOAD_PATH);

        String expectedUUID = UUID.nameUUIDFromBytes(xlsxFile.getBytes()).toString();

        assertNotNull(uuid);
        assertEquals(expectedUUID, uuid);

        //------------DOWNLOAD FILE------------
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("uid", uuid);
        final MockHttpServletResponse response = this.mockMvc.perform(get(DOWNLOAD_PATH).params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        assertNotNull(response);
        assertEquals(MediaType.APPLICATION_OCTET_STREAM_VALUE, response.getContentType());

        assertEquals(String.format("attachment; filename=generated_by_%s.csv", uuid), response.getHeader("Content-Disposition"));
    }

    @Test
    public void testDownload_failure() throws Exception {
        final String uuid = "unknown";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("uid", uuid);
        final MockHttpServletResponse response = this.mockMvc.perform(get(DOWNLOAD_PATH).params(params))
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse();
        assertNotNull(response);
        assertEquals(String.format(ErrorMessage.KEY_NOT_FOUND_IN_MAP, uuid), response.getErrorMessage());
    }
}
