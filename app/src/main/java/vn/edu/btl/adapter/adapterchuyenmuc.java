package vn.edu.btl.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.edu.btl.R;
import vn.edu.btl.model.chuyenmuc;


public class adapterchuyenmuc extends BaseAdapter {

    private Context context;
    private int layout;
    private List<chuyenmuc> chuyenmuclist;

    public adapterchuyenmuc(Context context, int layout, List<chuyenmuc> chuyenmuclist) {
        this.context = context;
        this.layout = layout;
        this.chuyenmuclist = chuyenmuclist;
    }

    @Override
    public int getCount() {
        return chuyenmuclist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        ImageView  img = (ImageView) convertView.findViewById(R.id.imgchuyenmuc);
        TextView txt = (TextView)  convertView.findViewById(R.id.txtviewchuyenmuc);

        chuyenmuc cm = chuyenmuclist.get(position);
        txt.setText(cm.getTenchuyenmuc());

        Picasso.get().load(cm.getHinhanhchuyenmuc()).placeholder(R.drawable.ic_load).error(R.drawable.ic_img).into(img);

        return convertView;
    }
}
