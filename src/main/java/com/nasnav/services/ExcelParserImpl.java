package com.nasnav.services;

import com.nasnav.models.data_process.DataInfo;
import com.nasnav.services.api.ExcelParser;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class ExcelParserImpl implements ExcelParser {

    private static Map<String, Object> locateHeader(Sheet mySheet) {
        for (int i = 0; i < mySheet.getLastRowNum(); i++) {
            if (mySheet.getRow(i) == null) {
                continue;
            }
            final short lastCellNum = mySheet.getRow(i).getLastCellNum();
            String[] header = new String[lastCellNum];
            boolean error = false;
            Iterator<Cell> cell_Iterator = mySheet.getRow(i).cellIterator();
            int j = 0;
            while (cell_Iterator.hasNext()) {
                final Cell cell = cell_Iterator.next();
                if (cell.getCellType() == CellType.BOOLEAN || cell.getCellType() == CellType.NUMERIC ||
                        cell.getCellType() == CellType.FORMULA || cell.getCellType() == CellType._NONE ||
                        cell.getCellType() == CellType.BLANK) {
                    error = true;
                    break;
                } else {
                    header[j] = cell.getStringCellValue();
                }
                j++;
            }
            if (!error) {
                Map<String, Object> map = new HashMap<>();
                map.put("row", i);
                map.put("header", header);
                return map;
            }
        }
        return null;
    }

    @Override
    public DataInfo parseExcelToList(InputStream inputStream) {
        DataInfo dataInfo = new DataInfo();
        List<String[]> list = new ArrayList<>();
        try {
            Workbook myBook = WorkbookFactory.create(inputStream);
            Sheet mySheet = myBook.getSheetAt(0);
            final Map<String, Object> pairs = locateHeader(mySheet);
            Integer rowNum = -1;
            if (pairs != null) {
                rowNum = (Integer) pairs.get("row");
                list.add((String[]) pairs.get("header"));
                dataInfo.setHasHeader(true);
            } else {
                dataInfo.setHasHeader(false);
            }
            Iterator<Row> rowIterator = mySheet.iterator(); //create a cursor called iterator to all rows in sheet
            Row r;
            Cell c;
            //to travel into the Excel spreadsheet
            while (rowIterator.hasNext()) {
                r = rowIterator.next();
                if (r.getRowNum() == rowNum) {
                    continue;
                }
                String[] rowData = new String[r.getLastCellNum()];
                //Cursor points to row
                Iterator<Cell> cell_Iterator = r.cellIterator();
                while (cell_Iterator.hasNext()) {
                    c = cell_Iterator.next();
                    //Cursor points to cell
                    switch (c.getCellType()) {
                        case STRING:
                            rowData[c.getColumnIndex()] = c.getStringCellValue();
                            break;
                        case NUMERIC:
                            rowData[c.getColumnIndex()] = String.valueOf(c.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            rowData[c.getColumnIndex()] = String.valueOf(c.getBooleanCellValue());
                            break;
                        case FORMULA:
                            rowData[c.getColumnIndex()] = String.format("\"=%s\"", c.getCellFormula());
                            break;
                        default:
                    }
                }
                list.add(rowData);
            }
            myBook.close();
            inputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        dataInfo.setData(list);
        return dataInfo;
    }
}
