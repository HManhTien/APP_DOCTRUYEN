package vn.edu.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class mannoidung extends AppCompatActivity {

    TextView  txt_nd_tentruyen  , txt_nd_noidung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mannoidung);
        txt_nd_tentruyen = findViewById(R.id.txt_tentruyen_noidung);
        txt_nd_noidung = findViewById(R.id.txt_noidung_noidung);

        Intent intent = getIntent();
        String nd_tentruyen = intent.getStringExtra("tentruyen");
        String nd_noidung = intent.getStringExtra("noidung");

        txt_nd_tentruyen.setText(nd_tentruyen);
        txt_nd_noidung.setText(nd_noidung);


        //cho phep cuon
        txt_nd_noidung.setMovementMethod(new ScrollingMovementMethod());
    }
}