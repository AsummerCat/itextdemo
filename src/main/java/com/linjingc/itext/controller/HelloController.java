package com.linjingc.itext.controller;

import com.linjingc.itext.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

/**
 * @author cxc
 * @date 2018/11/22 23:24
 */
@RestController
public class HelloController {
@Autowired
private HelloService helloService;

    @GetMapping(value = "")
    public String index() {
        return "hello";
    }

    @GetMapping(value = "exportPdf")
    public String exportPdf() {
        helloService.exportPdf();
        return "导出普通的pdf";
    }


}
