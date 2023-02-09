package com.example.cookit.network;

import com.example.cookit.model.MealModel;

import java.util.List;

public interface NetworkDelegate {
    void onSuccessResult(List<MealModel> models);

    void onFailureResult(String message);
}
