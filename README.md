# <!DOCTYPE html>

# <html lang="en">

# <head>

# &nbsp; <meta charset="UTF-8">

# &nbsp; <title>Spring Boot Kafka Messaging System</title>

# </head>

# <body style="font-family: Arial, sans-serif; line-height: 1.6; margin: 40px;">

# 

# &nbsp; <h1 style="color: #2c3e50;">📨 Spring Boot Kafka Messaging System</h1>

# 

# &nbsp; <p>

# &nbsp;   This project is a simple <strong>Kafka-based messaging system</strong> built using <strong>Spring Boot</strong>.

# &nbsp;   It includes a REST API to send messages, a Kafka Producer, and a Kafka Consumer to receive them.

# &nbsp; </p>

# 

# &nbsp; <h2 style="color: #2c3e50;">🖼️ Demo Screenshots</h2>

# 

# &nbsp; <p><strong>Message Sent via API:</strong></p>

# &nbsp; <img src="images/send-message.png" alt="Send Message Screenshot"

# &nbsp;      style="max-width: 100%; border: 1px solid #ccc; border-radius: 4px;" />

# 

# &nbsp; <p><strong>Message Received in Consumer:</strong></p>

# &nbsp; <img src="images/received-message.png" alt="Received Message Screenshot"

# &nbsp;      style="max-width: 100%; border: 1px solid #ccc; border-radius: 4px;" />

# 

# &nbsp; <h2 style="color: #2c3e50;">🧱 Tech Stack</h2>

# &nbsp; <ul>

# &nbsp;   <li>Java 17+</li>

# &nbsp;   <li>Spring Boot</li>

# &nbsp;   <li>Apache Kafka</li>

# &nbsp;   <li>Spring Kafka</li>

# &nbsp;   <li>Maven</li>

# &nbsp; </ul>

# 

# &nbsp; <h2 style="color: #2c3e50;">⚙️ Configuration</h2>

# &nbsp; <pre style="background: #f4f4f4; padding: 10px; border-radius: 5px;"><code>spring.kafka.bootstrap-servers=localhost:9092

# spring.kafka.consumer.group-id=group-id

# </code></pre>

# 

# &nbsp; <h2 style="color: #2c3e50;">▶️ Run the Project</h2>

# &nbsp; <ol>

# &nbsp;   <li>Start Zookeeper and Kafka on localhost (default ports).</li>

# &nbsp;   <li>Run the application:</li>

# &nbsp; </ol>

# &nbsp; <pre style="background: #f4f4f4; padding: 10px; border-radius: 5px;"><code>./mvnw spring-boot:run</code></pre>

# 

# &nbsp; <h2 style="color: #2c3e50;">🌐 API Endpoint</h2>

# &nbsp; <table border="1" cellpadding="8">

# &nbsp;   <thead>

# &nbsp;     <tr>

# &nbsp;       <th>Method</th>

# &nbsp;       <th>Endpoint</th>

# &nbsp;       <th>Description</th>

# &nbsp;     </tr>

# &nbsp;   </thead>

# &nbsp;   <tbody>

# &nbsp;     <tr>

# &nbsp;       <td>POST</td>

# &nbsp;       <td>/api/kafka/send</td>

# &nbsp;       <td>Send message to Kafka topic</td>

# &nbsp;     </tr>

# &nbsp;   </tbody>

# &nbsp; </table>

# 

# &nbsp; <h3>Sample JSON Body:</h3>

# &nbsp; <pre style="background: #f4f4f4; padding: 10px; border-radius: 5px;"><code>{

# &nbsp; "message": "Hello Kafka!"

# }</code></pre>

# 

# &nbsp; <h2 style="color: #2c3e50;">📤 Kafka Producer</h2>

# &nbsp; <pre style="background: #f4f4f4; padding: 10px; border-radius: 5px;"><code>

# kafkaTemplate.send("test-topic", message);

# </code></pre>

# 

# &nbsp; <h2 style="color: #2c3e50;">📥 Kafka Consumer</h2>

# &nbsp; <pre style="background: #f4f4f4; padding: 10px; border-radius: 5px;"><code>

# @KafkaListener(topics = "test-topic", groupId = "group-id")

# </code></pre>

# 

# &nbsp; <h2 style="color: #2c3e50;">✅ Features</h2>

# &nbsp; <ul>

# &nbsp;   <li>Simple Kafka setup with Producer/Consumer</li>

# &nbsp;   <li>REST API integration</li>

# &nbsp;   <li>Extensible for real-time systems</li>

# &nbsp; </ul>

# 

# &nbsp; <h2 style="color: #2c3e50;">📜 License</h2>

# &nbsp; <p>MIT License</p>

# 

# </body>

# </html>



