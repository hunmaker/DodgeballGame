package com.starry.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.starry.game.Ball.BallManager;

public class ModeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        Button easy = (Button)findViewById(R.id.easy);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BallManager.getInstance().hardLevel = 0;
                Intent intent = new Intent(ModeActivity.this, AndroidLauncher.class);
                startActivity(intent);
            }
        });

        Button normal = (Button)findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BallManager.getInstance().hardLevel = 1;
                Intent intent = new Intent(ModeActivity.this, AndroidLauncher.class);
                startActivity(intent);
            }
        });

        Button hard = (Button)findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BallManager.getInstance().hardLevel = 2;
                Intent intent = new Intent(ModeActivity.this, AndroidLauncher.class);
                startActivity(intent);
            }
        });

    }
}
