package com.company.business.concretes;

import com.company.business.abstracts.UserCheckSercvice;
import com.company.entities.concretes.User;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CheckManager implements UserCheckSercvice {
    List<String> listOfEmail = new ArrayList<String>();
    @Override
    public boolean checkFirstName(User user) {
        if (user.getFirstName().length()<2){
            System.out.println("İsminiz 2 karakterden kısa olmamalıdır!");
            return false;
        }
        else if(user.getFirstName().isEmpty()){
            System.out.println("İsim alanı boş bırakılamaz!");
            return false;
        }
            return true;
    }

    @Override
    public boolean checkLastName(User user) {
        if (user.getLastName().length()<2){
            System.out.println("Soyisminiz 2 karakterden kısa olmamalıdır!");
            return false;
        }
        else if(user.getLastName().isEmpty()){
            System.out.println("Soyisim alanı boş bırakılamaz!");
            return false;
        }
            return true;

    }

    @Override
    public boolean checkEMail(User user) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (user.getEmail().isEmpty()){
            System.out.println("Email alanı boş bırakılamaz");
            return false;
        }
        else if(!pattern.matcher(user.getEmail()).find()){ //mail adresi yazılan pattern şeklinde bulunmazsa
            System.out.println("Email formatında giriş yapınız!");
            return false;
        }
            return true;
    }

    @Override
    public boolean checkPassword(User user) {
        if (user.getPassword().isEmpty()){
            System.out.println("Şifre alanı boş bırakılamaz!");
            return false;
        }
        else if(user.getPassword().length()<6){
            System.out.println("Şifre en az 6 karakter olmalıdır!");
            return false;
        }
            return true;
    }

    @Override
    public boolean isCurrentEmail(User user) {
        if (listOfEmail.contains(user.getEmail())){
            System.out.println("Bu mail adresi ile sisteme daha önce kayıt olunmuş, farklı bir mail adresi deneyiniz.");
            return false;
        }
        else{
            listOfEmail.add(user.getEmail());
            return true;
        }
    }

    @Override
    public boolean isValid(User user) {
        if (checkFirstName(user) && checkLastName(user) && checkEMail(user) && checkPassword(user)
                && isCurrentEmail(user)) {
            return true;
        }
        return false;
    }
}
