//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vIBM 2.2.3-11/28/2011 06:21 AM(foreman)- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.01 at 03:04:46 PM EDT 
//


package jsr352.batch.jsl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import com.ibm.batch.container.xjcl.ControlElement;
import com.ibm.batch.container.xjcl.ExecutionElement;


/**
 * <p>Java class for Flow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="properties" type="{http://batch.jsr352/jsl}Properties" minOccurs="0"/>
 *         &lt;element name="listeners" type="{http://batch.jsr352/jsl}Listeners" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="decision" type="{http://batch.jsr352/jsl}Decision"/>
 *           &lt;element name="step" type="{http://batch.jsr352/jsl}Step"/>
 *         &lt;/choice>
 *         &lt;group ref="{http://batch.jsr352/jsl}ControlElements" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="next" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="abstract" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="parent" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flow", propOrder = {
    "properties",
    "listeners",
    "executionElements",
    "controlElements"
})
@Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
/**
 * Modified post-XJC-gen by custom JSR352 RI build logic 
 * since we can't seem to get JAXB's XJC to generate 
 * elements implementing a common interface. 
 *
 * This custom logic adds the interface implementation : 
 *      implements com.ibm.batch.container.xjcl.ExecutionElement 
 */
 public class Flow implements com.ibm.batch.container.xjcl.ExecutionElement {

    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected JSLProperties properties;
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected Listeners listeners;
    @XmlElements({
        @XmlElement(name = "step", type = Step.class),
        @XmlElement(name = "decision", type = Decision.class)
    })
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected List<ExecutionElement> executionElements;
    @XmlElements({
        @XmlElement(name = "end", type = End.class),
        @XmlElement(name = "stop", type = Stop.class),
        @XmlElement(name = "next", type = Next.class),
        @XmlElement(name = "fail", type = Fail.class)
    })
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected List<ControlElement> controlElements;
    @XmlAttribute(name = "id", required = true)
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected String id;
    @XmlAttribute(name = "next")
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected String nextFromAttribute;
    @XmlAttribute(name = "abstract")
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected String _abstract;
    @XmlAttribute(name = "parent")
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected String parent;

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link JSLProperties }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public JSLProperties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JSLProperties }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setProperties(JSLProperties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the listeners property.
     * 
     * @return
     *     possible object is
     *     {@link Listeners }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public Listeners getListeners() {
        return listeners;
    }

    /**
     * Sets the value of the listeners property.
     * 
     * @param value
     *     allowed object is
     *     {@link Listeners }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setListeners(Listeners value) {
        this.listeners = value;
    }

    /**
     * Gets the value of the executionElements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the executionElements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExecutionElements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Step }
     * {@link Decision }
     * 
     * 
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public List<ExecutionElement> getExecutionElements() {
        if (executionElements == null) {
            executionElements = new ArrayList<ExecutionElement>();
        }
        return this.executionElements;
    }

    /**
     * Gets the value of the controlElements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlElements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlElements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link End }
     * {@link Stop }
     * {@link Next }
     * {@link Fail }
     * 
     * 
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public List<ControlElement> getControlElements() {
        if (controlElements == null) {
            controlElements = new ArrayList<ControlElement>();
        }
        return this.controlElements;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the nextFromAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public String getNextFromAttribute() {
        return nextFromAttribute;
    }

    /**
     * Sets the value of the nextFromAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setNextFromAttribute(String value) {
        this.nextFromAttribute = value;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public String getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setAbstract(String value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2012-10-01T03:04:46-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setParent(String value) {
        this.parent = value;
    }

}
