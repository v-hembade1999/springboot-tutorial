package com.example.springboot;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springboot.dao.usersrepo;
import com.example.springboot.entity.users;

@SpringBootApplication
public class SpringbootApplication 
{

	public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		usersrepo repo = context.getBean(usersrepo.class);
		//create user object
		
	    //users user = new users();
		//user.setName("rock");
		//user.setCity("pune");
		//users u1  = repo.save(user);
		//System.out.println(u1);
		
		//users user1 = new users();
		//user1.setName("rock2");
		//user1.setCity("pune2");
		//users u2 = repo.save(user1);
		//System.out.println(u2);
		
		//update the user
		//Optional<users> optional = repo.findById(1);
		//users user = optional.get();
		//user.setName("john");
		//user.setCity("mumbai");
		//repo.save(user);
		//System.out.println(user);
		
		//get data
		//Iterable<users> itr =  repo.findAll();
		//itr.forEach(users->{System.out.println(users);});
		
		//delete
		//repo.deleteById(1);
		//System.out.println("deleted");
		
		//custom finder method
		List<users> user = repo.findByName("rock2");
		user.forEach(e->System.out.println(e));
		
		List<users> user1 = repo.findByNameAndCity("rock2","pune2");
		user1.forEach(e->System.out.println(e));
		
		
		
		
		
	}

}
