package com.omarassi.mvp.root;

import android.app.Application;

import com.omarassi.mvp.login.LoginModule;

/**
 * Created by omarassi on 02.06.17.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
