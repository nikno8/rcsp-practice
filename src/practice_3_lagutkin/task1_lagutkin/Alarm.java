package practice_3_lagutkin.task1_lagutkin;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class Alarm implements Observer<Integer> {

    private final int CO2_LIMIT = 70;
    private final int TEMP_LIMIT = 25;

    private int temperature = 0;
    private int co2 = 0;
    @Override
    public void onSubscribe(@NonNull Disposable disposable) {
        System.out.println(disposable.hashCode() + " has subscribed");
    }

    @Override
    public void onNext(@NonNull Integer value) {

        if (value <= 30){
            temperature = value;
            System.out.println("Next value from Temp sensor= " + value);
        } else {
            System.out.println("Next value from CO2 sensor= " + value);
            co2 = value;
        }
        checkingSystem();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }

    public void checkingSystem(){
        if (temperature >= TEMP_LIMIT && co2 >= CO2_LIMIT){
            System.out.println("ALARM!!! Temperature/CO2: " + temperature + "/"
                    + co2);
        } else if (temperature >= TEMP_LIMIT){
            System.out.println("Temperature warning: " + temperature);
        } else if (co2 >= CO2_LIMIT){
            System.out.println("CO2 warning: " + co2);
        }
    }


}
