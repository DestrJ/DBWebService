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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Destr
 */
public class DatabaseHandler implements IDBHandler{
    
    private final String JDBCDRIVERNAME = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "123";
    
    private Connection getDBConnection() {
        try {
            Class.forName(JDBCDRIVERNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection dbConnection = DriverManager.getConnection(URL, USER, PASSWORD)){
            return dbConnection;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        Connection dbConnection = getDBConnection();
        String insertUserSQL = "INSERT INTO users (name, password, privilege) VALUES('"+user.getName()+"','"+user.getPassword()+"','"+user.getPrivilege()+"');";
        try (Statement statement = dbConnection.createStatement()) {
            statement.execute(insertUserSQL);
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(User user) {
        Connection dbConnection = getDBConnection();
        String deleteUserSQL = "DELETE * FROM users WHERE id = "+user.getId();
        try(Statement statement = dbConnection.createStatement()){
            statement.execute(deleteUserSQL);
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public User getUser(int id) {
        Connection dbConnection = getDBConnection();
        User user = null;
        String selectUserSQL = "SELECT * FROM users WHERE id = "+id;
        try(Statement statement = dbConnection.createStatement()){
            ResultSet rs = statement.executeQuery(selectUserSQL);
            rs.next();
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setPrivilege(rs.getBoolean("privilege"));
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Connection dbConnection = getDBConnection();
        List<User> users = new ArrayList<>();        
        String selectUsersSQL = "SELECT * FROM users;";
        try(Statement statement = dbConnection.createStatement()){
            ResultSet rs = statement.executeQuery(selectUsersSQL);
            User user;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPrivilege(rs.getBoolean("privilege"));
                users.add(user);
            }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public List<User> getUsersInRange(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addResistor(Resistor resistor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateResistor(Resistor resistor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteResistor(Resistor resistor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resistor getResistor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resistor> getAllResistors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resistor> getResistorInRange(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCapacitor(Capacitor capacitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCapacitor(Capacitor capacitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCapacitor(Capacitor capacitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Capacitor getCapacitor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Capacitor> getAllCapacitors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resistor> getCapacitorInRange(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrder(Orders orders) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Orders orders) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOrder(Orders orders) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getOrdersInRange(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
