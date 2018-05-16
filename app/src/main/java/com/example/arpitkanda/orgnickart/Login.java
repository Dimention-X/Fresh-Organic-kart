package com.example.arpitkanda.orgnickart;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class Login extends Fragment {
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    EditText name;
    int randomNumber;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.login_holder, container, false);
        name=(EditText)view.findViewById(R.id.txt_name);
        return view;
    }
}
