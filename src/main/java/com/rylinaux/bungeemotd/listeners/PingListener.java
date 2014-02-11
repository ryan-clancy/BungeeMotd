package com.rylinaux.bungeemotd.listeners;

import com.rylinaux.bungeemotd.BungeeMotd;
import com.rylinaux.bungeemotd.utilities.StringUtils;

import java.util.Random;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PingListener implements Listener {

    private final BungeeMotd plugin;

    public PingListener(BungeeMotd plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPing(ProxyPingEvent event) {

        int index = new Random().nextInt(plugin.getDynamic().size());

        String motd = StringUtils.colorMessage(plugin.getMain() + "\n" + ChatColor.RESET + plugin.getDynamic().get(index));

        ServerPing response = event.getResponse();
        ServerPing updated = new ServerPing(response.getVersion(), response.getPlayers(), motd, response.getFavicon());

        event.setResponse(updated);

    }

}