package com.prakash.recyclerviewstaggered;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class RecyclerViewStaggered extends RecyclerView.Adapter<RecyclerViewStaggered.ViewHolder>{

    private static final String TAG="RecyclerViewStaggered";

    private ArrayList<String> mNames= new ArrayList<>();
    private ArrayList<String> mImageUrls= new ArrayList<>();
    private Context mContext;

    public RecyclerViewStaggered(ArrayList<String> mNames, ArrayList<String> mImageUrls, Context mContext) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
       .layout_grid_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder:called ");

        RequestOptions requestOptions= new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);


        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.image);
        holder.name.setText(mNames.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name;

    public ViewHolder(View itemView) {
        super(itemView);
        this.image= itemView.findViewById(R.id.imageAdapter);
        this.name= itemView.findViewById(R.id.nameAdapter);

    }
}

}



