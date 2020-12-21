package com.example.missuniverse;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final Object CardViewMissUniverseAdapter = this;
    private RecyclerView rvCategory;
    private ArrayList<MissUniverse> list = new ArrayList<>();
    //    private ArrayList<Biodata> list2 = new ArrayList<>();
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    //   public ImageButton info_image;
    int mode;
    ImageView btnMoveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    ImageView showDetail = findViewById(R.id.img_item_photo);

        btnMoveActivity = findViewById(R.id.img_item_photo);


        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(MissUniverseData.getListData());
        showRecyclerList();

    /*    @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.item_click_support:
                    Intent moveIntent = new Intent (MainActivity.this, DetailActivity.class);
                    moveIntent.putExtra(moveIntent.EXTRA_DETA)

            }
        } */

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(MissUniverseData.getListData());
            showRecyclerList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<MissUniverse> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }


    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListMissUniverseAdapter listMissUniverseAdapter = new ListMissUniverseAdapter(this);
        listMissUniverseAdapter.setListMissUniverse(list);
        rvCategory.setAdapter(listMissUniverseAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMissUniverse(list.get(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridMissUniverseAdapter gridMissUniverseAdapter = new GridMissUniverseAdapter(this);
        gridMissUniverseAdapter.setListMissUniverse(list);
        rvCategory.setAdapter(gridMissUniverseAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMissUniverse(list.get(position));
            }
        });

    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewMissUniverseAdapter cardViewMissUniverseAdapter = new CardViewMissUniverseAdapter(this);
        cardViewMissUniverseAdapter.setListMissUniverse(list);
        rvCategory.setAdapter(cardViewMissUniverseAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMissUniverse(list.get(position));
            }
        });
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    private void showSelectedMissUniverse(MissUniverse missUniverse) {
        Toast.makeText(this, "Kamu memilih " + missUniverse.getName(), Toast.LENGTH_SHORT).show();

        Intent moveIntent = new Intent (MainActivity.this, DetailActivity.class);
        moveIntent.putExtra(DetailActivity.EXTRA_DETAIL, "Jimena \"Ximena\" Navarrete Rosete adalah seorang model asal Meksiko dan pemenang kontes kecantikan Miss Universe 2010.\\n\n" +
                "        Sebelumnya, dia meraih gelar Nuestra Belleza México 2009.");
        startActivity(moveIntent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_item_photo:
                Intent moveIntent = new Intent (MainActivity.this, DetailActivity.class);
                moveIntent.putExtra(DetailActivity.EXTRA_DETAIL, "Jimena \"Ximena\" Navarrete Rosete adalah seorang model asal Meksiko dan pemenang kontes kecantikan Miss Universe 2010. Sebelumnya, dia meraih gelar Nuestra Belleza México 2009.");
                moveIntent.putExtra(DetailActivity.EXTRA_TTL, "22 Februari 1988");
                moveIntent.putExtra(DetailActivity.EXTRA_TINGGI, ",74 M");
                moveIntent.putExtra(DetailActivity.EXTRA_PASANGAN, "uan Carlos V");
                startActivity(moveIntent);
        }

    }
}



