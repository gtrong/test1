package com.example.a16199.myapplication;

import java.util.ArrayList;

public class Bullet {
    private int textX;
    private int textY;
    private boolean isDead;
    private float x;
    private float y;
    private int speed=2;
    private ArrayList arrayList;
    public Bullet(int textX, int textY){

        this.textX=textX;
        this.textY=textY;

    }
    public void move(){
        textX+=speed*10*(x/Math.sqrt(x*x+y*y));
        textY+=speed*10*(y/Math.sqrt(x*x+y*y));
    }
    public void setTextX(int textX){
        this.textX=textX;
    }
    public void setTextY(int textY){
        this.textY=textY;
    }
    public void setDead(boolean isDead){
        this.isDead=isDead;
    }
    public void setSpeed(int x){
        speed=x;
    }
    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }
    public int getTextX(){
        return textX;
    }
    public int getTextY(){
        return textY;
    }
    public boolean getIsDead(){
        return isDead;
    }

    /*public boolean test(int textX,int textY,int goalX,int gaolY,int textX1,int textY1,int sizeX,int sizeY){
        if(test1(textX,textY,goalX,gaolY,textX1,textY1,textX1,textY1+sizeY)==true){
            if(test1(textX,textY,goalX,gaolY,textX1,textY1,textX1+sizeX,textY1)==true){
                if(test1(textX,textY,goalX,gaolY,textX1,textY1,textX1+sizeX,textY1+sizeY)==true){
                    if(test1(textX,textY,goalX,gaolY,textX1,textY1,textX1+sizeX,textY1)==true){
                        return true;
                    }
                    else return false;
                } else return false;
            }else return false;
        }else return false;
    }*/
    /*public boolean test1(int textX,int textY,int textX1,int textY1,int textX2,int textY2,int textX3,int textY3){
        int x;
        x=((textX1-textX2)*(textY3-textY2)+(textY1-textY2)*(textX3-textX2))*(
                (textX-textX2)*(textY3-textY2)+(textY-textY2)*(textX3-textX2));
        if(x<0)return true;
        else return false;
    }*/
}
