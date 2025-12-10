import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;


public class Book_Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Books> books = new ArrayList<>();
        boolean found;
        while(true){
            try{
                System.out.println("\n------ Library Management System ------");
                System.out.println("1. Add Book");
                System.out.println("2. View All Books");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Exit");
                System.out.print("Enter Your Choice : ");
                int choice = input.nextInt();
                input.nextLine();
                if (choice == 5){
                    System.out.println("Thank you for using the Student Management System!\n");
                    break;
                }
                switch (choice){
                    case 1:
                        int t_id;
                        String t_name;
                        String t_author;

                        found = false;
                        while(true){
                            System.out.print("Enter ID : ");
                            if(input.hasNextInt()){
                                t_id = input.nextInt();
                                for(Books b:books){
                                    if(t_id == b.getId()){
                                        found = true;
                                        break;
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Enter a Valid Number !");
                                input.nextLine();
                            }

                        }
                        if(found) {
                            System.out.println("Student already exists in the list!");
                            break;
                        }
                        input.nextLine();


                        while(true){
                            System.out.print("Enter Book Title : ");
                            t_name = input.nextLine();
                            if(t_name.matches("[a-zA-Z ]+")){
                                break;
                            }
                            else{
                                System.out.println("! Name must contain only letters and spaces.");
                            }
                        }

                        while(true){
                            System.out.print("Enter Author Name : ");
                            t_author = input.nextLine();
                            if(t_author.matches("[a-zA-Z ]+")){
                                break;
                            }
                            else{
                                System.out.println("! Name must contain only letters and spaces.");
                            }
                        }

                        books.add(new Books(t_id,t_name,t_author));
                        System.out.println("Book added successfully!");
                        break;

                    case 2:
                        if(books.isEmpty()){
                            System.out.println("No Books in the List");
                        }
                        else{
                            System.out.println("\n--------------------------Books--------------------------");
                            for(Books s : books){
                                System.out.println(s);
                            }
                            System.out.println("-----------------------------------------------------------------");
                        }
                        break;

                    case 3:
                        int id;
                        while (true){
                            System.out.print("Enter Book ID to Borrow: ");
                            if(input.hasNextInt()){
                                id = input.nextInt();
                                break;
                            }
                            else {
                                System.out.println("Enter Valid Number");
                                input.nextLine();
                            }
                        }

                        found = false;

                        for (Books b : books) {

                            if (b.getId() == id) {
                                found = true;

                                if (!b.isBorrowed()) {
                                    b.setBorrowed(true);
                                    System.out.println("You have successfully borrowed: " + b.getTitle());
                                } else {
                                    System.out.println("Sorry! The book is already borrowed.");
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Book Not Found!");
                        }
                        break;

                    case 4:
                        int getid;
                        while(true){
                            System.out.print("Enter Book ID to Return: ");
                            if(input.hasNextInt()){
                                getid = input.nextInt();
                                break;
                            }
                            else {
                                System.out.println("Enter Valid Number");
                                input.nextLine();
                            }
                        }

                        found = false;

                        for (Books b : books) {

                            if (b.getId() == getid) {
                                found = true;

                                if (b.isBorrowed()) {
                                    b.setBorrowed(false);
                                    System.out.println("You have successfully returned: " + b.getTitle());
                                } else {
                                    System.out.println("This book was not borrowed.");
                                }
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Book Not Found!");
                        }
                        break;

                    default:
                        System.out.println("Invalid Input");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Enter Valid Input");
            }
            catch (Exception e){
                System.out.println("Something  Went Wrong" + e);
            }
        }

    }
}
