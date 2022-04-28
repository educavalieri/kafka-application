package deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Sale;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class SaleDeserializer implements Deserializer<Sale> {
    @Override
    public Sale deserialize(String s, byte[] sale) {
        try {
            return new  ObjectMapper().readValue(sale, Sale.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
