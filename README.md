 <!DOCTYPE html>

 <html lang="en">



 <body style="font-family: Arial, sans-serif; line-height: 1.6; margin: 40px;">



 <h1 style="color: 2c3e50;">📨 Spring Boot Kafka Messaging System</h1>

 

 <p>

   This project is a simple <strong>Kafka-based messaging system</strong> built using <strong>Spring Boot</strong>.

   It includes a REST API to send messages, a Kafka Producer, and a Kafka Consumer to receive them.

 </p>

 <img src="https://media.geeksforgeeks.org/wp-content/uploads/20220214105957/SpringBootProducerConsumer.jpg"
     alt="Spring Boot Kafka Producer-Consumer"
     style="max-width: 100%; border: 1px solid #ccc; border-radius: 4px;" />

 <h2 style="color: 2c3e50;">🧱😁 Tech Stack</h2>

 <ul>

   <li>Java 17+</li>

   <li>Spring Boot</li>

   <li>Apache Kafka</li>

   <li>Spring Kafka</li>

   <li>Maven</li>

 </ul>

 

 <h2 style="color: 2c3e50;">⚙️ Configuration</h2>

 <pre style="background: f4f4f4; padding: 10px; border-radius: 5px;"><code>spring.kafka.bootstrap-servers=localhost:9092

 spring.kafka.consumer.group-id=group-id

 </code></pre>

 

 <h2 style="color: 2c3e50;">▶️ Run the Project</h2>

 <ol>

   <li>Start Zookeeper and Kafka on localhost (default ports).</li>

   <li>Run the application:</li>

 </ol>

 <pre style="background: f4f4f4; padding: 10px; border-radius: 5px;"><code>./mvnw spring-boot:run</code></pre>

 <h2 style="color: 2c3e50;">✅ Features</h2>

 <ul>

   <li>Simple Kafka setup with Producer/Consumer</li>

   <li>REST API integration</li>

   <li>Extensible for real-time systems</li>

 </ul>

 

 <h2 style="color: 2c3e50;">📜 License</h2>

 <p>MIT License</p>

 

 </body>

 </html>



