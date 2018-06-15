package com.example.trong.gamelistui;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gvGamesList;
    private ArrayList<Game> gameslst;
    private  GamesDAO gamedao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gamedao = new GamesDAO(this);
        gameslst = gamedao.getAllGames();
        Log.d("gameslst", ""+gameslst);
        gvGamesList = findViewById(R.id.gvGamesList);
        customAdapter adapter = new customAdapter(gameslst, this);
        gvGamesList.setAdapter(adapter);
        int size = gameslst.size();
        Log.d("glst size", ""+size);
        Log.d("end","endddd");
    }

    class customAdapter extends BaseAdapter{
        ArrayList<Game> glst;
        Context c;

        public customAdapter(ArrayList<Game> glst, Context c) {
            this.glst = glst;
            this.c = c;
            Log.d("xxx", "yyy");
        }

        @Override
        public int getCount() {
            return glst.size();
        }

        @Override
        public Object getItem(int i) {
            return glst.get(i);
        }

        @Override
        public long getItemId(int i) {
            return glst.get(i).getGid();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Log.d("aaa", "yyy");
            Game g = glst.get(i);
            LayoutInflater l = LayoutInflater.from(c);
            view = l.inflate(R.layout.gameitem, null);
            ImageView img = view.findViewById(R.id.img);
            TextView txtGameName = view.findViewById(R.id.txtGameName);

            img.setImageURI(Uri.parse("android.resource://com.example.trong.gamelistui/drawable/" + g.getGimg()));
            txtGameName.setText(g.getGname());
            return view;
        }
    }
}

