package com.ieake;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ieake.util.AliyunIoTSignUtil;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IoTSimpleDemo {

    private static String productKey = "";
    private static String deviceName = "Unit01";
    private static String productSecret = "";
    private static String deviceSecret = "";
    private static String regionId = "cn-shanghai";

    private static MqttClient mqttClient;
    private static Random random = new Random();
    private static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {

        mqttClient = initAliyunIoTClient();

        ScheduledExecutorService scheduledThreadPool = new ScheduledThreadPoolExecutor(1,
                new ThreadFactoryBuilder().setNameFormat("thread-runner-%d").build());

        scheduledThreadPool.scheduleAtFixedRate(() -> postDeviceProperties(), 10, 10, TimeUnit.SECONDS);
    }

    private static void postDeviceProperties() {
        try {
            //基础版-属性上报topic
            String pubTopic = "/sys/" + productKey + "/" + deviceName + "/thing/event/property/post";
            //基础版-属性上报 自定义payload
//            String payloadJson =
//                    "{" +
//                            "        \"E_Craft_TT_Comp\": %s," +
//                            "        \"E_Craft_PT_Comp\": %s" +
//                            "}";

            String payloadJson =
                    "{" +
                            "    \"id\": %s," +
                            "    \"params\": {" +
                            "        \"E_Craft_TT_Comp\": %s," +
                            "        \"E_Craft_PT_Comp\": %s" +
                            "    }," +
                            "    \"method\": \"thing.event.property.post\"" +
                            "}";

            //上报数据
//            String payload = String.format(payloadJson, df.format(25 + random.nextFloat() * 10), df.format(50 + random.nextFloat() * 30));

            String payload = String.format(payloadJson, System.currentTimeMillis(), df.format(25+random.nextFloat()*10), df.format(50+random.nextFloat()*30));


            System.out.println("post :" + payload);

            MqttMessage message = new MqttMessage(payload.getBytes("utf-8"));
            message.setQos(1);

            mqttClient.publish(pubTopic, message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static MqttClient initAliyunIoTClient() {
        try {
            String clientId = "java" + System.currentTimeMillis();
            Map<String, String> params = new HashMap<>(16);
            params.put("productKey", productKey);
            params.put("deviceName", deviceName);
            params.put("clientId", clientId);
            String timestamp = String.valueOf(System.currentTimeMillis());
            params.put("timestamp", timestamp);

            String targetServer = "tcp://" + productKey + ".iot-as-mqtt." + regionId + ".aliyuncs.com:1883";

            String mqttclientId = clientId + "|securemode=3,signmethod=hmacsha1,timestamp=" + timestamp + "|";
            String mqttUsername = deviceName + "&" + productKey;
            String mqttPassword = AliyunIoTSignUtil.sign(params, deviceSecret, "hmacsha1");

            MemoryPersistence persistence = new MemoryPersistence();
            MqttClient client = new MqttClient(targetServer, mqttclientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            // MQTT 3.1.1
            connOpts.setMqttVersion(4);
            connOpts.setAutomaticReconnect(false);
            connOpts.setCleanSession(true);

            connOpts.setUserName(mqttUsername);
            connOpts.setPassword(mqttPassword.toCharArray());
            connOpts.setKeepAliveInterval(60);

            client.connect(connOpts);
            return client;
        } catch (Exception e) {
            System.out.println("initAliyunIoTClient error " + e.getMessage());
            e.printStackTrace();
        }
        return null;


    }
}
