package com.example.cookit.model.retrofit;

import com.example.cookit.model.retrofit.Country;

import java.util.List;

public class CountryResponse {


    private List<Country> meals;

    public List<Country> getCountries() {
        return meals;
    }

    public void setCountries(List<Country> countries) {
        this.meals = countries;
    }
}
