package myspringbootdemo.emailmng.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;

 
import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
//@Table(name = "email")
@Data
public class EMail {
 
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
 
    private String emailSubject;
 
    private String emailContent;
 
    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", emailSubject='" + emailSubject + '\'' +
                ", emailContent='" + emailContent + '\'' +
                '}';
    }
}
 