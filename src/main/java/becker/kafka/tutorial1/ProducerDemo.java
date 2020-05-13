package becker.kafka.tutorial1;

import oracle.jrockit.jfr.StringConstantPool;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {

        String bootstrapServer = "127.0.0.1:9092";

        // Create producer properties
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // Send data - asyncronous
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "Hello, World!");
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
