package serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Sale;
import org.apache.kafka.common.serialization.Serializer;

public class SaleSerializer implements Serializer<Sale> {
    @Override
    public byte[] serialize(String s, Sale sale) {
        try {
            return new ObjectMapper().writeValueAsBytes(sale);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
