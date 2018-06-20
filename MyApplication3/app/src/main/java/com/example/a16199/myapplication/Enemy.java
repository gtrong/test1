package com.example.a16199.myapplication;

import java.util.Iterator;

public class Enemy {
    private int textX;
    private int textY;
    private int type;
    private int sizeX;
    private int sizeY;
    private boolean isDead;
    private float direcX=1;
    private float direcY=1;
    public Enemy(int textX,int textY,int type,int sizeX,int sizeY){
        this.textX=textX;
        this.textY=textY;
        this.type=type;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
    }
    public int getTextX(){
        return textX;
    }
    public int getTextY(){
        return textY;
    }
    public int getType(){
        return type;
    }
    public int getSizeX(){
        return sizeX;
    }
    public int getSizeY(){
        return sizeY;
    }
    public boolean getIsDead(){
        return isDead;
    }
    public void setTextX(int textX){
        this.textX=textX;
    }
    public void setTextY(int textY){
        this.textY=textY;
    }
    public void setIsDead(boolean isDead){
        this.isDead=isDead;
    }
    public void setDirecX(float x){
        this.direcX=x;
    }
    public void setDirecY(float y){
        this.direcY=y;
    }
    public void move(){
        textX+=10*direcX/Math.sqrt(direcX*direcX+direcY*direcY);
        textY+=10*direcY/Math.sqrt(direcX*direcX+direcY*direcY);
        if(textX<0)
            textX=0;
        if(textX>1800)
            textX=1800;
        if(textY<0)
            textY=0;
        if(textY>900)
            textY=900;
    }
    /*public boolean test(int x,int y){
        if(textX+(10*(direcX/Math.sqrt(direcX*direcX+direcY*direcY)))>=x-sizeX|| textX+(10*(direcX/Math.sqrt(direcX*direcX+direcY*direcY)))<=x+sizeX){
            return true;
        }
        else if(textY+(10*(direcY/Math.sqrt(direcX*direcX+direcY*direcY)))>=y-sizeY||textY+(10*(direcY/Math.sqrt(direcX*direcX+direcY*direcY)))<=y+sizeY){
            return true;
        }
        else return false;
    }*/
}
