package pl.psnc.hamerhed.mongodb.persistance;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pl.psnc.hamerhed.mongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
