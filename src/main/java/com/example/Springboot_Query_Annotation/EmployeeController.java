package com.example.Springboot_Query_Annotation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository erepo;
	@RequestMapping("/test")
	public String test()
	{
		return "this is test for query annotation";
	}
	@PostMapping("/save")
	public String save(@RequestBody Employee emp)
	{
		erepo.save(emp);
		return "data saved";
	}
	@GetMapping("/show")
	public List<Employee> showall()
	{
		return erepo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Employee> byid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	@RequestMapping("/by/{id}")
	public Employee getByid(@PathVariable int id )
	{
		return erepo.getById(id);
	}
	@GetMapping("/name/{name}")
	public List<Employee>byname(@PathVariable String name)
	{
		return erepo.getByName(name);
	}
	@GetMapping("/city/{city}")
	public List<Employee>bycity(@PathVariable String city)
	{
		return erepo.getByCity(city);
	}
	@GetMapping("/both/{name}/{city}")
	public List<Employee>both(@PathVariable String name,@PathVariable String city)
	{
		return erepo.getByNameAndCity(name,city);
	}
	@GetMapping("/age/{age}")
	public List<Employee>byage(@PathVariable int age)
	{
		return erepo.getByAge(age);
	}
}
