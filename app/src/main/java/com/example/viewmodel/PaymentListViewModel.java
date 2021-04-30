package com.example.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.api.RetrofitRepository;
import com.example.model.Applicable;
import com.example.model.PaymentMethods;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PaymentListViewModel extends ViewModel {
    private CompositeDisposable disposable;

    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Applicable>> paymentMethods = new MutableLiveData<>();

    private RetrofitRepository retrofitRepository;

    //constructor
    public PaymentListViewModel() {
        disposable = new CompositeDisposable();
        retrofitRepository = RetrofitRepository.getInstance();
        fetchRepos();
    }

    //

    public LiveData<ArrayList<Applicable>> getPayments() {
        return paymentMethods;
    }

    public LiveData<Boolean> getError() {
        return repoLoadError;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    private void setPaymentMethods(ArrayList<Applicable> paymentMethods){
        this.paymentMethods.setValue(paymentMethods);
    }

    ///

    //get payment methods
//    public MutableLiveData<ArrayList<Applicable>> getPaymentMethods() {
//        //paymentMethods = retrofitRepository.getPaymentMethodss();
//        return paymentMethods;
//    }

    //upgraded get payment methods function
    private void fetchRepos() {
        loading.setValue(true);

                retrofitRepository.getPaymentMethodss()
                        .subscribeOn(Schedulers.io())
                        .doOnError(error -> {
                            Log.d("ViewModel", error.getLocalizedMessage());
                            repoLoadError.setValue(true);
                            loading.setValue(false);
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<PaymentMethods>() {
                            @Override
                            public void onSuccess(@NonNull PaymentMethods paymentMethods) {
                                //get only payment list from the object
                                Log.d("Result", paymentMethods.getNetworks().getApplicable().get(0).getLabel());

                                repoLoadError.setValue(false);
                                setPaymentMethods(paymentMethods.getNetworks().getApplicable());
                                loading.setValue(false);

                                //paymentsMethods.postValue(paymentMethods.getNetworks().getApplicable());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d("RxJava- Error Message", e.getLocalizedMessage());
                                repoLoadError.setValue(true);
                                loading.setValue(false);
                            }
                        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

}
