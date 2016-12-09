package nyc.c4q.shannonalexander_navarro.testjson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.testjson.models.Post;

import static nyc.c4q.shannonalexander_navarro.testjson.PostViewHolder.POST_INFO;

public class PostActivity extends AppCompatActivity {

    private TextView titleTV;
    private TextView dateTV;
    private TextView idTV;
    private TextView contentTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Intent intent = getIntent();
        Post post = (Post) intent.getSerializableExtra(POST_INFO);
        titleTV = (TextView) findViewById(R.id.titleTVTwo);
        dateTV = (TextView) findViewById(R.id.dateTVTwo);
        idTV = (TextView) findViewById(R.id.postIdTwo);
        titleTV.setText(post.getTitle());
        dateTV.setText(post.getDate());
        idTV.setText(post.getId());

        contentTV = (TextView) findViewById(R.id.content);
        contentTV.setText(post.getContent());
    }
}
