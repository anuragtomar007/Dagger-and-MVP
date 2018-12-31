package com.example.dell.flexydriver;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {
    @BindView(R.id.btn_phone)
    Button phoneSelector;
    @BindView(R.id.btn_email)
    Button emailSelector;
    @BindView(R.id.rlChildEmail)
    RelativeLayout emailRelativeLayout;
    @BindView(R.id.rlChildPhone)
    RelativeLayout phoneRelativeLayout;
    @BindView(R.id.btn_signUp)
    Button signUp;
    @BindView(R.id.et_emailAddress)
    EditText emailAddress;
    @BindView(R.id.et_PasswordEmail)
    EditText emailPassword;
    @BindView(R.id.et_phoneNumber)
    EditText phoneNumber;
    @BindView(R.id.et_PasswordPhone)
    EditText phonePassword;
    @BindView(R.id.btn_forgotPassword_email)
    Button emailForgotPassword;
    @BindView(R.id.btn_forgotPassword_phone)
    Button phoneForgotPassword;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this, this);
        emailSelector.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.appOrange));
    }

    @OnClick({R.id.btn_phone, R.id.btn_email, R.id.btn_forgotPassword_email, R.id.btn_forgotPassword_phone, R.id.btn_signUp,
            R.id.btn_phone_signIn, R.id.btn_email_signIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_phone:
                emailSelector.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                phoneSelector.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.appOrange));
                emailRelativeLayout.setVisibility(View.GONE);
                phoneRelativeLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_email:
                phoneSelector.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                emailSelector.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.appOrange));
                phoneRelativeLayout.setVisibility(View.GONE);
                emailRelativeLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_forgotPassword_email:
                presenter.forgotPassword();
                break;
            case R.id.btn_forgotPassword_phone:
                presenter.forgotPassword();
                break;
            case R.id.btn_signUp:
                presenter.SignUp();
                break;
            case R.id.btn_email_signIn:
                presenter.validate(emailAddress.getText().toString(), emailPassword.getText().toString());
//                presenter.authenticateLogin(emailAddress.getText().toString(), emailPassword.getText().toString());
                break;
            case R.id.btn_phone_signIn:
                presenter.validatePhone(phoneNumber.getText().toString(), phonePassword.getText().toString());
                presenter.authenticateLogin(phoneNumber.getText().toString(), phonePassword.getText().toString());
                break;
        }
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Yaa!!! You are successful in signIn Process", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "OOPS!!! Something Went Wrong.Please check your credentials", Toast.LENGTH_SHORT).show();
    }
}
