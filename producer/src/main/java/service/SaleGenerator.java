package service;

import model.Sale;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import serializer.SaleSerializer;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

public class SaleGenerator {

    private static Random rand = new Random();
    private static Long operation = 0L;
    private static BigDecimal valor = BigDecimal.valueOf(500);

    public static void main(String[] args) throws InterruptedException {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SaleSerializer.class.getName());

        try (KafkaProducer<String, Sale> producer = new KafkaProducer<String, Sale>(properties)) {

            while (true) {
                Sale sale = saleGenerate();
                ProducerRecord<String, Sale> record = new ProducerRecord<String, Sale>("venda-ingressos", sale);
                producer.send(record);
                Thread.sleep(200);
            }
        }
    }

    public static Sale saleGenerate(){
        Long client = rand.nextLong();
        Integer quantity = rand.nextInt(10);
        return new Sale(operation++, client, quantity, valor);
    }

}
