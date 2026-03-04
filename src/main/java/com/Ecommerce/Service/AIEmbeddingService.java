package com.Ecommerce.Service;

import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
public class AIEmbeddingService {

    // Isme model file inbuilt hoti hai, pehli baar run hone par extract hogi
    private final EmbeddingModel embeddingModel = new AllMiniLmL6V2EmbeddingModel();

    public float[] getEmbedding(String text) {
        try {
            if (text == null || text.isEmpty()) return null;
            
            // Direct local CPU se result aayega
            return embeddingModel.embed(text).content().vector();
        } catch (Exception e) {
            System.err.println("Local Embedding Error: " + e.getMessage());
            return null;
        }
    }
}