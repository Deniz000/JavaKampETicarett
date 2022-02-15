package com.company.business.abstracts;

import com.company.entities.concretes.User;

public interface UserService {
    void signUp(User user);
    void logIn(User user);
}
