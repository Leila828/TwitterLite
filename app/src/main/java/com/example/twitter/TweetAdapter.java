package com.example.twitter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TweetAdapter extends ArrayAdapter {
    List<Tweet> tweet;
    public TweetAdapter( Context context, List<Tweet> tweets) {
        super(context,0,tweets);
        tweet=tweets;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//LayoutInflater : Instancie un fichier XML de mise en page dans les objets
      if (convertView ==null){
          convertView=LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
      }
      tweetViewHolder viewHolder=(tweetViewHolder) convertView.getTag();
      if (viewHolder==null){

          viewHolder=new tweetViewHolder();
          viewHolder.name=(TextView) convertView.findViewById(R.id.titre);
          viewHolder.content=(TextView) convertView.findViewById(R.id.text);
          viewHolder.IdImage=(ImageView) convertView.findViewById(R.id.image);
          convertView.setTag(viewHolder);  }
         Tweet tweet= (Tweet) getItem(position);

    viewHolder.name.setText(tweet.name);
    viewHolder.content.setText(tweet.content);
    viewHolder.IdImage.setImageResource(tweet.IdImage);

        return convertView;

    }

}
