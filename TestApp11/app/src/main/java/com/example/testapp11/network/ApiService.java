package com.example.testapp11.network;

import com.example.testapp11.network.model.Country;

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

    private static final String END_POINT = "https://www.thecocktaildb.com/api/json/v1/1/";
    private static CountryApi countryApi;

    public interface CountryApi {
        @GET("all")
        Observable<List<Country>> getAllCountries();

        @GET("name/{country_name}")
        Observable<List<Country>> getCountryByName(@Path("country_name") String countryName, @Query("fullText") boolean fullText);

        @GET("filter.php")
        Observable<Country> getCocktail(@Query("a") String type);
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

    public static Observable<Country> getAllCocktail(){
        return countryApi.getCocktail("Alcoholic");
    }

    public static Observable<List<Country>> getData() {
        return countryApi.getAllCountries();
    }
    public static Observable<List<Country>> getCountryByName(String countryName) {
        return countryApi.getCountryByName(countryName, true);
    }

}
