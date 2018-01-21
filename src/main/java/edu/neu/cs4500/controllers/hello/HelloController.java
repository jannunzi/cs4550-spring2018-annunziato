package edu.neu.cs4500.controllers.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {
	
	@Autowired
	HelloRepository helloRepository;
	
	@RequestMapping("/api/hello/insert")
	public HelloObject insertHelloObject() {
		HelloObject obj = new HelloObject("Hello JPA!");
		helloRepository.save(obj);
		return obj;
	}
	
	@RequestMapping("/api/hello/insert/{message}")
	public HelloObject insertMessage(@PathVariable("message") String message) {
		HelloObject obj = new HelloObject(message);
		helloRepository.save(obj);
		return obj;
	}
	
	@RequestMapping("/api/hello/select/all")
	public List<HelloObject> selectAllHelloObjects() {
		List<HelloObject> hellos = (List<HelloObject>)helloRepository.findAll();
		return hellos;
	}

	@RequestMapping("/api/hello/string")
	public String sayHello() {
		return "Hello World 123!";
	}
	
	@RequestMapping("/api/hello/object")
	public HelloObject sayHelloObject() {
		HelloObject obj = new HelloObject("Hello World 234!");
		return obj;
	}
}
