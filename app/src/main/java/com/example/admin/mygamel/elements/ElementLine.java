package com.example.admin.mygamel.elements;

import android.content.Context;
import android.util.AttributeSet;

import com.example.admin.mygamel.base_classes.Element;
import com.example.admin.mygamel.Position;
import com.example.admin.mygamel.R;

import java.util.Random;

/**
 * Created by Admin on 25.04.2017.
 */
public class ElementLine extends Element {

    public ElementLine(Context context) {
        super(context);
    }

    public ElementLine(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected void getRandPos() {
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
    protected void nextPosition() {
        if(position.equals(Position.pos1)){
            position = Position.pos2;
        } else if(position.equals(Position.pos2)){
            position = Position.pos1;
        }
    }

    public void setActive(){
        this.setImageResource(R.drawable.elem_line_active);
    }

    public void resetActive(){
        this.setImageResource(R.drawable.elem_line);
    }

}
