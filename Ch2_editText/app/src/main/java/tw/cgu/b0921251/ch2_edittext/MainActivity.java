package tw.cgu.b0921251.ch2_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    public void onedit(View v){
        TextView t = (TextView) findViewById(R.id.T_text);
        TextView l = (TextView) findViewById(R.id.L_name);

        t.setText(l.getText().toString() + " Hello !");

        if (l.getText().toString().equals("")){
            t.setText("請輸入名字");
        }
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