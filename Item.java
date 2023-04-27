public class Item {

    int id;
    String name;
    int price;
    String category;


    public Item(int getId, String getName, int getPrice, String getCategory) {
      
        id = getId();
        name = getName();
        price = getPrice();
        category = getCategory();
        
        

    }

    String getCategory() {
        return null;
    }

    int getPrice() {
        return 0;
    }

    Object getItem() {
        return null;
    }

    public int getId() {
        return id ;
    }

    public String getName() {
        return null;
    }
}

class Supercar extends Item {

    public Supercar(int id, String name, int price) {
        super(id, name, price, "Supercar");
    }

    @Override
    public String getCategory() {
        return "Supercar";
    }
}



class SUV extends Item {

    public SUV(int id, String name, int price) {
        super(id, name, price, "SUV");
    }

    @Override
    public String getCategory() {
        return "SUV";
    }
}




    class Drift extends Item {

    public Drift(int id, String name, int price) {
        super(id, name, price, "Drift");
    }

    @Override
    public String getCategory() {
        return "Drift";
    }
}
