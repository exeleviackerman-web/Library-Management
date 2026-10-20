import java.util.ArrayList;
import java.util.Scanner;

class Book
{
     String title;
     String author;
     boolean isIssued = false;
     
     Book(String title, String author)
     {
          this.title = title;
          this.author = author;
     }
     public String toString()
     {
          return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
     }
}

public class LibraryManagement 
{
     public static void main(String args[])
     {
          Scanner scan = new Scanner(System.in);
          ArrayList<Book> books = new ArrayList<>();
          books.add(new Book("Wings Of Fire", "APJ Abdul Kalam"));
          books.add(new Book("The Mentalist", "Patrick Jane"));
          books.add(new Book("Harry Potter", "J.K. Rowling"));
         int choice = 0;
          
          while(choice != 6)
          {
               System.out.println("\t--- Library Menu---");
               System.out.println("\t1. Add Book");
               System.out.println("\t2. Search Book");
               System.out.println("\t3. Issue Book");
               System.out.println("\t4. Return Book");
               System.out.println("\t5. Display All Books");
               System.out.println("\t6. Exit");
               choice = scan.nextInt();
               
               switch(choice)
               {
                    case 1: {
                    scan.nextLine();
                    System.out.println("\tTitle : ");
                    String title = scan.nextLine();
                    System.out.println("\tAuthor");
                    String author = scan.nextLine();
                    books.add(new Book(title, author));
                    System.out.println("\tBook added successfully");
                    
                    break;
                    }
                    
                    case 2 : {
                    scan.nextLine();
                    System.out.println("\tEnter title to search : ");
                    String searchTitle = scan.nextLine();
                    boolean found = false;
                    for (Book b : books)
                    {
                         if (b.title.toLowerCase().contains(searchTitle.toLowerCase()))
                         {
                              System.out.println(b);
                              found = true;
                         }
                    }
                    if (! found){
                         System.out.println("\tBook not found");
                    }
                    }
                    
                    break;
                    
                    case 3 :
                    { 
                    scan.nextLine();
                    System.out.println("\tEnter Title To Issue The Book : ");
                    String title = scan.nextLine();
                    Boolean found = false;
                    for (Book b : books)
                    {
                          if (b.title.equalsIgnoreCase(title))
                          {
                               found = true;
                               
                               if(! b.isIssued)
                               {
                                    b.isIssued = true;
                                    System.out.println("\tBook Issued Successfully ");
                               }
                               else
                               {
                                    System.out.println("\tBook is Already Issued");
                               }
                                    break;
                          }
                    }
                    if (! found)
                    {
                         System.out.println("\tBOOK NOT FOUND");
                    }
                    }              
                    break;
                    
                    case 4 :
                    {
                    scan.nextLine();
                    System.out.println("\tEnter the title of the book you want to return");
                    String title = scan.nextLine();
                    boolean found = false;
                    
                    for(Book b : books)
                    {
                         if(b.title.equalsIgnoreCase(title))
                         {
                              found = true;
                              if(b.isIssued)
                              {
                                   b.isIssued = false;
                                   System.out.println("\tBook Returned Successfully");
                              }
                              else
                              {
                                   System.out.println("\tBook Is Already Returned");
                              }
                              break;
                         }
                    }
                    if(! found)
                    {
                         System.out.println("\tBook not found");
                    }
               }
                    break;
                    case 5 :
                    { 
                    if(books.isEmpty())
                    {
                          System.out.println("\tThere is no book");
                    }
                    else
                    {
                         for(Book b : books)
                         {
                              System.out.println(b);
                         }
                         }
                    }
                    break;
                    
                    case 6 :
                    System.out.println("\tBye!");
                    break;
                    
                    default :
                    System.out.println("\tWrong choice");
               }
          }
          scan.close();
     }
} 