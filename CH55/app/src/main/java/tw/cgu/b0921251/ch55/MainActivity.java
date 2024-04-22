package tw.cgu.b0921251.ch55;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
//implements CompoundButton.OnCheckedChangeListener{

    Boolean data[] = {false, false, false, false, false, false, false, false};
    int ids[] = {R.id.CB_1, R.id.CB_2, R.id.CB_3, R.id.CB_4, R.id.CB_5, R.id.CB_6, R.id.CB_7, R.id.CB_8};
    String names[] = {"漢堡","可樂","雞塊","咖啡","薯條","玉米濃湯","沙拉","蘋果派"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            for (int i = 0; i < 8; i++) {
                CheckBox temp = (CheckBox) findViewById(ids[i]);
                temp.setText(names[i]);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void buttonClick(View v){
        TextView t = findViewById(R.id.T_text);
        String outS = "您點的餐點是：" ;
        for (int i = 0 ; i < 8 ; i ++){
            if (data[i]){
                outS += names[i];
                outS += "\n";
            }
        }
        t.setText(outS);
    }

    public void onChecked(View v) {
        for (int i = 0 ; i < 8 ; i++){
            if (v.getId() == ids[i]){
                CheckBox temp = (CheckBox) findViewById(v.getId());
                if (temp.isChecked()){
                    data[i] = true;
                }
                else{
                    data[i] = false;
                }
            }
        }
    }
}