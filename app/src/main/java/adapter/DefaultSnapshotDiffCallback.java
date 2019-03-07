package adapter;

import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import com.firebase.ui.firestore.SnapshotParser;

/**
 * Created by psyfu on 2/7/2019.
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public class DefaultSnapshotDiffCallback<T> extends DiffUtil.ItemCallback<DocumentSnapshot> {
    private final SnapshotParser<T> mParser;

    public DefaultSnapshotDiffCallback(@NonNull SnapshotParser<T> parser) {
        mParser = parser;
    }

    @Override
    public boolean areItemsTheSame(@NonNull DocumentSnapshot oldItem,
                                   @NonNull DocumentSnapshot newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull DocumentSnapshot oldItem,
                                      @NonNull DocumentSnapshot newItem) {
        T oldModel = mParser.parseSnapshot(oldItem);
        T newModel = mParser.parseSnapshot(newItem);

        return oldModel.equals(newModel);
    }
}
