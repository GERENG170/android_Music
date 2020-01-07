package com.example.musicshop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity =0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter SpinnerAdapter;
    HashMap hashMap;
    String goodsName;
    double price;
    EditText userNameEditText;

   



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");
        userNameEditText = findViewById(R.id.editText3);






        SpinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(SpinnerAdapter);
        hashMap = new HashMap();
        hashMap.put("guitar",500.0);
        hashMap.put("drums",450.0);
        hashMap.put("keyboard",210.0);


    }

    public void increaseQuantity(View view) {
        quantity += 1;
        TextView nullTextView = findViewById(R.id.nullTextView);
        nullTextView.setText(" " + quantity);
        TextView priceText = findViewById(R.id.nullText);
        priceText.setText("" + quantity* price);


    }

    public void increaseQuantity2(View view) {
        quantity -=1;
        TextView nullTextView1 = findViewById(R.id.nullTextView);
        nullTextView1.setText(""+quantity);
        TextView priceText = findViewById(R.id.nullText);
        priceText.setText("" + quantity* price);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
   goodsName = spinner.getSelectedItem().toString();
   price = (double)hashMap.get(goodsName);
   TextView priceText = findViewById(R.id.nullText);
   priceText.setText("" + quantity* price);

        ImageView goodsImageView = findViewById(R.id.imageView);
        if (goodsName.equals("drums")){
            goodsImageView.setImageResource(R.drawable.drums);
        }
        else if (goodsName.equals("keyboard")){
            goodsImageView.setImageResource(R.drawable.piano);
        }
        else {
            goodsImageView.setImageResource(R.drawable.guitar);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCard(View view) {
        order order = new order();
        order.userName = userNameEditText.getText().toString();
        Log.d("UserName", order.userName);
        order.goodsName = goodsName;
        Log.d("UserName1", order.goodsName);
        order.quantity = quantity;
        Log.d("UserName3", "" + order.quantity);
        order.orderPrice = quantity * price;
        Log.d("UserName2","" + order.orderPrice);
        Intent oder = new Intent(MainActivity.this,oderActivity.class);
        oder.putExtra("name",order.userName);
        oder.putExtra("goods",order.goodsName);
        oder.putExtra("orderPrice",order.orderPrice);
        oder.putExtra("quantity",order.quantity);
        startActivity(oder);


    }
}
