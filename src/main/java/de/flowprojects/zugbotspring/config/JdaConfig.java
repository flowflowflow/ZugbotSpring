package de.flowprojects.zugbotspring.config;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JdaConfig {

    @Value("${discord.token}")
    private String token;

    private final List<ListenerAdapter> listeners;

    @Bean
    public JDA jda(List<ListenerAdapter> listeners) throws Exception {
        JDABuilder builder = JDABuilder.createDefault(token)
                .addEventListeners(listeners.toArray());

        return builder.build().awaitReady();
    }

}
