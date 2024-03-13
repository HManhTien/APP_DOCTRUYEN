package vn.edu.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Manthongtin extends AppCompatActivity {

    TextView txt_tt_noidung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manthongtin);

        txt_tt_noidung = findViewById(R.id.txt_tt_noidung);
        String noidung=" Code By Hoàng Mạnh Tiến MaxDz";

        txt_tt_noidung.setText(noidung);
    }
}