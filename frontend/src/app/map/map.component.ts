import { Component, OnInit } from '@angular/core';
import { ViewChild } from '@angular/core';
// import { } from '@types/googlemaps';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  latitude = 51.678418;
  longitude = 7.809007;
}


// export class AppComponent {
//   @ViewChild('gmap') gmapElement: any;
//   map: google.maps.Map;

//   ngOnInit() {
//     var mapProp = {
//       center: new google.maps.LatLng(18.5793, 73.8143),
//       zoom: 15,
//       mapTypeId: google.maps.MapTypeId.ROADMAP
//     };
//     this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
//   }
// }

function initMap() {
  console.log(document.getElementById('map'));
  // let map = new google.maps.Map(document.getElementById('map'), {
  //   zoom: 6,
  //   center: { lat: 52.0693, lng: 19.4803 },
  //   mapTypeControl: true,
  //   streetViewControl: false,
  //   fullscreenControl: false
  // });
}

