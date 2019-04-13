package com.paaste.coopy.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Points {
    public setPoint points = new setPoint();

    public List<PickupPoint> GetSuggestedPoint(PickupPoint point, int howMuch){
        List<PickupPoint> objectList= new ArrayList<>();
        double tmpDimenstion = 0;

        for(int i = 0; i < points.howMuch; i++){
            tmpDimenstion = Math.sqrt(Math.abs(points.picks[i].lat - point.lat)* Math.abs(points.picks[i].lat - point.lat) +
                    Math.abs(points.picks[i].lng - point.lng)* Math.abs(points.picks[i].lng - point.lng));

            points.picks[i].dimension = tmpDimenstion;
            objectList.add(points.picks[i]);
        }

        Collections.sort(objectList, new Comparator<PickupPoint>() {
            @Override
            public int compare(PickupPoint lhs, PickupPoint rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.dimension < rhs.dimension ? -1 : (lhs.dimension > rhs.dimension) ? 1 : 0;
            }
        });
        if(howMuch > points.howMuch)
            howMuch = points.howMuch;
        return objectList.subList(0,howMuch);
    }
}
