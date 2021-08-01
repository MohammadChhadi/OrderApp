package com.mohamad.orderapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateOrder extends AppCompatActivity {

    EditText edClient,edItem,edPrice,edQuantity,edDate;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateorder);

        edClient = findViewById(R.id.edtClient);
        edItem = findViewById(R.id.edtItem);
        edPrice = findViewById(R.id.edtPrice);
        edQuantity = findViewById(R.id.edtQuantity);
        edDate = findViewById(R.id.edtDate);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        edClient.setText(DetailsOrder.orderArrayList.get(position).getClient());
        edItem.setText(DetailsOrder.orderArrayList.get(position).getItem());
        edPrice.setText(DetailsOrder.orderArrayList.get(position).getPrice());
        edQuantity.setText(DetailsOrder.orderArrayList.get(position).getQuantity());
        edDate.setText(DetailsOrder.orderArrayList.get(position).getDate());

    }
    public void btn_update(View view) {

        final String name = edClient.getText().toString();
        final String item = edItem.getText().toString();
        final String price = edPrice.getText().toString();
        final String quantity = edQuantity.getText().toString();
        final String date = edDate.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://mohammadChhadi1.000webhostapp.com/update.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(UpdateOrder.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(UpdateOrder.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("client",name);
                params.put("item",item);
                params.put("price",price);
                params.put("quantity",quantity);
                params.put("date",date);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(UpdateOrder.this);
        requestQueue.add(request);
    }
}