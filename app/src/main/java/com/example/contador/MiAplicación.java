package com.example.contador;

import android.app.Application;

public class MiAplicación extends Application {
    private String currentUsername;
    public String getCurrentUsername() {
        return currentUsername;
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

}
