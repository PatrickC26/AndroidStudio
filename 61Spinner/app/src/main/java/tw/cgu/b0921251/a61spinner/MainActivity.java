package tw.cgu.b0921251.a61spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txv;
    Spinner cinema, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView) findViewById(R.id.txv);
        cinema = (Spinner) findViewById(R.id.cinema);
        time = (Spinner) findViewById(R.id.time);

    }

    public void order(View v){
        String cinemaS = cinema.getSelectedItem().toString();
        String timeS = time.getSelectedItem().toString();
        txv.setText("訂" + cinemaS + timeS + "的票");
    }


}