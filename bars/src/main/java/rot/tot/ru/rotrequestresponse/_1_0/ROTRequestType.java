//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.06.22 at 06:54:51 PM MSK 
//


package rot.tot.ru.rotrequestresponse._1_0;

import jakarta.xml.bind.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * <p>Java class for ROTRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ROTRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="NPARequest" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}NPARequestType"/&gt;
 *         &lt;element name="SURequest" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}SURequestType"/&gt;
 *         &lt;element name="MRRequest" type="{urn://ru.tot.rot/ROTRequestResponse/1.0.1}MRRequestType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROTRequestType", propOrder = {
        //"id",
    "npaRequest",
    "suRequest",
    "mrRequest"
})
@XmlRootElement(name = "ROTRequest")
@Document
public class ROTRequestType {

    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    protected String id;*/

    @XmlElement(name = "NPARequest")
    protected NPARequestType npaRequest;
    @XmlElement(name = "SURequest")
    protected SURequestType suRequest;
    @XmlElement(name = "MRRequest")
    protected MRRequestType mrRequest;

    /**
     * Gets the value of the npaRequest property.
     * 
     * @return
     *     possible object is
     *     {@link NPARequestType }
     *     
     */
    public NPARequestType getNPARequest() {
        return npaRequest;
    }

    /**
     * Sets the value of the npaRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NPARequestType }
     *     
     */
    public void setNPARequest(NPARequestType value) {
        this.npaRequest = value;
    }

    /**
     * Gets the value of the suRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SURequestType }
     *     
     */
    public SURequestType getSURequest() {
        return suRequest;
    }

    /**
     * Sets the value of the suRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SURequestType }
     *     
     */
    public void setSURequest(SURequestType value) {
        this.suRequest = value;
    }

    /**
     * Gets the value of the mrRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MRRequestType }
     *     
     */
    public MRRequestType getMRRequest() {
        return mrRequest;
    }

    /**
     * Sets the value of the mrRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MRRequestType }
     *     
     */
    public void setMRRequest(MRRequestType value) {
        this.mrRequest = value;
    }

}
