package sdk.fluig.com.example.main.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import sdk.fluig.com.bll.core.eula.EulaFlow;
import sdk.fluig.com.bll.core.login.LoginFlow;
import sdk.fluig.com.example.R;
import sdk.fluig.com.example.main.contract.MainContract;
import sdk.fluig.com.example.main.presenter.MainPresenter;
import sdk.fluig.com.example.model.ListItemType;
import sdk.fluig.com.example.utils.GuiUtils;

public class MainActivity extends AppCompatActivity
        implements MainAdapter.OnClickListener, MainContract.View {

    private MainContract.Presenter mPresenter;

    private MainAdapter mAdapter;

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();

        new MainPresenter(this);
    }
    //endregion

    //region Setups
    private void setupView() {
        mAdapter = new MainAdapter(MainActivity.this, ListItemType.allModes(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        RecyclerView recyclerView = findViewById(R.id.mainActivity_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                MainActivity.this,
                layoutManager.getOrientation()
        ));
        recyclerView.setAdapter(mAdapter);
    }
    //endregion

    //region MainAdapter.Listener
    @Override
    public void onClickItem(ListItemType itemType) {
        mPresenter.obtainNextStep(itemType);
    }
    //endregion

    //region MainContract.View
    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(int stringRes) {
        GuiUtils.showToast(MainActivity.this, stringRes);
    }

    @Override
    public void showList(ListItemType[] itemTypes) {
        mAdapter.setTypes(itemTypes);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showComponent(ListItemType itemType) {

    }

    @Override
    public void showLoginFlow() {
        new LoginFlow(MainActivity.this, new Intent()).start();
    }

    @Override
    public void showEulaFlow() {
        new EulaFlow(MainActivity.this, "Example").start();
    }
    //endregion
}
