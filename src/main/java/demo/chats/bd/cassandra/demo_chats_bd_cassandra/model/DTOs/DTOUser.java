package demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DTOUser {
	
    //               <<<----------ORM - Object Relational Mapping---------->>>

    private String name;
    
    @Column(length = 15) // Limita o número de caracteres no banco de dados
	@NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 10, max = 15, message = "'${validatedValue}'O número de telefone deve ter entre {min} e {max} dígitos")
    private String phoneNumber;

    //               <<<----------GETTERS E SETTERS---------->>>
    
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
