package com.shvmsJobs.controller;
import com.shvmsJobs.model.GeminiAiRequest;
import com.shvmsJobs.model.User;
import com.shvmsJobs.service.GeminiAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GeminiAIApiController {


        @Autowired
        private GeminiAIService callGeminiApi;

        @PostMapping("/gemini-api")
        public String callExternalApi(@RequestBody User requestBody) {
            return callGeminiApi.callGeminiApi(requestBody);
        }

}
