package com.lanou3g.chanyoujidemo.man;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseFragment;

/**
 * Created by ${jl} on 16/5/16.
 */
public class LoginFragment extends BaseFragment implements TextWatcher{
    EditText nameEt,passWordEt;
    //View view;
    @Override
    protected int initLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        //this.view = view;
        nameEt = (EditText) view.findViewById(R.id.login_fragment_name_et);
        nameEt.addTextChangedListener(this);
        passWordEt = (EditText) view.findViewById(R.id.login_fragment_password_et);
        passWordEt.addTextChangedListener(this);



    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_man,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.other_title_ok_iv);
        imageView.setImageResource(R.mipmap.poi_smallbutton_normal);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        if (nameEt.getText().length()>0&&passWordEt.getText().length()>0){
        Log.d("LoginFragment", nameEt.getText().toString());


//        }else  {
//            ImageView imageView = (ImageView) view.findViewById(R.id.other_title_ok_iv);
//            imageView.setVisibility(View.GONE);
//        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
