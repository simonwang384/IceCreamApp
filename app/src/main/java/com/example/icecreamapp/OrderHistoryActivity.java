package com.example.icecreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {
    ArrayList<OrderItem> orders;
    ArrayList<String> string_orders;
    ListView orderHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        setTitle("Order History");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        orderHistoryListView = findViewById(R.id.OrderHistoryListView);

        Intent i = getIntent();
        orders = new ArrayList<OrderItem>();
        string_orders = new ArrayList<>();
        orders = (ArrayList<OrderItem>) i.getSerializableExtra("ORDERS");
        for(OrderItem o: orders)
            string_orders.add(o.toString());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                string_orders
        );

        orderHistoryListView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
