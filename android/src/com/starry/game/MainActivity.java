package com.starry.game;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.starry.game.fragment.AccountFragment;
import com.starry.game.fragment.HomeFragment;
import com.starry.game.fragment.PeopleFragment;

public class MainActivity extends Activity implements View.OnClickListener {

    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(findViewById(R.id.framelayout)!=null){
//            if(savedInstanceState != null)
//                return;
//        }
        getFragmentManager().beginTransaction().replace(R.id.framelayout, new HomeFragment()).commit();

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        //mPlayer = MediaPlayer.create(getBaseContext(), R.raw.bgm_logo);
        //mPlayer.start();
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                getFragmentManager().beginTransaction().replace(R.id.framelayout, new HomeFragment()).commit();
                break;
            case R.id.button2:
                getFragmentManager().beginTransaction().replace(R.id.framelayout, new PeopleFragment()).commit();
                break;
            case R.id.button3:
                getFragmentManager().beginTransaction().replace(R.id.framelayout, new AccountFragment()).commit();
        }
    }

}
