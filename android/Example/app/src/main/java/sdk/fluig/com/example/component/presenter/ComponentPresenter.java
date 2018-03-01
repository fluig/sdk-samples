package sdk.fluig.com.example.component.presenter;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.component.contract.ComponentContract;
import sdk.fluig.com.example.component.view.fragment.ButtonFragment;
import sdk.fluig.com.example.component.view.fragment.EditTextFragment;
import sdk.fluig.com.example.component.view.fragment.GroupTextFragment;
import sdk.fluig.com.example.model.ListItemType;

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
    public void obtainCorrectFragment(ListItemType itemType) {
        switch (itemType) {
            case BUTTON:
                mView.showFragment(new ButtonFragment(), ButtonFragment.TAG);
                break;
            case EDIT_TEXT:
                mView.showFragment(new EditTextFragment(), EditTextFragment.TAG);
                break;
            case GROUP_TEXT:
                mView.showFragment(new GroupTextFragment(), GroupTextFragment.TAG);
                break;
            case MEDIA_VIEW:
            case PAGER:
            case THUMB:
            case WEB_VIEW:
                break;

            default:
                mView.showError(R.string.list_item_components_notfound);
                break;
        }
    }
    //endregion
}
