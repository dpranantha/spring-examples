package lab04;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import lab04.model.Product;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MarshallingJSONProduct {
    private static final long ANY_PRICE = 10L;
    private static final String ANY_PRODUCT = "XYZ";
    private ByteArrayOutputStream output;
    private ObjectMapper mapper; //used for JSON

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        mapper = new ObjectMapper();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws JsonParseException, JsonMappingException, IOException {
        Product product = new Product(ANY_PRODUCT,ANY_PRICE);
        mapper.writeValue(output, product);
        assertThat(output.toString(), is("{\"name\":\"XYZ\",\"price\":10}"));
    }

}
