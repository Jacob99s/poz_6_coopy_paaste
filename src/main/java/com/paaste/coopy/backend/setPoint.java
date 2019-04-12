package com.paaste.coopy.backend;

public class setPoint {
    int howMuch = 5;
    PickupPoint empty = new PickupPoint(0, "", 0, 0, "name");
    PickupPoint[] picks = {
            new PickupPoint(1, "shop", 51.200, 15.777, "name"),
            new PickupPoint(2, "paczkomat", 52.156, 15.777, "Paczkomat wesoły"),
            new PickupPoint(3, "paczkomat", 53.300, 15.777, "name"),
            new PickupPoint(4, "shop", 54.400, 15.777, "name"),
            new PickupPoint(5, "paczkomat", 55.500, 15.777, "name"),
    };


    public PickupPoint getPoint(int id){
        for(int i=0; i < this.howMuch; i++){
            if(id == this.picks[i].id){
                return this.picks[i];
            }
        }
        return this.empty;
    }
}
