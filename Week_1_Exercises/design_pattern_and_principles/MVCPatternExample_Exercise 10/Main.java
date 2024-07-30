public class Main {
    public static void main(String[] args) {
        // Create a Student object
        Student model = new Student("1", "Romit Raj Singh", "A");

        // Create a StudentView object
        StudentView view = new StudentView();

        // Create a StudentController object
        StudentController controller = new StudentController(model, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Romit Raj Singh");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
