package com.mywallet;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 30-Apr-18.
 */

public class Login_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        PoPWindows();

    }

    private void PoPWindows() {
        Animation slideUpAnimation, slideDownAnimation;

        LayoutInflater inflater = LayoutInflater.from(Login_Activity.this);
        View PromtView = inflater.inflate(R.layout.popwindows, null);
        final AlertDialog alertD = new AlertDialog.Builder(Login_Activity.this).create();
        alertD.setCancelable(true);
        final  ImageView FingerPrint = (ImageView)PromtView.findViewById(R.id.fingerprint);
        final  ImageView FingerPrint_blue = (ImageView)PromtView.findViewById(R.id.fingerprint_new);
        final  TextView Login = (TextView)PromtView.findViewById(R.id.tv_login);
        FingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FingerPrint_blue.setVisibility(View.VISIBLE);
                FingerPrint.setVisibility(View.GONE);
                Intent intent = new Intent(Login_Activity.this, Home_Activity.class);
                startActivity(intent);
                finish();
                overridePendingTransition( R.anim.right_in, R.anim.right_out );

            }
        });

        alertD.setView(PromtView);
        alertD.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition( R.anim.right_in, R.anim.right_out);
    }
}
