package controller;

import business.*;
import data.Serializer;
import gui.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Controller {
    LoginFrame loginFrame;
    LoginFrame registerFrame;
    UserService userService;
    DeliveryService deliveryService;
    EmployeeFrame employeeFrame;

    public Controller(){
        userService=new UserService();
        deliveryService=new DeliveryService(userService);
        loginFrame=new LoginFrame(false);
        registerFrame=new LoginFrame(true);
        employeeFrame=new EmployeeFrame(deliveryService);
        employeeFrame.update();
        deliveryService.addObserver(employeeFrame);
        Order.deliveryService=deliveryService;
        Order.userService=userService;

        loginFrame.getRegister().addActionListener(e->{
            registerFrame.refresh();
            registerFrame.setVisible(true);
        });
        loginFrame.getLogin().addActionListener(e->{
            User user;
            try{
                user=userService.access(loginFrame.getUsername(),loginFrame.getPassword());
            }catch(Exception exception){
                loginFrame.colorLines(exception.getMessage());
                return;
            }
            loginFrame.colorLines(null);
            if(user.getRole()==UserRole.CLIENT){
                ClientFrame clientFrame=new ClientFrame(user.getId());
                clientFrame.updateList(deliveryService.getMenuItems());
                clientFrame.getSearch().addActionListener(e1->{
                    clientFrame.updateList(deliveryService.filterItems(clientFrame.getKeyword(), clientFrame.getRatingMin(), clientFrame.getRatingMax(),clientFrame.getCaloriesMin(),clientFrame.getCaloriesMax(),clientFrame.getProteinMin(),clientFrame.getProteinMax(),clientFrame.getFatMin(),clientFrame.getFatMax(),clientFrame.getSodiumMin(),clientFrame.getSodiumMax(),clientFrame.getPriceMin(),clientFrame.getPriceMax()));
                });
                clientFrame.getOrder().addActionListener(e1->{
                    List<Object> objects;
                    try{
                        objects=clientFrame.getList().getSelectedValuesList();
                    }catch (Exception exception){
                        error("Not enough items selected.");
                        return;
                    }
                    if(objects==null||objects.size()<1){
                        error("Not enough items selected.");
                        return;
                    }
                    ArrayList<MenuItem> list=new ArrayList<>();
                    for(Object object:objects)
                        list.add((MenuItem) object);
                    deliveryService.addOrder(user,list);
                    JOptionPane.showMessageDialog(new JFrame(),"Items ordered successfully.","Info",JOptionPane.INFORMATION_MESSAGE);
                });
            }
            if(user.getRole()==UserRole.ADMIN){
                AdminFrame adminFrame=new AdminFrame();
                adminFrame.updateList(deliveryService.getMenuItems());
                adminFrame.getImportProducts().addActionListener(e1->{
                    deliveryService.importProducts("products.csv");
                    adminFrame.updateList(deliveryService.getMenuItems());
                });
                adminFrame.getAdd().addActionListener(e1->{
                    AddFrame addFrame=new AddFrame(false);
                    addFrame.getAdd().addActionListener(e2->{
                        addFrame.colorLines(null);
                        try{
                            deliveryService.addItem(new BaseProduct(addFrame.getTitleField().getText(),Double.parseDouble(addFrame.getRatingField().getText()),Integer.parseInt(addFrame.getCaloriesField().getText()),Integer.parseInt(addFrame.getProteinField().getText()),Integer.parseInt(addFrame.getFatField().getText()),Integer.parseInt(addFrame.getSodiumField().getText()),Integer.parseInt(addFrame.getPriceField().getText())));
                        }catch (NumberFormatException exception){
                            String message="Invalid number format: "+exception.getMessage().substring(18,exception.getMessage().length());
                            addFrame.colorLines(message);
                            return;
                        }catch (Exception exception){
                            addFrame.colorLines(exception.getMessage());
                            return;
                        }catch(Error error){
                            addFrame.colorLines(error.getMessage());
                            return;
                        }
                        addFrame.colorLines();
                        adminFrame.updateList(deliveryService.getMenuItems());
                        addFrame.dispose();
                    });
                });
                adminFrame.getReport().addActionListener(e1->{
                    ReportFrame reportFrame=new ReportFrame();
                    reportFrame.getGenerate1().addActionListener(e2->{
                        int hourMin;
                        int hourMax;
                        try{
                            hourMin = Integer.parseInt(reportFrame.getHourMin().getText());
                            hourMax = Integer.parseInt(reportFrame.getHourMax().getText());
                        }catch(Exception exception){
                            error("Invalid number format.");
                            return;
                        }
                        reportFrame.updateList(deliveryService.report1(hourMin,hourMax));
                    });
                    reportFrame.getGenerate2().addActionListener(e2->{
                        int timesOrdered;
                        try{
                            timesOrdered = Integer.parseInt(reportFrame.getTimesOrdered().getText());
                        }catch(Exception exception){
                            error("Invalid number format.");
                            return;
                        }

                        reportFrame.updateList(deliveryService.report2(timesOrdered));
                    });
                    reportFrame.getGenerate3().addActionListener(e2->{
                        int timesOrderedClients;
                        int valueHigher;
                        try{
                            timesOrderedClients = Integer.parseInt(reportFrame.getTimesOrderedClients().getText());
                            valueHigher=Integer.parseInt(reportFrame.getValueHigher().getText());
                        }catch(Exception exception){
                            error("Invalid number format.");
                            return;
                        }
                        reportFrame.updateList(deliveryService.report3(timesOrderedClients,valueHigher));
                    });
                    reportFrame.getGenerate4().addActionListener(e2->{
                        int day;
                        int month;
                        int year;
                        try{
                            day = Integer.parseInt(reportFrame.getDay().getText());
                            month=Integer.parseInt(reportFrame.getMonth().getText());
                            year=Integer.parseInt(reportFrame.getYear().getText());
                        }catch(Exception exception){
                            error("Invalid number format.");
                            return;
                        }

                        reportFrame.updateList(deliveryService.report4(day,month,year));
                    });
                });
                adminFrame.getModify().addActionListener(e1->{
                    Object object;
                    try{
                        object=adminFrame.getList().getSelectedValue();
                    }catch(Exception exception){
                        error("No item selected.");
                        return;
                    }
                    if(object==null){
                        error("No item selected.");
                        return;
                    }
                    if(object instanceof BaseProduct){
                        AddFrame modifyFrame=new AddFrame(true);
                        BaseProduct item=(BaseProduct)object;
                        modifyFrame.colorLines(null);
                        modifyFrame.getPriceField().setText(""+item.getPrice());
                        modifyFrame.getTitleField().setText(item.getTitle());
                        modifyFrame.getCaloriesField().setText(""+item.getCalories());
                        modifyFrame.getRatingField().setText(""+item.getRating());
                        modifyFrame.getProteinField().setText(""+item.getProtein());
                        modifyFrame.getFatField().setText(""+item.getFat());
                        modifyFrame.getSodiumField().setText(""+item.getSodium());

                        modifyFrame.getAdd().addActionListener(e2->{
                            try{
                                new BaseProduct(modifyFrame.getTitleField().getText(),Double.parseDouble(modifyFrame.getRatingField().getText()),Integer.parseInt(modifyFrame.getCaloriesField().getText()),Integer.parseInt(modifyFrame.getPriceField().getText()),Integer.parseInt(modifyFrame.getFatField().getText()),Integer.parseInt(modifyFrame.getSodiumField().getText()),Integer.parseInt(modifyFrame.getPriceField().getText()));
                            }catch (NumberFormatException exception){
                                String message="Invalid number format: "+exception.getMessage().substring(18,exception.getMessage().length());
                                modifyFrame.colorLines(message);
                                return;
                            }catch (Exception exception){
                                modifyFrame.colorLines(exception.getMessage());
                                return;
                            }catch (AssertionError assertionError){
                                modifyFrame.colorLines(assertionError.getMessage());
                                return;
                            }
                            modifyFrame.colorLines();
                            item.setTitle(modifyFrame.getTitleField().getText());
                            item.setRating(Double.parseDouble(modifyFrame.getRatingField().getText()));
                            item.setCalories(Integer.parseInt(modifyFrame.getCaloriesField().getText()));
                            item.setProtein(Integer.parseInt(modifyFrame.getProteinField().getText()));
                            item.setFat(Integer.parseInt(modifyFrame.getFatField().getText()));
                            item.setSodium(Integer.parseInt(modifyFrame.getSodiumField().getText()));
                            item.setPrice(Integer.parseInt(modifyFrame.getPriceField().getText()));
                            adminFrame.updateList(deliveryService.getMenuItems());
                            modifyFrame.dispose();
                        });
                    }
                    else{
                        error("Cannot modify composite item.");
                        return;
                    }
                });
                adminFrame.getDelete().addActionListener(e1->{
                    Object object;
                    try{
                        object=adminFrame.getList().getSelectedValue();
                    }catch(Exception exception){
                        error("No item selected.");
                        return;
                    }
                    if(object==null){
                        error("No item selected.");
                        return;
                    }
                    MenuItem item=(MenuItem) object;
                    deliveryService.getMenuItems().remove(item);
                    adminFrame.updateList(deliveryService.getMenuItems());
                });
                adminFrame.getCompose().addActionListener(e1->{
                    List<Object> objects;
                    try{
                        objects=adminFrame.getList().getSelectedValuesList();
                    }catch (Exception exception){
                        error("Not enough items selected.");
                        return;
                    }

                    if(objects==null||objects.size()<2){
                        error("Not enough items selected.");
                        return;
                    }

                    ArrayList<MenuItem> list=new ArrayList<>();
                    for(Object object:objects){
                        list.add((MenuItem) object);
                    }
                    String title= JOptionPane.showInputDialog("Menu title: ");
                    try{
                        deliveryService.addItem(new CompositeProduct(title,list));
                    }catch(AssertionError assertionError){
                        error(assertionError.getMessage());
                        return;
                    }

                    adminFrame.updateList(deliveryService.getMenuItems());
                });
                adminFrame.getSave().addActionListener(e1->{
                    Serializer.SERIALIZER.serialize(deliveryService.getMenuItems(),FileNames.ITEMS);
                    JOptionPane.showMessageDialog(new JFrame(),"Changes saved.","Info",JOptionPane.INFORMATION_MESSAGE);
                });
            }
            if(user.getRole()==UserRole.EMPLOYEE){
                employeeFrame.update();
                employeeFrame.setVisible(true);
            }
        });
        registerFrame.getRegister().addActionListener(e->{
            try{
                userService.addUser(registerFrame.getUsername(),registerFrame.getPassword());
            }catch(Exception exception){
                registerFrame.colorLines(exception.getMessage());
                return;
            }

            registerFrame.colorLines(null);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            registerFrame.setVisible(false);
        });

        employeeFrame.getOrderDone().addActionListener(e->{
            List<Object> objects;
            try{
                objects=employeeFrame.getList().getSelectedValuesList();
            }catch (Exception exception){
                error("No items selected.");
                return;
            }
            if(objects==null||objects.size()<1){
                error("No items selected.");
                return;
            }
            ArrayList<MenuItem> list=new ArrayList<>();
            for(Object object:objects)
                deliveryService.getCurrentOrders().remove(object);

            employeeFrame.update();
            Serializer.SERIALIZER.serialize(deliveryService.getCurrentOrders(),FileNames.CURRENT_ORDERS);
        });
    }

    public void error(String message){
        JOptionPane.showMessageDialog(new JFrame(),message,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
