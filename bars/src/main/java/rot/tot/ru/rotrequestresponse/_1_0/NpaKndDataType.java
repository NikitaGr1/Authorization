//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.06.22 at 06:54:51 PM MSK 
//


package rot.tot.ru.rotrequestresponse._1_0;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for NpaKndDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NpaKndDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="npaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="npaPublicId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="npaTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="npaType" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}CodeTitleType" minOccurs="0"/&gt;
 *         &lt;element name="npaApprovingAuthority" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}CodeTitleType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="npaAcceptanceDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="npaNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="npaLinkPravoGovRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NpaKndDataType", propOrder = {
        "id",
    "npaId",
    "npaPublicId",
    "npaTitle",
    "npaType",
    "npaApprovingAuthority",
    "npaAcceptanceDate",
    "npaNumber",
    "npaLinkPravoGovRu"
})
@Document
public class NpaKndDataType {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    protected String id;

    protected String npaId;
    protected String npaPublicId;
    protected String npaTitle;
    protected CodeTitleType npaType;
    protected List<CodeTitleType> npaApprovingAuthority;
    @XmlSchemaType(name = "dateTime")
    protected Date npaAcceptanceDate;
    protected String npaNumber;
    protected String npaLinkPravoGovRu;

    /**
     * Gets the value of the npaId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpaId() {
        return npaId;
    }

    /**
     * Sets the value of the npaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpaId(String value) {
        this.npaId = value;
    }

    /**
     * Gets the value of the npaPublicId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpaPublicId() {
        return npaPublicId;
    }

    /**
     * Sets the value of the npaPublicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpaPublicId(String value) {
        this.npaPublicId = value;
    }

    /**
     * Gets the value of the npaTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpaTitle() {
        return npaTitle;
    }

    /**
     * Sets the value of the npaTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpaTitle(String value) {
        this.npaTitle = value;
    }

    /**
     * Gets the value of the npaType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeTitleType }
     *     
     */
    public CodeTitleType getNpaType() {
        return npaType;
    }

    /**
     * Sets the value of the npaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeTitleType }
     *     
     */
    public void setNpaType(CodeTitleType value) {
        this.npaType = value;
    }

    /**
     * Gets the value of the npaApprovingAuthority property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the npaApprovingAuthority property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNpaApprovingAuthority().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeTitleType }
     * 
     * 
     */
    public List<CodeTitleType> getNpaApprovingAuthority() {
        if (npaApprovingAuthority == null) {
            npaApprovingAuthority = new ArrayList<CodeTitleType>();
        }
        return this.npaApprovingAuthority;
    }

    /**
     * Gets the value of the npaAcceptanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getNpaAcceptanceDate() {
        return npaAcceptanceDate;
    }

    /**
     * Sets the value of the npaAcceptanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNpaAcceptanceDate(Date value) {
        this.npaAcceptanceDate = value;
    }

    /**
     * Gets the value of the npaNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpaNumber() {
        return npaNumber;
    }

    /**
     * Sets the value of the npaNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpaNumber(String value) {
        this.npaNumber = value;
    }

    /**
     * Gets the value of the npaLinkPravoGovRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpaLinkPravoGovRu() {
        return npaLinkPravoGovRu;
    }

    /**
     * Sets the value of the npaLinkPravoGovRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpaLinkPravoGovRu(String value) {
        this.npaLinkPravoGovRu = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NpaKndDataType that = (NpaKndDataType) o;
        return Objects.equals(npaId, that.npaId) && Objects.equals(npaPublicId, that.npaPublicId) && Objects.equals(npaTitle, that.npaTitle) && Objects.equals(npaType, that.npaType) && Objects.equals(npaApprovingAuthority, that.npaApprovingAuthority) && Objects.equals(npaAcceptanceDate, that.npaAcceptanceDate) && Objects.equals(npaNumber, that.npaNumber) && Objects.equals(npaLinkPravoGovRu, that.npaLinkPravoGovRu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(npaId, npaPublicId, npaTitle, npaType, npaApprovingAuthority, npaAcceptanceDate, npaNumber, npaLinkPravoGovRu);
    }
}