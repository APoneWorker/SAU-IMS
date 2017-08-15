package com.fekpal.tool;

import com.fekpal.cons.ResponseCode;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * Created by APone on 2017/8/14.
 * word文档转html
 */

public class WordToHTML {


    public boolean toHtml(String fileName, String htmlName, String imageName) {

        OutputStreamWriter outputStreamWriter = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XWPFDocument document = new XWPFDocument(fileInputStream);
            XHTMLOptions options = XHTMLOptions.create();

            // 存放图片的文件夹,并设置html中图片的路径,图片获取路径
            options.setExtractor(new FileImageExtractor(new File(imageName)));
            options.URIResolver(new BasicURIResolver("image/" + fileName.replaceAll(".docx", "")));

            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(htmlName + "00.html"), "utf-8");
            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            xhtmlConverter.convert(document, outputStreamWriter, options);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            new WordToHTML().toHtml("D:/00.docx", "D:/ac/", "D:/ac/image/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
