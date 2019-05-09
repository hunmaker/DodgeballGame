package com.starry.game;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button2).setOnClickListener(new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            changeScene();
        }
    });
    }

    //씬전환
    private void changeScene()
    {
        Intent intent = new Intent(this, AndroidLauncher.class);
        startActivity(intent);
    }
}