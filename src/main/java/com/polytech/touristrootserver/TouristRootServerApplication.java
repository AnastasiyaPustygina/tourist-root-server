package com.polytech.touristrootserver;

import com.polytech.touristrootserver.domain.EmailCode;
import com.polytech.touristrootserver.repository.TouristRepository;
import com.polytech.touristrootserver.service.EmailCodeSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TouristRootServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouristRootServerApplication.class, args).getBean(EmailCodeSender.class);
	}
}
