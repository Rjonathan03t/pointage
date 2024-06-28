package org.example.model.employe.increasedTime;

public class IncreasedHour {
    private boolean night;
    private boolean sunday;


    public IncreasedHour(boolean night, boolean sunday) {
        this.night = night;
        this.sunday = sunday;

    }

    public boolean isNight() {
        return night;
    }

    public boolean isSunday() {
        return sunday;
    }
}
