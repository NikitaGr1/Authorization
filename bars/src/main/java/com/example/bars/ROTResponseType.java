//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.06.16 at 05:41:47 PM MSK 
//


package com.example.bars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for ROTResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ROTResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ROTResponseStatus" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}CodeTitleType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="NPAList" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}NPAListType"/&gt;
 *           &lt;element name="SUList" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}SUListType"/&gt;
 *           &lt;element name="MRList" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}MRListType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="queryItemsQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROTResponseType", propOrder = {
    "rotResponseStatus",
    "npaList",
    "suList",
    "mrList",
    "queryItemsQuantity"
})
public class ROTResponseType {

    @XmlElement(name = "ROTResponseStatus", required = true)
    protected CodeTitleType rotResponseStatus;
    @XmlElement(name = "NPAList")
    protected NPAListType npaList;
    @XmlElement(name = "SUList")
    protected SUListType suList;
    @XmlElement(name = "MRList")
    protected MRListType mrList;
    protected BigInteger queryItemsQuantity;

    /**
     * Gets the value of the rotResponseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CodeTitleType }
     *     
     */
    public CodeTitleType getROTResponseStatus() {
        return rotResponseStatus;
    }

    /**
     * Sets the value of the rotResponseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeTitleType }
     *     
     */
    public void setROTResponseStatus(CodeTitleType value) {
        this.rotResponseStatus = value;
    }

    /**
     * Gets the value of the npaList property.
     * 
     * @return
     *     possible object is
     *     {@link NPAListType }
     *     
     */
    public NPAListType getNPAList() {
        return npaList;
    }

    /**
     * Sets the value of the npaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link NPAListType }
     *     
     */
    public void setNPAList(NPAListType value) {
        this.npaList = value;
    }

    /**
     * Gets the value of the suList property.
     * 
     * @return
     *     possible object is
     *     {@link SUListType }
     *     
     */
    public SUListType getSUList() {
        return suList;
    }

    /**
     * Sets the value of the suList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SUListType }
     *     
     */
    public void setSUList(SUListType value) {
        this.suList = value;
    }

    /**
     * Gets the value of the mrList property.
     * 
     * @return
     *     possible object is
     *     {@link MRListType }
     *     
     */
    public MRListType getMRList() {
        return mrList;
    }

    /**
     * Sets the value of the mrList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MRListType }
     *     
     */
    public void setMRList(MRListType value) {
        this.mrList = value;
    }

    /**
     * Gets the value of the queryItemsQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQueryItemsQuantity() {
        return queryItemsQuantity;
    }

    /**
     * Sets the value of the queryItemsQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQueryItemsQuantity(BigInteger value) {
        this.queryItemsQuantity = value;
    }

}
