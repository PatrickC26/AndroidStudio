package tw.cgu.b0921251.listener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
    implements  View.OnClickListener, View.OnLongClickListener{


    TextView num ;
    Button add ;
    int numi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (TextView) findViewById(R.id.L_num);
        add = (Button) findViewById(R.id.B_add);
        add.setOnClickListener(this);
        add.setOnLongClickListener(this);
        num.setOnLongClickListener(this);
        num.setText("0");
    }

    @Override
    public void onClick(View v){
        num.setText(String.valueOf(++numi));
        System.out.println("ADDING");

    }


    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.B_add) {
            numi++;
            numi++;
            num.setText(String.valueOf(numi));
//            System.out.println("ADDING");
        }
        else{
            num.setText("0");
            numi = 0;
        }
        return true;
    }
}