package tw.cgu.b0921251.a72_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void quit(View v){
        System.exit(0);
    }

    public void goToSchool(View v){
        setContentView(R.layout.activity_school_lobby);
    }


    public void schoolIntro(View v){
        setContentView(R.layout.activity_school_intro);
    }


    public void eeIntro(View v){
        setContentView(R.layout.activity_ee_intro);
    }


    public void back(View v){
        setContentView(R.layout.activity_school_lobby);
    }

    public void toMain(View v){
        setContentView(R.layout.activity_main);
    }


}