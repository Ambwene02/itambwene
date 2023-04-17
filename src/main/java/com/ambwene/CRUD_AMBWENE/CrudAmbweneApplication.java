package com.ambwene.CRUD_AMBWENE;

import com.ambwene.CRUD_AMBWENE.entity.SpeakerEntity;
import com.ambwene.CRUD_AMBWENE.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudAmbweneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudAmbweneApplication.class, args);
	}

	@Autowired
	private SpeakerRepository speakerRepository;
	@Override
	public void run(String... args) throws Exception {
		SpeakerEntity speakerEntity = new SpeakerEntity();
		speakerEntity.setSpeakerID(1234);
		speakerEntity.setSpeakerFirstName("Ambwene");
		speakerEntity.setSpeakerSecondName("Jonh");
		speakerEntity.setSpeakerEmail("ambwene@gmail.com");
		speakerEntity.setPhoneNo(0762241240);
		speakerEntity.setAddress("Ikuti");
		speakerRepository.save(speakerEntity);

	}
}
