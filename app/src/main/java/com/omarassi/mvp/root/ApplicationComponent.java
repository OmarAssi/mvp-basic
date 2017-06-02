package com.omarassi.mvp.root;

import com.omarassi.mvp.login.LoginActivity;
import com.omarassi.mvp.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by omarassi on 02.06.17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject (LoginActivity target);

}
