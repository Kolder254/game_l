package com.example.admin.mygamel;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Admin on 25.04.2017.
 */ //Abstract element
abstract class Element extends android.support.v7.widget.AppCompatImageView{
    Position position = Position.pos1;
    Position rightPos = Position.pos1;

    public Element(Context context) {
        super(context);
        getRandPos();
    }

    public Element(Context context, AttributeSet attrs) {
        super(context, attrs);
        getRandPos();
    }

    abstract void getRandPos();

    boolean isRightPos(){
        if(position.equals(rightPos)){
            return true;
        }
        return false;

    }

    abstract  void nextPosition();

    public void myRotate(){
        this.setRotation(this.getRotation()+90);
        nextPosition();
    }

    public void setRightPos(Position pos) {
        rightPos = pos;
    }

}
