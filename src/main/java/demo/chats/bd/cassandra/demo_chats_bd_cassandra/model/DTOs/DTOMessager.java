package demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DTOMessager{
	

    //               <<<----------ORM - OBJECT RELATIONAL MAPPING---------->>>
	

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 11, max =15, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String receiverPhoneNumber;

    private String messageContent;

    // Construtores
    public DTOMessager() {}
    
    //               <<<----------GETTERS E SETTERS---------->>>
    

	public String getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}


	public void setReceiverPhoneNumber(String receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

}
