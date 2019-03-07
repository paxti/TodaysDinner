package adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.LoadingState;
import com.squareup.picasso.Picasso;
import com.tverezovskyi.todaysdinner.MainActivity;
import com.tverezovskyi.todaysdinner.R;
import com.tverezovskyi.todaysdinner.RecipeDetailsActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.Recipe;


/**
 * Created by psyfu on 2/7/2019.
 */
public class FirestoreAdapter extends FirestorePagingAdapter<Recipe, FirestoreAdapter.ItemViewHolder> {
    private static final String TAG = "FirestoreAdapter";

    /**
     * Construct a new FirestorePagingAdapter from the given {@link FirestorePagingOptions}.
     *
     * @param options
     */
    public FirestoreAdapter(@NonNull com.firebase.ui.firestore.paging.FirestorePagingOptions<Recipe> options) {
        super(options);
    }

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

    @Override
    protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull Recipe recipe) {
        recipe.setId(this.getItem(position).getId());
        holder.title.setText(recipe.getTitle());
        holder.subTitle.setText(recipe.getSubTitle());
        Picasso.get()
                .load(recipe.getThumbnail())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .error(R.drawable.ic_error_outline_black_24dp)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RecipeDetailsActivity.class);
                intent.putExtra("DATA", "asdasd");
                view.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
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
