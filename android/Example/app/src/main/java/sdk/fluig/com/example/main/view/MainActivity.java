package sdk.fluig.com.example.main.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import sdk.fluig.com.bll.core.eula.EulaFlow;
import sdk.fluig.com.bll.core.login.LoginFlow;
import sdk.fluig.com.example.R;
import sdk.fluig.com.example.component.view.ComponentActivity;
import sdk.fluig.com.example.main.contract.MainContract;
import sdk.fluig.com.example.main.presenter.MainPresenter;
import sdk.fluig.com.example.model.ListItemType;
import sdk.fluig.com.example.success.view.SuccessActivity;
import sdk.fluig.com.example.utils.GuiUtils;

public class MainActivity extends AppCompatActivity
        implements MainAdapter.OnClickListener, MainContract.View {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private MainContract.Presenter mPresenter;

    private MainAdapter mAdapter;

    private EulaBroadcastReceiver mEulaBroadcastReceiver;

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        setupEulaBroadcast();

        new MainPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mEulaBroadcastReceiver != null) {
            unregisterReceiver(mEulaBroadcastReceiver);
        }
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

        mSwipeRefreshLayout = findViewById(R.id.mainActivity_swipeContainer);
        mSwipeRefreshLayout.setOnRefreshListener(getOnRefreshListener());
    }

    private SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                showList(ListItemType.allModes());
                mSwipeRefreshLayout.setRefreshing(false);
            }
        };
    }

    private void setupEulaBroadcast() {
        mEulaBroadcastReceiver = new EulaBroadcastReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction(EulaFlow.ACTION_DID_ACCEPT);
        filter.addAction(EulaFlow.ACTION_DID_NOT_ACCEPT);
        registerReceiver(mEulaBroadcastReceiver, filter);
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
        Intent intent = new Intent(MainActivity.this, ComponentActivity.class);
        intent.putExtra(ComponentActivity.ARG_ITEM_TYPE, (Parcelable) itemType);
        startActivity(intent);
    }

    @Override
    public void showLoginFlow() {
        new LoginFlow(MainActivity.this, SuccessActivity.class).start();
    }

    @Override
    public void showEulaFlow() {
        new EulaFlow(MainActivity.this).start();
    }
    //endregion

    private class EulaBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals(EulaFlow.ACTION_DID_ACCEPT)) {
                    Intent nextIntent = new Intent(MainActivity.this, SuccessActivity.class);
                    nextIntent.putExtra(SuccessActivity.ARG_FLOW_SOURCE, "EULA");
                    startActivity(nextIntent);

                } else if (action.equals(EulaFlow.ACTION_DID_NOT_ACCEPT)) {
                    GuiUtils.showToast(MainActivity.this, R.string.eula_not_accepted);
                }
            }
        }
    }
}
