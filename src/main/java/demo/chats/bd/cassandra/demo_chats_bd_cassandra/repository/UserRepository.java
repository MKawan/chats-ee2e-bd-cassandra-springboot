package demo.chats.bd.cassandra.demo_chats_bd_cassandra.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Repository;

import demo.chats.bd.cassandra.demo_chats_bd_cassandra.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@EnableCassandraRepositories
public interface UserRepository extends CassandraRepository<User, UUID> {
	
    //               <<<----------CUSTOM QUERIES---------->>>
	
	@AllowFiltering
	Optional<List<User>> findByName(String name);
	
	@AllowFiltering
	User findByPhoneNumber(String phoneNumber);

}
