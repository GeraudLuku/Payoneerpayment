package com.example.api;

import com.example.model.PaymentMethods;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PaymentService {

    @GET("listresult.json")
    Single<PaymentMethods> getPaymentMethods();
}
