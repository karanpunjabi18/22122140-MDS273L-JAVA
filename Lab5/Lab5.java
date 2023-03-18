import java.util.Scanner;
class Student {
    String regNo;
    String name;
    String email;
    String phone;
    String classs;
    String department;
    Student(String regNo, String name, String email, String phone, String classs, String department){
        this.regNo=regNo;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.classs=classs;
        this.department=department;
    }
    void printDetails(){
        System.out.printf("%-25s %-15s %-50s %-12s %-10s %-15s",this.regNo,this.name,this.email,this.phone,this.classs,this.department);
    }
    String getRegNo(){
        return this.regNo;
    }
    String getName(){
        return this.name;
    }
}
public class Lab5 {
    static int count=0;
    static Scanner scan = new Scanner(System.in);
    static Student[] student = new Student[100];
    static Student addStudent(){
        System.out.println("===============Enter details for student "+(count+1)+":===============");
        System.out.println("==========================================================");
        System.out.print("Registration Number: ");
        String regNo=scan.nextLine();
        System.out.print("Name: ");
        String name=scan.nextLine();
        System.out.print("Email: ");
        String email=scan.nextLine();
        System.out.print("Phone Number: ");
        String phone=scan.nextLine();
        System.out.print("Class: ");
        String classs=scan.nextLine();
        System.out.print("Department: ");
        String department=scan.nextLine();
        System.out.println("==========================================================");
        Student student = new Student(regNo,name,email,phone,classs,department);
        return student;
    }
    static void searchStudent(){
        System.out.println("====================Search a student=======================");
        int flag=0;
        System.out.print("Registration Number: ");
        String regno=scan.nextLine();
        for(int i=0;i<count;i++){
            if(regno.equalsIgnoreCase(student[i].getRegNo())){
                flag=1;
                System.out.print("Name: ");
                String name=scan.nextLine();
                System.out.println("==========================================================");
                if(name.equalsIgnoreCase(student[i].getName())){
                    System.out.println("The student with registration number "+regno+ " and name "+name+" is present.");
                }
                else{
                    System.out.println("Name does not match!");
                }
                System.out.println("==========================================================");
            }
        }
        if(flag==0){
            System.out.println("==========================================================");
            System.out.println("The student with registration number "+regno+ " is not present!");
        }
    }
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.print("How many students you want to add? : ");
        int n=Integer.parseInt(scan.nextLine());
        System.out.println("==========================================================");
        for(int i=0;i<n;i++){
            student[i]=addStudent();
            count++;
        }
        while(true){
            System.out.println("===========================MENU===========================");
            System.out.println("1. Add a new student.");
            System.out.println("2. Search a student.");
            System.out.println("3. Display all students.");
            System.out.println("4. Exit.");
            System.out.println("==========================================================");
            System.out.print("Enter your choice: ");
            int choice=Integer.parseInt(scan.nextLine());
            System.out.println("==========================================================");
            switch(choice){
                case 1:{
                    student[count]=addStudent();
                    count++;
                    break;
                }
                case 2:{
                    searchStudent();
                    break;
                }
                case 3:{
                    if(count==0){
                        System.out.println("====================No students found!====================");
                        System.out.println("==========================================================");
                    }
                    else{
                        System.out.println("----------------------Student Details----------------------");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-25s %-15s %-50s %-12s %-10s %-15s\n", "Registration Number", "Name", "Email", "Phone Number", "Class", "Department");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                        for(int i=0;i<count;i++){
                            student[i].printDetails();
                            System.out.println();
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                        }
                    }
                    break;
                }
                case 4:{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Enter valid choice!");
                    break;
                }
            }
        }
    }
}
