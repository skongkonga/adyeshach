package ink.ptms.adyeshach.common.script.action

import ink.ptms.adyeshach.common.entity.type.AdyHuman
import ink.ptms.adyeshach.common.script.ScriptHandler.entitySelected
import ink.ptms.adyeshach.common.script.ScriptHandler.getEntities
import ink.ptms.adyeshach.common.script.ScriptHandler.getManager
import org.bukkit.Location
import taboolib.module.kether.*
import java.util.concurrent.CompletableFuture

/**
 * @author IzzelAliz
 */
class ActionPosition: ScriptAction<Any>() {

    override fun run(frame: ScriptFrame): CompletableFuture<Any> {
        val s = frame.script()
        if (s.getManager() == null) {
            error("No manager selected.")
        }
        if (!s.entitySelected()) {
            error("No entity selected.")
        }
        val e = s.getEntities()!!
        return CompletableFuture.completedFuture(if (e.size > 1) e.mapNotNull { it?.getLocation() } else e.first()!!.getLocation())
    }

    companion object {

        @KetherParser(["position"], namespace = "adyeshach", shared = true)
        fun parser() = scriptParser {
            ActionPosition()
        }
    }
}