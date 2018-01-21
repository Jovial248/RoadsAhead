package com.example.mypc.frider.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mypc.frider.R;
import com.example.mypc.frider.model.ProductObject;

import java.util.List;


public class CheckRecyclerViewAdapter extends RecyclerView.Adapter<CheckRecyclerViewHolder> {

    private Context context;

    private List<ProductObject> mProductObject;


    public CheckRecyclerViewAdapter(Context context, List<ProductObject> mProductObject) {
        this.context = context;
        this.mProductObject = mProductObject;
    }

    @Override
    public CheckRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_layout, parent, false);
        CheckRecyclerViewHolder productHolder = new CheckRecyclerViewHolder(layoutView);
        return productHolder;
    }

    @Override
    public void onBindViewHolder(CheckRecyclerViewHolder holder, final int position) {
        //get product quantity
        holder.quantity.setText("1");
        holder.productName.setText(mProductObject.get(position).getProductName());
        holder.productPrice.setText(String.valueOf(mProductObject.get(position).getPrize()) + " $");

        holder.removeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Do you want to remove product from cart", Toast.LENGTH_LONG).show();

                mProductObject.remove(position);

                notifyItemRemoved(position);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mProductObject.size();
    }
}
