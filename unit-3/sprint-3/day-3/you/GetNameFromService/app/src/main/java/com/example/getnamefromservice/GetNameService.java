package com.example.getnamefromservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Button;
import android.widget.TextView;

public class GetNameService extends Service {

    public GetNameService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    public String getName(){
        return "Amol Pardeshi";
    }

    public class ServiceBinder extends Binder{

        public GetNameService getNameService(){ return GetNameService.this; }
    }

}