package com.mango.controllers;

import com.mango.dtos.UserDto;
import com.mango.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;


	@GetMapping("/users")
	List<UserDto> findAll(){
		return userService.finalAll();
	}

	@GetMapping("/users/{id}")
	ResponseEntity findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.findById(id));
	}

	@GetMapping("/signin")
	ResponseEntity loginUser(@Valid @RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.findByUser(userDto));
	}

	@PostMapping("/users")
	ResponseEntity create(@Valid @RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDto));
	}

	@PutMapping("/updateUser")
	ResponseEntity update(@Valid @RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto));
	}

	@DeleteMapping("/users/{id}")
	ResponseEntity deleteById(@PathVariable Long id){
		userService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
