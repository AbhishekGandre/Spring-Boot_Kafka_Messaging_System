# Spring-Boot\_Kafka\_Messaging\_System



<!DOCTYPE html>

<html lang="en">

<head>

&nbsp; <meta charset="UTF-8">

&nbsp; <title>Spring Boot Kafka Messaging System</title>

&nbsp; <style>

&nbsp;   body {

&nbsp;     font-family: Arial, sans-serif;

&nbsp;     line-height: 1.6;

&nbsp;     margin: 40px;

&nbsp;   }

&nbsp;   code, pre {

&nbsp;     background: #f4f4f4;

&nbsp;     padding: 10px;

&nbsp;     display: block;

&nbsp;     border-radius: 5px;

&nbsp;     overflow-x: auto;

&nbsp;   }

&nbsp;   img {

&nbsp;     max-width: 100%;

&nbsp;     border: 1px solid #ccc;

&nbsp;     border-radius: 4px;

&nbsp;   }

&nbsp;   h1, h2 {

&nbsp;     color: #2c3e50;

&nbsp;   }

&nbsp; </style>

</head>

<body>



<h1>📨 Spring Boot Kafka Messaging System</h1>



<p>

&nbsp; This project is a simple <strong>Kafka-based messaging system</strong> built using <strong>Spring Boot</strong>.

&nbsp; It includes a REST API to send messages, a Kafka Producer, and a Kafka Consumer to receive them.

</p>



<h2>🖼️ Demo Screenshots</h2>



<p><strong>Message Sent via API:</strong></p>

<img src="images/send-message.png" alt="Send Message Screenshot" />



<p><strong>Message Received in Consumer:</strong></p>

<img src="images/received-message.png" alt="Received Message Screenshot" />



<h2>🧱 Tech Stack</h2>

<ul>

&nbsp; <li>Java 17+</li>

&nbsp; <li>Spring Boot</li>

&nbsp; <li>Apache Kafka</li>

&nbsp; <li>Spring Kafka</li>

&nbsp; <li>Maven</li>

</ul>



<h2>⚙️ Configuration</h2>

<pre><code>spring.kafka.bootstrap-servers=localhost:9092

spring.kafka.consumer.group-id=group-id

</code></pre>



<h2>▶️ Run the Project</h2>

<ol>

&nbsp; <li>Start Zookeeper and Kafka on localhost (default ports).</li>

&nbsp; <li>Run the application:</li>

</ol>

<pre><code>./mvnw spring-boot:run</code></pre>



<h2>🌐 API Endpoint</h2>

<table border="1" cellpadding="8">

&nbsp; <thead>

&nbsp;   <tr>

&nbsp;     <th>Method</th>

&nbsp;     <th>Endpoint</th>

&nbsp;     <th>Description</th>

&nbsp;   </tr>

&nbsp; </thead>

&nbsp; <tbody>

&nbsp;   <tr>

&nbsp;     <td>POST</td>

&nbsp;     <td>/api/kafka/send</td>

&nbsp;     <td>Send message to Kafka topic</td>

&nbsp;   </tr>

&nbsp; </tbody>

</table>



<h3>Sample JSON Body:</h3>

<pre><code>{

&nbsp; "message": "Hello Kafka!"

}</code></pre>



<h2>📤 Kafka Producer</h2>

<pre><code>

kafkaTemplate.send("test-topic", message);

</code></pre>



<h2>📥 Kafka Consumer</h2>

<pre><code>

@KafkaListener(topics = "test-topic", groupId = "group-id")

</code></pre>



<h2>✅ Features</h2>

<ul>

&nbsp; <li>Simple Kafka setup with Producer/Consumer</li>

&nbsp; <li>REST API integration</li>

&nbsp; <li>Extensible for real-time systems</li>

</ul>



<h2>📜 License</h2>

<p>MIT License</p>



</body>

</html>



