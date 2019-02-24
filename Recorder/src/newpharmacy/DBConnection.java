package newpharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public ArrayList<String> list= new ArrayList<String>();
    public String [] tables = new String[list.size()];
    
    
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "");
            
            st = con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void verify(JTextField username, JPasswordField password){
        try{
            String query = "select * from users where username = ? and password = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            rs = pst.executeQuery();
            if(rs.next()){                
                MainWindow main = new MainWindow();
                main.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Login failed!");
//                Login login = new Login();
//                login.setVisible(true);
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void fillCombo(JComboBox combo_name){
        try{
            String query = "select * from tables";
            rs = st.executeQuery(query);
            
            while(rs.next()){
                String name = rs.getString("name_date");
                combo_name.addItem(name);
//                System.out.println(name);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void createTable(String tablename){
        try{
            String query1 = "CREATE TABLE "+tablename+" (" 
            + "id INT NOT NULL AUTO_INCREMENT,"  
            + "itemname VARCHAR(20)," 
            + "amount INT, "
            + "price FLOAT, "
            + "customer VARCHAR(30), "
            + "PRIMARY KEY(id))";
            
           
                        
            st = con.createStatement();         
            st.executeUpdate(query1);
            
            
//            System.out.println("here");
        }
        catch(Exception e){
            
        }
    }
    public void insertintotables(String date, String creator){
        try{
            String query = "insert into tables (name_date, creator) values(?, ?)";
            pst =  con.prepareStatement(query);            
            pst.setString(1, date);
            pst.setString(2, creator);
            pst.execute();
            
//            System.out.println("tables");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void addRecords(String tablename, String itemname, String amount, String price, String customer){
        try{
            String query = "insert into "+tablename+" (itemname, amount, price, customer) values(?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, itemname);
            pst.setString(2, amount);
            pst.setString(3, price);
            pst.setString(4, customer);            
            pst.execute();
            System.out.println("fill");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void getTables(){
        try{
            String query = "select * from tables";
            rs = st.executeQuery(query);            
            int c = 0;
            while(rs.next()){
                list.add(rs.getString("name_date"));          
            }
            
            tables = list.toArray(tables);
//            System.out.println(tables.length);
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public String getTable(){
        String table = null;
        try{
            
            String query = "select name_date from tables order by id desc limit 1";
            rs = st.executeQuery(query);            
            
            while(rs.next()){
                table = rs.getString("name_date");
            }
        }
        catch(Exception e){
            
        }
        return table;
    }
    
    
    public void fillRecordsTable(JTable tablename, String query){
        try{
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();            
            tablename.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    }
    
    public String setValues(String query, String column) throws SQLException{
        try{            
            rs = st.executeQuery(query);
            while(rs.next()){
                return rs.getString(column);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs.getString(column);
    }
}
