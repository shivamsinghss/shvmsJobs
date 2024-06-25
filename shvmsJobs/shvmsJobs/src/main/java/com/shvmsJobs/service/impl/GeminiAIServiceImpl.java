package com.shvmsJobs.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvmsJobs.model.*;
import com.shvmsJobs.service.GeminiAIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class GeminiAIServiceImpl implements GeminiAIService {

    private static final Logger logger = LoggerFactory.getLogger(GeminiAIServiceImpl.class);

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String apiUrl;

    public GeminiAIServiceImpl(RestTemplate restTemplate,
                               @Value("${gemini.api.key}") String apiKey,
                               @Value("${gemini.api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    @Override
    public String callGeminiApi(User requestBody) {
        StringBuilder extractedText = new StringBuilder();
        Part part = new Part();
        String searchText = "";
        logger.info("searched value in gemini AI :::::::::: {}", searchText);
        part.setText(searchText);
        Content content = new Content();
        content.setParts(Collections.singletonList(part));
        GeminiApiUri requestedBody = new GeminiApiUri();
        requestedBody.setContents(Collections.singletonList(content));
        String fullUrl = apiUrl + "?key=" + apiKey;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GeminiApiUri> request = new HttpEntity<>(requestedBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(fullUrl, request, String.class);
        String responseBody = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        String resultValue = "Failed to fetch data from AI";
        try {
            JsonNode root = mapper.readTree(responseBody);
            JsonNode textNode = root.path("candidates").get(0).path("content").path("parts").get(0).path("text");
            resultValue = textNode.asText();
            logger.info("Extracted text value from gemini AI: {}", resultValue);
        } catch (Exception e) {
            logger.error("Error extracting text value: {}", e.getMessage());
        }
        return resultValue;
    }
}
