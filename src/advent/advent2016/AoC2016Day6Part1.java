package advent.advent2016;

import java.util.*;

public class AoC2016Day6Part1 {

    public static void main(String[] args) {
        String result;

        result = test("eedadn\r\ndrvtee\r\neandsr\r\nraavrd\r\natevrs\r\ntsrnev\r\nsdttsa\r\nrasrtv\r\nnssdts\r\nntnada\r\nsvetve\r\ntesnvt\r\nvntsnd\r\nvrdear\r\ndvrsen\r\nenarar");
        assert result.equals("easter");
        System.out.println(result);

        result = test("jtfxgqec\r\nzxoeuddn\r\nanlfufma\r\ndxuuyxkg\r\nttnewhlw\r\nsjoyeiry\r\nrgfwwdhw\r\nqymxsllk\r\nforftdvy\r\nrzmnmewh\r\nhogawihi\r\nmtsyexba\r\nmrjzqqfk\r\nypmkexpg\r\npjuyopgv\r\nrtqquvaj\r\nevubmlrq\r\nbqlrtuce\r\nndidnbps\r\nvqukosam\r\nmzdyfkcd\r\nrrbwdimb\r\nuhnvxgly\r\naaimxpcv\r\nacxvinqj\r\nmuaeikzy\r\nlhzbosjd\r\nfflqqiit\r\nunfhzfrs\r\ngmwoyvob\r\ncculubmy\r\nzqbugcwa\r\nijouicwt\r\nbildjjww\r\nugksmnps\r\nivawibvu\r\nigzteede\r\nfoehssxo\r\npkeevvlt\r\nxumuixyw\r\nokhhtycj\r\nxhblffye\r\niqapgjqe\r\nlkhpntum\r\nwuzxgwow\r\nbkkpfguu\r\nbnqctsdi\r\ncwncjrwn\r\neivhabsi\r\nbwdicgfm\r\nkowiourk\r\ndhbzuztx\r\ngibitfxo\r\nwmrlhenb\r\nwfzmjvwh\r\nzddjirfg\r\nfafhmiwf\r\nddhvufhg\r\nqdwnlzqp\r\nnhsnngut\r\nuacmfgop\r\nmorcixux\r\nsfdxrgqy\r\ntezzvctv\r\ndnnmtkfp\r\ndygdzcib\r\nefurreri\r\nnpvpklix\r\nsvpbdgyw\r\nmcntltzd\r\ninwkhxlx\r\nsajfgeoi\r\nnwkqrspt\r\nqtzqsksv\r\nmtncajjk\r\netarsvxr\r\neyaeeauy\r\ngqnctylg\r\nuerywmma\r\nhjrxhtjb\r\nzdsdyfzp\r\nzhgrrhvd\r\nyvxqyalf\r\nrlgwftff\r\nxczvgpzq\r\nyydydclu\r\nrzltbrro\r\njforpzau\r\nzskadlfz\r\ndqbqdsgv\r\nbcwjltvc\r\nbyfoamgd\r\ncpefdmso\r\nocuetyke\r\nvlqrfnpp\r\nggikwydh\r\neakpyuov\r\nosaguhlz\r\nylmrfvee\r\nnvdvqpzm\r\npudbbuhh\r\nbwmqdpyv\r\nproscvgy\r\ncetkcpjw\r\nsbhcqeya\r\nfgnyltmf\r\nqcspgopp\r\nbdhnemmy\r\ntczkhihl\r\nyduxunvr\r\ndtxerncl\r\nxnxeaayt\r\nrvlcbgts\r\nvpavzjqs\r\noueloufw\r\nmubbhyna\r\nnptmeppg\r\nojjfbuzz\r\nlusboycs\r\ngurmmorr\r\nkefddaka\r\ncpvpszit\r\nbfvthzpm\r\nowgcvdjo\r\nsimxphmv\r\nrxedvjyw\r\nhmeieuxr\r\nvgqhcapz\r\nvwtvbain\r\naobnhdsx\r\nhkpshsjs\r\njxgegczu\r\nxbsfxesk\r\npqhifeaj\r\ntriurorr\r\nrnkufaxl\r\nhmrqfoaw\r\nveghzoxa\r\nzbvgbpcm\r\nrqrnbylj\r\ntxaawlta\r\nuuksnfel\r\njqvycrvw\r\ncdttmdpc\r\nwojvbrzp\r\nqvnuinon\r\ngnpguyvh\r\ncgbkpzbu\r\npdaqhlan\r\nmuiykslt\r\nprvzlunm\r\nwhhcrchz\r\ncahjhrkl\r\nzifdgfpq\r\nwanlienf\r\nsfrnozvi\r\nmwmykvyh\r\nfbdfzgut\r\nwfrviilb\r\nucaopfgo\r\nfjhuikma\r\nhdmizjdj\r\nxngpfwvn\r\nrueojtjg\r\nxvtssxtx\r\nvvcgzidf\r\nxtehcxki\r\nxksbfbso\r\nosnzpqmy\r\nisrnjkxh\r\nutleakmz\r\ndthmtbdt\r\nplregxuh\r\namoeprsy\r\ntmyhzhqd\r\ncsxqavbe\r\njmojlysw\r\nslebxnbl\r\nldzryqmj\r\najejyudk\r\nynhgnjhw\r\nmdibxxxw\r\nrvtcmesd\r\njmnwqddq\r\nhppfoplc\r\nnrcbjynz\r\nkcqnjzue\r\nmthvgjxm\r\nykztdbcv\r\netqqnhuz\r\ntezkopgq\r\nfwhwkqmz\r\nfozpkzfy\r\nhbbtlcog\r\nhdvjqwyh\r\nxuljsrvz\r\nabskreoo\r\naedeydgc\r\ndcyigvqf\r\nntpcvvgk\r\niiwgzkhl\r\nzofhlqlx\r\nveumtlae\r\nqibdapwq\r\nxpgpwirt\r\nwvnnautq\r\nwfhlgmdg\r\nyqcrvdgx\r\nsrdufrbu\r\nvycrvkpx\r\nflwxzkim\r\nenxayqxm\r\ndgpntiaj\r\nqedfutmp\r\nvfdovine\r\ndgrvjfjt\r\ndqxxjahk\r\nhnxpblyp\r\nnnadwbsc\r\nkrmqqgwf\r\nefykkzeb\r\nlkrmrwqw\r\nvfzayrwt\r\nchopbnyf\r\nvbydrtln\r\nazmlestl\r\nsqcyddvi\r\nzdcubjok\r\nafshwptc\r\nsjgpuoch\r\nbnfylydl\r\nrsyxsbzi\r\npsyuvyzx\r\nnpngqypd\r\nxejayhdk\r\naqfmvjfi\r\ntpffksph\r\nuekwkjnj\r\nljsjimwm\r\nhbgzjlig\r\nngssshxx\r\nicitlosb\r\nunxryqyt\r\nnzpujfti\r\nlupxnzhe\r\nkxglfnic\r\necewosbs\r\nhtlqxpiq\r\nclqgnyfd\r\nyyiozvar\r\nmbvjgmyc\r\nsrhwhlin\r\ncasmlryr\r\nebuzskkp\r\niewhdqtr\r\noyidcobe\r\navptvltf\r\nmfheqaxl\r\nshqnezrq\r\nxrpkzuvb\r\nsoxdjwba\r\naitmzlds\r\nrpmpozpd\r\nccgxauky\r\ngsstsjyx\r\nbzeolqal\r\nvfhddmuc\r\nwfbbmqfv\r\npumxmnhj\r\nqumdxkns\r\nxymraott\r\nuthlccig\r\nezpalags\r\ngiftxymr\r\nujjacleo\r\ncgwgmktp\r\nistetgdl\r\nazedmaao\r\nbnlfwyoq\r\norcwhbek\r\namswhkum\r\nyxupesxu\r\nmlzvqsrg\r\nsolkxzby\r\ntbaxnjdu\r\nxwbsiquk\r\nhsftntsn\r\najraaorz\r\nmwmycrff\r\nymnbrbpj\r\nuyfscatq\r\nkzkgmbeh\r\nlibgpgnr\r\nkxlgthxc\r\nvzjbobyx\r\nisqessab\r\nehursvof\r\nguwrjnbi\r\nxivkphwn\r\nrurrmdmi\r\nnqijeuzq\r\njambocej\r\nqrtidktb\r\nsbzvehmq\r\naikgzrsq\r\nlgydnujf\r\ntwafyzry\r\nnxhtklba\r\nxhyaqyqe\r\nxgvdfcrf\r\nwdieppsd\r\niabrfmdm\r\ndoijaavc\r\noxydttkg\r\nqsqiofwv\r\ntitrvjym\r\nmwojqcku\r\ntewiyhjx\r\njlqbksqd\r\nknycvoks\r\ntmcbnvhv\r\nekksoxmz\r\nmgvommal\r\nhrosnzeu\r\nfzeymbek\r\nevqxcukn\r\nilkpvdvl\r\nrclpjbkb\r\ntdpitlei\r\nzvvzuucc\r\npzdgwnfz\r\nmralxxlz\r\nwywkawzh\r\nhmazaakd\r\nllltvbex\r\nihsmefpz\r\nrzzgkjyz\r\nsrjqpeoq\r\njrczcdna\r\nuuyskwop\r\nyeuiaepa\r\nvzppcwnn\r\noqhxixdo\r\nxkwpfsij\r\ncmsoiogl\r\nngbmaeue\r\nlmqttyrj\r\nyhgjxfmx\r\nlwfgjnyp\r\nibbkjgra\r\ngaxsotzr\r\npaugisvs\r\npcqqauqi\r\npweuwnqs\r\njcbrscrj\r\novtsgcnh\r\noscsgtqn\r\nhkpwmhwk\r\npmdgwclk\r\nowmskdhh\r\nqutyussr\r\natdkvmzl\r\noqslriwe\r\nwafjwfxp\r\nipcqlsxv\r\nkzurbnoh\r\nlfhfzwqo\r\nucybqwrj\r\ntgnblzgm\r\nlhwlniea\r\ntlxymfbu\r\nbcyvlkvt\r\nglpacpjk\r\nrjagzpnu\r\nfyjpvhaq\r\ncjtzwtdu\r\ndkaqawts\r\npjoovtlv\r\nxsnwqixw\r\nswcftfed\r\ncadigksp\r\nfnsmxccx\r\ncbxmdxvb\r\nhpyqnpjq\r\njzpvphmo\r\nkdkpubul\r\nkiajwwta\r\nuyeuctbe\r\nyetyzqxw\r\nfgeemnbl\r\nbrprbvgj\r\nxszwwlea\r\nygunyguo\r\njwplrcbq\r\nfejndxnx\r\noxsmkcqm\r\nldwkbpsk\r\ncmzuxrst\r\njaoadiiu\r\noxcpkgbc\r\nnyulhuci\r\nbdwfqtkv\r\nehxvnzyd\r\ncizuemsb\r\nlbqyqduk\r\nkqweswcd\r\ntqnicuzh\r\nutyaiaeu\r\nosjdgvtj\r\nqmrxcaoa\r\nqiltxgvv\r\nqklfgyss\r\nlpjebmuo\r\nbvebkous\r\nyifrmeoa\r\njzgntlep\r\nwadcknde\r\nkaikclag\r\ntucuhehr\r\nbvwhuwzn\r\nuvlecxgy\r\nrzyxjhmo\r\ndyyfwjgv\r\nvocjkohi\r\nylyflktq\r\nraltxpqg\r\neitypruw\r\npfbmopgm\r\nqerushjt\r\nxykophcv\r\namjhrlhi\r\nuqkjhdhn\r\nkkohprfw\r\nhvsmtnfd\r\nuxgiqmqc\r\nnpxwplcj\r\nltchgces\r\nexiyyief\r\nysmvbqso\r\nzpyvuhqz\r\nlkvwronk\r\nvxilskkl\r\ncxfypwcd\r\njhrczkmf\r\nrdedtejq\r\ngmxcrlzi\r\njumwfmnn\r\ngkynzdtd\r\ndfdkxggc\r\nyldclxhz\r\nfsxvbwyj\r\nioiupzio\r\nlxyqvncv\r\nrsgsviny\r\nosgcimej\r\ntecqrgkq\r\ntozohtwt\r\nkmlowfrf\r\nhhpiukqe\r\nxlxlkjwf\r\nntvtoexx\r\nzzvsvdow\r\nyluidajg\r\nvumkynvp\r\nvaxipwwg\r\npqymmoif\r\nsgjzogut\r\njppwszzn\r\ngvvaibqu\r\nlwjotuil\r\nsrflotab\r\nibnblmjm\r\nkvcsdivb\r\nwqrpzmvr\r\ngcmqdezs\r\nvrizdyfo\r\nvtqnsjbf\r\njwocjmvb\r\nfjkiiowl\r\nctjhmmrq\r\npcckqfki\r\nwqolxgfg\r\ngbsdyrbc\r\ngiqmfqwb\r\nfodfpvyl\r\nnxdzwvzz\r\nhpnatltw\r\nadjjyhjd\r\naoguhvmv\r\nyyeanoir\r\nbaojaygs\r\novkebbjb\r\npmykvfex\r\nzeooykoa\r\nuuozuxjb\r\nkxxvbhbr\r\njxbchjlr\r\nqhiwdonk\r\ndnvfwwfh\r\nkjfrlslh\r\nwionbrdf\r\nqgkjarob\r\nkwplsxso\r\ntxgelygh\r\nvlmziqwf\r\nwbetqqkp\r\nqfkocear\r\nwrvonhyr\r\nsbiqrcri\r\nlnwzitce\r\nbctyrwph\r\nkallfwzc\r\nzfqwanet\r\nbevnljjr\r\nkwqsktan\r\ngjviqwlu\r\nzflsnpig\r\nwzaufqvr\r\nuvxhutav\r\ndiejbica\r\nojciaexn\r\nzyjoxrwi\r\ndjkodeiz\r\ngsinkcqk\r\njkonssuq\r\neychyabp\r\nfkcogwnr\r\nkkioyrnn\r\ninqxlztu\r\ncqnbxxks\r\nipwmpdmm\r\nmoozfajm\r\nirjaimrw\r\nojihmanb\r\nhzoszxzc\r\najjvxqqi\r\nohkfkijd\r\nnlsahrpv\r\nzizxtmxa\r\ngjtnrurd\r\npyqghfuj\r\nfltnnyfe\r\ngoxagvfp\r\nnplhpkiy\r\ndlwgyvby\r\nfzrfhcgh\r\nzaiuostp\r\njdjojfkw\r\nthksqbjh\r\nqopcwnht\r\newkljwho\r\nqguaeaac\r\nwxzzxgcc\r\nnlnuuhdu\r\nihtzrqay\r\nnmtdbkhp\r\nyasxhulm\r\ndrzjobfy\r\nqpgcjdxn\r\naegbxmjb\r\nbbuxsffr\r\nzevjcgzn\r\npgbqezxk\r\nqdlepjko\r\nzbtzvicm\r\nssjdcggg\r\nugrtxalo\r\ntsbvnppt\r\nrboleppu\r\ngywfqiwz\r\nskgzeqhu\r\nhzuggbcf\r\ndkegaxap\r\nzijcjrkm\r\njtfkeoog\r\nfyvtrvig\r\ngophbeoj\r\nieatnihe\r\nvlaauxgz\r\nmxnheqkz\r\nmftwybny\r\nebawojuj\r\ndyrvecbs\r\nlrrcwang\r\nqswijdeu\r\nwkuszdax\r\necaokzfc\r\npmbznspx\r\ntjqrztdv\r\nmwdxruge\r\nwhutfdqy\r\nzpfwqvox\r\nfkqapoid\r\nbodleqbn\r\nkpxiuodk\r\njohmsncc\r\nenhamlol\r\nyhtydoss");
        assert result.equals("tsreykjj");
        System.out.println(result);
    }

    private static String test(String s) {
        List<Map<String, Integer>> list = new ArrayList<>();

        String[] strings = s.split("\r\n");
        for (String string : strings) {
            while (list.size() < string.length()) {
                list.add(new HashMap<>());
            }
            for (int j = 0; j < string.length(); ++j) {
                String key = String.valueOf(string.charAt(j));
                Map<String, Integer> map = list.get(j);
                if (map.containsKey(key)) {
                    int count = map.get(key).intValue();
                    map.put(key, count + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map<String, Integer> map : list) {
            List<Map.Entry<String, Integer>> sorted = new LinkedList<>(
                    map.entrySet());
            Collections.sort(sorted,
                    new Comparator<Map.Entry<String, Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> o1,
                                           Map.Entry<String, Integer> o2) {
                            return -Integer.compare(o1.getValue().intValue(),
                                    o2.getValue());
                        }
                    });
            result.append(sorted.get(0).getKey());
        }

        return result.toString();
    }
}