package sdk.fluig.com.example.component.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sdk.fluig.com.example.R;
import sdk.fluig.com.ui.components.mediaview.FluigSdkMediaView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MediaViewFragment extends Fragment {

    //region Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_media_view, container, false);

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
        FluigSdkMediaView mediaView = view.findViewById(R.id.mediaViewFragment_component);
        mediaView.setVideo(R.raw.video_background);
    }

    private void setupTextView(View view) {
        String text = "mediaView.setVideo(R.raw.video_background);\n\n";

        text = text +
                "<sdk.fluig.com.ui.components.mediaview.FluigSdkMediaView\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\">\n" +
                "    app:video=\"@raw/video_background\" />\n";

        TextView textView = view.findViewById(R.id.mediaViewFragment_textView);
        textView.setText(text);
    }
    //endregion
}
