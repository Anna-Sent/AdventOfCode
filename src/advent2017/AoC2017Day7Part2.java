package advent2017;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2017Day7Part2 {
    public static void main(String[] args) {
        int result;

        result = test("pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj, cntj, xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)", "tknk");
        System.out.println(result);
        // 60

        result = test("xsddbi (61)\n" +
                "nqtowev (11)\n" +
                "xwohr (82)\n" +
                "flejt (36)\n" +
                "idwpug (54)\n" +
                "uoxzkp (51)\n" +
                "choeijs (54)\n" +
                "gmsjkn (65)\n" +
                "txszqu (687) -> mvjqmad, lwqlyjq, jlgnsu\n" +
                "zhlfdac (15)\n" +
                "htouwcr (74)\n" +
                "vlbsr (56)\n" +
                "titbn (9)\n" +
                "bvrpb (86)\n" +
                "wuwjp (54)\n" +
                "umnqkb (160) -> nbrvl, bcmbao, vfimqtl\n" +
                "uwnml (29)\n" +
                "cdvhmy (42)\n" +
                "xghhu (306) -> molth, atqewc\n" +
                "vcvayah (71)\n" +
                "fujwb (187) -> tyjyc, xyemll\n" +
                "zqnjd (91) -> jxsmuey, uelnii, vcwezm, uxnwtp\n" +
                "wphtnvm (72)\n" +
                "xgihtsx (15)\n" +
                "fwvvidu (80)\n" +
                "lonwb (1656) -> rydrp, mgyixhn, cjhtxo\n" +
                "qyasuw (41)\n" +
                "vbvug (6)\n" +
                "mkrjamh (154) -> ecbog, owaebx\n" +
                "ghvpg (98)\n" +
                "eazvkxv (66)\n" +
                "jguufio (61)\n" +
                "udpcyt (71)\n" +
                "xerbuu (38)\n" +
                "sxzpils (70)\n" +
                "looigzn (10)\n" +
                "znmumx (77)\n" +
                "uxzwwe (67)\n" +
                "wuegrv (99)\n" +
                "owttcz (91)\n" +
                "vkhazkn (37) -> oactn, ftxif, rxlbou, bkfav\n" +
                "rddnfg (10) -> mvgmbru, zlazoqs\n" +
                "zzsqfm (99)\n" +
                "fhjzpjw (19)\n" +
                "zwxwfin (50)\n" +
                "ocdzc (26)\n" +
                "cohps (52)\n" +
                "dxhrpq (46)\n" +
                "yeheld (55)\n" +
                "ekxczvo (81)\n" +
                "pxlzcx (589) -> vjvit, cnblx, bwiqe, pjsbxvk, ipqjxa, zkikz\n" +
                "offkzc (95) -> wymlvix, felrwte, bzublv\n" +
                "bavyg (22) -> szszezd, lurhq, ltncvl, fmwvok, frikrv, tumwln, xjtujzp\n" +
                "awjwff (18)\n" +
                "sjhwgq (8316) -> ydqgvnf, oztasey, qkmkwgl\n" +
                "vmyrdkl (53)\n" +
                "mzrwaa (48)\n" +
                "njqemt (30)\n" +
                "objssr (91) -> xujmi, oqihtt\n" +
                "bcpbvya (75)\n" +
                "fqayb (69)\n" +
                "vwksn (19) -> zwxxii, owttcz\n" +
                "czmzol (145) -> qzayss, ufrrrzi\n" +
                "inija (25)\n" +
                "eppufdw (555) -> brwsjee, laoouso, jgfcyze\n" +
                "mmtzk (39) -> utispep, onkhx\n" +
                "zoofu (129) -> cyczt, qargs\n" +
                "msryw (260)\n" +
                "etvpko (18)\n" +
                "wxudgdd (84)\n" +
                "ymkax (45) -> znmumx, hnjuqgw\n" +
                "uxbjym (87)\n" +
                "msskm (69)\n" +
                "nmtia (75)\n" +
                "jawbtmo (46)\n" +
                "bpelccj (187) -> ctzhawr, qhldpg\n" +
                "dbexmj (365) -> bijprk, iotkxfd\n" +
                "bxcdldt (16)\n" +
                "fhdqcbx (25) -> gefut, mulybo\n" +
                "iunkpe (15)\n" +
                "yzvqo (80)\n" +
                "fbgguv (57) -> bkomu, tynxlau, sfruur, zxvbb, khupkt, xkntkvz\n" +
                "yaripcu (8)\n" +
                "acfmyv (79)\n" +
                "sohuv (18)\n" +
                "aahhxau (233) -> rbauxvx, neliq\n" +
                "yuhmnjs (98)\n" +
                "xpzpv (206) -> mxtxm, kgzyk, yzpaxlz, vfxqcbq, lcgtwj\n" +
                "ovhhkoc (52)\n" +
                "stwubkv (70) -> uzzeydh, zknpmnc\n" +
                "otbxl (54)\n" +
                "bfroq (39)\n" +
                "nkbmoin (341) -> vgqmfj, weygson, knbems, gdmlk, ecfrqpl, tbaai, sfohocq\n" +
                "twazofk (258) -> dntwqr, vugavk\n" +
                "venvbai (32)\n" +
                "pcqpqjk (38)\n" +
                "apqby (37) -> xkzlyvh, vlsjsgg\n" +
                "tgsicj (59)\n" +
                "rsvixyg (32)\n" +
                "whjcp (245)\n" +
                "rmnkgss (22)\n" +
                "zbmwego (55)\n" +
                "lptmne (17) -> fkjlcz, jinwsas, qnevjto, wfjks\n" +
                "rtyegs (76) -> nhbbd, yqqun\n" +
                "cavlg (1148) -> lsaroxx, evkau, gldgrng\n" +
                "kqswas (504) -> ntcddy, bwqmns, vtvsd, oxoqy\n" +
                "tmvfp (46)\n" +
                "dlhyzjw (79)\n" +
                "xsfwcgq (657) -> inknun, seihhya, qrlhp, bchtcht, rswqvx\n" +
                "ekleund (68)\n" +
                "rihlj (72)\n" +
                "oldrtya (66)\n" +
                "yiqnfd (62)\n" +
                "sgpiiir (14)\n" +
                "vbojbp (66)\n" +
                "qnscqms (197) -> mernsee, ubjuhxp, mlfxnna\n" +
                "vfxzkq (660) -> ukrqfm, pnsvthy, qdcos\n" +
                "kkeuh (273) -> urfhlf, hjtkb\n" +
                "sakhif (30)\n" +
                "yrdhq (71)\n" +
                "ckcjr (50) -> owgsk, vdnphf\n" +
                "ndvdj (10)\n" +
                "zzcqptv (87)\n" +
                "aemyrqj (23)\n" +
                "vbauj (49)\n" +
                "rcumpgx (18)\n" +
                "ijyhvsj (25)\n" +
                "gazaoty (83)\n" +
                "lugwl (228)\n" +
                "msrrlv (90)\n" +
                "enxbya (19)\n" +
                "wlyzbz (99)\n" +
                "gmrqpdk (40)\n" +
                "gefut (75)\n" +
                "bafnaij (57)\n" +
                "jgfcyze (166) -> ziqyhi, wrwgm, hdikur, bmqhrtg\n" +
                "rcmyfr (281)\n" +
                "pohdy (87) -> frcqooy, idhvksi\n" +
                "wkfjzs (81)\n" +
                "dcgphc (16)\n" +
                "bgqvm (38)\n" +
                "ltgnnr (87)\n" +
                "xjtujzp (1565) -> soryrk, zkvopb, xufneyr\n" +
                "idhvksi (69)\n" +
                "yjnrjde (65)\n" +
                "lfykdub (61)\n" +
                "dnjydir (41)\n" +
                "ifgfg (197) -> jcbgta, aemyrqj\n" +
                "grlofut (23)\n" +
                "tjaqrw (96)\n" +
                "gjgcvyp (85)\n" +
                "kwavcf (254) -> vmpmig, djeee\n" +
                "mdnqs (101) -> tpmhs, essvr\n" +
                "gqlyhql (159) -> uwrhuw, ypanow\n" +
                "vjzfc (25)\n" +
                "guauivo (42) -> puvhc, bjcsjrr, ccjtpv, ibwve, evbvdgl, stwubkv, kwxpnrs\n" +
                "pbohgz (74) -> sbfiv, igbhyk, rhxcyd\n" +
                "bkomu (42437) -> krbpgmk, ekgbf, yqlxeb, ogyiesm, poypmax\n" +
                "yjoyyvl (55) -> sjioze, nigkvxl, itjxq\n" +
                "efobdsd (218) -> yqnso, glqspl\n" +
                "zxvbb (56366) -> fvkxwt, xlanm, gxitq\n" +
                "cvrga (47) -> vagjk, ghvpg\n" +
                "mwrnosj (52)\n" +
                "dxffr (15)\n" +
                "dcsxekv (41)\n" +
                "kbmse (68)\n" +
                "tqyldbt (59)\n" +
                "nvtyg (31)\n" +
                "jnzqvia (67) -> divak, cmgvs\n" +
                "rhxcyd (44)\n" +
                "hnjuqgw (77)\n" +
                "vdnphf (89)\n" +
                "qqnywdg (160) -> lrjnzf, luhxcq, whgpim\n" +
                "sfizdf (1053) -> aahhxau, shiiodm, cvnfak, whjcp\n" +
                "zdawjkr (34)\n" +
                "tracdgp (27)\n" +
                "tcvgl (305) -> ljfvbjd, bafnaij\n" +
                "iuwwa (42)\n" +
                "iekwfia (52)\n" +
                "odoxr (72)\n" +
                "uravet (102) -> hzzxjxa, mvdzfo\n" +
                "jvnuwap (66)\n" +
                "kjdjdr (76) -> kpdmptf, hsqhwef\n" +
                "vycgaoz (82) -> jqulm, ziwlgdb\n" +
                "ifdkle (202)\n" +
                "gtpyffj (812) -> kcpwmyz, emkzxk, hwuabde, efgqua\n" +
                "oxoqy (17) -> lktbqq, zukio, bcpbvya\n" +
                "kfngejn (49)\n" +
                "anhjp (75)\n" +
                "xwwzp (14358) -> lonfrp, eppufdw, nmxqs\n" +
                "wcpyi (205)\n" +
                "wzxqipp (88)\n" +
                "ekgbf (6702) -> bckbud, fzzlnwi, cvprip\n" +
                "ziwlgdb (63)\n" +
                "bxqjg (70)\n" +
                "bverp (49)\n" +
                "rlgbvvj (13)\n" +
                "sqvxf (37)\n" +
                "ltncvl (977) -> sktewq, hydeeqe, ibdjxl\n" +
                "fxqng (90)\n" +
                "jcdmhvd (157) -> twgrfm, dxhrpq\n" +
                "kpgatn (41)\n" +
                "znpvlac (97) -> vmyrdkl, aideelj\n" +
                "vifbi (634) -> rkwkwd, onqax, cfrcco, onamlmy, zoofu, vwosnfn\n" +
                "gezqw (12)\n" +
                "hagrq (97) -> fhecgzf, mefajk, uyrxc, gdclwzu\n" +
                "gdclwzu (60)\n" +
                "sczyp (19)\n" +
                "cvlkltp (151) -> guiej, vffqp\n" +
                "fimqsn (125) -> ehvxt, xyoiv, mikast\n" +
                "lktbqq (75)\n" +
                "tyjyc (55)\n" +
                "xoqvvx (18) -> xawfk, ojrjqv\n" +
                "bcmbao (89)\n" +
                "qntpdh (93)\n" +
                "iieico (12)\n" +
                "modms (37)\n" +
                "xwwfi (82) -> cpjkea, hsexbak, dxaemlq, wlyzbz\n" +
                "xxoil (23)\n" +
                "uelnii (82)\n" +
                "shiiodm (53) -> hclea, nrduy\n" +
                "hqwkq (42)\n" +
                "twgrfm (46)\n" +
                "yrozpm (246) -> btukw, fbyju\n" +
                "onqax (301) -> vtlvs, ccnpjdf\n" +
                "klhfca (81)\n" +
                "lvcsn (95)\n" +
                "jpcseag (92)\n" +
                "tgwgno (202) -> yyyub, ofcyw\n" +
                "ztjquwi (545) -> ptawnqq, ziprwty, yzfzbw, hpqux, baaqr, bwugxhi\n" +
                "ealyedu (71)\n" +
                "debir (48)\n" +
                "ppossv (51)\n" +
                "kzxyyd (62)\n" +
                "bchtcht (185) -> rsvixyg, cppdkv\n" +
                "ndeop (9)\n" +
                "htujh (695) -> nzhnurq, btbnj, ghsxqq\n" +
                "lkwogh (53)\n" +
                "ofyuao (159) -> llhiw, nbjpcc\n" +
                "vxlypal (9)\n" +
                "dvipr (67) -> udnmqte, osnjzpt, swujbg\n" +
                "ybnehoi (50) -> hatmr, alkizae\n" +
                "xkntkvz (44502) -> lwugjj, cstmu, rsjffj, pxlzcx, jtmuv\n" +
                "fhvyhk (252) -> boqgjn, rzzezfx\n" +
                "krmbsc (47)\n" +
                "jkymeqw (26)\n" +
                "xjypx (70)\n" +
                "jytapdu (15) -> vqvwkm, jpcseag, kgkpfg\n" +
                "btrepl (15)\n" +
                "umnkslz (13)\n" +
                "lxbsif (72)\n" +
                "adunt (71)\n" +
                "cupeghk (67)\n" +
                "xcckt (7)\n" +
                "mutwmaa (39)\n" +
                "qmpncds (39)\n" +
                "ypanow (88)\n" +
                "zhhhntj (51)\n" +
                "tcqnso (85)\n" +
                "uakcbox (68)\n" +
                "sckgsn (38)\n" +
                "bgpjb (136) -> aqaems, jkymeqw\n" +
                "gxitq (83) -> wshlljj, krpda, aasxby, ywhjz, stnnf, nfkmi\n" +
                "ulehitr (187) -> knrtys, mnfep\n" +
                "galojia (25)\n" +
                "pjxauhw (61)\n" +
                "wvhvw (229) -> xcckt, duzgl\n" +
                "cpjkea (99)\n" +
                "jqulm (63)\n" +
                "gpqhjv (20) -> wzxqipp, ykxnd, dhsopiv\n" +
                "ipqjxa (51) -> gsmcgor, inlcow, hdmcpq, xhmornc, lisfhnn\n" +
                "ofwtjhw (38)\n" +
                "pkceuqw (62) -> isqxwp, evkrnfo, pcqpqjk\n" +
                "hmnvh (97)\n" +
                "cxcah (75)\n" +
                "fkjof (90)\n" +
                "iinxvw (14)\n" +
                "ckypedd (61)\n" +
                "vxwobup (543) -> sejkvk, olrdlw, hfxsib\n" +
                "hpqux (196) -> ocdzc, xlvjz\n" +
                "gyuyu (173) -> xfurlrr, etlce\n" +
                "rffwau (96)\n" +
                "bfulyh (154) -> tjuqz, tzqdwe, ayeqoz\n" +
                "llhiw (88)\n" +
                "vmsmdqx (72)\n" +
                "aasxby (832) -> lvcdsgp, dhejgd, nzvpgv\n" +
                "qlkjhsi (25)\n" +
                "chhhge (34)\n" +
                "rveuz (18)\n" +
                "cmbnwse (112) -> jphmpr, tlkhxww\n" +
                "ppqdnd (175)\n" +
                "szvty (18)\n" +
                "crbcsqt (382) -> oakbrw, dswjpxm\n" +
                "xqxgd (76)\n" +
                "dxddn (12)\n" +
                "usitmiz (81)\n" +
                "vqrtnp (44)\n" +
                "axkhzf (94)\n" +
                "tzszs (299) -> jieijuo, ndeop\n" +
                "frjtwx (94)\n" +
                "tzqdwe (32)\n" +
                "sjioze (46)\n" +
                "yzpaxlz (216) -> heqbpd, dphmg\n" +
                "lewbxa (43)\n" +
                "knbems (173) -> looigzn, qdkrr\n" +
                "bwqmns (210) -> dcgphc, wwzli\n" +
                "vtwdqkd (61) -> vcvayah, wyhnmbs\n" +
                "owgsk (89)\n" +
                "dpfvy (54)\n" +
                "qongfb (48)\n" +
                "qilhudr (125) -> qbcar, wuwjp, umxurvd\n" +
                "aahqtsf (1755) -> hfhswyd, znpvlac, bruqu\n" +
                "dxaemlq (99)\n" +
                "gybikf (185) -> uwnml, noqjuo\n" +
                "vjvit (194) -> jdhewio, wwhlo, crbcsqt\n" +
                "zkikz (194) -> ttqpi, ifdkle, qdyzunw, wkcrce, jcezw, qeiijk\n" +
                "wphgd (7)\n" +
                "nmxqs (180) -> sftqzaf, gyuyu, tkvmtol, vwksn, doppnr\n" +
                "bpgdb (190) -> jxpixqi, kygcziz\n" +
                "tmigcw (151) -> gmsjkn, njmlk\n" +
                "lodcj (54)\n" +
                "loxjzpo (59)\n" +
                "fxfznc (32)\n" +
                "hwuabde (207) -> mvamo, bverp\n" +
                "ixroc (98)\n" +
                "wdzhfmw (126) -> galojia, ibyrsdo\n" +
                "bznst (20)\n" +
                "dkoike (123) -> wuckr, mfbnys, gmrqpdk\n" +
                "atyaqz (112) -> asmysiq, paoitb, okpdcz\n" +
                "bsfsayz (13)\n" +
                "ffhxi (15)\n" +
                "rgkrl (85)\n" +
                "fhecgzf (60)\n" +
                "lwugjj (361) -> hykxm, hechfb, edtkfvv, lonwb\n" +
                "qtraszq (13)\n" +
                "qargs (95)\n" +
                "adwir (18)\n" +
                "bnmshvm (145) -> vfmlyg, ychjmik\n" +
                "isqxwp (38)\n" +
                "yblsbf (83)\n" +
                "azzysl (36) -> anhjp, ixnlvyo, mmndzs, alaug\n" +
                "ysdqkw (87)\n" +
                "olevfy (158) -> wuipwl, etvpko, bavaf\n" +
                "tvcxl (25) -> vlmzodk, vbojbp, oldrtya\n" +
                "fhyvz (40)\n" +
                "hzfwtzf (75)\n" +
                "gdmlk (5) -> bgavnd, iqpcu\n" +
                "utojr (82) -> nuytv, frjtwx, guurpo\n" +
                "kcpwmyz (97) -> oykqvif, ukrjos, mwrnosj, bdjlzf\n" +
                "qvndh (115) -> fyeuhqh, kmbrqv, kgqgct, qtraszq\n" +
                "fvjcbib (98)\n" +
                "ziiijv (85)\n" +
                "lbnenyf (75) -> tdhxy, ozlqcn\n" +
                "nbwkld (54)\n" +
                "blpjnzf (123) -> gapzarg, syxkp\n" +
                "jhruwih (84)\n" +
                "ecbog (27)\n" +
                "ccqldu (46)\n" +
                "izyxppl (58)\n" +
                "lfwru (177) -> smiucuf, libtrl\n" +
                "cvnfak (123) -> lfykdub, yxqaa\n" +
                "jwjrj (89)\n" +
                "ytbyct (73) -> yaehsu, cxcah\n" +
                "oqihtt (68)\n" +
                "mvjqmad (359) -> swaxyxe, perbvgz\n" +
                "vahnoue (42)\n" +
                "egrimlf (42)\n" +
                "uewchd (1998) -> oqqme, vaeeqvi\n" +
                "hbtur (295) -> mgqkhic, jkvgvz\n" +
                "qekpce (78)\n" +
                "anehvd (75) -> frezf, wvdoa\n" +
                "laeaf (38)\n" +
                "hipfszh (149) -> dxavaum, qkapxbc, adwir\n" +
                "parvx (15)\n" +
                "ayeqoz (32)\n" +
                "weunegg (85)\n" +
                "cbbtbz (85)\n" +
                "fkjwn (67)\n" +
                "takxgz (49)\n" +
                "heqbpd (6)\n" +
                "yxpnzkn (212) -> dxavw, nxpozme, wdjcb\n" +
                "vkwsodp (38)\n" +
                "asmysiq (51)\n" +
                "ilvblzm (85)\n" +
                "laohhtn (86)\n" +
                "onoyb (86)\n" +
                "sfwaimh (24)\n" +
                "grtrt (96)\n" +
                "oekhu (40)\n" +
                "jxqzmuv (7)\n" +
                "vtlvs (9)\n" +
                "jjdmu (84)\n" +
                "qzobjfo (158) -> vetsll, utsfqn, dcsxekv\n" +
                "uwrfay (60)\n" +
                "guurpo (94)\n" +
                "kpnxkyy (32)\n" +
                "aqugisv (965) -> rddnfg, qozmho, pbohgz, lupyc\n" +
                "dswjpxm (11)\n" +
                "smiucuf (53)\n" +
                "mfamq (74)\n" +
                "agfnncm (95)\n" +
                "qshoazt (1737) -> ockzlpp, yeheld, judfhye\n" +
                "wngzh (9094) -> guauivo, aiwvi, vxruziw, ikqijv\n" +
                "hawmd (40)\n" +
                "kxkwxoj (32) -> pyvwl, akdffhk\n" +
                "qdpoyl (4734) -> aahqtsf, lnontej, lfiteup, oaopxo\n" +
                "ftkflbo (27)\n" +
                "ukrjos (52)\n" +
                "fdzqz (70)\n" +
                "dvncmy (1046) -> hzfwtzf, nmtia, ygiyze, zuquy\n" +
                "gsfnr (96)\n" +
                "cprbzvp (28)\n" +
                "tyywgp (57)\n" +
                "gsmocx (118) -> krmbsc, ywmif\n" +
                "laoouso (122) -> xvdkt, eogzpga\n" +
                "yzfzbw (178) -> vjevs, paqihg\n" +
                "cxhuwiw (46)\n" +
                "vfimqtl (89)\n" +
                "dkcqdx (132) -> wemjk, kyuneoo\n" +
                "dszip (73) -> vzbpn, xqxgd\n" +
                "chljtta (157) -> dpfvy, nbwkld\n" +
                "zzcagx (165) -> wuvmf, nrvsqf\n" +
                "xfglmz (740) -> nrlhen, rfkcylj, ymkax\n" +
                "pnsvthy (103) -> cadasac, rpxmv, azkmt\n" +
                "xokmont (84)\n" +
                "divak (77)\n" +
                "lonfrp (60) -> pohdy, bnmshvm, oheank, qwlze, dszip\n" +
                "yngqiv (236) -> cayigxg, ixomyeb\n" +
                "lfiteup (1188) -> qnsqwm, qdpnnex, cmbnwse, onaatvy\n" +
                "mefajk (60)\n" +
                "eqbwx (23)\n" +
                "zuoczei (64) -> ismrc, dbexmj, oeqqj\n" +
                "kygcziz (14)\n" +
                "nwxyrtn (87) -> kpgatn, egcjfjo\n" +
                "loljfo (10)\n" +
                "bruqu (17) -> uwylbft, qntpdh\n" +
                "wohvpbn (67)\n" +
                "qgvqg (315) -> iekwfia, qhrxvzj\n" +
                "wwhlo (36) -> hcyjfzz, dbuqsj, latmzh, geztlsi\n" +
                "oheank (225)\n" +
                "ujpgmwm (50)\n" +
                "ndgzf (37)\n" +
                "rgzrnnl (52)\n" +
                "vgjgz (24)\n" +
                "fvwll (147) -> axkhzf, mqpbpgq\n" +
                "iqtemv (69)\n" +
                "yfrmup (6)\n" +
                "rzzezfx (56)\n" +
                "qkpaxtt (76) -> wohvpbn, fkjwn\n" +
                "tjuqz (32)\n" +
                "ztfhz (8)\n" +
                "wayftw (17)\n" +
                "qbcar (54)\n" +
                "neliq (6)\n" +
                "yxqaa (61)\n" +
                "lupyc (114) -> rsqihar, moivx, xxoil, vggstn\n" +
                "dlkhb (56)\n" +
                "uctlk (36)\n" +
                "ssyfvrj (56)\n" +
                "ibwve (36) -> zfmas, sddvn\n" +
                "brwsjee (46) -> uqpprye, ejovcx\n" +
                "wgcgdvt (13)\n" +
                "ndhitxf (141) -> uoxzkp, ppossv\n" +
                "seblnmz (31)\n" +
                "osnjzpt (36)\n" +
                "cihzh (85)\n" +
                "dtkdwp (42)\n" +
                "xmogef (10)\n" +
                "btbnj (186) -> jxqzmuv, tycgm, xewbn, rjayavy\n" +
                "gcrbrn (90)\n" +
                "jiaho (7)\n" +
                "czuwoe (325) -> hxzjg, cfiyqh\n" +
                "hxzjg (6)\n" +
                "zfshwt (80)\n" +
                "frycrnj (44)\n" +
                "owcwvug (85)\n" +
                "cnsbonb (64)\n" +
                "gwudp (77)\n" +
                "xsjbc (89)\n" +
                "fvkxwt (7466) -> zuoczei, gjwzw, qsyocuq\n" +
                "whgpim (68)\n" +
                "tzhoqw (84)\n" +
                "bbbms (56)\n" +
                "ubhlb (350)\n" +
                "zzbzwdm (34)\n" +
                "cwixiq (35) -> jvnuwap, hkweu\n" +
                "ecytwe (249)\n" +
                "ckombz (80)\n" +
                "bzbfpkb (156) -> zhrsp, rgzrnnl\n" +
                "vfkjif (42)\n" +
                "oinyx (42)\n" +
                "necqpdx (48)\n" +
                "qpden (7)\n" +
                "ruabtb (88) -> xvwio, lhbwbik\n" +
                "btukw (52)\n" +
                "rkofvt (1150) -> gkqgru, xoqvvx, iqler, dhaxwd\n" +
                "utyrttu (89) -> wjaocmd, xwohr, rxflxr\n" +
                "nnnkplx (23)\n" +
                "kgzyk (90) -> iqymm, asrwh\n" +
                "ukrqfm (96) -> yuiicxp, qjnhwpq\n" +
                "aulgwyb (852) -> rhjxbx, weguko, ppqdnd, csmul, srscbv, kriwb\n" +
                "jppsaym (95)\n" +
                "vfmlyg (40)\n" +
                "weygson (129) -> kpnxkyy, wdcltyl\n" +
                "vzbpn (76)\n" +
                "foibc (12)\n" +
                "hsqhwef (48)\n" +
                "hpgwq (18)\n" +
                "crothf (108) -> pwfdn, hawmd\n" +
                "nfmicyi (65)\n" +
                "cjeauo (97)\n" +
                "ptawnqq (65) -> kcjwb, bvknwgq, xsddbi\n" +
                "oicysoz (33) -> awgjkiv, ndszsz\n" +
                "rdvtzr (11)\n" +
                "swqym (72)\n" +
                "cppdkv (32)\n" +
                "uuapl (38)\n" +
                "yriibfp (27)\n" +
                "nfklqi (22)\n" +
                "xhmornc (148) -> dnjydir, icnav, qyasuw\n" +
                "lhbwbik (72)\n" +
                "wshlljj (1198) -> ojqqw, olevfy, iwiaa\n" +
                "mjtuzfr (23) -> ukaflr, zzsqfm\n" +
                "zxavxe (34) -> swqym, yreenth, ubvheu\n" +
                "pxhwr (7)\n" +
                "wyhnmbs (71)\n" +
                "nigkvxl (46)\n" +
                "perbvgz (23)\n" +
                "kyuneoo (64)\n" +
                "djeee (15)\n" +
                "lkfdr (85)\n" +
                "evkau (63)\n" +
                "tridq (59)\n" +
                "eepdcje (37) -> cxhuwiw, damyp, tmvfp\n" +
                "nzdbs (50)\n" +
                "ejnqcb (74)\n" +
                "dfzwcc (74)\n" +
                "efgqua (62) -> klhfca, usitmiz, aceqrlu\n" +
                "mqpbpgq (94)\n" +
                "boqgjn (56)\n" +
                "bxkxp (81)\n" +
                "vbzwk (48)\n" +
                "gldgrng (63)\n" +
                "kgkpfg (92)\n" +
                "jutgp (84)\n" +
                "zouxmz (48)\n" +
                "uktpcar (155) -> ebwgi, pozpmyh\n" +
                "dhaxwd (167) -> pxhwr, qxyramq, wphgd\n" +
                "yreenth (72)\n" +
                "iciuuh (63) -> gslii, fqaefy, hwuwj\n" +
                "xifaq (38)\n" +
                "oqdukh (56)\n" +
                "hasyyr (24)\n" +
                "khzbxke (174) -> ftkflbo, tracdgp\n" +
                "zoryb (73) -> eusnn, exqkey\n" +
                "ebnqn (9)\n" +
                "pncxkcd (156) -> izpxjp, myckhlw\n" +
                "qqmlvk (96)\n" +
                "qpxgye (93)\n" +
                "qybit (79)\n" +
                "stbgj (10)\n" +
                "smsoi (53)\n" +
                "zlpxr (136) -> iuauic, dznlyl\n" +
                "wfwbq (42)\n" +
                "frcqooy (69)\n" +
                "zxrmy (70)\n" +
                "mxvaxl (60)\n" +
                "wwzli (16)\n" +
                "jpnhog (8)\n" +
                "pablb (107) -> muopf, oekhu, thzqscd\n" +
                "mxgyt (51)\n" +
                "xkzlyvh (80)\n" +
                "fkrog (46)\n" +
                "qcntm (13) -> lvcsn, kpqwup, gosgwz, moiqr\n" +
                "wzybp (73)\n" +
                "urkya (70)\n" +
                "lqbnqnl (91)\n" +
                "sycbr (76) -> mutwmaa, qmpncds, bfroq, khsdxn\n" +
                "alzvh (2766) -> gtpyffj, fzgto, uewchd\n" +
                "bwaye (245) -> rveuz, rcumpgx\n" +
                "wfdkce (50)\n" +
                "xmbujw (94) -> jguufio, shyxzeh, pjxauhw, ytirlv\n" +
                "jrkbay (75)\n" +
                "knrtys (63)\n" +
                "ubjuhxp (51)\n" +
                "urbkrn (416) -> seblnmz, kgfhvte\n" +
                "urfhlf (9)\n" +
                "wyohotq (145) -> vlbsr, oqdukh, ssyfvrj\n" +
                "lurhq (1328) -> cibzqvo, sycbr, ruabtb\n" +
                "aqaems (26)\n" +
                "ysakcag (82)\n" +
                "hydeeqe (97) -> jutgp, wxudgdd, bqtxl\n" +
                "ecanv (17) -> dxloi, whaax\n" +
                "bmyahis (55) -> qpxgye, ajkztpj, ywkpvle\n" +
                "qlxgnl (7)\n" +
                "tdwxgv (22)\n" +
                "qdyzunw (182) -> stbgj, loljfo\n" +
                "ftxif (57)\n" +
                "xminmbj (69)\n" +
                "cvwsj (86) -> stdfrj, fvjcbib, ixroc, ksqrqx\n" +
                "vfxqcbq (84) -> vlgiuef, dojviv\n" +
                "cpmpyvq (19)\n" +
                "frikrv (36) -> yngqiv, wsoahhs, pncxkcd, gpqhjv, zlpxr, fdumfc, kwavcf\n" +
                "ikqijv (429) -> jcqhl, nwxyrtn, vjxldb, mmtzk, gnffg\n" +
                "wuipwl (18)\n" +
                "latmzh (92)\n" +
                "uyrxc (60)\n" +
                "pyoma (1498) -> oicysoz, qsbcfm, eepdcje, fhdqcbx, zzcagx, dvipr\n" +
                "sttus (85)\n" +
                "essvr (61)\n" +
                "pibqmuz (19) -> kgvbcq, wuegrv\n" +
                "xfurlrr (14)\n" +
                "cmgvs (77)\n" +
                "qkluh (73) -> weunegg, ziiijv\n" +
                "nqylf (225) -> bvenb, njozyy, amxjb, stujlz\n" +
                "hfymm (14) -> uakcbox, kbmse, qvyrm\n" +
                "mernsee (51)\n" +
                "nnyago (76) -> mxvaxl, uwrfay\n" +
                "brlzr (15)\n" +
                "jpwwg (65)\n" +
                "muopf (40)\n" +
                "oxzmr (360) -> ydowp, nnnkplx, grlofut\n" +
                "xpvukx (86)\n" +
                "erbssqe (66)\n" +
                "irhslmm (33)\n" +
                "yiteow (83)\n" +
                "kthnd (77) -> zbmwego, pvliyn, svsjobu, bzfew\n" +
                "uzzeydh (53)\n" +
                "stdfrj (98)\n" +
                "fblafmm (11)\n" +
                "qpjzx (27)\n" +
                "gjqwe (313)\n" +
                "uizop (48)\n" +
                "tzvld (393)\n" +
                "iqler (88) -> vnelda, ujpgmwm\n" +
                "xljycl (41)\n" +
                "rdomgf (10) -> sggimr, jegoty, owcwvug, tcqnso\n" +
                "fnzskbi (42)\n" +
                "vkleczw (93) -> uxzwwe, cupeghk\n" +
                "tdhxy (95)\n" +
                "iiiof (38)\n" +
                "qvyrm (68)\n" +
                "eogzpga (44)\n" +
                "naxce (126) -> inija, cvvegrx\n" +
                "hxfvc (18) -> lqbnqnl, qguphyk\n" +
                "vwosnfn (293) -> umnkslz, rlgbvvj\n" +
                "khuess (49)\n" +
                "akdffhk (78)\n" +
                "kriwb (19) -> ziayhmx, zouujb, kcqgcgl\n" +
                "bmqhrtg (11)\n" +
                "dbuqsj (92)\n" +
                "aftzw (81)\n" +
                "nrvsqf (5)\n" +
                "emhxtcg (534) -> uktpcar, yjoyyvl, blwhz, bvbtxh, jkoyyzg, cdnwq\n" +
                "kcqgcgl (52)\n" +
                "fzgto (67) -> qcntm, tzvld, yohxzv, ttmnf, hbtur\n" +
                "ymxwlpc (92) -> ngjngv, jcdmhvd, nqylf, ecytwe, iciuuh\n" +
                "alkizae (61)\n" +
                "emkzxk (257) -> krfqcf, sybpjci\n" +
                "sejkvk (203) -> kojry, tdwxgv\n" +
                "yunpioi (33)\n" +
                "qmnji (89)\n" +
                "dpyxxkv (162) -> dtkdwp, rehst\n" +
                "vsfgg (12529) -> mtrde, xpzpv, etwpt, dvncmy\n" +
                "ttmnf (239) -> qrzjlw, gwudp\n" +
                "qdkrr (10)\n" +
                "okpdcz (51)\n" +
                "zsigmj (69) -> eazvkxv, ticdma\n" +
                "oaopxo (2220) -> jeopf, wphtnvm\n" +
                "uxnwtp (82)\n" +
                "kodrhj (90)\n" +
                "tflwng (93)\n" +
                "jzpdbe (29)\n" +
                "spgwj (172)\n" +
                "wmukud (34)\n" +
                "geztlsi (92)\n" +
                "kpqwup (95)\n" +
                "jcbgta (23)\n" +
                "ksfss (18)\n" +
                "zuquy (75)\n" +
                "qozmho (146) -> btrepl, gljkci, parvx, onwgja\n" +
                "vlsjsgg (80)\n" +
                "bdwbjzh (38)\n" +
                "lvdff (191) -> wqokqz, zyaab\n" +
                "mvgmbru (98)\n" +
                "krolgpf (27)\n" +
                "ixreefh (108) -> auqyep, jgnklq\n" +
                "ivlac (48)\n" +
                "nhteaei (70)\n" +
                "pwhmf (204) -> iujytuv, iieico\n" +
                "dpoat (79)\n" +
                "ubvheu (72)\n" +
                "ygiyze (75)\n" +
                "atqewc (16)\n" +
                "sawpop (92) -> piyqfs, wfamtnm\n" +
                "uwylbft (93)\n" +
                "yqnso (27)\n" +
                "ccjtpv (158) -> oipqc, vxlypal\n" +
                "hkweu (66)\n" +
                "gfasdd (11)\n" +
                "jsuak (24)\n" +
                "vugavk (38)\n" +
                "duzgl (7)\n" +
                "odxyfb (686) -> biglt, irjov, pibqmuz\n" +
                "umxurvd (54)\n" +
                "qgcvk (881) -> oizmgt, apqby, ecanv\n" +
                "jphmpr (91)\n" +
                "cvrqij (84)\n" +
                "blwhz (23) -> cihzh, sttus\n" +
                "guiej (70)\n" +
                "wjaocmd (82)\n" +
                "ruvfo (50) -> dlhyzjw, skdylgb\n" +
                "ksqrqx (98)\n" +
                "pwhplm (61)\n" +
                "nfhaii (6)\n" +
                "wfamtnm (58)\n" +
                "qbzeji (317)\n" +
                "okxucaz (54)\n" +
                "nzvpgv (290) -> kwmao, ofgeu\n" +
                "jlwzgg (61)\n" +
                "bsqilyq (82)\n" +
                "gosgwz (95)\n" +
                "syxkp (79)\n" +
                "epydl (42)\n" +
                "fhhrji (186) -> faudqy, bxcdldt\n" +
                "evkrnfo (38)\n" +
                "mulybo (75)\n" +
                "xvdkt (44)\n" +
                "qdpnnex (120) -> nwyulno, uxbjym\n" +
                "nnxqmb (297)\n" +
                "urqox (57)\n" +
                "dphmg (6)\n" +
                "wymlvix (64)\n" +
                "yfnlhlh (57)\n" +
                "oykqvif (52)\n" +
                "wexhnbh (196)\n" +
                "gzctkm (40)\n" +
                "vcwezm (82)\n" +
                "vjxldb (169)\n" +
                "ufrrrzi (31)\n" +
                "gatjls (152) -> gkxebo, xmogef\n" +
                "zujrs (72)\n" +
                "qidmgsc (301) -> hpgwq, szvty\n" +
                "oboju (147) -> cprbzvp, xbytmo\n" +
                "wdcltyl (32)\n" +
                "xsmcfs (95)\n" +
                "mnfep (63)\n" +
                "ajxsrs (296) -> vwslb, wmukud\n" +
                "vksnzty (97)\n" +
                "ccnpjdf (9)\n" +
                "cciwr (22)\n" +
                "inknun (149) -> mfutay, nzdbs\n" +
                "ckzuyha (85)\n" +
                "nkdxy (225) -> ccqldu, fkrog\n" +
                "sfohocq (13) -> fkjof, gcrbrn\n" +
                "aefqoq (84)\n" +
                "pknqf (246)\n" +
                "xujmi (68)\n" +
                "olofh (164) -> uqtiwgu, xsmcfs\n" +
                "fqaefy (62)\n" +
                "thneux (88) -> choeijs, lodcj\n" +
                "swujbg (36)\n" +
                "zfmas (70)\n" +
                "dojviv (72)\n" +
                "stujlz (6)\n" +
                "shyxzeh (61)\n" +
                "bzublv (64)\n" +
                "jubtls (68)\n" +
                "aideelj (53)\n" +
                "jieijuo (9)\n" +
                "iqpcu (94)\n" +
                "xiwnu (12)\n" +
                "grrxl (84)\n" +
                "sftqzaf (43) -> qybit, dpoat\n" +
                "bqoptf (74)\n" +
                "alaug (75)\n" +
                "sawkpue (271) -> modms, ssrqm, ndgzf, sqvxf\n" +
                "bnjwfrz (63)\n" +
                "xklrgp (149) -> yfrmup, nfhaii, uspmxw\n" +
                "jbarvch (275) -> qtqcv, prvldv\n" +
                "pmgngjy (74)\n" +
                "qitnlrh (70)\n" +
                "sbfiv (44)\n" +
                "bijprk (8)\n" +
                "sktewq (253) -> fxfznc, venvbai, rxgry\n" +
                "gcdzhfy (70)\n" +
                "zyzet (19)\n" +
                "zffpxgw (217) -> hpcmne, ajiubh\n" +
                "ajiubh (37)\n" +
                "ywmif (47)\n" +
                "egzpjym (202) -> hasyyr, vgjgz\n" +
                "jopcvyb (448) -> tgwgno, uyhlbf, rdomgf, yrozpm, qnscqms, ubhlb\n" +
                "jkoyyzg (79) -> urqox, yfnlhlh\n" +
                "auciw (18)\n" +
                "prlhyb (7)\n" +
                "jtqijee (171) -> auciw, awqgdfk, uceyfx, awjwff\n" +
                "dxloi (90)\n" +
                "gxpuofv (65) -> cxptwu, zrwnma, mxgyt\n" +
                "moiqr (95)\n" +
                "rfkcylj (16) -> ckypedd, xjufehm, nbkzvz\n" +
                "rkwkwd (97) -> dfzwcc, pmgngjy, ejnqcb\n" +
                "fkjlcz (177) -> mjrog, qmnji\n" +
                "cider (27)\n" +
                "cfiyqh (6)\n" +
                "ywkpvle (93)\n" +
                "nbkzvz (61)\n" +
                "ndszsz (71)\n" +
                "kwzgwt (83)\n" +
                "rgxwwc (27)\n" +
                "prvldv (6)\n" +
                "iotkxfd (8)\n" +
                "mfutay (50)\n" +
                "vgkltqq (16) -> wzxyc, uodhr, xsjbc\n" +
                "dehjjod (82)\n" +
                "yyyub (74)\n" +
                "dfwpczh (16) -> bkjppqe, yuhmnjs\n" +
                "zejjjo (109) -> aoipta, bbbms\n" +
                "zrwnma (51)\n" +
                "bwiqe (98) -> dtburx, bpgdb, fhhrji, hfymm, tgqwgb, gxpuofv\n" +
                "ktcdxoo (973) -> efobdsd, jtmps, zmjqiv\n" +
                "tvinpl (220) -> iglmzsi, zujrs\n" +
                "dkkkntv (78)\n" +
                "qwlze (163) -> nvtyg, hzywspw\n" +
                "bzbvwgh (7) -> kbwpk, czuwoe, tpekc, qidmgsc, hagrq\n" +
                "brghw (48)\n" +
                "kojry (22)\n" +
                "cstmu (8193) -> mkrjamh, vycgaoz, ruvfo, sawpop\n" +
                "kjmse (87)\n" +
                "umutl (36) -> grtrt, tjaqrw\n" +
                "olrdlw (67) -> fxqng, irvolb\n" +
                "emrbwzz (7)\n" +
                "iyxsjhc (80)\n" +
                "ueasp (94)\n" +
                "jdhewio (390) -> qpden, olspso\n" +
                "szszezd (909) -> tvcxl, mdnqs, waxkga, gyjvtjm, ytbyct\n" +
                "egdrn (74) -> fdzqz, urkya, nhteaei, xjypx\n" +
                "eoaoxqm (753) -> khzbxke, pwhmf, kapxuq\n" +
                "uyhlbf (350)\n" +
                "qkmkwgl (68) -> tyywgp, xjhvuc\n" +
                "hbwec (56)\n" +
                "mfbnys (40)\n" +
                "jegoty (85)\n" +
                "ukaflr (99)\n" +
                "fmwvok (1044) -> cksiby, uravet, wexhnbh, nnyago, thneux\n" +
                "rjayavy (7)\n" +
                "xybiuiq (53) -> egrimlf, cdvhmy, hqwkq, wfwbq\n" +
                "xlanm (10383) -> bwmrksn, fimqsn, naxce, zjtjt\n" +
                "tumwln (348) -> qgvqg, sawkpue, tcvgl, zqnjd\n" +
                "onamlmy (195) -> kzxyyd, yiqnfd\n" +
                "gljkci (15)\n" +
                "vjevs (35)\n" +
                "vuzxr (82)\n" +
                "ccuehkp (93)\n" +
                "jtmps (56) -> wixoky, vmsmdqx, lxbsif\n" +
                "xvwio (72)\n" +
                "thzqscd (40)\n" +
                "yuiicxp (56)\n" +
                "xrkqv (137) -> xgihtsx, iunkpe\n" +
                "yacmhtk (19)\n" +
                "mcjlm (575) -> qkluh, bsfgu, ndhitxf, jtqijee, ifgfg, wvhvw\n" +
                "bmfhjo (170) -> bznst, xcgwl\n" +
                "wrwgm (11)\n" +
                "kwxpnrs (132) -> rmnkgss, cciwr\n" +
                "mmndzs (75)\n" +
                "dkjlges (80)\n" +
                "mpnnffx (142) -> wayftw, epaaasn\n" +
                "xsfefyb (674) -> xybiuiq, jnzqvia, eywfmfs\n" +
                "zukio (75)\n" +
                "npjcdl (68)\n" +
                "mikast (17)\n" +
                "rbauxvx (6)\n" +
                "ipxns (75)\n" +
                "frezf (95)\n" +
                "rxflxr (82)\n" +
                "ejzsbli (237) -> djsss, rkhyewd\n" +
                "ullvx (79)\n" +
                "cxetjr (1657) -> fujwb, nnxqmb, kthnd\n" +
                "vmpmig (15)\n" +
                "kgqgct (13)\n" +
                "fupwuk (49)\n" +
                "mctsts (17)\n" +
                "pozpmyh (19)\n" +
                "dfrcge (27)\n" +
                "ywhjz (482) -> exesam, odbyxq, xghhu, xmbujw\n" +
                "ytirlv (61)\n" +
                "eajmafa (81)\n" +
                "dxavw (16)\n" +
                "rswqvx (249)\n" +
                "pwfdn (40)\n" +
                "cayigxg (24)\n" +
                "doppnr (201)\n" +
                "rehst (42)\n" +
                "rxezd (318) -> sohuv, ksfss\n" +
                "hfhswyd (85) -> tqyldbt, tridq\n" +
                "aoipta (56)\n" +
                "tpmhs (61)\n" +
                "zkvopb (23) -> nxqzuy, jpwwg\n" +
                "aceqrlu (81)\n" +
                "utispep (65)\n" +
                "zmtfcll (70)\n" +
                "sfruur (62) -> twbxgv, evows, xwwzp, vsfgg, zsasjr\n" +
                "utsfqn (41)\n" +
                "tdknh (69)\n" +
                "fwocscd (158) -> krolgpf, gbmfzzu\n" +
                "zouujb (52)\n" +
                "mvdzfo (47)\n" +
                "wfjks (83) -> ekleund, kikntw, jubtls, npjcdl\n" +
                "bvbtxh (136) -> zyzet, pflvdx, ontrln\n" +
                "obzomb (23) -> ullvx, acfmyv, mzywzs\n" +
                "khupkt (63041) -> alzvh, sjhwgq, lyxzfqz\n" +
                "zhrsp (52)\n" +
                "vxruziw (439) -> tpvzavf, xrkqv, qvndh, xklrgp, cwixiq\n" +
                "svcafxb (423) -> jbarvch, mawwtx, stkcndh\n" +
                "dhejgd (82) -> tzhoqw, cvrqij, xokmont\n" +
                "erfldtn (82)\n" +
                "predg (84)\n" +
                "waxkga (169) -> rgxwwc, yriibfp\n" +
                "kvpsfgk (17)\n" +
                "tlmxygb (70) -> rvyqbq, olofh, egdrn, pkudedc, rxezd, csnhv, jrgougl\n" +
                "nzhnurq (114) -> zwxwfin, lwvcp\n" +
                "fzvdchs (59)\n" +
                "rsqihar (23)\n" +
                "vtvsd (114) -> cnsbonb, ajhizdz\n" +
                "zykcrir (60)\n" +
                "ockzlpp (43) -> chxsxbr, vbvug\n" +
                "fdumfc (134) -> lninq, ykowao\n" +
                "nqjuj (19)\n" +
                "akzcjd (63)\n" +
                "qhrxvzj (52)\n" +
                "kpdmptf (48)\n" +
                "gtpew (23) -> iyxsjhc, fwvvidu, mdshsxt, yzvqo\n" +
                "stkcndh (183) -> cohps, legrbb\n" +
                "nbrfpbr (872) -> iedrlkp, rtyegs, hxfvc\n" +
                "nxqzuy (65)\n" +
                "ojrjqv (85)\n" +
                "egcjfjo (41)\n" +
                "mlfxnna (51)\n" +
                "nhbbd (62)\n" +
                "ykxnd (88)\n" +
                "bwfqr (89)\n" +
                "wuvmf (5)\n" +
                "kmbrqv (13)\n" +
                "uwrhuw (88)\n" +
                "oaqvt (50)\n" +
                "wqzic (42)\n" +
                "yxsaf (80)\n" +
                "cvvegrx (25)\n" +
                "faudqy (16)\n" +
                "qeiijk (188) -> jiaho, qlxgnl\n" +
                "moqped (94)\n" +
                "zmjqiv (94) -> jwjrj, bwfqr\n" +
                "jdxfsa (1869) -> lugwl, ckcjr, umutl\n" +
                "wsmmlrl (70)\n" +
                "hjtkb (9)\n" +
                "wdjcb (16)\n" +
                "jlgnsu (65) -> wxvuup, ilvblzm, ckzuyha, cbbtbz\n" +
                "pjsbxvk (770) -> dfwpczh, gsmocx, fwocscd\n" +
                "iiwwr (284) -> hmnvh, vksnzty\n" +
                "sysvory (145) -> udpcyt, yrdhq, ealyedu, kmufvuk\n" +
                "wvdoa (95)\n" +
                "dcqinx (36)\n" +
                "rugnh (52)\n" +
                "uspmxw (6)\n" +
                "ajhizdz (64)\n" +
                "onkhx (65)\n" +
                "gbmfzzu (27)\n" +
                "zjtjt (14) -> xqshwdz, khjag\n" +
                "pzlhzky (48)\n" +
                "vonesxw (19)\n" +
                "aiwvi (242) -> walkm, ixreefh, gatjls, spgwj, kjdjdr, ybnehoi\n" +
                "pflvdx (19)\n" +
                "rvyqbq (214) -> bxqjg, sxzpils\n" +
                "bdmah (57)\n" +
                "tgqwgb (78) -> zxrmy, qvmbysw\n" +
                "dbnoug (31) -> xnvdqbe, mtowovz, bzbncmc\n" +
                "hclea (96)\n" +
                "sggimr (85)\n" +
                "weithhz (56)\n" +
                "mzywzs (79)\n" +
                "vfykuuv (87)\n" +
                "zwxxii (91)\n" +
                "etlce (14)\n" +
                "ixomyeb (24)\n" +
                "xqshwdz (81)\n" +
                "exesam (300) -> fhjzpjw, qxjknv\n" +
                "djimr (1615) -> ltgnnr, kjmse\n" +
                "cadasac (35)\n" +
                "pyvwl (78)\n" +
                "hdikur (11)\n" +
                "bkfav (57)\n" +
                "nrduy (96)\n" +
                "uqpprye (82)\n" +
                "kmrmxw (29)\n" +
                "xjhvuc (57)\n" +
                "aflcmu (407) -> ezycquw, kaecmob\n" +
                "utamsb (75) -> llrrzrn, erbssqe\n" +
                "bavaf (18)\n" +
                "umhjck (87) -> zepjndx, bdmah\n" +
                "ngjngv (123) -> jqnnot, bnjwfrz\n" +
                "kcjwb (61)\n" +
                "cibzqvo (178) -> dfrcge, uuixxr\n" +
                "gjgwki (78)\n" +
                "rgelh (66) -> tmigcw, jmzvi, tjslk, blpjnzf, qzobjfo, rcmyfr, bwaye\n" +
                "uceyfx (18)\n" +
                "epaaasn (17)\n" +
                "biglt (73) -> rihlj, odoxr\n" +
                "bsfgu (215) -> iinxvw, sgpiiir\n" +
                "hatmr (61)\n" +
                "txtdw (8)\n" +
                "fdaqst (25)\n" +
                "dxavaum (18)\n" +
                "ticdma (66)\n" +
                "plkmpm (78) -> bieok, grrxl\n" +
                "ywzai (152) -> khuess, vbauj\n" +
                "mdshsxt (80)\n" +
                "weguko (91) -> iuwwa, epydl\n" +
                "kaecmob (10)\n" +
                "psmztc (11)\n" +
                "qzayss (31)\n" +
                "tbdhh (104) -> sfwaimh, orihc, jsuak\n" +
                "wxvuup (85)\n" +
                "mhpxyvm (734) -> xdkya, zsigmj, umhjck\n" +
                "oqqme (17)\n" +
                "judfhye (25) -> brlzr, dxffr\n" +
                "qsbcfm (37) -> fqayb, xminmbj\n" +
                "bvknwgq (61)\n" +
                "hwuwj (62)\n" +
                "zgoinf (345) -> xljycl, ghfcfj\n" +
                "vbvxs (31) -> akzcjd, vnynj, eanoucd, txxfz\n" +
                "mqlgoq (86)\n" +
                "csmul (75) -> wfdkce, oaqvt\n" +
                "fzzlnwi (63) -> vgkltqq, vbvxs, lfwru\n" +
                "ywegjjk (6058) -> rgelh, sfizdf, mcjlm, ztjquwi\n" +
                "gyjvtjm (179) -> paynlu, nfklqi\n" +
                "ecfrqpl (133) -> okniwp, njqemt\n" +
                "xcgwl (20)\n" +
                "nsxrvpg (313) -> nqtowev, fblafmm\n" +
                "iwiaa (188) -> ztfhz, txtdw, jpnhog\n" +
                "nxpozme (16)\n" +
                "dxpxept (36)\n" +
                "tbaai (25) -> vrqbi, jjdmu\n" +
                "imxro (58)\n" +
                "onwgja (15)\n" +
                "gnqwwbt (75)\n" +
                "nbjpcc (88)\n" +
                "ontrln (19)\n" +
                "jxpixqi (14)\n" +
                "llrrzrn (66)\n" +
                "hdmcpq (131) -> qitnlrh, wsmmlrl\n" +
                "vlgiuef (72)\n" +
                "bieok (84)\n" +
                "hpcmne (37)\n" +
                "qxjknv (19)\n" +
                "qguphyk (91)\n" +
                "aukjf (179) -> okxucaz, otbxl\n" +
                "vggstn (23)\n" +
                "vlmzodk (66)\n" +
                "bqtxl (84)\n" +
                "vilskw (181) -> vahnoue, wqzic\n" +
                "wzxyc (89)\n" +
                "upsmxqn (470) -> bmyahis, xanbjlw, twazofk\n" +
                "fwohcn (30)\n" +
                "zknpmnc (53)\n" +
                "afelswv (52)\n" +
                "kapxuq (82) -> wzybp, tdstv\n" +
                "awgjkiv (71)\n" +
                "vaeeqvi (17)\n" +
                "ydqgvnf (110) -> flejt, dxpxept\n" +
                "cdcvlb (27)\n" +
                "uqtiwgu (95)\n" +
                "jaerxmv (38)\n" +
                "mxtxm (90) -> tdknh, pjbwq\n" +
                "wvtac (60)\n" +
                "ziprwty (71) -> pshwly, jwojmds, tgsicj\n" +
                "rhjxbx (9) -> mhdkdt, kwzgwt\n" +
                "pqlwekx (87)\n" +
                "rpxmv (35)\n" +
                "yenln (12) -> wklmops, ulehitr, dbnoug, wyohotq, gjqwe\n" +
                "skdylgb (79)\n" +
                "brnhg (94)\n" +
                "qhldpg (74)\n" +
                "srsenpj (84)\n" +
                "whaax (90)\n" +
                "etjste (205)\n" +
                "ntcddy (8) -> qekpce, gjgwki, dkkkntv\n" +
                "ljfvbjd (57)\n" +
                "irjov (61) -> bzdgxs, zkbeehu\n" +
                "bvenb (6)\n" +
                "tlkhxww (91)\n" +
                "icnav (41)\n" +
                "myckhlw (64)\n" +
                "iglmzsi (72)\n" +
                "oztasey (158) -> dxddn, foibc\n" +
                "oakbrw (11)\n" +
                "hawtu (54)\n" +
                "zkbeehu (78)\n" +
                "hzzxjxa (47)\n" +
                "felrwte (64)\n" +
                "ogyiesm (5127) -> eoaoxqm, lptmne, titze\n" +
                "ojqqw (52) -> yxsaf, zfshwt\n" +
                "odbyxq (338)\n" +
                "gkxebo (10)\n" +
                "bvcghhs (29)\n" +
                "mvamo (49)\n" +
                "wemjk (64)\n" +
                "olspso (7)\n" +
                "uasqon (97)\n" +
                "liwlcz (728) -> fhvyhk, qqnywdg, ajxsrs, utojr, tvinpl\n" +
                "rkhyewd (49)\n" +
                "wuckr (40)\n" +
                "hzywspw (31)\n" +
                "ofgeu (22)\n" +
                "hcyjfzz (92)\n" +
                "ieebfpb (71)\n" +
                "aclihvm (8)\n" +
                "xyoiv (17)\n" +
                "okniwp (30)\n" +
                "jfchk (1360) -> hbwec, weithhz\n" +
                "kwmao (22)\n" +
                "piqids (229) -> fbusld, xifaq, vkwsodp\n" +
                "ryctwjl (19)\n" +
                "sybpjci (24)\n" +
                "klnxfd (1174) -> zoryb, wcpyi, etjste\n" +
                "mjrog (89)\n" +
                "zyaab (50)\n" +
                "xanbjlw (258) -> uuapl, sckgsn\n" +
                "xdkya (143) -> bvcghhs, jzpdbe\n" +
                "dznlyl (74)\n" +
                "lcgtwj (160) -> pxsokyl, chhhge\n" +
                "cvprip (282) -> qkpaxtt, bmfhjo, tqimh\n" +
                "paynlu (22)\n" +
                "ixnlvyo (75)\n" +
                "qjnhwpq (56)\n" +
                "qnsqwm (106) -> brnhg, trcyfi\n" +
                "jeopf (72)\n" +
                "vnelda (50)\n" +
                "nwyulno (87)\n" +
                "njozyy (6)\n" +
                "yjrar (13) -> jppsaym, agfnncm\n" +
                "gyzorus (49)\n" +
                "pjbwq (69)\n" +
                "hechfb (31) -> aflcmu, sjdpe, ofdehn, zgoinf, umnqkb\n" +
                "jrgougl (54) -> jrkbay, elpwvoy, gnqwwbt, ipxns\n" +
                "wsoahhs (188) -> zouxmz, brghw\n" +
                "rhlepi (85)\n" +
                "qopkhc (69) -> cvrga, ujtej, gybikf, dkoike, guhjkd\n" +
                "lvcdsgp (178) -> afelswv, ovhhkoc, rugnh\n" +
                "dhsopiv (88)\n" +
                "jwojmds (59)\n" +
                "auqyep (32)\n" +
                "jkodco (46) -> adunt, ztook\n" +
                "pxsokyl (34)\n" +
                "ieohkpr (10)\n" +
                "velhob (109) -> gyzorus, kfngejn\n" +
                "cfrcco (217) -> zhhhntj, jcvimc\n" +
                "xlvjz (26)\n" +
                "tnhet (78) -> onoyb, laohhtn, mqlgoq\n" +
                "ejovcx (82)\n" +
                "yaehsu (75)\n" +
                "kqueox (7)\n" +
                "evows (4599) -> xsfwcgq, txszqu, uypxc, aulgwyb, qshoazt, dyfnpt, rkofvt\n" +
                "dtburx (130) -> frycrnj, vqrtnp\n" +
                "qtqcv (6)\n" +
                "mgyixhn (32) -> msskm, iqtemv\n" +
                "bckbud (249) -> iqjbdok, mjtuzfr, zejjjo\n" +
                "njmlk (65)\n" +
                "ebwgi (19)\n" +
                "lsaroxx (63)\n" +
                "xjufehm (61)\n" +
                "htbmh (29)\n" +
                "molth (16)\n" +
                "lninq (75)\n" +
                "lwqlyjq (309) -> qongfb, pzlhzky\n" +
                "yqlxeb (79) -> ymxwlpc, cavlg, odxyfb, xsfefyb, mhpxyvm, htujh, xfglmz\n" +
                "vagjk (98)\n" +
                "ssrqm (37)\n" +
                "damyp (46)\n" +
                "svsjobu (55)\n" +
                "djsss (49)\n" +
                "udnmqte (36)\n" +
                "lzeihwp (83)\n" +
                "oplzouv (74) -> fqfnocq, ntftmt, piqids, dbpkf, gtpew\n" +
                "puvhc (137) -> bsfsayz, ssxuat, brlbdjx\n" +
                "nxmksiq (40)\n" +
                "amxjb (6)\n" +
                "gnffg (119) -> vjzfc, ijyhvsj\n" +
                "inlcow (271)\n" +
                "tfqxv (1437) -> zmtfcll, gcdzhfy\n" +
                "lnontej (19) -> bpelccj, utyrttu, gqlyhql, fvwll, ejzsbli, nsxrvpg, ofyuao\n" +
                "gjwzw (207) -> egzpjym, ywzai, bfulyh, zxavxe\n" +
                "oactn (57)\n" +
                "bwugxhi (56) -> vbzwk, krrvyl, ivlac, mzrwaa\n" +
                "legrbb (52)\n" +
                "vetsll (41)\n" +
                "iujytuv (12)\n" +
                "qkapxbc (18)\n" +
                "kgfhvte (31)\n" +
                "uypxc (82) -> bpzjm, dkcqdx, msryw, aqlqmq, yxpnzkn, obzomb, bzbfpkb\n" +
                "gslii (62)\n" +
                "fyeuhqh (13)\n" +
                "wxbao (84)\n" +
                "nfkmi (894) -> drzge, bgpjb, jkodco, kxkwxoj, crothf\n" +
                "fqfnocq (305) -> yacmhtk, vonesxw\n" +
                "ykowao (75)\n" +
                "jxsmuey (82)\n" +
                "cejnfcx (89) -> rhlepi, rgkrl, gjgcvyp, lkfdr\n" +
                "wattsr (23)\n" +
                "bzfew (55)\n" +
                "guhjkd (162) -> cdcvlb, cider, qpjzx\n" +
                "ayhdd (184) -> laeaf, udiio, bgqvm, ofwtjhw\n" +
                "onaatvy (51) -> aftzw, ekxczvo, wkfjzs\n" +
                "uodhr (89)\n" +
                "cnblx (498) -> vkleczw, pablb, objssr, pzjvq\n" +
                "bdjlzf (52)\n" +
                "tynxlau (32867) -> ywegjjk, bavyg, qdpoyl, wngzh\n" +
                "soryrk (69) -> fnzskbi, oovqoi\n" +
                "nrlhen (153) -> wattsr, eqbwx\n" +
                "kgvbcq (99)\n" +
                "zsasjr (77) -> jopcvyb, pyoma, jdxfsa, liwlcz, cxetjr, vifbi, tlmxygb\n" +
                "orihc (24)\n" +
                "titze (609) -> czmzol, velhob, truximz, utamsb\n" +
                "igbhyk (44)\n" +
                "jgnklq (32)\n" +
                "bjcsjrr (138) -> bpemyk, nqjuj\n" +
                "ismrc (90) -> cjeauo, uasqon, prxmxv\n" +
                "fbusld (38)\n" +
                "kikntw (68)\n" +
                "cksiby (128) -> zzbzwdm, zdawjkr\n" +
                "rgkapf (77) -> dkjlges, ckombz, vpnjbha\n" +
                "oovqoi (42)\n" +
                "ujtej (57) -> ccuehkp, tflwng\n" +
                "yanvh (44)\n" +
                "mawwtx (29) -> bvrpb, xpvukx, jhbqc\n" +
                "jinwsas (235) -> gzctkm, nxmksiq, fhyvz\n" +
                "gapzarg (79)\n" +
                "sjdpe (263) -> erfldtn, vuzxr\n" +
                "vnynj (63)\n" +
                "jqnnot (63)\n" +
                "rxlbou (57)\n" +
                "xewbn (7)\n" +
                "tiwkyz (117) -> lewbxa, btnnorn\n" +
                "kbwpk (307) -> ffhxi, polumk\n" +
                "gkqgru (14) -> pqlwekx, ysdqkw\n" +
                "baaqr (94) -> btnyx, fdszkhp\n" +
                "jmzvi (89) -> rzwjli, uizop, necqpdx, debir\n" +
                "mtowovz (94)\n" +
                "wklmops (201) -> mbkbmql, dlkhb\n" +
                "xnvdqbe (94)\n" +
                "ofdehn (95) -> yiteow, yblsbf, gazaoty, lzeihwp\n" +
                "brlbdjx (13)\n" +
                "xawfk (85)\n" +
                "krfqcf (24)\n" +
                "khsdxn (39)\n" +
                "qrlhp (61) -> moqped, ueasp\n" +
                "rzwjli (48)\n" +
                "polumk (15)\n" +
                "bwmrksn (14) -> bxkxp, eajmafa\n" +
                "vwslb (34)\n" +
                "qdcos (132) -> ryctwjl, sczyp, enxbya, cpmpyvq\n" +
                "uuixxr (27)\n" +
                "yqqun (62)\n" +
                "bpemyk (19)\n" +
                "trcyfi (94)\n" +
                "ttqpi (72) -> nfmicyi, yjnrjde\n" +
                "zepjndx (57)\n" +
                "fbyju (52)\n" +
                "nbrvl (89)\n" +
                "pshwly (59)\n" +
                "uskfp (84)\n" +
                "cdnwq (41) -> xerbuu, iiiof, jaerxmv, bdwbjzh\n" +
                "dntwqr (38)\n" +
                "welvrkn (74)\n" +
                "krpda (826) -> azzysl, ayhdd, tnhet\n" +
                "jhbqc (86)\n" +
                "zlazoqs (98)\n" +
                "seihhya (81) -> jhruwih, aefqoq\n" +
                "jcqhl (5) -> glxogmc, bsqilyq\n" +
                "hsexbak (99)\n" +
                "wixoky (72)\n" +
                "awqgdfk (18)\n" +
                "walkm (84) -> cxuijad, yanvh\n" +
                "jcezw (34) -> wxbao, predg\n" +
                "iqjbdok (41) -> msrrlv, kodrhj\n" +
                "krrvyl (48)\n" +
                "bkjppqe (98)\n" +
                "srscbv (83) -> jawbtmo, wmvniap\n" +
                "nuytv (94)\n" +
                "glxogmc (82)\n" +
                "iuauic (74)\n" +
                "jtmuv (2257) -> terkw, bzbvwgh, emhxtcg, nkbmoin\n" +
                "noqjuo (29)\n" +
                "xbytmo (28)\n" +
                "khjag (81)\n" +
                "mhdkdt (83)\n" +
                "elpwvoy (75)\n" +
                "edtkfvv (1462) -> tbdhh, mpnnffx, wdzhfmw, pkceuqw\n" +
                "qxyramq (7)\n" +
                "swaxyxe (23)\n" +
                "pvliyn (55)\n" +
                "ztook (71)\n" +
                "ofcyw (74)\n" +
                "txxfz (63)\n" +
                "tqimh (196) -> prlhyb, kqueox\n" +
                "ezycquw (10)\n" +
                "lyxzfqz (30) -> qgcvk, jfchk, upsmxqn, nbrfpbr, jmbueky, kqswas\n" +
                "poypmax (7848) -> atyaqz, vkhazkn, chljtta, anehvd, vilskw, lbnenyf\n" +
                "xyemll (55)\n" +
                "pkudedc (256) -> takxgz, fupwuk\n" +
                "sxvig (60)\n" +
                "jkvgvz (49)\n" +
                "ssxuat (13)\n" +
                "vrqbi (84)\n" +
                "tjslk (281)\n" +
                "moivx (23)\n" +
                "oizmgt (137) -> sakhif, fwohcn\n" +
                "vpnjbha (80)\n" +
                "izpxjp (64)\n" +
                "pzjvq (85) -> ieebfpb, yprusb\n" +
                "tycgm (7)\n" +
                "lrjnzf (68)\n" +
                "yprusb (71)\n" +
                "oeqqj (259) -> pwhplm, jlwzgg\n" +
                "libtrl (53)\n" +
                "ozlqcn (95)\n" +
                "jmbueky (38) -> iiwwr, cvwsj, yvwecfs\n" +
                "eywfmfs (73) -> mfamq, bqoptf\n" +
                "udiio (38)\n" +
                "plsep (96)\n" +
                "ghsxqq (46) -> srsenpj, uskfp\n" +
                "qnevjto (283) -> dcqinx, uctlk\n" +
                "lwvcp (50)\n" +
                "chxsxbr (6)\n" +
                "hfxsib (247)\n" +
                "fdszkhp (77)\n" +
                "tkvmtol (117) -> vfkjif, oinyx\n" +
                "xycva (275) -> aclihvm, yaripcu\n" +
                "mtrde (1154) -> gsfnr, plsep\n" +
                "jcvimc (51)\n" +
                "vqvwkm (92)\n" +
                "asrwh (69)\n" +
                "hykxm (1428) -> dpyxxkv, plkmpm, pknqf\n" +
                "twbxgv (13182) -> yenln, qrgqcd, tfqxv\n" +
                "ziayhmx (52)\n" +
                "oipqc (9)\n" +
                "cjhtxo (137) -> gfasdd, psmztc, rdvtzr\n" +
                "iqymm (69)\n" +
                "ehvxt (17)\n" +
                "bzbncmc (94)\n" +
                "irvolb (90)\n" +
                "cxuijad (44)\n" +
                "bgavnd (94)\n" +
                "dhuof (39) -> ysakcag, dehjjod\n" +
                "wkcrce (182) -> ndvdj, ieohkpr\n" +
                "qvmbysw (70)\n" +
                "prxmxv (97)\n" +
                "evbvdgl (158) -> titbn, ebnqn\n" +
                "glqspl (27)\n" +
                "azkmt (35)\n" +
                "eanoucd (63)\n" +
                "rydrp (156) -> mbniyi, emrbwzz\n" +
                "vffqp (70)\n" +
                "tpvzavf (117) -> fdaqst, qlkjhsi\n" +
                "ajkztpj (93)\n" +
                "krbpgmk (4302) -> svcafxb, vfxzkq, vxwobup, qopkhc\n" +
                "mgqkhic (49)\n" +
                "bpzjm (142) -> loxjzpo, fzvdchs\n" +
                "ntftmt (195) -> welvrkn, htouwcr\n" +
                "etwpt (59) -> cejnfcx, oxzmr, sysvory\n" +
                "owaebx (27)\n" +
                "ctzhawr (74)\n" +
                "btnnorn (43)\n" +
                "vbmqrqx (13)\n" +
                "csnhv (248) -> smsoi, lkwogh\n" +
                "lisfhnn (91) -> zykcrir, sxvig, wvtac\n" +
                "drzge (162) -> vbmqrqx, wgcgdvt\n" +
                "ibyrsdo (25)\n" +
                "kkmidak (15)\n" +
                "sddvn (70)\n" +
                "gsmcgor (79) -> rffwau, qqmlvk\n" +
                "rsjffj (80) -> klnxfd, oplzouv, djimr, ktcdxoo, aqugisv\n" +
                "dyfnpt (468) -> xwwfi, urbkrn, kryczad\n" +
                "exqkey (66)\n" +
                "ydowp (23)\n" +
                "truximz (91) -> imxro, izyxppl\n" +
                "qrgqcd (309) -> rgkapf, tzszs, qbzeji, nkdxy\n" +
                "btnyx (77)\n" +
                "qsyocuq (346) -> qilhudr, aukjf, offkzc\n" +
                "wmvniap (46)\n" +
                "eusnn (66)\n" +
                "terkw (474) -> yjrar, hipfszh, oboju, tiwkyz, vtwdqkd, dhuof\n" +
                "aqlqmq (230) -> zhlfdac, kkmidak\n" +
                "ziqyhi (11)\n" +
                "piyqfs (58)\n" +
                "kryczad (478)\n" +
                "paoitb (51)\n" +
                "tpekc (271) -> irhslmm, yunpioi\n" +
                "qrzjlw (77)\n" +
                "aslvy (29)\n" +
                "yvwecfs (478)\n" +
                "paqihg (35)\n" +
                "itjxq (46)\n" +
                "ibdjxl (262) -> kmrmxw, htbmh, aslvy\n" +
                "cxptwu (51)\n" +
                "ghfcfj (41)\n" +
                "yohxzv (359) -> kvpsfgk, mctsts\n" +
                "kmufvuk (71)\n" +
                "mbniyi (7)\n" +
                "rxgry (32)\n" +
                "stnnf (88) -> jytapdu, kkeuh, xycva, zffpxgw, cvlkltp, lvdff\n" +
                "ychjmik (40)\n" +
                "bzdgxs (78)\n" +
                "cyczt (95)\n" +
                "luhxcq (68)\n" +
                "iedrlkp (176) -> xiwnu, gezqw\n" +
                "vgqmfj (85) -> idwpug, hawtu\n" +
                "tdstv (73)\n" +
                "mbkbmql (56)\n" +
                "dbpkf (169) -> zzcqptv, vfykuuv\n" +
                "wqokqz (50)\n" +
                "xufneyr (153)", "jdxfsa");
        // 1864
        System.out.println(result);
    }

    private static int test(String s, String root) {
        Pattern pattern = Pattern.compile("([a-z]+) \\((\\d+)\\)( -> ([[a-z]+| |,]+))?");
        String[] parts = s.split("\n");
        Map<String, Node> nodes = new HashMap<>();
        for (String part : parts) {
            Matcher matcher = pattern.matcher(part);
            assert matcher.matches() : "not matches: " + part;
            Node node = new Node();
            node.name = matcher.group(1);
            node.number = Integer.parseInt(matcher.group(2));
            if (matcher.groupCount() > 3) {
                String childrenStr = matcher.group(4);
                if (childrenStr != null) {
                    node.children = childrenStr.split(", ");
                }
            }
            assert !nodes.containsKey(node.name);
            nodes.put(node.name, node);
        }
        System.out.println(root + ": " + nodes.get(root).number);
        for (String child : nodes.get(root).children) {
            System.out.println(child + ": " + weight(nodes.get(child), nodes));
        }
        return 0;
    }

    private static int weight(Node node, Map<String, Node> nodes) {
        if (node.children == null) {
            return node.number;
        }
        int sum = 0;
        for (String child : node.children) {
            sum += weight(nodes.get(child), nodes);
        }
        return sum + node.number;
    }

    private static class Node {
        String name;
        int number;
        String[] children;
    }
}
