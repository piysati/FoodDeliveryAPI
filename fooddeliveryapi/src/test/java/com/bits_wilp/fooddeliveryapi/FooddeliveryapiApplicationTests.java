package com.bits_wilp.fooddeliveryapi;

import com.bits_wilp.fooddeliveryapi.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FooddeliveryapiApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className = this.userRepo.getClass().getName();
		String packageNAme = this.userRepo.getClass().getPackageName();
		//when we autowire repo ca=lass a class is created by jvm at runtime even if you dont annotate repo interface
		System.out.println(className);
		System.out.println(packageNAme);
	}

}
