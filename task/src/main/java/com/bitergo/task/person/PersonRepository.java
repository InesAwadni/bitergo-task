package com.bitergo.task.person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
    @Query("SELECT AVG(age) FROM Person")
    int getAverageAge();
}
