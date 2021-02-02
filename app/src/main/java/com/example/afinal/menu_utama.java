package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class menu_utama extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama);
    }
    public void onBtnClick (View view) {
        TextView txtHello = findViewById(R.id.txtMessageName);
        EditText edtTxtName = findViewById(R.id.edtTxtName);
        txtHello.setText("Your Name Is : " + edtTxtName.getText().toString());

        TextView txtHello1 = findViewById(R.id.txtMessageEmail);
        EditText edtTxtEmail = findViewById(R.id.edtTxtEmail);
        txtHello1.setText("Your Email Is : " + edtTxtEmail.getText().toString());

        TextView txtHello2 = findViewById(R.id.txtMessageAge);
        EditText edtTxtAge = findViewById(R.id.edtTxtAge);
        txtHello2.setText("Your Age Is :  " + edtTxtAge.getText().toString() + " !!!");
    }
}
