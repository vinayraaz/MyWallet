package com.mywallet;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.mywallet.api.ApiClient;
import com.mywallet.api.ApiInterface;
import com.mywallet.model.FeedResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by admin on 30-Apr-18.
 */

public class Login_Activity extends AppCompatActivity {
    CallbackManager callbackManager;
    LoginButton loginButton;
    public String Access_Token="EAACEdEose0cBAMukOyZCIJfwVNyA5js4k6IeyNjrhDBf9cu8bBuJGA3IH9ItqMPZC00OyT5G88y7nEWOSlEHawsqejWm7NjX43OUvCgwEMVZCTGQzYgWvq2vp0JGZAYqsPo2NIqZAlLVOakC8UmEpNoMMxctjndx3L25XgefsCBSPvchcDB2bYjiB1UZCuEdoZD";
    ApiInterface apiService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login_activity);

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.btnfb);
       // PoPWindows();

        apiService = ApiClient.getClient().create(ApiInterface.class);
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getIDDetails();
                getfeed();
               // getFriendsList();
               // getfeed();
                getUserDetails(loginResult);

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });


    }

    private void getIDDetails() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Insert your code here
                        System.out.println("ResponseUSERID**"+object.toString());

                    }
                });

        request.executeAsync();
    }

    private void getfeed() {
        Call<FeedResponse> call = apiService.getFeedResponse(Access_Token);
        call.enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                Gson gson = new Gson();
                System.out.println("ResponseFeed**"+gson.toJson(response.body()));
//                System.out.println("ResponseFeed**"+response.body().getData().size());
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {

            }
        });
        /*GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/feed",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        // Insert your code here
                        Gson gson = new Gson();
                        System.out.println("ResponseFeed**"+gson.toJson(response.toString()));
                        System.out.println("ResponseFeed**"+response.toString());
                    }
                });

        request.executeAsync();*/
    }

    private List<String> getFriendsList()  {
        final List<String> friendslist = new ArrayList<String>();
        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/2073974246192994",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        // Insert your code here
                        Gson gson = new Gson();
                        System.out.println("Response2**"+response.toString());
                    }
                });

        request.executeAsync();
        /*new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/friends", null, HttpMethod.GET, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse response) {
*//* handle the result *//*
                Log.e("Friends List: 1", response.toString());
                try {
                    JSONObject responseObject = response.getJSONObject();
                    JSONArray dataArray = responseObject.getJSONArray("data");

                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject dataObject = dataArray.getJSONObject(i);
                        String fbId = dataObject.getString("id");
                        String fbName = dataObject.getString("name");
                        Log.e("FbId", fbId);
                        Log.e("FbName", fbName);
                        friendslist.add(fbId);
                    }
                    Log.e("fbfriendList", friendslist.toString());
                    List<String> list = friendslist;
                    String friends = "";
                    if (list != null && list.size() > 0) {
                        friends = list.toString();
                        if (friends.contains("[")) {
                            friends = (friends.substring(1, friends.length() - 1));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    //hideLoadingProgress();
                }
            }
        }).executeAsync()*/;


        return friendslist;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void getUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject json_object, GraphResponse response) {
                        Gson gson = new Gson();
                        System.out.println("ResponseLogindetails**"+json_object.toString());
                        Intent intent = new Intent(Login_Activity.this, UserProfile_Activity.class);
                        intent.putExtra("userProfile", json_object.toString());
                        startActivity(intent);
                    }

                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();

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
        final LinearLayout FaceBook_Login = (LinearLayout)PromtView.findViewById(R.id.facebook_linear);
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

        FaceBook_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login_Activity.this, Facebook_page.class);
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

    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }
}
