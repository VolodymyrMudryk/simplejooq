package com.mudryk.simplejooq.businesslayer.businessentities;

import org.joda.time.LocalDateTime;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class User implements Entity<Long> {

    private final long id;
    private final String name;
    private final LocalDateTime createDate;

    public User(long id, String name, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return createDate != null ? createDate.equals(user.createDate) : user.createDate == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
