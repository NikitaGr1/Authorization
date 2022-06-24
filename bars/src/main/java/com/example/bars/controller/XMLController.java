package com.example.bars.controller;

import com.example.bars.document.ROTResponseTypeDB;
import com.example.bars.repository.ResponseRepository;
import jakarta.xml.bind.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rot.tot.ru.rotrequestresponse._1_0.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class XMLController
{
    @Autowired
    private ResponseRepository responseRepository;

    @PostMapping("/getResponse")
    public ResponseEntity<String> createResponse(@RequestBody String xmlFile) throws JAXBException {
        /*ByteArrayInputStream xmlContentBytes = new ByteArrayInputStream(xmlFile.getBytes());
        JAXBContext jaxbContext = JAXBContext.newInstance("rot.tot.ru.rotrequestresponse._1_0");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<ROTResponseType> responseElement = (JAXBElement<ROTResponseType>) unmarshaller.unmarshal(xmlContentBytes);
        ROTResponseType response = responseElement.getValue();
        try {
            responseRepository.save(response);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }*/

        ByteArrayInputStream xmlContentBytes = new ByteArrayInputStream(xmlFile.getBytes());
        JAXBContext jaxbContext = JAXBContext.newInstance(ROTResponseType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ROTResponseType response = (ROTResponseType) unmarshaller.unmarshal(xmlContentBytes);
        List<ROTResponseType> responseList = new ArrayList<>();
        responseRepository.findAll().forEach(responseList::add);
        if (!responseList.isEmpty()) {
            for (ROTResponseType rotResponseType : responseList) {
                if (rotResponseType.equals(response)) {
                    return new ResponseEntity<>(rotResponseType.getId(), HttpStatus.FOUND);
                }
            }
        }
        try {
            responseRepository.save(response);
            return new ResponseEntity<>(response.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getRequest")
    public ResponseEntity<String> marshallToXML(@RequestParam(name = "requestType") String requestType) throws JAXBException {
        ROTRequestType rotRequestType = new ROTRequestType();
        switch (requestType) {
            case "mr_request":
                MRRequestType mrRequestType = new MRRequestType();
                mrRequestType.setDateFrom(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                mrRequestType.setDateTo(new Date());
                rotRequestType.setMRRequest(mrRequestType);
                break;
            case "su_request":
                SURequestType suRequestType = new SURequestType();
                suRequestType.setDateFrom(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                suRequestType.setDateTo(new Date());
                rotRequestType.setSURequest(suRequestType);
                break;
            case "npa_knds_request":
                NPARequestType npaRequestType = new NPARequestType();
                npaRequestType.setDateFrom(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                npaRequestType.setDateTo(new Date());
                rotRequestType.setNPARequest(npaRequestType);
                break;
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ROTRequestType.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(rotRequestType, sw);
            String xmlContent = sw.toString();
            return new ResponseEntity<>(xmlContent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
