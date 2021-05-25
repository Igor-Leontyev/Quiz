package com.crybz.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static com.crybz.quiz.R.drawable.*;

public class Level1 extends AppCompatActivity {
    LinearLayout askExam;

    Dialog dialog;
    int countProgress = 0;

    ImageView img_ask, img_answer_left, img_abswer_right;
    int count = 0;
    int i = 0;
    ArrayO arrayO = new ArrayO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView t_level = findViewById(R.id.t_level);
        t_level.setText(R.string.LVL_1);

        //Развернуть игру на весь экран (начало)
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Развернуть игру на весь экран (конец)


        img_ask = findViewById(R.id.img_asks);
        img_answer_left = findViewById(R.id.img_answer_left);
        img_abswer_right = findViewById(R.id.img_answer_right);


        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9,
                R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16, R.id.point17,
                R.id.point18, R.id.point19, R.id.point20,

        };

        //подключаем анимацию
        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);
        // конец


        //блок кода с заменой кртинки


        //обрабатываем нажатие на картинк

        if ((count % 2 )!= 1) {

            //блок кода с заменой кртинки
            img_ask.setImageResource(arrayO.imegesAsk[i]);
            img_answer_left.setImageResource(arrayO.imegesAnswerTrue[i]);
            img_abswer_right.setImageResource(arrayO.imegesAnswerFalse[i]);

            img_answer_left.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        img_abswer_right.setEnabled(false);//блокировка правой картинки
                        img_answer_left.setImageResource(true_green);


                    }

                         else if (event.getAction() == MotionEvent.ACTION_UP) {

                        countProgress++;
                        count++;
                        i++;

                        img_ask.setImageResource(arrayO.imegesAsk[i]);
                        img_answer_left.setImageResource(arrayO.imegesAnswerTrue[i]);
                        img_abswer_right.setImageResource(arrayO.imegesAnswerFalse[i]);




                        for(int i = 0;i<countProgress;i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.true_prog);
                        }


                    }
                         img_abswer_right.setEnabled(true);

                    return true;
                }
            });

        }

        else {

            //блок кода с заменой кртинки
            img_ask.setImageResource(arrayO.imegesAsk[i]);
            img_answer_left.setImageResource(arrayO.imegesAnswerFalse[i]);
            img_abswer_right.setImageResource(arrayO.imegesAnswerTrue[i]);

            img_abswer_right.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        img_answer_left.setEnabled(false);//блокировка правой картинки
                        img_abswer_right.setImageResource(true_green);


                    }



                    else if (event.getAction() == MotionEvent.ACTION_UP) {

                        img_ask.setImageResource(arrayO.imegesAsk[i]);
                        img_answer_left.setImageResource(arrayO.imegesAnswerFalse[i]);
                        img_abswer_right.setImageResource(arrayO.imegesAnswerTrue[i]);

                        countProgress++;
                        count++;
                        i++;

                        for(int i = 0;i<countProgress;i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.true_prog);
                        }

                    }
                    img_answer_left.setEnabled(true);

                    return true;
                }
            });


        }

        //код для закругления углов (начало
        img_ask.setClipToOutline(true);
        img_answer_left.setClipToOutline(true);
        img_abswer_right.setClipToOutline(true);
        //код для закругления углов (конец

        dialog = createTaskInfoDialog();

        TextView b_close = dialog.findViewById(R.id.b_close);
        b_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level1.this,GameLevel.class);
                    startActivity(intent);
                    finish();//закрыть Level1

                }
                catch (Exception e){

                }
                dialog.dismiss();//закрываем диалоговое окно
            }
        });

        dialog.show();// показать диалоговое окно ( запустить )

        Button b_continue  = dialog.findViewById(R.id.b_continue);
        b_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dialog.dismiss();
                }
                catch (Exception e){
                }
            }
        });

        Button b_exit = findViewById(R.id.b_exit);
        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level1.this, GameLevel.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){
                }
            }
        });
    }

    public Dialog createTaskInfoDialog(){
        //вызов нового диалогового окна
        Dialog dialog = new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//убираем заголовок
        dialog.setContentView(R.layout.diolog_prewie);//путь к макету диологового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозрачный фон за диалоговым окном
        dialog.setCancelable(false);// невозможность закрыть системной кнопкой назад <

        return dialog;
    }

    public void imageExchange(){

    }

    //обработка системной кнопки
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(Level1.this, GameLevel.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
    }

}
