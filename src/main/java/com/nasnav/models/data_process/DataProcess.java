package com.nasnav.models.data_process;

import com.opencsv.bean.CsvBindByName;
import com.poiji.annotation.ExcelCellName;
import lombok.Data;

@Data
public class DataProcess {

    @ExcelCellName("quantity")
    @CsvBindByName(column = "quantity")
    private Integer quantity;

    @ExcelCellName("variant_id")
    @CsvBindByName(column = "variant_id")
    private String variantId;

    @ExcelCellName("price")
    @CsvBindByName(column = "price")
    private Double price;

    @ExcelCellName("description")
    @CsvBindByName(column = "description")
    private String description;

    @ExcelCellName("discount")
    @CsvBindByName(column = "discount")
    private Double discount;

    @ExcelCellName("external_id")
    @CsvBindByName(column = "external_id")
    private String externalId;

    @ExcelCellName("product_group_key")
    @CsvBindByName(column = "product_group_key")
    private String productGroupKey;

    @ExcelCellName("product_name")
    @CsvBindByName(column = "product_name")
    private String productName;

    @ExcelCellName("barcode")
    @CsvBindByName(column = "barcode")
    private String barcode;

    @ExcelCellName("brand")
    @CsvBindByName(column = "brand")
    private String brand;

    @ExcelCellName("tags")
    @CsvBindByName(column = "tags")
    private String tags;

    @ExcelCellName("Class")
    @CsvBindByName(column = "Class")
    private String theClass;

    @ExcelCellName("Color")
    @CsvBindByName(column = "Color")
    private String color;

    @ExcelCellName("Size")
    @CsvBindByName(column = "Size")
    private String size;

    @ExcelCellName("Cut")
    @CsvBindByName(column = "Cut")
    private String cut;

    @ExcelCellName("Glaze")
    @CsvBindByName(column = "Glaze")
    private String glaze;

    @ExcelCellName("Info")
    @CsvBindByName(column = "Info")
    private String info;

    @ExcelCellName("Origin")
    @CsvBindByName(column = "Origin")
    private String origin;

    @ExcelCellName("Product")
    @CsvBindByName(column = "Product")
    private String product;

    @ExcelCellName("Code")
    @CsvBindByName(column = "Code")
    private String code;

    @ExcelCellName("Style")
    @CsvBindByName(column = "Style")
    private String style;

    @ExcelCellName("Texture")
    @CsvBindByName(column = "Texture")
    private String texture;

    @ExcelCellName("Type")
    @CsvBindByName(column = "Type")
    private String type;

    @ExcelCellName("Length")
    @CsvBindByName(column = "Length")
    private Integer length;

    @ExcelCellName("LEVI'S CODE")
    @CsvBindByName(column = "LEVI'S CODE")
    private String levisCode;
}
