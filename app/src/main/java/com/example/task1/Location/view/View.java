package com.example.task1.Location.view;

public interface View {
    public void onLocationRecieved(String latitude, String longitude);

    public void onNoLocationRecieved(String message);
}

