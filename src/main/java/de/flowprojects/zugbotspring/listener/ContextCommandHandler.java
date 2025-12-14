package de.flowprojects.zugbotspring.listener;

import de.flowprojects.zugbotspring.commands.BotCommands;
import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ContextCommandHandler extends ListenerAdapter {



    @Override
    public void onMessageContextInteraction(@Nonnull MessageContextInteractionEvent event) {
        if(!event.getUser().isBot()) {
            if(event.getName().equals(BotCommands.CRINGE_COMMAND_NAME))
            {
                event.deferReply(true).queue();

                Message message = event.getTarget();

                try {
                    message.addReaction(Emoji.fromUnicode("\uD83C\uDDE8")).queue();
                    message.addReaction(Emoji.fromUnicode("\uD83C\uDDF7")).queue();
                    message.addReaction(Emoji.fromUnicode("\uD83C\uDDEE")).queue();
                    message.addReaction(Emoji.fromUnicode("\uD83C\uDDF3")).queue();
                    message.addReaction(Emoji.fromUnicode("\uD83C\uDDEC")).queue();
                    message.addReaction(Emoji.fromUnicode("\uD83C\uDDEA")).queue();

                    event.getHook().sendMessage("Done!").queue();
                }
                catch (InsufficientPermissionException e) {
                    log.error("Missing permissions to add reactions to message! {}", e.getMessage());
                    event.reply("I don't have permission to add reactions to that message!").setEphemeral(true).queue();
                }
                catch (IllegalStateException e) {
                    log.error("Message {} is ephemeral! {}", message.getIdLong(), e.getMessage());
                    event.reply("That message is ephemeral!").setEphemeral(true).queue();
                }
            }

            if(event.getName().equals(BotCommands.UNCRINGE_COMMAND_NAME))
            {
                event.deferReply(true).queue();

                Message message = event.getTarget();

                try {
                    message.removeReaction(Emoji.fromUnicode("\uD83C\uDDE8")).queue();
                    message.removeReaction(Emoji.fromUnicode("\uD83C\uDDF7")).queue();
                    message.removeReaction(Emoji.fromUnicode("\uD83C\uDDEE")).queue();
                    message.removeReaction(Emoji.fromUnicode("\uD83C\uDDF3")).queue();
                    message.removeReaction(Emoji.fromUnicode("\uD83C\uDDEC")).queue();
                    message.removeReaction(Emoji.fromUnicode("\uD83C\uDDEA")).queue();


                    event.getHook().sendMessage("Done!").queue();
                }
                catch (InsufficientPermissionException e) {
                    log.error("Missing permissions to add reactions to message!: {}", e.getMessage());
                    event.reply("I don't have permission to remove reactions to that message!").setEphemeral(true).queue();
                }
                catch (IllegalStateException e) {
                    log.error("Message {} is ephemeral! {}", message.getIdLong(), e.getMessage());
                    event.reply("That message is ephemeral!").setEphemeral(true).queue();
                }
            }
        }
    }
}
