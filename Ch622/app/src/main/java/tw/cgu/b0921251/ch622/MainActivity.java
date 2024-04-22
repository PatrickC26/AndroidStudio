package tw.cgu.b0921251.ch622;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements  AdapterView.OnItemSelectedListener {
    TextView txv;
    Spinner cinema, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView) findViewById(R.id.txv);
        cinema = (Spinner) findViewById(R.id.cinema);
        time = (Spinner) findViewById(R.id.time);

        cinema.setOnItemSelectedListener(this);
    }

    public void order(View v){
        String cinemaS = cinema.getSelectedItem().toString();
        String timeS = time.getSelectedItem().toString();
        txv.setText("你住在" + cinemaS + "的" + timeS);
    }


    String a0S[] = {"宜蘭","基隆","台北","桃園","新竹","苗栗"};
    String a1S[] = {"彰化","台中","南投"};
    String a2S[] = {"雲林","嘉義","台南","高雄","屏東"};
    String a3S[] = {"花蓮","台東"};

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (cinema.getSelectedItemPosition()){
            case 0:
                ArrayAdapter<String> a0 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,a0S);
                a0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                time.setAdapter(a0);
                break;
            case 1:
                ArrayAdapter<String> a1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,a1S);
                a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                time.setAdapter(a1);
                break;
            case 2:
                ArrayAdapter<String> a2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,a2S);
                a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                time.setAdapter(a2);
                break;

            case 3:
                ArrayAdapter<String> a3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,a3S);
                a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                time.setAdapter(a3);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}