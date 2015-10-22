       var map;

           function initialize() {
               var mapOptions = {
                   zoom: 12,
                   center: new google.maps.LatLng(33.9500, -83.3833),
                   mapTypeId: google.maps.MapTypeId.ROADMAP
               };
               map = new google.maps.Map(document.getElementById('map_canvas'),
                   mapOptions
               );
               google.maps.event.addListener(map, 'click', function(event) {
                   document.getElementById('latMap').value = event.latLng.lat();
                   document.getElementById('lngMap').value = event.latLng.lng();
               });
               
               
           }
           
           function mapDivClicked (event) {
               var target = document.getElementById('map_canvas'),
                   posx = event.pageX - target.offsetLeft,
                   posy = event.pageY - target.offsetTop,
                   bounds = map.getBounds(),
                   neLatlng = bounds.getNorthEast(),
                   swLatlng = bounds.getSouthWest(),
                   startLat = neLatlng.lat(),
                   endLng = neLatlng.lng(),
                   endLat = swLatlng.lat(),
                   startLng = swLatlng.lng();

               document.getElementById('posX').value = posx;
               document.getElementById('posY').value = posy;
               
               var latitude = startLat + ((posy/350) * (endLat - startLat));
               var longitude = startLng + ((posx/500) * (endLng - startLng));
               
               document.getElementById('lat').value = latitude; 
               document.getElementById('lng').value = longitude;
               
               placeMarker(latitude, longitude);
           }
           
          function placeMarker(latitude, longitude) {
        	   
        	 

        	   var marker = new google.maps.Marker({
        	     position: {lat: latitude, lng: longitude},
        	     map: map,
        	     title: 'Hello World!'
        	   });
        	   
        	   marker.setMap(map);
        	 }
           
           
           
           google.maps.event.addDomListener(window, 'load', initialize);
           
