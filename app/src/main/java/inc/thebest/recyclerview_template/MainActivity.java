package inc.thebest.recyclerview_template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView mHorizonatalRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mHorizontalLayoutManager;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //Code for Horizontal RecyclerView
        mHorizonatalRecyclerView = findViewById(R.id.horizontal_recycler_view);
        mHorizontalLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        //Code For Vertical RecyclerView
        mRecyclerView = findViewById(R.id.recycler_view);
        movieAdapter = new MovieAdapter(movieList, MainActivity.this);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());

        //Adding RecyclerView Divider/Separator
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));




        /**
         * Code for Displaying Horizontal Scrolling RecyclerView
         *
         * keep movie_list_row.xml width to `wrap_content`
         */
        //mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);


        mHorizonatalRecyclerView.setAdapter(movieAdapter);
        mHorizonatalRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHorizonatalRecyclerView.setLayoutManager(mHorizontalLayoutManager);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(movieAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareMovieData();
    }

    //This method adds sample data to RecyclerView
    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        movieAdapter.notifyDataSetChanged();
    }
}
