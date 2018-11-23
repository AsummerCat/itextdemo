package com.linjingc.itext.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.linjingc.itext.util.ChineseFontUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * itext测试demo
 *
 * @author cxc
 * @date 2018/11/22 23:29
 */
@Service
@Log4j2
public class HelloService {

    @Autowired
    private ChineseFontUtil chineseFontUtil;

    /**
     * 测试导出Pdf
     */
    public void exportPdf() {

        //创建一个临时目录接收
        String uploadPath = this.getClass().getClassLoader().getResource("").getPath() + File.separator;

        try {
            //1、创建文档对象实例
            Document document = new Document();

            //获取字体解决中文乱码问题
            Font fontChinese = chineseFontUtil.getChineseFont();

            //页面大小
            Rectangle rect = new Rectangle(PageSize.B4.rotate());
            //页面背景色
            rect.setBackgroundColor(BaseColor.ORANGE);

            //创建一个pdf
            PdfWriter.getInstance(document, new FileOutputStream(uploadPath + "一只写Bug的猫普通的导出Pdf.pdf"));
            //打开pdf
            document.open();
            //写入内容
            for (int i = 0; i < 5; i++) {
                document.add(new Paragraph("Hello World哈哈哈", fontChinese));
            }
            //关闭pdf
            document.close();

        } catch (IOException | DocumentException e) {
            log.info("导出错误{}", e);
        }
    }

}
