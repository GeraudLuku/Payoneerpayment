package com.example.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.model.Applicable;
import com.example.payoneerpayment.R;

import java.util.ArrayList;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.PaymentMethodViewHolder> {

    private ArrayList<Applicable> mPaymentMethodsList;

    public PaymentMethodAdapter(ArrayList<Applicable> paymentMethods) {
        this.mPaymentMethodsList = paymentMethods;
    }


    @NonNull
    @Override
    public PaymentMethodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_method_item, parent, false);
        return new PaymentMethodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodViewHolder holder, int position) {
        Applicable paymentMethod = mPaymentMethodsList.get(position);

        holder.mPaymentMethodLabel.setText(paymentMethod.getLabel());
        holder.mPaymentMethodGrouping.setText(paymentMethod.getGrouping().replace("_"," "));
        Glide.with(holder.itemView.getContext())
                .load(paymentMethod.getLinks().getLogo())
                .centerCrop()
                .into(holder.mPaymentMethodImage);
    }

    @Override
    public int getItemCount() {

        return mPaymentMethodsList == null ? 0 : mPaymentMethodsList.size();
    }

    public static class PaymentMethodViewHolder extends RecyclerView.ViewHolder {

        public ImageView mPaymentMethodImage;
        public TextView mPaymentMethodLabel,mPaymentMethodGrouping;

        public PaymentMethodViewHolder(@NonNull View itemView) {
            super(itemView);

            mPaymentMethodImage = itemView.findViewById(R.id.payment_image);
            mPaymentMethodLabel = itemView.findViewById(R.id.payment_label);
            mPaymentMethodGrouping = itemView.findViewById(R.id.grouping);
        }
    }
}
