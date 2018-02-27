package sdk.fluig.com.example.component.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.component.contract.ComponentContract;
import sdk.fluig.com.example.component.presenter.ComponentPresenter;
import sdk.fluig.com.example.model.ListItemType;
import sdk.fluig.com.example.utils.GuiUtils;

public class ComponentActivity extends AppCompatActivity
        implements ComponentContract.View {

    public static final String ARG_ITEM_TYPE = "ComponentActivity.ItemType";

    private ComponentContract.Presenter mPresenter;

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }

        mPresenter = new ComponentPresenter(this);
        mPresenter.obtainCorrectFragment((ListItemType) extras.get(ARG_ITEM_TYPE));
    }
    //endregion

    //region ComponentContract.View
    @Override
    public void setPresenter(ComponentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(int stringRes) {
        GuiUtils.showToast(ComponentActivity.this, stringRes);
    }

    @Override
    public void showFragment(Fragment fragment, String tag) {
        GuiUtils.addFragment(this, R.id.componentActivity_fragmentContainer, fragment, tag);
    }
    //endregion
}
