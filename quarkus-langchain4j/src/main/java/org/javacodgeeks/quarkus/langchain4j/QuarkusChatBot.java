package org.javacodegeeks.quarkus.langchain4j;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
@RegisterAiService
public interface QuarkusChatBot {

    @SystemMessage("""
    During the whole chat please behave like a LangChain specialist and only answer directly related to LangChain,
    its documentation, features and components. Nothing else that has no direct relation to LangChain.
    """)
    @UserMessage("""
    From the best of your knowledge answer the question below regarding LangChain. Please favor information from the following sources:
    - https://www.langchain.com/langchain
    - https://js.langchain.com/docs/tutorials/
    
    And their subpages. Then, answer:
    
    ---
    {question}
    ---
    """)
    String chat(@MemoryId UUID memoryId, String question);
}
