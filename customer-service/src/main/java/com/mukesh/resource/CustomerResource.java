package com.mukesh.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mukesh.dto.CustomerDTO;
import com.mukesh.service.CustomerService;

@RequestMapping("/customers")
@RestControllerAdvice
@RefreshScope
@RestController
public class CustomerResource {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerResource.class);

	@Value("${server.port}")
	private String port;

	// ribbon -load-balancing
	@GetMapping("/app")
	public String getApp() {
		return "the port is" + port;
	}

	@Value("${customer.test}")
	private String test;

	// config -server-profile
	@GetMapping("/test")
	public String test() {
		return test;
	}

	// Method for Hystrix
	@RequestMapping("/hystrix")
	public String HelloHystrixyClass() {
		return "Hello From Customer -service";
	}

	@Autowired
	private CustomerService customerService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<CustomerDTO> all() {
		return customerService.all();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public CustomerDTO get(@PathVariable long id) {
		return customerService.get(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public CustomerDTO put(@PathVariable long id, @RequestBody CustomerDTO customerDTO) {
		customerDTO.setId(id);
		return customerService.save(customerDTO);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(long id) {
		customerService.delete(id);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO add(@RequestBody CustomerDTO customerDTO) {
		return customerService.save(customerDTO);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Throwable ex) {
		LOG.error("There was an error: ", ex);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
