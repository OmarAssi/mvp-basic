package com.omarassi.mvp.login;

/**
 * Created by omarassi on 02.06.17.
 */

public class MemoryRepository implements LoginRepository {

    private User user;


    @Override
    public User getUser() {
        if (user == null) {
            User user = new User("Android", "MVP");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        }
        this.user = user;

    }
}
