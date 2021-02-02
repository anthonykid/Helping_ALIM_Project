package com.example.afinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.afinal.R;
import com.example.afinal.menu_utama;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class login extends Activity {

    EditText un,pw;
    TextView error;
    Button simpan;
    Button cancel;
    Button daftar;
    String i;


    /** Called when the activity is first created. */

    @Override


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un=(EditText)findViewById(R.id.et_un);
        pw=(EditText)findViewById(R.id.et_pw);
        simpan=(Button)findViewById(R.id.btn_login);
        error=(TextView)findViewById(R.id.tv_error);
        simpan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            // TODO Auto-generated method stub
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("username", un.getText().toString()));
            postParameters.add(new BasicNameValuePair("password", pw.getText().toString()));

            //String valid = "1";


            String response = null;
            try {
                if (un.getText().toString().equals("dicky") && pw.getText().toString().equals("123"))
                {
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    berhasil_login(view);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sorry!! username or password wrong",Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e) {
                un.setText(e.toString());
            }
    }
    });
    }
    public void tambah_user (View theButton)
    {
        Intent i = new Intent(this, tambah_user.class);
        startActivity(i);
    }

    public void berhasil_login (View theButton)
    {
        Intent s = new Intent (this, menu_utama.class);
        startActivity(s);
    }
}
