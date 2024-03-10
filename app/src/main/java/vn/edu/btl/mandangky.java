package vn.edu.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.btl.model.taikhoan;
import vn.edu.btl.database.database;
public class mandangky extends AppCompatActivity {

    EditText txtTaiKhoan , txtMatKhau , txtEmail;
    Button     btnLogin , btnregister;

    database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandangky);

        database = new database(this);
        Anhxa();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ntaikhoan = txtTaiKhoan.getText().toString();
                String nmatkhau = txtMatKhau.getText().toString();
                String nemail = txtEmail.getText().toString();

                taikhoan taikhoan1 = CreateTK();
                if(ntaikhoan.equals("") || nmatkhau.equals("") || nemail.equals(""))
                {
                    Log.e("Thông báo: " , "chưa nhập đầy đủ thông tin");
                }else {
                    database.addtaikhoan(taikhoan1);
                    Toast.makeText(mandangky.this, "Đăng kí thành công ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private taikhoan CreateTK(){
        String ntaikhoan = txtTaiKhoan.getText().toString();
        String nmatkhau = txtMatKhau.getText().toString();
        String nemail = txtEmail.getText().toString();
        int phanquyen = 1;
        taikhoan tk = new taikhoan(ntaikhoan,nmatkhau,nemail,phanquyen);
        return  tk;
    }
    public void Anhxa(){
        txtTaiKhoan = findViewById(R.id.ntxt_taikhoan);
        txtMatKhau = findViewById(R.id.ntxt_matkhau);
        txtEmail = findViewById(R.id.ntxt_email);
        btnLogin = findViewById(R.id.btn_nlogin);
        btnregister = findViewById(R.id.btn_nregister);
    }
}