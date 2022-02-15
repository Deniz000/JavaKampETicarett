package com.company;

import com.company.business.concretes.CheckManager;
import com.company.business.concretes.MailVerificationManager;
import com.company.business.concretes.UserManager;
import com.company.dataAccess.concretes.HibernateUserDao;
import com.company.entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(1,"Güldeniz","Özdemir","guleniz@gmail.com","guldeniz");
        User user2 = new User(2,"Emre","Eren","emre@gmail.com","emre01");
        User user3 = new User(3,"Fatma","Orhan","fatma@gmail.com","fatmma");

        UserManager userManager = new UserManager(new CheckManager(), new MailVerificationManager(),new HibernateUserDao());
        userManager.signUp(user1);
        userManager.signUp(user2);
        userManager.signUp(user3);
    }
}
