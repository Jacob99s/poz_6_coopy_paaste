package com.paaste.coopy.backend;

public class PickupPoint {

    public int id = 0;
    public String category = "undefined";
    public double lat = 0;
    public double lng = 0;
    public String name = "";

    public PickupPoint(int id_point, String category_point, double lat_point, double lng_point, String name_point){
        this.id = id_point;
        this.category = category_point;
        this.lat = lat_point;
        this.lng = lng_point;
        this.name = name_point;
    }
}




