package com.fh.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * poi导入Excel
 */
public class ExcelUtil {

    /**
     * poi利用java的反射机制做导出
     * <p>
     * <p>
     * 根据传过来的list数据，表头集合，属性字段集合，构建workbook
     *
     * @param workbook  HSSFWorkbook workbook = new HSSFWorkbook();
     * @param headerArr String[] headerArr = {"服装id","服装名称","服装价格","品牌名称","生产日期"};
     * @param fildsArr  String[] fildsArr = {"cloId","cloName","cloPrice","brandName","cloDateTime"};
     * @param list      查询出来的数据集合
     * @param response
     * @param request
     * @throws Exception 例如：
     */
    public static void buildWorkBook(String sheetName, HSSFWorkbook workbook, String[] headerArr, String[] fildsArr, List list, HttpServletResponse response, HttpServletRequest request) throws Exception {
        //创建sheeet
        HSSFSheet sheet = workbook.createSheet(sheetName);

        //创建第一行
        HSSFRow row;
        row = sheet.createRow(0);

        HSSFCell cell;

        //第一行的表头信息
        for (int i = 0; i < headerArr.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(headerArr[i]);
        }

        //循环有多少行数据，list中所有的数据集合
        for (int i = 0; i < list.size(); i++) {
            //通过反射获取所有字段，需要一个class,
            Class<?> aClass = list.get(i).getClass();

            //第一行已经有数据了，从0+1行开始
            row = sheet.createRow(i + 1);

            //遍历所有的字段集合
            for (int j = 0; j < fildsArr.length; j++) {
                cell = row.createCell(j);

                //通过java的反射获取所有字段
                Field declaredField = aClass.getDeclaredField(fildsArr[j]);

                //因为字段都是私有的，需要把字段可读，设置该属性
                declaredField.setAccessible(true);

                //获取该字段在该条对象中的值
                Object obj = declaredField.get(list.get(i));

                //把值给了cell
                cell.setCellValue(getValue(obj));
            }
        }
        //在controller层最后必须调用该方法，调用通过流的导出Excel，避免会有多个sheeet，所有一般在controller最后在调用该方法【否则无法通过流导出Excel】
        //  ExcelUtil.outExcel(response,request,workbook);

    }


    /**
     * 因为会有多个sheeet，所有一般在controller最后在调用该方法【否则无法通过流导出Excel】
     * 通过流将Excel导出
     * 设置中文的字符编码乱码问题 +
     *
     * @param response
     * @param request
     * @param workbook
     * @throws Exception
     */
    public static void outExcel(HttpServletResponse response, HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
        // 导出 文件名,避免重名，用uuid
        String fileName = UUID.randomUUID() + ".xlsx";
        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
            fileName = new String(fileName.getBytes("GB2312"), "ISO-8859-1");
        } else {
            // 对文件名进行编码处理中文问题
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
            fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
        }
        // 重置
        response.reset();
        // 设置编码方式
        response.setCharacterEncoding("UTF-8");
        ///  MIME  方式
        response.setContentType("application/x-msdownload");
        //  下载是否提示  inline
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        // 输出流 通过 response 输出
        ServletOutputStream out = response.getOutputStream();
        // 流写出
        workbook.write(out);

        out.close();
    }


    /**
     * 将所有类型都转换成String类型
     *
     * @param obj
     * @return
     */
    public static String getValue(Object obj) {

        //instanceof是Java中的二元运算符，左边是对象，右边是类；当对象是右边类或子类所创建对象时，返回true；否则，返回false。
        if (obj instanceof Date) {
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
            String objStr = sm.format(obj);
            return objStr;
        } else {
            return obj + "";
        }

    }


}
