package co.unicauca.solid.isp.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Libardo, Julio
 */
public class User {

    public int UserId;
    public String Email;
    public LocalDateTime CreationDate;

    public User(int UserId, String Email, LocalDateTime CreationDate) {
        this.UserId = UserId;
        this.Email = Email;
        this.CreationDate = CreationDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public LocalDateTime getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDateTime CreationDate) {
        this.CreationDate = CreationDate;
    }

}
