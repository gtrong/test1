package com.example.a16199.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

import java.util.ArrayList;
import java.util.Arrays;

public class MySurfaceView extends SurfaceView implements Callback,Runnable {
    private SurfaceHolder sfh;
    private Paint paint;
    private int textX = 10, textY = 10;
    private Thread th;
    private boolean flag;
    private Canvas canvas;
    private int screenW, screenH;
    private float dx = 0, dy = 0;
    private float x = 200, y = 300;
    private int i = 0;
    private boolean direction = true;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private ArrayList<Enemy> enemys = new ArrayList<Enemy>();
    private ArrayList<Bullet> bulletsR=new ArrayList<Bullet>();
    private int count = 0;

    public MySurfaceView(Context context) {
        super(context);

        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        screenW = this.getWidth();
        screenH = this.getHeight();
        flag = true;
        th = new Thread((Runnable) this);
        th.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int points = event.getPointerCount();
        for (int i = 0; i < points; i++) {
            double b = Math.pow((double) event.getX(i) - 500, 2) + Math.pow((double) event.getY(i) - 500, 2);

            if (event.getX(i) > screenW / 2) {
                Bullet bullet = new Bullet(textX, textY);
                if (enemys.size() > 0) {
                    bullet.setX((float) (enemys.get(0).getTextX() - textX));
                    bullet.setY((float) (enemys.get(0).getTextY() - textY));
                } else {
                    bullet.setX(dx);
                    bullet.setY(dy);
                }
                bullets.add(bullet);
            }
            if (b < 150000 || event.getX(i) < screenW / 2) {
                dx = (int) event.getX(i) - 500;
                dy = (int) event.getY(i) - 500;
                dx = dx / 20;
                dy = dy / 20;
                if (dx < 0)
                    direction = true;
                else
                    direction = false;




        /*switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 按下
                dx = (int) event.getX() - 500;
                dy = (int) event.getY() - 500;
                if(dx<0)
                    direction=true;
                else
                    direction=false;
                dx=dx/10;
                dy=dy/10;
                break;


            case MotionEvent.ACTION_MOVE:
                // 移动
                dx = (int) event.getX() - 500;
                dy = (int) event.getY() - 500;
                if(dx<0)
                    direction=true;
                else
                    direction=false;
                dx=dx/20;
                dy=dy/20;
//                Log.d("TIEJIANG", "CX= " + cx + ", CY= " + cy);
                break;
            case MotionEvent.ACTION_UP:
                // 抬起
                dx = (int) event.getX() - 500;
                dy = (int) event.getY() - 500;
                if(dx<0)
                    direction=true;
                else
                    direction=false;
                dx=dx/20;
                dy=dy/20;
                //小球回到原点
                dx = (screenW/2 - 500)/10;
                dy = (screenH/2 - 500)/10;
                break;
                default:
                    dx = (int) event.getX() - 500;
                    dy = (int) event.getY() - 500;
                    if(dx<0)
                        direction=true;
                    else
                        direction=false;
                    dx=dx/10;
                    dy=dy/10;
                    break;
        }*/
                textY += (int) dy;
                textX += (int) dx;
                if (textX > 1800)
                    textX = 1800;
                if (textY > 900)
                    textY = 900;
                if (textX < 0)
                    textX = 0;
                if (textY < 0)
                    textY = 0;
                return true;
            }
        }
        return true;
    }

