package net.minestom.server.item.metadata;

import net.minestom.server.item.ItemMetaView;
import net.minestom.server.item.firework.FireworkEffect;
import net.minestom.server.tag.Tag;
import net.minestom.server.tag.TagHandler;
import net.minestom.server.tag.TagReadable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;

public record FireworkEffectMeta(TagReadable readable) implements ItemMetaView<FireworkEffectMeta.Builder> {
    private static final Tag<FireworkEffect> FIREWORK_EFFECT = Tag.NBT("Explosion")
            .map(nbt -> FireworkEffect.fromCompound((NBTCompound) nbt), FireworkEffect::asCompound);

    public @Nullable FireworkEffect getFireworkEffect() {
        return getTag(FIREWORK_EFFECT);
    }

    @Override
    public <T> @UnknownNullability T getTag(@NotNull Tag<T> tag) {
        return readable.getTag(tag);
    }

    public record Builder(TagHandler tagHandler) implements ItemMetaView.Builder {
        public Builder() {
            this(TagHandler.newHandler());
        }

        public Builder effect(@Nullable FireworkEffect fireworkEffect) {
            setTag(FIREWORK_EFFECT, fireworkEffect);
            return this;
        }
    }
}
