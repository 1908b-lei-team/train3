package com.fh.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExportExcelTest {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        File file = new File("C:\\Users\\srj\\Desktop\\aaa.xlsx");
        //通过WorkbookFactory加载文件
        Workbook workbook = WorkbookFactory.create(file);

        //获取sheet
        Sheet sheet = workbook.getSheetAt(0);

        //获取当前sheet一共有多少行
        int lastRowNum = sheet.getLastRowNum();

        Row row;
        //读取时候注意，数字的地方就是数字，文本地方就是文本
        for (int i = 0; i < lastRowNum; i++) {

            //从第一行开始读取
            row = sheet.getRow(i + 1);

            //读取第0列开始
            Cell cell = row.getCell(0);

            //获取当前列的信息
            String stringCellValue = cell.getStringCellValue();

            //读取第1列
            cell = row.getCell(1);

            //获取当前列的信息，是数字类型的，不能用String
            double numericCellValue = cell.getNumericCellValue();

            System.out.println(stringCellValue + "的期望薪资为：" + numericCellValue);


        }


    }
}
