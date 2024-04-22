package tw.cgu.b0921251.a45_led;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener{

    TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.text);
        a.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        View bg = findViewById(R.id.background);



        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            a.setText("七彩霓虹燈\n震動中");
            vb.vibrate(5000);
//            for(int i = 0 ; i < 10 && motionEvent.getAction() == MotionEvent.ACTION_DOWN ; i++) {
                Random ran = new Random();
                int r = ran.nextInt(256);
                int g = ran.nextInt(256);
                int b = ran.nextInt(256);

                bg.setBackgroundColor(Color.rgb(r, g, b));
                r = ran.nextInt(256);
                g = ran.nextInt(256);
                b = ran.nextInt(256);
                a.setTextColor(Color.rgb(r, g, b));
//            }
        }
        else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            vb.cancel();
            bg.setBackgroundColor(Color.rgb(0,0,0));
            a.setTextColor(Color.rgb(255,255,255));
            a.setText("動霓虹");
        }

        return true;
    }
}