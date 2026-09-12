import java.util.*;

class Custumers {
    private String name;
    private int age;
    private String pass;
    private double id;
    private long salary;

    public Custumers (String name,int age , String pass,double id){
    this.name = name;
    this.age = age;
    this.pass = pass;
    this.id = id;
    this.salary = 0;
    
}


public String getName(){
    return name;
}

public int getAge(){
    return age;
}

public String getPass(){
    return pass;
}

public double getId(){
    return id;
}

public long getSalary(){
    return salary;
}

public void setName( String name){
    this.name = name;
}

public void setAge(int age){
    this.age = age;
}

public void setPass(String pass){
    this.pass = pass;
}

public void setId(double id){
    this.id = id;
}

public void setSalary(long salary){
    this.salary = salary;
}

public void DisplayDetail() {
    System.out.println("====================================");
    System.out.println("name =                           "+ name);
    System.out.println("age =                             "+ age);
    System.out.println("id =                               "+ id);
    System.out.println("Amaunt=                        "+ salary);
    System.out.println("====================================");
}
}

public class  CustomersDetails {
    static ArrayList<Custumers>customer = new ArrayList<>();
    static Scanner obj = new Scanner(System.in);

    public static void addCustumer(){
        System.out.println("=======ADD USERS=======");
        System.out.println("enter your id...");
        double id = obj.nextDouble();
        obj.nextLine();

        for(Custumers users : customer){
            if(users.getId() == id){
                System.out.println("already exists...");
                return;
            }
            
        }
        System.out.println("=====ENTER DETAILS=====");
        System.out.println("enter your name        ");
        String name = obj.nextLine();
        System.out.println("enter your age         ");
        int age = obj.nextInt();
        obj.nextLine();
        System.out.println("crate your password    ");
        String pass = obj.nextLine();
        Custumers users = new Custumers( name, age, pass, id);

        customer.add(users);

        System.out.println("Successfully added the user!");

    }

    public static void AddAmount(){
        System.out.println("=======ADD DETAILS TO CREDIT=======");
        //System.out.println("enter your name                    ");
       // System.out.println("enter your age                     ");
        System.out.println("enter your id                      ");
        double id = obj.nextDouble();
        //System.out.println("enter your password                ");

        for(Custumers users : customer){
            if(users.getId()== id){
                System.out.println("Your name = " + users.getName());
                System.out.println("Your age  = " + users.getAge());
                System.out.println("enter amount =           ");
                long amount = obj.nextLong();
                users.setSalary(users.getSalary() + amount);

                System.out.println("your amount has been credit");
                System.out.println("Available balance = " + users.getSalary());
                return;
            }
        }
        
    }


    public static void withdrowAmount(){
        System.out.println("========WITHDRAW AMOUNT=======");
        System.out.println("ente you id                   ");
        double id = obj.nextDouble();

        for(Custumers users : customer){
            if(users.getId() == id){
                System.out.println("Your name = " + users.getName());
                System.out.println("Your age  = " + users.getAge());
                System.out.println("enter amount =            ");
                long amount = obj.nextLong();
                
                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0!");
                    return;
                }

                users.setSalary(users.getSalary() + amount);

                System.out.println("Your amount has been credited.");
                System.out.println("Available balance = " + users.getSalary());
                return;
            }
        }
        
    }

    public static void UpdateCustumer(){
        System.out.println("=======update details=======");
        System.out.println("enter your id               ");
        double oldid = obj.nextDouble();
        for(Custumers users : customer){
            if(users.getId() == oldid){
                System.out.println("enter new name              ");
                String name = obj.nextLine();
                System.out.println("enter new age               ");
                int age = obj.nextInt();
                System.out.println("enter new id                ");
                double newid = obj.nextDouble();
                System.out.println("enter your password         ");
                String pass = obj.nextLine();


                users.setAge(age);
                users.setId(newid);
                users.setName(name);
                users.setPass(pass);

                System.out.println("succesfully update the details");       
                return;
            }
        }
        System.out.println(" user not found!");

    }
    public static void deleteUser(){
        System.out.println("=======DELETE USER=======");
        System.out.println("enter your id            ");
        double id = obj.nextDouble();
        Iterator<Custumers> iterator = customer.iterator();

        while (iterator.hasNext()) {

            Custumers user = iterator.next();

            if (user.getId() == id) {

                iterator.remove();

                System.out.println("Successfully deleted the user!");
                return;
            }
        }

        System.out.println("User not found!");
    }
    
    public static void displayAllCustomers() {

        System.out.println("======= ALL CUSTOMER RECORDS =======");

        if (customer.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }

        for (Custumers users : customer) {
            users.DisplayDetail();
        }
    }
    public static void main(String[] args) {
        int choice;
    
        do {
                System.out.println("======================================");
                System.out.println("       BANK MANAGEMENT SYSTEM");
                System.out.println("======================================");
                System.out.println("1. Update custumer");
                System.out.println("2. Display All Records");
                System.out.println("3. withdraw amount");
                System.out.println("4. Delete user");
                System.out.println("5. Add amount");
                System.out.println("6. Add user");
                System.out.println("7. Exit");
                System.out.println("======================================");

                System.out.print("Enter your choice: ");
                choice = obj.nextInt();


                switch (choice) {

                    case 1:
                        UpdateCustumer();
                        break;

                    case 2:
                        displayAllCustomers();
                        break;

                    case 3:
                        withdrowAmount();
                        break;

                    case 4:
                        deleteUser();
                        break;

                    case 5:
                        AddAmount();
                        break;

                    case 6:
                        addCustumer();
                        break;

                    case 7:
                        System.out.println("Thank you for using bank Management System!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } while (choice != 7);

         obj.close();
        
    }

}