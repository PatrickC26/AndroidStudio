package tw.cgu.b0921251.a2021_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener{
    TextView txv1,txv2,txv3,txv4,txvQ;
    EditText edtDrop;
    Button btnDrop, btnStart;
    int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};
    int[] winning4ID = {0,0,0,0} ; //存入隨機方法抽出4個不重複並符合抽獎資格的值
    int[] tempwinning4ID = {0,0,0,0} ; //存入前次隨機方法抽出4個不重複並符合抽獎資格的值
    int tenID[] = {1,2,3,4,5,6,7,8,9,10};
    int display_all = 0;
    int display_onlyID = 1;
    int display_onlyName = 2;
    int displayMethod = display_onlyID; //「符合抽獎資格」的顯示狀態
    String [] tenName = {"Alice","Bob","Cindy","Danny","Elsa",
            "Frank","Gina","Howard","Iris","Jason"};
    String msg1 = "遊戲片:";
    String msg2 = "資料夾:";
    String msg3 = "顯示卡:";
    String msg4 = "馬克杯:";
    RadioGroup display;
    boolean [] isQualified={true,true,true,true,true,true,true,true,true,true};
    boolean [] isCanceled={false,false,false,false,false,false,false,false,false,false};
    boolean [] isWinning={false,false,false,false,false,false,false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv1 = (TextView) findViewById(R.id.txv1);
        txv2 = (TextView) findViewById(R.id.txv2);
        txv3 = (TextView) findViewById(R.id.txv3);
        txv4 = (TextView) findViewById(R.id.txv4);
        txvQ = (TextView) findViewById(R.id.txvQ);
        edtDrop=(EditText) findViewById(R.id.edtDrop);
        btnDrop = (Button) findViewById(R.id.btnDrop);
        btnStart = (Button) findViewById(R.id.btnStart);
        display = (RadioGroup)findViewById(R.id.display);
        btnDrop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        display.setOnCheckedChangeListener(this);
        for(int id:chk_id){
            CheckBox chk = (CheckBox) findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }
        for (int i = 0 ; i < 4 ; i++){
            winning4ID[i] = -1;
        }
        drawWinning4ID();
    }

    @Override
    public void onClick(View v) {
//        (20%)//程式碼(B)
        if (v.getId() == R.id.btnDrop){
            String dS = edtDrop.getText().toString();
            if (!dS.isEmpty()) {
                int dSI = Integer.parseInt(dS);
                if (dSI > 0 && dSI <= 10) {
                    isCanceled[dSI - 1] = true;
                }
                else{
                    txvQ.setText("請重新輸入放棄抽獎資格ＩＤ");
                }
                showQualification();
            }
            else{
                txvQ.setText("請重新輸入放棄抽獎資格ＩＤ");
            }
        }else if (v.getId() == R.id.btnStart){
            drawWinning4ID();
            String pre[] = {msg1, msg2, msg3, msg4};
            int txv[] = { R.id.txv1,R.id.txv2,R.id.txv3,R.id.txv4};
            for (int i = 0 ; i < 4 ; i++){
                String msg = "";
                if (winning4ID[i] != -1)
                    msg = pre[i] + tenID[winning4ID[i]] + "號" + tenName[winning4ID[i]];
                else
                    msg = pre[i];

                TextView chk = (TextView) findViewById(txv[i]);
                chk.setText(msg);
            }

        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        (30%) //程式碼(C)
        for(int i = 0 ; i < 4 ; i++){
            CheckBox chk = (CheckBox) findViewById(chk_id[i]);
            if (chk.isChecked())
                winning4ID[i] = 9;
            else
                winning4ID[i] = -1;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        changeDisplayMethod();
    }

    protected void changeDisplayMethod(){
//        (20%)//程式碼(D)寫一個隨著RadioButton變換符合抽獎資格顯示格式方法
        RadioButton tempRB = findViewById(R.id.showID);
        if (tempRB.isChecked())
            displayMethod = display_onlyID;

        tempRB = findViewById(R.id.showAll);
        if (tempRB.isChecked())
            displayMethod = display_all;

        tempRB = findViewById(R.id.showName);
        if (tempRB.isChecked())
            displayMethod = display_onlyName;

        String outS = "";
        for (int i = 0 ; i < 10 ; i++){
            if (isQualified[i]){
                if (displayMethod == display_onlyID)
                    outS += String.valueOf(tenID[i]);
                else if (displayMethod == display_onlyName)
                    outS += tenName[i];
                else if (displayMethod == display_all)
                    outS = outS + String.valueOf(tenID[i]) + "號" + tenName[i];

                outS += ",";
            }
        }
        outS = outS.substring(0,outS.length()-1);
        txvQ.setText("符合抽獎資格\n" + outS);
    }


    public void drawWinning4ID(){
//        (10%)//程式碼(E)寫一個隨機方法抽出4個不重複並符合抽獎資格的值存入winning4ID


        Random r = new Random();
        for (int i = 0 ; i < 4 ; i++){
            if (winning4ID[i] != -1) {
                int getI = -1;
                while (true) {
                    getI = r.nextInt(10);
                    if (isQualified[getI] && !isWinning[getI])
                        break;
                }
                winning4ID[i] = getI;
                isWinning[getI] = true;
            }
        }

        for (int i = 0 ; i < 10 ; i++){
            isWinning[i] = false;
        }
        tempwinning4ID = winning4ID;
    }

    protected void showQualification(){
//        (10%)//程式碼(F)寫一個逐一檢查是否有抽獎資格並顯示的方法
        for (int i = 0 ; i < 10 ; i++){
            isQualified[i] = !isCanceled[i];
        }
        changeDisplayMethod();
    }

}