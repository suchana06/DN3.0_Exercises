import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "taskId=" + taskId + ", taskName='" + taskName + '\'' + ", status='" + status + '\'' + '}';
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class Exercise5_Solution {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head != null && head.task.taskId == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exercise5_Solution taskList = new Exercise5_Solution();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    taskList.addTask(new Task(id, name, status));
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task foundTask = taskList.searchTask(searchId);
                    System.out.println(foundTask != null ? foundTask : "Task not found.");
                    break;
                case 3:
                    System.out.println("Tasks:");
                    taskList.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskList.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
