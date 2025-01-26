package ru.gocinema.server.services;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    private static final String SALT = "gocimena";

    @Override
    public String sign(String password) {
        return Md5Crypt.md5Crypt(password.getBytes(StandardCharsets.UTF_8), SALT);
    }
}
