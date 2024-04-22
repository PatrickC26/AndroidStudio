package tw.cgu.b0921251_mcs.sql_5g;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDownloadService();
                System.out.println("Downloading...");
            }
        });




//        startDownloadService();
    }


    private void startDownloadService() {
        Intent serviceIntent = new Intent(this, DownloadService.class);
        serviceIntent.setAction(DownloadService.ACTION_START);

        serviceIntent.putExtra("", "");

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(serviceIntent);
//            System.out.println("HERE");
//        } else {
//            startService(serviceIntent);
//            System.out.println("THERE");
//        }
    }
}
