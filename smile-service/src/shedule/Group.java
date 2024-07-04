package shedule;

import java.util.LinkedList;


public class Group {

    private String nameGroup;
    private int totalCountHours;
    private int curriculum;
    private int countSubjects;

    private LinkedList <Sub> allsubjects;

    public Group (String nameGroup, int totalCountHours, int countSubjects) {
        this.nameGroup = nameGroup;
        this.totalCountHours = totalCountHours;
        this.countSubjects = countSubjects;
        allsubjects = new LinkedList<>();
    }



    public void addSubject (Sub subject) {
        if (allsubjects.contains(subject)) {
            System.out.println("The Subject is already added");
        } else {
            allsubjects.add(subject);
        }
    }

    public void checkCurriculum () {
        int count = 0;
        for (Sub sub: this.allsubjects
             ) {
            count += sub.getCountHours();
        }
        if (count > totalCountHours) {
            System.out.println("The total number of hours does not match");
        } else if (count < totalCountHours) {
            System.out.println("The total number of hours is not enough");
        } else {
            System.out.println("The clock matches each other.");
        }
    }
    public void getAllCurriculum () {
        System.out.println(getNameGroup());
        for (Sub sub: allsubjects
             ) {
            System.out.println(sub.getNameSubject() + " - " + sub.getCountHours());
        }
    }

    public String getNameGroup() {
        return nameGroup;
    }
}
