package com.example.lap11799.dagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {
    @Provides
    @Singleton
    Motor provideMotor(){
        return new Motor();
    }

    @Provides
    @Singleton
    Vehicle provideVehicle(){
        return new Vehicle(provideMotor());
    }
}
