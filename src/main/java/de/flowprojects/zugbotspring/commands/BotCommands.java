package de.flowprojects.zugbotspring.commands;

import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class BotCommands {

    // Slash commands
    public static final String ADD_SERVER_EMBED_COMMAND_NAME = "addserverembed";

    // Context menu commands
    public static final String CRINGE_COMMAND_NAME = "Cringe!";
    public static final String UNCRINGE_COMMAND_NAME = "Uncringe!";

    public static SlashCommandData addServerEmbedCommand() {
        return Commands.slash(ADD_SERVER_EMBED_COMMAND_NAME, "Creates an embed with specified template")
                .addOption(
                        OptionType.STRING,
                        "servername",
                        "The name of the server",
                        true
                )
                .addOption(
                        OptionType.STRING,
                        "description",
                        "The description of the server",
                        true)
                .addOption(
                        OptionType.STRING,
                        "ip",
                        "The ip address or URL of the server",
                        true
                )
                .addOption(
                        OptionType.STRING,
                        "password",
                        "The password of the server",
                        true
                )
                .addOption(
                        OptionType.STRING,
                        "preset",
                        "The preset used to style the embed (minecraft, valheim)",
                        false
                )
                .addOption(
                        OptionType.BOOLEAN,
                        "whitelist",
                        "Does the server use a whitelist?",
                        false
                );
    }

    public static CommandData addCringeCommand() {
        return Commands.context(Command.Type.MESSAGE, CRINGE_COMMAND_NAME);
    }

    public static CommandData addUncringeCommand() {
        return Commands.context(Command.Type.MESSAGE, UNCRINGE_COMMAND_NAME);
    }
}
