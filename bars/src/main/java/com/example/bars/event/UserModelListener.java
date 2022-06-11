package com.example.bars.event;

import com.example.bars.document.Customer;
import com.example.bars.service.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserModelListener extends AbstractMongoEventListener<Customer> {

    private NextSequenceService sequenceGenerator;

    @Autowired
    public UserModelListener(NextSequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
        if (event.getSource().getAuid() < 1) {
            event.getSource().setAuid(sequenceGenerator.getNextSequence("customSequences"));
        }
    }


}