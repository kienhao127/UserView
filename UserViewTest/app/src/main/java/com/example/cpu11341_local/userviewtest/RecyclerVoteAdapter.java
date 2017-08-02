package com.example.cpu11341_local.userviewtest;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by CPU11341-local on 8/2/2017.
 */

public class RecyclerVoteAdapter extends RecyclerView.Adapter<RecyclerVoteAdapter.RecyclerViewHolder>{

    private ArrayList<UserData> arrayListUser = new ArrayList<UserData>();
    private ArrayList<VoteData> arrayListVote = new ArrayList<VoteData>();

    public RecyclerVoteAdapter(ArrayList<UserData> arrayListUser, ArrayList<VoteData> arrayListVote){
        this.arrayListUser = arrayListUser;
        this.arrayListVote = arrayListVote;
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:{
                return new ViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.top1_vote_item_layout,parent,false));
            }
            case 1:
            case 2:{
                return new ViewHolder23(LayoutInflater.from(parent.getContext()).inflate(R.layout.top23_vote_item_layout,parent,false));
            }
            default:{
                return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.vote_item_layout,parent,false));
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ViewHolder1 viewHolder0 = (ViewHolder1)holder;
                VoteData voteData1 = arrayListVote.get(position);
                UserData userData1 = new UserData();
                for (UserData u : arrayListUser){
                    if (voteData1.getUserID() == u.getUserID()){
                        userData1 = u;
                        break;
                    }
                }
                viewHolder0.textViewNumber.setText(String.valueOf(position+1));
                viewHolder0.textViewName.setText(userData1.getUserName());
                viewHolder0.imageViewAvatar.setImageResource(userData1.getImgSrc());
                viewHolder0.textViewScore.setText(String.valueOf(voteData1.getScore()));
                break;

            case 1:
            case 2:
                ViewHolder23 viewHolder2 = (ViewHolder23)holder;
                VoteData voteData23 = arrayListVote.get(position);
                UserData userData23 = new UserData();
                for (UserData u : arrayListUser){
                    if (voteData23.getUserID() == u.getUserID()){
                        userData23 = u;
                        break;
                    }
                }
                viewHolder2.textViewNumber.setText(String.valueOf(position+1));
                viewHolder2.textViewName.setText(userData23.getUserName());
                viewHolder2.imageViewAvatar.setImageResource(userData23.getImgSrc());
                viewHolder2.textViewScore.setText(String.valueOf(voteData23.getScore()));
                break;

            default:
                RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder)holder;
                VoteData voteData = arrayListVote.get(position);
                UserData userData = new UserData();
                for (UserData u : arrayListUser){
                    if (voteData.getUserID() == u.getUserID()){
                        userData = u;
                        break;
                    }
                }
                recyclerViewHolder.textViewNumber.setText(String.valueOf(position+1));
                recyclerViewHolder.textViewName.setText(userData.getUserName());
                recyclerViewHolder.imageViewAvatar.setImageResource(userData.getImgSrc());
                recyclerViewHolder.textViewScore.setText(String.valueOf(voteData.getScore()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return arrayListVote.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNumber, textViewName, textViewScore;
        ImageView imageViewStar;
        CircleImageView imageViewAvatar;
        public RecyclerViewHolder(View view) {
            super(view);

            textViewNumber = (TextView) view.findViewById(R.id.textViewNumber);
            imageViewAvatar = (CircleImageView) view.findViewById(R.id.imageViewAvatar);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
            textViewScore = (TextView) view.findViewById(R.id.textViewScore);
            imageViewStar = (ImageView) view.findViewById(R.id.imageViewStar);
        }
    }

    public static class ViewHolder1 extends RecyclerViewHolder {

        TextView textViewNumber, textViewName, textViewScore;
        ImageView imageViewStar;
        CircleImageView imageViewAvatar;
        public ViewHolder1(View view){
            super(view);
                textViewNumber = (TextView) view.findViewById(R.id.textViewNumber);
                imageViewAvatar = (CircleImageView) view.findViewById(R.id.imageViewAvatar);
                textViewName = (TextView) view.findViewById(R.id.textViewName);
                textViewScore = (TextView) view.findViewById(R.id.textViewScore);
                imageViewStar = (ImageView) view.findViewById(R.id.imageViewStar);
            }
        }

    public static class ViewHolder23 extends RecyclerViewHolder {
        TextView textViewNumber, textViewName, textViewScore;
        ImageView imageViewStar;
        CircleImageView imageViewAvatar;
        public ViewHolder23(View view) {
            super(view);textViewNumber = (TextView) view.findViewById(R.id.textViewNumber);
            imageViewAvatar = (CircleImageView) view.findViewById(R.id.imageViewAvatar);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
            textViewScore = (TextView) view.findViewById(R.id.textViewScore);
            imageViewStar = (ImageView) view.findViewById(R.id.imageViewStar);
        }
    }
}


