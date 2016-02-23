package cz.autocont.dtos;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Michael
 */
public class MessageDTO {
    
    private Long id;
    
    @NotNull
    @Size(min = 3)
    private String user;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateAndTime;
    
    private String text;
    
    public MessageDTO(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public int hashCode() {
        final int prime = 13;
        int result = 1;
        result = prime * result + user.hashCode();
        result = prime * result + dateAndTime.hashCode();
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MessageDTO)) {
            return false;
        }
        MessageDTO other = (MessageDTO) obj;
        if (user == null) {
            if (other.getUser()!= null) {
                return false;
            }
        } else if (!user.equals(other.getUser())) {
            return false;
        }
        if (dateAndTime == null) {
            if (other.getDateAndTime() != null) {
                return false;
            }
        } else if (!dateAndTime.equals(other.getDateAndTime())) {
            return false;
        }
        if (text == null) {
            if (other.getUser() != null) {
                return false;
            }
        } else if (!this.getText().equals(other.getText())) {
            return false;
        }
        return true;
    }
    
}
