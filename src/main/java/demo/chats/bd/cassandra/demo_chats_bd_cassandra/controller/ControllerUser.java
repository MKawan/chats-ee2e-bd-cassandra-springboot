package demo.chats.bd.cassandra.demo_chats_bd_cassandra.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.User;
import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.DTOs.DTOMessager;
import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.DTOs.DTOUser;
import demo.chats.bd.cassandra.demo_chats_bd_cassandra.services.ServiceUser;

@RestController
@RequestMapping("/api/v1/chat")
public class ControllerUser {
	
    @Autowired
	private ServiceUser serviceUser;
    
    //               <<<----------GETTINGS---------->>>
    
    @GetMapping("/consult")
    public Optional<User> getId(UUID id)
    {
    	return serviceUser.getId(id);
    }
    // Endpoint para buscar um usuário pelo nome
    @GetMapping("/consult/{name}")
    public List<User> getUserByUsername(@PathVariable String name) {
      return (List<User>) serviceUser.getUserByName(name);
    }
    
    @GetMapping("/consult/all")
    public Iterable<User> userAlls(){
    	return serviceUser.userAll();
    }
    
    
    //               <<<----------POST---------->>>
    
    @PostMapping("/create/user")
	public User createUser(@RequestBody DTOUser dtoUser) {
		return serviceUser.createUser(dtoUser);
	}
    
    @PostMapping("/sender/message")
    public void sender(String numberSend, DTOMessager dtoMessager) {
    	serviceUser.sendMessage(numberSend, dtoMessager);
    }
	
    @PutMapping("/update")
    public User update(String name, String number) {
    	return serviceUser.updaUser(name, number);
    }
    
    
    //               <<<----------DELETE---------->>>
    
    @DeleteMapping("/delete/{number}")
    public void delete(String number){
    	serviceUser.deleteNumber(number);
    }
    
    @DeleteMapping("/delete/{phoneNumber}/{messageId}")
    public void delete(String phoneNumber, UUID messageId){
    	serviceUser.deleteMessage(phoneNumber, messageId);
    }
}
