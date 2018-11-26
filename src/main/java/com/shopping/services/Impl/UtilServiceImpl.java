package com.shopping.services.Impl;

import com.shopping.services.UtilService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

    @Override
    public String getImgLogin() {
        return null;
    }

    @Override
    public String encodeBase(byte[] file){
        Base64 codec = new Base64();
        return codec.encodeAsString(file);
    }
}
