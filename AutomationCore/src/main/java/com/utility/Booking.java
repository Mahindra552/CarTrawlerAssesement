package com.utility;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Booking {

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getNumofDays() {
        return numofDays;
    }

    public void setNumofDays(int numofDays) {
        this.numofDays = numofDays;
    }

    private int numofDays;
    private String checkInDate;


}
