package sdk.fluig.com.example.component.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sdk.fluig.com.example.R;
import sdk.fluig.com.ui.components.edittext.FluigSdkEditText;
import sdk.fluig.com.ui.components.edittext.FluigSdkGroupText;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupTextFragment extends Fragment {

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

        FluigSdkGroupText groupText = new FluigSdkGroupText(context);
        groupText.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        for (int i = 0; i < 3; i++) {
            FluigSdkEditText editText = new FluigSdkEditText(context);
            editText.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            editText.setHint("Edit text " + (i+1));

            groupText.addView(editText);
        }

        LinearLayout linearLayout = view.findViewById(R.id.componentFragment_container);
        linearLayout.addView(groupText);
    }

    private void setupTextView(View view) {
        String text = "groupText.addView(editText);\n\n";

        text = text +
                "<sdk.fluig.com.ui.components.edittext.FluigSdkGroupText\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\">\n" +
                "        <sdk.fluig.com.ui.components.edittext.FluigSdkEditText\n" +
                "            ... />\n" +
                "        ...\n" +
                "</sdk.fluig.com.ui.components.edittext.FluigSdkGroupText>\n";

        TextView textView = view.findViewById(R.id.componentFragment_textView);
        textView.setText(text);
    }
    //endregion
}
