public class GradeCalculator {

    public static double calculateAverage(double[] marks) {
        double sum = 0;
        for (double m : marks) sum += m;
        return sum / marks.length;
    }

    public static String getGrade(double avg) {
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }
}

