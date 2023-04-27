import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Player player = new Player(5000000);

        while (!player.isBankrupt()) {
            System.out.println("Your balance: $" + player.getBalance());
            store.showItems();
            System.out.print("Enter the ID of the car you want to buy: ");
            try (Scanner scanner = new Scanner(System.in)) {
                int itemId = scanner.nextInt();
                Item item = store.getItem(itemId);

                if (item == null) {
                    System.out.println("Invalid item ID. Try again.");
                    continue;
                }

                if (player.buyItem(item)) {
                    System.out.println("You bought a " + item.getName() + " for $" + item.getPrice() + ".");
                    store.updateItemPrice(item);
                } else {
                    System.out.println("You cannot afford this item.");
                }
            }
        }

        System.out.println("You have spent all your money!");
        System.out.println("You bought " + player.getItems().size() + " cars:");
        player.showItems();
    }
}

class Player {
    private double balance;
    private ArrayList<Item> items = new ArrayList<>();

    public Player(double balance) {
        this.balance = balance;
    }

    public boolean buyItem(Item item) {
        if (balance >= item.getPrice()) {
            balance -= item.getPrice();
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean isBankrupt() {
        return balance <= 0;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("- " + item.getName() + " ($" + item.getPrice() + ")");
        }
    }
}

class Store {
    private ArrayList<Item> items = new ArrayList<>();

    public Store() {
        items.add(new Item(1, "Ferrari LaFerrari", 1500000, "Supercar"));
        items.add(new Item(2, "Bugatti Chiron", 3000000, "Supercar"));
        items.add(new Item(3, "Pagani Zonda", 15000000, "Supercar"));
        items.add(new Item(4, "Jeep Cherokee", 50000, "SUV"));
        items.add(new Item(5, "Range Rover Sport", 100000, "SUV"));
        items.add(new Item(6, "Lamborghini Urus", 300000, "SUV"));
        items.add(new Item(7, "Mazda Miata", 30000, "Drift"));
        items.add(new Item(8, "Supra MkIv", 80000, "Drift"));
        items.add(new Item(9, "BMW E30", 130000, "Drift"));
        items.add(new Item(10, "Nissan Skyline R-34", 400000, "Drift"));
    }

    public void updateItemPrice(Item item) {
    }

    public Item getItem(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void showItems() {
        System.out.println("Items for sale:");
        for (Item item : items) {
            System.out.println("- ID: " + item.getId() + ", " + item.getName() + " (" + item.getCategory() + "), $" + item.getPrice());
        }
    }

    
}

class Main {
    public static void main(String[] args) {
        // create an inventory
        Inventory inventory = new Inventory();

        // create items
        Item LaFerrari = new Supercar(1, "La Ferrari", 1500000);
        Item BugattiChiron = new Supercar(2, "Bugatti Chiron", 3000000);
        Item PaganiZonda = new Supercar(3, "Pagani Zonda", 15000000);
        Item JeepCherokee = new SUV(4, "Jeep Cherokee", 50000);
        Item RangeRoverSport = new SUV(5, "Range Rover Sport", 100000);
        Item LamborghiniUrus = new SUV(6, "Lamborghini Urus", 300000);
        Item MazdaMiata = new Drift(7, "Mazda Miata", 30000);
        Item SupraMkIv = new Drift(8, "Supra MkIv", 80000);
        Item BMWE30 = new Drift(9, "BMW E30", 130000);
        Item SkylineR34 = new Drift(10, "Skyline R34", 400000);

        // add items to the inventory
        inventory.add(LaFerrari);
        inventory.add(BugattiChiron);
        inventory.add(PaganiZonda);
        inventory.add(JeepCherokee);
        inventory.add(RangeRoverSport);
        inventory.add(LamborghiniUrus);
        inventory.add(MazdaMiata);
        inventory.add(SupraMkIv);
        inventory.add(BMWE30);
        inventory.add(SkylineR34);

        // print the inventory
        System.out.println(inventory);
    }
}

    
