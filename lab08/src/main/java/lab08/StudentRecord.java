package lab08;

public class StudentRecord {

    private String studentID;
    private double midterm;
    private double assignments;
    private double finalExam;

    public StudentRecord(String studentID, double assignments, double midterm, double finalExam)
    {
        this.studentID = studentID;
        this.midterm = midterm;
        this.assignments = assignments;
        this.finalExam = finalExam;
    }

    public double getFinalMark(){
        double finalMark = this.assignments * 0.2;
        finalMark += this.midterm * 0.3;
        finalMark += this.finalExam * 0.5;
        return finalMark;
    }

    public String getLetterGrade(){
        double finalMark = getFinalMark();
        if ( finalMark < 50 ) {
            return "F";
        }else if(finalMark < 60){
            return "D";
        }else if(finalMark < 70){
            return "C";
        }else if(finalMark < 80){
            return "B";
        }else{
            return "A";
        }
    }

    public String getStudentID() {
        return studentID;
    }

    public double getMidterm() {
        return midterm;
    }

    public double getAssignments() {
        return assignments;
    }

    public double getFinalExam() {
        return finalExam;
    }
}
