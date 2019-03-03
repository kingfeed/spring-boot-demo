package com.k.i.n.g.f.demo;

import com.k.i.n.g.f.demo.dao.PersonDao;
import com.k.i.n.g.f.demo.dao.PetDao;
import com.k.i.n.g.f.demo.entity.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private PersonDao personDao;
	@Autowired
	private PetDao petDao;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testPersonUpdate(){
		System.out.println(personDao.updateNameById(1));;
	}
	@Test
	public void testPetInsert(){
		petDao.insertPet(new Pet("zjl",1));
	}

	@Test
	public void testPetUpdate(){
		petDao.updatePetById(new Pet("zjl",1,2),6);
	}

	@Test
	public void testConcurrentPetUpdate(){

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				petDao.updatePetById(new Pet(Thread.currentThread().getName(),2,4),6);
			}
		};

		Thread t1 = new Thread(runnable,"t1");
		Thread t2 = new Thread(runnable,"t2");
		Thread t3 = new Thread(runnable,"t3");

		t2.start();
		t1.start();
		t3.start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindAllPet(){
		petDao.findAll();
	}

}
