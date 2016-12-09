package nyc.c4q.shannonalexander_navarro.testjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;

import nyc.c4q.shannonalexander_navarro.testjson.models.AllPosts;
import nyc.c4q.shannonalexander_navarro.testjson.network.PostService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String WP_BASE_URL = "http://www.washingtonpost.com/";
    private static final String TAG = MainActivity.class.getSimpleName();

    RecyclerView recyclerView;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter();
        recyclerView.setAdapter(postAdapter);

        getThePostsFromRetrofit();
    }

    private void getThePostsFromRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostService service = retrofit.create(PostService.class);

        Call<AllPosts> call = service.getPosts();

        call.enqueue(new Callback<AllPosts>() {
            @Override
            public void onResponse(Call<AllPosts> call, Response<AllPosts> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success: " + response.body().getPosts());
                    postAdapter.setAllPosts(response.body().getPosts());
                } else {
                    try {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<AllPosts> call, Throwable t) {
                Log.e("WGY", "IFIGII");
            }
        });
    }
}
