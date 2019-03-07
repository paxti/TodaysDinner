package com.tverezovskyi.todaysdinner;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.Recipe;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private LinearLayoutManager mLayoutManager;
    private FirestorePagingAdapter<Recipe, ItemViewHolder> adapter;
    private Context mContext;


    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recipes) RecyclerView mChecksRecycler;
    @BindView(R.id.fab) FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mContext = this;

        Picasso.get().setIndicatorsEnabled(true);
        Picasso.get().setLoggingEnabled(true);

        mChecksRecycler.setLayoutManager(new LinearLayoutManager(this));

        mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                mChecksRecycler.getContext(),
                mLayoutManager.getOrientation());

        // mChecksRecycler.addItemDecoration(dividerItemDecoration);

        Query baseQuery = FirebaseFirestore
                .getInstance()
                .collection("recipes");

        final PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPrefetchDistance(10)
                .setPageSize(20)
                .build();

        FirestorePagingOptions<Recipe> options = new FirestorePagingOptions.Builder<Recipe>()
                .setLifecycleOwner(this)
                .setQuery(baseQuery, config, Recipe.class)
                .build();

        adapter = new FirestorePagingAdapter<Recipe, ItemViewHolder>(options) {

                @Override
                protected void onLoadingStateChanged(@NonNull LoadingState state) {
                    switch (state) {
                        case LOADING_INITIAL:
                            Log.d(TAG, "Initial load");
                        case LOADING_MORE:
                            Log.d(TAG, "Loading more");
                        case LOADED:
                            Log.d(TAG, "Loaded");
                        case ERROR:
                            // The previous load (either initial or additional) failed. Call
                            // the retry() method in order to retry the load operation.
                            // ...
                    }
                }

                    @NonNull
                    @Override
                    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item, parent, false);
                        return new ItemViewHolder(view);
                    }

                    @Override
                    protected void onBindViewHolder(@NonNull ItemViewHolder holder,
                                                    int position,
                                                    @NonNull Recipe model) {
                        model.setId(this.getItem(position).getId());
                        holder.title.setText(model.getTitle());
                        holder.subTitle.setText(model.getSubTitle());
                        Log.d(TAG, "asd  " + model.getFullImage());
                        Picasso.get()
                                .load(model.getThumbnail())
                                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                                .error(R.drawable.ic_error_outline_black_24dp)
                                .into(holder.image);
                    }
            };

        mChecksRecycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image) ImageView image;
        @BindView(R.id.title) TextView title;
        @BindView(R.id.subtitle) TextView subTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
