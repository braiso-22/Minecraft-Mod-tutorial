package com.javaminecraft;

import java.util.logging.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnMontura extends JavaPlugin {

    public static final Logger LOG = Logger.getLogger("Minecraft");

    @Override
    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] arguments) {
        if (label.equalsIgnoreCase("spawnmontura")) {
            if (sender instanceof Player) {

                // Lo general cuando se spawnean mobs 
                Player me = (Player) sender;
                Location spot = me.getLocation();
                World world = me.getWorld();

                // Especifico para crear un caballo blanco domesticado
                Horse horse = world.spawn(spot, Horse.class);
                horse.setVariant(Horse.Variant.HORSE);
                horse.setAdult();
                horse.setStyle(Horse.Style.NONE);
                horse.setColor(Horse.Color.WHITE);
                horse.setTamed(true);
                horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
                horse.setOwner(me);

                // Texto que sale por el terminal del server
                LOG.info("Generado caballo con dueño ".concat(me.getDisplayName()));
                return true;
            }
        }
        return false;
    }
}
