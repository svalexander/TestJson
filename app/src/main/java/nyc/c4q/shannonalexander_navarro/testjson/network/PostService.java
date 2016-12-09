package nyc.c4q.shannonalexander_navarro.testjson.network;

import nyc.c4q.shannonalexander_navarro.testjson.models.AllPosts;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shannonalexander-navarro on 12/7/16.
 */

public interface PostService {
    @GET("wp-srv/simulation/simulation_test.json")
    Call<AllPosts> getPosts();

}
