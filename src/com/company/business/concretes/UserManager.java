package com.company.business.concretes;

import com.company.business.abstracts.UserCheckSercvice;
import com.company.business.abstracts.UserService;
import com.company.business.abstracts.VerificationService;
import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

public class UserManager implements UserService {
    UserCheckSercvice userCheckSercvice;
    VerificationService verificationService;
    UserDao userDao;

    public UserManager(UserCheckSercvice userCheckSercvice, VerificationService verificationService, UserDao userDao) {
        this.userCheckSercvice = userCheckSercvice;
        this.verificationService = verificationService;
        this.userDao = userDao;
    }

    @Override
    public void signUp(User user){
        //tüm bilgiler doğruysa database'e ekleniyor.
        if (userCheckSercvice.isValid(user)){
            verificationService.sendToVerifyMail(user);
            verificationService.verifyMail(user);
            userDao.add(user);
        }
        else {
            System.out.println("Kayıt olunamadı. Lütfen bilgileriniz kontrol edip tekrar deneyiniz!");
        }
    }

    @Override
    public void logIn(User user) {
        if (verificationService.checkVerifyAccount(user)){
            System.out.println("Girişi yapıldı.");
        }
        else{
            System.out.println("Girişi yapılamadı.");
        }
    }
}
