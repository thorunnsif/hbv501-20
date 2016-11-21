package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drug") // If you want to specify a table name, you can do so here
public class Drug {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dosage;
    private int frequency;
    private int date;
    private String name;
    private int activeIngr;
    private boolean reminder;
    private int reminderTime;

    public Drug() {
        this.name = "";
    }

    public Drug(int dosage, int frequency, int date, String name, int activeIngr, boolean reminder, int reminderTime) {
        this.dosage = dosage;
        this.frequency = frequency;
        this.date = date;
        this.name = name;
        this.activeIngr = activeIngr;
        this.reminder = reminder;
        this.reminderTime = reminderTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActiveIngr() {
        return activeIngr;
    }

    public void setActiveIngr(int activeIngr) {
        this.activeIngr = activeIngr;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public int getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(int reminderTime) {
        this.reminderTime = reminderTime;
    }

    @Override
    public String toString() {
        return String.format(
                "Drug[dosage=%s, name=%s]",
                dosage,name);
    }
}
