package com.example.bars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class BarsApplication {

	public static void main(String[] args) throws JAXBException, IOException {
		SpringApplication.run(BarsApplication.class, args);

		JAXBContext jaxbContext = JAXBContext.newInstance(ROTResponseType.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<ROTResponseType> rotResponseType = (JAXBElement<ROTResponseType>) unmarshaller.unmarshal(new File("resources/response.xml"));
		ROTResponseType response = rotResponseType.getValue();
		System.out.println(response);
	}


}
