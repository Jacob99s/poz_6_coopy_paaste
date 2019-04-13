import { Component, OnInit } from '@angular/core';

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

function initMap() {
  console.log(document.getElementById('map'));
  let map = new google.maps.Map(document.getElementById('map'), {
    zoom: 6,
    center: { lat: 52.0693, lng: 19.4803 },
    mapTypeControl: true,
    streetViewControl: false,
    fullscreenControl: false
  });
}

