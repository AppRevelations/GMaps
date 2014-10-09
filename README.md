GMaps
=====
How to integrate Google Map with you android app? 
And what you can do with Google Map?

Integrating Google Map

MainActivity.java

 recognizes fragment in activity_main.xml.

         mGoogleMap = ((SupportMapFragment) getSupportFragmentManager().
                                            findFragmentById(R.id.map)).getMap();
				      

Remember you have to generate an Api-key on Google Api Console for your project to use Google Map service.And add it
your manifest file(AndroidManifest.xml) with some permissions.

Change type of Map

     mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //satellite type
     mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);    //normal type
     mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);    //hybrid type

Draw a Polyline on Map

Latlng stores Latitude and longitude of a point.

     PolylineOptions rectOptions = new PolylineOptions()
                           .add(new LatLng(28.665584803619396,77.09241461008787))
                           .add(new LatLng(28.668645437046642,77.092843092978)) 
                           .add(new LatLng(28.67172716100681,77.09343284368515))
                           .add(new LatLng(28.674535816341333,77.09403567016125))
                           .color(Color.GRAY); 
                           
     Polyline polyline = mGoogleMap.addPolyline(rectOptions);
     
     .add():- in it you mention all LatLng points you want to join


Draw a Polygon on Map,change color of polygon and many more things.

            Polygon polygon = mGoogleMap.addPolygon(new PolygonOptions()
                               .add(new LatLng(28.669152592199133,77.09767676889896),
                               new LatLng(28.66937469243565,77.09329839795828),
                               new LatLng(28.67469701463505,77.0941312238574),
                               new LatLng(28.67446315936509,77.09602821618319),
                               new LatLng(28.669943325730124,77.09776259958744))
                               .fillColor(Color.RED));
	                        
	        
  Change view of map :- Changing viewing angle etc.

              CameraPosition cameraPosition = new CameraPosition
                                                 .Builder()
                                                 .target(x)
                                                 .zoom(17)
                                                 .bearing(30)
                                                 .tilt(90)
                                                 .build();  
    	   
    target():-   Sets the center of the map to Mountain View
    zoom():-     Sets the zoom
    bearing():-	 Sets the orientation of the camera to east
    tilt():-	 Sets the tilt of the camera to 90 degrees
    // Creates a CameraPosition from the builder
    mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    			
    			
Add a marker ,move that marker by touch (dragging).

      MarkerOptions marker = new MarkerOptions()
                                    .position(new LatLng(point.latitude, point.longitude))
                                    .snippet("Here it is")
                                    .title("My Marker")
                                    .draggable(true);
                                    
       mGoogleMap.addMarker(marker);
	   
	   
	 Title and Snippet is for info window which appears when you click on window 
	 or you can add this line in your code to see it.
	 
	 mGoogleMap.addMarker(marker).showInfoWindow();
	                        
         draggable(true) : you can place your marker where you want on map by dragging it.

