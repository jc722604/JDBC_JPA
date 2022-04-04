package week4_hw2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "user_UUID")
    private int userId;

    @Column(name = "username")
    private String usernmae;

    @Column(name = "password")
    private String password;

    private Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
}
