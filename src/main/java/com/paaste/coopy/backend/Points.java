package com.paaste.coopy.backend;

import java.util.ArrayList;
import java.util.List;

public class Points {
    public setPoint points = new setPoint();

    public List<Integer> GetSuggestedPoint(PickupPoint point, int howMuch, double last_dimension,  List<Integer> last_data){

        double shortest_dimension = last_dimension;
        double tmpDimenstion = 0;

        for(int i = 0; i < points.howMuch; i++){
//            if(shortest_dimension < last_dimension)
//                break;

            tmpDimenstion = Math.sqrt(Math.abs(points.picks[i].lat - point.lat)* Math.abs(points.picks[i].lat - point.lat) +
                    Math.abs(points.picks[i].lng - point.lng)* Math.abs(points.picks[i].lng - point.lng));

            if(tmpDimenstion < shortest_dimension){
                last_data.add(points.picks[i].id);
                shortest_dimension = tmpDimenstion;
            }
        }
        if(howMuch < 2)
            return last_data;
        else
            return this.GetSuggestedPoint(point, howMuch-1, shortest_dimension, last_data);
    }
}
