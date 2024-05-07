package com.ms.reservation;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(String to, String subject, String body) {
        // Simula o envio de e-mail
        System.out.println("Enviando e-mail para: " + to);
        System.out.println("Assunto: " + subject);
        System.out.println("Corpo: " + body);
        System.out.println("E-mail enviado com sucesso!");
    }
}
