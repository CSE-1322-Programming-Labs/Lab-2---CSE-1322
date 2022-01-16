import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        StockItem Milk = new StockItem("1 Gallon of Milk",3.60f,15);
        StockItem Bread = new StockItem("1 Loaf of Bread",1.98f,30);

        boolean quit = false;
        int userChoice = -1;
        while(!quit){
            System.out.println();
            boolean isValidInput = false;
            Scanner sc = new Scanner(System.in);
            printMenu();
            while(!isValidInput){
                if(sc.hasNextInt()){
                    userChoice = sc.nextInt();
                    if(userChoice > 8 || userChoice < 1){
                        System.out.println("Please enter a valid integer)");
                    }else{
                        isValidInput = true;
                    }
                }else{
                    System.out.println("Please enter a number");
                    sc.next();
                }
            }
            switch (userChoice){
                case 1://Sold One Milk
                    Milk.lowerQuantity(1);
                    break;
                case 2: //Sold One Bread
                    Bread.lowerQuantity(1);
                    break;
                case 3://Change price of Milk
                    System.out.println("Please enter a new price for Milk");
                    Milk.setPrice(sc.nextFloat()); //The exception handling for this is in the setPrice method.
                    break;
                case 4://Change the price of Bread
                    System.out.println("Please enter a new price for Bread");
                    break;
                case 5://Add Milk to inventory
                    System.out.println("How much Milk would you like to add to the inventory?");
                    Milk.raiseQuantity(sc.nextInt());
                    break;
                case 6://Add Bread to inventory
                    System.out.println("How much Bread would you like to add to the inventory?");
                    Bread.raiseQuantity(sc.nextInt());
                    break;
                case 7://See inventory
                    System.out.print("Milk: ");
                    toString(Milk);
                    System.out.print("Bread: ");
                    toString(Bread);
                    break;
                case 8:
                    quit = true;
            }
        }

    }
    public static void printMenu(){
        System.out.println("1. Sold One Milk");
        System.out.println("2. Sold One Bread");
        System.out.println("3. Change price of Milk");
        System.out.println("4. Change price of Bread");
        System.out.println("5. Add Milk to Inventory");
        System.out.println("6. Add Bread to Inventory");
        System.out.println("7. See Inventory");
        System.out.println("8. Quit");
    }

    public static void toString(StockItem item){
        System.out.println("Item number: "+item.getId()+" is "+item.getDescription()+" has price $"+item.getPrice()+" we currently have "+item.getQuantity()+" in stock");
    }
}
