package com.shvmsJobs.service;

import com.shvmsJobs.model.GeminiAiRequest;
import com.shvmsJobs.model.User;

public interface GeminiAIService {

    String callGeminiApi(User requestBody);

}
