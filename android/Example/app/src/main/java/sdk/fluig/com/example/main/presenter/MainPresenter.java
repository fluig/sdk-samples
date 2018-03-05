package sdk.fluig.com.example.main.presenter;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.main.contract.MainContract;
import sdk.fluig.com.example.model.ComponentType;
import sdk.fluig.com.example.model.FlowType;
import sdk.fluig.com.example.model.ItemType;
import sdk.fluig.com.example.model.ListType;

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
    public void obtainNextStep(ItemType itemType) {
        if (itemType instanceof ListType) {
            showList((ListType) itemType);

        } else if (itemType instanceof FlowType) {
            showFlow((FlowType) itemType);

        } else if (itemType instanceof ComponentType) {
            mView.showComponent((ComponentType) itemType);

        } else {
            mView.showError(R.string.list_notfound);
        }
    }

    private void showList(ListType listType) {
        switch (listType) {
            case FLOW:
                mView.showList(FlowType.values());
                break;
            case COMPONENTS:
                mView.showList(ComponentType.values());
                break;
        }
    }

    private void showFlow(FlowType flowType) {
        switch (flowType) {
            case LOGIN:
                mView.showLoginFlow();
                break;
            case EULA:
                mView.showEulaFlow();
                break;
        }
    }
}
