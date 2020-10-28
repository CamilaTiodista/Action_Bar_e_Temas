package com.example.actionbaretemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.SearchView;

import android.widget.ShareActionProvider;
import android.view.ActionProvider;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar actionBar = getActionBar();
        //actionBar.setTitle ("Teste");



        //Navegação por tabs na action bar
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem searchitem=menu.findItem(R.id.action_search);


        //Search View
        SearchView searchView = (SearchView) searchitem.getActionView();
        searchView.setOnQueryTextListener(onSearch());
        return true;

        //ShareActionProvider
        //MenuItem shareItem = menu.findItem(R.id.action_share);
        //ShareActionProvider share = (ShareActionProvider) shareItem.getActionProvider();
        //share.setShareIntent(getDefaultIntent());
    }

    //Search View
    private SearchView.OnQueryTextListener onSearch(){
        return new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                toast ("Buscar o texto: "+query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                return false;
            }
        };
    }

    //define o que vai ser compartilhado
    //private Intent getDefaultIntent(){
        //Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.setType("text/*");
        //intent.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar");
        //return intent;
    //}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_search) {
            toast( "Clicou no Search!");
            return true;
        } else if (id == R.id.action_refresh) {
            toast("Clicou no Refresh!");
            return true;
        } else if (id == R.id.action_settings) {
            toast("Clicou no Settings!");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}