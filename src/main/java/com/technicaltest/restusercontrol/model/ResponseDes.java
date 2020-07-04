package com.technicaltest.restusercontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data @AllArgsConstructor @NoArgsConstructor
public class ResponseDes {
	private int responseCode;
	private String description;
	private int elapsedTime;
	Result result;
}
