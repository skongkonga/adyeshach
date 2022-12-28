package ink.ptms.adyeshach.impl.compat

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import tech.mistermel.servertours.api.ServerToursAPI

object CompatServerTours {

    val serverToursHooked by lazy { Bukkit.getPluginManager().getPlugin("ServerTours") != null }

    fun isRoutePlaying(player: Player): Boolean {
        return serverToursHooked && ServerToursAPI.getInstance().isRoutePlaying(player)
    }
}