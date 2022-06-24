package com.example.bars;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import rot.tot.ru.rotrequestresponse._1_0.ROTResponseType;

import java.io.File;

@SpringBootApplication
public class BarsApplication {

	public static void main(String[] args) throws JAXBException {
		SpringApplication.run(BarsApplication.class, args);

		/*JAXBContext jaxbContext = JAXBContext.newInstance("rot.tot.ru.rotrequestresponse._1_0");
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<ROTResponseType> responseElement = (JAXBElement<ROTResponseType>) unmarshaller.unmarshal(new File("src/main/resources/schema.xml"));
		ROTResponseType response = responseElement.getValue();
		System.out.println(response);*/
	}

}
