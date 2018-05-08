package com.mywallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by admin on 02-May-18.
 */

public class PayMoney_Details_Activity extends AppCompatActivity{
    LinearLayout Success_Proceed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_proceed_wallet);
        Success_Proceed = (LinearLayout)findViewById(R.id.success_proceed);
        Success_Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayMoney_Details_Activity.this, PayMoney_Success_Activity.class);
                startActivity(intent);
                overridePendingTransition( R.anim.right_in, R.anim.right_out );
            }
        });
    }
}
