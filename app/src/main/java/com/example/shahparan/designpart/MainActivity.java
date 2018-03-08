package com.example.shahparan.designpart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,phone,email,cgpa;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        cgpa = findViewById(R.id.cgpa);
        show = findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
            }
        });


    }

    private void checkValidation() {

        String nameTemp;
        String phoneTemp;
        String emailTemp;
        String cgpaTemp;

        nameTemp = name.getText().toString();
        phoneTemp = phone.getText().toString();
        emailTemp = email.getText().toString();
        cgpaTemp = cgpa.getText().toString();

        Boolean flag=false;


        if(nameTemp.isEmpty()){
            name.setError("Name Field is Empty");
            flag = true;
        }

        if(phoneTemp.isEmpty()){
            phone.setError("Phone Number Field is Empty");
            flag = true;
        }else {
            if (phoneTemp.length() < 10)
            {
                phone.setError("Number is too Short..");
                flag = true;
            }else{
                if(phoneTemp.startsWith("017") || phoneTemp.startsWith("015") ||phoneTemp.startsWith("019")){

                }else{
                    phone.setError("Phone is not Excepted");
                    flag = true;
                }
            }

        }

        if(cgpaTemp.isEmpty()){
            cgpa.setError("CGPA Field is Empty");
            flag = true;
        }else {
            if(cgpaTemp.length()==4){
                Float cgpaFloat = Float.valueOf(cgpaTemp);
                if((cgpaFloat > 4.0) || (cgpaFloat < 2.0)){
                    cgpa.setError("CGPA is not Valid");
                    flag = true;
                }
            }else{
                cgpa.setError("CGPA is not Valid");
                flag = true;
            }

        }

        if (flag == false){
            Toast.makeText(MainActivity.this,nameTemp+"\n"+phoneTemp+"\n"+emailTemp+"\n"+cgpaTemp, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something wrong..", Toast.LENGTH_LONG).show();
        }

        name.setText("");
        phone.setText("");
        email.setText("");
        cgpa.setText("");

    }

}
