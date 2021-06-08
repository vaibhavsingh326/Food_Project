package com.vaibhav.recipe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SelectionFragment extends Fragment implements View.OnClickListener {
    private Button mBtnArea;
    private Button mBtnCategory;
    private Button mBtnIngredients;
    private Button mBtnCategoryList;
    private EditText mEtInput;
    FragmentCommunicationListener fragmentCommunicationListener;

    public SelectionFragment() {
    }

    public SelectionFragment(FragmentCommunicationListener fragmentCommunicationListener) {
        this.fragmentCommunicationListener = fragmentCommunicationListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    private void initViews(View view) {
        mBtnArea= view.findViewById(R.id.btnArea);
        mBtnCategory = view.findViewById(R.id.btnCategory);
        mBtnIngredients = view.findViewById(R.id.btnIngredient);
        mBtnCategoryList = view.findViewById(R.id.btnListOfCategories);
        mEtInput = view.findViewById(R.id.etInput);
        mBtnArea.setOnClickListener(this);
        mBtnIngredients.setOnClickListener(this);
        mBtnCategory.setOnClickListener(this);
        mBtnCategoryList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnArea:
                if (mEtInput.getText().toString()!=null){
                    String area = mEtInput.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("area",area);
                    bundle.putInt("type",1);
                    fragmentCommunicationListener.dataPassed(bundle,1);

                }else {
                    mEtInput.setError("Field Cannot Be Empty");
                }

                break;
            case R.id.btnCategory:
                if (mEtInput.getText().toString()!=null){
                    String category = mEtInput.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putInt("type",2);
                    bundle.putString("area",category);
                    fragmentCommunicationListener.dataPassed(bundle,2);
                }else {
                    mEtInput.setError("Field Cannot Be Empty");
                }

                break;
            case R.id.btnIngredient:
                if (mEtInput.getText().toString()!=null){
                    String ingredient = mEtInput.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putInt("type",3);
                    bundle.putString("area",ingredient);
                    fragmentCommunicationListener.dataPassed(bundle,3);
                }else {
                    mEtInput.setError("Field Cannot Be Empty");
                }

                break;
            case R.id.btnListOfCategories:
                Bundle bundle = new Bundle();
                fragmentCommunicationListener.dataPassed(bundle,4);
                break;
        }

    }
}