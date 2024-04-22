package tw.cgu.B0921251.Ch2_Buton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int ts = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView a = (TextView) findViewById(R.id.T_text);
        a.setTextSize(ts);
        a.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }


    public void bigger(View v){
        TextView a = (TextView) findViewById(R.id.T_text);
        a.setTextSize(++ts);
    }

    public void smaller(View v){
        TextView a = (TextView) findViewById(R.id.T_text);
        ts--;
        if (ts < 15){
            ts = 15;
        }
        a.setTextSize(ts);
    }

}