package demo.chats.bd.cassandra.demo_chats_bd_cassandra.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import jakarta.persistence.Entity;

@Entity
@UserDefinedType("messager")
public class Messager {

    //               <<<----------ORM - OBJECT RELATIONAL MAPPING---------->>>
	
	@Column("id")
	@CassandraType(type = CassandraType.Name.UUID)
	private UUID id;

    @Column("type_messager")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String typeMessager;

    @Column("receiver_phone_number")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String receiverPhoneNumber;

    @Column("message_content")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String messageContent;

    @Column("timestamp")
    @CassandraType(type = CassandraType.Name.TIMESTAMP) // Use TIMESTAMP em vez de DATE para LocalDateTime
    private LocalDateTime timestamp;


    //               <<<----------GETTERS E SETTERS---------->>>
    
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTypeMessager() {
		return typeMessager;
	}

	public void setTypeMessager(String typeMessager) {
		this.typeMessager = typeMessager;
	}

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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
