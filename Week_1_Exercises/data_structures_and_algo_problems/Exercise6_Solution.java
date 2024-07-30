import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", title='" + title + '\'' + ", author='" + author + '\'' + '}';
    }
}

public class Exercise6_Solution {
    private Book[] books;
    private int size;

    public Exercise6_Solution(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public Book linearSearch(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearch(String title) {
        Arrays.sort(books, 0, size, Comparator.comparing(book -> book.title.toLowerCase()));
        int low = 0, high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = title.compareToIgnoreCase(books[mid].title);

            if (result == 0) {
                return books[mid];
            }
            if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the library: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Exercise6_Solution library = new Exercise6_Solution(capacity);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Book");
            System.out.println("2. Linear Search by Title");
            System.out.println("3. Binary Search by Title");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                }
                case 2 -> {
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBookLinear = library.linearSearch(searchTitle);
                    System.out.println(foundBookLinear != null ? foundBookLinear : "Book not found.");
                }
                case 3 -> {
                    System.out.print("Enter title to search: ");
                    String searchTitleBinary = scanner.nextLine();
                    Book foundBookBinary = library.binarySearch(searchTitleBinary);
                    System.out.println(foundBookBinary != null ? foundBookBinary : "Book not found.");
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
