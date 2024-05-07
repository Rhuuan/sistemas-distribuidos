package com.ms.reservation;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}