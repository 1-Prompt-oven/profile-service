package com.promptoven.profileservice.application.out.call;

public interface EventPublisher {

	void publish(String topic, Object message);

}
