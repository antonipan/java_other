package pattern.decorator;

public class TeamleadJava extends SenjorJavaDeveloper {
    public TeamleadJava(Developer developer) {
        super(developer);
    }
    public String sendWeekCustomer () {
        return "Send code. ";
    }

    @Override
    public String codeReview() {
        return super.codeReview() + sendWeekCustomer();
    }
}
