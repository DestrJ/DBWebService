/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entities.Capacitor;
import entities.Orders;
import entities.Resistor;
import entities.User;
import java.util.List;

/**
 *
 * @author Destr
 */
public interface IDBHandler {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User getUser(int id);
    public List<User> getAllUsers();
    public List<User> getUsersInRange(int from, int to);
    
    public void addResistor(Resistor resistor);
    public void updateResistor(Resistor resistor);   
    public void deleteResistor(Resistor resistor);
    public Resistor getResistor(int id);
    public List<Resistor> getAllResistors();
    public List<Resistor> getResistorInRange(int from, int to);
    
    public void addCapacitor(Capacitor capacitor);
    public void updateCapacitor(Capacitor capacitor);
    public void deleteCapacitor(Capacitor capacitor);
    public Capacitor getCapacitor(int id);
    public List<Capacitor> getAllCapacitors();
    public List<Resistor> getCapacitorInRange(int from, int to); 
    
    public void addOrder(Orders orders);
    public void updateOrder(Orders orders);
    public void deleteOrder(Orders orders);
    public User getOrder(int id);
    public List<User> getAllOrders();
    public List<User> getOrdersInRange(int from, int to);    
}
