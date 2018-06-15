package com.example.trong.gamelistui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class GamesDAO {
    private  SQLiteDatabase gamesdao;
    private dbHelper dh;
    private  Context c;

    public GamesDAO(Context c) {
        this.c = c;
        dh = new dbHelper(c);
        gamesdao = dh.getWritableDatabase();
    }

    public ArrayList<Game> getAllGames(){
        ArrayList<Game> glst = new ArrayList<Game>();
        Cursor cr = gamesdao.rawQuery("select * from games", null);
        if(cr.moveToFirst()){
            while (cr.isAfterLast() == false){
                Log.d("dfdfdfdfdfdfddf","vo dc vong lap");
                int gid = cr.getInt(0);
                String gname = cr.getString(1);
                Log.d("tengname", ""+cr.getString(1));
                String gimg = cr.getString(2);

                Game g = new Game(gid, gname, gimg);
                glst.add(g);

                cr.moveToNext();
            }
            Log.d("vao lenh if", ""+glst.size());
        }

        cr.close();

        Log.d("GamesListdao", ""+glst.size());
        return glst;
    }
}

class Game{
    private int gid;
    private String gname;
    private String gimg;

    public Game(int gid, String gname, String gimg) {
        this.setGid(gid);
        this.setGname(gname);
        this.setGimg(gimg);
    }


    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }
}

class dbHelper extends SQLiteOpenHelper{

    public dbHelper(Context context) {
        super(context, "games.db", null, 1);
        Log.i("vo dc constructor", "dgsdgshdsds");
        Log.d("dbhelper","database created!!!!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("Create table games (gid INTEGER primary key AUTOINCREMENT not null, gname varchar(50) not null, gimg varchar(150) not null)");
//        db.execSQL("insert into games(gname, gimg) values('Fallout 3', 'pic1')");
//        db.execSQL("insert into games(gname, gimg) values('Call of duty Blackops 3', 'pic2')");
//        db.execSQL("insert into games(gname, gimg) values('Victoria', 'pic3')");
//        db.execSQL("insert into games(gname, gimg) values('Battlefiled 3', 'pic4')");

        db.execSQL("Create table games (gid INTEGER primary key not null, gname varchar(50) not null, gimg varchar(150) not null)");
        db.execSQL("insert into games(gid,gname, gimg) values(1,'Fallout 3', 'pic1')");
        db.execSQL("insert into games(gid, gname, gimg) values(2,'Call of duty Blackops 3', 'pic2')");
        db.execSQL("insert into games(gid, gname, gimg) values(3,'Victoria', 'pic3')");
        db.execSQL("insert into games(gid, gname, gimg) values(4,'Battlefiled 3', 'pic4')");

        Log.d("oncreate","table data created!!!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

