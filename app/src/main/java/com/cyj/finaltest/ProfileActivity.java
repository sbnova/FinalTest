package com.cyj.finaltest;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends BaseActivity {

    private de.hdodenhof.circleimageview.CircleImageView profileImgView;
    private android.widget.TextView profileNameTxt;
    private android.widget.TextView profileEmailTxt;
    private android.widget.TextView profilePasswordTxt;
    private android.widget.TextView profileGenderTxt;
    private android.widget.TextView profileAgeTxt;
    private android.widget.TextView profilePhoneNumberTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.profilePhoneNumberTxt = (TextView) findViewById(R.id.profilePhoneNumberTxt);
        this.profileAgeTxt = (TextView) findViewById(R.id.profileAgeTxt);
        this.profileGenderTxt = (TextView) findViewById(R.id.profileGenderTxt);
        this.profilePasswordTxt = (TextView) findViewById(R.id.profilePasswordTxt);
        this.profileEmailTxt = (TextView) findViewById(R.id.profileEmailTxt);
        this.profileNameTxt = (TextView) findViewById(R.id.profileNameTxt);
        this.profileImgView = (CircleImageView) findViewById(R.id.profileImgView);

    }
}
