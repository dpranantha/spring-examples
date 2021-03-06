package lab04;

import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lab04.model.Product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class MarshallingXMLProduct {

    private static final String ANY_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><product><name>XYZ</name><price>10</price></product>";
    private static final long ANY_PRICE = 10L;
    private static final String ANY_PRODUCT = "XYZ";
    private static final String ANY_FILE = "product.xml";
    private JAXBContext context;
    private ByteArrayOutputStream output;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
   private File file;
    //private ObjectMapper mapper; //used for JSON
 
    @Before
    public void setUp() throws Exception {
        context = JAXBContext.newInstance(Product.class);
        output = new ByteArrayOutputStream();
        marshaller = context.createMarshaller();
        unmarshaller = context.createUnmarshaller();
        file = new File(ANY_FILE);
    }

    @After
    public void tearDown() throws Exception {
        output.flush();
    }

    @Test
    public void marshallAProduct() throws JAXBException {
         Product product = new Product(ANY_PRODUCT,ANY_PRICE);
         marshaller.marshal(product, output);
         marshaller.marshal(product, file);
         assertThat(output.toString(), is(ANY_XML));
    }

    @Test
    public void unmarshallAnXML() throws JAXBException {
        Product product = (Product) unmarshaller.unmarshal(file);
        assertThat(product.getName(), is(ANY_PRODUCT));
    }
}
