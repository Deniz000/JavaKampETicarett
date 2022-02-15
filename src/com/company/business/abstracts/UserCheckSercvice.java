package com.company.business.abstracts;

import com.company.entities.concretes.User;

public interface UserCheckSercvice {
    boolean checkFirstName(User user);
    boolean checkLastName(User user);
    boolean checkEMail(User user);
    boolean checkPassword(User user);
    boolean isCurrentEmail(User user);
    boolean isValid(User user);
}
