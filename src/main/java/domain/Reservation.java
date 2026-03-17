/* Reservation.java

*/
//Reservation domain class
//Author: Abulele Ntwanambi 218276400
//Date: 16 March 2026.

package domain;


import java.time.LocalDate;
import java.util.Objects;

public class Reservation
{
    private String reservationID;;
    private LocalDate date;
    private String status;


    public Reservation(Builder builder){
        this.reservationID = builder.reservationID;
        this.date = builder.date;
        this.status = builder.status;
    }
    public String toString(){
        String reserveInfo =
                "Reservation" + " " + reservationID + " "+
                        "Local Date" + date + " " + "Status" + " " + status;

        return reserveInfo;
    }

    public String getReservationID() {

        return reservationID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder{
        private String reservationID;
        private LocalDate date;
        private String status;


        public Builder setReservationID(String reservationID){
            this.reservationID = reservationID;
            return this;
        }
        public Builder setDate( LocalDate date){
            this.date = date;
            return this;
        }

        public Builder setStatus(String Status){
            this.status = status;
            return this;
        }

        public  Reservation build(){
            return new Reservation(this);

        }
    }



}


