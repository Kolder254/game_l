package com.example.admin.mygamel;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<Element> myElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myElements = new ArrayList<>();

        ImageView view11 = (ImageView) findViewById(R.id.pos_1_1);
        ElementCorner view12 = (ElementCorner) findViewById(R.id.pos_1_2);
        ElementCorner view13 = (ElementCorner) findViewById(R.id.pos_1_3);
        ElementLine view14 = (ElementLine) findViewById(R.id.pos_1_4);
        ElementLine view21 = (ElementLine) findViewById(R.id.pos_2_1);
        ElementLine view22 = (ElementLine) findViewById(R.id.pos_2_2);
        ElementLine view23 = (ElementLine) findViewById(R.id.pos_2_3);
        ElementCorner view24 = (ElementCorner) findViewById(R.id.pos_2_4);
        ElementCorner view31 = (ElementCorner) findViewById(R.id.pos_3_1);
        ElementCorner view32 = (ElementCorner) findViewById(R.id.pos_3_2);
        ElementCorner view33 = (ElementCorner) findViewById(R.id.pos_3_3);
        ElementCorner view34 = (ElementCorner) findViewById(R.id.pos_3_4);
        ElementCorner view41 = (ElementCorner) findViewById(R.id.pos_4_1);
        ElementLine view42 = (ElementLine) findViewById(R.id.pos_4_2);
        ElementCorner view43 = (ElementCorner) findViewById(R.id.pos_4_3);
        ImageView view44 = (ImageView) findViewById(R.id.pos_4_4);


        view12.setRightPos(Position.pos2);
        view13.setRightPos(Position.pos3);
        view21.setRightPos(Position.pos2);
        view22.setRightPos(Position.pos2);
        view23.setRightPos(Position.pos2);
        view31.setRightPos(Position.pos1);
        view32.setRightPos(Position.pos4);
        view33.setRightPos(Position.pos1);
        view34.setRightPos(Position.pos3);


        myElements.add(view12);
        myElements.add(view13);
        myElements.add(view21);
        myElements.add(view22);
        myElements.add(view23);
        myElements.add(view31);
        myElements.add(view32);
        myElements.add(view33);
        myElements.add(view34);

        view11.setOnClickListener(this);
        view12.setOnClickListener(this);
        view13.setOnClickListener(this);
        view14.setOnClickListener(this);
        view21.setOnClickListener(this);
        view22.setOnClickListener(this);
        view23.setOnClickListener(this);
        view24.setOnClickListener(this);
        view31.setOnClickListener(this);
        view32.setOnClickListener(this);
        view33.setOnClickListener(this);
        view34.setOnClickListener(this);
        view41.setOnClickListener(this);
        view42.setOnClickListener(this);
        view43.setOnClickListener(this);
        view44.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Element){
            ((Element) v).myRotate();
        }
        if(isCompleted()){
            Log.v("Main","Complete");
            final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setView(R.layout.alert_layout)
                    .setNegativeButton("cancell", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create()
                    .show();
            /*Button btnOk =(Button) findViewById(R.id.btn_ok);
            btnOk.setOnClickListener(new View.OnClickListener(){
                @Override
                 public void onClick(View v) {

                }
            });*/
        }
    }

    boolean isCompleted(){
        for (Element v: myElements) {
            if(!v.isRightPos()){
                return false;
            }
        }
        return true;
    }
}



//Abstract element
abstract class Element extends android.support.v7.widget.AppCompatImageView{
    Position position = Position.pos1;
    Position rightPos = Position.pos1;
    boolean isNeeded = false;

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

// corner element
class ElementCorner extends Element{


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

class ElementLine extends Element{

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
}

enum Position{
    pos1,pos2,pos3,pos4;
}

