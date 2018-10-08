package telegramBot;

import org.telegram.telegrambots.meta.api.objects.Location;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "questType")

public class QuestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(nullable = false)
    private String awardType;

 //   @Column(nullable = false)
    private Date currentDate;

    @Column(nullable = false)
    private String date;



    @Column
    private float longitude;

    @Column
    private float latitude;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String dateFormation(Date currentDate){
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
        String date = dateFormat.format(currentDate);
        return date;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "QuestType{" +
                "id=" + id +
                ", awardType='" + awardType + '\'' +
                ", date='" + date + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
