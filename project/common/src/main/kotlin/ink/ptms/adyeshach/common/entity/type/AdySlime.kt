package ink.ptms.adyeshach.common.entity.type

/**
 * @author sky
 * @date 2020/8/4 23:15
 */
abstract class AdySlime : AdyMob() {

    open fun getSize(): Int {
        return getMetadata("size")
    }

    open fun setSize(size: Int) {
        setMetadata("size", size)
    }
}