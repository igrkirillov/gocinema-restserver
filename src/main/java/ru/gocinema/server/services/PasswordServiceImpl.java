package ru.gocinema.server.services;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    private static final String MD5_SALT = "$1$gocim";

    @Override
    public String sign(String password) {
        return Md5Crypt.md5Crypt(password.getBytes(StandardCharsets.UTF_8), MD5_SALT);
    }
}
