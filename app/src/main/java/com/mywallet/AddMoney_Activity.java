package com.mywallet;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by admin on 02-May-18.
 */

public class AddMoney_Activity extends AppCompatActivity{
    LinearLayout Add;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_money_wallet);
        Add = (LinearLayout)findViewById(R.id.add);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(AddMoney_Activity.this);
                View PromtView = inflater.inflate(R.layout.money_add_pop, null);
                final AlertDialog alertD = new AlertDialog.Builder(AddMoney_Activity.this).create();
                alertD.setCancelable(true);

                final TextView TV_Ok = (TextView)PromtView.findViewById(R.id.tv_ok);
                TV_Ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       alertD.dismiss();
                        Intent intent = new Intent(AddMoney_Activity.this, Home_Activity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition( R.anim.right_in, R.anim.right_out );

                    }
                });

                alertD.setView(PromtView);
                alertD.show();
            }
        });
    }
    public void A(){

    }
}
