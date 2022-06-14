package com.example.testapp12.network;

import com.example.testapp12.network.model.Country;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiService {

    private static final String END_POINT = "https://restcountries.com/v2/";
    private static CountryApi countryApi;

    public interface CountryApi {
        @GET("all")
        Observable<List<Country>> getAllCountries();

        @GET("name/{country_name}")
        Observable<List<Country>> getCountryByName(@Path("country_name") String countryName, @Query("fullText") boolean fullText);
    }

    static {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(END_POINT)
                .client(client)
                .build();

        countryApi = retrofit.create(CountryApi.class);
    }

    public static Observable<List<Country>> getData(){
        return countryApi.getAllCountries();
    }

    public static Observable<List<Country>> getCountryByName(String countryName) {
        return countryApi.getCountryByName(countryName, true);
    }
}
