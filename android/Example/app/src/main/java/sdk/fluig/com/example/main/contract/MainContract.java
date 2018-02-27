package sdk.fluig.com.example.main.contract;

import sdk.fluig.com.example.base.contract.BaseView;
import sdk.fluig.com.example.model.ListItemType;

/**
 * Created by gregorysholl on 26/02/18.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void showList(ListItemType[] itemTypes);

        void showComponent(ListItemType itemType);

        void showLoginFlow();

        void showEulaFlow();
    }

    interface Presenter {

        void obtainNextStep(ListItemType itemType);
    }
}
