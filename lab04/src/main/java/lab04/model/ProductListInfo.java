package lab04.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductListInfo {
    @XmlElementWrapper(name="product-info")
    @XmlElement(name="info")
    @JsonProperty
    private List<ProductInfo> productInfos= new ArrayList<ProductInfo>();

    public static ProductListInfo from(String baseUrl, Collection<Entry<Long, Product>> allProducts) {
        ProductListInfo products = new ProductListInfo();
        for(Entry<Long, Product> entry : allProducts) {
            products.add(baseUrl, entry);
        }
        return products;
    }

    private void add(String baseUrl, Entry<Long, Product> entry) {
        String url = String.format("%s/%d", baseUrl, entry.getKey());
        productInfos.add(new ProductInfo(url, entry.getKey(), entry.getValue()));
    }

}
