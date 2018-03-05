package sdk.fluig.com.example.component.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.utils.GuiUtils;
import sdk.fluig.com.ui.components.webview.FluigSdkWebView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {

    public static final String TAG = WebViewFragment.class.getSimpleName();

    //region Constructors
    public WebViewFragment() {}
    //endregion

    //region Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web_view, container, false);

        setupView(view);

        return view;
    }
    //endregion

    //region Setups
    private void setupView(View view) {
        if (view == null) {
            return;
        }

        FluigSdkWebView webView = view.findViewById(R.id.webViewFragment_component);
        webView.loadUrl("https://www.fluig.com");

        GuiUtils.showToast(getContext(), R.string.web_view_no_additional_config, Toast.LENGTH_LONG);
    }
    //endregion
}
