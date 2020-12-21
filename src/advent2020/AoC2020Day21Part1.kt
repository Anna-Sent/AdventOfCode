package advent2020

import java.util.regex.Pattern

private val pattern = Pattern.compile("contains ([\\w ,]+)\\)")

private fun test(input: String): Int {
    val dishes = mutableListOf<Pair<Set<String>, Set<String>>>()
    val allIngredients = mutableSetOf<String>()
    val allIngredientsList = mutableListOf<String>()
    val allAllergens = mutableSetOf<String>()
    val tokens = input.split("\n")
    for (token in tokens) {
        val lists = token.split(" (")
        val ingredients = lists[0].split(" ").toSet()
        allIngredients += ingredients
        val s = lists[1]
        val matcher = pattern.matcher(s)
        if (!matcher.matches()) {
            throw IllegalArgumentException("not matches $s")
        }
        val allergens = matcher.group(1).split(", ").toSet()
        allAllergens += allergens
        println("$ingredients -> $allergens")
        dishes += ingredients to allergens
        allIngredientsList += ingredients
    }

    val allergenToIngredients = mutableMapOf<String, MutableSet<String>>()
    for (allergen in allAllergens) {
        allergenToIngredients[allergen] = mutableSetOf()
    }

    for ((ingredients, allergens) in dishes) {
        for (allergen in allergens) {
            allergenToIngredients[allergen]!!.addAll(ingredients)
        }
    }

    println(allergenToIngredients)

    while (!allergenToIngredients.all { it.value.size == 1 }) {

        for ((dish1Ingredients, dish1Allergens) in dishes) {
            for ((dish2Ingredients, dish2Allergens) in dishes) {
                val commonIngredients = dish1Ingredients.intersect(dish2Ingredients)
                val commonAllergens = dish1Allergens.intersect(dish2Allergens)
                if (commonAllergens.size == 1) {
                    val commonAllergen = commonAllergens.toList()[0]
                    allergenToIngredients[commonAllergen] = allergenToIngredients[commonAllergen]!!
                            .intersect(commonIngredients).toMutableSet()
                }
            }
        }

        for (allergen in allAllergens) {
            if (allergenToIngredients[allergen]!!.size == 1) {
                for ((a, i) in allergenToIngredients) {
                    if (a != allergen) {
                        i -= allergenToIngredients[allergen]!!
                    }
                }
            }
        }

        println(allergenToIngredients)
    }

    allIngredientsList.removeAll { e -> allergenToIngredients.values.any { s -> s.contains(e) } }
    return allIngredientsList.size
}

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test("""
        mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
        trh fvjkl sbzzf mxmxvkd (contains dairy)
        sqjhc fvjkl (contains soy)
        sqjhc mxmxvkd sbzzf (contains fish)
    """.trimIndent())
    check(5, result)

    result = test("""
        qtncs hjlcgk rrvp rgc tzvlm vxkmcmj dxk gpgf fnbqnt fnqxjl cppzn ctnkv czvhncg krjn mft dknlb gnsxbz gljdv htskk kkzqp mpm jckpd xbmj xvph bvh cjbvz tdtzd tdbcfb qrvft mxkh rhcj jcbcxtj hkxqsc dfbnq sxksnzf ckqnfq hbmv xnzqrm ndssl hkzrs rgdz nhhsgd hchdc zgng nsvfk lbgntt gjck grsx ndgfp nptr mmpgm mqxhh csmfzp sp gptcng gdtq bpbdlmg rtnjfqm ssfvs cpvn bgsdh dfxmxd jjgvd hrbdk (contains dairy)
        xppdk rgc kntss qkdgt jpvfc sjvrgx tkqng smzhj jdmhd zhj xbmj bvh zgng jvshst rhcj rjt cvcr qgqnjx xbdsf ckqnfq cpvn ldkmxjd hskshtl mtxxb zfrlbz qtncs krjn gkcqxs jttxhczk sxlj fnbqnt ctnkv hdrkr bpbdlmg jcbcxtj mvv tzvlm cnhch vbb qmgfs ndgfp dxk hfkvr dgcq xnzqrm vmhf sp nptr nmfv hkzrs rgphsms dfbnq vcx bnsfss kfpx cbmnb tdbcfb dknlb dtv gdtq tprcc nhhsgd hkxqsc rhrrrbr (contains fish, wheat, shellfish)
        sp bvh cnjmk zjzrbq jjgvd mvv krjn dpfvx grsx sgnq lcc qmgfs jcbcxtj cvcr smzhj rhcj kfpx jdmhd qrvft qbbdfr kkzqp ckqnfq drsbbfrp cztkz stnlkxj vfcs xbdsf mxkh mmbqr mckrjz vxkmcmj cppzn ctnkv rgdz hdrkr pvtbbc gjck mft tdbcfb mjndggkb jcmbbfm gnsxbz vrjj hdgfgj hkzrs bpbdlmg rsrxtc rgc bnhmc zfrlbz pnkpb cjbvz mbjt dfxmxd (contains sesame, nuts)
        lcc sp cxjkfz bklcz nzcgntfs qvzxxp kfpx tdbcfb grsx vbb pxz bhp mvv gkcqxs tk qmvp mft xdkhj rjt vmhf smpsr tdtzd kfsl fczmkt hskshtl gnsxbz bbxmx cztkz qkdgt zhj bnhmc hkzrs bvh rgphsms dbdmmt bbmpr hrbdk cnjmk lpznnc xrtx gpgf qbbdfr zxr jjgvd bpbdlmg nptr mmbqr hchdc lnhqgk tzvlm pnkpb dgcq hsrjm htskk cbmnb rgc ldg xbmj krjn bn cnhch vdhtgm (contains nuts, fish, wheat)
        ngrnd qtc hdrkr qgqnjx sjzsc fhp cbmnb qbbdfr jckpd lpznnc xrrcj ldkmxjd krjn kflk nhhsgd cvpt dfxmxd sjvrgx xrtx bpbdlmg mxkh zbrfr hfkvr xdkhj qtncs pxz bnsfss tk cppzn kbtxv tzvlm tjpsn rgc tkqng nptr rhrrrbr bnhmc bvh skkgc jvshst zjzrbq fjk gljdv hsrjm sp xbmj dtdbzq ndgfp lgsk vxkmcmj nmfv lcc bgsdh ctnkv tdbcfb qrvft bn hzvgn lbgntt ndssl rgphsms qjgrv kntss mmbqr scvzn ktrfs zxr xvph lxntzp hdgfgj gptcng tdtzd jttxhczk xbdsf gdtq md (contains soy, nuts)
        qbbdfr mqxhh cztkz kfsl stnjg gkcqxs mxkh kzcpb mbjt csmfzp ndgfp fczmkt hvgh pxz gjck qgqnjx tzqrlb bvh vzzgts mvfqbnlb kntss bzfv drsbbfrp scvzn cjbvz xrrcj kfpx jchrn gxxg stnlkxj hsrjm vbb mckrjz zjgxg vcx md vfhlb hbmv dpcmr qmvp lkkt ldtr jpvfc cvpt tzvlm vxkmcmj czvhncg sxksnzf xvph jckpd krjn ngrnd mpm hdgfgj pnkpb xrtx zxr zbrfr xtnk grsx zfrlbz qqzjfk ldg nptr rgc rhcj hfkvr tdbcfb dpfvx hjlcgk gljdv vrjj qss xbdsf kthm bn bpbdlmg fhp xppdk qtncs (contains shellfish)
        qbbdfr jckpd dtv jjgvd rsrxtc dgcq ssfvs hsrjm tdbcfb kntss nhhsgd xdjt vcx nptr zjgxg jpvfc ndssl xrrcj hdgfgj rxpddd tzvlm kfpx bpbdlmg ndgfp zxr bzfv lkkt pvtbbc gkcqxs kkzqp hkzrs qvzxxp bn xbdsf lgsk nzcgntfs sgnq ktrfs sxksnzf qss sp qmgfs rgdz sgn tjpsn mxkh mpm sxlj rgc dpfvx xppdk dfbnq jcmbbfm md mmpgm gptcng lpznnc cppzn vnqh zjzrbq mqxhh vdhtgm cxjkfz jvshst mtxxb rrvp fnqxjl gpgf mgngg bvh (contains peanuts, nuts)
        jdmhd lxntzp qgqnjx jvshst jchrn hchdc qbbdfr rgc nhhsgd kfsl kbtxv jttxhczk zjgxg xtnk rsrxtc scvzn zbrfr ssfvs dpcmr kqctvs rhrrrbr mtxxb vmhf tdbcfb csmfzp bpbdlmg mmpgm mxkh zgng cnhch hzvgn rhcj xdjt krjn ldg sgn tghpf vbb rxpddd gdtq lbgntt qtc jjgvd ldkmxjd vzzgts stnlkxj nmfv jpvfc xvph rrvp bvh vfgg bgsdh nsvfk xdkhj mjjgj grsx qvzxxp cppzn vrjj rtnjfqm rjt hdgfgj jcbcxtj vxkmcmj sp (contains soy, dairy)
        qmvp zjgxg md sxlj qgqnjx mmbqr jchrn hchdc ldkmxjd qkdgt xppdk rtnjfqm rgdz rsrxtc tk gdtq tghpf bnsfss jckpd htskk krjn bpbdlmg sp fjk bhp lpznnc gkcqxs jdmhd hskshtl hsrjm lbgntt mxkh hbmv hrbdk lkkt bvh qrcmm xnzqrm rgc bnhmc grsx hjlcgk smzhj qss pnkpb rhcj hdrkr tzqrlb kntss (contains nuts, sesame, fish)
        vfcs dtdbzq tdbcfb tzqrlb sjvrgx hbmv ctnkv krjn bbxmx vrjj jpvfc csmfzp zxr cbmnb nzcgntfs zbrfr ckqnfq sxlj dgcq qmgfs xdjt tk mxkh dqgl jckpd ssfvs vdhtgm dknlb rgphsms drsbbfrp bvh xtnk vfhlb dfbnq nptr mqxhh bpbdlmg sp czvhncg bnhmc kqctvs dpcmr xnzqrm tghpf sgn cvpt ndssl hkxqsc fhp ngrnd mjjgj gkcqxs qmvp lcc hzvgn vbb (contains dairy, soy)
        zjgxg tkqng dfbnq bzfv gkcqxs zjzrbq rxpddd mbjt sgnq hrbdk bvh md jdclr nzcgntfs cpvn bgsdh mjndggkb skkgc ngrnd stnjg scvzn kflk lxntzp vdhtgm rgc tdbcfb fhp dbdmmt jttxhczk pvtbbc tghpf tdtzd rdnhkqz kntss bnhmc dtdbzq mmpgm ssfvs rjt zhj vbb smzhj drsbbfrp hfkvr mmbqr xrtx smpsr lpznnc sp vfcs hjlcgk sxlj rtnjfqm hzvgn jcbcxtj jpvfc qmvp gdtq krjn vcx bpbdlmg nptr rhrrrbr jckpd (contains soy, peanuts, sesame)
        lkkt htskk zjzrbq nmfv mxkh rtnjfqm md sp stnlkxj kflk lxntzp jdclr ldtr ldkmxjd vfgg rhcj xdkhj dpfvx mckrjz qqzjfk cztkz sxlj rgc kthm jvshst smpsr hkxqsc hchdc jpvfc tdbcfb cxjkfz tprcc tzvlm vxkmcmj gnsxbz qrcmm qtc lpznnc pvtbbc qtncs fnbqnt grsx sjzsc qvzxxp fnqxjl mbjt vrjj hzvgn mqxhh tghpf ngrnd cjbvz drsbbfrp krjn sxksnzf dtv bpbdlmg gkcqxs zjgxg dqgl kzcpb (contains peanuts)
        kntss qgqnjx xvph xspm nhhsgd jdmhd gpgf dqgl csmfzp gkcqxs tzqrlb vfgg nptr hrbdk xbdsf mmpgm hskshtl lbgntt dtdbzq zxr qqzjfk cbmnb rdnhkqz hsrjm dgcq dfxmxd lpznnc hzvgn kkzqp qtc kthm jcbcxtj tdbcfb jpvfc rxpddd rhcj hdrkr zjgxg fczmkt mbjt cppzn nsvfk lgsk vfhlb mjjgj nzcgntfs ldkmxjd ngrnd qtncs mxkh jvshst dknlb nmfv sp xrrcj fnbqnt bvh qrcmm jchrn qrvft ktrfs bpbdlmg zjzrbq vxkmcmj scvzn krjn mgngg tdtzd jcmbbfm bhp (contains peanuts, nuts, shellfish)
        cztkz dtv gnsxbz fhp vrjj hrbdk vfgg vzzgts ktrfs sgnq qtc hbmv cvcr dgcq kzcpb tprcc krjn lpznnc hdgfgj gxxg ctnkv rhrrrbr hjlcgk kkzqp dpfvx dxk gptcng htskk bpbdlmg csmfzp sjzsc ckqnfq qtncs cvpt xbdsf jjgvd qss mxkh ssfvs kfpx mpm qqzjfk bgsdh jchrn vbb mgngg bklcz bvh mckrjz qmgfs jvshst smzhj zgng gkcqxs bnhmc dqgl vxkmcmj lbgntt mvv rsrxtc zjzrbq stnjg gpgf rgc dtdbzq nzcgntfs lcc jpvfc pnkpb zfrlbz sp sjvrgx cvvjvf nsvfk md kqctvs cxjkfz tjpsn smpsr cppzn (contains nuts, dairy, peanuts)
        fnbqnt mpm cnjmk pnkpb hrbdk xvph qqzjfk tdbcfb dpfvx vrjj rjt nzcgntfs qmvp krjn cvpt dfxmxd bklcz tk ngrnd vnqh hzvgn hkzrs nhhsgd zgng mft dtdbzq rxpddd bbmpr skkgc cpvn ctnkv kkzqp lcc gkcqxs qtncs jpvfc ldtr hfkvr fjk ssfvs bvh mjndggkb sxlj rhcj bn kntss mgngg gjck kflk sjvrgx kqctvs mqxhh pvtbbc bnsfss rgc qkdgt cppzn tzqrlb sp rrvp qtc hbmv mxkh drsbbfrp kfpx mjjgj gpgf tzvlm zjgxg (contains shellfish, fish)
        mgngg vcx rgc nzcgntfs zjgxg rdnhkqz ctnkv fjk csmfzp hskshtl bnsfss ldg tk tjpsn mqxhh cvcr drsbbfrp vxkmcmj lkkt tprcc rjt md cztkz dpcmr kflk dknlb zhj kkzqp fnqxjl dtdbzq gkcqxs ldkmxjd ktrfs bbmpr dpfvx qtc cbmnb gxxg hzvgn sxlj tzqrlb jdclr fhp mft dbdmmt kzcpb cvpt czvhncg cnhch xtnk tdtzd hjlcgk sjvrgx bnhmc tdbcfb grsx mxkh htskk hdgfgj mmpgm bzfv hfkvr bklcz rsrxtc bpbdlmg dxk jjgvd qjgrv bvh jckpd rtnjfqm zjzrbq nmfv vfgg sp ckqnfq (contains nuts, sesame, fish)
        rxpddd ktrfs hskshtl sp zfrlbz xnzqrm qgqnjx bvh ldkmxjd lxntzp hzvgn qjgrv tzvlm ngrnd ndgfp rgphsms zgng cxjkfz jpvfc rhcj bbxmx qtc htskk sjvrgx qmgfs kzcpb drsbbfrp rsrxtc mxkh cvcr sgnq bn tzqrlb ctnkv ldg vzzgts rgc kfsl skkgc hdgfgj rrvp tghpf jdclr rgdz nmfv tprcc cnjmk gdtq tdbcfb hkxqsc cztkz dfxmxd gkcqxs ndssl krjn lnhqgk jckpd mft cvpt (contains peanuts)
        xnzqrm gkcqxs hjlcgk nhhsgd rgdz fhp qmgfs jcbcxtj jckpd ndssl qtncs xppdk mpm qtc xbmj fczmkt czvhncg mbjt kntss xdkhj drsbbfrp cvvjvf gdtq dtv vfcs bhp dqgl kbtxv mxkh cxjkfz tjpsn xvph cppzn bvh gnsxbz bnhmc rgc vnqh cbmnb gpgf smpsr tdbcfb pnkpb hkxqsc bzfv bn bpbdlmg scvzn zjgxg gxxg ngrnd ssfvs sgnq dfbnq hzvgn ctnkv jttxhczk nptr tk sp nmfv hbmv vrjj xbdsf (contains sesame, wheat)
        ktrfs jvshst jchrn dbdmmt gxxg rjt kflk jjgvd vfgg vrjj rgc pxz sgn bzfv bhp grsx vxkmcmj qbbdfr fczmkt dqgl hchdc tdtzd xspm cnjmk hkzrs krjn rgdz hrbdk tjpsn mpm jpvfc cpvn kthm gkcqxs hvgh zbrfr bpbdlmg tdbcfb kkzqp qgqnjx cppzn hskshtl cvpt qvzxxp qtc kzcpb mckrjz sgnq gnsxbz mxkh nhhsgd qrcmm bvh qjgrv kfsl hzvgn fjk stnlkxj dfbnq vnqh (contains nuts, sesame)
        ldtr kfsl mpm tzvlm tzqrlb mvv vnqh rjt drsbbfrp bbxmx bnhmc jchrn sxksnzf xbdsf kflk xnzqrm hbmv hsrjm sp ndssl bnsfss czvhncg sxlj bvh gdtq zgng bpbdlmg mmpgm vmhf zjgxg krjn nmfv hkxqsc qrcmm smzhj qmvp vfhlb gkcqxs dqgl xspm mxkh rdnhkqz fjk bhp nzcgntfs lpznnc qjgrv tdbcfb bklcz hskshtl qtncs lxntzp ktrfs gptcng ngrnd fczmkt dtdbzq md jpvfc smpsr tjpsn cbmnb (contains fish, nuts)
        xdjt krjn xspm vbb htskk rgdz kqctvs cxjkfz hfkvr mqxhh pvtbbc rjt jvshst smpsr tghpf hsrjm sxksnzf vfhlb vcx qss tk qtncs clmg sp mvfqbnlb hzvgn bhp rgc nzcgntfs tdbcfb qtc czvhncg gkcqxs vnqh hkzrs mxkh qjgrv bpbdlmg nhhsgd gljdv qmgfs rtnjfqm cnhch vdhtgm mgngg ldtr rhcj vrjj dxk sgnq tdtzd (contains sesame)
        vrjj zhj vfhlb smpsr xnzqrm ckqnfq bn czvhncg rjt cvcr bvh rdnhkqz kthm qrcmm md gnsxbz jvshst xspm cnjmk bpbdlmg pnkpb jckpd mxkh mft gxxg xtnk sp mmbqr rgphsms mqxhh kbtxv clmg tdbcfb qvzxxp bzfv lnhqgk xppdk zbrfr nzcgntfs jttxhczk mmpgm tzvlm vfcs kfsl ssfvs nmfv ldg ctnkv dknlb cvpt hbmv gljdv cpvn sxksnzf rgc jcbcxtj krjn xdjt bnsfss kzcpb cnhch hdrkr qtncs dfbnq cppzn hkxqsc sgnq zjgxg nsvfk jpvfc qtc (contains soy, sesame)
        mvfqbnlb qjgrv bbmpr fjk vxkmcmj krjn hdgfgj sjvrgx ndgfp ctnkv gxxg cvvjvf mjjgj vrjj xrrcj skkgc sgnq hkxqsc hjlcgk cxjkfz qtncs sp cnhch vfgg bpbdlmg dknlb fnqxjl lpznnc dfxmxd mxkh qqzjfk bbxmx qgqnjx gkcqxs nzcgntfs zfrlbz rgphsms zgng hkzrs fczmkt rgc scvzn nmfv kqctvs tjpsn hrbdk tdbcfb ngrnd bhp sxksnzf rsrxtc hdrkr mmpgm jpvfc (contains peanuts)
        mjjgj bzfv lxntzp xspm stnjg lgsk bbmpr jchrn qmvp mxkh xdjt rjt dknlb stnlkxj sxlj bn gkcqxs drsbbfrp ktrfs dtv htskk fhp tzvlm jjgvd bpbdlmg mtxxb rgc zxr mft jpvfc gxxg zfrlbz rxpddd kthm tdtzd vbb vxkmcmj bnsfss tdbcfb ldg fczmkt mgngg xvph mpm bvh ctnkv dgcq bbxmx kfsl pvtbbc hchdc sp qvzxxp hkzrs dpfvx mbjt (contains wheat, soy)
        cjbvz rxpddd qbbdfr bpbdlmg tprcc ckqnfq vfcs qtc krjn lbgntt nptr vdhtgm xbdsf qss fczmkt mjndggkb dknlb tk ngrnd nsvfk sp hsrjm sjzsc csmfzp fnbqnt jckpd cnhch sxksnzf qqzjfk jpvfc gkcqxs nzcgntfs dtdbzq drsbbfrp dqgl mxkh gptcng hrbdk gpgf qgqnjx vzzgts xbmj jdclr lnhqgk mgngg smpsr rgc mjjgj mmpgm skkgc tdbcfb smzhj bbxmx cvpt qkdgt tdtzd qrcmm cppzn kqctvs ldtr vnqh vfgg qrvft xrtx kkzqp dgcq sjvrgx cxjkfz zjzrbq fnqxjl lgsk jcmbbfm stnjg bnhmc sgnq bnsfss zfrlbz gnsxbz czvhncg (contains wheat, dairy, soy)
        rhrrrbr hbmv mtxxb hdrkr ndssl kfsl dgcq htskk mjjgj vmhf sjvrgx xnzqrm gptcng tzvlm jpvfc dpfvx xbdsf cnjmk jjgvd qkdgt xdkhj hkxqsc jckpd bvh rgdz dpcmr zgng hvgh dtv sp nptr tkqng cvvjvf cztkz cjbvz lgsk dtdbzq nsvfk grsx tdbcfb xbmj lxntzp vrjj bhp fnqxjl sxlj stnjg sjzsc mxkh cppzn hsrjm skkgc gkcqxs fnbqnt pnkpb krjn mjndggkb vbb sgn rgc nhhsgd vfgg dbdmmt ckqnfq ktrfs dknlb rhcj vdhtgm (contains wheat)
        pxz fhp pnkpb xdjt bbmpr tdtzd rgc jchrn sp qvzxxp mxkh rxpddd hdgfgj tdbcfb grsx bvh czvhncg fnbqnt xspm vfgg zbrfr cbmnb hjlcgk bpbdlmg jttxhczk jdmhd hfkvr vzzgts krjn lgsk ktrfs dpfvx mpm mmpgm clmg jvshst sxksnzf jdclr jcbcxtj hrbdk bgsdh dknlb (contains soy, peanuts)
        ldtr qbbdfr qtncs qmvp qrcmm skkgc rgc hkxqsc cpvn bn jjgvd hbmv krjn gpgf hskshtl kfpx tzqrlb fnqxjl rrvp tdbcfb fczmkt gkcqxs bklcz mjndggkb xrtx fnbqnt mmpgm mqxhh kntss ldg bpbdlmg mxkh xdjt tjpsn qrvft sp lkkt ktrfs mgngg hjlcgk xnzqrm tdtzd xppdk cppzn jpvfc vxkmcmj dpfvx ctnkv dxk (contains shellfish, fish, dairy)
        xrrcj xdjt kntss fjk vrjj hzvgn gljdv mbjt zbrfr qkdgt kbtxv bpbdlmg kzcpb vdhtgm hdgfgj xppdk dfxmxd mtxxb qbbdfr jvshst ngrnd hbmv xspm fnqxjl mpm hkxqsc cjbvz tzqrlb cbmnb mxkh kkzqp tk bzfv vnqh bvh ldg nsvfk kthm qvzxxp jchrn rtnjfqm dpfvx mckrjz hdrkr gpgf dfbnq kfpx ndgfp jckpd stnjg kqctvs rgdz vmhf gkcqxs tdbcfb rdnhkqz bnhmc sp bnsfss cvcr cpvn krjn rrvp gdtq hjlcgk zjgxg ldkmxjd hchdc cxjkfz (contains wheat, shellfish)
        rrvp ldkmxjd lcc hkzrs tk tghpf tdtzd cppzn vfcs mxkh hkxqsc xdkhj bhp kkzqp gljdv pxz drsbbfrp mjndggkb hdrkr jckpd xbmj kfsl hzvgn ssfvs sxlj xnzqrm nzcgntfs sgnq mjjgj jdmhd bpbdlmg pvtbbc mgngg rgc tkqng kzcpb vnqh krjn vbb qgqnjx kntss bzfv sjzsc rtnjfqm bnsfss bvh qss vdhtgm mqxhh zjzrbq dknlb vcx qjgrv mft vfhlb htskk nhhsgd qtncs vmhf gkcqxs gjck kfpx xdjt mmbqr xbdsf zgng qrvft md vrjj ctnkv cbmnb zjgxg qqzjfk lnhqgk ngrnd ldg sp kthm (contains peanuts)
        ngrnd vfcs smzhj qbbdfr krjn hsrjm mgngg mqxhh jjgvd mtxxb nsvfk sp scvzn mjndggkb bvh bpbdlmg cnhch xdjt hfkvr cztkz rsrxtc mpm ldtr hdgfgj sjvrgx xppdk lpznnc rgc mft rdnhkqz qtc zxr tdtzd bbxmx gkcqxs cxjkfz mmpgm jchrn rhcj gptcng lxntzp smpsr vmhf zjzrbq hchdc jvshst mvv bzfv xrtx kzcpb vnqh pxz kflk nzcgntfs mxkh (contains soy, shellfish, nuts)
        gptcng md hdgfgj mpm bpbdlmg lpznnc tk hchdc xrrcj tkqng tdbcfb rhcj kflk xdkhj dtdbzq zfrlbz ngrnd dfxmxd jpvfc mgngg xppdk xrtx gnsxbz csmfzp nptr qtncs vrjj bhp cztkz gpgf mjjgj bbxmx jchrn cnhch rdnhkqz vdhtgm gkcqxs lbgntt cpvn sxlj vmhf vzzgts sgn ndssl ndgfp qkdgt stnlkxj gxxg mxkh vcx qss mvv rgc smpsr sp cppzn kfpx fczmkt hvgh mckrjz sjzsc cxjkfz xbdsf bvh kbtxv cbmnb sjvrgx jdmhd jjgvd nsvfk mvfqbnlb jckpd dpcmr bbmpr dgcq (contains nuts)
    """.trimIndent())
    check(1829, result)
}
