private val br = System.`in`.bufferedReader()
private val sb = StringBuilder()

data class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null
) {
    fun addChild(n: Int) {
        if (n > value) right?.addChild(n) ?: run { right = Node(n) }
        else left?.addChild(n) ?: run { left = Node(n) }
    }
}

fun main() {
    val root = Node(br.readLine().toInt())

    while (true) {
        val node = br.readLine() ?: break
        val n = node.toInt()
        root.addChild(n)
    }
    postOrder(root)
    print(sb)
}

fun postOrder(node: Node?) {
    node?.let {
        postOrder(it.left)
        postOrder(it.right)
        sb.append("${it.value}\n")
    }
}
