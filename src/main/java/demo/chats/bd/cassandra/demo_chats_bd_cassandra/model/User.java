package demo.chats.bd.cassandra.demo_chats_bd_cassandra.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Table;

import jakarta.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Frozen;

import lombok.Data;

@Table("users")
@Data
public class User {
    
    //               <<<----------ORM - Object Relational Mapping---------->>>
	
	@CassandraType(type = CassandraType.Name.TEXT)
	@Column("phone_number")
	@PrimaryKeyColumn(name = "phone_number", type = PrimaryKeyType.PARTITIONED)
	private String phoneNumber;
	
	@CassandraType(type = CassandraType.Name.UUID)
	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.CLUSTERED)
	private UUID id;

	@CassandraType(type = CassandraType.Name.TEXT)
	private String name;

	@NotNull
	@Frozen
	@Column("sent_messages")
    private List<Messager> sentMessages = new ArrayList<>();
	

    //               <<<----------GETTERS E SETTERS---------->>>
	
	
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Messager> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Messager> message) {
		this.sentMessages = (@Frozen List<Messager>) message;
	}

}
