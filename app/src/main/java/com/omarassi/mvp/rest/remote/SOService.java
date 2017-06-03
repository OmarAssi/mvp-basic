package com.omarassi.mvp.rest.remote;

import com.omarassi.mvp.rest.StackAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by omarassi on 03.06.17.
 */

public interface SOService {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Observable<StackAPI> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Observable<StackAPI> getAnswers(@Query("tagged") String tags);

}
