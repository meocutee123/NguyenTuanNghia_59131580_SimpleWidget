package com.gmail.nguyentuannghia_59131580_simplewidget;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText edtName, edtDOB, others;
    RadioGroup rdg;
    RadioButton rdbMale, rdbFemale;
    CheckBox wMovie, lMusic, cafeWF, sHome, cooking;
    Button btn;
    String Notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }

    private void addView(){
        edtName = findViewById(R.id.edtName);
        edtDOB = findViewById(R.id.edtDOB);
        rdg = findViewById(R.id.rdg);
        wMovie = findViewById(R.id.wMovie);
        lMusic = findViewById(R.id.lMusic);
        cafeWF = findViewById(R.id.cafeWF);
        sHome = findViewById(R.id.sHome);
        cooking = findViewById(R.id.cooking);
        others = findViewById(R.id.others);
        btn = findViewById(R.id.btn);
    }

    private void addEvent(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
    }

    private void confirm(){
        Notification = edtName.getText().toString() + "\n" +
                "Ngày sinh: " + edtDOB.getText().toString() + "\n" +
                "Giới tính: ";
        if (rdg.getCheckedRadioButtonId() == R.id.rdbMale)
            Notification += "Nam" + "\n" + "Sở thích: ";
        else
            Notification += "Nữ" + "\n" + "Sở thích: ";

        if (wMovie.isChecked())
            Notification += "Xem phim; ";
        if (lMusic.isChecked())
            Notification += "Nghe nhạc; ";
        if (cafeWF.isChecked())
            Notification += "Đi cà phê với bạn; ";
        if (sHome.isChecked())
            Notification += "Ở nhà một mình; ";
        if (cooking.isChecked())
            Notification += "Vào bếp nấu ăn; ";

        Notification += others.getText().toString();
        Toast.makeText(getApplicationContext(), Notification, Toast.LENGTH_SHORT).show();
    }
}
