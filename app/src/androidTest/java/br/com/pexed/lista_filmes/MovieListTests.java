package br.com.pexed.lista_filmes;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import br.com.pexed.lista_filmes.model.Movie;
import br.com.pexed.lista_filmes.view.MovieListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MovieListTests {

    @Rule
    public ActivityTestRule<MovieListActivity> mActivityRule = new ActivityTestRule<>(
            MovieListActivity.class);


    @Test
    public void whenLoadingListEmpty_thenLoadedListPopulated() throws Exception{
        List<Movie> list = mActivityRule.getActivity().getViewModel().getMovies().getValue();
        assert list == null;
        //Waiting for request
        Thread.sleep(1500);
        //Check list populated
        list = mActivityRule.getActivity().getViewModel().getMovies().getValue();
        assert list.size() > 0;
    }
}
