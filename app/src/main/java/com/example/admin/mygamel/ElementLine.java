package com.example.admin.mygamel;

import android.content.Context;
import android.util.AttributeSet;

import java.util.Random;

/**
 * Created by Admin on 25.04.2017.
 */
public class ElementLine extends Element{

    public ElementLine(Context context) {
        super(context);
    }

    public ElementLine(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    void getRandPos() {
        Random r = new Random();
        switch (r.nextInt(2)) {
            case 0:
                position = Position.pos1;
                break;
            case 1:
                position = Position.pos2;
                this.setRotation(90);
                break;
            default:
                break;
        }
    }

    @Override
    void nextPosition() {
        if(position.equals(Position.pos1)){
            position = Position.pos2;
        } else if(position.equals(Position.pos2)){
            position = Position.pos1;
        }
    }

    void setActive(){
        this.setImageResource(R.drawable.elem_line_active);
    }

    void resetActive(){
        this.setImageResource(R.drawable.elem_line);
    }

}
