package com.example.afinal;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.afinal.R;

public class tambah_user extends Activity {

    EditText un,pw,rpw,nl,al,nt,nh;
    RadioGroup jk;
    TextView error;
    Button simpan,keluar;


    /** Called when the activity is first created. */

    @Override


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_user);

        un=(EditText)findViewById(R.id.et_un);
        pw=(EditText)findViewById(R.id.et_pw);
        rpw=(EditText)findViewById(R.id.et_rpw);
        nl=(EditText) findViewById(R.id.et_nama);
        jk=(RadioGroup) findViewById(R.id.jekel);
        al=(EditText) findViewById(R.id.et_alamat);
        nt=(EditText) findViewById(R.id.et_notel);
        nh=(EditText) findViewById(R.id.et_nohp);


        simpan=(Button)findViewById(R.id.btn_simpan);
        keluar=(Button)findViewById(R.id.btn_keluar);
        error=(TextView)findViewById(R.id.error);
        simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //atur variabel utk menampung pilihan jenis kelamin
                String type=null;
                switch (jk.getCheckedRadioButtonId()) {
                    case R.id.pria:
                        type="Pria";
                        break;
                    case R.id.perempuan:
                        type="Perempuan";
                        break;
                }

                ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
                postParameters.add(new BasicNameValuePair("username", un.getText().toString()));
                postParameters.add(new BasicNameValuePair("password", pw.getText().toString()));
                postParameters.add(new BasicNameValuePair("repassword", rpw.getText().toString()));
                postParameters.add(new BasicNameValuePair("nama", nl.getText().toString()));
                postParameters.add(new BasicNameValuePair("jekel", type));
                postParameters.add(new BasicNameValuePair("alamat", al.getText().toString()));
                postParameters.add(new BasicNameValuePair("nomor_tlp", nt.getText().toString()));
                postParameters.add(new BasicNameValuePair("nomor_hp", nh.getText().toString()));

                //String valid = "1";
                String response = null;
                try {
                    response = CustomHttpClient.executeHttpPost("http://10.0.2.2/hellomysql/simpan.php", postParameters);
                    String res = response.toString();
                    res = res.trim();
                    res = res.replaceAll("\\s+","");
                    error.setText(res);
                }
                catch (Exception e) {
                    un.setText(e.toString());
                }
            }
        });
    }
    public void keluar (View theButton)
    {
        Intent a = new Intent (this, login.class);
        startActivity(a);
    }
}