public class StudentGrade {
    String name;
    double[] marks;

    public StudentGrade(String name, int subjects) {
        this.name = name;
        this.marks = new double[subjects];
    }
}

