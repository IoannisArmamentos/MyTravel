package com.noobs.mytravel;

import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    LoginButton loginButton;
    TextView textView;
    ImageView imageView;
    private static final String EMAIL = "email";
    private static final String USER_POSTS = "user_posts";
    private static final String AUTH_TYPE = "rerequest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        //LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        loginButton = findViewById(R.id.login_button);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        callbackManager = CallbackManager.Factory.create();
        //textView = findViewById(R.id.textViewtest);
        imageView = findViewById(R.id.imageView);

        //For Facebook gia ta kleidia
        //printKeyHash();

        //Hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        // An einai logged in synexizei stin MainMenu alliws prepei kanei log in
        if (accessToken != null) {
            loginButton.setVisibility(View.INVISIBLE);
            new Timer().schedule(new TimerTask() {
                public void run() {
                    //textView.setText("Login Success \n");
                    startActivity(new Intent(MainActivity.this, MainMenu.class));
                }
            }, 2500);
        } else {
            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            setResult(RESULT_OK);
                            //textView.setText("Login Success \n" + loginResult.getAccessToken().getUserId() + "\n TROLOLOLOL \n" + loginResult.getAccessToken().getToken());
                            startActivity(new Intent(MainActivity.this, MainMenu.class));
                        }

                        @Override
                        public void onCancel() {
                            setResult(RESULT_CANCELED);
                        }

                        @Override
                        public void onError(FacebookException exception) {
                        }
                    });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

/*    private void printKeyHash() {
        try {
            String packageName = getApplicationContext().getPackageName();
            PackageInfo info = getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            Log.e("KeyHash:", e.toString());
        }
    }*/

/*    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }*/
}

