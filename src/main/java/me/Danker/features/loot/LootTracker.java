package me.Danker.features.loot;

import me.Danker.events.PacketReadEvent;
import me.Danker.handlers.ConfigHandler;
import me.Danker.utils.Utils;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LootTracker {

    public static long itemsChecked = 0;
    static Pattern dropPattern = Pattern.compile(".*? \\((?<amount>\\d+)x .*\\).*");

    @SubscribeEvent
    public void onPacketRead(PacketReadEvent event) {
        if (!Utils.inSkyblock) return;

        if (event.packet instanceof S29PacketSoundEffect) {
            S29PacketSoundEffect packet = (S29PacketSoundEffect) event.packet;

            if (packet.getSoundName().equals("note.pling")) {
                if (System.currentTimeMillis() / 1000 - itemsChecked < 3) return;

                if (Utils.isInScoreboard("Boss slain!") || Utils.isInScoreboard("Slay the boss!")) {
                    int itemTeeth = Utils.getItems("Wolf Tooth");
                    int itemWebs = Utils.getItems("Tarantula Web");
                    int itemRev = Utils.getItems("Revenant Flesh");
                    int itemNullSphere = Utils.getItems("Null Sphere");
                    int itemDerelictAshe = Utils.getItems("Derelict Ashe");

                    // If no items, are detected, allow check again. Should fix items not being found
                    if (itemTeeth + itemWebs + itemRev + itemNullSphere + itemDerelictAshe > 0) {
                        itemsChecked = System.currentTimeMillis() / 1000;
                        WolfTracker.teeth += itemTeeth;
                        SpiderTracker.webs += itemWebs;
                        ZombieTracker.revFlesh += itemRev;
                        EndermanTracker.nullSpheres += itemNullSphere;
                        BlazeTracker.derelictAshes += itemDerelictAshe;
                        WolfTracker.teethSession += itemTeeth;
                        SpiderTracker.websSession += itemWebs;
                        ZombieTracker.revFleshSession += itemRev;
                        EndermanTracker.nullSpheresSession += itemNullSphere;
                        BlazeTracker.derelictAshesSession += itemDerelictAshe;

                        ConfigHandler.writeIntConfig("wolf", "teeth", WolfTracker.teeth);
                        ConfigHandler.writeIntConfig("spider", "web", SpiderTracker.webs);
                        ConfigHandler.writeIntConfig("zombie", "revFlesh", ZombieTracker.revFlesh);
                        ConfigHandler.writeIntConfig("enderman", "nullSpheres", EndermanTracker.nullSpheres);
                        ConfigHandler.writeIntConfig("blaze", "derelictAshe", BlazeTracker.derelictAshes);
                    }
                }
            }
        }
    }

    public static int getAmountfromMessage(String message) {
        Matcher matcher = dropPattern.matcher(message);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group("amount"));
        }
        return 1;
    }
    
}
