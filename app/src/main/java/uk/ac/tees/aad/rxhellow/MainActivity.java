package uk.ac.tees.aad.rxhellow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import uk.ac.tees.aad.rxhellow.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    TextView textView;
    ArrayList<Myuser> list;
    viewmodel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = ViewModelProviders.of(MainActivity.this).get(viewmodel.class);



        Observable<Myuser> observable = Observable.just(viewModel.getMyuser());
        Observer<Myuser> observer = new Observer<Myuser>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Myuser myuser) {


                activityMainBinding.setUsermodel(viewModel.getMyuser());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

                activityMainBinding.setUsermodel(viewModel.changeUser());

            }
        };

        observable.subscribe(observer);






    }
}