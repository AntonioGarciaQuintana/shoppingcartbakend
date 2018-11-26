package com.shopping.controllers;

import com.shopping.enums.CateroryEnum;
import com.shopping.enums.ClassificationEnum;
import com.shopping.enums.GenreEnum;
import com.shopping.services.UtilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UtilController {

    private UtilService utilService;

    @GetMapping("/categories")
    public ResponseEntity<List<CateroryEnum>> category() {
        return new ResponseEntity<List<CateroryEnum>>(Arrays.asList(CateroryEnum.values()), HttpStatus.OK);
    }

    @GetMapping("/classifications")
    public ResponseEntity<List<ClassificationEnum>> monday() {
        return new ResponseEntity<List<ClassificationEnum>>(Arrays.asList(ClassificationEnum.values()), HttpStatus.OK);
    }

    @GetMapping("/genres")
    public ResponseEntity<List<GenreEnum>> genres() {
        return new ResponseEntity<List<GenreEnum>>(Arrays.asList(GenreEnum.values()), HttpStatus.OK);
    }
    @GetMapping("/getImgLogin")
    public ResponseEntity getImgLogin() {
        return ResponseEntity.ok().body(this.utilService.getImgLogin());
    }
}
