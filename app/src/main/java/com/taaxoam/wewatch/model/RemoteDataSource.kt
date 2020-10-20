package com.taaxoam.wewatch.model

import com.taaxoam.wewatch.network.RetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class RemoteDataSource {

  fun searchResultsObservable(query: String): Observable<TmdbResponse> {
    return RetrofitClient.moviesApi
        .searchMovie(RetrofitClient.API_KEY, query)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
  }
}