package demo.chats.bd.cassandra.demo_chats_bd_cassandra.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.Messager;
import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.User;
import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.DTOs.DTOMessager;
import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.DTOs.DTOUser;
import demo.chats.bd.cassandra.demo_chats_bd_cassandra.repository.UserRepository;

@Service
public class ServiceUser {
	
	
	private UserRepository userRepository;
	
	@Autowired
	public ServiceUser (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
    //               <<<----------CREATE---------->>>
	
	
	//Metodo para criar usuario
	public User createUser(DTOUser dtoUser) {
		
		User user = new User();
		 
		String numberPhone = dtoUser.getPhoneNumber();
		User numeroExister = userRepository.findByPhoneNumber(numberPhone);
		 
		if (numeroExister != null) {
			throw new RuntimeException("Número de telefone já existe.");
		}
		 
		// Geração automática do UUID
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        
        user.setPhoneNumber(dtoUser.getPhoneNumber());
		user.setName(dtoUser.getName());
		return userRepository.save(user);
	}
	
    //               <<<----------CONSULT---------->>>
	
	
    // Método para buscar um usuário pelo nome
    public List<User> getUserByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }
    
    //buscar usuario pelo id
    public Optional<User> getId(UUID id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user == null) {
			throw new RuntimeException("Id não existe");
		}
		
		return user;
	}
    
    //Metodo para buscar todos os usuarios
    public Iterable<User> userAll(){
    	return userRepository.findAll();
    }
    
    //               <<<----------MESSAGERS---------->>>
    
    
    //enviando messagem
    public User sendMessage(String numberSend, DTOMessager dtoMessager) {

        // Verificar se o número existe
        User numeroExister = userRepository.findByPhoneNumber(numberSend);

        //checando numero no bd
		if (numeroExister == null) {
			throw new RuntimeException("Número de telefone não existe.");
		}
		
        // Criar a mensagem
        Messager message = new Messager();
        message.setId(UUID.randomUUID());
        message.setTypeMessager("send");
        message.setReceiverPhoneNumber(dtoMessager.getReceiverPhoneNumber());
        message.setMessageContent(dtoMessager.getMessageContent());
        message.setTimestamp(LocalDateTime.now());

        // Adicionar a nova mensagem ao bd
        numeroExister.getSentMessages().add(message);
        receivedMessager(dtoMessager);
        
        // Salvar as alterações no repositório
        return userRepository.save(numeroExister);
    }
    
    public User receivedMessager(DTOMessager dtoMessager) {

        // Verificar se o número existe
        User numeroExister = userRepository.findByPhoneNumber(dtoMessager.getReceiverPhoneNumber());
        
        //checando numero no bd
		if (numeroExister == null) {
			throw new RuntimeException("Número de telefone não existe.");
		}
		
        // Criar a mensagem
        Messager message = new Messager();
        message.setId(UUID.randomUUID());
        message.setTypeMessager("received");
        message.setReceiverPhoneNumber(dtoMessager.getReceiverPhoneNumber());
        message.setMessageContent(dtoMessager.getMessageContent());
        message.setTimestamp(LocalDateTime.now());

        // Adicionar a nova mensagem à lista
        numeroExister.getSentMessages().add(message);

        // Salvar as alterações no repositório
        return userRepository.save(numeroExister);
    }
     
    //               <<<----------UPDATE---------->>>
    
    
    //update usuario pelo numero
    public User updaUser(String name, String number){
		User numeroExister = userRepository.findByPhoneNumber(number);
		 
		if (numeroExister == null) {
			throw new RuntimeException("Número de telefone não existe.");
		}
		
		numeroExister.setName(name);
		numeroExister.setPhoneNumber(number);
		
		return userRepository.save(numeroExister);
    }
    
    //               <<<----------DELETES---------->>>
    
    
    //deletando um usuario pelo numero
    public void deleteNumber(String numberPhone) {
    	
		User numeroExister = userRepository.findByPhoneNumber(numberPhone);
		 
		if (numeroExister == null) {
			throw new RuntimeException("Número de telefone não existe.");
		}
		
		userRepository.delete(numeroExister);
	}
    
    public User deleteMessage(String phoneNumber, UUID messageId) {
    	
    	User user = userRepository.findByPhoneNumber(phoneNumber);
    	
    	if (user != null) {
	    	
	    	// Remove a mensagem da lista de sentMessages
	    	boolean removed = user.getSentMessages().removeIf(m ->
	    		m.getId().equals(messageId));
	    	if (removed) {
	    		
	    	// Salva o usuário atualizado no Cassandra
	    		return userRepository.save(user);
	    	}
	    	else{
	    		throw new RuntimeException("Mensagem não encontrada.");
	    	}

    	}else{
    		throw new RuntimeException("Usuário não encontrado.");
    	}
    }
}
