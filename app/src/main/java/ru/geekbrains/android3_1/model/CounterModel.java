package ru.geekbrains.android3_1.model;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class CounterModel
{
    ArrayList<Integer> counters;

    public CounterModel()
    {
        counters = new ArrayList<>();
        counters.add(0);
        counters.add(0);
        counters.add(0);
    }

    public Observable<Integer> calculate(int index){
        Integer value = counters.get(index) + 1;
        counters.set(index, value);
        return Observable.just(value);
    }
}
