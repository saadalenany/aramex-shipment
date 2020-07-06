package com.nasnav.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class})
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class BaseTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void empty() {}

    protected <T> T postForObject(String url, Object data, Class<T> cls) throws Exception {
        return postForObject(url, data, new LinkedMultiValueMap<>(), cls);
    }

    protected <T> T postForObject(String url, Object data, MultiValueMap<String, String> params, Class<T> cls) throws Exception {
        String content = this.mockMvc.perform(
                post(url).params(params).content(objectMapper.writeValueAsBytes(data)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        return objectMapper.readValue(content, cls);
    }

    protected <T> T putForObject(String url, Object data, Class<T> cls) throws Exception {
        return putForObject(url, data, new LinkedMultiValueMap<>(), cls);
    }

    protected <T> T putForObject(String url, Object data, MultiValueMap<String, String> params, Class<T> cls) throws Exception {
        String content = this.mockMvc.perform(
                put(url).params(params).content(objectMapper.writeValueAsBytes(data)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        return objectMapper.readValue(content, cls);
    }

    protected <T> T getForObject(String url, Class<T> cls) throws Exception {
        return getForObject(url, new LinkedMultiValueMap<>(), cls);
    }

    protected <T> T getForObject(String url, MultiValueMap<String, String> params, Class<T> cls) throws Exception {
        String content = this.mockMvc.perform(get(url).params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        return objectMapper.readValue(content, cls);
    }

    /**
     * execute get call and expect success and List as a result
     *
     * @param url url to be called
     * @param <T> Class type of returned List
     * @return List ot T objects
     */
    protected <T> List<T> getForList(String url, Class<T> cls) throws Exception {
        return getForList(url, new LinkedMultiValueMap<>(), cls);
    }

    /**
     * execute get call and expect success and List as a result
     *
     * @param url    url to be called
     * @param params request params
     * @param <T>    Class type of returned List
     * @return List ot T objects
     */
    protected <T> List<T> getForList(String url, MultiValueMap<String, String> params, Class<T> cls) throws Exception {
        String content = this.mockMvc.perform(get(url).params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, cls));
    }

    /**
     * execute get call and expect success and Set as a result
     *
     * @param url url to be called
     * @param <T> Class type of returned Set
     * @return Set ot T objects
     */
    protected <T> Set<T> getForSet(String url, Class<T> cls) throws Exception {
        return getForSet(url, new LinkedMultiValueMap<>(), cls);
    }

    /**
     * execute get call and expect success and Set as a result
     *
     * @param url    url to be called
     * @param params request params
     * @param <T>    Class type of returned Set
     * @return Set ot T objects
     */
    protected <T> Set<T> getForSet(String url, MultiValueMap<String, String> params, Class<T> cls) throws Exception {
        String content = this.mockMvc.perform(get(url).params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(Set.class, cls));
    }

    protected <T> MockHttpServletResponse deleteForObject(String path, String id) throws Exception {
        return this.mockMvc.perform(delete(path + "/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    /**
     * This method uses java.io.FileInputStream to read
     * file content into a byte array
     *
     * @param file
     * @return
     */
    protected byte[] readFileToByteArray(File file) {
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

        } catch (IOException ioExp) {
            ioExp.printStackTrace();
        }
        return bArray;
    }

    protected String uploadFile(MockMultipartFile multipartFile, String UPLOAD_PATH) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.multipart(UPLOAD_PATH)
                .file(multipartFile)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}
