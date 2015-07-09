package lab04.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
public class ProductInfo {
    @XmlElement
    @JsonProperty
    private Product product;
    @XmlElement
    @JsonProperty
    private Long id;
    @XmlElement
    @JsonProperty
    private String url;

    public ProductInfo() {
        //needed for marshalling
    }

    public ProductInfo(String url, Long id, Product product) {
        this.url = url;
        this.id = id;
        this.product = product;
    }

}
