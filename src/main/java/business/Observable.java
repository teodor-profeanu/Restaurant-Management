package business;

import gui.Observer;

import java.util.ArrayList;
import java.util.List;


public class Observable {
    protected List<Observer> observers=new ArrayList<>();

    public void notifyObservers(){
        for(Observer observer:observers)
            observer.update();
    }
}
