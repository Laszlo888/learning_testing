package teacherstudent;

public class Teacher {
    public static void main(String[] args) {
        Student student = new Student();
        teach(student);
    }

    void giveAnswer() {
        System.out.println("the teacher is answering a question");
    }

    static void teach(Student student) {
        student.learn();
    }
}
