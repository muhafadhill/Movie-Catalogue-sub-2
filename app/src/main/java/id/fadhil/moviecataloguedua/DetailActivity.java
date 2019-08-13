package id.fadhil.moviecataloguedua;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movies";
    private TextView tvTitle, tvRelease, tvOverview, tvGenre;
    private ImageView imgPoster;

    private TextView tvVote;
    @BindViews({
            R.id.img_star1,
            R.id.img_star2,
            R.id.img_star3,
            R.id.img_star4,
            R.id.img_star5
    })
    List<ImageView> img_votes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ButterKnife.bind(this);
        initView();

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        imgPoster.setImageResource(movie.getPhoto());
        tvTitle.setText(movie.getTitle());
        tvRelease.setText(movie.getRelease());
        tvGenre.setText(movie.getGenre());
        tvOverview.setText(movie.getDescription());
        tvVote.setText(String.valueOf(movie.getRating()));

        double userRating = Double.parseDouble(movie.getRating());
        double usRating = userRating / 2;
        int integerPart = (int) usRating;
        for (int i = 0; i < integerPart; i++) {
            img_votes.get(i).setImageResource(R.drawable.ic_star_black_24dp);
        }

        // Fill half star
        if (Math.round(usRating) > integerPart) {
            img_votes.get(integerPart).setImageResource(R.drawable.ic_star_half_black);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void initView() {
        tvTitle = findViewById(R.id.tv_title);
        imgPoster = findViewById(R.id.img_poster);
        tvVote = findViewById(R.id.tv_vote);
        tvRelease = findViewById(R.id.tv_release_date);
        tvGenre = findViewById(R.id.tv_genres);
        tvOverview = findViewById(R.id.tv_overview);
    }
}
