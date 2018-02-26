package sdk.fluig.com.example.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import sdk.fluig.com.bll.core.eula.EulaFlow;
import sdk.fluig.com.bll.core.login.LoginFlow;
import sdk.fluig.com.example.R;
import sdk.fluig.com.example.model.ListItemType;
import sdk.fluig.com.example.utils.GuiUtils;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnClickListener {

    private MainAdapter mAdapter;

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
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
        switch (itemType) {
            //mode
            case FLOW:
            case COMPONENTS:
                showListOfType(itemType);
                break;

            //flows
            case LOGIN:
            case EULA:
                startFlowOfType(itemType);
                break;

            //components
            case BUTTON:
            case EDIT_TEXT:
            case GROUP_TEXT:
            case MEDIA_VIEW:
            case PAGER:
            case THUMB:
            case WEB_VIEW:
                showComponentOfType(itemType);
                break;

            default:
                break;
        }
    }
    //endregion

    //region Lists
    private void showListOfType(ListItemType type) {
        ListItemType[] types;

        switch (type) {
            case FLOW:
                types = ListItemType.allFlows();
                break;
            case COMPONENTS:
                types = ListItemType.allComponents();
                break;
            default:
                GuiUtils.showToast(MainActivity.this, R.string.list_item_mode_notfound);
                return;
        }

        mAdapter.setTypes(types);
        mAdapter.notifyDataSetChanged();
    }
    //endregion

    //region Flows
    private void startFlowOfType(ListItemType type) {
        switch (type) {
            case LOGIN:
                startLoginFlow();
                break;
            case EULA:
                startEulaFlow();
                break;
            default:
                GuiUtils.showToast(MainActivity.this, R.string.list_item_flow_notfound);
                break;
        }
    }

    private void startLoginFlow() {
        new LoginFlow(MainActivity.this, new Intent()).start();
    }

    private void startEulaFlow() {
        new EulaFlow(MainActivity.this, "Example").start();
    }
    //endregion

    //region Components
    private void showComponentOfType(ListItemType type) {
        switch (type) {
            case BUTTON:
            case EDIT_TEXT:
            case GROUP_TEXT:
            case MEDIA_VIEW:
            case PAGER:
            case THUMB:
            case WEB_VIEW:
            default:
                GuiUtils.showToast(MainActivity.this, R.string.list_item_components_notfound);
                break;
        }
    }
    //endregion
}