    private void logic() {
        if (enemys.size()==0&&count==0) {
            Enemy ene = new Enemy(50, 50, 1, 50, 50);
            ene.setIsDead(true);
            ene.setDirecX(1);
            ene.setDirecY(2);
            Bullet bullet=new Bullet(50,50);
            bullet.setY(textY-50);
            bullet.setX(textX-50);
            bullet.setSpeed(1);
            bulletsR.add(bullet);
            enemys.add(ene);
            ene.setTextX(300);
            Enemy ene1 = new Enemy(500, 500, 1, 50, 50);
            Bullet bullet1=new Bullet(500,500);
            bullet1.setY(textY-500);
            bullet1.setX(textX-500);
            bullet1.setSpeed(1);
            bulletsR.add(bullet1);
            ene1.setDirecY(5);
            ene1.setDirecX(-1);
            enemys.add(ene1);

            Enemy ene2 = new Enemy(1000, 600, 1, 50, 50);
            Bullet bullet2=new Bullet(500,500);
            bullet2.setY(textY-500);
            bullet2.setX(textX-600);
            bullet2.setSpeed(1);
            bulletsR.add(bullet2);
            ene2.setDirecY(-3);
            ene2.setDirecX(-5);
            enemys.add(ene2);
            count=1;
        }
        if(enemys.size()==0&&count==1){
            Enemy ene = new Enemy(800, 100, 1, 50, 50);
            ene.setIsDead(true);
            ene.setDirecY(3);
            ene.setDirecX(4);
            enemys.add(ene);
            Bullet bullet=new Bullet(500,500);
            bullet.setY(textY-800);
            bullet.setX(textX-100);
            bullet.setSpeed(1);
            bulletsR.add(bullet);
            ene.setTextX(300);
            ene.setDirecY(9);
            ene.setDirecX(0);
            Enemy ene1 = new Enemy(90, 300, 1, 50, 50);
            Bullet bullet1=new Bullet(90,300);
            bullet1.setY(textY-90);
            bullet1.setX(textX-300);
            bullet1.setSpeed(1);
            bulletsR.add(bullet1);
            ene1.setDirecY(5);
            ene1.setDirecX(-4);
            enemys.add(ene1);

            Enemy ene2 = new Enemy(500, 700, 1, 50, 50);
            Bullet bullet2=new Bullet(500,700);
            bullet2.setY(textY-500);
            bullet2.setX(textX-700);
            bullet2.setSpeed(1);
            bulletsR.add(bullet2);
            ene2.setDirecY(-4);
            ene2.setDirecX(2);
            enemys.add(ene2);
            count++;

        }
        /*for(int i=0;i<enemys.size();i++){
            if(enemymove(enemys.get(i),i)){
                enemys.get(i).setDirecX(textX-enemys.get(i).getTextX());
                enemys.get(i).setDirecY(textY-enemys.get(i).getTextY());
                enemys.get(i).move();
            }
        }*/
        for(int i=0;i<enemys.size();i++){
            enemys.get(i).move();
        }
        for(int i=0;i<bulletsR.size();i++){
            bulletsR.get(i).move();
        }
       for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).move();
            if (bullets.get(i).getTextX() > 1920 && bullets.get(i).getTextY() > 1080 && bullets.get(i).getTextY() < 0 && bullets.get(i).getTextX() < 0) {
                Bullet bull = bullets.get(i);
                bullets.remove(bull);
            }
           for (int j = 0; j < enemys.size(); j++) {
               if(bullets.size()>0) {
                if (bullets.get(i).getTextX() == enemys.get(j).getTextX() + enemys.get(j).getSizeX() ) {

                        if (enemys.get(j).getTextY() < bullets.get(i).getTextY() || enemys.get(j).getTextY() + enemys.get(j).getSizeY() > bullets.get(i).getTextY()) {
                            Bullet bull = bullets.get(i);
                            bullets.remove(bull);
                            Enemy ene = enemys.get(j);
                            enemys.remove(ene);
                        }
                    }


                else if (bullets.get(i).getTextY() == enemys.get(j).getTextY() ) {
                    if (enemys.get(j).getTextY() < bullets.get(i).getTextY() || enemys.get(j).getTextY() + enemys.get(j).getSizeY() > bullets.get(i).getTextY()) {
                        Bullet bull = bullets.get(i);
                        bullets.remove(bull);
                        Enemy ene = enemys.get(j);
                        enemys.remove(ene);
                    }
                }
            }
            }
        }
    }

    @Override
    public void run() {
        while (flag) {
            long start = System.currentTimeMillis();
            myDraw();
            logic();
            long end = System.currentTimeMillis();
            try {
                if (end - start < 25) {
                    Thread.sleep(25 - (end - start));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        flag = false;
    }

    public void myDraw() {

        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawRGB(0, 0, 0);
                Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoops);
                Bitmap bmp1 = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoop1s);
                Bitmap bmp2 = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoop2s);
                Bitmap bmp3 = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoop3s);
                Bitmap bmpR = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoopsr);
                Bitmap bmp1R = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoop1sr);
                Bitmap bmp2R = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoop2sr);
                Bitmap bmp3R = BitmapFactory.decodeResource(this.getResources(), R.mipmap.uupoop3sr);
                Bitmap bulletmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.bullet);
                Bitmap enemy = BitmapFactory.decodeResource(this.getResources(), R.mipmap.enemy);
                Bitmap bulletsT=BitmapFactory.decodeResource(this.getResources(),R.mipmap.bulletr);
                Bitmap map=BitmapFactory.decodeResource(this.getResources(),R.mipmap.map);
                canvas.drawBitmap(map,0,0,paint);
                if (i < 2) {
                    if (direction)
                        canvas.drawBitmap(bmp, textX, textY, paint);
                    else
                        canvas.drawBitmap(bmpR, textX, textY, paint);

                    i++;
                } else if (i < 5) {
                    if (direction)
                        canvas.drawBitmap(bmp1, textX, textY, paint);
                    else
                        canvas.drawBitmap(bmp1R, textX, textY, paint);
                    i++;
                } else if (i < 8) {
                    if (direction)
                        canvas.drawBitmap(bmp2, textX, textY, paint);
                    else
                        canvas.drawBitmap(bmp2R, textX, textY, paint);
                    i++;
                } else {
                    if (direction)
                        canvas.drawBitmap(bmp3, textX, textY, paint);
                    else
                        canvas.drawBitmap(bmp3R, textX, textY, paint);
                    i = 0;
                }


                if (bullets != null) {
                    for (int i = 0; i < bullets.size(); i++) {
                        canvas.drawBitmap(bulletmap, bullets.get(i).getTextX(), bullets.get(i).getTextY(), paint);
                    }
                }
                if(bulletsR!=null){
                    for(int i=0;i<bulletsR.size();i++){
                        canvas.drawBitmap(bulletsT, bulletsR.get(i).getTextX(), bulletsR.get(i).getTextY(), paint);
                    }
                }
                for (int i = 0; i < enemys.size(); i++) {
                    canvas.drawBitmap(enemy, enemys.get(i).getTextX(), enemys.get(i).getTextY(), paint);

                }


            }

        } catch (Exception e) {

        } finally {
            if (canvas != null)
                sfh.unlockCanvasAndPost(canvas);
        }
    }



    /*public boolean enemymove(Enemy enemy,int index) {
        int size = enemys.size();
        for (int j = 0; j < size; j++) {
            if (j != index) {
                if (enemys.get(i).test(enemys.get(j).getTextX(), enemys.get(j).getTextY()))
                    return false;
            }
        }
        return true;


    }*/
}