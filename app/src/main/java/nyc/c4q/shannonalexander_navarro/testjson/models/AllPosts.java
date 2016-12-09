
package nyc.c4q.shannonalexander_navarro.testjson.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllPosts {

    @SerializedName("posts")
    @Expose
    public List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }
}
