package com.yuseok.android.memowithnodejs;

import com.yuseok.android.memowithnodejs.domain.Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by YS on 2017-03-24.
 */

public interface LocalhoostInterface {
    @GET("bbs")
    Call<Data> getData();
}
