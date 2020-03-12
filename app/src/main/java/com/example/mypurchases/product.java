package com.example.mypurchases;

import android.widget.ImageView;

public class product  {
    String type ;

    public product(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}