package com.company.business.concretes;

import com.company.business.abstracts.UserCheckSercvice;
import com.company.business.abstracts.VerificationService;
import com.company.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class MailVerificationManager implements VerificationService {

    List<User> verificatedEmails = new ArrayList<User>();
    @Override
    public void sendToVerifyMail(User user) {
        verificatedEmails.add(user);
        System.out.println(user.getEmail() + " mail gönderildi.");
    }

    @Override
    public void verifyMail(User user) {
        System.out.println(user.getEmail() + " basarıyla doğrulandı!");
    }

    @Override
    public boolean checkVerifyAccount(User user) {
        if (verificatedEmails.contains(user)){
            return true;
        }
        return false;
    }
}
