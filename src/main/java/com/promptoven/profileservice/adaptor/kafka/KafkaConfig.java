package com.promptoven.profileservice.adaptor.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.promptoven.profileservice.application.in.dto.event.MemberBanEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberNicknameUpdateEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberRegisterEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberUnbanEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberWithdrawEvent;
import com.promptoven.profileservice.application.in.dto.event.SettlementFirstCreateEvent;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableKafka
@Slf4j
@RequiredArgsConstructor
public class KafkaConfig {

	@Value("${spring.kafka.text-bootstrap-servers}")
	private String bootstrapServers;
	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	@Bean
	public ProducerFactory<String, Object> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	private <T> ConsumerFactory<String, T> createTypedConsumerFactory(Class<T> targetType) {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

		// Configure key deserializer with error handling
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
		props.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);

		// Configure value deserializer with error handling
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
		props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);

		JsonDeserializer<T> jsonDeserializer = new JsonDeserializer<>(targetType);
		jsonDeserializer.addTrustedPackages("*");

		return new DefaultKafkaConsumerFactory<>(
			props,
			new StringDeserializer(),
			jsonDeserializer
		);
	}

	private <T> ConcurrentKafkaListenerContainerFactory<String, T> createTypedContainerFactory(
		Class<T> targetType) {
		ConcurrentKafkaListenerContainerFactory<String, T> factory =
			new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(createTypedConsumerFactory(targetType));
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, SettlementFirstCreateEvent> settlementFirstCreateListenerFactory() {
		return createTypedContainerFactory(SettlementFirstCreateEvent.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MemberBanEvent> memberBanListenerFactory() {
		return createTypedContainerFactory(MemberBanEvent.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MemberWithdrawEvent> memberWithdrawListenerFactory() {
		return createTypedContainerFactory(MemberWithdrawEvent.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MemberRegisterEvent> memberRegisterListenerFactory() {
		return createTypedContainerFactory(MemberRegisterEvent.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MemberUnbanEvent> memberUnbanListenerFactory() {
		return createTypedContainerFactory(MemberUnbanEvent.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MemberNicknameUpdateEvent> memberNicknameUpdateListenerFactory() {
		return createTypedContainerFactory(MemberNicknameUpdateEvent.class);
	}

}