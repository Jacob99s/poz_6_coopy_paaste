package com.paaste.coopy.backend;

public class pickupPoint {

    public int id = 0;
    public String category = "undefined";
    public double lat = 0;
    public double lng = 0;

    public pickupPoint(int id_point, String category_point, double lat_point, double lng_point){
        this.id = id_point;
        this.category = category_point;
        this.lat = lat_point;
        this.lng = lng_point;
    }

    public String toJSON(){
        return "{id: "+this.id+",category: "+this.category+",lat: "+this.lat+",lng: "+this.lng+"}";
    }
}




