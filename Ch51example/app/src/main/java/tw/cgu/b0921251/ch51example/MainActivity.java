package tw.cgu.b0921251.ch51example;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements CompoundButton.OnCheckedChangeListener{

    CheckBox CB_hamburger, CB_frenchfried, CB_cola, CB_soup;

    Boolean b_hamburger, b_frenchfried, b_cola, b_soup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CB_hamburger = (CheckBox) findViewById(R.id.CB_hamburger);
        CB_frenchfried = (CheckBox) findViewById(R.id.CB_frenchfried);
        CB_cola = (CheckBox) findViewById(R.id.CB_cola);
        CB_soup = (CheckBox)findViewById(R.id.CB_soup);

        CB_hamburger.setOnCheckedChangeListener(this);
        CB_frenchfried.setOnCheckedChangeListener(this);
        CB_soup.setOnCheckedChangeListener(this);
        CB_cola.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        View ham, fried, cola, soup;
        ham = findViewById(R.id.I_hamburger);
        fried = findViewById(R.id.I_french);
        cola = findViewById(R.id.I_cola);
        soup = findViewById(R.id.I_soup);
        if (b){
            switch (compoundButton.getId()){
                case R.id.CB_hamburger:
                    ham.setVisibility(View.VISIBLE);
                    b_hamburger = true;
                    break;
                case R.id.CB_cola:
                    cola.setVisibility(View.VISIBLE);
                    b_cola = true;
                    break;
                case R.id.CB_frenchfried:
                    fried.setVisibility(View.VISIBLE);
                     b_frenchfried= true;
                    break;
                case R.id.CB_soup:
                    soup.setVisibility(View.VISIBLE);
                     b_soup = true;
                    break;
            }

        }else{
            switch (compoundButton.getId()) {
                case R.id.CB_hamburger:
                    ham.setVisibility(View.INVISIBLE);
                    b_hamburger = false;
                    break;
                case R.id.CB_cola:
                    cola.setVisibility(View.INVISIBLE);
                    b_cola = false;
                    break;
                case R.id.CB_frenchfried:
                    fried.setVisibility(View.INVISIBLE);
                    b_frenchfried = false;
                    break;
                case R.id.CB_soup:
                    soup.setVisibility(View.INVISIBLE);
                    b_soup = false;
                    break;
            }
        }

        if (b_hamburger || b_frenchfried || b_cola || b_soup){
            TextView alert = findViewById(R.id.T_alert);
            alert.setText("你點的餐點如下");
        }
        else{
            TextView alert = findViewById(R.id.T_alert);
            alert.setText("請點餐");
        }
    }

    public void press(View v){
        TextView alert = findViewById(R.id.T_alert);
        String out = "你點的餐點如下\n";
        if (b_hamburger){
            out += "漢堡 ";
        }
        if (b_frenchfried){
            out += "薯條 ";
        }
        if (b_cola){
            out += "可樂 ";
        }
        if (b_soup){
            out += "預擬濃湯";
        }
        alert.setText(out);
    }

}