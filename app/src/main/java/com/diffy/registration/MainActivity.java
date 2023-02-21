package com.diffy.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText nm,em,ps;
    RadioGroup dep;
    RadioButton selectedDepBtn;
    CheckBox lang1,lang2,lang3;
    String varName,varEmail,varPass,selectedDep;
    int selectedRadioId = -1;
    StringBuilder data = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.sub);
        nm = (EditText) findViewById(R.id.name);
        em = (EditText) findViewById(R.id.email);
        ps = (EditText) findViewById(R.id.pass);
        dep = (RadioGroup) findViewById(R.id.dep);
        lang1 = (CheckBox) findViewById(R.id.mal);
        lang2 = (CheckBox) findViewById(R.id.eng);
        lang3 = (CheckBox) findViewById(R.id.hind);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                varName = nm.getText().toString();
                varEmail = em.getText().toString();
                varPass = ps.getText().toString();
                selectedRadioId = dep.getCheckedRadioButtonId();
                if (varName.isEmpty()) {
                    nm.setError("Enter name");
                }else if (varEmail.isEmpty()){
                    em.setError("Enter Email");
                }else if (varPass.isEmpty()){
                    ps.setError("Enter Password");
                }else if (selectedRadioId <= 0){
                    selectedDepBtn = (RadioButton) findViewById(R.id.radioButton5);
                    selectedDepBtn.setError("Select Department");
                }else if (!lang1.isChecked() && !lang2.isChecked() && !lang3.isChecked()) {
                    lang3.setError("Select at least 1 language");
                }else {
                    data.setLength(0);
                    selectedRadioId = dep.getCheckedRadioButtonId();
                    selectedDepBtn = (RadioButton) findViewById(selectedRadioId);
                    selectedDep = selectedDepBtn.getText().toString();
                    data.append(
                            "Name:"+varName+"\n"+
                            "Email:"+varEmail+"\n"+
                            "Department:"+selectedDep
                    );
                    Toast.makeText(MainActivity.this,"Registration Succesfull",Toast.LENGTH_LONG).show();

                    /*PopupWindow pop = new PopupWindow(
                            View data,
                            int hi21,
                            int wi21
                    );*/
                    Bundle loginDta = new Bundle();
                    loginDta.putString("data",String.valueOf(data));
                    Intent confirmScreen = new Intent(getApplicationContext(),popup.class);
                    confirmScreen.putExtra("loginDta",loginDta);
                    startActivity(confirmScreen);
                }
            }
        });
    }
}