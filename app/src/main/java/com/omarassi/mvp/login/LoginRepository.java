package com.omarassi.mvp.login;

/**
 * Created by omarassi on 02.06.17.
 */

public interface LoginRepository {

    User getUser();

    void saveUser(User user);

}
