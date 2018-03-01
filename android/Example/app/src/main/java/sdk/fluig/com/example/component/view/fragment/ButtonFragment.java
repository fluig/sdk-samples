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
import sdk.fluig.com.ui.components.button.FluigSdkButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    public static final String TAG = ButtonFragment.class.getSimpleName();

    //region Constructors
    public ButtonFragment() {}
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
        FluigSdkButton button = new FluigSdkButton(getContext());
        button.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        button.setText("OK");
        button.setBackgroundColor(Color.BLUE);
        button.setBackgroundColorEnd(Color.MAGENTA);
        button.setCornerless(true);

        LinearLayout linearLayout = view.findViewById(R.id.componentFragment_container);
        linearLayout.addView(button);
    }

    private void setupTextView(View view) {
        String text = "button.setText(\"OK\");\n" +
                "button.setBackgroundColor(Color.BLUE);\n" +
                "button.setBackgroundColorEnd(Color.MAGENTA);\n" +
                "button.setCornerless(true);\n\n";

        text = text +
                "<sdk.fluig.com.ui.components.button.FluigSdkButton\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    android:background=\"@color/blue\"\n" +
                "    app:backgroundColor_end=\"@color/magenta\"\n" +
                "    app:cornerless=\"true\" />";

        TextView textView = view.findViewById(R.id.componentFragment_textView);
        textView.setText(text);
    }
    //endregion
}
