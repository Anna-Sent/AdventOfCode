package advent.advent2024

import utils.Point

private var result = 0

fun main() {
    result = test(
        """
            AAAA
            BBCD
            BBCC
            EEEC
    """.trimIndent()
    )
    check(140, result)

    result = test(
        """
            OOOOO
            OXOXO
            OOOOO
            OXOXO
            OOOOO
    """.trimIndent()
    )
    check(772, result)

    result = test(
        """
            RRRRIICCFF
            RRRRIICCCF
            VVRRRCCFFF
            VVRCCCJFFF
            VVVVCJJCFE
            VVIVCCJJEE
            VVIIICJJEE
            MIIIIIJJEE
            MIIISIJEEE
            MMMISSJEEE
    """.trimIndent()
    )
    check(1930, result)

    result = test(
        """
            DDDDDDDDDSSSSSSSSSYWYYPPPPPPPEWEEECCRRRRROKKKKKKKKKKKKKKKKMMMMMIMMMIIIIIIIIIIIIIIIIIIIIIIIIIIVVVVVVVVVVVEEEETTTTTWWWWWWWWWQQQPBPPPPPPPAAAAAJ
            DDDDDDDDSSDDDSSSSSYYYYPPYPPPEEEEEERRRRRRKKKKKKKKKKKKKKKMMMMMMMMIMMMMMMMIMIIIIIIIIIISIISIIIVVVVVVVVVVVVVVVEEEETTWTTWWWWWWWWWQQPPPPPPPPAAAAAJJ
            DDDDDDDDDDGDDSSSSYYYYPPPYYPPEEEEEERRRRRKKKKKKKKKKKKKKKKKKEMMMMMMMMMMMIIIMMIIIMIIISSSIISIIVVVVVVVVVVVVVVVEEEEEEEWWWWWWWWWWWQQPPPPPPPPAAAAAAAA
            DDDDDDDDDDDDDDSSSYYYYYYYYYYPEEEEEEEEEERRKKKKKKKKKKKKKKKKKMMMMMMMMMMMMMMMMMMMMMMMSSSSSSSSVVVVVVVVVVVVVVVVVVVEEWWWWWWWWWWQQWQQQQPPPPPPATAAAAAA
            DDDDDDDDDDDDDDSSSYYYYYYYYYYYGYEYEEERRRRRKKKKKKKKKKKKKKKKKKMMMMMMMMMMMMMHMMMMMMMMKSVVSSSSVVVVDDVVVVVVVVVVVVEEEWWWWWWWWWWWQQQQQQPPPPPPPAAAAAAA
            DDDDDDDDDDDDDDSSSYYYYYYYYYYYYYNYEEERRRRRRKKKKKKKKKKKKKKDMMMMMMMMMMMMMMMHMMMMMMMMMSSSSSSSSVVVVLVVVVVVVVVVVEEEEEWWWWWWWWWWQQQQQQPQQAPPAAAAAAAA
            DDDDDDDDDDDDDDSSSYYYYYYYYYYYYYYYOOERRRRRRUKKKKKKKKKKKKDDDMMMMMMMMMMMMMHHMMMMMMMMSSSSSSSSSSLUULVVVVVVVVVVVEEEEEWEEBWWWWWWQQQQQQQQQAAAAAAAAAAA
            DDDDDDDDDDDDDDDDDYYYYYYYYYYYYYYYOOYCRRRRRKKDKKJKKKKKDKDDDDDMMMMMMMMMMMMMMMMMMMMMSSSSSSSSSSLLLLLVVVVVVVVVVVVEEEEEEBWWWWWQQQQQQQQQQQQAAAAAAAAA
            DDDDDDDDDDDDDDDDDYYYYYYYYYYYYYYYYYYYYDRRRRMVVVVKKKKKDDDDDDMMMMMBMMMMMMMMMMMMMMMMMSSSSSSSSSLLLLLLVVVVVZZVVVVEEEEFEWWWWWWNQQQQNQQQQAAAAAAAAAAA
            DDDDDDDDDDRDDDDDDDYYYYYYYYYYYYYYYYYYYDRRVRVVVVVKKDDKKDDDDDMMMMBBBBMAMMMMMMMMMMMIMSSXVVSSSSSLLLLVVVZVZZZYVVSSEEEFFFWWFWWNNNQQNNQQQQQAAAAAAAAA
            DDDDDDDDDDDDDDCDDDYYYYYYYYYYYYYYYYDDDDRRVRVVVVVVKDDDDDDDDDDMMMBBBMMAMMMMMMMMMMGMMSSXVSSSSSLLLLLLLVZZZZZZZZZSEEFFFFFGFFFNNNNNNQQQRRRAAAAAAAAA
            DDDDDDDDDDDCCCCCWYYWYYYYYYYYYYYYYYDDDDRRVVVVVVVVVDDVDDDDDDMMMMMMMMMMMMMMMMMMMMMMMMVVVVSVVSLLLLLLLZZZZZZZZZZZZRRFFFFFFFNNNNNNNNRRRRRRAAAAAAAA
            DDDDDDZDDDDCCCWWWWWWWYYYYYYYYYYYYYDDDDDDDVAVVVVVVVVVDDDDDDMAAAAAMMMMMMMMMMMMMMBMVVVVVSSVVSSSLLLLZZZZZZZZZZZZZRRRFFFFFNNNNNNNNNRRRRRRAAAAAAAA
            DDDDDDZDDWWWWWWEWWWWWYYYYYYYYYYYYYDDDDJJJJJVVVVVDDDDDDDDDDMAAAAAAAAAAAMMMMMMMMVVVVVVVVVGVVSSLLLSSZZZZZZZZZZZZRRRFFFFFNRRNNNNNRRRRRRRAAAAAAAA
            BBBZZDZZZWWWWWWWWWWWWKYYYYYYYYYYYYDZJJJVVVVVVVVVDDDDDDDDDDMAAAAAAAAAAAMMMMMMMMVVVVVVVVVVVVSSSSSSZZZZZZZZZZZZRRRRRFGFFFFRNNRRRRRRRRRRUAAATTAA
            PBBBZZZZWWWWWWWWWWWWYKYYYYYYYYYYYYZZJJJJJVVVVVJOODDDDDDDDDMAAAAAAAAAAAUMMMMMMVVVVVVVVVVVVVVSSSAZZZZZZZZZZZZZZRRRGGGFFFRRRRRRRRRRRRRRUAPPAAAA
            BBBBBBZZZZIIIWWWWWWWYYYYYYYYYYYYYZZZZJJJJVVVJJJOODDDDDDDDMMAAAAAAAAAAAUUMMVMMVVVVVVVVVVVVVVVSSAZZZZAAZZZZZZZZZYYFFFFFFRRRRRRRRRRRRRRRRVVVFAU
            BBBBBEIIIIIIIIWIWWWWYYYIIIIIYYYYZZZZZJIJJJJJJOOOOODDDDDDDDMMMMMMMTMMUUUUMAVVVVVVVVVVVVVVVVVVVAAADDAAAAZZZZZZZZZYYFFFFFRRRRRRRRRRRRRRRVVVVVAU
            BBEBJXIIIIIIIIWIWWWWYYIIIIIHHYYIZZZZPJIIJJJJJOOOOOODDDDDDMMMMMMMMTTHTTUUUVVVVVVVVVVEEEVVVVVVAAAAAAAAAAAZZZZZZZYYYYFFFFRORRRRRRRRRRRRRGVVVVAA
            JJBBJXXXIIIIIIIIWWYYYYIIIIIIIWIIIIZZIIIJJJJJJOOOOOOODDDDDDMMMMMMMMTTTTUTTTVVTVVVVVVVVEEVEVVAARAAAAAAAAAAAZZZZZYYYYYFFFSOWWWRRRRRRQQRGGVVVVVV
            JJJBXXOXXIIIIIIIWIIIYYIIIIIIIIIIIIIZIIIIJDDDDOOOOOOODODDDDMMMMMMMMMATTTTTTTTTTNNVVVVVEEEEEVAAAAAAAAAAAAGZZZZZZYYYYYFFFSOWTRRRRRRQQQQQVVVVVVV
            JJJBXOOXXIIIIIIIIIIIIYIIIIIIIIIIIIIZIIIIDDDDDDOOOOOOOODDMMMMUMMMMMLTTTTTTTTTTNNNVVVVEEEEEEAAAAAAAAAAAAAAZZZZZZYYYYSSSSSWWWWWWRRRQQQBQQVVVVVV
            JJJXXXXXIIIIXIIIIIIIIIIIIIIIIIIIIIIZIIIIDDDDDDOOOOOOOOOOXIMMUMMMMMMTTTTTTTTTTTTTGGVEEEEEEEEAAAAAAAAAAAAAZWEAEEEYYYYWVSWWWWWBRRRRQQQQQQQQVVVV
            JJJXXXXIXXIIXXXIIIIIIIIIIIIIIIIIIIIIIIIIIDDDOOOOOOOOOOOXXIMUUMMMMTTTTTTTTTTTTTTTTGVVEEEEEEEAAAAAAAAAAAAAZZEEEEEYEYEWWWWWWWBBRRRRQQQQQQQQVVVV
            JNJJXXXXXXXXXXXXIIIIIIIIIIIIIIIIIIIIIIIIIDDDOOOOOOOOOOOXXXUUUUUUTTTTTTTTTTTTTTTTTTGGEEEEEEEEAAAAAAAAAAAAAEEEEEEEEYEIIIIIWWWBBBQQQQQQQQQQQQVV
            JNNNXXXXXXXXXXXXXXIIIIIIIIIIIIIIIIIIIIIIDDDDDOOOOOOOOOXXXOXUUDUUUTTTTTTTTTTTTTTTGGGGEEEEEEEEAAAAAAAAAAAAAEEEEEEEEEEIIIBBBBBBBBBQQQQQQQQQQQVV
            JNNNNXXXNNNXXXXXXXIIIIIIIIIIXIIIIIIIIIIIDDDDDOOOOOOOOODXXXXDDDTTTTKKTTTTTTTTTYYGGGGGGEEEEEEEEAAPPPAAAAAACEEEEEEEEEEBBBBBBBBBBBBBQQQQQQQQQQVV
            JNNNNNNNNNNXXXXXXXIIIIIIIIIIIIIIIIIIIIIICCCOOOOOOOOOODDDXXDDDRRKKKKKTTTTTTTTTTYYGGGEEEEEEEEEEAAPPPPPAAAAEEEEEEEEEEESBBBBBBBBBBQQQQQQQQQQQQQV
            JFNNNNNNNNNXXXXXXGIIIIIPIIIIIIIIIIIIIIIIICOOOOOOOOOODDDDDDDDDRRRKKKKKTTTTTTTTTYGGGGGCEEEEEOOPAPPPPPPPAEAEEEEEEEEEIIBBBBBBBBBBBBBBQQQQQQQQQQQ
            JFFFNNFNNNNAAXXAAIIIIIIIIIQQQQQIIIIIIYIICCCCOOOOOOOOODDDDDDDDDKKKKKKKKTTTTTTTYYYGXGCCEEEEOOOPPPPPPRPPAEEZEEEETTTTTTTBBBBBBBBBBBBBQQQQQQQQQQQ
            JJFFFFFFFNAAAXAAAAAIIAAAIIIIQQQIIIIIYYICCCCCCOOOOODOODDDDDDDDDKKKKKKKKTTKKTTTYYYXXCCPPPPPOOOPPPPPPPPZZZZZWWEETTTTTTTBBBBBTTTTTBBQQQQQQQQQGGG
            FFFFFFFFFFFJAAAAAAAAAAAAAIIATQTKTTIIIYYCCCCCOOOOODDDDDDDDDDDJJJJKKKKKKKKKKKKYYYXXXCCCCPPPPPPPPPPPPPPZZZZZZEEETTTTTTTBBBBBTTTTTBBQQQQQQQQGGGG
            FFFFFFFFFFWJAAAAAAAAAAAAAIAATTTTTTTTTYYYYYCCCOOPPPDDDDDDDDDTJJJJKKKKKKKKKKKKYXYXXXXCPPPPPPPPAPPPPPPPZZZZZZEEETTTTTTTBBBBBTTTTTBBBQQQQQQQQGGG
            FFFFFFFOOWWJJAAAAAAAAAAAAAAATTTTTTTTYYYYYYYYCOOPPPDDDDDDDDDTJJJKKKKKKKKKKKKKXXXXXXXXPPPPPPPVPPPPPPPPPZZZZZZAATTTTTTTEEBBBTTTTTBBQQQQQQQQGGGG
            FFFFFFFFFFWWJAAWAAAAAAAAAAAAATTTTTTTTYYYYYYYYYYPPPPDDPDDDDTTTTTTTKKKKKKKKKKKKXXXXXXXXXXPPPPPPPPPPPPPPPPZZZCAATTTTTTTTTTEBTTTTTKKQQQQDQQQGGGG
            FFFFFFFFFWWWWWWWAAAAAAAAAAAATTTTTTTTTTTTYYYYJJPPPPPPPPDDTTTTTTTTKKKKKKKKKKKKKKXXXXXXXXXXPPPPPPPPPPPPPPPPZZCAUTTTTTTTTTTTTTTTTTBKKKQKDDQQGGGG
            FFFFFFFEFFWWWWWWAAAAAAAAAAATXTTTTTTTTTTYYYYJJJPJPPPPPDDDTTTTTTTTTTKKKKKKKKKKKXXXXXXXXXXXPPPPPPPPPPPPPPPPZZZAATTTTTTTTTTTTTTTTTBKKKKKKKKKGGGG
            FFFFFFFFWWWWWWWWWWAAAAAAAAATTTTTTTTTTATYHJJJJJJJPPPPPDDDDTSTTTTTTTKKAKKJKKKKXXXXXXXXXXXPPFHPPPPPPPPPPLPPPZAAATTTTTTTTTTTTTTTTTBBKKKKKKKKGGGG
            FFFFFFFFFWWWWWWWWWAAAAAAAAAATTTTTTTTTAAYHHHHJJJJJPPPPDDDDTDTTTTTKKKTTTKXKXXXXXXXXXXXXXPPPFHPPPPPPPPPPPPPPAAAAAATTTTTTTTTTTTTTTVKKKKKKKKKGGGG
            FFFFFFFFXWWWWWWWWWWAAAAAAKKATBBTTTTTTHHHHHHJJJJJJPPDDDDDDDDTTTTTTTTTTVKXXXXXXXXXXXXXXPPPFFFFFPPPPPPPPPPPPPAWAAABEETTTTTTTTTTTTKKKKKKKKGGGGGG
            NNNFNNNNWWWWWWWWWAAAKKAKKKKKKKTTTTTTTTTHHHHHJJJJDDDDDDDDDDDTTTTTTTTTTVVDDRDXXXXXXXXXKXPPPFFFFPPPPPPPPPPPPPPWAAABEETTTTTTTTTTTAKKKKKKKKGGGGGG
            XXNNNNNNWWWWWWWWWWAAKKKKKKKKKTTTTTTTHHHHHHHJJJJJJDDDDDDDDDDTTTTTTTTTTTTDDDDDXXXXXXXXXXPPFFFFFPPPPPPPPPPPPPPWAAAEEEAATTTTTTTTTAAKKKKKKKKGGGGG
            XXXXXNNNWWWWWWWWWGKKKKKKKKKKHHHHHTHHHHHHHHHJJJJJJDDDDDDDDDDTTTTTTTTTTDDDDDDCCCXXXXXXXXXPPFFFFPPPPPPPPPPPPWWWWWBBEEEETTTTTTTTTKKKGKKKGGKGGGGG
            XXXXXXNWWWWWWWWWWGKKKKKKKKKHHHHHHHHHHHHHHHHHJJJJJDDDDDDDDDDTTTJJJJTTJDDDDDUDCCXCXXXXXXPPPFFFFFPPPRPPPPPPWWWWWWBBEEAATTTTTTTTTJDKGKGGGGKGGGGG
            XXXXXXWWWWWWWWWWWKKKKKKKKOKHHHHHHHHHHHHHHHJJJJJJJDDDDDDDDDTTTTJJJJJJJDDDDDDDCCCCCCCXXXPPPPPFFFFPPRRPPRRPWWWWWWWBBEAATTTTTTTTTJKKKKKGGGGGGGGG
            XXXXXXXXXNWWWWWAAAKKKKOKKOOHHHHHHHHHHHHHHHHHJJJJDDDDDDDDDDTTTTJJJJJJJDDDRRRRCCCCCCCCXXPPPPPFFFFPRRRRRRRRRWWWWWWBBHHAAAAAHJJJJCCCKKBBBGBBGBGG
            XXXXXXXXXNWWWWWAAAAKAAOOOOHHHHHHHHQHHHHHHHHJJJJJJJDDDDZDTTTTTTJJJJJJDDDDRRRRRCCCCCCCXPPPPPPPFPPPRRRRRRRRRRWWWWWBBBHHHHHHHJJJCCCCKKKBBBBBBBBB
            XXXXXXXXXXWCWWAAAAAKAAAOOOHHHHHHHHHHHHHHHHHHJJJJJJDDDDZDTTTJJJJJJJJJDDRRRRRRRRCCCCCCXXPPPPPPPPPPRRRRRRRRRRRWBBBBBHHHHHHHHHJJCCCCCCCBBBBBBBBB
            XXXXXXXXXXCCWAAAAAAAAAAOOHHHHHHHHHHHHHHHHHHHJFFFFFFDIIITTTTTKKKJJJJDDDDRRRRRRRQCCCCCZPPPPPPPPXPRRRRRRRRRRRRRRBBBHHHHHHHHHHHCCCCCCCBBBBBBBBBB
            XXXXXXXXXXCCAAAAAAAAAAAOOOOHHHHHHHHHHHHHHHHJJFFFFFFIIIIIIIIIKKIJJDDDDDDRRRRRRKQXCCCZZZZXPPPPPXPRRRRRRRRRRRRRBBBBHHHHHHHHHHHCCCCCGGBBBBBBBBBB
            XXXXXXXXXXCCAAAAAAAAAAAAOOOHHHHHHHHHHHHHHHHHJFFFFFFMIIIIIIIIIIIEJDDDDRRRRRRRRQQQHCCZZZZXXXXXXXXRXRRRRRRRQQRRBBBHHHHHHHHHHHHCCCCGGGGBBBBBBBBB
            XXXXXXXXXXCAAAAAAAAAAAAOOOOOOHHHHHHHHBHQHHJJJFFFFFFFIIIIIIIIIIEEJBBRRRRRRRRRRQQQQZZZZZZXXXXXXXXXXRRRRRRRQRRRBBBBBHHHHHHHHHOHCCCGGGGGBBBBBBBB
            XXXXXXXXXXXDJJJJJJJJAAAOOOOJHHHHHHHHHHHQQQYYYYYYFFFIIIIIIIIIIIEEERRRRRRRRRRRRQQQQZZZZXXXXXXXXXXXXXRRRRRQQQQRBBBBHHHHHHHHHHHHCCCCGGGBBBBBBBBB
            XXXXXXXXXAAAJJJJJJJJAAOOOOOJHHHHHHHQHQQQQFYYYYYYFFIIIIIIIIIIIIIEEERRRRRRRRRRRQQQQQZZZXXXXXXXXXXXXXXXQRQQQSSSBBSBHHHHHCHCCCCCCGGGGGGGGNBBBBNN
            XXXQXXXXXFFAJJJJJJJJAOOOOQOOHHHHHQQQQQQQPFYYYYYYFFFIFIIIIIIIIEEEEEEEERRRRRRRRQQQQQZZZXXXXXXXXXXXXXXQQRQQQQSSSSSBSSCCCCCCCCCCCGGGGGGGGNNBBBNN
            XXXQXQQFFFFAJJJJJJJJAOOOOOOOLHHHHQQQQOQPPFYYYYYYFFFFFIIIIIIIAEEEEEEEEERRRRRRRRQQQZZZZXXXXXXXXXXXXXXXQQQSSSSSSSSSSSCCCCCCCCCCCCCGGGGGGGNNNNNN
            BXQQQQQQQFFFJJJJJJJJOOOOOOOOOQQHQQQQQQPPPPYYYYYYFFRFIIIIIIAAAEEEAEEEEERRRRRRRRQQQZZZZXXXXXXXXXXXXXXXXQSSSSSSSSSSSSCCCCCCCCCCCCGGGGGGGGGNNNNN
            QQQQQQQQFFFFJJJJJJJJOOOOOOOOOOQQQQYYYQQPPPYYYYYYYYYYIIIIIIAAAAAEAEEEEEERRRRRRRZZZZZZZXXXKXPXXXXXXXXXXSSSSSSSSSSSSCCCCCCCCCCCYCGGGGGGGGNNNNNN
            QQQQQQQQFFFFJJJJJJJJAOOOOOOOOQQQQQQYPPPPPPYYYYYYYYYYIIIIIAAAAAAAAAEEHEERRRRZZZZZZZZZZZXXKPPPXXXXXXBXXSSSSSSSSSSSSCCCCCCCCCCCCCCGGGGGGGNNNNNN
            MQQQQQQFFFFFJJJJJJJJJJJJJJJJJJJQYYYYYPPPPPPPPPYYYYYYIIIIIAAAAAAAAAEHHEERRRRZZZZZZZZZZZLLPPPPPPDDXDDDDHSSSSSSSSSSSCCCCCCCCCCCCCCGGGGGGGGGNNNN
            MQQQQQQFFFFFJJJJJJJJJJJJJJJJJJJYYYYYYPPPPPPPPIYYYYYYIIIIIAAAAAAAAAHHHHERKRRZZZZZZZZZZZPPPPPPPMDDDDDDDHSSSSSSSSSSSGCCCCCCCCCCCCGGGGGGGGGNNNNN
            QQQQQQQQFFJJJJJJJJJJJJJJJJJJJJJYYYYPPPPPPPPPPYYYYYYYCIIIIIAAAAAAAAAHHHEERRZZZZZZZZZZZZPPPPPPPPDDDDDDDHHSSSSSSSSSSGGGCCCCCCCCCCGCGGGGGGNNNNNN
            QQQQQQQQFFJJJJJJJJJJJJJJJJJJJJJYYYYYPPPPPPPLLYYYYYYYCIIIIAADAAAAAAAAHHHERRZZZZZZZZZZZZZPPPPPPDDDDDDDDDHHSSSSSSSGSGGGCCCCCCCCCCCCCGGGGGGNNNNN
            QQQQQQQFFYJJJJJJJJJJJJJJJJJJJJJYDYYYYYPPPPLLPYYYYYYYCIIJJJAAAAAAAAAAHHHEHRZZZZZZZZZZZZZOPPVVPDDDDDBDHHHHSSSSSSGGGGGGGCCCCCCCCCCWCCGGGGGNNNNN
            QSSSSSFFFFJJJJJJJJJJIIIIIEEEEEYYYYYYYYYYPPLLLYYYYYYYCCCCCJJJAAAAAAAHHHHHHRZZZZZZZZZZZZZOOOVVVDDDDDDDHHHHHHSGGSGGGGGGGGGCCCCWCWWWWCWNNNNNNNNN
            SSSSSFFFFFJJJJJJJJJJJIJIIEEEEEEYYYYYYYYYPPKLLYYYYYYYCCKCKAAJAAAAAAHHHHHHHRZZZZZZZZZZZZZOOVVVVVDDDDDHHHMMMMMMGGGGGGGGGGGGWCWWWWWWWWWWWWNNNNNN
            SSSSSSSYYFJJJJJJJJJJJJJEEEEEEEEYYYYYYYCPPPLLLYYYYYYYCCKKKAAAAAAAAAHHHHHRRRZZZZZZZZZZZZZOOHHHHVHDDDHHHMMMMMMMMGGGGGGGGGWGWWWWWWWWWWWWNNNNNNNN
            SSSSSSSLYFJJJJJJJJJJFFJJEEEEEEWYYYYYYYCPPPPMMYYYYYYYCCCKKAAAAAAAAHHHHHHRRRZZZZZZZZZZZZZHHHHHHVHHHDDDHHMMMMMMMGGGGGGGFFWWWWWWWWWWWWWNNNNNNNQQ
            SSSSSSSLYYJJJJJJJJJJJJJJEEEEEEWWYYYYYYCPPPPPPYYYYYYYCCCKKAAAAAAAAAHHHHHHHHZZZZZZZZZZZZZHHZHHHHHHHHDHHMMMMMMMGGGGGGGGWWSWWWWWWWWWWWWNNNNNNNMQ
            SSSSSSSSYYJJJJJJJJJJJJJJJEEEEEEWWWWWYLNBNNPPCYYYYYYYCCCCKAAAAAAAAAHHHLLQLRZZZZZZZZZZZZZHHZHHHHHHHHHHHHMMMGGMGGGGGGGGWWSWWWWWWWWWWWWNNNNNNSQQ
            SSSSSSSJJYJJJJJJJJJJJJJJJJJEEEEWWWWNNNNNNNNPPCCCCCCCCCCCCAAGGXAAAAHHHPLQLLZZZZZZZZZZZZZHHHHHHHHHHHHHHHMMMMGGGGGGGGGMWWWWWWWWWWWWWWNNNNNNNNQQ
            SSSSSSSSJYYYYYYYYYJJJJJJJJJJJJEJJJWNNNNNNNNNYCCCCCCCCCGGGAGGGGAAAAHHLLLLLLLRBBPPPPPPHHHHHHHHHHNHHHHHMMMMMMVGVGGPGGGGWDWWWWWWWWWWWWNVNNNNNNQQ
            SSSSSSSSJJYYYYYYYYYYJJJJJJJJJJJJJJWNNNNNNNCCCCCCCCCCCCCGGGGGGGAMMGTLLLLLLBBBBBYPPPPPPPHHHHHHNNNNHHUUUVVVVVVVVVVGGVGGWDDWWWWWWWWWWWVVVNNQQQQQ
            SSSSSSYJJYYYYYYYYJJJJJJJJJJJJJJJJJNNNNPPPPCCCCCCCCCCCCCCGGGGGGAMGGTTLLLLLLLBBXYYPPPPPPPPHHHHVNNNHHUUUVVVVVVVVVVVGVVVVDDWWWWWWWWWWWVVVNNNQQQQ
            SSSSSSYYJYYYYYYYYYJJJJJJJJJJJJOOOOOONNPPPPPPPXXXLCCCCCCGGGGGGGGGGGGGBLLLLLBBYYYYYPPPPHHHHHHUVNNNUUUUUUUUVVVVVVVVGVVVDDDWWWWWWWWWWVVVNNQQQQQQ
            SSSSSSSYYYYYYYYYYYJJJJJJJJJJJJOOOOFFFFPPPPPPPXXXXXCCCXGGGGGGGGGGGGGBBBBLBBBBYYYYYYPPPHHHHHUUVNUUUUUUUUUVVVVVVVVVVVVVDIDDDDWWWWWWVVVVNNQQQQQQ
            SSSSSSSYYYYYYYYYYYJJJJJJJJJJJJJWWOFFFFPPPPPPPPPSSSSSCXGGGGGGGGGGGGGBBBBBBBYBBYYYYYPPPYHHHHBUUNUUUUUUUUUJVVVVVVVVVVVDDDDDDWWWVWWWVVVVQQQQQQQQ
            SSSSSSYYYYYYYYYYYYYJJJJJJJJJJEEWWOFFFFPPPPPPPPPSSSSSSGGGGGGGGGGGGGGBBBBBBBYYYYYYYYYYYYYHHEUUUUUUUQQQQQQVVVVVVVVVVVVDDDDDDWVVVVVWVVVVQQQQQQQQ
            SSSSTTYYYYYYYYYQQQQJJJJJJJEEJEEEWOFFFFPPPPPPPPPSSSSSSGGSGGGGGGGGGYGGBBBYYYYYYYYYYYYYYEEEEQQQQQQQQQQQQQQFVMVVVVVVVVVDDDDVVVVVVVVVVVVQQQQQQQQQ
            USSSTTYYYCCYYYYPQQQQJJJEEEEEEEEEOOFFFFPPPPPPPPPXSSSSSSSSSSGGGGGGGGGBBBYYYYYYYYYYYYYOYEEEEQQQQQQQQQQQQQQFFFVVVVVVVDDDDDVVVVVVVVVVVVVVQQQQQQQQ
            USSSTTTTTTTYYYYQQQQQQEEEEEEEEEEFFFFFFFPPPPPPPPPXSSSSSSSSGGGGGGGGBBBBBBBYYYYYYYYYYYOOOEEEEQQQQQQQQQQQQQQFFFVVVVVVVFDDDDVVVVVVVVVVVVVVQQQQQQQQ
            SSVTTTTTTTTTYQQQQQQQQEEEEEEEEEEFFFFFFFPPPPPPPPPXSSSSSSSSGGGGGGGGGBBBBBBYYYYYYYYYYYOOOAAAAQQQQQQQQQQQQQQEFFFVVVVVVFFFRVPVVVVVVVVVVVVVVVVQQQQQ
            STTTTTTTTTTTCCCCQQQQQEEEEEEEEEEFFFFFFFPPPPPPPPPKSKSSSSSSSGGGGGGGGBBBBBBBYYYYYYYOYOOOOOAAAQQQQQQQQQQQQQQTTTFFFFVVFFVVVVVVVVVVSVVVVVVVVVVVQQVV
            TTTTTTTTTTTCCCQQQQQQQEEEEEEEEEEFFFFFFFFFFPPPPPPKKKSSSSSSSGGGGGGGGJBBBBBBBOOOOYYOOOOOOOQQQQQQQQQQQQQQQQQTTTTTFFFVVFVVVVVVVVVSSSSSSVVVVVDQQQVV
            JTTTTTTTTTTCTCCQQQQQEEEEEEEEEEEFFFFFFFFFFPPPPPPKKKKSSSSHSGHGGGQBBBBBBBBBBOOOOOOOOOOOOOQQQQQQQQQQQQQQQQTTTKTTFFFFFFFFVVVVVVVSSSSSSVVVVVDVQVVV
            JTTTTTTTTTTTTCQQQQQQEEEEEEEEEEEFFFFFFFFFFFFFFKKKKKKKSSSHHHHGGGHBBBBBBBBBBOOOOSSSSOOOOOQQQQQQQQQQQQQQQQCTTTTFFFFFFFFFFVOOVSSSSSSSSSVVVVDVVVVV
            JTTTTTTTTTTTTCQQQQQQQEEEEEOOOOOFFFFFFFFFFFFFFCKKKKKKKSHHHHHRRGHHBBBBBBBBALOOSSSSSOOOAAQQQQQQQQQQQQQQQQTTTTFFFFFFFFFFFFOVSSSSSSSSSDDDDDDVVVVV
            JJJTTTTTTTTTTCQOQQQQQEEEEOOOOOOFFFFFFFFFFFFFFKKKKKKKKKNHHHHHRHHHHHBBBAABALOSSSSSSOHOAAQQQQQQQQQQQQQQQQCTTTFFFTTTFFFFFFOOTTSSSSSSSDDDDDDDVVVV
            JJTTTTTTTTKTTCQOOQQQQEEOOIOOOOOFFFFFFFFFFFFFFKKKKKKKKKHHHHHHHHHHHHBBBAAAALOOSSSSHOHQQQQQQQQQQAAAAAQQQQCTTTTFTTTTTTFFFOOOTTSSSSSSSDDDDDDDDVDV
            JJJTITTTTKKKTXOOOQQQEEEOOOOOOOOFFFFFFFFFFFFFFKKKKKWWWWHHHHHHHHHHHHHBBAAALLLOSSSSSLLQQQQQQQQQQAAAAAACCCCTVTTTTTTTTTQFOOOOTTTSSSBBBBDDDDDDVVDV
            JJJTIIRTTKKKXXXXXQQQPYOOOOOOOOOQQQZZZTFFFFQFFKQQHHHHHWHHHHHHHHHHHWVVBAALLLLOOOLLLLLQQQQQQQQQQAAAAACCCTCTTTTTTTTTTMCOOOOOOOOOBBBBBBDDDDDDVDDD
            IIIIIIITTIKKIZXXXXDYYYOOOOOOOOOOQQZZQQQFFFQQQQQQHHHHHHHHHHHHHHHHWWWVWWALLLLLOOLLLLLQQQQQQQQQQAAAACCCCTTTTTTTTTTTGCCCOOOOOOOOOODDDDDDDDDDDDDD
            IIIIIIITIIIIIZXXXXYYYYOOOOOOOOOQQQQQQQQFQQQQQHHHHHHHHHHHHHHHHHHWWWWWWWAWYLLLLLLLLLLQQQQQQAYAAAAAACCCTTTTTTTTTTTTGGCOOOOOOOOOOOODDDDDDDDDDDDD
            IIIIIIIIIIIIIIXXXXYYYYYOOOOOOOOQQQQQQQQQQQQQQRHHHHHHHHHHHHHHHHHWWWWWJWWWYLLLLLLLLLTQQQQQQYYYAYAAACTTTTTTTTTTTTTTTTCCOOOOOOOOOOODDDDDDDDDDDDD
            IIIIIIIIIIIIIXXXXYYYYYYYYOOOOOOQQQQQQQQQQQQRRRHHHJHHHHNHHNHHHHWWWWWWWWWWYLLLLLLLLLTQQQQQQYYYYYYAYCTTTTTTTTTTTTTCTCCCCCFOOOOOOOOODDDDDDDDDDDD
            IIIIIIIIIIIIIIXXXYYYYYYYYYYYOQOQQQQQQQQQQQQRRQHHJJHHHNNNNNNNHHWWWWWWWWYWYYLLVLLLLLTTTTTTYYYYYYYYYYYTTTTPATTTTTTCCCCCCCCCOOOOOOOODDDDDDDDDDDD
            IIIIIIIIIIIIXXXXXXYYYYYWWWWQQQQQQQQQQQQQQQQRQQJJJJHHHHNNNNNNNNWWWWWWWWWYYVVLVLLLLLTTTTTTTYYOOOYYYYYTTTAAATZZTTCCCCCCCCOOOOOOOOOODDDDDDDDDDDD
            IIIIIIIIIIIIZXZXZXYYYYYWWWWWQQQQQQQQQQQQQQQQQQQEEJJJHHNNNNNANNWWWWWWWVWWVVVVVTTLLLTTTTTTYYYOYYYYYYYYTTTAAATTTCCCCCCCCOOOOOOOOOOOOXXDDDDDDDDD
            IIIIIIIIIIIIZXZZZYYYYYYWWWWWSSQQQQQQQQQQQQQQQEEEEEEJJJJNNNNAAWWWWWWWWVVVVVVVVTTLTTTTTTTTTTOOYOYOYYYYTTAAAAAAACCCCCCCCCOOKOOOOOFOBUUDDDDDDCDD
            VVIIIIIIIIIIZZZZZYYYYYWWWWWWWWQQQQQQQQQQEQEEQEEEEEEEJJJJNNNNAWWWWWWWWWVVVVVVVTTTTTTTTTTTTTOOOOOOOOYYYAJAAAAACCCCCCCCCCOOKOOOKKOOUUUUUUDDCCCC
            VVIILIIIIIIIZZZZZZYZZWWWWWWWWWWQQQKQQQQQEEEEEEEEEEEEJJWWWWWWAWWWWWWWWVVVVVVHVTVTTTTTTTTTTOOOOOOOOOOYYAAAAAAAACCCCCCCCCOOKKKKKKUUUUUUUCCDCCCC
            VVVIIIIIIIIZZZZZZZYZZWWWWWWWWWWQQQWQEEEQQEEEEEEEEEEWWJWWWWWAAAWWWWWWWWVVVVVVVVVTTTTTTTTTTOOOOOOOOOOAAAAAAAAACCCCCCKCKKKKKKEKUKUUUUUCCCCCCJCC
            VVVVVIIIIIZZZZZZZZZZZZZWWWWWWWWWQWWEEEEQEEEEEEEEEEERWWLWWWWAAWWWWWWWWWVVVVVVVVVTTTTTTTTTOOOOOOOOOOAAAAAAAAAACCCCCKKKKKKKEEEKUUUUUUUJJJJJCJJC
            VVVVVVVIINZYZZZZZZZZZZZWWWWWWWWWWWWEEEEEEEEEEEEEEWWWWWWWWWWAAAAWWWWWWWWVVVVVVVVVTTTTTTOOOOOOOOOOOOAAAAAAAAAAACACCKKKKKKKKEEEEUUUKKUJJJJOJJJJ
            VVVVVVVIINZYZZEVPVVVZZZZWWWWWWWWWWWWWEEEEEEEEEEEEEWWWWWWWWWAKAAAAKEKWRRVVVVVVVVVITTTTOOOEEOOOOEECAAAAAAAAAAAAAACKKKKKKKEEEEEEEKKKKKJJJJJJJJJ
            VVVVVVVVMMMMZEEVVVVVZZZZZZWWWWWWWGWEEEEEEEEEEEMMMEEWWWWWWKKKKKAKKKKKRRRZVVVVVVVVTTTTTOOOEQEOOEEECAAAAAAAAAAAAAAAAAAKKKKEEEEEEEKKKKKJJJJJJJJR
            VVVVVVVVMMMMJVEEVVVVVVVVVWWWWWWGGGEEEEEEEEEEEEMMMEEEWWKWWXXXKKKKKKKKRZZZZVVVVDDDDDDTEEOEEQEEEEEMEQQQAAOAAAAAAAAAAAAKEEEEEEEEEEKKKRRRRJJJJJRR
            VVVVVVVMMMMMVVVVVVVVVVVVTWWWWGGGGGGGEEEEEEEEEEMMMMEETKKKKXXKKKKKKZZZRZZZZVVVVDDDDDDTEECEEEEEEEEMEEAAAAOAAAAAAAAAAAAKEEEEEEEEEEEKKRRRRRRRJBRR
            VVVVVVMMMMMMMMVVVVVVVVVVVVGGGGGGGGGGGEEEEEEEDDMMMRRETTTKKKKKKKKKKZZZZZZZYVVVVDDDDDDDEEEEEEEEEEEEEEOAAZOOAAAAAAAAADDLWWWWEEELEILKRRRRRRRRRRRR
            VVVVMMMMMMMMMMMVVVVVVVVVVGGGGGGGGGGGGGEEEDEDYDMMMMEETTTKKKKKKKKKKKKZZZZZZVVVDDDDDDDDEEEEEEEEEEEEEEOOOOOOOAAALALLLDDLEEEEEELLIILRRRRRRRRRRRRR
            VVVVVMMMMMMMMMVVVVVVVVVVVVGGGGGGGGGGGGEEDDDDDDMMMMTTTTKKKKKKKKKKKKKZZZZZZZDDDDDDDDDEEEEEEEEEEEEEEEOOOOOOOOOOLLLLLDLLLLLEELLLLLLLRRRRRRRRRRRR
            VVVVVMMMMMMMMMVVVVVVVVVVVSGGGGGGGGGGGEEDDDDDDTDMMMTTTTKKKKKKKKKKZZZZZZZZZZZZDDDDDDDEEEEEEEEEEEEEEOOOOOOOOXLLLLLLLLLLLLLLLLLLLLLLRRRRRRRRRRRW
            VVVMMMMMMMMMMMVVVVVVVVVVVSGGGGGGGGGGSDDDDDDDDDDTTMTTTKKKKKKKKKKKZZZZZZZZZZZDDDDDDEEEEEEEEEEEEEEEEOOOOOOOLLLLLLLLLLSLLLLLLLLLLLLLLRRRRRRRRRRR
            VVVVMOOMOMMMMBBVVVVVVVVVVSSSGGSSSSGSSSDDDDDDDDDTTTTTTTKFFKKKKKKKZZZZZZZZZZZZDDDDDDDEEEEEEEEEEEEEOOOOOOOOLLLLLLLLLLSSSLLLLLLLLLLLLRRRRRRRRRRR
            VVOOOOOOOOMMPBPPVVVVVVVSSSSSGGGSSSSSSDDDDDDDDTTTTTTTTTTLFFKKKKKKKKKZZZZZZZIIDDDDDDDEEEEWEEEEEEEEKKKKOOOOLLLLLLLLLLSSSSLLLLLLLLLLLLRRRRRRRRRW
            VVOQOOOOOOMMPPPPPVVVVVVVSSSSSSSSBSSSSSSDDDDDDDDDTLLLTTTLFFKKKKKKKKKDDZZZZZZDDDDDDDDDDEEEEEEEKKEKKKKLLLLLLLLLLLLNLLSSSLLLLLLLLLLLLRRRRRRRRRRW
            VVOOOOOOOOMPPPPPPVVVHVVVSPSSSBBBBBSSSDDDDDDDDZDDTLLLLLLLLFFKKKKBBKKDDDDDDDDDDDDDDDDDDEEKEEKKKKKKKKKLLLLLLLLLLLLLLLSSSLLLLLLLLLLLRRRRRRRRRRRW
            VVVOOOOOOOMPPPPPPPPVHPVSSPSSSSBBBBBBBBCDDDDZZZZLLLLLLLLLLFFVVVVVDDDDDDDDDDDDDDDDDDDDKKKKKKKKKKKKKKFLLLLLLLLLLLLLLLLLSSSLLLLLYLDRRRRRRRRRWWWW
            VVVVOOOOOOSPPPPPPPPVVPEPPPSSSBBBBBBBBBLDLMLLZZLLLLLLLLLVVVVVVVVVVDDDDDDDDDDDDDGDDDDDDKKKKKKKKKKKKFFFIIOLLLLLLLLLLLLLLSSSLLYYYYRRRZZRRRRRRWWW
            VVVOOVOOOOOPPPPPPPPPPPPPPPSSBBBBBBBBBBLLLLLLZLLLLLLLLLLVVVVVVVVVVDDDDDDDDDDGDDDDDDDFDKKKKPPKKKKKKFFFFIOLLLLLLLLLLLLLLSSSLKYYRRRRFFZKZZDDZZZZ
            VVVOOVVVVOPPPPPOPPPPPPPPZPSSBBBBBBBBBBBLLLLLZZLLLLLLLLLVVVVVVVVVVVDDDDDDDDDDDDDDHFFFFKPPPPPPPPPPPFFFFLLLLLLLLLLLLLLLLSSSKKYYYRRFFFZKZZDZZZZZ
            VVVVVVOOOOOOOOOOOPPPPPPPZZSBBBBBBBBBBBLLLLLLLLLLLLLLLLVVVVVVVVVVVDDDDDDDDDDDDDLUUFFFFFPPPIIIIIPPPFFFFFFLLLLLLLLLLLLLSSSKKKKKYKRFFZZZZZZZZZZZ
            VVVVOVVOOOOOOOOWOPPPPPPPPPSSIIIIIIIIBBLLLLLLLLLLLLLLLVVVVVVVVVVVVDDDDDDDDUUDDUUUUUUUFFPPPIIIIIPPPFFFFFFLLLLLLRRRRLSSSKKKKKPKKKFFZZZZZZZZZZZZ
            VVOOOOOOOOOOOOOOOOSPPPPPPSSSIIIIIIIIBLLLLLLLLLLLLLLLLVVVVVVVVVSSSDDDDDDDUUUDDUUUUUUIIIIIIIIIIIPPPFFFFFFRRLLLLRRRRSSSSKYKKKKKKKFZZZZZZZZZZZZZ
            OOOOOOOOOOOOOOOOSSSPPPPSSSSSIIIIIIIIBLLLLLLLLLLLLLLLLLFVVVVVVVSSDDDDRRRDUUUUUUUUUIIIIIIIIIIIIIPHPFFFFFRRRLLRRRRSSSSSSSKKKKKKKFFZZZZZZZZZZZZZ
            LOOOOOOOOOOOOOOSSSSSPSSSSSSSIIIIIIIIBLLLLLLLLLLLLLLLLLVVVVVVVVSSSSDRRRRUUUUUUUUUUIIIIIIIIIIIIIPPPPFFFFFRRRRRRRRRSSSKKKKKKKKKKZZZZZZZZZZZZZZZ
            OOOOOOOOOOOOOOOSSSSSPSSSSSSSIIIIIIIIBBNNNNLLLLLLLLLLLLVVVVVVVVSRRSDRRRRRUWUUUUUUUIIIIIIIIIIIIIPPPPFFFFFFRRRRRRRRSSSSKKKKKKIJJYZZZZZZZZZZZZZZ
            OOOOOOOOOOOOOOOOSSSSSSSSSSSSIIIIIIIINNNNNNLLLLLULHLLLLVVVVVVVVRRRRRRRRRUUWWUUUUUUIIIIIIIIIIIIIPPPPPFFFRRRRRRRRRRSSSSKKKKJJJJJYZZZEPZZZZZZZZZ
            OOOOOOOOOOOOOOOOGGSSSSSSSSSSIIIIIIIINNNNNNLLLLLLHHHHHHVVVVVVVDFRRRRRRRRRRWWUUUUUUIIIIIIIIIIIIISSSXSFFFRRRRRRRRRRRRJKKKKKKJJJJJPPPPPZZPZZZZZZ
            OOOOOOOOOOOOOOOOGGSSSSSSSSSSSSBBBBBBNNNNBNNLLLLLHHHHHVVVVLDZVDFRGRRRRWWWWWWUUWUUUUUIIIIIIIIIIIPPSSSFFFRRRRRRRRRRRJJKKKKKJJJJJJPPPPPPPPPPPZZZ
            OOOOOOOOOOOOONGGGGGSSSSSSSSSSSBQBBBBBNNNBBBLLLLLBHHHVVVVVDDDDDDDRRRWWWWWWNWWWWWWUUVUUVPPPPPPPPPSSSSSFFRRRRRRRRRNRJKKJJJKJJJJJHPPPPPPPPPPPPPZ
            OOOOOOOOOOOOOODGGGGGSSSSSSMMMMMMBBBOBBNNBBBBBLLBBBBBVVVVVDDDDDDDRRRKWWWWWWWWWVVVVUVVVVUPPPPPPPPSSSSSWRRRRRRRRRRRRJJJJJJJJJJJJPPPPPPPPPPPPPPP
            OOOOOOOOGGLLGGGGGGGGGGGSMMMMMMMOOOOOBBNNBBBBBBBBRBBDVVVVVDDDDDWWWWWWWWWWWWWWWWWWVUVVVVUUPPPSPPSSSSSSSSSRRRRRRRRJJJJJJJJJJJJUUIUPPPPPPPPPPPPP
            OOOOOGGGGGGGGGGGGGGGGMSSMMMMMMMMOOBBBBBBBBBBBBBBBBBDDDVDDDDDDDGWWWWWWWWWWWWWWWWVVVVVVVUUPPPSSSSSSSSSSSSRRRAAARRJJJJJJJJJJJUUUUUUPPPPPPPPPPPF
            OOOOGGGGGGGGGGGGGGGGGMMSMMMMMMMMOOMMBBBBBBBBBBBBBBBDDDDDDDDDDGGGGGWWWWWWWWWWWVWVVVVVVVUUUPSSSSSSSSSSSSSRAAAAAJJJJJJJJJJJJJUUUUUPPPPPPPPPPPPP
            OOOOGGGGGGGGGGGGGGGGGMMMMMMMMMMMMMMMBBBBBBBBBBBBBBBBDDDUUUDDDGGGGGWWWWWWWWWWWVVVVVVVVVUUUUCSSSSSSSSSSSSSSAAAAJJJJJJJJJJJJJUUUUUPPPPPPPPPPPPP
            OOOOGGGGGGGGGGGGGGGGGMMMMMMMMMMMMMMBBBBBBBBBBBBBBBBBBUDDUUUDDGGGGWWWWWWWWWWWWWVVVVVVVVUUUUSNSSSSSSSSSSSSSSSAXJJJJJJJJJJJJUUUUUUPPPPPPPPPPPPP
            OOOOGOGGGGGGGGGGGGGGGMMMMMMMMMMMMMBBBBBBBBBBBBBBBBBPUUUUUUNUDGGGGGWWWWWWWWWWWVVVVVVVVVUUUUSNSSSSSSSSSSSSDSSXXJJJJJJJJJJJJUJJUUPPPPPPPPPPPPPP
            OOOOGOGGGGGGGGGGGGGGGMMMMMMMMMMMMBBBBBBBBBBBBBBBBBBPPPUUUUUUUGGGGGWGWWWWWWWWWVVVVVVVVVVVUUSSSSSSSSSSSSXSSXXXXJJJJJJJJJJJJJJJUUUPPPPPPPPPPPPP
            OOOOOOOOGGGGGGGGGGGGGMOMMMMWMMMCMBBBBBBBBBBBBBBBBBPPPUULUUUGGGGGGGGGGWIIIWGWVVVVVVVVVVVVUUYYSSSHSSSSTSXXXXXXXXXJJJJJJJJJJJUUUUPPPPPPPPPPPPPP
    """.trimIndent()
    )
    check(1533644, result)
}

