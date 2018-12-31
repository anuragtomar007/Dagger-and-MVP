package com.example.dell.flexydriver;

public interface LoginContract {
    interface view {
        void onSuccess();

        void onError();
    }

    interface presenter {
        void forgotPassword();

        void SignUp();

        void signIn();

        void validate(String string1, String string2);

        void validatePhone(String string1, String string2);

        boolean validateEmail(String email);

        void authenticateLogin(String string, String password);
    }
}
