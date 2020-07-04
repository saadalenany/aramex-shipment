package com.nasnav.services;

import com.nasnav.ErrorMessage;
import com.nasnav.InMemory;
import com.nasnav.models.data_process.DataProcess;
import com.nasnav.services.api.DataProcessor;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DataProcessorImpl implements DataProcessor {

    @Override
    public String uploadXlsx(MultipartFile multipartFile) {
        try {
            //Parse the Excel file into list of DataProcess POJO class
            final String extension = Optional.ofNullable(multipartFile.getOriginalFilename())
                    .filter(f -> f.contains(".")).map(f -> f.substring(multipartFile.getOriginalFilename()
                            .lastIndexOf(".") + 1)).orElseThrow(() -> new RuntimeException(
                                    String.format(ErrorMessage.FILE_NO_EXTENSION, multipartFile.getOriginalFilename())));

            List<DataProcess> dataProcesses;
            if (extension.equalsIgnoreCase("XLSX")) {
                dataProcesses = Poiji.fromExcel(multipartFile.getInputStream(), PoijiExcelType.XLSX, DataProcess.class);
            } else if (extension.equalsIgnoreCase("XLS")) {
                dataProcesses = Poiji.fromExcel(multipartFile.getInputStream(), PoijiExcelType.XLS, DataProcess.class);
            } else {
                throw new RuntimeException(String.format(ErrorMessage.UPLOADED_FILE_TYPE, multipartFile.getOriginalFilename()));
            }

            //Generate the UUID based on the file original name
            final String uuid = UUID.nameUUIDFromBytes(multipartFile.getOriginalFilename().getBytes()).toString();

            InMemory.getDataProcess().put(uuid, dataProcesses);
            return uuid;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(ErrorMessage.ERROR_UPLOADING_PARSING);
        }
    }

    @Override
    public File returnCsv(String uuid) {
        if (!InMemory.getDataProcess().containsKey(uuid)) {
            throw new RuntimeException(String.format(ErrorMessage.KEY_NOT_FOUND_IN_MAP, uuid));
        }

        try {
            File file = new File(String.format("generated_by_%s.csv", uuid));
            // Creating writer class to generate csv file
            FileWriter writer = new FileWriter(file);

            // Creating StatefulBeanToCsv object
            StatefulBeanToCsv beanWriter = new StatefulBeanToCsvBuilder(writer).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();

            // Write list to StatefulBeanToCsv object
            beanWriter.write(InMemory.getDataProcess().get(uuid));

            // closing the writer object
            writer.flush();
            writer.close();

            return file;
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
            throw new RuntimeException(ErrorMessage.ERROR_GENERATING_WRITING_DOWNLOADING);
        }
    }

}
