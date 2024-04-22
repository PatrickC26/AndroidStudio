package tw.cgu.b0921251.ch55a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] id={R.id.checkBox,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4,R.id.checkBox5,R.id.checkBox6,R.id.checkBox7,R.id.checkBox8};

        for(int i:id) {

            CheckBox chk = (CheckBox) findViewById(i);
            chk.setOnCheckedChangeListener(this);
        }



    }

    public void takeorder(View v){

        String msg = "";
        int[] id={R.id.checkBox,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4,R.id.checkBox5,R.id.checkBox6,R.id.checkBox7,R.id.checkBox8};

        for(CompoundButton chk:select)
            msg+= "\n"+chk.getText();

        if(msg.length()>0)
            msg="你點購的餐點是:"+msg;
        else
            msg = "請點餐";

        ((TextView)findViewById(R.id.textView)).setText(msg);

    }
    ArrayList<CompoundButton> select = new ArrayList<>();
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChk) {
        if(isChk)
            select.add(buttonView);
        else
            select.remove(buttonView);
    }
}