private fun test(input: String): Int {
    val map = input.split("\n")
    val height = map.size
    val width = map[0].length

    fun isInsideMap(point: Point): Boolean {
        return point.x in 0..<height && point.y in 0..<width
    }

    fun Point.generateNext(plot: Set<Point>): Set<Point> {
        val results = mutableSetOf<Point>()
        val set = setOf(Point(0, 1), Point(1, 0), Point(0, -1), Point(-1, 0))
        for (delta in set) {
            val next = Point(x + delta.x, y + delta.y)
            if (isInsideMap(next) && map[next.x][next.y] == map[x][y] && next !in plot) {
                results += next
            }
        }
        return results
    }

    fun bfs(startPoint: Point): Set<Point> {
        val plot = mutableSetOf<Point>()
        var opened = mutableSetOf<Point>()
        opened += startPoint
        plot += startPoint
        while (opened.isNotEmpty()) {
            val achievable = mutableSetOf<Point>()
            for (current in opened) {
                val next = current.generateNext(plot)
                for (nextPoint in next) {
                    achievable += nextPoint
                }
            }
            opened = achievable
            plot += achievable
        }
        return plot
    }

    val plots = mutableSetOf<Set<Point>>()
    for (x in 0..<width) {
        for (y in 0..<height) {
            val foundNew = plots.none { it.contains(Point(x, y)) }
            if (foundNew) {
                val plot = bfs(Point(x, y))
                plots += plot
            }
        }
    }

    fun adjacent(point: Point, plot: Set<Point>): Set<Point> {
        val results = mutableSetOf<Point>()
        val set = setOf(Point(0, 1), Point(1, 0), Point(0, -1), Point(-1, 0))
        for (delta in set) {
            val next = Point(point.x + delta.x, point.y + delta.y)
            if (next in plot) {
                results += next
            }
        }
        return results
    }

    fun perimeterOf(plot: Set<Point>): Int {
        var p = 0
        for (point in plot) {
            p += 4 - adjacent(point, plot).size
        }
        return p
    }

    var fiyat = 0
    for (plot in plots) {
        fiyat += plot.size * perimeterOf(plot)
    }

    return fiyat
}
