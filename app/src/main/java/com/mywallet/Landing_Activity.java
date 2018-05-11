package com.mywallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

/**
 * Created by admin on 30-Apr-18.
 */

public class Landing_Activity extends AppCompatActivity {
    LinearLayout Get_Start;
    Animation slideUpAnimation, slideDownAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet_home);
        Get_Start = (LinearLayout)findViewById(R.id.get_start);
        slideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_animation);

        slideDownAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);

        Get_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Landing_Activity.this,SendMoney_Activity.class);
                startActivityForResult(intent,0);
                overridePendingTransition( R.anim.slide_up_animation, R.anim.slide_down_animation );
            }
        });

    }
}
