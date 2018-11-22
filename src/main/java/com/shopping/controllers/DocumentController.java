package com.shopping.controllers;

import com.shopping.entities.Document;
import com.shopping.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("document")
@CrossOrigin("*")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping(value = "/uploadFile")
    public ResponseEntity  handleFileUpload(@RequestParam(value="file") MultipartFile file) throws IOException {
        String message = "";
        try{
            Document ret = this.documentService.saveFile(file);
            return ResponseEntity.ok(ret);
        }catch (Exception  e){
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }
}
