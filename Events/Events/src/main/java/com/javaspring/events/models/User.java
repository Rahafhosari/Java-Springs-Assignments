package com.javaspring.events.models;

import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "First Name must be at least 2 characters.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only letters")
    private String firstName;

    @NotEmpty
    @Size(min = 2, message = "Last Name must be at least 2 characters.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Last Name contain only letters")
    private String lastName;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    @Email(message="Invalid email format!")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$",
            message = "Invalid password format, Try Again!")
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "planner",fetch = FetchType.LAZY)
    private List<Event> eventsPlanned;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<Message> messages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="users_events",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="event_id")
    )

    private List<Event> eventsAttending;


    public User() {}

    public User(String firstName,String lastName,String email, String password, String passwordConfirmation,String city, String State) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

//Getters

    public Long getId() {
        return id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

//Setters
    public void setId(Long id) { this.id = id; }

    public void setFirstName(String firstName) {   this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setCity(String city) { this.city = city;}

    public void setState(String state) { this.state = state; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
