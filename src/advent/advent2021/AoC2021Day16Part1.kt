package advent.advent2021

private var result = 0

fun main() {
    result = test(
        """
            8A004A801A8002F478
    """.trimIndent()
    )
    check(16, result)

    result = test(
        """
            620080001611562C8802118E34
    """.trimIndent()
    )
    check(12, result)

    result = test(
        """
            C0015000016115A2E0802F182340
    """.trimIndent()
    )
    check(23, result)

    result = test(
        """
            A0016C880162017C3686B18A3D4780
    """.trimIndent()
    )
    check(31, result)

    result = test(
        """
            4054460802532B12FEE8B180213B19FA5AA77601C010E4EC2571A9EDFE356C7008E7B141898C1F4E50DA7438C011D005E4F6E727B738FC40180CB3ED802323A8C3FED8C4E8844297D88C578C26008E004373BCA6B1C1C99945423798025800D0CFF7DC199C9094E35980253FB50A00D4C401B87104A0C8002171CE31C41201062C01393AE2F5BCF7B6E969F3C553F2F0A10091F2D719C00CD0401A8FB1C6340803308A0947B30056803361006615C468E4200E47E8411D26697FC3F91740094E164DFA0453F46899015002A6E39F3B9802B800D04A24CC763EDBB4AFF923A96ED4BDC01F87329FA491E08180253A4DE0084C5B7F5B978CC410012F9CFA84C93900A5135BD739835F00540010F8BF1D22A0803706E0A47B3009A587E7D5E4D3A59B4C00E9567300AE791E0DCA3C4A32CDBDC4830056639D57C00D4C401C8791162380021108E26C6D991D10082549218CDC671479A97233D43993D70056663FAC630CB44D2E380592FB93C4F40CA7D1A60FE64348039CE0069E5F565697D59424B92AF246AC065DB01812805AD901552004FDB801E200738016403CC000DD2E0053801E600700091A801ED20065E60071801A800AEB00151316450014388010B86105E13980350423F447200436164688A4001E0488AC90FCDF31074929452E7612B151803A200EC398670E8401B82D04E31880390463446520040A44AA71C25653B6F2FE80124C9FF18EDFCA109275A140289CDF7B3AEEB0C954F4B5FC7CD2623E859726FB6E57DA499EA77B6B68E0401D996D9C4292A881803926FB26232A133598A118023400FA4ADADD5A97CEEC0D37696FC0E6009D002A937B459BDA3CC7FFD65200F2E531581AD80230326E11F52DFAEAAA11DCC01091D8BE0039B296AB9CE5B576130053001529BE38CDF1D22C100509298B9950020B309B3098C002F419100226DC
    """.trimIndent()
    )
    check(889, result)
}

private fun test(input: String): Int {
    val data = input.map { it.map() }.reduce { a, b -> a + b }
    println(data)

    val info = readPacket(data, 0)

    return info.versionSum
}

private fun readPacket(data: String, startPosition: Int): PacketInfo2021161 {
    var position = startPosition
    var versionSum = 0
    while (true) {
        if (data.substring(position).all { it == '0' }) break

        val version = Integer.parseInt(data.substring(position, position + 3), 2)
        println("version = $version")
        position += 3
        versionSum += version

        val typeId = Integer.parseInt(data.substring(position, position + 3), 2)
        println("typeId = $typeId")
        position += 3

        when (typeId) {
            4 -> {
                // literal value
                val numberData = data.substring(position)
                var group = 0
                var numberString = ""
                while (true) {
                    val groupString = numberData.substring(group, group + 5)
                    numberString += groupString.substring(1)
                    group += 5
                    if (groupString.startsWith("0")) break
                }
                position += group
            }
            else -> {
                // operator
                val lengthTypeId = data[position]
                position += 1
                when (lengthTypeId) {
                    '1' -> {
                        val packetsCount = Integer.parseInt(data.substring(position, position + 11), 2)
                        position += 11
                        for (i in 1..packetsCount) {
                            val info = readPacket(data, position)
                            position = info.position
                            versionSum += info.versionSum
                        }
                    }
                    '0' -> {
                        val numberLength = Integer.parseInt(data.substring(position, position + 15), 2)
                        position += 15
                        val info = readPacket(data.substring(position, position + numberLength), 0)
                        position += numberLength
                        versionSum += info.versionSum
                    }
                }
            }
        }
    }
    return PacketInfo2021161(versionSum, position)
}

private data class PacketInfo2021161(val versionSum: Int, val position: Int)

private fun Char.map(): String = when (this) {
    '0' -> "0000"
    '1' -> "0001"
    '2' -> "0010"
    '3' -> "0011"
    '4' -> "0100"
    '5' -> "0101"
    '6' -> "0110"
    '7' -> "0111"
    '8' -> "1000"
    '9' -> "1001"
    'A' -> "1010"
    'B' -> "1011"
    'C' -> "1100"
    'D' -> "1101"
    'E' -> "1110"
    'F' -> "1111"
    else -> throw IllegalArgumentException()
}
