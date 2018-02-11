package saul.example.com.flicks.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import saul.example.com.flicks.R;
import saul.example.com.flicks.models.Movie;

/**
 * Created by saul on 2/10/18.
 */

public class MovieAdapter extends ArrayAdapter<Movie>{

    public MovieAdapter(Context context, List<Movie> movies){
        super(context,android.R.layout.simple_list_item_1,movies);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Movie movie=getItem(position);
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_movie,parent,false);
        }

        ImageView ivImage=(ImageView)convertView.findViewById(R.id.idMovieImage);
        ImageView ivImageLand=(ImageView)convertView.findViewById(R.id.idMovieImageLande);
        ivImage.setImageResource(0);
        ivImageLand.setImageResource(0);

        TextView tvTitle=(TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview=(TextView)convertView.findViewById(R.id.tvOverview);
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImageLand);
        return convertView;
    }
}
