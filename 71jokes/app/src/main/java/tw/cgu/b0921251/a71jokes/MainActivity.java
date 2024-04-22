package tw.cgu.b0921251.a71jokes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemClickListener {

    String qArray[] = {"誰是萬獸之王？" ,
            "什麼人死後還會出現？" ,
            "什麼帽不能戴？" ,
            "什麼桶子裝不滿？" ,
            "什麼車最長？" ,
            "什麼地方自討苦吃？" ,
            "什麼人最不聽話？" ,
            "什麼牛不會吃草？" ,
            "什麼地方看的月亮最大？" ,
            "什麼東西比細菌還小？"};
    String ansArray[] = {"動物園園長" ,
            "電影中的人" ,
            "螺帽" ,
            "馬桶" ,
            "塞車" ,
            "藥店" ,
            "聾子" ,
            "蝸牛" ,
            "月球上" ,
            "細菌的兒子"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, qArray);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);


    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"答案：" + ansArray[i],Toast.LENGTH_SHORT).show();
    }
}