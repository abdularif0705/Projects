package Final_Exam;

import java.util.ArrayList;

public class Student {

    private String name;
    private int age;
    private char gender;
    private int yearOfStudy;
    private int studentNumber;
    private ArrayList<Course> courses;
    public static int lastStudentNumber = 10000;
    public int numberOfCoursesNeeded;

    public Student(String name, int age, char gender, int numberOfCoursesNeeded) {

        studentNumber = ++lastStudentNumber;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.yearOfStudy = 1;
        this.numberOfCoursesNeeded = numberOfCoursesNeeded;
        courses = new ArrayList<>();
    }

    public class GraduateStudent extends Student {
        private String thesis;
        private ArrayList<String> seminars;
        private double salary;
        private boolean passed = false;

        /**
         * constructor
         *
         * @param name
         * @param age
         * @param gender
         * @param numberOfCoursesNeeded
         * @param salary
         * @param thesis
         */
        public GraduateStudent(String name, int age, char gender, int numberOfCoursesNeeded, double salary, String thesis) {
            super(name, age, gender, numberOfCoursesNeeded);
            this.salary = salary;
            this.thesis = thesis;
            this.seminars = new ArrayList<>();
        }

        //setters

        /**
         * sets salary
         *
         * @param salary
         */
        public void setSalary(double salary) {
            this.salary = salary;
        }

        /**
         * sets if they have passed their thesis
         *
         * @param passed
         */
        public void setPassed(boolean passed) {
            this.passed = passed;
        }

        /**
         * sets thesis subject
         *
         * @param thesis
         */
        public void setThesis(String thesis) {
            this.thesis = thesis;
        }

        //getter methods

        /**
         * returns Salary
         *
         * @return
         */
        public double getSalary() {
            return salary;
        }

        /**
         * returns thesis
         *
         * @return
         */
        public String getThesis() {
            return thesis;
        }

        /**
         * returns if the person has passed their thesis
         *
         * @return
         */
        public boolean isPassed() {
            return passed;
        }

        @Override
        public boolean graduated() {
            if (super.graduated() && seminars.size() >= 10 && this.passed) {
                return true;
            }
            return false;
        }
    }

    public boolean graduated() {

        if (courses.size() >= numberOfCoursesNeeded)
            return true;
        else
            return false;

    }
}