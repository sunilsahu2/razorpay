package alert;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaClient {

	public static void main(String[] args) {
		String topic ="quickstart-events";
	   
	      Logger logger= LoggerFactory.getLogger(KafkaClient.class.getName());  
	        String bootstrapServers="127.0.0.1:9092";  
	        String grp_id="third_app";  
	      
	        //Creating consumer properties  
	        Properties properties=new Properties();  
	        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
	        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
	        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
	        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  
	        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");  
	        //creating consumer  
	        KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(properties);  
	        //Subscribing  
	                consumer.subscribe(Arrays.asList(topic));  
	        //polling  
	        while(true){  
	            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));  
	            for(ConsumerRecord<String,String> record: records){  
	                logger.info("Key: "+ record.key() + ", Value:" +record.value());  
	                logger.info("Partition:" + record.partition()+",Offset:"+record.offset());  
	            }  
	  
	  
	        }  
	 
	}

}
