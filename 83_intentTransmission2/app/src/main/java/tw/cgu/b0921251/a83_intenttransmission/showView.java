package tw.cgu.b0921251.a83_intenttransmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class showView extends AppCompatActivity {

    TextView info,info2,info3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_view);

        info = findViewById(R.id.L_info);
        info2 = findViewById(R.id.l_info);
        info3 = findViewById(R.id.l_info2);
        Intent it = getIntent();
        int gender = it.getIntExtra("gender", -1);
        double height = it.getDoubleExtra("height", -1);

        String infoS = "您是一位";
        double suggest = 0;
        if (gender == -1 || height == -1)
            ;
        else if (gender == 1) {
            infoS += "女";
            suggest = (height-70.0)*0.6;
        }
        else {
            infoS += "男";
            suggest = (height-80.0)*0.7;
        }

        infoS =  infoS + "生" ;
        info.setText(infoS);
        System.out.println(infoS);

        infoS= "您的身高是" + String.valueOf(height) + "cm";
        info2.setText(infoS);
        System.out.println(infoS);
        infoS = "您的標準體重是" + String.format("%.1f",suggest) + "kg";
        info3.setText(infoS);
        System.out.println(infoS);
    }

    public void finish (View view){
        finish();
    }
}