package sdk.fluig.com.example.component.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sdk.fluig.com.example.R;
import sdk.fluig.com.ui.components.thumb.FluigSdkProfileThumb;

/**
 * Created by gregorysholl on 13/03/18.
 */

public class ProfileThumbFragment extends Fragment {

    public static final String TAG = ProfileThumbFragment.class.getSimpleName();

    //region Constructors
    public ProfileThumbFragment() {}
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
        Context context = getContext();

        FluigSdkProfileThumb profileThumb = new FluigSdkProfileThumb(context);
        profileThumb.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        profileThumb.setImageResource(R.drawable.doge);
        profileThumb.setBorderColor(Color.BLACK);
        profileThumb.setBorderColorEnd(Color.RED);

        LinearLayout linearLayout = view.findViewById(R.id.componentFragment_container);
        linearLayout.addView(profileThumb);
    }

    private void setupTextView(View view) {
        String text = "profileThumb.setImageResource(R.drawable.doge);\n" +
                "profileThumb.setBorderColor(Color.BLACK);\n" +
                "profileThumb.setBorderColor(Color.RED);\n\n";

        text = text +
                "<sdk.fluig.com.ui.components.thumb.FluigSdkProfileThumb\n" +
                "    android:layout_width=\"100dp\"\n" +
                "    android:layout_height=\"100dp\">\n" +
                "    android:src=\"@drawable/doge\"\n" +
                "    app:borderColor=\"@color/black\"\n" +
                "    app:borderColorEnd=\"@color/red\" />\n";

        TextView textView = view.findViewById(R.id.componentFragment_textView);
        textView.setText(text);
    }
    //endregion
}
