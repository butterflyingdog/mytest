package myspringbootdemo.emailmng.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;
//import org.hibernate.annotations.Entity;
 
import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Table(name = "email")
@Data
public class EMail {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
 
    private String url;
 
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
————————————————
版权声明：本文为CSDN博主「java干货」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/dandandeshangni/article/details/108544261