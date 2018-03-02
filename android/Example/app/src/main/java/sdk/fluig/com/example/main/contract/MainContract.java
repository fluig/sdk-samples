package sdk.fluig.com.example.main.contract;

import sdk.fluig.com.example.base.contract.BaseView;
import sdk.fluig.com.example.model.ComponentType;
import sdk.fluig.com.example.model.ItemType;

/**
 * Created by gregorysholl on 26/02/18.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void showList(ItemType[] itemTypes);

        void showComponent(ComponentType componentType);

        void showLoginFlow();

        void showEulaFlow();
    }

    interface Presenter {

        void obtainNextStep(ItemType itemType);
    }
}
