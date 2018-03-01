package sdk.fluig.com.example.main.presenter;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.main.contract.MainContract;
import sdk.fluig.com.example.model.ListItemType;

/**
 * Created by gregorysholl on 26/02/18.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void obtainNextStep(final ListItemType itemType) {
        switch (itemType) {
            //mode
            case FLOW:
            case COMPONENTS:
                showList(itemType);
                break;

            //flows
            case LOGIN:
            case EULA:
                showFlow(itemType);
                break;

            //components
            case BUTTON:
            case EDIT_TEXT:
            case GROUP_TEXT:
            case MEDIA_VIEW:
            case THUMB:
            case WEB_VIEW:
                mView.showComponent(itemType);
                break;

            default:
                break;
        }
    }

    private void showList(ListItemType itemType) {
        switch (itemType) {
            case FLOW:
                mView.showList(ListItemType.allFlows());
                break;
            case COMPONENTS:
                mView.showList(ListItemType.allComponents());
                break;
            default:
                mView.showError(R.string.list_item_mode_notfound);
                break;
        }
    }

    private void showFlow(ListItemType itemType) {
        switch (itemType) {
            case LOGIN:
                mView.showLoginFlow();
                break;
            case EULA:
                mView.showEulaFlow();
                break;
            default:
                mView.showError(R.string.list_item_flow_notfound);
                break;
        }
    }
}
