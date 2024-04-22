package tw.cgu.b0921251.a8_3_intenttransmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements View.OnLongClickListener , View.OnClickListener {

    String data[] = {"Press to add", "Long Press to delete", "" ,"" ,"" ,""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1, t2,t3,t4,t5,t6;
        t1 = findViewById(R.id.L_1);
        t2 = findViewById(R.id.L_2);
        t3 = findViewById(R.id.L_3);
        t4 = findViewById(R.id.L_4);
        t5 = findViewById(R.id.L_5);
        t6 = findViewById(R.id.L_6);

        t1.setOnLongClickListener(this);
        t1.setOnClickListener(this);
        t2.setOnLongClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnLongClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnLongClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnLongClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnLongClickListener(this);
        t6.setOnClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {



        return true;
    }

    @Override
    public void onClick(View view) {
        int pos = -1;
        switch(view.getId()){
            case R.id.L_1:
                pos = 0;
                break;
            case R.id.L_2:
                pos = 1;
                break;
            case R.id.L_3:
                pos = 2;
                break;
            case R.id.L_4:
                pos = 3;
                break;
            case R.id.L_5:
                pos = 4;
                break;
            case R.id.L_6:
                pos = 5;
                break;
        }
        if (pos == -1)
            return;
        Intent it = new Intent(this, secondPage.class);
        it.putExtra("no", pos);
        it.putExtra("data", data[pos]);
        startActivity(it);
    }
}