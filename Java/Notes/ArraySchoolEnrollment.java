package Notes;

public class ArraySchoolEnrollment {
    public static void main(String[] args) {
    int[] semesterOneMarks = {10, 20, 30, 40, 50};

    String[] semesterOneCourses = new String[5];

    semesterOneCourses[0] = "Algebra";
    semesterOneCourses[1] = "World History";
    semesterOneCourses[2] = "Literature";
    semesterOneCourses[3] = "Programming";
    semesterOneCourses[4] = "Gym";
    
    System.out.print(semesterOneCourses[0] + ": ");
    System.out.println(semesterOneMarks[0]);

    // Changed from "World History" to "History"
    semesterOneCourses[1] = "History";
    System.out.print(semesterOneCourses[1] + ": ");
    System.out.println(semesterOneMarks[1]);

    System.out.print(semesterOneCourses[2] + ": ");
    System.out.println(semesterOneMarks[2]);

    System.out.print(semesterOneCourses[3] + ": ");
    System.out.println(semesterOneMarks[3]);

    System.out.print(semesterOneCourses[4] + ": ");
    System.out.println(semesterOneMarks[4]);


    }
    
}
