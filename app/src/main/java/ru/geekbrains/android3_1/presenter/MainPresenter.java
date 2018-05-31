package ru.geekbrains.android3_1.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.geekbrains.android3_1.model.CounterModel;
import ru.geekbrains.android3_1.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>
{
    CounterModel model;
    Observer<Integer> observer0, observer1, observer2;

    public MainPresenter(CounterModel model)
    {
        this.model = model;
    }

    @Override
    protected void onFirstViewAttach()
    { 
        super.onFirstViewAttach();
        observer0 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer i) {
                getViewState().setButtonOneText(String.valueOf(i));
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Observer", "onError", e);
            }

            @Override
            public void onComplete() {

            }
        };
        observer1 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer i) {
                getViewState().setButtonTwoText(String.valueOf(i));
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Observer", "onError", e);
            }

            @Override
            public void onComplete() {

            }
        };
        observer2 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer i) {
                getViewState().setButtonThreeText(String.valueOf(i));
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Observer", "onError", e);
            }

            @Override
            public void onComplete() {

            }
        };

    }

    public void buttonClick(int id)
    {
        switch (id) {
            case 0:
                model.calculate(id).subscribe(observer0);
                break;
            case 1:
                model.calculate(id).subscribe(observer1);
                break;
            case 2:
                model.calculate(id).subscribe(observer2);
                break;
        }
    }
}
