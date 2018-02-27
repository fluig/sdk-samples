package sdk.fluig.com.example.component.contract;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import sdk.fluig.com.example.model.ListItemType;

/**
 * Created by gregorysholl on 27/02/18.
 */

public interface ComponentContract {

    interface View {

        void setPresenter(Presenter presenter);

        void showError(@StringRes int stringRes);

        void showFragment(Fragment fragment);
    }

    interface Presenter {

        void obtainCorrectFragment(ListItemType itemType);
    }
}
