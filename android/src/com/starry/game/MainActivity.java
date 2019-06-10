package com.starry.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.starry.game.Ball.BallManager;
import com.starry.game.fragment.AccountFragment;
import com.starry.game.fragment.HomeFragment;
import com.starry.game.fragment.PeopleFragment;

public class MainActivity extends Activity implements View.OnClickListener {


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
