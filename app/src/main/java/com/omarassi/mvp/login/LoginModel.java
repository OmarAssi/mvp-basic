package com.omarassi.mvp.login;

/**
 * Created by omarassi on 02.06.17.
 */

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String fname, String lname) {
        repository.saveUser(new User(fname, lname));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
