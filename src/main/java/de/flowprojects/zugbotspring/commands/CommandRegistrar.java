package de.flowprojects.zugbotspring.commands;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandRegistrar {

    private final JDA jda;

    //@PostConstruct
    @SuppressWarnings("unused")
    public void registerCommands() {

        jda.updateCommands()
                .addCommands(
                        // Slash commands
                        BotCommands.addServerEmbedCommand(),
                        BotCommands.addCringeCommand(),

                        // Message context menu commands
                        BotCommands.addUncringeCommand()
                ).queue();
    }

    // For testing purposes
    @PostConstruct
    public void registerGuildCommands() {

        long guildId = 1051551007630446623L;


        jda.getGuildById(guildId)
                .updateCommands()
                .addCommands(
                        // Slash commands
                        BotCommands.addServerEmbedCommand(),
                        BotCommands.addCringeCommand(),

                        // Message context menu commands
                        BotCommands.addUncringeCommand()
                ).queue();
    }
}
