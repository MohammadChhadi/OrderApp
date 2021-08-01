package com.mohamad.orderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CreateOrder extends AppCompatActivity {

    EditText txtClient,txtItem,txtPrice,txtQuantity,txtDate;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        txtClient = (EditText) findViewById(R.id.edtClient);
        txtItem   = (EditText) findViewById(R.id.edtItem);
        txtPrice  = (EditText) findViewById(R.id.edtPrice);
        txtQuantity  = (EditText) findViewById(R.id.edtQuantity);
        btn_insert = (Button) findViewById(R.id.btnInsert);
        txtDate=(EditText)findViewById(R.id.edtDate);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String client = txtClient.getText().toString().trim();
        final String item = txtItem.getText().toString().trim();
        final String price = txtPrice.getText().toString().trim();
        final String quantity = txtQuantity.getText().toString().trim();
        final String date = txtDate.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://mohammadchhadi1.000webhostapp.com/insert.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(CreateOrder.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else{
                                Toast.makeText(CreateOrder.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(CreateOrder.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("client",client);
                    params.put("item",item);
                    params.put("price",price);
                    params.put("quantity",quantity);
                    params.put("date",date);



                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(CreateOrder.this);
            requestQueue.add(request);



        }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}