package Oops;


import java.sql.SQLOutput;
import java.util.Scanner;

// Book class creation
 public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;


//    Constructor to initialize book attributes
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable=true;

    }

//    Getter Setter method for the Book class properties
    public int getBookId(){
        return bookId;
    }
    public String gettitle(){
        return title;
    }
    public String getauthor(){return author;}
    public boolean getisAvailable(){return isAvailable;}

    @Override
    public String toString(){
        return "Book Id: "+bookId+"\nBook Title: "+title+"\nBook Author: "+author+"\nAvailable: "+isAvailable;
    }
}

// Library Class Creation
class Library {

    private Book[] books;
    private int count;

//    Library Constructor
public Library(int size){
    books=new Book[size];
    count=0;
}

//    Method to add book
    public void addBook(Book book){
        if (count<books.length){
            books[count++]=book;
            System.out.println("Book added Successfully!!");
        }else {
            System.out.println("Library is full!");
        }
    }

//    Method to Remove book

    public void removeBook(int bookId){

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId()==bookId){
                books[i]=books[count-1];
                books[count-1]=null;
                count--;
                System.out.println("Book removed Successfully!!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

//    Method to Search book

    public Book searchBook(int bookId){
for (int i=0;i<count;i++){
    if (books[i].getBookId()==bookId){
        return books[i];
    }
}return null;
    }

//    Method to display book

    public void displayBook(){

    if (count==0){
        System.out.println("No books in the Library!");
        return;
    }
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}

// Management class Creation
  class BookManagementSystem{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        Library library=new Library(2);

        while(true){
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Book");
            System.out.println("5.Exit");
            System.out.println("Choose an Option: ");
            int choice=scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter book id: ");
                    int id=scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title=scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author=scanner.nextLine();
                    library.addBook(new Book(id,title,author));
                    break;

                case 2:
                    System.out.println("Enter Book id to Remove: ");
                    int removeId=scanner.nextInt();
                    library.removeBook(removeId);
                    break;

                case 3:
                    System.out.println("Enter Book id to Search: ");
                    int searchId=scanner.nextInt();
                    Book book=library.searchBook(searchId);
                    if (book != null) {
                        System.out.println("Book Found: "+book);
                    }else{
                        System.out.println("Book not Found");
                    }
                    break;

                case 4:
                    library.displayBook();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }
    }
}

