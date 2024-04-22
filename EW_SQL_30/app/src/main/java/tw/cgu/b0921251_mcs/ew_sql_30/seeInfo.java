package tw.cgu.b0921251_mcs.ew_sql_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class seeInfo extends AppCompatActivity {
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    private TextView L_id;
    private EditText T_title, T_price, T_orderPersoon;
    private CheckBox C_checkOut;

    private static final String DATABASE_TABLE = "books";
    String [][] stringA = new String[1][0];
    private int count = 0;
    private int max_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_info);

        L_id = findViewById(R.id.L_id);
        T_title = findViewById(R.id.T_bookName);
        T_price = findViewById(R.id.T_bookPrice);
        T_orderPersoon = findViewById(R.id.T_orderPerson);
        C_checkOut = findViewById(R.id.C_hasCheckout);

        renew();
        showInfo();



        findViewById(R.id.B_next).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                count ++;
                if (count > max_count) count = max_count;
                showInfo();
            }
        });

        findViewById(R.id.B_pre).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                count --;
                if (count < 0) count =0;
                showInfo();
            }
        });

        findViewById(R.id.B_update).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                updateValue();
            }
        });

        findViewById(R.id.B_delete).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                delete();
                count --;
                if (count < 0) count =0;
                showInfo();
            }
        });












//        if (id == R.id.action_update) {  // 更新
//            String title = txtTitle.getText().toString();
//            ContentValues cv = new ContentValues();
//            double price = Double.parseDouble(txtNewPrice.getText().toString());
//            cv.put("price", price);
//            int count = db.update(DATABASE_TABLE, cv, "title='" + title + "'", null);
//            output.setText("更新記錄成功: " + count);
//            return true;
//        }
//        if (id == R.id.action_delete) {  // 刪除
//            String title = txtTitle.getText().toString();
//            int count = db.delete(DATABASE_TABLE, "title='" + title + "'", null);
//            output.setText("刪除記錄成功: " + count);
//            return true;
//        }
//        if (id == R.id.action_queryAll) {  // 顯示全部記錄
//            String[] colNames = new String[]{"_id", "title", "price"};
//            String str = "";
//            Cursor c = db.query(DATABASE_TABLE, colNames, null, null, null, null, null);
//            // 顯示欄位名稱
//            for (int i = 0; i < colNames.length; i++)
//                str += colNames[i] + "\t\t";
//            str += "\n";
//            c.moveToFirst();  // 第1筆
//            // 顯示欄位值
//            for (int i = 0; i < c.getCount(); i++) {
//                str += c.getString(c.getColumnIndex(colNames[0])) + "\t\t";
//                str += c.getString(1) + "\t\t";
//                str += c.getString(2) + "\n";
//                c.moveToNext();  // 下一筆
//            }
//            output.setText(str.toString());
//
//            return true;
//        }
    }


    void delete(){
        int id = db.delete(DATABASE_TABLE, "_id='" + stringA[count][0] + "'", null);
        Toast mytoast = new Toast(this);
        mytoast.setText("刪除記錄成功: " + String.valueOf(id));
        mytoast.show();
        renew();
    }


    void updateValue(){
        ContentValues cv = new ContentValues();
        cv.put("title", T_title.getText().toString());
        cv.put("person", T_orderPersoon.getText().toString());

        double price = Double.parseDouble(T_price.getText().toString());
        cv.put("price", price);

        cv.put("checkOut", C_checkOut.isChecked() ? 1 : 0);
        

        int new_id = db.update(DATABASE_TABLE, cv, "_id='" + stringA[count][0] + "'", null);

        Toast mytoast = new Toast(this);
        mytoast.setText("更新記錄成功: " + String.valueOf(new_id));
        mytoast.show();

        renew();

        
    }


    void showInfo(){
        L_id.setText("ID: " + stringA[count][0]);
        T_title.setText(stringA[count][1]);
        T_price.setText(stringA[count][2]);
        T_orderPersoon.setText(stringA[count][3]);

        if (stringA[count][4].equals("1")) C_checkOut.setChecked(true);
        else C_checkOut.setChecked(false);
    }

    void renew(){
        dbHelper = new MyDBHelper(this);
        db = dbHelper.getWritableDatabase(); // 開啟資料庫


        String[] colNames = new String[]{"_id", "title", "price", "person", "checkOut"};
        String str = "";
        Cursor c = db.query(DATABASE_TABLE, colNames, null, null, null, null, null);
        c.moveToFirst();  // 第1筆
        // 顯示欄位名稱
        for (String colName : colNames) str += colName + "\t\t";
        str += "\n";

        max_count = c.getCount() -1;
        stringA = new String[c.getCount()][5];

        // 顯示欄位值
        for (int i = 0; i < c.getCount(); i++) {
            stringA[i][0] = c.getString(0);
            stringA[i][1] = c.getString(1);
            stringA[i][2] = c.getString(2);
            stringA[i][3] = c.getString(3);
            stringA[i][4] = c.getString(4);

            str += c.getString(0) + "\t\t";
            str += c.getString(1) + "\t\t\t";
            str += c.getString(2) + "\t\t\t";
            str += c.getString(3) + "\t\t\t";
            str += c.getString(4) + "\n";
            c.moveToNext();  // 下一筆
        }

        System.out.println(str);
    }
}