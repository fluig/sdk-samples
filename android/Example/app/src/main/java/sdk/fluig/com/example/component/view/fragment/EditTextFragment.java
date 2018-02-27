package sdk.fluig.com.example.component.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sdk.fluig.com.example.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {

    public static final String TAG = EditTextFragment.class.getSimpleName();

    public EditTextFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_text, container, false);
    }
}
