package com.rhota.mcplugin;

import com.rhota.mcplugin.world.GameWorldHandler;
import com.rhota.mcplugin.world.LoadWorld;
import com.rhota.mcplugin.world.Teleport;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class TestCommand implements CommandExecutor {

    final private Plugin p;

    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        File schematics = new File(p.getDataFolder(), "schematics");
        if (!(arg0 instanceof Player))
            return false;
//        LoadWorld.loadInCurrentWorld(new File(schematics, "test.schematic"), ((Player) arg0).getLocation());

//        World q = LoadWorld.loadInCompletelyBlankWorld("hi",new File(schematics, "test.schematic"), ((Player) arg0).getLocation());
//        Teleport.tp(q, (Player) arg0);

        GameWorldHandler w = GameWorldHandler.tryRecycleWorld();
        World q = w.createBlankWorld();
        LoadWorld.loadInCurrentWorld(new File(schematics, "test.schematic"), new Location(q,0,64,0));
        Teleport.tp(q, (Player) arg0);
        return true;
    }

    public TestCommand(Plugin p) {
        this.p = p;
    }
}
