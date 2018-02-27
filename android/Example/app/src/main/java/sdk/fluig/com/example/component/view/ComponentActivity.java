package sdk.fluig.com.example.component.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.component.contract.ComponentContract;

public class ComponentActivity extends AppCompatActivity
        implements ComponentContract.View {

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);
    }
    //endregion

    //region ComponentContract.View
    @Override
    public void setPresenter(ComponentContract.Presenter presenter) {

    }

    @Override
    public void showError(int stringRes) {

    }

    @Override
    public void showFragment(Fragment fragment) {

    }
    //endregion
}
