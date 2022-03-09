/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author aliso
 */
public class DBAccess {
    private Connection con;
    private Statement stmt;
    private SQLException connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            stmt = con.createStatement();
            return null;
        }
        catch (SQLException e){return e;}
    }
    
    private SQLException close() {
        try {
            stmt.close();
            con.close();
            return null;
        }
        catch (SQLException e) {return e;}
    }
    
    public SQLException insert (String s) {
        connect();
        try {
            stmt.executeUpdate(s);
        }
        catch (SQLException e){return e;}
        close();
        return null;
    }
    
    public SQLException getAuthor (Author a){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery("select * from Author where id = " + a.id);
            while (rs.next())
                a.name = rs.getString("name");
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException getBook (Book b){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery("select * from Book where icbn = " + b.icbn);
            while (rs.next()){
                b.title = rs.getString("title");
                b.author = rs.getString("author");
                b.publisher = rs.getString("publisher");
            }
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException getEmployee (Employee e){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery("select * from Employee where id = " + e.id);
            while (rs.next()) {
                e.name = rs.getString("name");
                e.worksIn = rs.getString("Works In");
            }
        }
        catch (SQLException ex) {return ex;}
        return null;
    }
    
    public SQLException getLibrary (Library l){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery("select * from Library where name = " + l.name);
            while (rs.next())
                l.street = rs.getString("street");
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException getPublisher (Publisher p){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery("select * from Publisher where id = " + p.id);
            while (rs.next()) {
                p.name = rs.getString("name");
                p.country = rs.getString("country");
            }
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException runAEPQuery (String s, ArrayList <String> myArr){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery(s);
            while (rs.next())
                myArr.add(rs.getString("ID"));
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException runBookQuery (String s, ArrayList <String> myArr){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery(s);
            while (rs.next())
                myArr.add(rs.getString("icbn"));
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException runLibraryQuery (String s, ArrayList <String> myArr){
        ResultSet rs;
        connect();
        try {
            rs = stmt.executeQuery(s);
            while (rs.next())
                myArr.add(rs.getString("Name"));
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException deleteAuthor(String id){
        connect();
        try {
            stmt.executeUpdate("delete from Author where id = " + id);
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException deleteBook(String icbn){
        connect();
        try {
            stmt.executeUpdate("delete from Book where icbn = " + icbn);
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException deleteEmployee(String id){
        connect();
        try {
            stmt.executeUpdate("delete from Employee where id = " + id);
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException deleteLibrary(String name){
        connect();
        try {
            stmt.executeUpdate("delete from Library where name = " + name);
        }
        catch (SQLException e) {return e;}
        return null;
    }
    
    public SQLException deletePublisher(String id){
        connect();
        try {
            stmt.executeUpdate("delete from Publisher where id = " + id);
        }
        catch (SQLException e) {return e;}
        return null;
    }
}
