package com.lemon.data.remote.api;

import com.lemon.data.remote.pojo.movie.detail.MovieDetail;
import com.lemon.data.remote.pojo.movie.find.MovieFindResponse;
import com.lemon.data.remote.pojo.person.detail.PersonDetail;
import com.lemon.data.remote.pojo.person.find.PersonFindResponse;
import com.lemon.data.remote.pojo.tvshow.detail.TvShowDetail;
import com.lemon.data.remote.pojo.tvshow.find.TvShowFindResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit {@link Retrofit} Api service interface
 */
public interface TMDbApi {

    String BASE_URL = "https://api.themoviedb.org/";
    String IMAGES_URL = "https://image.tmdb.org/t/p/";

    /**
     * Perform Api request to get movie details
     *
     * @param apiVersion - a version of api request
     * @param movieId    - a movie id
     * @param key        - a key for api request
     * @param language   - a language by default
     * @param additional - additional arguments for api request
     * @return {@link Single} of movie details {@link MovieDetail}
     */
    @GET("{api_version}/movie/{movie_id}")
    Single<MovieDetail> getMovieDetails(@Path("api_version") final int apiVersion,
                                        @Path("movie_id") final int movieId,
                                        @Query("api_key") final String key,
                                        @Query("language") final String language,
                                        @Query("append_to_response") final String additional);

    /**
     * Perform Api request to get tv show details
     *
     * @param apiVersion - a version of api request
     * @param tvShowId-  a tv show id
     * @param key        - a key for api request
     * @param language   - a language by default
     * @param additional - additional arguments for api request
     * @return {@link Single} of tv show details {@link TvShowDetail}
     */
    @GET("{api_version}/tv/{tv_id}")
    Single<TvShowDetail> getTvShowDetails(@Path("api_version") final int apiVersion,
                                          @Path("tv_id") final int tvShowId,
                                          @Query("api_key") final String key,
                                          @Query("language") final String language,
                                          @Query("append_to_response") final String additional);

    /**
     * Perform Api request to get person details
     *
     * @param apiVersion - a version of api request
     * @param personId - a person id
     * @param key - a key for api request
     * @param language - a language by default
     * @param additional - additional arguments for api request
     * @return {@link Single} of person details {@link PersonDetail}
     */
    @GET("{api_version}/person/{person_id}")
    Single<PersonDetail> getPersonDetails(@Path("api_version") final int apiVersion,
                                          @Path("person_id") final int personId,
                                          @Query("api_key") final String key,
                                          @Query("language") final String language,
                                          @Query("append_to_response") final String additional);

    /**
     * Perform Api request for search movies
     *
     * @param apiVersion - a version of api request
     * @param key - a key for api request
     * @param language - a language by default
     * @param query - a string search query
     * @param page - a page number
     * @param isAdult - shows adult contents
     * @return {@link Single} of movie search results {@link MovieFindResponse}
     */
    @GET("{api_version}/search/movie")
    Single<MovieFindResponse> searchMovies(@Path("api_version") final int apiVersion,
                                           @Query("api_key") final String key,
                                           @Query("language") final String language,
                                           @Query("query") final String query,
                                           @Query("page") final int page,
                                           @Query("include_adult") final boolean isAdult);

    /**
     * Perform Api request for search tv shows
     *
     * @param apiVersion - a version of api request
     * @param key - a key for api request
     * @param language - a language by default
     * @param query - a string search query
     * @param page - a page number
     * @param isAdult - shows adult contents
     * @return {@link Single} of tv show search results {@link TvShowFindResponse}
     */
    @GET("{api_version}/search/tv")
    Single<TvShowFindResponse> searchTvShows(@Path("api_version") final int apiVersion,
                                             @Query("api_key") final String key,
                                             @Query("language") final String language,
                                             @Query("query") final String query,
                                             @Query("page") final int page,
                                             @Query("include_adult") final boolean isAdult);

    /**
     * Perform Api request for search persons
     *
     * @param apiVersion - a version of api request
     * @param key - a key for api request
     * @param language - a language by default
     * @param query - a string search query
     * @param page - a page number
     * @param isAdult - shows adult contents
     * @return {@link Single} of person search results {@link PersonFindResponse}
     */
    @GET("{api_version}/search/person")
    Single<PersonFindResponse> searchPersons(@Path("api_version") final int apiVersion,
                                             @Query("api_key") final String key,
                                             @Query("language") final String language,
                                             @Query("query") final String query,
                                             @Query("page") final int page,
                                             @Query("include_adult") final boolean isAdult);

    /**
     * Perform Api request to get popular movies
     *
     * @param apiVersion - a version of api request
     * @param key - a key for api request
     * @param language - a language by default
     * @param page - a page number
     * @return {@link Single} of popular movie results {@link MovieFindResponse}
     */
    @GET("{api_version}/movie/popular")
    Single<MovieFindResponse> getPopularMovies(@Path("api_version") final int apiVersion,
                                               @Query("api_key") final String key,
                                               @Query("language") final String language,
                                               @Query("page") final int page);

    /**
     * Perform Api request to get popular tv shows
     *
     * @param apiVersion - a version of api request
     * @param key - a key for api request
     * @param language - a language by default
     * @param page - a page number
     * @return {@link Single} of popular tv shows results {@link TvShowFindResponse}
     */
    @GET("{api_version}/tv/popular")
    Single<TvShowFindResponse> getPopularTvShows(@Path("api_version") final int apiVersion,
                                                 @Query("api_key") final String key,
                                                 @Query("language") final String language,
                                                 @Query("page") final int page);

    /**
     * Perform Api request to get popular persons
     *
     * @param apiVersion - a version of api request
     * @param key - a key for api request
     * @param language - a language by default
     * @param page - a page number
     * @return {@link Single} of popular person results {@link PersonFindResponse}
     */
    @GET("{api_version}/person/popular")
    Single<PersonFindResponse> getPopularPersons(@Path("api_version") final int apiVersion,
                                                 @Query("api_key") final String key,
                                                 @Query("language") final String language,
                                                 @Query("page") final int page);
}
