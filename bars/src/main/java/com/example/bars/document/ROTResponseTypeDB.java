package com.example.bars.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import rot.tot.ru.rotrequestresponse._1_0.CodeTitleType;
import rot.tot.ru.rotrequestresponse._1_0.MRListType;
import rot.tot.ru.rotrequestresponse._1_0.NPAListType;
import rot.tot.ru.rotrequestresponse._1_0.SUListType;

import java.math.BigInteger;

@Document(collection = "rOTResponseType")
public class ROTResponseTypeDB
{
    @Id
    protected String id;

    protected CodeTitleType rotResponseStatus;
    protected NPAListType npaList;
    protected SUListType suList;
    protected MRListType mrList;
    protected BigInteger queryItemsQuantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CodeTitleType getRotResponseStatus() {
        return rotResponseStatus;
    }

    public void setRotResponseStatus(CodeTitleType rotResponseStatus) {
        this.rotResponseStatus = rotResponseStatus;
    }

    public NPAListType getNpaList() {
        return npaList;
    }

    public void setNpaList(NPAListType npaList) {
        this.npaList = npaList;
    }

    public SUListType getSuList() {
        return suList;
    }

    public void setSuList(SUListType suList) {
        this.suList = suList;
    }

    public MRListType getMrList() {
        return mrList;
    }

    public void setMrList(MRListType mrList) {
        this.mrList = mrList;
    }

    public BigInteger getQueryItemsQuantity() {
        return queryItemsQuantity;
    }

    public void setQueryItemsQuantity(BigInteger queryItemsQuantity) {
        this.queryItemsQuantity = queryItemsQuantity;
    }
}
