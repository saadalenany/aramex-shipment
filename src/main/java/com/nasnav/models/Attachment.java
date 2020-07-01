package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Attachment {

    @JsonAlias({"FileName", "file_name"})
    private String fileName;

    @JsonAlias({"FileExtension", "file_extension"})
    private String fileExtension;

    @JsonAlias({"FileContents", "file_contents"})
    private Byte[] fileContents;
}
