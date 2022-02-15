package com.company.core;

import com.company.google.GoogleManager;

public class googeLoginAdapter implements LogInService {

    @Override
    public void add(String message) {
        GoogleManager googleManager = new GoogleManager();
        googleManager.simulator();
    }
}
