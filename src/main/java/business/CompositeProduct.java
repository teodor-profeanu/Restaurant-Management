package business;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {
    ArrayList<MenuItem> items;

    public CompositeProduct(String title,ArrayList<MenuItem> items) {
        this.title=title;
        this.items = items;
        validate();
    }

    @Override
    public int computePrice() {
        int price=0;
        for(MenuItem item:items)
            price+=item.computePrice();
        return price;
    }

    @Override
    public void validate() throws AssertionError{
        assert title!=null&&title.length()>0:"Invalid title.";
        assert items.size()>1:"Invalid number of products.";
    }

    public String toString(){
        String string=title+" (";
        for(MenuItem item:items)
            string+=item.title+", ";
        string=string.substring(0,string.length()-2);
        string+="), $"+computePrice()+".";
        return string;
    }
}
