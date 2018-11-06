package com.example.storm.stormreview.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.storm.stormreview.R;

import java.util.ArrayList;
import java.util.List;

import Adapters.UserAdapter;
import Models.User;
import Services.ApiClient;
import Services.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamProgressActivity extends AppCompatActivity {
    private List<User> usersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ProgressDialog progressDoalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_progress);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

       /* progressDoalog = new ProgressDialog(TeamProgressActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();*/

        /*Create handle for the RetrofitInstance interface*/
       /* UserClient service = ApiClient.getClient().create(UserClient.class);
        Call<List<User>> call = service.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressDoalog.dismiss();
                mAdapter = new UserAdapter(response.body(), TeamProgressActivity.this);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(TeamProgressActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }


        });
*/

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

        recyclerView.setHasFixedSize(true);
        mAdapter = new UserAdapter(usersList, TeamProgressActivity.this);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        prepareUsersData();

    }


    private void prepareUsersData() {

        User user = new User("Tamer", 1, "email", 300);
        usersList.add(user);

        User user1 = new User("Rayhane", 2, "email", 200);
        usersList.add(user1);

        User user2 = new User("Oluchi", 3, "email", 145);
        usersList.add(user2);

        User user3 = new User("Mikhail", 4, "email", 120);
        usersList.add(user3);

        User user4 = new User("Phuong", 5, "email", 80);
        usersList.add(user4);

        User user5 = new User("Shujun", 6, "email", 45);
        usersList.add(user5);

        User user6 = new User("Storm", 7, "email", 31);
        usersList.add(user6);

        mAdapter.notifyDataSetChanged();
    }
}
