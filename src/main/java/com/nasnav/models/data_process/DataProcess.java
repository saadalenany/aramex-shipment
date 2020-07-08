package com.nasnav.models.data_process;

import com.opencsv.bean.CsvBindByName;
import com.poiji.annotation.ExcelCellName;
import lombok.Data;

@Data
public class DataProcess {

    @ExcelCellName("Quantity")
    @CsvBindByName(column = "Quantity")
    private Integer quantity;

    @ExcelCellName("Variant Id")
    @CsvBindByName(column = "Variant Id")
    private String variantId;

    @ExcelCellName("Price")
    @CsvBindByName(column = "Price")
    private Double price;

    @ExcelCellName("Description")
    @CsvBindByName(column = "Description")
    private String description;

    @ExcelCellName("Discount")
    @CsvBindByName(column = "Discount")
    private Double discount;

    @ExcelCellName("External Id")
    @CsvBindByName(column = "External Id")
    private String externalId;

    @ExcelCellName("Product Group Key")
    @CsvBindByName(column = "Product Group Key")
    private String productGroupKey;

    @ExcelCellName("Product Name")
    @CsvBindByName(column = "Product Name")
    private String productName;

    @ExcelCellName("Bar Code")
    @CsvBindByName(column = "Bar Code")
    private String barcode;

    @ExcelCellName("Brand")
    @CsvBindByName(column = "Brand")
    private String brand;

    @ExcelCellName("Tags")
    @CsvBindByName(column = "Tags")
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

    @ExcelCellName("Lookup Code")
    @CsvBindByName(column = "Lookup Code")
    private String lookupCode;

    @ExcelCellName("ITEM CODE (Rasport)")
    @CsvBindByName(column = "ITEM CODE (Rasport)")
    private String itemCode;

    @ExcelCellName("By Model")
    @CsvBindByName(column = "By Model")
    private String byModel;

    @ExcelCellName("Style Name")
    @CsvBindByName(column = "Style Name")
    private String styleName;

    @ExcelCellName("Color Family")
    @CsvBindByName(column = "Color Family")
    private String colorFamily;

    @ExcelCellName("Division")
    @CsvBindByName(column = "Division")
    private String division;

    @ExcelCellName("Gender")
    @CsvBindByName(column = "Gender")
    private String gender;

    @ExcelCellName("Category")
    @CsvBindByName(column = "Category")
    private String category;

    @ExcelCellName("Class Hierarchy")
    @CsvBindByName(column = "Class Hierarchy")
    private String classHierarchy;

    @ExcelCellName("Fit Name")
    @CsvBindByName(column = "Fit Name")
    private String fitName;

    @ExcelCellName("Sub Class Hierarchy")
    @CsvBindByName(column = "Sub Class Hierarchy")
    private String subClassHierarchy;

    @ExcelCellName("Leg Opening")
    @CsvBindByName(column = "Leg Opening")
    private String legOpening;

    @ExcelCellName("Closure/Collar")
    @CsvBindByName(column = "Closure/Collar")
    private String closure;

    @ExcelCellName("Pocket Styling")
    @CsvBindByName(column = "Pocket Styling")
    private String pocketStyling;

    @ExcelCellName("Misc. Features & Benefits")
    @CsvBindByName(column = "Misc. Features & Benefits")
    private String miscFeaturesBenefits;

    @ExcelCellName("Wash Instructions")
    @CsvBindByName(column = "Wash Instructions")
    private String washInstructions;

    @ExcelCellName("Class Hierarchy2")
    @CsvBindByName(column = "Class Hierarchy2")
    private String classHierarchy2;

    @ExcelCellName("Sub Class Hierarchy2")
    @CsvBindByName(column = "Sub Class Hierarchy2")
    private String subClassHierarchy2;

    @ExcelCellName("Seasonality")
    @CsvBindByName(column = "Seasonality")
    private String seasonality;

    @ExcelCellName("EAN Code")
    @CsvBindByName(column = "EAN Code")
    private String eanCode;

    @ExcelCellName("Fabrication")
    @CsvBindByName(column = "Fabrication")
    private String fabrication;

    @ExcelCellName("Levi's® Collaboration")
    @CsvBindByName(column = "Levi's® Collaboration")
    private String levisCollaboration;

    @ExcelCellName("Image")
    @CsvBindByName(column = "Image")
    private String image;

    @ExcelCellName("Link")
    @CsvBindByName(column = "Link")
    private String link;

    @ExcelCellName("In store")
    @CsvBindByName(column = "In store")
    private String inStore;

    @ExcelCellName("Remarks")
    @CsvBindByName(column = "Remarks")
    private String remarks;

    @ExcelCellName("Action")
    @CsvBindByName(column = "Action")
    private String action;

    @ExcelCellName("Article No")
    @CsvBindByName(column = "Article No")
    private String articleNo;

    @ExcelCellName("Family")
    @CsvBindByName(column = "Family")
    private String family;

    @ExcelCellName("Art Name")
    @CsvBindByName(column = "Art Name")
    private String artName;

    @ExcelCellName("Season")
    @CsvBindByName(column = "Season")
    private String season;

    @ExcelCellName("Product Group")
    @CsvBindByName(column = "Product Group")
    private String productGroup;

    @ExcelCellName("Product Type")
    @CsvBindByName(column = "Product Type")
    private String productType;

    @ExcelCellName("SUBGender")
    @CsvBindByName(column = "SUBGender")
    private String subGender;

    @ExcelCellName("Sex")
    @CsvBindByName(column = "Sex")
    private String sex;

    @ExcelCellName("RTP")
    @CsvBindByName(column = "RTP")
    private String rtp;

}
