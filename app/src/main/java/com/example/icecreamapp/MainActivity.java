package com.example.icecreamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView ounceTextField;
    TextView priceTextField;

    Button theWorksButton;
    Button resetButton;
    Button orderButton;

    CheckBox peanutsCheckBox;
    CheckBox MMsCheckBox;
    CheckBox AlmondsCheckBox;
    CheckBox BrownieCheckBox;
    CheckBox StrawberriesCheckBox;
    CheckBox OreosCheckBox;
    CheckBox GummyBearsCheckBox;
    CheckBox MarshmallowsCheckBox;

    Spinner flavorSpinner;
    Spinner sizeSpinner;

    SeekBar hotFudgeSeekBar;
    double price;
    String size;
    String flavor;
    ArrayList<OrderItem> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ounceTextField = findViewById(R.id.OunceTextField);
        priceTextField = findViewById(R.id.PriceTextView);

        theWorksButton = findViewById(R.id.TheWorksButton);
        resetButton = findViewById(R.id.ResetButton);
        orderButton = findViewById(R.id.OrderButton);

        peanutsCheckBox = findViewById(R.id.PeanutsCheckBox);
        MMsCheckBox = findViewById(R.id.MMCheckBox);
        AlmondsCheckBox = findViewById(R.id.AlmondsCheckBox);
        BrownieCheckBox = findViewById(R.id.BrownieCheckBox);
        StrawberriesCheckBox = findViewById(R.id.StrawberriesCheckBox);
        OreosCheckBox = findViewById(R.id.OreosCheckBox);
        GummyBearsCheckBox = findViewById(R.id.GummyBearsCheckBox);
        MarshmallowsCheckBox = findViewById(R.id.MarshmallowsCheckBox);

        hotFudgeSeekBar = findViewById(R.id.HotFudgeSeekBar);

        flavorSpinner = findViewById(R.id.flavorSpinner);
        sizeSpinner = findViewById(R.id.sizeSpinner);

        price = 0;
        size = sizeSpinner.getItemAtPosition(0).toString();
        orders = new ArrayList<>();
        flavor = flavorSpinner.getItemAtPosition(0).toString();

        theWorksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theWorks();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderItem o = new OrderItem(flavor,size,price);
                orders.add(o);
                Toast.makeText(MainActivity.this,"Sundae is on the way!", Toast.LENGTH_SHORT).show();
                reset();
            }
        });

        flavorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    flavor = "Vanilla";
                else if(position == 1)
                    flavor = "Chocolate";
                else if(position == 2)
                    flavor = "Strawberry";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    size = "Small";
                else if(position == 1)
                    size = "Medium";
                else if(position == 2)
                    size = "Large";
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        peanutsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        MMsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        AlmondsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        BrownieCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        StrawberriesCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        OreosCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        GummyBearsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        MarshmallowsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });



        hotFudgeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        update();
    }

    public void update() {
        calculate();
        priceTextField.setText("$"+ String.format("%.2f",price));
        ounceTextField.setText(hotFudgeSeekBar.getProgress() + " oz");
    }

    public void reset() {
        peanutsCheckBox.setChecked(false);
        MMsCheckBox.setChecked(false);
        AlmondsCheckBox.setChecked(false);
        BrownieCheckBox.setChecked(false);
        StrawberriesCheckBox.setChecked(false);
        OreosCheckBox.setChecked(false);
        GummyBearsCheckBox.setChecked(false);
        MarshmallowsCheckBox.setChecked(false);
        hotFudgeSeekBar.setProgress(1);
        sizeSpinner.setSelection(0);
        update();
    }

    public void theWorks() {
        peanutsCheckBox.setChecked(true);
        MMsCheckBox.setChecked(true);
        AlmondsCheckBox.setChecked(true);
        BrownieCheckBox.setChecked(true);
        StrawberriesCheckBox.setChecked(true);
        OreosCheckBox.setChecked(true);
        GummyBearsCheckBox.setChecked(true);
        MarshmallowsCheckBox.setChecked(true);
        hotFudgeSeekBar.setProgress(3);
        sizeSpinner.setSelection(2);
        update();
    }

    public void calculate() {

        price = 0;

        if (size.equalsIgnoreCase("Small"))
            price = 2.99;
        else if(size.equalsIgnoreCase("Medium"))
            price = 3.99;
        else if(size.equalsIgnoreCase("Large"))
            price = 4.99;

        if (peanutsCheckBox.isChecked())
            price += 0.15;
        if (MMsCheckBox.isChecked())
            price += 0.25;
        if (AlmondsCheckBox.isChecked())
            price += 0.15;
        if(BrownieCheckBox.isChecked())
            price += 0.20;
        if(StrawberriesCheckBox.isChecked())
            price += 0.20;
        if (OreosCheckBox.isChecked())
            price += 0.20;
        if (GummyBearsCheckBox.isChecked())
            price += 0.20;
        if (MarshmallowsCheckBox.isChecked())
            price += 0.15;

        if (hotFudgeSeekBar.getProgress() == 1)
            price += 0.15;
        else if(hotFudgeSeekBar.getProgress() == 2)
            price += 0.25;
        else if(hotFudgeSeekBar.getProgress() == 3)
            price += 0.30;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent i = new Intent(MainActivity.this,AboutActivity.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.action_order_history) {
            Intent i = new Intent(MainActivity.this, OrderHistoryActivity.class);
            i.putExtra("ORDERS",orders);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
