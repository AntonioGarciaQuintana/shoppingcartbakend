package com.shopping.services.Impl;

import com.shopping.entities.Document;
import com.shopping.repositories.DocumentRepository;
import com.shopping.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;

    @Autowired
    DocumentServiceImpl(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }
    @Override
    public Document saveFile(MultipartFile file) throws IOException {

        Document document = new Document();
        document.setDocName(file.getOriginalFilename());
        document.setFile(file.getBytes());
         Document ret =  this.documentRepository.save(document);

        return ret;
    }
}
