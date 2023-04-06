package com.em.login.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.em.login.models.LoginUser;
import com.em.login.models.User;
import com.em.login.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
//	-----------------------REGISTRATION-----------------------------------
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	
    	//Rejects if email exist:
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches","An account with that email ready exist");
    	}
    	
    	//Rejects if password doesn't match confirmation:
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches","Confirm PW must match");;
    	}
    	//return Null if results has erros:
    	if(result.hasErrors()) {
            return null;
    	}
    	//Hash and set PW save user to DB:
    	String hashed = BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    }
//	-----------------------LOGIN -----------------------------------  
 // This method will be called from the controller
    // whenever a user submits a login form.
    public User login(LoginUser newLoginUser, BindingResult result) {        
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
    	
    	//Find User in DB and REJECT if not found
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	//If USER exists-take from DB
    	User user = potentialUser.get();
        
    	//Reject if PW matches fails
    	if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	} 	
    	if(result.hasErrors()) {
        	return null;
        }
    	//return to user's object
    	return user;
    }
//	-----------------------find by ID / EMAIL----------------------------------
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }

    public User findByEmail(String email) {
		Optional<User> result = userRepo.findByEmail(email);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
    
    
}