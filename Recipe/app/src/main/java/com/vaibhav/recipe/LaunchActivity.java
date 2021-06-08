package com.vaibhav.recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class LaunchActivity extends AppCompatActivity implements FragmentCommunicationListener {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private ListFragment listFragment = new ListFragment();
    private CategoryFragment categoryFragment = new CategoryFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch);
        SelectionFragment selectionFragment = new SelectionFragment(this);
        fragmentManager.beginTransaction().add(R.id.flContainer,selectionFragment,"Select").commit();
    }


    @Override
    public void dataPassed(Bundle bundle,int type) {
        switch (type){
            case 1:
                Log.d("Vaibhav","ListOne");
                listFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.flContainer,listFragment,"com.vaibhav.recipe.ListFragment").addToBackStack("ListOne").commit();
                break;
            case 2:
                Log.d("Vaibhav","ListOne");
                listFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.flContainer,listFragment,"ListFragment").addToBackStack("ListTwo").commit();
                break;
            case 3:
                listFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.flContainer,listFragment,"ListFragment").addToBackStack("ListThree").commit();
                break;
            case 4:
                fragmentManager.beginTransaction().replace(R.id.flContainer,categoryFragment,"CategoryFrag").commit();
                break;
        }
    }
}