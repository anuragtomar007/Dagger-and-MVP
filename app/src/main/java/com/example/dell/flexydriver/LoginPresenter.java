package com.example.dell.flexydriver;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.dell.flexydriver.Networking.FlexyData;
import com.example.dell.flexydriver.Networking.LoginClient;

import java.util.Calendar;
import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginPresenter implements LoginContract.presenter {
    private LoginModel model;
    private LoginContract.view view;
    private Context context;
    Boolean result;

    public LoginPresenter(LoginContract.view view, Context context) {
        this.view = view;
        this.context = context;
        model = new LoginModel();
    }

    @Override
    public void forgotPassword() {
        Toast.makeText(context, "You have clicked the Forgot Password Button ", Toast.LENGTH_SHORT).show();
        Date date = Calendar.getInstance().getTime();
        Toast.makeText(context, "Time: " + date.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SignUp() {
        Toast.makeText(context, "You have clicked the Sign Up Button", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validate(String string1, String string2) {
        if (model.validateData(string1, string2)) {
            Toast.makeText(context, "Please fill all the Credentials", Toast.LENGTH_SHORT).show();
            result = false;
            signIn();
        } else {
            if (validateEmail(string1)) {
                Toast.makeText(context, "Email is in correct format", Toast.LENGTH_SHORT).show();
                result = true;
            } else {
                Toast.makeText(context, "Email is not in correct format", Toast.LENGTH_SHORT).show();
                result = false;
            }
            if (result) {
                signIn();
            }
        }
    }

    @Override
    public void validatePhone(String string1, String string2) {
        if (model.validateData(string1, string2)) {
            Toast.makeText(context, "Please fill all the Credentials", Toast.LENGTH_SHORT).show();
            result = false;
            signIn();
        } else {
            result = true;
            signIn();
        }
    }

    @Override
    public boolean validateEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]{2,3}$";
        if (email.matches(emailPattern))
            return true;
        else
            return false;
    }

    @Override
    public void signIn() {
        if (result == true) {
            view.onSuccess();
            Toast.makeText(context, "You are Logged In our app", Toast.LENGTH_SHORT).show();
        } else if (result == false)
            view.onError();
    }

    @Override
    public void authenticateLogin(String string, String password) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        String countryCode = "91";
        String deviceId = "123";
        String pushToken = "321";
        String appVersion = "8";
        String deviceMake = "12";
        String deviceModel = "21";
        int deviceType = 1;
        Date time = Calendar.getInstance().getTime();
        String deviceTime = "11:30";
        int deviceOsVersion = android.os.Build.VERSION.SDK_INT;

        LoginClient.getClient().signInFlexy(countryCode, string, password, deviceId, pushToken, appVersion, deviceMake,
                deviceModel, deviceType, deviceTime, deviceOsVersion, new Callback<FlexyData>() {
                    @Override
                    public void success(FlexyData flexyData, Response response) {
                        progressDialog.dismiss();
                        Toast.makeText(context, "Success :" + response.getBody().toString(), Toast.LENGTH_SHORT).show();
                        Log.d("Device", "Success : " + response.getBody().toString());
                        Toast.makeText(context, "Status of call :" + response.getStatus(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(context, "Error Found " + error.toString(), Toast.LENGTH_LONG).show();
                        Log.d("Device", "Error :" + error.toString());
                        progressDialog.dismiss();
                    }
                });
    }
}
