package tw.cgu.b0921251.a37_random_color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void changeColor(View v){
        TextView LR = findViewById(R.id.L_R);
        TextView LG = findViewById(R.id.L_G);
        TextView LB = findViewById(R.id.L_B);
        View color = findViewById(R.id.L_color);

        Random ran = new Random();
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);

        LR.setTextColor(Color.rgb(r,0,0));
        LG.setTextColor(Color.rgb(0,g,0));
        LB.setTextColor(Color.rgb(0,0,b));

        LR.setText("R : " + r);
        LG.setText("G : " + g);
        LB.setText("B : " + b);

        color.setBackgroundColor(Color.rgb(r,g,b));
    }
}