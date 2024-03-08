package com.vdc.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class StaticFileDownController {

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/manual/")
    public void resouceFileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Resource resource = resourceLoader.getResource("classpath:static/file/IMS_User_Manual_20211005.pdf");

            if (resource.exists()) {
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", String.format("attachment; filename=" + resource.getFilename()));
                response.setContentLength((int) resource.contentLength());

                InputStream inputStream = resource.getInputStream();
                FileCopyUtils.copy(inputStream, response.getOutputStream());
            }
    }

}
