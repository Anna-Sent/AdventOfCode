package advent.advent2024

import kotlin.math.max

private var result = ""

fun main() {
    result = test(
        """
            x00: 1
            x01: 0
            x02: 1
            x03: 1
            x04: 0
            x05: 0
            x06: 1
            x07: 1
            x08: 0
            x09: 1
            x10: 1
            x11: 1
            x12: 1
            x13: 0
            x14: 0
            x15: 1
            x16: 0
            x17: 0
            x18: 0
            x19: 1
            x20: 1
            x21: 0
            x22: 0
            x23: 1
            x24: 0
            x25: 0
            x26: 0
            x27: 1
            x28: 1
            x29: 1
            x30: 1
            x31: 0
            x32: 1
            x33: 0
            x34: 0
            x35: 1
            x36: 0
            x37: 1
            x38: 1
            x39: 0
            x40: 0
            x41: 0
            x42: 0
            x43: 0
            x44: 1
            y00: 1
            y01: 0
            y02: 0
            y03: 1
            y04: 1
            y05: 0
            y06: 0
            y07: 0
            y08: 0
            y09: 0
            y10: 0
            y11: 1
            y12: 0
            y13: 1
            y14: 1
            y15: 0
            y16: 1
            y17: 0
            y18: 0
            y19: 0
            y20: 0
            y21: 0
            y22: 0
            y23: 1
            y24: 0
            y25: 1
            y26: 1
            y27: 1
            y28: 1
            y29: 0
            y30: 1
            y31: 0
            y32: 1
            y33: 1
            y34: 0
            y35: 1
            y36: 0
            y37: 1
            y38: 0
            y39: 1
            y40: 1
            y41: 1
            y42: 1
            y43: 1
            y44: 1

            wmd OR mjf -> fgw
            vfp AND fsp -> fnq
            x19 AND y19 -> nhb
            jht XOR ptw -> z04
            ffj OR vqn -> msb
            y23 AND x23 -> fgn
            tft AND jph -> srr
            rtk AND pdw -> fvt
            jrv OR qks -> gds
            dqt AND vgb -> rgv
            x21 AND y21 -> bnk
            chr XOR rfr -> z29
            jkh OR rgv -> fkb
            jgq XOR msf -> z25
            y09 XOR x09 -> mrt
            vtj OR ptr -> jfv
            cfc AND qgm -> vqn
            tpm OR tbc -> jph
            rvt XOR hks -> z05
            x05 XOR y05 -> rvt
            y20 AND x20 -> wmd
            y38 AND x38 -> rbs
            x09 AND y09 -> cdw
            twc OR mmq -> dqt
            bwh XOR hjb -> z07
            y34 XOR x34 -> hrg
            wnt XOR gct -> z01
            rfr AND chr -> tbc
            mrt AND jfv -> jbg
            gfm OR wkt -> vfb
            x07 XOR y07 -> hjb
            gtb XOR hbj -> z22
            x26 XOR y26 -> pkc
            x32 AND y32 -> kss
            jgq AND msf -> fqj
            tvg OR vds -> kpm
            mgw XOR dpc -> z28
            x38 XOR y38 -> dwr
            kqf AND fkb -> qdb
            y31 AND x31 -> wpv
            vcc OR jhv -> jrr
            x27 XOR y27 -> tjh
            x37 AND y37 -> gng
            x29 XOR y29 -> rfr
            rmg XOR hrg -> z34
            jdv XOR tdb -> z13
            drc XOR kvf -> z24
            bnk OR qpk -> gtb
            dpc AND mgw -> hbd
            qjw XOR nkg -> z10
            tpf OR cjj -> hks
            rgk XOR mrg -> z15
            dwr XOR nvh -> z38
            mrg AND rgk -> dtn
            y15 XOR x15 -> mrg
            mwh AND dpt -> kbq
            x28 XOR y28 -> mgw
            jrr AND jpn -> hrt
            x33 XOR y33 -> gts
            y06 XOR x06 -> kmj
            pkc XOR hnq -> z26
            qvt OR gfw -> jqk
            y18 XOR x18 -> qkr
            x22 XOR y22 -> hbj
            kdc XOR gts -> z33
            sjb XOR ssr -> z20
            x29 AND y29 -> tpm
            x21 XOR y21 -> pqg
            y41 AND x41 -> twc
            cfc XOR qgm -> z17
            qdg OR fvt -> tdb
            fnq OR wpv -> nfh
            x32 XOR y32 -> hnc
            fgn XOR shg -> z23
            y11 XOR x11 -> mnq
            pkc AND hnq -> vds
            hwq XOR gds -> z08
            cdw OR jbg -> qjw
            y24 AND x24 -> hdg
            rqh AND wvd -> hpn
            kqf XOR fkb -> z43
            npv AND ckq -> cjg
            jcg XOR wmb -> vvf
            srr OR ktw -> vfp
            x11 AND y11 -> dkt
            kvf AND drc -> wdj
            nvh AND dwr -> rck
            rck OR rbs -> dpt
            x14 AND y14 -> sbw
            fsp XOR vfp -> z31
            y08 XOR x08 -> hwq
            y35 XOR x35 -> jpn
            cjg OR ttn -> gcd
            kqh AND ntb -> hrb
            hbd OR btk -> chr
            dtn OR gvb -> fqb
            tjh AND kpm -> vks
            wnt AND gct -> dnc
            y39 XOR x39 -> mwh
            y40 AND x40 -> ttn
            rmg AND hrg -> vcc
            smm OR qdb -> scd
            hnc AND nfh -> tbr
            x36 XOR y36 -> rqh
            x42 XOR y42 -> vgb
            dkt OR hcm -> rtk
            y17 XOR x17 -> qgm
            dck OR fwj -> kvf
            x17 AND y17 -> ffj
            x30 AND y30 -> ktw
            shg AND fgn -> fwj
            y37 XOR x37 -> smb
            nfh XOR hnc -> z32
            sbw OR hrb -> rgk
            vhv OR vhs -> ktn
            y05 AND x05 -> wkt
            scd XOR jts -> z44
            hks AND rvt -> gfm
            x01 AND y01 -> gcq
            hjb AND bwh -> qks
            gng OR qgb -> z37
            hwq AND gds -> ptr
            x40 XOR y40 -> npv
            nkg AND qjw -> gfw
            x19 XOR y19 -> wmb
            fqj OR shj -> hnq
            y15 AND x15 -> gvb
            rtg XOR gcd -> z41
            vgb XOR dqt -> z42
            dpt XOR mwh -> z39
            x39 AND y39 -> qtb
            wth OR qwn -> cfc
            fgw XOR pqg -> z21
            jph XOR tft -> z30
            x14 XOR y14 -> kqh
            kmj XOR vfb -> z06
            x27 AND y27 -> kfb
            msb XOR qkr -> z18
            y10 XOR x10 -> nkg
            msb AND qkr -> mcc
            kss OR tbr -> kdc
            ngv AND ktn -> ddq
            qcs XOR gwm -> z02
            sjb AND ssr -> mjf
            gcd AND rtg -> mmq
            wmb AND jcg -> z19
            x31 XOR y31 -> fsp
            x43 AND y43 -> smm
            wvd XOR rqh -> z36
            ckq XOR npv -> z40
            jrr XOR jpn -> z35
            qkw OR wnm -> bwh
            x12 AND y12 -> z12
            y02 AND x02 -> vhv
            y07 AND x07 -> jrv
            gtb AND hbj -> kjm
            y20 XOR x20 -> sjb
            qfd OR pmm -> rmg
            y02 XOR x02 -> gwm
            mcc OR cgn -> jcg
            x36 AND y36 -> bfh
            x06 AND y06 -> wnm
            jqk AND mnq -> hcm
            y44 AND x44 -> knj
            jqk XOR mnq -> z11
            bfh OR hpn -> vhp
            scd AND jts -> bjt
            ntb XOR kqh -> z14
            y04 AND x04 -> tpf
            x00 XOR y00 -> z00
            ntn OR kjm -> shg
            y01 XOR x01 -> wnt
            qcs AND gwm -> vhs
            y42 AND x42 -> jkh
            x00 AND y00 -> gct
            y16 XOR x16 -> rsf
            x03 XOR y03 -> ngv
            jht AND ptw -> cjj
            smb XOR vhp -> nvh
            knj OR bjt -> z45
            x03 AND y03 -> thd
            y41 XOR x41 -> rtg
            y34 AND x34 -> jhv
            fqb AND rsf -> wth
            x23 XOR y23 -> dck
            ngv XOR ktn -> z03
            kpm XOR tjh -> z27
            y08 AND x08 -> vtj
            fgw AND pqg -> qpk
            vks OR kfb -> dpc
            tdb AND jdv -> wtg
            y43 XOR x43 -> kqf
            rsf XOR fqb -> z16
            x13 XOR y13 -> jdv
            kbq OR qtb -> ckq
            x33 AND y33 -> pmm
            sbt OR wtg -> ntb
            pdw XOR rtk -> qdg
            kdc AND gts -> qfd
            kmj AND vfb -> qkw
            x13 AND y13 -> sbt
            x28 AND y28 -> btk
            y44 XOR x44 -> jts
            y22 AND x22 -> ntn
            y04 XOR x04 -> ptw
            x24 XOR y24 -> drc
            gcq OR dnc -> qcs
            x30 XOR y30 -> tft
            x12 XOR y12 -> pdw
            qwb OR hrt -> wvd
            thd OR ddq -> jht
            mrt XOR jfv -> z09
            y18 AND x18 -> cgn
            vhp AND smb -> qgb
            x10 AND y10 -> qvt
            nhb OR vvf -> ssr
            y26 AND x26 -> tvg
            x25 AND y25 -> shj
            y35 AND x35 -> qwb
            y25 XOR x25 -> msf
            hdg OR wdj -> jgq
            x16 AND y16 -> qwn
    """.trimIndent()
    )
    check("dck,fgn,nvh,qdg,vvf,z12,z19,z37", result)
}

