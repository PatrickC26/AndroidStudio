package tw.cgu.b0921251.ch4light;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
    implements  View.OnClickListener, View.OnLongClickListener{

    TextView T_on, T_off, T_random ;
    ConstraintLayout background ;
    Button B_on, B_off ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        T_on = findViewById(R.id.T_on);
        T_off = findViewById(R.id.T_close);
        T_random = findViewById(R.id.T_ramdom);
        B_on = findViewById(R.id.B_on);
        B_off = findViewById(R.id.B_off);
        background = findViewById(R.id.background);

        B_on.setOnClickListener(this);
        B_on.setOnLongClickListener(this);
        B_off.setOnClickListener(this);
        B_off.setOnLongClickListener(this);

        T_on.setVisibility(View.GONE);
        T_off.setVisibility(View.GONE);
        T_off.setTextColor(Color.rgb(255,255,255));
        T_random.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.B_on){
            T_on.setVisibility(View.VISIBLE);
            T_off.setVisibility(View.GONE);
            T_random.setVisibility(View.GONE);
            background.setBackgroundColor(Color.rgb(255,255,255));
        }
        else {
            T_on.setVisibility(View.GONE);
            T_off.setVisibility(View.VISIBLE);
            T_random.setVisibility(View.GONE);
            background.setBackgroundColor(Color.rgb(0,0,0));
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.B_on){
            T_on.setVisibility(View.GONE);
            T_off.setVisibility(View.GONE);
            T_random.setVisibility(View.VISIBLE);
            T_random.setText("隨機彩色");
            Random ran = new Random();
            int r = ran.nextInt(256);
            int g = ran.nextInt(256);
            int b = ran.nextInt(256);
            T_random.setTextColor(Color.rgb(r,g,b));
            r = ran.nextInt(256);
            g = ran.nextInt(256);
            b = ran.nextInt(256);
            background.setBackgroundColor(Color.rgb(r,g,b));
        }
        else {
            T_on.setVisibility(View.GONE);
            T_off.setVisibility(View.GONE);
            T_random.setVisibility(View.VISIBLE);
            T_random.setText("關");
            T_random.setTextColor(Color.rgb(255,255,255));
            background.setBackgroundColor(Color.rgb(0,0,0));
        }

        return true;
    }
}