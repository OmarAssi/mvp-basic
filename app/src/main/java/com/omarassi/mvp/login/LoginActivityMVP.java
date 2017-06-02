package com.omarassi.mvp.login;

/**
 * Created by omarassi on 02.06.17.
 */

public interface LoginActivityMVP {

    interface View {

        String getFirstName();

        String getLastName();

        void showUserNotAvailable();

        void showInputError();

        void showUserSavedMessage();

        void setFirstName(String fname);

        void setLastName(String lname);

    }

    interface Presenter {

        void setView(LoginActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();

        void saveUser();

    }

    interface Model {

        void createUser(String fname, String lname);

        User getUser();

    }

}
