package shedule;

public class Sub {
    private String nameSubject;
    private int countHours;

    public Sub() {

    }

    public Sub(String nameSubject, int countHours) {
        this.nameSubject = nameSubject;
        this.countHours = countHours;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public int getCountHours() {
        return this.countHours;
    }

    public void setCountHours(int countHours) {
        this.countHours = countHours;
    }
}
