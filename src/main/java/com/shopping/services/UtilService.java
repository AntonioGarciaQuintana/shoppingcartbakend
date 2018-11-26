package com.shopping.services;

import org.springframework.stereotype.Service;
@Service
public interface UtilService {

     String getImgLogin();

    String encodeBase(byte[] file);
}
