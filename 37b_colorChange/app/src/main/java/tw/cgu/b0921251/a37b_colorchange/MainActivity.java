package tw.cgu.b0921251.a37b_colorchange;

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

    public void changerandom(View v){
        TextView LR = findViewById(R.id.L_R);
        TextView LG = findViewById(R.id.L_G);
        TextView LB = findViewById(R.id.L_B);
        View color = findViewById(R.id.LL_color);

        Random ran = new Random();
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);

        LR.setTextColor(Color.rgb(r,g,b));
        LG.setTextColor(Color.rgb(r,g,b));
        LB.setTextColor(Color.rgb(r,g,b));

        r = ran.nextInt(256);
        g = ran.nextInt(256);
        b = ran.nextInt(256);

        color.setBackgroundColor(Color.rgb(r,g,b));
    }

    public void changeWord(View v){
        TextView LR = findViewById(R.id.L_R);
        TextView LG = findViewById(R.id.L_G);
        TextView LB = findViewById(R.id.L_B);
        TextView TR = findViewById(R.id.T_R);
        TextView TG = findViewById(R.id.T_G);
        TextView TB = findViewById(R.id.T_B);

        int r = Integer.parseInt(TR.getText().toString());
        int g = Integer.parseInt(TG.getText().toString());
        int b = Integer.parseInt(TB.getText().toString());

        LR.setTextColor(Color.rgb(r,g,b));
        LG.setTextColor(Color.rgb(r,g,b));
        LB.setTextColor(Color.rgb(r,g,b));
    }

    public void changeBackground(View v){
        View color = findViewById(R.id.LL_color);
        TextView TR = findViewById(R.id.T_R);
        TextView TG = findViewById(R.id.T_G);
        TextView TB = findViewById(R.id.T_B);

        int r = Integer.parseInt(TR.getText().toString());
        int g = Integer.parseInt(TG.getText().toString());
        int b = Integer.parseInt(TB.getText().toString());

        color.setBackgroundColor(Color.rgb(r,g,b));
    }
}