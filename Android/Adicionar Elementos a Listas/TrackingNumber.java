package com.ipbeja.estig.packagetracker3;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Me on 28/12/2016.
 */

public class TrackingNumber implements Serializable {

    private int[] weights;
    private List<Integer> code;
    private Context context;
    private List<String> countryList;
    private static final long serialVersionUID = 156152615L;

    public TrackingNumber(Context context, List<String> countryList) {

        this.weights = new int[]{8, 6, 4, 2, 3, 5, 9, 7};
        this.code = new ArrayList<>();
        this.context = context;
        this.countryList = countryList;

    }

    public boolean validTrackingNumber(String nr) {

        String part1 = nr.substring(0, 2);
        String part2 = nr.substring(2, 11);
        String part3 = nr.substring(11,13);

        return validDigits(part2) && validCountry(part3) && validService(part1);

    }

    private boolean validDigits(String digits) {

        if (digits.length() == 9) {

            String[] digits2 = digits.split("(?<=.)");

            for (String cod : digits2){
                this.code.add(Integer.parseInt(cod));
            }

            if (this.code.get(this.code.size()-1) == calcLastDigit()){

                return true ;
            }

        }
        return false;
    }

    private int calcLastDigit(){

        int s = 0 ;

        for (int i = 0 ; i < this.weights.length ; i++){
            s += this.weights[i] * this.code.get(i) ;
        }

        int c = 11 - (s % 11) ;

        if (c == 10){
            c = 0 ;
        }
        if (c == 11){
            c = 5 ;
        }

        return c ;

    }

    private boolean validCountry(String country) {

        for (String cty : this.countryList){

            if (cty.equals(country)){
                return true;
            }

        }

        return false ;

    }

    private boolean validService(String service) {
        return true;
    }

}
