package com.george.project;

import com.project.george.facade.business.ClinicApplicationBusiness;
import com.project.george.facade.business.impl.ClinicApplicationBussinesImpl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	System.out.println("HOLAAAAAAAAAAAAAAAaa");
    	ClinicApplicationBusiness clinicApplicationBusiness=new ClinicApplicationBussinesImpl();
    	try {
			String value=clinicApplicationBusiness.mensajeTest("Alberto");
			System.out.println("Value : "+value);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
