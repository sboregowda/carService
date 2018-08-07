/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sathwick
 */

@Entity
@Table
@NamedQueries({@NamedQuery(name="Customer.getCust",query="SELECT e FROM Customer e")})
public class Customer implements Serializable{
    
    @Id
    @Column
    private String CustID;
    @Column
    private String Email;
    @Column
    private String Mobile;
    @Column
    private String Password;

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Customer(String CustID, String Email, String Mobile, String Password) {
        this.CustID = CustID;
        this.Email = Email;
        this.Mobile = Mobile;
        this.Password = Password;
    }

    public Customer(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }
    
    
    
    public Customer(){}
    
}
