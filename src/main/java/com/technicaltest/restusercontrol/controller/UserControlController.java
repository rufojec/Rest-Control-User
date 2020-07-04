package com.technicaltest.restusercontrol.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.technicaltest.restusercontrol.model.ResponseDes;
import com.technicaltest.restusercontrol.model.User;
import com.technicaltest.restusercontrol.repository.UserDao;
import com.technicaltest.restusercontrol.services.IrestServiceConsumer;

@RestController
@RequestMapping("users")
public class UserControlController {
	private final static Logger log = LoggerFactory.getLogger(UserControlController.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private IrestServiceConsumer consumer;
	
	@PostMapping()
	public User createUser(@RequestBody User userRequest) {
		log.info("initiating user creation");
		userDao.save(userRequest);
		return userRequest;
	}
	
	@GetMapping()
	public @ResponseBody Iterable<User> getAllUsers() {
		log.info("initiating list all user");
	    return userDao.findAll();
	}
	
	@GetMapping(path="/get")
	public User getUsersFromEmail(@RequestParam(value="email") String email) {
		log.info("initiating list all user");
	    return userDao.findByEmail(email);
	}
	
	@PostMapping(path="/ionix")
	public ResponseDes postIonixDes(@RequestParam(value="param")String param) throws RestClientException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return consumer.postConsult(param);
	}
}
