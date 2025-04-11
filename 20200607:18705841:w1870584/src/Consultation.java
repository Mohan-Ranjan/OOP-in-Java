import java.time.LocalDateTime;

public class Consultation {
    static int month, date, hour, minutes;
    private double cost;
    private String notes;


    private LocalDateTime consultationDate;

    private LocalDateTime totalConsultationTime;

    private int duration;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public LocalDateTime getConsultationDate() {
        return consultationDate;
    }

    public LocalDateTime getTotalConsultationTime() {
        return totalConsultationTime;
    }

    public void setTotalConsultationTime(int duration) {
    }

    public void setConsultationDate( int month, int date, int hour, int minutes) {
        this.consultationDate = LocalDateTime.of(2023, month, date, hour, minutes);
        Consultation.month = month;
        Consultation.date = date;
        Consultation.hour = hour;
        Consultation.minutes = minutes;
    }

    public void initializeConstant(){
        setCost(0.0);
        setNotes(" ");
        setConsultationDate(2, 1, 1, 10);
    }
}
