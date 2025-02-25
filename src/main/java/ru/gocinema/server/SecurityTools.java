package ru.gocinema.server;

import java.util.Scanner;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class SecurityTools {

    public static void main(String[] args) {
        System.out.println("Введите пароль для шифрования:");
        String raw = new Scanner(System.in).nextLine().trim();
        String encoded = new StandardPasswordEncoder("").encode(raw);
        System.out.println(encoded);
    }
}
