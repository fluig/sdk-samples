package sdk.fluig.com.example.base.contract;

import android.support.annotation.StringRes;

/**
 * Created by gregorysholl on 27/02/18.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void showError(@StringRes int stringRes);
}
