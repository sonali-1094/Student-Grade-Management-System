public class Student {

    private String name;
    private int[] marks;
    private double average;
    private char grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateAverage();
        assignGrade();
    }

    private void calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        average = sum / (double) marks.length;
    }

    private void assignGrade() {
        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 40) grade = 'D';
        else grade = 'F';
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }

    public char getGrade() {
        return grade;
    }

    public int getHighestMark() {
        int max = marks[0];
        for (int m : marks) {
            if (m > max) max = m;
        }
        return max;
    }

    public int getLowestMark() {
        int min = marks[0];
        for (int m : marks) {
            if (m < min) min = m;
        }
        return min;
    }

    public void display() {
        System.out.println("\nName: " + name);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println("\nAverage: " + average);
        System.out.println("Highest: " + getHighestMark());
        System.out.println("Lowest: " + getLowestMark());
        System.out.println("Grade: " + grade);
    }
}

