package com.mercari.mercaritest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercari.mercaritest.data.model.SellItems;

import java.util.List;

/**
 * Created by ssavdekar on 4/29/18.
 */

public class SellItemsAdapter extends RecyclerView.Adapter<SellItemsAdapter.MyViewHolder>{
    private List<SellItems> sellItemsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTextView);
            price = (TextView) view.findViewById(R.id.priceTextView);
            photo = (ImageView) view.findViewById(R.id.itemImageView);
        }
    }


    public SellItemsAdapter(List<SellItems> sellItemsList) {
        this.sellItemsList = sellItemsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SellItems item = sellItemsList.get(position);
        holder.name.setText(item.getName());
        holder.price.setText(String.valueOf(item.getPrice()));
        ImageDownloader downloader = new ImageDownloader();
        downloader.setImage(item.getPhoto(), holder.photo);
    }

    @Override
    public int getItemCount() {
        return sellItemsList.size();
    }
}
