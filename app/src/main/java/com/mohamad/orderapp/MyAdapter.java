package com.mohamad.orderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mohamad.orderapp.Model.Order;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Order> {

    Context context;
    List<Order> arrayListOrder;


    public MyAdapter(@NonNull Context context, List<Order> arrayListOrder) {
        super(context, R.layout.custom_list_item,arrayListOrder);

        this.context = context;
        this.arrayListOrder = arrayListOrder;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvDate = view.findViewById(R.id.txt_date);
        TextView tvAmount = view.findViewById(R.id.txt_price);
        TextView tvClient = view.findViewById(R.id.txt_client);

        tvID.setText(arrayListOrder.get(position).getId());
        tvDate.setText(arrayListOrder.get(position).getDate());
        tvAmount.setText(arrayListOrder.get(position).getPrice());
        tvClient.setText(arrayListOrder.get(position).getClient());

        return view;
    }
}