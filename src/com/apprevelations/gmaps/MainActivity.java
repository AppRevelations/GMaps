package com.apprevelations.gmaps;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	GoogleMap mGoogleMap;
	Marker marker;
	LatLng x= new LatLng(28.66597840000000,77.09385829999997);
	int a=0,b=0,c=0,d=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mGoogleMap = ((SupportMapFragment) getSupportFragmentManager().
				      findFragmentById(R.id.map)).getMap();
		mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(28.66597840000000,77.09385829999997), 15));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.maptype) {
			
			Toast.makeText(this, "Satellite type", 1300).show();
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			mGoogleMap.clear();
			if(a==0)
			{
			 a=1;
			}
            if(d==1)
            {
            	mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    			CameraPosition cameraPosition = new CameraPosition.Builder()
        	    .target(x)      // Sets the center of the map to Mountain View
        	    .zoom(17)                   // Sets the zoom
        	    .bearing(30)                // Sets the orientation of the camera to east
        	    .tilt(0)             // Sets the tilt of the camera to 0 degrees
        	    .build();                   // Creates a CameraPosition from the builder
        	     mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)
        			);
        	     d=0;
            }
		} 
		
		
		else if (id == R.id.polyline)
		{
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			
			return true;
		}
		
		
		else if (id == R.id.polygon)
		{
			
			
			
			if(a==1)
			{
			  a=0;
			  mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			}
			if(d==1)
            {
            	mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    			CameraPosition cameraPosition = new CameraPosition.Builder()
        	    .target(x)      // Sets the center of the map to Mountain View
        	    .zoom(17)                   // Sets the zoom
        	    .bearing(30)                // Sets the orientation of the camera to east
        	    .tilt(0)             // Sets the tilt of the camera to 0 degrees
        	    .build();                   // Creates a CameraPosition from the builder
        	     mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)
        			);
        	     d=0;
            }
			return true;
		}
		
		
		else if (id == R.id.view)
		{
			if(d==0)
			{
				d=1;
			}
		   mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			CameraPosition cameraPosition = new CameraPosition.Builder()
    	    .target(x)      // Sets the center of the map to Mountain View
    	    .zoom(17)                   // Sets the zoom
    	    .bearing(30)                // Sets the orientation of the camera to east
    	    .tilt(90)             // Sets the tilt of the camera to 90 degrees
    	    .build();                   // Creates a CameraPosition from the builder
    	mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)
    			);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
