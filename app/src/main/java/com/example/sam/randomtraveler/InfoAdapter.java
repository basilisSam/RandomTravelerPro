package com.example.sam.randomtraveler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public InfoAdapter( Context context, int resource) {
        super(context, resource);
    }


    public void add( Info object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {

        return list.size();
    }


    @Override
    public Object getItem(int position) {

        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        InfoHolder infoHolder;
        if(row==null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            infoHolder = new InfoHolder();
            infoHolder.tx_from =(TextView) row.findViewById(R.id.tx_from);
            infoHolder.tx_To =(TextView) row.findViewById(R.id.tx_To);
            infoHolder.tx_Price =(TextView) row.findViewById(R.id.tx_Price);
            infoHolder.tx_DateFrom =(TextView) row.findViewById(R.id.tx_DateFrom);
            infoHolder.tx_DateTo =(TextView) row.findViewById(R.id.tx_DateTo);
            row.setTag(infoHolder);
        }else
        {
            infoHolder = (InfoHolder) row.getTag();
        }

        Info info = (Info) this.getItem(position);
        infoHolder.tx_from.setText(info.getFrom());
        infoHolder.tx_To.setText(info.getTo());
        infoHolder.tx_Price.setText(info.getPrice());
        infoHolder.tx_DateFrom.setText(info.getDateFrom());
        infoHolder.tx_DateTo.setText(info.getDateTo());
        return row;
    }

    static class InfoHolder{
        TextView tx_from,tx_To,tx_Price,tx_DateFrom,tx_DateTo;
    }
}
