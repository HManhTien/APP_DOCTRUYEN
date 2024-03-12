package vn.edu.btl.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.btl.R;
import vn.edu.btl.model.Truyen;

public class adaptertruyen extends BaseAdapter{

   private Context context;
   private ArrayList<Truyen> listtruyen;

   public adaptertruyen(Context context , ArrayList<Truyen> listtruyen){
       this.context = context;
       this.listtruyen = listtruyen;
   }
    @Override
    public int getCount() {
        return listtruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return listtruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Viewhoder{
       TextView txtTentruyen;
       ImageView imgtruyen;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Viewhoder viewhoder = null;
       viewhoder = new Viewhoder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.newtruyen,null);

        viewhoder.txtTentruyen = convertView.findViewById(R.id.txtviewtentruyenmoi);
        viewhoder.imgtruyen = convertView.findViewById(R.id.imgviewtruyen);
        convertView.setTag(viewhoder);

        Truyen truyen = (Truyen) getItem(position);
        viewhoder.txtTentruyen.setText(truyen.getTentruyen());

        Picasso.get().load(truyen.getAnh()).placeholder(R.drawable.ic_load).error(R.drawable.ic_img);
        return convertView;
    }
}
