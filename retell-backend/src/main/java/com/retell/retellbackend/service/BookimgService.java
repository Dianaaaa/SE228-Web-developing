package com.retell.retellbackend.service;

import org.springframework.web.multipart.MultipartFile;

public interface BookimgService {
    String uploadfile(MultipartFile file);

    byte[] getfile(String fileid);
}
