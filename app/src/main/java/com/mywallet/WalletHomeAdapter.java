package com.mywallet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by admin on 03-May-18.
 */

public class WalletHomeAdapter extends RecyclerView.Adapter<WalletHomeAdapter.WalletViewHolder> {
    private Context context;
    ArrayList<WalletModel> walletModels_list = new ArrayList<>();

    public WalletHomeAdapter(Context context, ArrayList<WalletModel> walletModels_list) {
        this.context = context;
        this.walletModels_list = walletModels_list;
        notifyDataSetChanged();
    }


    @Override
    public WalletViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wallet_list_details, parent, false);
        WalletViewHolder contactViewHolder = new WalletViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(WalletViewHolder holder, int position) {
        holder.WalletName.setText(walletModels_list.get(position).getWallet_name());
        holder.WalletImage.setImageResource(walletModels_list.get(position).getWallet_image());

        // Picasso.with(context).load(Image_resource).resize(40, 40).into(holder.WalletImage);

    }

    @Override
    public int getItemCount() {
        return walletModels_list.size();
    }

    public class WalletViewHolder extends RecyclerView.ViewHolder {
        public TextView WalletName;
        public ImageView WalletImage;

        public WalletViewHolder(View itemView) {
            super(itemView);
            WalletName = (TextView) itemView.findViewById(R.id.name);
            WalletImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
