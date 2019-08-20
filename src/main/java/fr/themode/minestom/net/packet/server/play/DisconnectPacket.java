package fr.themode.minestom.net.packet.server.play;

import fr.adamaq01.ozao.net.Buffer;
import fr.themode.minestom.chat.Chat;
import fr.themode.minestom.net.packet.server.ServerPacket;
import fr.themode.minestom.utils.Utils;

public class DisconnectPacket implements ServerPacket {

    public String message;

    @Override
    public void write(Buffer buffer) {
        Utils.writeString(buffer, Chat.rawText(message));
    }

    @Override
    public int getId() {
        return 0x1A;
    }
}
