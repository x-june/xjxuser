package com.xjxuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xjxuser.mapper")
public class XjxuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(XjxuserApplication.class, args);
	}
}
