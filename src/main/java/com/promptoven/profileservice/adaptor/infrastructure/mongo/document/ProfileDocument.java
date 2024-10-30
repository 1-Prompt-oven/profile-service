package com.promptoven.profileservice.adaptor.infrastructure.mongo.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document(collection = "Profile")
public class ProfileDocument {
}
