package tw.cgu.b0921251.a72_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class schoolIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_intro);
    }

    public void back(View v){
        setContentView(R.layout.activity_school_lobby);
    }

}