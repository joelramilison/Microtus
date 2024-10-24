package net.minestom.server.entity.metadata.animal;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.Metadata;
import net.minestom.server.entity.MetadataHolder;
import org.jetbrains.annotations.NotNull;

public class BeeMeta extends AnimalMeta {
    public static final byte OFFSET = AnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    //Microtus start - update java keyword usage
    private static final byte ANGRY_BIT = 0x02;
    private static final byte HAS_STUNG_BIT = 0x04;
    private static final byte HAS_NECTAR_BIT = 0x08;
    //Microtus end - update java keyword usage

    public BeeMeta(@NotNull Entity entity, @NotNull MetadataHolder metadata) {
        super(entity, metadata);
    }

    public boolean isAngry() {
        return getMaskBit(OFFSET, ANGRY_BIT);
    }

    public void setAngry(boolean value) {
        setMaskBit(OFFSET, ANGRY_BIT, value);
    }

    public boolean isHasStung() {
        return getMaskBit(OFFSET, HAS_STUNG_BIT);
    }

    public void setHasStung(boolean value) {
        setMaskBit(OFFSET, HAS_STUNG_BIT, value);
    }

    public boolean isHasNectar() {
        return getMaskBit(OFFSET, HAS_NECTAR_BIT);
    }

    public void setHasNectar(boolean value) {
        setMaskBit(OFFSET, HAS_NECTAR_BIT, value);
    }

    public int getAngerTicks() {
        return super.metadata.getIndex(OFFSET + 1, 0);
    }

    public void setAngerTicks(int value) {
        super.metadata.setIndex(OFFSET + 1, Metadata.VarInt(value));
    }

}
