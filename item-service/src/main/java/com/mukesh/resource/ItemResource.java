package com.mukesh.resource;

import java.util.List;

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
import org.springframework.web.client.RestTemplate;

import com.mukesh.dto.ItemDTO;
import com.mukesh.service.ItemService;

@RequestMapping("/items")
@RestControllerAdvice
@RestController
@RefreshScope
public class ItemResource {

	// Here we are Implementing Load Balancing using Ribbon
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/invoke")
	public String serverLocation() {
		String url = "http://customer-service/customers/app";
		return restTemplate.getForObject(url, String.class);
	}

	@Value("${item.test}")
	private String test;

	// config -server-profile
	@GetMapping("/test")
	public String test() {
		return test;
	}

	@Autowired
	private ItemService itemService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<ItemDTO> all() {
		return itemService.all();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{itemName}")
	public ItemDTO get(@PathVariable String itemName) {
		return itemService.get(itemName);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{itemName}")
	public ItemDTO put(@PathVariable String itemName, @RequestBody ItemDTO itemDTO) {
		itemDTO.setName(itemName);
		return itemService.save(itemDTO);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		itemService.delete(id);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ItemDTO add(@RequestBody ItemDTO itemDTO) {
		return itemService.save(itemDTO);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Throwable ex) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
