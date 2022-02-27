package at.htlleonding.persistence;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @OneToOne(mappedBy = "Customer")
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "Customer")
    @JoinColumn(name = "billing_adress_id")
    private Set<BillingAddress> billingAddresses = new HashSet<>();

    @OneToMany(mappedBy = "Customer")
    @JoinColumn(name = "shipping_adress_id")
    private Set<ShippingAddress> shippingAddresses = new HashSet<>();

    @OneToMany(mappedBy = "Customer")
    private Set<SalesOrder> salesOrders = new HashSet<>();

    @OneToOne(mappedBy = "Customer")
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    public Customer(){}

    public Customer(int id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<BillingAddress> getBillingAddresses() {
        return billingAddresses;
    }

    public void setBillingAddresses(Set<BillingAddress> billingAddresses) {
        this.billingAddresses = billingAddresses;
    }

    public Set<ShippingAddress> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(Set<ShippingAddress> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    public Set<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public void setSalesOrders(Set<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}