package com.company.dataAccess.concretes;

import com.company.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements com.company.dataAccess.abstracts.UserDao {

    List<User> users = new ArrayList<User>();
    @Override
    public void add(User user) {
        System.out.println("Kullanıcı eklendi "
                + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public void delete(User user) {

        System.out.println("Kullanıcı silindi! "
                + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public void update(User user) {

        System.out.println("Kullanıcı bilgileri güncellendi "
                + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public User get(int id) {

        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

}
