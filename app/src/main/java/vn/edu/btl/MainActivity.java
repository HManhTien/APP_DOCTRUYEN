package vn.edu.btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import vn.edu.btl.adapter.adaptertruyen;
import vn.edu.btl.model.Truyen;
import vn.edu.btl.database.database;



public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView , listviewnew , listviewthongtin;
    DrawerLayout drawerLayout;
    String email , taikhoan;

    ArrayList<Truyen> TruyenArrylist;
    adaptertruyen adaptertruyen;

    database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new database(this);
        // nhận dữ lieu ở màn đăng nhập gửi
        Intent intentpq =getIntent();
        int i =  intentpq.getIntExtra("phanq" , 0);
        int idd = intentpq.getIntExtra("idd" ,0);
        email = intentpq.getStringExtra("email");
        taikhoan = intentpq.getStringExtra("tentaikhoan");

        anhxa();
        actionviewfliper();
        actionbar();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent  intent1 = new Intent(MainActivity.this , mannoidung.class);

                String tent = TruyenArrylist.get(position).getTentruyen();
                String noidungt = TruyenArrylist.get(position).getNoidung();
                intent1.putExtra("tentruyen" ,tent);
                intent1.putExtra("noidung" , noidungt);
                startActivity(intent1);
            }
        });
    }

    private void actionbar() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    public void actionviewfliper(){
        ArrayList<String> mangquangcao = new ArrayList<>();

        //Thêm ảnh vào mảng quảng cáo
        mangquangcao.add("https://s3.cloud.cmctelecom.vn/tinhte1/2014/03/2432999_tinhte.vn-up-facebook-500.jpg");
        mangquangcao.add("https://upload.wikimedia.org/wikipedia/commons/e/ea/Moldova_Competitiveness_Project%2C_USAID_Moldova_%2848121769796%29.jpg");

        for(int i = 0 ; i < mangquangcao.size() ; i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);

        viewFlipper.setAutoStart(true);

        Animation animation_slile_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.side_in_right);
        Animation animation_slile_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.side_out_right);

        viewFlipper.setInAnimation(animation_slile_in);
        viewFlipper.setInAnimation(animation_slile_out);
    }

    public void anhxa(){
      toolbar = findViewById(R.id.toolbarmanhinhchinh);
      viewFlipper = findViewById(R.id.ViewFlipper);
      listviewnew = findViewById(R.id.listviewnew);
      listView =   findViewById(R.id.listview);
      listviewthongtin = findViewById(R.id.listviewthongtin);
      navigationView = findViewById(R.id.NavigationView);
      drawerLayout = findViewById(R.id.drawer_layout);

      TruyenArrylist = new ArrayList<>();
        Cursor cursor1 = database.getData1();

        while (cursor1.moveToNext()){
            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);
            TruyenArrylist.add(new Truyen(id,tentruyen,noidung,anh,id_tk));

            adaptertruyen = new adaptertruyen(getApplicationContext(),TruyenArrylist);
            listView .setAdapter(adaptertruyen);

        }
        cursor1.moveToFirst();
        cursor1.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.mymenu,menu);
       return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            Intent  intent = new Intent(MainActivity.this , Mantimkiem.class);
            startActivity(intent);
        } else {

        }

        return super.onOptionsItemSelected(item);
    }
}