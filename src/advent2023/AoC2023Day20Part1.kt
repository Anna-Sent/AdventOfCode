package advent2023

import java.util.LinkedList

private var result = 0

fun main() {
    result = test(
        """
            broadcaster -> a, b, c
            %a -> b
            %b -> c
            %c -> inv
            &inv -> a
    """.trimIndent()
    )
    check(32000000, result)

    result = test(
        """
            broadcaster -> a
            %a -> inv, con
            &inv -> b
            %b -> con
            &con -> output
    """.trimIndent()
    )
    check(11687500, result)

    result = test(
        """
            %rp -> gq, sd
            &kh -> cs
            %jz -> pl, jb
            %dx -> tx
            %dh -> bm, sd
            &zv -> ns, dx, hl, hn, fm
            %xb -> ds, sk
            %hv -> sk, kr
            %db -> zv, zz
            &sk -> rg, hh, hv, kr, kh, zl, zn
            %tc -> jz
            %dj -> ts, pl
            %jk -> sd, vh
            %fm -> dx, zv
            %dp -> sd, cc
            %vh -> sd
            &lz -> cs
            %kr -> rg
            %jb -> bf, pl
            %kz -> sk
            %ts -> pl, bs
            %gr -> ns, zv
            %kc -> sd, kf
            %jd -> zv
            %bs -> vg
            %zk -> rp
            %vf -> zk
            %mm -> ms, sk
            %qc -> pl, dj
            %fk -> qc
            %bm -> vf, sd
            %ds -> kz, sk
            %sn -> zv, jd
            %zn -> mm
            %ct -> fk
            %np -> sk, xb
            &tg -> cs
            %tx -> cm, zv
            %zl -> hh
            %zz -> px, zv
            %ms -> zl, sk
            %ns -> db
            %px -> zv, sn
            broadcaster -> fm, hv, kc, bv
            &hn -> cs
            %hh -> np
            %kf -> dh
            %vg -> pl, tc
            %bv -> ct, pl
            &pl -> bv, fk, ct, bs, tg, tc
            %cm -> zv, hl
            %cc -> sd, jk
            %bf -> pl
            %hl -> gr
            &cs -> rx
            %gq -> dp
            %rg -> zn
            &sd -> zk, kf, gq, lz, kc, vf
    """.trimIndent()
    )
    check(703315117, result)
}

private fun test(input: String): Int {
    val modulesTypes = mutableMapOf<String, Char>()
    val modulesOutputs = mutableMapOf<String, List<String>>()
    val flipFlopStates = mutableMapOf<String, Boolean>()
    val conjunctionInputs = mutableMapOf<String, MutableMap<String, Int>>()
    for (line in input.split("\n")) {
        val (token1, token2) = line.split(" -> ")
        val name = if (token1 != "broadcaster") {
            val type = token1[0]
            val name = token1.removeRange(0, 1)
            modulesTypes[name] = type
            if (type == '%') {
                flipFlopStates[name] = false
            } else if (type == '&') {
                conjunctionInputs[name] = mutableMapOf()
            }
            name
        } else {
            token1
        }
        val outputs = token2.split(", ")
        modulesOutputs[name] = outputs
    }

    for (conjunctionModule in conjunctionInputs.keys) {
        val inputs = mutableMapOf<String, Int>()
        for ((module, outputs) in modulesOutputs) {
            if (conjunctionModule in outputs) {
                inputs += module to 0
            }
        }
        conjunctionInputs[conjunctionModule] = inputs
    }

    var lowCount = 0
    var highCount = 0

    for (time in 1..1000) {
        val queue = LinkedList<Triple<String, String, Int>>()
        queue += Triple("button", "broadcaster", 0)
        while (queue.isNotEmpty()) {
            val (from, where, pulse) = queue.poll()
            if (pulse == 0) {
                ++lowCount
            } else {
                ++highCount
            }
            val type = modulesTypes[where]
            if (where == "broadcaster") {
                val outputs = modulesOutputs[where]!!
                for (output in outputs) {
                    queue += Triple(where, output, pulse)
                }
            } else when (type) {
                '%' -> {
                    if (pulse == 0) {
                        flipFlopStates[where] = !flipFlopStates[where]!!
                        val outputs = modulesOutputs[where]!!
                        for (output in outputs) {
                            queue += Triple(where, output, if (flipFlopStates[where]!!) 1 else 0)
                        }
                    }
                }

                '&' -> {
                    conjunctionInputs[where]!![from] = pulse
                    val allHigh = conjunctionInputs[where]!!.values.all { it == 1 }
                    val outputs = modulesOutputs[where]!!
                    for (output in outputs) {
                        queue += Triple(where, output, if (allHigh) 0 else 1)
                    }
                }
            }
        }
    }

    return lowCount * highCount
}
