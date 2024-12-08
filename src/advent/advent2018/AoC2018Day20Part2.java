package advent.advent2018;

import utils.Point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day20Part2 {
    private static final Map<Point, Character> directions = new HashMap<Point, Character>() {{
        put(new Point(0, 1), 'S');
        put(new Point(0, -1), 'N');
        put(new Point(1, 0), 'E');
        put(new Point(-1, 0), 'W');
    }};
    private static Pattern pattern;

    public static void main(String[] args) {
        int result;

        result = test("^NWSSSWWSWNNWWSESWWWNENWWSSSWSSSWNWNNE(NWNEE(S|NNWSWWNWWNENNNEENWWNENWWSWNNEENNNENWNNEEESSW(NWES|)SESWSS(WNNSSE|)EEEESSSEENEESEENNEEEEESWWSEESSESWSWNW(NN(ESNW|)WNNWSSWSS(ENESNWSW|)SWS(ESWENW|)WWNENNE(S|NWW(N|WWWWSEESSWS(WNN(E|WSWW(WNEN(E(S|NNE(SS|NE(NWWSWN|S)))|W)|S))|EENNNES(NWSSSWENNNES|))))|SSEEENESESSEENNEENWNNNESSENNNNENWWNWNNWWSWWWNNNEENWWWWWWWWSWSEESWSS(WWS(ESNW|)WNWNW(SS(E|S)|NENNWWS(E|SWS(W(NNNE(S|NNW(NEEEEENNNENNNNWNNWWNWWNENWNWNWSSWSWSSEESSWNWSSSSWNWSWWNNNWSWSESWSWNNWNWSWWWWSSWNWWSWSWSSWNWSSWWNWSSSESSSWWNWWWSESWSSSENNEN(N|ESSENEEN(WW|ENNW(S|NNN(W|EESWSESSEESSWNWSSSWN(WWSWSWW(SSWSESSWNWNWSSSWNWSWWNNNWWNENNWSWSWSSE(ESE(SSSESSWSEEEESESENNNESEESESENNWNWWNEEESEENEEENESSSWNWWSESESSWWN(NWW(NEWS|)SESWWSSWNNWWSWWN(WWNWSSESWSEEN(ESSEESEESESWSWSSEESWWWNNWNNN(ES(ENSW|)S|WWWNWSSWNNWSSSWNWNENNWNWNEEEE(SS(WNWESE|)EEESEE|NNWWS(WNWNWWSSE(SSSWNWN(E|NNNNEEEE(NWWNEEN(WWWSSWNNNNNNE(ESE(N|SS(ENNSSW|)WWN(E|N))|NWNNNNNNESENEENENEENESSESWWSW(SSSENNESSE(SSWW(NEWS|)S|ENWNE(EESWSNENWW|)N(WW|NNNNNNEENENE(SS(ESNW|)W|NNWSWNNEENWWWNWNENNWSWWNWNEE(ENENNNESSEENNNW(NWWWS(EE|WNWWSWWWNNESENENWWNEEEEEESWWWSEEEENENESS(W|EESW(SSESEENEENENNNWSWS(WS(W(S|NNNE(S|ENEEENNNENWNWNNWWSESWSEESSWNWWSES(WWNWSS(EE|W(SEWN|)NWNNNWSWWWSS(WNNNNENESE(SWWEEN|)ENWNENESEESSW(WNEWSE|)SS(S|EEN(W|NE(NNW(S|NENNNWNWNNENNN(WSWS(E|SSWSESESWS(SENENSWSWN|)WWWNNE(SENSWN|)NWNWSSSWNNWNWWSWNWWNNENN(EEESSS(ENEES(WSNE|)ENES(ENNWN(WWWWSEEE(WWWNEEWWSEEE|)|EE)|S)|WW(NNESNWSS|)W)|WSWWN(WWSESSESSWSW(SEEEN(W|EE(SSSSSSSSWNWWWW(NEEENNNE(SSS|N(N|WWWWSSEE(NW|SWW)))|SESWSSEEEE(NWN(W(SW|NE)|EEEEE(SWWWEEEN|)NWNNW(NENENNWSW(NNNEE(ES(WW|SEES(SWNWSSWSS(NNENNEWSSWSS|)|E))|N)|S)|SS))|SWWSWNWSSEEE(N|SSWNWWSSSSSSSSEENWNNNESEEENE(NENWWN(EEE(ESE(N|SWSW(W|NN))|N)|WSWWS(WNN|ESENE))|SSSSWWSESEESWWWNWWN(WWSESEESWSSSESWSSWSEE(SWWWNNNENNW(S|NENNW(N|S))|ENWNEEE(SWEN|)EEE(SS|NNNWWSS(ENSW|)WWWNENWN(WSNE|)EE(N(ESEENESSSEN(NNNWNWNNWW(N|S(W|ESS(S|E)))|E)|WW)|SS)))|ENNN(ESENSWNW|)W)))))|NWWNNNW(ESSSEEWWNNNW|)))|NN(NN|E))|E)))|EESSSSS(EENENEEENNN(EESESENEEEN(ESSWSEENNNESSENESSSSSENNESSSWSSSWNWSWNWWWWSSSSESWWNWNNE(NWNNE(S|NNWNWWSWWWSESWWWWS(ESES(SENENN(W(W|S)|ENNEE(SWSSSW(N|SESSSEN(NNNNN|ESEEESSESSSESWSWWWSSENEESENNEESWSS(WWW(N|SW(WWWWNEE(NNWWWNENWNENNENWWSWNNWSW(SESWSEE(NEWS|)SWSWNW(SWSSWW(NEWS|)SSSSEE(SWWS(E|SWNNWSWW(NENWWNWSW(SES(ENSW|)W|NN(NESENEEN(WNSE|)ESE(N|SWWS(WN|ESEN))|W))|SES(E(S|N)|W)))|ENWWNNEEENWNEEE(SWSEE(NEEWWS|)SS(WNWSW(SE|NWW)|EE)|N))|NNN)|NNENNE(ESWSESEEEESWSSWSES(SWNSEN|)EENE(S|NWW(S|NE(E|NN)))|N))|EE)|S))|ENE(NNNENENNWSWNWNNENESENNEENWNWWWSS(ENEWSW|)WSWNWW(NENN(NWWSSEN(SWNNEEWWSSEN|)|EE(SSWNSENN|)EEENEENWN(WSNE|)NESENNNWNNNNESSSESENENNESSENNNWWWW(SSENSWNN|)N(WWWWSSW(NNWWEESS|)SEE(SSSEWNNN|)NN|EEEEEEESSEEEENWN(WSWNSENE|)EESEEEN(EEEEESSENEN(ESSSW(N|SSWSEENNEESSW(N|SEESSENEEESENENNENEEEESWSWSSESSSEENWNEENWWN(W|NENEESS(W(W|N)|ENEESSEENWNENNEENWWNEEESESSW(SWSW(NNEWSS|)SSSWNWSSSWWNENWN(E|WN(ENSW|)WSSESSSEEEESENESEENEESWSEENNENWNEEESSW(SWSESSSSWSESSWNWNNWWWWSWSSENESENN(W|ESSSE(N|SSSSWSSWNNNWWWSWWNENWWWNENNWWNNENESEE(NNE(S|NNN(EESSW(SEEENEE(NWWWS|SW)|N)|WSSWNWSS(ESNW|)WNWSSWWSESWWSSWNWNNE(NE(NWWNWNENENWWNN(WWWWSSSSESESSSWNWWSWWWWWWSWWNENEEEEEENWNNNWSSWNWSWWWS(SWNWNNWSSSWWSWNNWNENNWNEEENWWNENESENESEENWNWWNENWWSWS(WWS(WNWWSESWSESSE(NNENWESWSS|)S(SSWSSWNNNWWSSWWWSWSEENESSEEN(N(WSNE|)NN|EEESWWSEESSSSEEENESEENESEEENENEEENNESSSWWSSSWSSSWSSENENEENNEEEESENENNESESSSSSWSWSSEEN(W|EEEENWNWNENNWW(S(SSS(W|E)|E)|NEEENWWNNNENE(SESWS(WNSE|)ESSENEEESSWNWSWWWSESS(WNSE|)EESWWSSSWSSEEEEESWWWWSWSSESEENNN(ESEESESEENWNNENWNENENENWWNWWWSWSES(E(EN(NWSNES|)E|SWSES(S|WW))|WWNNN(WWSESSW(N|W)|ENNW(NWN(WSNE|)EESENNNE(EEEESEENNW(S|NEE(NNWSWNNEENNW(SWNWSSSSSWSE(WNENNNSSSWSE|)|NNNE(SS|NWNNNE(SS|NN(WSNE|)NNNNNNWSWWNNWSWSS(E(EEE|N)|WWNWN(WSSSWWSEEE(EN(WN|ESEN)|S)|NESE(S|NENEEEES(WSNE|)ENNWNNWSWWWNNNEES(WSEWNE|)EEE(SS|NWWNEENWWWWWWWWSS(WNWWS(E|WNWWN(EEEEE|WSWWWSEESENESE(ESSWWN(E|WWS(ESEEEWWWNW|)WWNENWWWNENN(WWWWSWNWSWWSWWNN(E(EE|S)|WWSESWW(SEESSSESENEES(W|ENNNE(S|ENN(WSWNWSSSWWWNNESEN(SWNWSSNNESEN|)|EE(N(E|W)|SS(WNSE|)EE))))|NN))|EEE))|N)))|ENE(EEE|SS(SSS(SWEN|)EEEE|W))))))))))|SSSSWWWSWWSES(WWWWNEENNN(ESEN|WSS)|ENENEESSSWSESWSESWWW(NENNN(NENSWS|)WW|SEESWWW(NN|S(W|EEEE(SWWSSEE(NWES|)SWWSSWWSSSSSWSESWWSSSESENNWNEEENNEE(NWWNW(NNNEEE(NWNEWSES|)SWS(ESW|WN)|SSS)|SSW(N|SESSWSESSSSWNNNWWSSWWNENN(WSWSWSSE(EESESWSEENN(ESE(SSW(WSWNWWNNWN(E|WWWNWSSSEEN(ESSWSSSWSSSSSSWWSSSSSWWWWSSENESSSESWWSESESWWWN(E|WWNWWNEEEE(SWEN|)NENWWNNWSWNWNNNWWWSWSESSSSENNE(ESWS(SSSESE(ESSWSWWNN(E(E|S)|WSSSEESSES(WWNNWSSWWNENNNNWSSWWSWWNENEENNENE(S|NNWN(EESSSE|WNNWWWSSWWWWWNENESENNNNNNWNEESENNESEES(SSSS(E(SS|N)|WWWNENN(NESSSNNNWS|)WSW(SSSS|N))|ENENNNWNWSWS(WWWWNENNNEENWWNNNESSEENNENWW(SS|NWWS(WWNENNNENNNNNENWNWWWNWNWWWSESWSSWNWWSSE(EEEEENN(W(WSEWNE|)N(N|E)|ESSEE(NNWSNESS|)SSWS(E|WSWSSWWNNE(NNN(ES(ENEWSW|)S|WSSWNNWSWNWSWWSWNNEENNWWWS(EE|SWWNENNNESEEENWWNWWNNWSWNNEENWWWWNNENENESE(NNWWWSWSW(NNEWSS|)SWNWSSWSEEE(NWES|)SWWWSSEEEN(WW|ESE(NNWESS|)SSENESSSWNWWWSSEE(NWES|)ESSESWWSSESEEENWN(W(W|S)|E(NNWSNESS|)ESSEEEESEE(ESENEE(NEN(W|N)|SWSWWWSWSSSSEEESSSSWSWSSSSENNEESSES(WSWWWSEESWWWNNWWWNEENNE(NWWNEENNWWNNWWSSSWWNWSWSWSEEEESWWWWWSWSSWSSENENNEESSW(N|SSSSSESSSSENESSS(WWN(WSWNWSWWNNWNEENEEN(NNNWWSESWS(WWNNWSWNNWSWSSWNNWNNENES(SWEN|)ENNNWNNNNNWNWWNWSWNNENWWNNWWWNENWNWWNEENWWWSSSSWSSENEE(NWNEWSES|)SESWW(N|SSSENEEEN(W(NNESNWSS|)WW|ESSSEESESWWWSWSWNNEN(EE|NNWSW(N|WSE(SSSSEEESWSWWSSWNWSWWSSSESWSSWSWS(EEEN(EES(W|EENNW(NNENNN(WSWS(E|W(NWNEEWWSES|)SSS(WN|ENN))|EENWN(WSNE|)EEN(W|EE(ENE(E|NNWN(NE(NWNWESES|)S|WWSES(WS(E|WNN(W|N))|E)))|SSSSWSSWNWW(NEENEN(N|W)|SESSSS(WNNNWESSSE|)EENENWN(WSSNNE|)ENE(N(N|W)|EEEEE(NWWNSEES|)(SSSS(ENSW|)WNWWWS(W(W|NNEEN(EESWENWW|)WW)|EE)|EE))))))|S))|W)|WWWWWNENNWSWSWNWSS(WWNENWNNWSWNNNNNNEEEENEENNWSWWNENNENNWSWNWNENNNNEEESWSESWS(WNNNSSSE|)ESENENNNESSENNESESESWW(SWSEESSSWNNWSWSESESENEESS(ENNEE(SWEN|)(NWWNNNNN(ESSSSENN(SSWNNNSSSENN|)|W(SW(W|SESSSWNN(SSENNNSSSWNN|))|NNE(NNWSW(WNWNEE(NNWNNNWNWWSESSWWWSWNWWNNNWNEENWWWNNNWSWW(SESWSSESSESEE(NWN(E|NNW(NN|W|SS))|SWWSSSE(SSWS(E|WNWNE(NNWWNENWWSWWSWNNWNEESENENWWWNWNNNN(NNNWSW(WWSSWWSWSSSEEENEENE(NWW(NNEESW|SWW(NE|SWN))|SSWWSEE(E|SSSSWNWNENWWSWWSSSWSWSSWSWSEESWWSEESWWW(NNNNNENENWNEENWWNNNNENNNE(NWNNWNNNW(N(EEE(SSW(SESE(SWEN|)(EE|N)|N)|N|E)|N)|SSSSSSSS(ENNNNSSSSW|)SSSSSSSS)|SSSES(WSS(WNNSSE|)E(S|N)|EEN(W|E)))|SESWSSSENEESSSSEENWNENNNENWWN(WWSS(E(ESSNNW|)N|W)|EEEESWSSEEN(EEENNWWW(SEEWWN|)NWNENWNWSSSWNWSWNNNN(ESE(SWEN|)NNESENNNEN(EE(NN|SSSEESSWWN(E|WS(WNNNE(S|N)|SSSEENN(WSNE|)ESEENWNENWNNNWW(SEWN|)NEENESE(E|SSW(N|SEESSESWW(SESENESSE(SWS(WNWSSSWWSESWSEE(SWWSESE(SS(EENNWS|WWN(E|NWWSS(ENSW|)WWNWWS(WWWWWWNWWNW(SSEEWWNN|)NNNESSEN(NNWWNEEN(SWWSEEWWNEEN|)|ESS(ESEENNW(N(WSNE|)ENESEEESWS(WNWSSE|EEE(S|NWNENESE(SWEN|)NNNWNENNESENNN(WSWW(NNE(S|EE)|SSWSSS(WNNNWSSWNWSWW(N(E|N)|SEEEES(E|WW))|E))|EE)))|S)|W))|E)))|N)|NN)|EE)|NENWNWNNW(ESSESEWNWNNW|))|NN))))))|WWW(NNESEWNWSS|)SS(ENSW|)W(WSEWNE|)N)|W)|W)))))|N)|ESSSENESS(EE(NNWSNESS|)SE(N|S(ESSNNW|)W)|W))|E))|NNESEEN(WNEWSE|)EES(ENEE(SWS(WWSSSNNNEE|)E|E(E|N(WWW|NN)))|W)))|N(WSWENE|)ENWNNESEES(W|ESSSEEEENWWNENENESS(W|SSESS(WWW(NEEWWS|)SWSSENEE(NWES|)S(W|E)|EENEEES(SSSSWNNNNWS(NESSSSNNNNWS|)|EEEEESSSEEENWWNNEENNNESEEESESWWSWW(WW|SESWSSW(NWWSEWNEES|)SEES(SSEEEENENWWSWWNNNWNENEENN(WSWENE|)EEENNWSWNNNEENESS(WW|ESESWW(SEEENEESSW(WWSSSWNNNWWSESWWW(NNESNWSS|)SS(WW(NNESNWSS|)S|EEN(W|ESSSW(N|SWSWS(WNWWEESE|)ESSESESSE(SWWW(NWNE(ES|NWNN)|SSSESENE(EEENSWWW|)(NWWNEE|SSS))|ENNNW(WNNW(S|NENENEEESSE(NE(NWNNESESEE(S(S|WW)|NEENWWW(S|WNWNEESENENEEE(SSSS(SEEE(NWWEES|)SW(S|WW)|WNNW(NEWS|)W)|NWWNNE(EE(SWWEEN|)E|NWWSWWWW(N(EEE|WWNW(WNENNNENWWSSW(WNWSWNWSWS(WS(ESNW|)WWNWNNNESENNEES(EENENNWNN(NNWWWWNNW(NEEN(W|EESWSS(WNSE|)EEN(NNEWSS|)W)|SSSSWWNWSSSWWWSWNNWNENWWWWSSWNWSWNWWWNNNNEEENNEEESEEEESEENWNWWNNNE(EESS(WNWSNESE|)E(N|S(SSSES(EESNWW|)WWNWWWNWWSWNWW(NEWS|)SES(WS(E|WNWW(SE|NEE))|EEE(EEESEESWWSEE(WWNEENSWWSEE|)|N))|W))|NWWSSWWWS(EEESWENWWW|)WWNNNNWSSSWSESWWS(WW(SSE(N|SWSSE(SWW(NNN|SESESS(EENWNENW(NEESESEEN(ESSENEE(SWSEESWWSWNWSWSWSW(S(S|EEEN(W|NEEEEN(W|EESENES(ENNNWSWWNN(E(EEN(NNEEENNEEESWWSEESS(WNWSWNWSW(SEWN|)N|E|S)|WWW)|S)|W(SS|W))|SWWW(N|WSEEEESWWWWWNW(N(WSNE|)E|S))))))|NW(NEENEN(EE|NWSWSWNN(E|N))|S))|NWNNWSS(NNESSEWNNWSS|))|W)|W)|WWW(SES(ENEWSW|)SS|NN(ESEWNW|)NNWSSSW(SEWN|)NWW(S(E|W(S|WWN(WWNEEN|EE)))|NNEESW))))|N))|NENWWNNNNENNWNWNN(WSSSSWWNWN(EESNWW|)(N|WSWWSSENEESWSWSSW(WSWS(SWNN(N(E|N)|WSSS(S|WWWNENE(NWW(S|W)|S)))|EENEENNESSS(EENWNNENW(NEESSS(S(ENNNNN(N|E)|S)|W)|W)|S|WW))|NN))|ESENESS(W|SSSSWSES(W|E(S|NNE(S|NNENNEESS(WNSE|)SEENWNNNNWNNWNNENESENEEESS(ENNNE(SSS|NNNENNESSEENWNENENENWN(WSSW(NN|SWWWWSS(ENSW|)SWWNWWWSWSWSS(WS(E|WNWWSWNWSS(SENESSENESSW(WWNWSNESEE|)SEEE(S(E|WWSSW(NN|SS))|NWNNNWWN(SEESSSNNNWWN|))|WWNENNN(W(W|SS)|NEENW(NE(EESSW(N|SS(WNWSNESE|)EEENNENNWNW(NEESES(E(NNWESS|)EEEE(NWES|)S|S)|SS(SSWENN|)E))|N)|W))))|EEN(NESSEENN(W(NWES|)S|ES(ENSW|)S)|W)))|ENWNEE(NWWNW(NENSWS|)W|EESSESWWSW(NNNESNWSSS|)SESS(ENNNEWSSSW|)WWN(WSNE|)(E|N))))|WW(NEWS|)SSW(SEESSWS(WNNEWSSE|)ESWS(SWWWS(EEE|S)|EENNEE(SWSNEN|)NWN(W(NNNWSNESSS|)S|E))|NNW(W|SS)))))))))|EE)))|EES(E(EENWWEESWW|)SSSW(NN|S(ESNW|)W)|W))|WS(E|SW(S|W)))|EE)|S(E|S))|S))|SSS(ENNESSENENW(ESWSWNSENENW|)|WSWNWSSSE(NEWS|)SWWWNE))))))|S)|SWWS(WWNNE(ENWESW|)S|S(ENSW|)S)))|SS)))))|N)|N))|WW)|NNE(E|S)))))))|S)|S)|S)))|EE)|W(N|WWWSSENESE(SWWSWSW(NWNE(NNWNW(NEN(WNNW(NNEEE(N(NEWS|)W|SW(W|SS))|W)|ES(E|S))|SS(E|SSS(WWWW(SEEEWWWN|)NWNW(NNESEEEE(SSWNW(S|W)|NNWSWW)|S)|E)))|E)|SESS(WNSE|)ENENWNEE(NWES|)S)|N)))|N)|EE))|E)))))|E)|ESSWS(W(WSNE|)N|E))|E)|ENEENNWSWNNENENWWNENWWWW(NNESEEEEEE(ESSSSSENENNESSEENWNENN(ESESWSEEEEE(SWWSWWW(NEEWWS|)SEESWWWSES(ENEEES(WW|ENE(NEWS|)S)|WWNWNENWN(EESNWW|)WSSSWS(EE|WNNENWWNNW(NENWWNEE(WWSEESNWWNEE|)|S(W|SSSS(ENNSSW|)WW))))|NNWWN(ENE(NWES|)SES(E|S)|W(SSEEWWNN|)W))|WWWWS(EEE|SS))|NWWN(EE|WWS(E|WNNW(NN(WW|EES(W|E(SWEN|)NNNE(SSENSWNN|)N(N(EE|NN)|WWWW)))|S))))|SESE(N|S(SWNSEN|)E))))|SSEEENN(SSWWWNSEEENN|))|ENNWN(E|NNW(NEE(EE|NWWNEENNE(NNWNENWN(E|WSWSESS(W(SESWENWN|)WWNE(E|NW(NE|WSS))|E))|S))|WS(W|E)))))|NWNN(ESNW|)NWWWSEESWWWN(SEEENWESWWWN|))))|SENEEENNEESWSESWSSSSEE(SWSESWWNNWW(SEWN|)WNEENWNWSW(SS|NN(EEE(NWWEES|)S|WWW(NEWS|)W))|NNENESESS(WWNEWSEE|)ENESSENNENNWNENNWSWWSS(SE(E|NN)|WNNNEENWWWWNNENWW(NNEN(NNESSENNNWWWWNNW(S|NENWNEESESESWS(WNNSSE|)EENESSSSESWSWS(W(W|N)|SENEEN(NESEEESESWSEESENNEESEEENENWNWNWNNWNWSWWWSWWNENENWNNENEEESSE(NNNNN(WSWS(WWWSWSWWWSSESWW(SEEE(S(SEEEES(W|S(S|EENNE(NWW(SS|W)|SSE(ESWENW|)N)))|WW)|NNN(ESSNNW|)W)|NNNWNNWW(SESNWN|)NW(NENWNNN(WSWNWSSEESWSESWWNWN(E|NWWWNEEENWWWWWNNNN(WWWWNN(ESEEEWWWNW|)WWSWNNNNE(NNWWNWWWWWS(ES(W|SESENESSE(S(WWNWESEE|)SSEEE(SEESWWWW(NEWS|)SSSENESSENNEN(ENE(NWES|)SSWSWSEENESSWSEEEN(WNNSSE|)ESE(SESSWW(N(E|NWWWWWNNWWWWSS(ENEESW|WNW(SS(W(SESWSSENES(NWSWNNSSENES|)|WWWNEEE(WWWSEEWWNEEE|))|E)|NNE(S|E))))|S(WSWNSENE|)EE)|N)|WWW)|N)|NNN(E|WWN(WSNE|)E)))|WWN(WWW|NE(EENNEENESENENWNNESEEEESSSESSWSSE(SWWW(S|NNE(S|NWNE(NWW(NEENWW|WSWWWWSEEEEE(SWEN|)N)|E)))|NENNNE(NWNNNE(SS|EEENENENEENWWNWNWWNN(EEES(SEES(E(SSS(ENESE(N|ESE(SESSEESESS(WWWNE(E|NWWNW(SSESS(WNWWS(WW(NNE(EE|S)|WWSSE(SWEN|)N)|ES(WSNE|)EE)|EE)|N(E|NW(WNEWSE|)S)))|ENNNWNWN(WSNE|)NESESENESEES(WWWSSSSWSES(SE(E|N)|W)|ENNWWN(W|NE(S|N(NEWS|)W))))|N))|WWSWSW)|NENWWNNW(WW|SS))|W)|WW)|WSW(N|SSSWNNWSSSESES(EENNW(NN(EES(W|S(ENSW|)S)|N)|S|W)|WWWN(NWNWSSSE(N|S(EESSSNNNWW|)WWNNWSWWNWNN(WWSSSSSW(NN|S(WNWESE|)S(SSWWEENN|)EEN(W|EENWWNN(ESEWNW|)NN))|ESE(S|EENNNEEE(S(WW|S)|N(EE|WWWNNWSSSSSWNWW(EESENNSSWNWW|))))))|E)))))|SESS(WN|ES)))|S)))|SS)|EESSSWNN(SSENNNSSSWNN|)))|ESENEEE(NE(N|S)|SWWSSSW(NNWESS|)SEE(NNNESNWSSS|)SSEEENENEEENWNEES(NWWSESNWNEES|)))|S))|E)|EE(SWSNEN|)N(W|N))|S(WWSWNN(ENWESW|)W|ESEESS(WNSE|)SENEE(NWWNN(WW|NESE(SW|NE))|SWS(SE(SWSSESWSESSSENENENESEEEEEE(SWWSWSESWWNWWSSSEESEE(NN(W(WWNSEE|)S|ENNNES)|SWSWWSESES(SS(WNNWWN(E|WSWNNWSWNWWNNWNNNWNNNNESESE(NNWN(E|WWWSSSWWWWNWNWNNEN(WWW(SSE(SSESSWW(SWSES(WW|ESENEESENNNN(EESSE(SE(N|SSSSE(NN|ESWSSESWWNWWWWWNNWNNW(SWSESWSESWSWSEENEEEESSSW(SSSSEENEESESSWWN(E|WWS(WWN(E|W(NENNSSWS|)SSWNWSSE(WNNESEWNWSSE|))|SE(ESSW(SSENESESSENEEEEE(NNWWWS(EE|WWNNNWS(WNNEEESENNWNNNNNEEENWWNENNESEE(NWNENENWWSWSWNWNW(W|SSESSWWWSEESWWSESS(WNWWNENNWSW(NNEN(NW(S|WWWWNN)|E(EEE|S))|SWS(S|E))|SSS)|N(EESEWNWW|)N)|SW(SEEESWWWSWSSSSW(NWNNE(NWES|)S|SEES(EENWNWNNEE(S(S|W)|NN(WSWENE|)E)|SWNWSWWS(NEENESNWSWWS|)))|W))|S))|SWWWWSWW(EENEEEWWWSWW|))|N)|N))|N)|NNWSWN)|NE(EESENNN(ESSE(SSSESWWNN(N|WW(WN|SESW))|N)|NN)|N))))|NN)|WSSWN(WWSEWNEE|)NN))|N(E|NN))|N)|NE(EE|NNNWSW(N|S(E|WNWSWWS(W|EEEESW)))))|ESENESSE(SSWNW(S|WN(E|W))|NENN(W(WNSE|)S|EEE(SWS(WNSE|)E|N)))))|SSW(NWNSES|)SSENESENNWNEN(W|EE(N(NEES(ENEWSW|)W|W)|SWSSE(SSS(SENNE(NWES|)E|WN(N|WSWWNE))|N)))))|S)|ENN(ESNW|)(W|N)))|NNWWNN(EES(ESENNWNNES(NWSSESNWNNES|)|W)|WWN(E|W(NEWS|)SWWWSEEES(ENESS(EE|WW)|WWWW(S(S|E)|NN(W|N))))))|N)|W)|E)))|W)))|W)|SWSESSSS(SWSSNNEN|)ENE(NWES|)S))))))|S)))|N)|E))|ES(ENSW|)W))))|ENNWNEEENNN(W(SSWENN|)N|EESSW(N|SSWSW(N|SEENESENNWNENNEN(ESSWSESWSSENEEES(WW|ENEENWNENEENEE(SSSSWWW(S(EEE|WW)|NEEN(WW|N))|NWNNNNNNNNWWSESSSSSWSWSWNWNEENENNNWNNNWSWSESSS(ENSW|)WS(WWSSSE(ESS(ENEENEN(SWSWWSNEENEN|)|SWS(E|WNNW(N(EESNWW|)NNNWW(SEWN|)N(W|NNNEENNW(NNENEEENWWWN(WSSNNE|)EENNNNNW(NEESEENWNNE(EEENESSSWWN(E|W(W|SSEEESWWSSWSSESENN(W|E(NWNEWSES|)SSSSWNWWWN(E|W(SS(EEES(EESSSSSSSS(NNNNNNNNWESSSSSSSS|)|W)|WSWW(NEWS|)(W|SESSESWW(NN|S(E|WNWSSE))))|NENWW(NENN(WSNE|)ES(ENSW|)S|S))))))|NWW(WSESWENWNE|)NN)|SSSS)|SWW(NEWS|)S))|SS)))|NN)|E)))|W))))))|N)|EEE(NWES|)E)|NNNWSS))|W))|N)|N)|N(W|NN))|N)|ENE(N(NWSNES|)E|S))))|NN)))))))|NNNWS(S|WWWWNN))|S)))|WS(W|S))|NN(WNWSS(E|WS(SSW(SESNWN|)WNWNNE(NWNWSSSWSWWSSS(WNWN(ENNNENEE(SWSWENEN|)NWN(W(SW(WN(E|WWWSSS(ENNEWSSW|)WWWS(SWNWNNE(S|EEN(WWWNWN(N|E|WSW(SESE(N|SWWNWNWW(N(NWNEWSES|)EE|SSE(N|ES(WWSEWNEE|)EE(E|S))))|N))|E(S|N)))|E))|S)|N)|EENNE(E|SS|NWNNWNNN(ESSE|WSS)))|WSS(SWSEWNEN|)E)|ENEN(W|E(SSWENN|)(E|N)))|SE(S|N))|E))|E)))))|E)|E)|E)|EEEEE)|EEEE(NWNSES|)SSW(NWWEES|)SEENESE(SWWSSWNWN(WSNE|)E|E(NWES|)E))|S)|S)))|SSSEEESE(N|ES(S|WWWNW(WWNNNWW(EESSSEWNNNWW|)|S))))))|N))|N)))))|W)|WW)))|SES(ESSS(WNNSSE|)ES(WSEWNE|)E|W))|SSWS(W(N|S)|E)))))|N|E))|W)|WWNENWNEEEE(SWWEEN|)N(NESEEN(EN(EES(ESESSSENNESENNWN(EESE(NNWESS|)SSESWW(NN|WW)|W(WNWNEWSESE|)S)|W)|NW(S|N))|W)|W)))|S)|WWWW)|WSSWWNWSW(NNEEES|S(S|E)))|WN(W|NNN))))|S)))|ENEESWS(NENWWSNEESWS|)))|EE))|W)|E)|E)|W)))|SS)|S))))|W(NENEWSWS|)WWSWWS(SS|E)))|E)|ES(ENE(S|E)|W)))|N|E)|E)))|N)|ENNESE)|E)|N)|N)|N(N|E))|N)))))|S))|W)|E)))|ENEES(ENNWWNN(ESEE(NWES|)SSSEEESWSESSSS(WNNNW(S|NN)|ENE(SSW(W|SS)|NNEN(ESNW|)WN(E|W(NENSWS|)SSS)))|W)|W))))|S)$");
        assert result == 8475 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        pattern = Pattern.compile(s);
        return bfs(new Point(0, 0));
    }

    private static int bfs(Point startPoint) {
        Map<Point, String> closed = new HashMap<>();
        Map<Point, String> opened = new HashMap<>();

        opened.put(startPoint, "");

        while (opened.size() > 0) {
            Map<Point, String> achievable = new HashMap<>(opened);
            for (Point point : achievable.keySet()) {
                Set<Point> next = nextPoints(point, opened.get(point));
                for (Point nextPoint : next) {
                    if (!opened.containsKey(nextPoint) && !closed.containsKey(nextPoint)) {
                        String nextPointPath = opened.get(point) + delta(point, nextPoint);
                        opened.put(nextPoint, nextPointPath);
                    }
                }
                String path = opened.get(point);
                closed.put(point, opened.get(point));
                opened.remove(point);
            }
        }

        int count = 0;
        for (Map.Entry<Point, String> entry : closed.entrySet()) {
            if (entry.getValue().length() >= 1000) {
                ++count;
            }
        }
        return count;
    }

    private static Character delta(Point from, Point to) {
        int dx = to.x - from.x, dy = to.y - from.y;
        return directions.get(new Point(dx, dy));
    }

    private static Set<Point> nextPoints(Point point, String acc) {
        Set<Point> nextPoints = new HashSet<>();
        for (Point deltaPoint : directions.keySet()) {
            int dx = deltaPoint.x;
            int dy = deltaPoint.y;
            Point nextPoint = new Point(point.x + dx, point.y + dy);
            String newAcc = acc + directions.get(deltaPoint);
            Matcher matcher = pattern.matcher(newAcc);
            boolean matches = matcher.matches() || matcher.hitEnd();
            if (matches) {
                nextPoints.add(nextPoint);
            }
        }
        return nextPoints;
    }
}