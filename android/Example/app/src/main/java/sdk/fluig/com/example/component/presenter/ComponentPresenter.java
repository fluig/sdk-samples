package sdk.fluig.com.example.component.presenter;

import sdk.fluig.com.example.component.contract.ComponentContract;
import sdk.fluig.com.example.component.view.fragment.ButtonFragment;
import sdk.fluig.com.example.component.view.fragment.EditTextFragment;
import sdk.fluig.com.example.component.view.fragment.GroupTextFragment;
import sdk.fluig.com.example.component.view.fragment.MediaViewFragment;
import sdk.fluig.com.example.component.view.fragment.ProfileThumbFragment;
import sdk.fluig.com.example.component.view.fragment.WebViewFragment;
import sdk.fluig.com.example.model.ComponentType;

/**
 * Created by gregorysholl on 27/02/18.
 */

public class ComponentPresenter implements ComponentContract.Presenter {

    private ComponentContract.View mView;

    //region Constructors
    public ComponentPresenter(ComponentContract.View view) {
        mView = view;
        view.setPresenter(this);
    }
    //endregion

    //region ComponentContract.Presenter
    @Override
    public void obtainCorrectFragment(ComponentType componentType) {
        switch (componentType) {
            case BUTTON:
                mView.showFragment(new ButtonFragment());
                break;
            case EDIT_TEXT:
                mView.showFragment(new EditTextFragment());
                break;
            case GROUP_TEXT:
                mView.showFragment(new GroupTextFragment());
                break;
            case MEDIA_VIEW:
                mView.showFragment(new MediaViewFragment());
                break;
            case PROFILE_THUMB:
                mView.showFragment(new ProfileThumbFragment());
                break;
            case WEB_VIEW:
                mView.showFragment(new WebViewFragment());
                break;
        }
    }
    //endregion
}
