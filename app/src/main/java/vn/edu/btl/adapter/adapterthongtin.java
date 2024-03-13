package vn.edu.btl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.btl.R;
import vn.edu.btl.model.taikhoan;

public class adapterthongtin extends BaseAdapter {

    private Context context;
    private int layout;
    private List<taikhoan> taikhoanList;

    public adapterthongtin(Context context, int layout, List<taikhoan> taikhoanList) {
        this.context = context;
        this.layout = layout;
        this.taikhoanList = taikhoanList;
    }

    @Override
    public int getCount() {
        return taikhoanList.size();
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

        TextView txttentaikhoan = (TextView) convertView.findViewById(R.id.txt_name);
        TextView txtemail = (TextView) convertView.findViewById(R.id.emailngdung);

        taikhoan taikhoan= taikhoanList.get(position);
        txttentaikhoan.setText(taikhoan.getmTaiKhoan());
        txtemail.setText(taikhoan.getmEmaill());
        return convertView;
    }
}
