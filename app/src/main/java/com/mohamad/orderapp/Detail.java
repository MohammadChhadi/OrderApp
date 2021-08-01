package com.mohamad.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView tvId,tvClient,tvItem,tvPrice,tvQuantity,tvDate;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvId = findViewById(R.id.txtid);
        tvClient = findViewById(R.id.txt_client);
        tvPrice = findViewById(R.id.txt_price);
        tvItem = findViewById(R.id.txt_item);
        tvQuantity = findViewById(R.id.txt_quantity);
        tvDate = findViewById(R.id.txt_date);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvId.setText("ID: "+DetailsOrder.orderArrayList.get(position).getId());
        tvClient.setText("Client: "+DetailsOrder.orderArrayList.get(position).getClient());
        tvItem.setText("Item: "+DetailsOrder.orderArrayList.get(position).getItem());
        tvPrice.setText("Price: "+DetailsOrder.orderArrayList.get(position).getPrice());
        tvQuantity.setText("Qusntity: "+DetailsOrder.orderArrayList.get(position).getQuantity());
        tvDate.setText("Date: "+DetailsOrder.orderArrayList.get(position).getDate());

    }
}