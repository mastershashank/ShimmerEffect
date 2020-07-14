package com.shimmer.shimmereffect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    private ArrayList<ShimmerModel> list;
    boolean showShimmer = true;
    private Context context;

    //Constructor


    public RecyclerViewAdaptor(ArrayList<ShimmerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shimmer_model_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (showShimmer) {
            holder.shimmerFrameLayout.startShimmer();
        } else {
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);

            holder.tvtitle.setBackground(null);
            holder.tvtitle.setText(list.get(position).getTitle());

            holder.tvdesc.setBackground(null);
            holder.tvdesc.setText(list.get(position).getDescription());

            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background));
        }

    }

    @Override
    public int getItemCount() {
        int SHIMMER_ITEM_NUMBER = 10;
        return showShimmer ? SHIMMER_ITEM_NUMBER : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ShimmerFrameLayout shimmerFrameLayout;
        TextView tvtitle, tvdesc;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmerLayout);
            tvtitle = itemView.findViewById(R.id.modelTitle);
            tvdesc = itemView.findViewById(R.id.modelDesc);
            imageView = itemView.findViewById(R.id.modelImage);
        }
    }
}
