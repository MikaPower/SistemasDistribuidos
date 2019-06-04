package edu.ufp.inf.sd.rabbit.topics.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



public class EmitLogTopic {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            String routingKey = getRouting(argv,0);
            String message = getMessage(argv,1);

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }
    }


    private static String getRouting(String [] strings, int routingKeyIndex){
        if(strings.length< routingKeyIndex){
            return "anonymous info";
        }
        return strings[routingKeyIndex];

    }


    private static String getMessage(String [] strings, int messageIndex){
        if(strings.length<messageIndex){
            return "Hello World";
        }
        return joinStrings(strings," ",messageIndex);
    }






    private static String joinStrings(String[] strings, String delimiter, int startMsqIndex) {
        String result = "";
        if (strings.length < startMsqIndex) {
            return "error";
        }
        while (startMsqIndex < strings.length) {
            result = result.concat(strings[startMsqIndex]);
            if(startMsqIndex +1 != strings.length)
             result = result.concat(delimiter);
            startMsqIndex++;
        }
return result;
    }
    //..
}
