package lesson3;

public class MoodAnalyser {

    public String moodanalyse (String mood) {
        if (mood.contains("хорошее")) {
            return "Хорошего дня";
        } else if (mood.contains("плохое")) {
            return "Всё будет хороошо";
        }
        return "Ясно";
    }
}
