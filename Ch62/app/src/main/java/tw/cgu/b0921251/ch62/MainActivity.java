package tw.cgu.b0921251.ch62;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    ArrayList<String> select = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.LV_chose);
        lv.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView txv = (TextView) view;
        //***********
        String item = txv.getText().toString();
        if(select.contains(item)){
            select.remove(item);
        }else{
            select.add(item);
        }

        String msg;
        if(select.size()>0){
            msg = "你夾了:";
            for(String str:select){
                msg=msg +" " +str;
            }
        }else{
            msg = "請選擇!";
        }

        TextView msgtxv = (TextView) findViewById(R.id.L_show);
        msgtxv.setText(msg);

    }
}