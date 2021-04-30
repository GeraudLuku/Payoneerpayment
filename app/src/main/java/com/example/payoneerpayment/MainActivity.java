package com.example.payoneerpayment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.example.Adapter.PaymentMethodAdapter;
import com.example.model.Applicable;
import com.example.viewmodel.PaymentListViewModel;

import java.util.ArrayList;

import io.reactivex.plugins.RxJavaPlugins;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Context mContext;

    private ProgressBar mLoadProgress;

    private Animation mFadeInAnim, mFadeOutAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set context
        mContext = this;

        //set support action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //initiate views
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mLoadProgress = findViewById(R.id.load_progress);

        //animations
        mFadeInAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        mFadeOutAnim = AnimationUtils.loadAnimation(this, R.anim.fade_out);


        //connect to viewmodel
        PaymentListViewModel paymentListViewModel = new ViewModelProvider(this).get(PaymentListViewModel.class);

        //listen to incoming payment method results
        paymentListViewModel.getPayments().observe(this, new Observer<ArrayList<Applicable>>() {
            @Override
            public void onChanged(ArrayList<Applicable> applicables) {
                Log.d("MainActivity", applicables.get(0).getLabel());
                //send this data to recyclerview adapter to display on the screen
                mAdapter = new PaymentMethodAdapter(applicables);
                mRecyclerView.setAdapter(mAdapter);

                //show RecyclerView when data is available and hide dialog
                mRecyclerView.startAnimation(mFadeInAnim);
                mLoadProgress.startAnimation(mFadeOutAnim);
            }
        });

        //check if its still loading or not
        paymentListViewModel.getLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading != null) {
                    if (isLoading) {
                        mRecyclerView.startAnimation(mFadeOutAnim);
                    }else {
                        mLoadProgress.startAnimation(mFadeOutAnim);
                    }
                }
            }
        });

        //check if an error was encountered
        paymentListViewModel.getError().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isError) {
                //if an error was encountered show a popup dialog
                if (isError != null)
                    if (isError) {
                        mLoadProgress.startAnimation(mFadeOutAnim);
                        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
                        alertDialog.setMessage("An Error occured while fetching data, visit logcat");
                        alertDialog.show();
                    }
            }
        });

    }
}