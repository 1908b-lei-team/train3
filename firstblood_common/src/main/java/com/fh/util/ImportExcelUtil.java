package com.fh.util;

import com.fh.systemConst.Const;
import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/**
 * freemarker导出Excel，word，pdf
 */
public class ImportExcelUtil {


    /**
     * 导出word，Excel公用  对于日期图片不可以
     *
     * @param response
     * @param map        查询的list集合，其他一些数据都放到map中
     * @param fileName   导入的模板的文件名
     * @param suffixName 生成的文件的后缀名 例如：.xlsx .docx
     */
    public static void downloadExcel(HttpServletResponse response, Map map, String fileName, String suffixName) {
        Configuration configuration = new Configuration();
        //configuration.setDefaultEncoding("utf-8");
        //有两种方式获取你的模板，模板在项目中时用第一个，模板在本地时用第二个。
        //注意：两种方式的路径都只需要写到模板的上一级目录
        //configuration.setClassForTemplateLoading(this.getClass(), "/template");
        //this.getClass()在static中不可使用，可以使用类名.class获取class
        //template为模板的文件夹名，需要写成常量，容易更改
        configuration.setClassForTemplateLoading(ImportExcelUtil.class, Const.IMPORT_TEMPLATE_PATH);
        //  configuration.setDirectoryForTemplateLoading(new File("C:/"));
        //File outFile = new File("D:/outFile/"+Math.random()*10000+".xls");//输出路径
        response.setContentType("application/octet-stream");
        //response.setHeader("Content-disposition", "attachment;filename=" + UUID.randomUUID().toString() + ".xlsx");
        //后缀名作为动态的
        response.setHeader("Content-disposition", "attachment;filename=" + UUID.randomUUID().toString() + suffixName);
        Template t = null;
        OutputStream out = null;
        OutputStreamWriter writer = null;
        try {
            // t = configuration.getTemplate("excel-template.xml", "utf-8"); //文件名，获取模板
            //fileName,传过来的作为常量
            t = configuration.getTemplate(fileName, "utf-8"); //文件名，获取模板
            out = response.getOutputStream();
            writer = new OutputStreamWriter(out, "utf-8");
            t.process(map, writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 导出pdf
     *
     * @param map
     * @param response
     */
    public static void uploadPdf(Map map, HttpServletResponse response) {
        ByteArrayOutputStream baos = null;
        OutputStream out = null;
        try {
            //调用工具类
            baos = ImportExcelUtil.createPDF(map, Const.IMPORT_PDF_PATH);

            // 设置响应消息头，告诉浏览器当前响应是一个下载文件
            response.setContentType("application/x-msdownload");
            // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
            String fileName = URLEncoder.encode("月度报告.pdf", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            baos.writeTo(out);
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 通过模板导出pdf文件
     *
     * @param data             数据
     * @param templateFileName 模板文件名
     * @throws Exception ：SIMSUN.TTC为宋体，可在C:\Windows\Fonts中查找
     *                   <p>
     *                   文章路径：https://blog.csdn.net/weixin_39806100/article/details/86616041
     */
    public static ByteArrayOutputStream createPDF(Map data, String templateFileName) throws Exception {
        // 创建一个FreeMarker实例, 负责管理FreeMarker模板的Configuration实例
        Configuration cfg = new Configuration();
        // 指定FreeMarker模板文件的位置
        cfg.setClassForTemplateLoading(ImportExcelUtil.class, Const.IMPORT_TEMPLATE_PATH);
        ITextRenderer renderer = new ITextRenderer();
        OutputStream out = new ByteArrayOutputStream();
        try {
            // 设置 css中 的字体样式（暂时仅支持宋体和黑体） 必须，不然中文不显示
            renderer.getFontResolver().addFont("/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 设置模板的编码格式
            cfg.setEncoding(Locale.CHINA, "UTF-8");
            // 获取模板文件
            Template template = cfg.getTemplate(templateFileName, "UTF-8");
            StringWriter writer = new StringWriter();

            // 将数据输出到html中
            template.process(data, writer);
            writer.flush();

            String html = writer.toString();
            // 把html代码传入渲染器中
            renderer.setDocumentFromString(html);

            // 设置模板中的图片路径 （这里的images在resources目录下） 模板中img标签src路径需要相对路径加图片名 如<img src="images/xh.jpg"/>
            // String url = ImportExcelUtil.class.getClassLoader().getResource("images").toURI().toString();
            // renderer.getSharedContext().setBaseURL(url);
            renderer.layout();

            renderer.createPDF(out, false);
            renderer.finishPDF();
            out.flush();
            return (ByteArrayOutputStream) out;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

