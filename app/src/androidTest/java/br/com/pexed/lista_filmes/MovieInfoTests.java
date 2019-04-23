package br.com.pexed.lista_filmes;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import br.com.pexed.lista_filmes.model.Movie;
import br.com.pexed.lista_filmes.view.MovieInfoActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MovieInfoTests {

    private Movie movie;

    @Rule
    public ActivityTestRule<MovieInfoActivity> mActivityRule = new ActivityTestRule<>(
            MovieInfoActivity.class,
            false,
            false);

    @Before
    public void init(){
        movie = new Movie(
                "Title Test",
                "Overview Test",
                "1h20m",
                "2018",
                "http://test.com/test.jpg",
                new ArrayList<String>(),
                "123");
    }


    @Test
    public void whenIntentWithMovie_thenTextViewsPopulated() {
        Intent intent = new Intent();
        // intent stuff
        intent.putExtra("MOVIE", movie);
        mActivityRule.launchActivity(intent);
        onView(withId(R.id.tvInfoTitle)).check(matches(withText(movie.getTitle())));
        onView(withId(R.id.tvInfoDuration)).check(matches(withText(movie.getDuration())));
        onView(withId(R.id.tvInfoOverview)).check(matches(withText(movie.getOverview())));
        onView(withId(R.id.tvInfoReleaseYear)).check(matches(withText(movie.getReleaseYear())));
    }

}
