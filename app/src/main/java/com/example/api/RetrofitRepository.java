package com.example.api;

import com.example.model.PaymentMethods;

import io.reactivex.Single;

public class RetrofitRepository {

    private static RetrofitRepository retrofitRepository;
    private PaymentService paymentService;

    public static RetrofitRepository getInstance() {
        if (retrofitRepository == null) {
            retrofitRepository = new RetrofitRepository();
        }
        return retrofitRepository;
    }

    public RetrofitRepository() {
        paymentService = RetrofitClientInstance.getRetrofitInstance().create(PaymentService.class);
    }

    //return the observable method to the view model
    public Single<PaymentMethods> getPaymentMethodss() {
        return paymentService.getPaymentMethods();
    }

}

