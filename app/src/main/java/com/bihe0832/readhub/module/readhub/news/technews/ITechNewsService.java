package com.bihe0832.readhub.module.readhub.news.technews;

import com.bihe0832.readhub.module.readhub.news.api.bean.NewsRsp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * Created by erichua on 5/14/15.
 */
public interface ITechNewsService {
    @GET("technews")
    Call<NewsRsp> requestNewsList(@Query("lastCursor") String lastCursor, @Query("pageSize") int pageSize);
}
