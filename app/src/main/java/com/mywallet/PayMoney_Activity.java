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

public class PayMoney_Activity extends AppCompatActivity {
    LinearLayout Add_Proceed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymoney_wallet);
        Add_Proceed = (LinearLayout) findViewById(R.id.add_proceed);
        Add_Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayMoney_Activity.this, PayMoney_Details_Activity.class);
                startActivity(intent);
                overridePendingTransition( R.anim.right_in, R.anim.right_out );
            }
        });
    }
}
