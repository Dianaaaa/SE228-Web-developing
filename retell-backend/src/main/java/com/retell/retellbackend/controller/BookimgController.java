package com.retell.retellbackend.controller;


import com.retell.retellbackend.service.BookimgService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Blob;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookimgController {

    @Autowired
    public BookimgService service;

    @RequestMapping(value="/bookimg/get/{fileid}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getBookimg(@PathVariable String fileid) {
        byte[] bookimg = service.getfile(fileid);

        BASE64Encoder encoder = new BASE64Encoder();

        JSONObject res = new JSONObject();
        res.put("img", encoder.encode(bookimg));
        return res;

    }

    @RequestMapping(value="/bookimg/upload", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject uploadBookimg(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        String result = service.uploadfile(multipartFile);
        JSONObject res = new JSONObject();
        if (result != null) {
            res.put("msg", "ok");
            res.put("status", 200);
        } else {
            res.put("msg", "error");
            res.put("status", 401);
        }
        return res;
    }
}
