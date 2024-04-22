package tw.cgu.b0921251_mcs.ew_sql_30;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_SQL();

//                MyDBHelper dbHelper = new MyDBHelper(this);
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
            }
        });

        Intent addNew_I = new Intent(this, addNew.class);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addNew_I);
            }
        });

        Intent seeSQL_I = new Intent(this, seeInfo.class);
        findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(seeSQL_I);
            }
        });
    }


    public void check_SQL() {
        MyDBHelper dbHelper = new MyDBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        TextView output = (TextView)findViewById(R.id.output);

        output.setText("資料庫是否開啟: " + db.isOpen() + "\n資料庫版本: " + db.getVersion());


    }

}