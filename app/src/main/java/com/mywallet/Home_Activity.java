package com.mywallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 30-Apr-18.
 */

public class Home_Activity extends AppCompatActivity {
    LinearLayout Home,SendMoney,PayMoney,AddMoney;
    RecyclerView recyclerView;
    WalletHomeAdapter walletHomeAdapter;
    ArrayList<WalletModel> walletModels_list = new ArrayList<>();


    private final String home_texts[] = {"Send Money","Top Up","Pay Bill" ,"Digital","Pay Utilities","Open Wallet"};

    private final int home_text_icons[] = {R.drawable.send_money,R.drawable.top_up,R.drawable.ic_light_bulb,R.drawable.pay_utilities,
            R.drawable.digital,R.drawable.ic_open_wallet};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        Home =(LinearLayout)findViewById(R.id.home);
        SendMoney =(LinearLayout)findViewById(R.id.sendmoney);
        PayMoney =(LinearLayout)findViewById(R.id.paymoney);
        AddMoney =(LinearLayout)findViewById(R.id.addmoney);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

       for (int i=0;i<home_texts.length;i++){
           WalletModel  walletModel = new WalletModel();
           walletModel.setWallet_name(home_texts[i]);
           walletModel.setWallet_image(home_text_icons[i]);
           walletModels_list.add(walletModel);
       }
        walletHomeAdapter = new WalletHomeAdapter(this,walletModels_list);
        recyclerView.setLayoutManager(new GridLayoutManager(Home_Activity.this, 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(walletHomeAdapter);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_money= new Intent(Home_Activity.this,Home_Activity.class);
                startActivity(add_money);
                overridePendingTransition( R.anim.right_in, R.anim.right_out );
            }
        });
        SendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_money= new Intent(Home_Activity.this,SendMoney_Activity.class);
                startActivity(add_money);
                overridePendingTransition( R.anim.right_in, R.anim.right_out );
            }
        });
        PayMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_money= new Intent(Home_Activity.this,PayMoney_Activity.class);
                startActivity(add_money);
                overridePendingTransition( R.anim.right_in, R.anim.right_out );
            }
        });
        AddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_money= new Intent(Home_Activity.this,AddMoney_Activity.class);
                startActivity(add_money);
                overridePendingTransition( R.anim.right_in, R.anim.right_out );
            }
        });
    }


}
