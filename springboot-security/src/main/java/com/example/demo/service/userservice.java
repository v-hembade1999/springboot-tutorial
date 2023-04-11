package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
@Service
public class userservice 
{
	List<user> list = new ArrayList<>();
    userservice()
    {
    	list.add(new user("rock","redhat","abc@gmail.com"));
    	list.add(new user("jack","redhat","jack@gmail.com"));
    }
    
    //getallusers
    public List<user> getallusers()
    {
    	 return this.list;
    }
    
    //getuserbyname
    public user getuserbyname(String name)
    {
    	return this.list.stream().filter((user)->user.getUsername().equals(name)).findAny().orElse(null);
    }
    
    //adduser
    public user adduser(user u)
    {
    	this.list.add(u);
    	return u;
    }
}
