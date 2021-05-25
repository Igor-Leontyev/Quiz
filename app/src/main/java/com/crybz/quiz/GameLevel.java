package com.crybz.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameLevel extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_level);
        Button b_exit = (Button)findViewById(R.id.b_exit);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevel.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){

                }

            }
        });

        TextView b_lvl_1 = (TextView)findViewById(R.id.b_lvl_1);
        b_lvl_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevel.this,Level1.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        });

    }
}
