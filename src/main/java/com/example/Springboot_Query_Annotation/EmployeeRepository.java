package com.example.Springboot_Query_Annotation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	//JPQL
	
	@Query("from empployee_info b where b.id=?1")//position based
	//@Query("from empployee_info b where b.id=:id")// name based
      Employee getById(int id);
	
@Query("from empployee_info b where b.name=?1")
	List<Employee> getByName(String name);

@Query("from empployee_info b where b.city=:city")
List<Employee> getByCity(String city);

@Query("from empployee_info b where b.name=?1 and b.city=?2")
List<Employee> getByNameAndCity(String name, String city);

@Query("from empployee_info b where b.age=?1")
List<Employee> getByAge(int age);

}
