package com.example.admin.mygamel;

import android.content.Context;
import android.util.AttributeSet;

import java.util.Random;

/**
 * Created by Admin on 25.04.2017.
 */ // corner element
public class ElementCorner extends Element{


    public ElementCorner(Context context) {
        super(context);
    }

    public ElementCorner(Context context, AttributeSet attrs){
        super(context,attrs);
    }


    @Override
    void getRandPos(){
        Random r = new Random();
        switch (r.nextInt(4)){
            case 0:
                position = Position.pos1;
                break;
            case 1:
                position = Position.pos2;
                this.setRotation(90);
                break;
            case 2:
                position = Position.pos3;
                this.setRotation(180);
                break;
            case 3:
                position = Position.pos4;
                this.setRotation(270);
                break;
            default:
                break;
        }
    }

    @Override
    void nextPosition(){
        if(position.equals(Position.pos1)){
            position = Position.pos2;
        } else if(position.equals(Position.pos2)){
            position = Position.pos3;
        } else if(position.equals(Position.pos3)){
            position = Position.pos4;
        } else {
            position = Position.pos1;
        }
    }

}
