package com.example.admin.allofferstesapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*
(Custom adapter) created by Anjana
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<NewOffers> moviesList;

    // Complex data items may need more than one view per item, and
    // access to all the views for a data item in a view holder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
           image = (ImageView) view.findViewById(R.id.image);
            text = (TextView) view.findViewById(R.id.text);

        }
    }

    // constructor (depends on the kind of dataset)
    public MyAdapter(List<NewOffers> moviesList) {
        this.moviesList = moviesList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_list_view, parent, false);

        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewOffers movie = moviesList.get(position);
        holder.image.setImageBitmap(movie.getImage());
        holder.text.setText(movie.getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
