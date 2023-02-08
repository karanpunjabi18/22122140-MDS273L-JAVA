import java.util.List;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] nameList=new String[1024];
        int choice;
        int index=0;
        do {
            System.out.println("================================================");
            System.out.println("1. Enter a name:");
            System.out.println("2. Search for a name:");
            System.out.println("3. Remove a name:");
            System.out.println("4. Show all names:");
            System.out.println("5. Continue:");
            System.out.println("6. Exit:");
            System.out.println("================================================");
            System.out.print("Please Enter your choice:");
            choice=Integer.parseInt(scan.nextLine());
            System.out.println("================================================");
            switch (choice) {
                case 1:
                    String name;
                    System.out.print("Enter a Name: ");
                    name=scan.nextLine();
                    name=name.toLowerCase();
                    int flag2=0;
                    for(int i=0;i<nameList.length;i++){
                        if(name.equals(nameList[i])){
                            System.out.println("================================================");
                            System.out.println("Name Already Exists.");
                            System.out.println("================================================");
                            flag2=1;
                            break;
                        }
                    }
                    if(flag2==0){
                        nameList[index]=name;
                        index++;
                    }
                    break;
                case 2:
                    String search;
                    System.out.println("================================================");
                    System.out.print("Enter a Name you want to search: ");
                    search=scan.nextLine();
                    search=search.toLowerCase();
                    System.out.println("================================================");
                    int flag1=0;
                    for(int i=0;i<nameList.length;i++){
                        if(search.equals(nameList[i])){
                            System.out.println("================================================");
                            System.out.println(search+" is present in "+(i+1)+" place.");
                            System.out.println("================================================");
                            flag1=1;
                            break;
                        }
                    }
                    if(flag1==0){
                        System.out.println("================================================");
                        System.out.println("Sorry!, name "+search+" is not present.");
                        System.out.println("================================================");
                    }
                    break;
                case 3:
                    String remove;
                    System.out.println("================================================");
                    System.out.print("Enter a Name you want to Remove: ");
                    remove=scan.nextLine();
                    remove=remove.toLowerCase();
                    System.out.println("================================================");
                    String[] newNameList=new String[nameList.length];
                    int flag=0;
                    for(int i=0,k=0;i<nameList.length;i++){
                        if(remove.equals(nameList[i])){
                            flag=1;
                            index--;
                        }
                        else{
                            newNameList[k]=nameList[i];
                            k++;
                        }
                    }
                    if(flag==0){
                        System.out.println("================================================");
                        System.out.println("Sorry!, name "+remove+" is not present.");
                        System.out.println("================================================");
                    }
                    else{
                        nameList=newNameList;
                    }
                    break;
                case 4:
                    System.out.println("================================================");
                    System.out.println("Values are as follows:");
                    System.out.println("================================================");
                    for (String string : nameList) {
                        if(string==null){
                            break;
                        }
                        System.out.println(string);
                    }
                    System.out.println("================================================");
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("================================================");
                    System.out.println("Please provide a valid choice!");
                    System.out.println("================================================");
                    break;
            }
        } while (choice!=6);
    }
}
