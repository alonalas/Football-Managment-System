package LogicLayer;

import javax.xml.crypto.Data;

public class Date {
    private int year;
    private int month;
    private int day;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Date){
            return ((Date)obj ).getYear()==this.getYear() &&
                    ((Date)obj ).getMonth()== this.getMonth() &&
                    ((Date)obj ).getDay()==this.getDay();
        }
        return false;
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
