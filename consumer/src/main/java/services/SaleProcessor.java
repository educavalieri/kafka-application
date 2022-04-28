package services;

import deserializer.SaleDeserializer;
import model.Sale;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class SaleProcessor {

    public static void main(String[] args) throws InterruptedException{

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, SaleDeserializer.class.getName());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-test" );
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest" );


        try(KafkaConsumer<String, Sale> consumer = new KafkaConsumer<>(properties)){
            consumer.subscribe(Arrays.asList("venda-ingressos"));

            while (true){
                ConsumerRecords<String, Sale> sales = consumer.poll(Duration.ofMillis(200));
                for(ConsumerRecord<String, Sale> record : sales){
                    Sale sale = record.value();
                    Thread.sleep(500);
                    System.out.println(sale);
                }
            }
        }

    }

}
