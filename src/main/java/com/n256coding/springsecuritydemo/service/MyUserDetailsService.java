package com.n256coding.springsecuritydemo.service;

import com.n256coding.springsecuritydemo.config.MongoConfiguration;
import com.n256coding.springsecuritydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;


public class MyUserDetailsService implements UserDetailsService {

//    @Autowired
    private MongoOperations mongoOperations;

    public MyUserDetailsService() {
        MongoConfiguration config = new MongoConfiguration();
        mongoOperations = config.createConnection();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = new Query(where("username").is(username));
        List<User> users = mongoOperations.find(query, User.class);

        if (users.size() == 1) {
            User user = users.get(0);
            MongoUserDetails mongoUserDetails = new MongoUserDetails(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities().toArray(new String[user.getAuthorities().size()]));
            return mongoUserDetails;
        }else{
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
