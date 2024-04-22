package tw.cgu.b0921251.a8_4intentsendingback;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String date[] = new String[100];
    String fee[] = new String[100];
    int current = 0;

    TextView L_date, L_fee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        L_date = findViewById(R.id.L_dates);
        L_fee=findViewById(R.id.L_moneys);
    }

    public void newData(View v){
        Intent it = new Intent(this, editing.class);
        startActivityForResult(it, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent it) {
        super.onActivityResult(requestCode, resultCode, it);

        if (resultCode == RESULT_OK) {

            System.out.println(current);
            System.out.println(fee[current]);
            String temp = it.getStringExtra("fee");
            date[current] = temp.split("`")[0];
            fee[current] = temp.split("`")[1];

            String show_date = "", show_fee = "";

            for (int i = 0; i <= current; i++) {
                System.out.println(i);
                System.out.println(fee[i]);
                show_date += date[i];
                show_date += "\n";
                show_fee += fee[i];
                show_fee += "\n";
            }

            L_date.setText(show_date);
            L_fee.setText(show_fee);

            Toast.makeText(this,"共花費"+fee[current]+"元",Toast.LENGTH_SHORT).show();

            current++;
        }
        else
            Toast.makeText(this,"取消輸入",Toast.LENGTH_SHORT).show();
    }



    public void cleanALL(View v){
        date = new String[100];
        fee = new String[100];

        L_date.setText("");
        L_fee.setText("");

        current = 0;
    }



}