package pattern.decorator;

public class SenjorJavaDeveloper extends DeveloperDecorator {
    public SenjorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String codeReview () {
        return "Review code. ";
    }

    @Override
    public String makejob() {
        return super.makejob() + codeReview();
    }
}
