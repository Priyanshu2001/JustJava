package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.justjava.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    private ActivityMainBinding v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding v = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(v.getRoot());
        v.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });
        v.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });
        v.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order();
            }
        });


    }

    public void increment() {
        quantity += 1;
        display(quantity);
        displayStats();
    }

    public void decrement() {
        quantity -= 1;
        if (quantity < 0) {
            quantity = 0;
        }
        display(quantity);
        displayStats();
    }

    public void order() {
        Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show();
    }

    public void display(int num) {
        TextView showNumber = findViewById(R.id.textView3);
        showNumber.setText(num + "");

    }

    public void displayStats() {
        TextView showTotal = findViewById(R.id.textView6);
        TextView showComment = findViewById(R.id.textView7);
        showTotal.setText("Total  Amount to be Paid:  ₹  " + quantity * 10);
        showComment.setText(quantity + " Item in Your Cart. Order your delicious Coffee and enjoy!");
    }
}