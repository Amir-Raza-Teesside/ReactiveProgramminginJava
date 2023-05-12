package uk.ac.tees.aad.rxhellow;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class viewmodel extends AndroidViewModel {

    Myuser myuser;
    public viewmodel(@NonNull Application application) {
        super(application);

        myuser = new Myuser("amirraza2501@gmail.com","Aamir Raza","Male");
    }


    public Myuser getMyuser()
    {
        return myuser;
    }

    public Myuser changeUser()
    {
        myuser = new Myuser("dummy@gmail.com","dummy","11222");
        return myuser;
    }
}
