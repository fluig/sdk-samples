package sdk.fluig.com.example.component.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sdk.fluig.com.example.R;
import sdk.fluig.com.ui.components.edittext.FluigSdkEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {

    public static final String TAG = EditTextFragment.class.getSimpleName();

    //region Constructors
    public EditTextFragment() {}
    //endregion

    //region Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_component, container, false);

        setupView(view);

        return view;
    }
    //endregion

    //region Setups
    private void setupView(View view) {
        if (view == null) {
            return;
        }

        setupComponent(view);
        setupTextView(view);
    }

    private void setupComponent(View view) {
        FluigSdkEditText editText = new FluigSdkEditText(getContext());
        editText.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        editText.setHint("Hint");
        editText.setHintTextColor(Color.BLUE);
        editText.setIcon(R.drawable.ic_account);
        editText.showValidState();

        LinearLayout linearLayout = view.findViewById(R.id.componentFragment_container);
        linearLayout.addView(editText);
    }

    private void setupTextView(View view) {
        String text = "editText.setHint(\"Hint\");\n" +
                "editText.setHintTextColor(Color.BLUE);\n" +
                "editText.setIcon(R.drawable.ic_account);\n" +
                "editText.showValidState();\n\n";

        text = text +
                "<sdk.fluig.com.ui.components.edittext.FluigSdkEditText\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    android:hint=\"Hint\"\n" +
                "    android:textColorHint=\"@color/blue\"\n" +
                "    app:icon=\"@drawable/ic_account\" />\n";

        TextView textView = view.findViewById(R.id.componentFragment_textView);
        textView.setText(text);
    }
    //endregion
}
