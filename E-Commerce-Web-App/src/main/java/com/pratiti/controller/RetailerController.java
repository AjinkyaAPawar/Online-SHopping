package com.pratiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.pratiti.service.RetailerService;

@RestController
@CrossOrigin
public class RetailerController {

	@Autowired
	private RetailerService retailerService;
	
}
