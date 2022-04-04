package week4_hw2.security.factory;

import org.springframework.security.core.GrantedAuthority;
import week4_hw2.domain.User;
import week4_hw2.security.pojo.JwtUser;

import java.util.Collection;
import java.util.List;

public class JwtUserFactory {

    private JwtUserFactory(){

    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getUserId(),
                user.getUsernmae(),
                user.getPassword(),
                user.getAuthorities()
        );
    }



}
