package saul.example.com.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.jar.JarException;

/**
 * Created by saul on 2/10/18.
 */

public class Movie {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public boolean isVideo() {
        return video;
    }

    String posterPath;
    String originalTitle;
    String overview;

    int voteCount;
    double voteAverage;
    double popularity;
    String backdropPath;
    boolean video;


    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath=jsonObject.getString("poster_path");
        this.originalTitle=jsonObject.getString("original_title");
        this.overview=jsonObject.getString("overview");

        this.voteCount=jsonObject.getInt("vote_count");
        this.voteAverage=jsonObject.getDouble("vote_average");
        this.popularity=jsonObject.getDouble("popularity");
        this.backdropPath=jsonObject.getString("backdrop_path");
        this.video=jsonObject.getBoolean("video");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results=new ArrayList<>();

        for(int i=0;i<array.length();i++){
            try{
                results.add(new Movie(array.getJSONObject(i)));
            }catch (JSONException e){
                e.printStackTrace();
            }


        }
        return results;
    }
}
