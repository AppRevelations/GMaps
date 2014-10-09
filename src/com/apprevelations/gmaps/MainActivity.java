package com.apprevelations.gmaps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends ActionBarActivity {

	GoogleMap mGoogleMap;
	Marker marker;
	LatLng x= new LatLng(28.66597840000000,77.09385829999997);
	int d=0;
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
            if(d==1)
            {
            	mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    			CameraPosition cameraPosition = new CameraPosition.Builder()
        	    .target(x)      // Sets the center of the map to Mountain View
        	    .zoom(15)                   // Sets the zoom
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
			if(d==1)
			{
				d=0;
				CameraPosition cameraPosition = new CameraPosition.Builder()
	    	    .target(x)      // Sets the center of the map to Mountain View
	    	    .zoom(15)                   // Sets the zoom
	    	    .bearing(30)                // Sets the orientation of the camera to east
	    	    .tilt(0)             // Sets the tilt of the camera to 0 degrees
	    	    .build();                   // Creates a CameraPosition from the builder
	    	     mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)
	    			);
			}
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			mGoogleMap.clear();
			PolylineOptions rectOptions = new PolylineOptions()
	        .add(new LatLng(28.665584803619396,77.09241461008787))
	        .add(new LatLng(28.668645437046642,77.092843092978)) 
	        .add(new LatLng(28.67172716100681,77.09343284368515))  
	        .add(new LatLng(28.674535816341333,77.09403567016125))  
	        .color(Color.GRAY); 

	      Polyline polyline = mGoogleMap.addPolyline(rectOptions);

			return true;
		}
		
		
		else if (id == R.id.polygon)
		{
			if(d==1)
			{
				d=0;
				CameraPosition cameraPosition = new CameraPosition.Builder()
	    	    .target(x)      // Sets the center of the map to Mountain View
	    	    .zoom(15)                   // Sets the zoom
	    	    .bearing(30)                // Sets the orientation of the camera to east
	    	    .tilt(0)             // Sets the tilt of the camera to 0 degrees
	    	    .build();                   // Creates a CameraPosition from the builder
	    	     mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)
	    			);
			}
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			mGoogleMap.clear();
			
			Polygon polygon = mGoogleMap.addPolygon(new PolygonOptions()
	        .add(new LatLng(28.669152592199133,77.09767676889896),
	        		new LatLng(28.66937469243565,77.09329839795828),
	        		new LatLng(28.67469701463505,77.0941312238574),
	        		new LatLng(28.67446315936509,77.09602821618319),
	        new LatLng(28.669943325730124,77.09776259958744))
	        .fillColor(Color.RED));
			
			return true;
		}
		
		
		else if (id == R.id.view)
		{
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			mGoogleMap.clear();
			if(d==0)
			{
				d=1;
			}
		  
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
		else if (id == R.id.marker)
		{
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			mGoogleMap.clear();
			if(d==1)
			{
				d=0;
				CameraPosition cameraPosition = new CameraPosition.Builder()
	    	    .target(x)      // Sets the center of the map to Mountain View
	    	    .zoom(15)                   // Sets the zoom
	    	    .bearing(30)                // Sets the orientation of the camera to east
	    	    .tilt(0)             // Sets the tilt of the camera to 0 degrees
	    	    .build();                   // Creates a CameraPosition from the builder
	    	     mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)
	    			);
			}
			mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

	            @Override
	            public void onMapClick(LatLng point) {

	            	
	                MarkerOptions marker = new MarkerOptions().position(
	                        new LatLng(point.latitude, point.longitude))
	                        .snippet("Here it is").title("My Marker").draggable(true);
	                        
	                mGoogleMap.addMarker(marker);
                    
	            System.out.println(point.latitude+"---"+ point.longitude);  
	            }
	        });
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
