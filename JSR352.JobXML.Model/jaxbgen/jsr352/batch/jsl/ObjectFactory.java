//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vIBM 2.2.3-11/28/2011 06:21 AM(foreman)- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.01 at 03:04:46 PM EDT 
//


package jsr352.batch.jsl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jsr352.batch.jsl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Split_QNAME = new QName("http://batch.jsr352/jsl", "split");
    private final static QName _Job_QNAME = new QName("http://batch.jsr352/jsl", "job");
    private final static QName _Step_QNAME = new QName("http://batch.jsr352/jsl", "step");
    private final static QName _Flow_QNAME = new QName("http://batch.jsr352/jsl", "flow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jsr352.batch.jsl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExceptionClassFilter }
     * 
     */
    public ExceptionClassFilter createExceptionClassFilter() {
        return new ExceptionClassFilter();
    }

    /**
     * Create an instance of {@link Split }
     * 
     */
    public Split createSplit() {
        return new Split();
    }

    /**
     * Create an instance of {@link Step }
     * 
     */
    public Step createStep() {
        return new Step();
    }

    /**
     * Create an instance of {@link JSLJob }
     * 
     */
    public JSLJob createJSLJob() {
        return new JSLJob();
    }

    /**
     * Create an instance of {@link Flow }
     * 
     */
    public Flow createFlow() {
        return new Flow();
    }

    /**
     * Create an instance of {@link Batchlet }
     * 
     */
    public Batchlet createBatchlet() {
        return new Batchlet();
    }

    /**
     * Create an instance of {@link PartitionReducer }
     * 
     */
    public PartitionReducer createPartitionReducer() {
        return new PartitionReducer();
    }

    /**
     * Create an instance of {@link Stop }
     * 
     */
    public Stop createStop() {
        return new Stop();
    }

    /**
     * Create an instance of {@link Analyzer }
     * 
     */
    public Analyzer createAnalyzer() {
        return new Analyzer();
    }

    /**
     * Create an instance of {@link CheckpointAlgorithm }
     * 
     */
    public CheckpointAlgorithm createCheckpointAlgorithm() {
        return new CheckpointAlgorithm();
    }

    /**
     * Create an instance of {@link Partition }
     * 
     */
    public Partition createPartition() {
        return new Partition();
    }

    /**
     * Create an instance of {@link PartitionMapper }
     * 
     */
    public PartitionMapper createPartitionMapper() {
        return new PartitionMapper();
    }

    /**
     * Create an instance of {@link Collector }
     * 
     */
    public Collector createCollector() {
        return new Collector();
    }

    /**
     * Create an instance of {@link Chunk }
     * 
     */
    public Chunk createChunk() {
        return new Chunk();
    }

    /**
     * Create an instance of {@link PartitionPlan }
     * 
     */
    public PartitionPlan createPartitionPlan() {
        return new PartitionPlan();
    }

    /**
     * Create an instance of {@link JSLProperties }
     * 
     */
    public JSLProperties createJSLProperties() {
        return new JSLProperties();
    }

    /**
     * Create an instance of {@link Next }
     * 
     */
    public Next createNext() {
        return new Next();
    }

    /**
     * Create an instance of {@link Listener }
     * 
     */
    public Listener createListener() {
        return new Listener();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link End }
     * 
     */
    public End createEnd() {
        return new End();
    }

    /**
     * Create an instance of {@link Decision }
     * 
     */
    public Decision createDecision() {
        return new Decision();
    }

    /**
     * Create an instance of {@link Fail }
     * 
     */
    public Fail createFail() {
        return new Fail();
    }

    /**
     * Create an instance of {@link Listeners }
     * 
     */
    public Listeners createListeners() {
        return new Listeners();
    }

    /**
     * Create an instance of {@link ExceptionClassFilter.Include }
     * 
     */
    public ExceptionClassFilter.Include createExceptionClassFilterInclude() {
        return new ExceptionClassFilter.Include();
    }

    /**
     * Create an instance of {@link ExceptionClassFilter.Exclude }
     * 
     */
    public ExceptionClassFilter.Exclude createExceptionClassFilterExclude() {
        return new ExceptionClassFilter.Exclude();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Split }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://batch.jsr352/jsl", name = "split")
    public JAXBElement<Split> createSplit(Split value) {
        return new JAXBElement<Split>(_Split_QNAME, Split.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JSLJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://batch.jsr352/jsl", name = "job")
    public JAXBElement<JSLJob> createJob(JSLJob value) {
        return new JAXBElement<JSLJob>(_Job_QNAME, JSLJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Step }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://batch.jsr352/jsl", name = "step")
    public JAXBElement<Step> createStep(Step value) {
        return new JAXBElement<Step>(_Step_QNAME, Step.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://batch.jsr352/jsl", name = "flow")
    public JAXBElement<Flow> createFlow(Flow value) {
        return new JAXBElement<Flow>(_Flow_QNAME, Flow.class, null, value);
    }

}
