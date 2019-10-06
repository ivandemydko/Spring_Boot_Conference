package one.persistence.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private Address address;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Time time;
    @JoinColumn(name = "speaker_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Speaker speaker;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "registeredlist",
            joinColumns = @JoinColumn(name = "report_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userList = new HashSet<>();
    private int presence;
    @Transient
    private boolean isUserRegistered;

    public Report(String name, Address address, Date date, Time time, Speaker speaker) {
        this.name = name;
        this.address = address;
        this.date = date;
        this.time = time;
        this.speaker = speaker;
    }

    public Report() {
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public boolean getIsUserRegistered() {
        return isUserRegistered;
    }

    public void setIsUserRegistered(boolean userRegistered) {
        isUserRegistered = userRegistered;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    public boolean isUserRegistered() {
        return isUserRegistered;
    }

    public void setUserRegistered(boolean userRegistered) {
        isUserRegistered = userRegistered;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return isUserRegistered == report.isUserRegistered &&
                Objects.equals(id, report.id) &&
                Objects.equals(name, report.name) &&
                Objects.equals(address, report.address) &&
                Objects.equals(date, report.date) &&
                Objects.equals(time, report.time) &&
                Objects.equals(speaker, report.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, date, time, speaker, isUserRegistered);
    }

}


