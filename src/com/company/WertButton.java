package com.company;

import javafx.scene.control.Button;

public class WertButton extends Button {
    int wert;
    public WertButton(String s,int wert){
    super(s);
        this.wert=wert;
    }

    public int getWert() {
        return wert;
    }
}
