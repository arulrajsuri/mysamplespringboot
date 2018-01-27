package com.sample.maven.samplemaven;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class samplecontroller {

	@RequestMapping("/getvalue")
	public String getvalue()
	{
		return "Jenkins updated again....";
	}
}
