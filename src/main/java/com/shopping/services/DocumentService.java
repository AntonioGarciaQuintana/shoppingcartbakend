package com.shopping.services;

import com.shopping.entities.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface DocumentService {

    public Document saveFile(MultipartFile file) throws IOException;
}
