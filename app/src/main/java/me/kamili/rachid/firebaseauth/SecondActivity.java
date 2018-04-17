package me.kamili.rachid.firebaseauth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.kamili.rachid.firebaseauth.utils.FacebookManager;

public class SecondActivity extends AppCompatActivity implements FacebookManager.ISignOutInteraction{

    private FacebookManager mFacebookManager;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mFacebookManager = FacebookManager.getInstance(this);

        tvEmail = findViewById(R.id.tvEmail);
        tvEmail.setText(mFacebookManager.getUser().getEmail());
    }

    public void onSignOut(View view) {
        mFacebookManager.signOut();
    }

    @Override
    public void onSignOut(boolean isSignedOut) {
        finish();
    }
}
