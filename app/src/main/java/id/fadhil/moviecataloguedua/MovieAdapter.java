package id.fadhil.moviecataloguedua;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {
    private ArrayList<Movie> movies;
    Context context;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ListViewHolder listViewHolder, final int i) {
        final Movie movie = movies.get(i);
        Glide.with(context)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(100, 150))
                .into(listViewHolder.imgPhoto);
        listViewHolder.txtRating.setText(movie.getRating());
        listViewHolder.txtTitle.setText(movie.getTitle());
        listViewHolder.txtDescription.setText(movie.getDescription());
        listViewHolder.txtRelease.setText(movie.getRelease());
        listViewHolder.txtDuration.setText(movie.getRuntime());


        listViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtDescription;
        TextView txtRating;
        ImageView imgPhoto;
        TextView txtRelease;
        TextView txtDuration;
        CardView cardView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtRating = itemView.findViewById(R.id.txt_rating);
            txtDuration = itemView.findViewById(R.id.txt_duration);
            txtDescription = itemView.findViewById(R.id.txt_description);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            txtRelease = itemView.findViewById(R.id.txt_release);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
