package com.devsav.common.utility;

import org.springframework.stereotype.Component;

@Component
public class Notificator {

    public void notifyAdminEnter(String email) {
        MailSender.sendMail(email, "Welcome Admin!");
    }
}