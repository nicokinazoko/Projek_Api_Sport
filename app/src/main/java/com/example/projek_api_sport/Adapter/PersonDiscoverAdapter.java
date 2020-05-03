package com.example.projek_api_sport.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projek_api_sport.Model.Person.PersonDiscoverResultSportsItem;
import com.example.projek_api_sport.R;

import java.util.ArrayList;

public class PersonDiscoverAdapter extends RecyclerView.Adapter<PersonDiscoverAdapter.ViewHolder> {

    private ArrayList <PersonDiscoverResultSportsItem> personDiscoverResultSportsItems      =   new ArrayList<>();

    private Context context;

    private String BASE_IMAGE_URL                                                           =   "";

    public PersonDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<PersonDiscoverResultSportsItem> items)
    {
        personDiscoverResultSportsItems.clear();
        personDiscoverResultSportsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view                                                                           =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context)
                .load(personDiscoverResultSportsItems
                        .get(position)
                        .getStrSportThumb())
                .into(holder.imageViewThumbnail);

        holder.textViewSportTitle.setText(personDiscoverResultSportsItems.get(position).getStrSport().toString());

        holder.textViewSportFormat.setText(personDiscoverResultSportsItems.get(position).getStrFormat().toString());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewThumbnail;
        TextView textViewSportTitle,textViewSportFormat;
        CardView cardViewItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewThumbnail                                                              =   itemView.findViewById(R.id.itemlist_imageview_thumbnail_person);
            textViewSportTitle                                                              =   itemView.findViewById(R.id.itemlist_sport_title);
            textViewSportFormat                                                             =   itemView.findViewById(R.id.itemlist_sport_format);
            cardViewItem                                                                    =   itemView.findViewById(R.id.itemlist_cardview_person);
        }
    }
}
