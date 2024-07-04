package pattern.decorator;

public class Task {

    public static void main(String[] args) {
        Developer developer = new TeamleadJava(new SenjorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer.makejob());
    }

}
