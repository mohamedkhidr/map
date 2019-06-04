package com.example.task1.validations;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class validator {


    public static boolean isValidAmountField(Context context , String input , double min , double max){

        if(!input.equals("")){

            double amount = Double.parseDouble(input);
            if(amount > max){
                Toast.makeText(context , "The maximum amount allowed is  "+max ,Toast.LENGTH_SHORT).show();
                return false;
            }else if(amount < min){
                Toast.makeText(context , "The minimum amount allowed is  "+min ,Toast.LENGTH_SHORT).show();
                return false;
            }else{
                return true;
            }
        }else{
            Toast.makeText(context , "Enter a valid amount value  " ,Toast.LENGTH_SHORT).show();
            return false;

        }
    }
}
