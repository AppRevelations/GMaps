package com.apprevelations.gmaps;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	GoogleMap mGoogleMap;
	Marker marker;
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
			
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			return true;

		} 
		else if (id == R.id.polyline)
		{
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			return true;
		}
		else if (id == R.id.polygon)
		{
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			return true;
		}
		else if (id == R.id.view)
		{
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
