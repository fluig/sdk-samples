package sdk.fluig.com.example.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.model.ListItemType;

public class MainFragment extends Fragment {

    private static final String ARG_LIST = "MainFragment.List";

    private RecyclerView mRecyclerView;

    private ListItemType[] mList;

    private Listener mListener;

    //region Factory
    public static MainFragment newInstance(ListItemType... params) {
        Bundle args = new Bundle();
        args.putParcelableArray(ARG_LIST, params);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }
    //endregion

    //region Constructors
    public MainFragment() {}
    //endregion

    //region Lifecycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mList = (ListItemType[]) getArguments().getParcelableArray(ARG_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Listener) {
            mListener = (Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    //endregion

    //region Interface
    public interface Listener {
        void onClickItem(ListItemType itemType);
    }
    //endregion
}
