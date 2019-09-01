package com.example.materialdialog;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;

import android.widget.Toast;
import android.os.Bundle;
import android.view.View;

import android.app.MaterialDialogs.MaterialDialog;
import android.app.MaterialDialogs.MaterialDialogListener;
import android.app.MaterialDialogs.Animation;

public class MainActivity extends AppCompatActivity {
	private Toolbar _toolbar;
	private FloatingActionButton fab;
	
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		getSupportActionBar().setHomeButtonEnabled(false);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View _v) {
				onBackPressed();
			}
		});
		fab = (FloatingActionButton)findViewById(R.id._fab);
		fab.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				new MaterialDialog.Builder(MainActivity.this)
					.setTitle("Material Dialog")
					.setMessage("Author: Gymkhana Studio")
					.setTextButton("Download")
					.setAnimation(Animation.UP)
					.setIcon(R.drawable.ic_launcher)
					.setOnClicked(new MaterialDialogListener(){
						@Override
						public void OnClick(){
							Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
						}
					})
					.show();
			}
		});
    }
}
