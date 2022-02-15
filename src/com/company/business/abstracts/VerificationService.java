package com.company.business.abstracts;

import com.company.entities.concretes.User;

public interface VerificationService {
    void sendToVerifyMail(User user);
    void verifyMail(User user);
    boolean checkVerifyAccount(User user);
}
