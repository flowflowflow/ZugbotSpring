package de.flowprojects.zugbotspring.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler extends ListenerAdapter {

    private boolean gagsAllowed = true;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if(!event.getAuthor().isBot()) {
            if(message.contains("0gag")) {
                gagsAllowed = false;
            }
            if(message.contains("1gag")) {
                gagsAllowed = true;
            }
            if(message.contains("9gag") && !gagsAllowed) {
                event.getMessage().delete().queue();
            }
        }
    }
}
