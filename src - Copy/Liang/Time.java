package Liang;

import java.util.Date;

public class Time {
    int hour;
    int minute;
    int second;

    Time(){
        this.hour=(int)((System.currentTimeMillis()/3600000));
        this.minute=(int)(((System.currentTimeMillis()/60000)-(this.hour*60)));
        this.second=(int)(((System.currentTimeMillis()/1000)-(this.hour*3600)-(this.minute*60)));


    }
    Time(int hour, int minute, int second){
        this.hour=hour;
        this. minute=minute;
        this.second=second;

    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setTime(long elapseTime){
        this.hour=(int)((elapseTime/3600000));
        this.minute=(int)(((elapseTime/60000)-(this.hour*60)));
        this.second=(int)(((elapseTime/1000)-(this.hour*3600)-(this.minute*60)));


    }


}
