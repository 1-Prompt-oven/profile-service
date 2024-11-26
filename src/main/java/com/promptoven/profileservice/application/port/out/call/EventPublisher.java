package com.promptoven.profileservice.application.port.out.call;

public interface EventPublisher {

	void publish(String topic, Object message);

}
