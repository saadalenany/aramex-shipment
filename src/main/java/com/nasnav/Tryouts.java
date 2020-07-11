package com.nasnav;

import javafx.util.Pair;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Tryouts {

    public static void main(String[] args) {

        ArrayList<String[]> list = new ArrayList<>();
        try {
            FileInputStream fIO = new FileInputStream("C:/Users/salen/Downloads/LEVI'S SS20 Rasport Webpage (levis sheet).xlsx");
            Workbook myBook = WorkbookFactory.create(fIO);
            Sheet mySheet = myBook.getSheetAt(0);
            final Pair<String, Object>[] pairs = locateHeader(mySheet);
            Integer rowNum = -1;
            if (pairs != null) {
                rowNum = (Integer)pairs[0].getValue();
                list.add((String[])pairs[1].getValue());
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
                            rowData[c.getColumnIndex()] = String.valueOf(c.getCellFormula());
                            break;
                        default:
                    }
                }
                list.add(rowData);
            }
            myBook.close();
            fIO.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        writeToCSV(list);
    }

    private static void writeToCSV(ArrayList<String[]> list) {
        try {
            FileWriter writer = new FileWriter("sto.csv");
            for (String[] arr: list) {
                String collect = Arrays.asList(arr).stream().collect(Collectors.joining(","));
                writer.write(collect);
                writer.write("\n"); // newline
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Pair<String, Object>[] locateHeader(Sheet mySheet) {
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
                return new Pair[] { new Pair<>("row", i), new Pair<>("header", header) };
            }
        }
        return null;
    }
}
