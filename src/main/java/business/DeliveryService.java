package business;

import data.Serializer;
import gui.Observer;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeliveryService extends Observable{
    private List<MenuItem> menuItems;
    private List<MenuItem> currentOrders;
    private HashMap<Order, List<MenuItem>> orders;
    private int currentId;
    private UserService userService;


    public DeliveryService(UserService userService){
        this.userService=userService;
        try{
            menuItems= Serializer.SERIALIZER.deserialize(FileNames.ITEMS);
        } catch (Exception e) {
            menuItems=new ArrayList<>();
        }
        try{
            orders=Serializer.SERIALIZER.deserialize(FileNames.ORDERS);
        } catch (Exception e) {
            orders=new HashMap<>();
        }
        try{
            currentOrders=Serializer.SERIALIZER.deserialize(FileNames.CURRENT_ORDERS);
        } catch (Exception e) {
            currentOrders=new ArrayList<>();
        }
    }

    public void addItem(MenuItem item){
        if(menuItems!=null&&menuItems.size()>0)
            item.setId(menuItems.get(menuItems.size()-1).getId()+1);
        else
            item.setId(1);
        menuItems.add(item);
    }

    public List<MenuItem> filterItems(String keyword,double ratingMin,double ratingMax,int caloriesMin,int caloriesMax,int proteinMin,int proteinMax,int fatMin,int fatMax,int sodiumMin,int sodiumMax,int priceMin,int priceMax){
        List<MenuItem> filtered=new ArrayList<>(menuItems);
        if(keyword!=null&&keyword.length()>0)
            filtered=filtered.stream().filter(n->n.getTitle().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
        else if(ratingMin==-1&&ratingMax==-1&&caloriesMin==-1&&caloriesMax==-1&&priceMax==-1&&priceMin==-1&&fatMax==-1&&fatMin==-1&&proteinMax==-1&&proteinMin==-1&&sodiumMax==-1&&sodiumMin==-1)
            return menuItems;
        filtered=filtered.stream().filter(n->{
            if(n instanceof BaseProduct){
                BaseProduct product=(BaseProduct) n;
                if(ratingMin!=-1&&product.getRating()<ratingMin||ratingMax!=-1&&product.getRating()>ratingMax)
                    return false;
                if(caloriesMin!=-1&&product.getCalories()<caloriesMin||caloriesMax!=-1&&product.getCalories()>caloriesMax)
                    return false;
                if(proteinMin!=-1&&product.getProtein()<proteinMin||proteinMax!=-1&&product.getProtein()>proteinMax)
                    return false;
                if(fatMin!=-1&&product.getFat()<fatMin||fatMax!=-1&&product.getFat()>fatMax)
                    return false;
                if(sodiumMin!=-1&&product.getSodium()<sodiumMin||sodiumMax!=-1&&product.getSodium()>sodiumMax)
                    return false;
                if(priceMin!=-1&&product.getPrice()<priceMin||priceMax!=-1&&product.getPrice()>priceMax)
                    return false;
            }else{
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        return new ArrayList<>(filtered);
    }

    public void addOrder(User user, ArrayList<MenuItem> items){
        int maxId=0;
        for(Order order:orders.keySet())
            if(order.getOrderId()>maxId)
                maxId=order.getOrderId();
        Order order=new Order(maxId+1,user.getId(), LocalDateTime.now());
        for(MenuItem item:items)
            currentOrders.add(item);
        orders.put(order,items);

        try{
            FileWriter file=new FileWriter("bill"+order.getOrderId()+".txt");
            file.write("User:\n");
            file.write(user+"\n");
            file.write("Products:\n");
            int price=0;
            for(MenuItem item:items){
                file.write(item+"\n");
                price+=item.computePrice();
            }
            file.write("Price: $"+price+"\n");
            file.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }
        Serializer.SERIALIZER.serialize(currentOrders,FileNames.CURRENT_ORDERS);
        Serializer.SERIALIZER.serialize(orders,FileNames.ORDERS);
        notifyObservers();
    }

    public void importProducts(String fileName){
        menuItems=new ArrayList<>();
        currentId=1;
        try{

            File inputF = new File(fileName);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            menuItems = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());

            menuItems=menuItems.stream().filter(n->{
                for(MenuItem item:menuItems){
                    if(item.getTitle().compareTo(n.getTitle())==0){
                        if(item==n)
                            return true;
                        else
                            return false;
                    }
                }
                return true;
            }).collect(Collectors.toList());

            br.close();
        } catch (IOException e) {

        }
    }
    private Function<String, BaseProduct> mapToItem = (line) -> {

        String[] p = line.split(",");

        BaseProduct item = new BaseProduct();

        item.setTitle(p[0]);
        item.setRating(Double.parseDouble(p[1]));
        item.setCalories(Integer.parseInt(p[2]));
        item.setProtein(Integer.parseInt(p[3]));
        item.setFat(Integer.parseInt(p[4]));
        item.setSodium(Integer.parseInt(p[5]));
        item.setPrice(Integer.parseInt(p[6]));
        item.setId(currentId);
        currentId++;

        return item;
    };

    public List<Order> report1(int hourMin, int hourMax){
        List<Order> filtered=orders.keySet().stream().filter(n->{
            Order order=(Order) n;
            int min= hourMin;
            int max=hourMax;
            int actual=order.getOrderTime().getHour();
            if(min>max){
                max+=24;
                if(actual<min)
                    actual+=24;
            }
            if(actual<min)
                return false;
            if(actual>=max)
                return false;
            return true;
        }).collect(Collectors.toList());
        return filtered;
    }

    public List<MenuItem> report2(int timesOrdered){
        HashMap<MenuItem,Integer> frequency=new HashMap<>();
        for(Order order:orders.keySet()){
            List<MenuItem> itemList=orders.get(order);
            for(MenuItem item:itemList){
                frequency.merge(item,1,Integer::sum);
            }
        }
        List<MenuItem> filtered=frequency.keySet().stream().filter(n->{
            if(frequency.get(n)<timesOrdered)
                return false;
            return true;
        }).collect(Collectors.toList());

        return filtered;
    }

    public List<String> report3(int timesOrderedClients, int valueHigher) {
        HashMap<User,Integer> frequency=new HashMap<>();
        for(Order order:orders.keySet()){
            List<MenuItem> itemList=orders.get(order);
            int price=0;
            for(MenuItem item:itemList){
                price+=item.computePrice();
            }
            if(price>=valueHigher){
                frequency.merge(userService.findById(order.getClientId()),1,Integer::sum);
            }
        }

        List<User> filtered=frequency.keySet().stream().filter(n->{
            if(frequency.get(n)<timesOrderedClients)
                return false;
            return true;
        }).collect(Collectors.toList());

        List<String> result=new ArrayList<>();
        for(User user:filtered)
            result.add(""+user+" made an order of "+valueHigher+" or higher "+frequency.get(user)+" times");
        return result;
    }

    public List<String> report4(int day, int month,int year) {

        List<Order> filtered=orders.keySet().stream().filter(n->{
            if(n.getOrderTime().getDayOfMonth()!=day)
                return false;
            if(n.getOrderTime().getMonth().getValue()!=month)
                return false;
            if(n.getOrderTime().getYear()!=year)
                return false;
            return true;
        }).collect(Collectors.toList());

        HashMap<MenuItem,Integer> frequency=new HashMap<>();
        for(Order order:filtered){
            List<MenuItem> itemList=orders.get(order);
            for(MenuItem item:itemList){
                frequency.merge(item,1,Integer::sum);
            }
        }

        List<String> result=new ArrayList<>();
        for(MenuItem menuItem:frequency.keySet())
            result.add(""+menuItem.getTitle()+" was ordered "+frequency.get(menuItem)+" times");
        return result;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public List<MenuItem> getCurrentOrders() {
        return currentOrders;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public HashMap getOrders(){
        return orders;
    }


}
