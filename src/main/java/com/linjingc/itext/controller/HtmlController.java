package com.linjingc.itext.controller;

import com.linjingc.itext.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cxc
 * @date 2018/11/23 09:49
 */
@Controller
@RequestMapping("html")
public class HtmlController {
    @Autowired
    private HtmlService htmlService;

    @GetMapping(value = "exportHtmlToPdf")
    @ResponseBody
    public String exportHtmlToPdf() {
        htmlService.exportHtmlToPdf();
        return "html文件导出到pdf";
    }


    @GetMapping(value = "exportHtmlTemplateToPdf")
    @ResponseBody
    public String exportHtmlTemplateToPdf() {
        try {
            htmlService.exportHtmlTemplateToPdf();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "html模板文件导出到pdf";
    }

    /**
     * html模板填充内容到PDF
     *
     * @return
     */
    @GetMapping(value = "exportHtmlFillToPdf")
    @ResponseBody
    public String exportHtmlFillToPdf() {
        htmlService.exportHtmlFillToPdf();
        return "html模板文件导出到pdf";
    }


    /**
     * 模板直接导出到浏览器
     */
    @GetMapping(value = "exportHtmlFillPdfToBrowser")
    public void exportHtmlFillPdfToBrowser(HttpServletResponse response)throws Exception{
        try {
            htmlService.exportHtmlFillPdfToBrowser(response);
        }catch (Exception e){
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print("导出失败");

        }
    }

}
