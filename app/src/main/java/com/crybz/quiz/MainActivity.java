package com.crybz.quiz;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private long timePressed;
    Toast tostExit ;

    Button bNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNext = findViewById(R.id.b_next);
        bNext.setOnClickListener(this);


        // код убирает полосу с зарядом и сетью

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.b_next:
                Intent intent = new Intent(this,GameLevel.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onBackPressed() { // не понял почему timePressed + 2000 не true?

        if (timePressed + 2000 > System.currentTimeMillis()){
            long time = System.currentTimeMillis();
            System.out.println("  "+time);
            tostExit.cancel();
            super.onBackPressed();
        }
        else{
            tostExit = Toast.makeText(getBaseContext(),"нажмите еще раз",Toast.LENGTH_LONG);
            tostExit.show();
        }
        timePressed = System.currentTimeMillis();
    }
}
