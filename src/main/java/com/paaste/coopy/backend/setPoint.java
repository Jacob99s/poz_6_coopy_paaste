package com.paaste.coopy.backend;

public class setPoint {
    int howMuch = 5;
    pickupPoint empty = new pickupPoint(0, "", 0, 0);
    pickupPoint[] picks = {
            new pickupPoint(1, "shop", 57.200, 16.17),
            new pickupPoint(2, "shop", 56.200, 15.17),
            new pickupPoint(3, "shop", 55.300, 15.27),
            new pickupPoint(4, "shop", 55.400, 15.37),
            new pickupPoint(5, "paczkomat", 55.500, 15.47),
    };

    public String toJSON(){
        String returnedString = "{";
        for(int i=0; i < this.howMuch; i++)
            returnedString += this.picks[i].toJSON();
        returnedString += "}";

        return returnedString;
    }

    public pickupPoint getPoint(int id){
        for(int i=0; i < this.howMuch; i++){
            if(id == this.picks[i].id){
                return this.picks[i];
            }
        }
        return this.empty;
    }
}
