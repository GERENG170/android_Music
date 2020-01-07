package com.example.musicshop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class oderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder);
        Intent receiv3dOrderIntent = getIntent();
        String userName = receiv3dOrderIntent.getStringExtra("name");
        String goodsName = receiv3dOrderIntent.getStringExtra("goods");
        int orderPrice = receiv3dOrderIntent.getIntExtra("orderPrice", 0);
        double quantity = receiv3dOrderIntent.getDoubleExtra("quantity",0);
        TextView orderText = findViewById(R.id.orderText);
        orderText.setText("NAME:" + userName +"\n"+"GOODSNAME:" + goodsName+"\n"+ "PRICE:" + orderPrice+"\n"+ "QUANTITY:"  + quantity);

    }
    }
