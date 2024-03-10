package vn.edu.btl;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.btl.database.database;

public class mandangnhap extends AppCompatActivity {

    EditText   txtTaiKhoan , txtMatKhau;
    Button     btnLogin , btnregister;
    vn.edu.btl.database.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandangnhap);
        anhxa();

        database = new database(this);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mandangnhap.this,mandangky.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentaikhoan = txtTaiKhoan.getText().toString();
                String matkhau = txtMatKhau.getText().toString();

                Cursor cursor = database.getdata();
                while(cursor.moveToNext()){
                    String datatentaikoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);
                    if(datatentaikoan.equals(tentaikhoan) && datamatkhau.equals(matkhau)){
                        int phanquyen = cursor.getInt(4);
                        int idd = cursor.getInt(0);
                        String email = cursor.getString(3);

                        Intent intent  = new Intent(mandangnhap.this , MainActivity.class);
                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("id" , idd);
                        intent.putExtra("email" ,email);
                        intent.putExtra("tentaikoan" , tentaikhoan);

                        startActivity(intent);
                    }
                }
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }



    public void anhxa(){
        txtTaiKhoan = findViewById(R.id.txt_taikhoan);
        txtMatKhau = findViewById(R.id.txt_matkhau);
        btnLogin = findViewById(R.id.btn_login);
        btnregister = findViewById(R.id.btn_register);

    }
}