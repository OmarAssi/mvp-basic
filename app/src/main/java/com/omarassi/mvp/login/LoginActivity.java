package com.omarassi.mvp.login;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.omarassi.mvp.R;
import com.omarassi.mvp.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    private EditText firstName;
    private EditText lastName;
    private Button login;
    private RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);
        layout = (RelativeLayout) findViewById(R.id.layout);
        firstName = (EditText) findViewById(R.id.editTextFname);
        lastName = (EditText) findViewById(R.id.editTextLname);
        login = (Button) findViewById(R.id.buttonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();

    }

    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Snackbar snackbar = Snackbar
                .make(layout, R.string.error_message, Snackbar.LENGTH_LONG);
        snackbar.show();

    }

    @Override
    public void showInputError() {
        Snackbar snackbar = Snackbar
                .make(layout, R.string.input_error, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void showUserSavedMessage() {
        Snackbar snackbar = Snackbar
                .make(layout, R.string.user_saved, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void setFirstName(String fname) {
        firstName.setText(fname);

    }

    @Override
    public void setLastName(String lname) {
        lastName.setText(lname);
    }

}
