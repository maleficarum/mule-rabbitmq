mule-rabbitmq
=============

This connector is a very basic way to send and receive messages from/to RabbitMQ.

Introduction
============

To include this connector in your project, you have to include mule-rabbitmq jar.

After that, you must modify mule-config.xml to add the connector schema as follows :

#### Add the namespaces
	xmlns:rabbitmq="http://www.mulesoft.org/schema/mule/rabbitmq"

#### Include de XSD location
	http://www.mulesoft.org/schema/mule/rabbitmq http://www.mulesoft.org/schema/mule/rabbitmq/1.0-SNAPSHOT/mule-rabbitmq.xsd

#### Configuration
=============

To connecto to RabbitMQ service , you have to configure the follow params :

	<rabbitmq:config host="localhost" username="test" password="test" port="1000" queueName="TEST"/>

Finally, to send messages to queue :

	<rabbitmq:send message="#[payload['c']]"/>
