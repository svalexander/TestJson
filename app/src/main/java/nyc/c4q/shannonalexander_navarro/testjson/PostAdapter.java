package nyc.c4q.shannonalexander_navarro.testjson;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.testjson.models.Post;

/**
 * Created by shannonalexander-navarro on 12/6/16.
 */

public class PostAdapter extends RecyclerView.Adapter {

    private List<Post> allPosts = new ArrayList<>();

    public PostAdapter() {
        allPosts = new ArrayList<>();
    }

    public PostAdapter(List<Post> posts) {
        this.allPosts = posts;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        PostViewHolder viewHolder = (PostViewHolder) holder;
        Post post = allPosts.get(position);
        viewHolder.bind(post);

    }

    @Override
    public int getItemCount() {
        return allPosts.size();
    }

    public void setAllPosts(List<Post> mallPosts) {
        allPosts.clear();
        allPosts.addAll(mallPosts);
        notifyDataSetChanged();
    }
}
