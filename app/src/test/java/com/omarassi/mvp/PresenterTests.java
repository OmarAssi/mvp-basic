package com.omarassi.mvp;

import com.omarassi.mvp.login.LoginActivityMVP;
import com.omarassi.mvp.login.LoginActivityPresenter;
import com.omarassi.mvp.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by omarassi on 02.06.17.
 */

public class PresenterTests {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;

    @Before
    public void setup() {

        mockLoginModel = mock(LoginActivityMVP.Model.class);

        user = new User("test", "junit");

        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);

        presenter.setView(mockView);

    }

    @Test
    public void loadTheUserFromTheRepoWhenValidUserIsPresent() {
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        //Verify model interaction
        verify(mockLoginModel, times(1)).getUser();

        //Verify view interaction
        verify(mockView, times(1)).setFirstName("test");
        verify(mockView, times(1)).setLastName("junit");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {

        when(mockLoginModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();

        //verify view interactions
        verify(mockLoginModel, times(1)).getUser();

        //verify view interactions
        verify(mockView, never()).setFirstName("test");
        verify(mockView, never()).setLastName("junit");
        verify(mockView, times(1)).showUserNotAvailable();

    }


    @Test
    public void shouldCreateErrorMessageIfFieldAreEmpty() {

        //set up the view mock
        when(mockView.getFirstName()).thenReturn(""); // empty string

        presenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        //now tell mockView to return a value for first name and an empty last name

        when(mockView.getFirstName()).thenReturn("omar");
        when(mockView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(2)).showInputError();
    }

}
