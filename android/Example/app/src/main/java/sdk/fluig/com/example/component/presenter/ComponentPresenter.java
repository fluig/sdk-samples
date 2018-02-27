package sdk.fluig.com.example.component.presenter;

import sdk.fluig.com.example.component.contract.ComponentContract;
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

    }
    //endregion
}