private fun test(input: String): String {
    val inputWires = mutableMapOf<String, Int>()
    val formulas = mutableMapOf<String, String>()
    val zWires = mutableSetOf<String>()
    val allWires = mutableSetOf<String>()
    var highBit: Int? = null

    val (lines1, lines2) = input.split("\n\n")
    for (line in lines1.split("\n")) {
        val (wire, valueStr) = line.split(": ")
        val value = valueStr.toInt()
        inputWires[wire] = value
        allWires += wire
    }
    for (line in lines2.split("\n")) {
        val (formula, wire) = line.split(" -> ")
        formulas[wire] = formula
        allWires += wire
        if (wire.startsWith("z")) {
            zWires += wire
            val index = wire.removePrefix("z").toInt()
            highBit = if (highBit == null) index else max(index, highBit)
        }
    }

    val argsHighBit = highBit!! - 1
    val resHighBit = highBit

    val cachedWires = mutableMapOf<String, Int>()
    val involvedWires = mutableSetOf<String>()
    fun calcValue(w: String, swaps: Map<String, String>): Int? {
        val wire = if (w in swaps) {
            swaps[w]!!
        } else {
            w
        }
        involvedWires += wire
        if (wire in inputWires) {
            return inputWires[wire]!!
        }
        if (wire in cachedWires) {
            if (cachedWires[wire] == -1) {
                return null
            }
            return cachedWires[wire]!!
        }
        cachedWires[wire] = -1
        if (wire in formulas) {
            val formula = formulas[wire]!!
            when {
                formula.contains(" AND ") -> {
                    val (w1, w2) = formula.split(" AND ")
                    val value1 = calcValue(w1, swaps) ?: return null
                    val value2 = calcValue(w2, swaps) ?: return null
                    val value = value1 and value2
                    cachedWires[wire] = value
                    return value
                }

                formula.contains(" OR ") -> {
                    val (w1, w2) = formula.split(" OR ")
                    val value1 = calcValue(w1, swaps) ?: return null
                    val value2 = calcValue(w2, swaps) ?: return null
                    val value = value1 or value2
                    cachedWires[wire] = value
                    return value
                }

                formula.contains(" XOR ") -> {
                    val (w1, w2) = formula.split(" XOR ")
                    val value1 = calcValue(w1, swaps) ?: return null
                    val value2 = calcValue(w2, swaps) ?: return null
                    val value = value1 xor value2
                    cachedWires[wire] = value
                    return value
                }

                else -> throw IllegalStateException("invalid formula $formula for $wire")
            }
        }
        throw IllegalStateException("no formula for $wire")
    }

    fun xWires() = inputWires.filterKeys { it.startsWith("x") }.keys
    fun yWires() = inputWires.filterKeys { it.startsWith("y") }.keys

    fun formatZName(index: Int) = "z${String.format("%02d", index)}"
    fun formatXName(index: Int) = "x${String.format("%02d", index)}"
    fun formatYName(index: Int) = "y${String.format("%02d", index)}"

    fun startTests(allSwaps: Map<String, String>, checkBit: Int): Boolean {
        for (xValue in 0..3) {
            for (yValue in 0..3) {

                var xBinaryString = ""
                var rx = 0
                while (rx <= argsHighBit) {
                    if (rx == checkBit - 1) {
                        val xBin = xValue.toString(2)
                        xBinaryString = xBin + xBinaryString
                        rx += xBin.length
                    } else {
                        xBinaryString = "0$xBinaryString"
                        ++rx
                    }
                }

                val x = java.lang.Long.parseLong(xBinaryString, 2)
                for (index in 0..argsHighBit) {
                    inputWires[formatXName(index)] = xBinaryString[xBinaryString.lastIndex - index] - '0'
                }

                var yBinaryString = ""
                var ry = 0
                while (ry <= argsHighBit) {
                    if (ry == checkBit - 1) {
                        val yBin = yValue.toString(2)
                        yBinaryString = yBin + yBinaryString
                        ry += yBin.length
                    } else {
                        yBinaryString = "0$yBinaryString"
                        ++ry
                    }
                }

                val y = java.lang.Long.parseLong(yBinaryString, 2)
                for (index in 0..argsHighBit) {
                    inputWires[formatYName(index)] = yBinaryString[yBinaryString.lastIndex - index] - '0'
                }

                val z = x + y
                var expectedBinaryString = z.toString(2)
                for (index in expectedBinaryString.length..resHighBit) {
                    expectedBinaryString = "0$expectedBinaryString"
                }
                cachedWires.clear()
                involvedWires.clear()
                var actualBinaryString = ""
                for (zWire in zWires.toList().sortedDescending()) {
                    val value = calcValue(zWire, allSwaps) ?: return false
                    actualBinaryString += value
                }

                val hasCorruptedBits = expectedBinaryString != actualBinaryString
                if (hasCorruptedBits) {
                    return false
                }
            }
        }
        return true
    }

    fun findGoodSwaps(allSwaps: Map<String, String>, checkBit: Int): Set<Pair<String, String>> {
        cachedWires.clear()
        involvedWires.clear()
        calcValue(formatZName(checkBit), allSwaps)

        val possibleBrokenWires = involvedWires.toMutableSet()
        possibleBrokenWires += formatZName(checkBit + 1)

        cachedWires.clear()
        involvedWires.clear()
        for (i in 0..<checkBit) {
            calcValue(formatZName(i), allSwaps)
        }
        val correctWires = involvedWires.toSet()

        possibleBrokenWires -= correctWires
        possibleBrokenWires -= xWires()
        possibleBrokenWires -= yWires()
        possibleBrokenWires -= allSwaps.keys

        val possibleFixingWires = mutableSetOf<String>().apply {
            this += allWires
            this -= correctWires
            this -= xWires()
            this -= yWires()
            this -= allSwaps.keys
            this -= possibleBrokenWires
            this -= zWires
        }

        val goodSwaps = mutableSetOf<Pair<String, String>>()
        for (ps1 in possibleBrokenWires) {
            for (ps2 in possibleFixingWires) {
                val success = startTests(mutableMapOf<String, String>().apply {
                    this += allSwaps
                    this += mapOf(ps1 to ps2, ps2 to ps1)
                }, checkBit)
                if (success) {
                    goodSwaps += ps1 to ps2
                }
            }
        }

        return goodSwaps
    }

    fun findAllSwaps(allSwaps: Map<String, String>, r: Int): Map<String, String> {
        println("considering $allSwaps $r")

        if (r > argsHighBit) {
            return allSwaps
        }

        val success = startTests(allSwaps, r)
        if (success) {
            return findAllSwaps(allSwaps, r + 1)
        }

        val goodSwaps = findGoodSwaps(allSwaps, r)

        for ((swap1, swap2) in goodSwaps) {
            val checkAllSwaps = mutableMapOf<String, String>().apply {
                this += allSwaps;this[swap1] = swap2;this[swap2] = swap1
            }
            val result = findAllSwaps(checkAllSwaps, r + 1)
            if (result.isNotEmpty()) {
                return result
            }
        }

        return emptyMap()
    }

    val allSwaps = findAllSwaps(emptyMap(), 0)
    println("solution is $allSwaps")

    for (r in 0..argsHighBit) {
        val success = startTests(allSwaps, r)
        if (!success) {
            println("tests failed for bit $r")
        }
    }

    return allSwaps.keys.toList().sorted().joinToString(",")
}
