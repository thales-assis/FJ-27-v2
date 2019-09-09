package br.com.alura.forum.repository; 

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.Course;

public interface CourseRepository extends Repository<Course, Long> {
	
	@Query("SELECT c FROM Course c "
			+ "WHERE c.name = :courseName")
	Optional<Course> findByName(String courseName);

}
