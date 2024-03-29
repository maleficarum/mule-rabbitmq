/**
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */
package mx.maleficarum;

import java.io.IOException;

import org.mule.api.annotations.Connect;
import org.mule.api.annotations.Disconnect;
import org.mule.tools.cloudconnect.annotations.Connector;
import org.mule.tools.cloudconnect.annotations.Operation;
import org.mule.tools.cloudconnect.annotations.Property;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Connector(namespacePrefix="rabbitmq")
public class RabbitMQCloudConnector {
	

	private Connection connection = null;
	protected Channel channel = null;
	
	@Property
	private String queueName;
	
	@Property
	private String host;
	
	@Property
	private int port;
	
	@Property
	private String username;
	
	@Property
	private String password;
	
	
    public String getQueueName() {
		return queueName;
	}


	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	@Disconnect
	public void disconnect() throws Exception {
		channel.close();
		connection.close();		
	}
	
	@Connect
	public void connect() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setUsername(username);
		factory.setPassword(password);
		

		try {
			connection = factory.newConnection();
			channel = connection.createChannel();

			channel.queueDeclare(queueName, false, false, false, null);
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}


	/*
     * The following is a sample operation
     */
    @Operation
    public String send(String message) {
    	return message.toUpperCase();
    }
}