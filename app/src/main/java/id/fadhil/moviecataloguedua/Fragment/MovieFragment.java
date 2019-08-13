package id.fadhil.moviecataloguedua.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.fadhil.moviecataloguedua.Movie;
import id.fadhil.moviecataloguedua.MovieAdapter;
import id.fadhil.moviecataloguedua.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvmovies;
    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataRating;
    private String[] dataRelease;
    private String[] dataDuration;
    private String[] dataGenre;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        rvmovies = view.findViewById(R.id.rv_movie);

        prepare();
        addItem();

        return view;
    }


    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataDuration = getResources().getStringArray(R.array.data_runtime);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataRelease = getResources().getStringArray(R.array.data_release);
        dataGenre = getResources().getStringArray(R.array.data_genre);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setRating(dataRating[i]);
            movie.setRuntime(dataDuration[i]);
            movie.setRelease(dataRelease[i]);
            movie.setGenre(dataGenre[i]);
            movies.add(movie);
        }
        rvmovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MovieAdapter(getActivity(), movies);
        rvmovies.setAdapter(adapter);

    }

}
