package sdk.fluig.com.example.main.contract;

import android.support.annotation.StringRes;

import sdk.fluig.com.example.model.ListItemType;

/**
 * Created by gregorysholl on 26/02/18.
 */

public interface MainContract {

    interface View {

        void setPresenter(Presenter presenter);

        void showError(@StringRes int stringRes);

        void showList(ListItemType[] itemTypes);

        void showComponent(ListItemType itemType);

        void showLoginFlow();

        void showEulaFlow();
    }

    interface Presenter {

        void obtainNextStep(ListItemType itemType);
    }
}
