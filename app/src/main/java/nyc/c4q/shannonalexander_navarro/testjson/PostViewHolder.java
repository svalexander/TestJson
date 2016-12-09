package nyc.c4q.shannonalexander_navarro.testjson;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.testjson.models.Post;

/**
 * Created by shannonalexander-navarro on 12/6/16.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {
    private TextView postID;
    private TextView postTitle;
    private TextView postExcerpt;
    private TextView postDate;
    private LinearLayout layout;
    public static final String POST_INFO = "info";
    View rootView;

    public PostViewHolder(View parent) {
        super(inflateView(parent)); //needs to be the view where your data will be displayed, create an inflateView method to go with this
        rootView = itemView; //itemView is a field in the parent class, it is built in already

        layout = (LinearLayout) rootView.findViewById(R.id.activity_main);
        postID = (TextView) rootView.findViewById(R.id.postId);
        postTitle = (TextView) rootView.findViewById(R.id.titleTV);
        postExcerpt = (TextView) rootView.findViewById(R.id.excerpt);
        postDate = (TextView) rootView.findViewById(R.id.dateTV);

        postTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), PostActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    private static View inflateView(View parent) {
        //inflate the view of viewHolder, returns its to the ViewHolder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.post_holder, (ViewGroup) parent, false);
    }


    public void bind(final Post posts) {
        postID.setText(posts.getId());
        postTitle.setText(posts.getTitle());
        postExcerpt.setText(posts.getExcerpt());
        postDate.setText(posts.getDate());
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), PostActivity.class);
                intent.putExtra(POST_INFO, posts);
                rootView.getContext().startActivity(intent);
            }
        });
    }
}
