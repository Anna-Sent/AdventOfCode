package advent.advent2018;

import utils.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day10 {
    public static void main(String[] args) {
        int result;

        result = test("position=< 9,  1> velocity=< 0,  2>\n" +
                "position=< 7,  0> velocity=<-1,  0>\n" +
                "position=< 3, -2> velocity=<-1,  1>\n" +
                "position=< 6, 10> velocity=<-2, -1>\n" +
                "position=< 2, -4> velocity=< 2,  2>\n" +
                "position=<-6, 10> velocity=< 2, -2>\n" +
                "position=< 1,  8> velocity=< 1, -1>\n" +
                "position=< 1,  7> velocity=< 1,  0>\n" +
                "position=<-3, 11> velocity=< 1, -2>\n" +
                "position=< 7,  6> velocity=<-1, -1>\n" +
                "position=<-2,  3> velocity=< 1,  0>\n" +
                "position=<-4,  3> velocity=< 2,  0>\n" +
                "position=<10, -3> velocity=<-1,  1>\n" +
                "position=< 5, 11> velocity=< 1, -2>\n" +
                "position=< 4,  7> velocity=< 0, -1>\n" +
                "position=< 8, -2> velocity=< 0,  1>\n" +
                "position=<15,  0> velocity=<-2,  0>\n" +
                "position=< 1,  6> velocity=< 1,  0>\n" +
                "position=< 8,  9> velocity=< 0, -1>\n" +
                "position=< 3,  3> velocity=<-1,  1>\n" +
                "position=< 0,  5> velocity=< 0, -1>\n" +
                "position=<-2,  2> velocity=< 2,  0>\n" +
                "position=< 5, -2> velocity=< 1,  2>\n" +
                "position=< 1,  4> velocity=< 2,  1>\n" +
                "position=<-2,  7> velocity=< 2, -2>\n" +
                "position=< 3,  6> velocity=<-1, -1>\n" +
                "position=< 5,  0> velocity=< 1,  0>\n" +
                "position=<-6,  0> velocity=< 2,  0>\n" +
                "position=< 5,  9> velocity=< 1, -2>\n" +
                "position=<14,  7> velocity=<-2,  0>\n" +
                "position=<-3,  6> velocity=< 2, -1>");
        assert result == 3 : "unexpected result is " + result;
        System.out.println(result);

        result = test("position=< 52484, -20780> velocity=<-5,  2>\n" +
                "position=<-52068,  31483> velocity=< 5, -3>\n" +
                "position=< 21120,  52398> velocity=<-2, -5>\n" +
                "position=<-10264, -31236> velocity=< 1,  3>\n" +
                "position=< 52501,  52392> velocity=<-5, -5>\n" +
                "position=<-31144,  52394> velocity=< 3, -5>\n" +
                "position=<-41603,  21031> velocity=< 4, -2>\n" +
                "position=<-41630, -31239> velocity=< 4,  3>\n" +
                "position=< 21126, -20780> velocity=<-2,  2>\n" +
                "position=<-31150, -10326> velocity=< 3,  1>\n" +
                "position=<-41598,  21033> velocity=< 4, -2>\n" +
                "position=<-10252, -20787> velocity=< 1,  2>\n" +
                "position=<-20677, -52149> velocity=< 2,  5>\n" +
                "position=< 21102, -31236> velocity=<-2,  3>\n" +
                "position=<-20734,  41942> velocity=< 2, -4>\n" +
                "position=< 42018, -41696> velocity=<-4,  4>\n" +
                "position=<-52071, -41691> velocity=< 5,  4>\n" +
                "position=<-20720, -41693> velocity=< 2,  4>\n" +
                "position=<-20710,  10574> velocity=< 2, -1>\n" +
                "position=< 31540,  10578> velocity=<-3, -1>\n" +
                "position=< 31581, -41693> velocity=<-3,  4>\n" +
                "position=< 31540,  10576> velocity=<-3, -1>\n" +
                "position=<-31184,  31490> velocity=< 3, -3>\n" +
                "position=<-31168, -41689> velocity=< 3,  4>\n" +
                "position=<-41641,  10575> velocity=< 4, -1>\n" +
                "position=<-41590,  41940> velocity=< 4, -4>\n" +
                "position=<-31179, -41695> velocity=< 3,  4>\n" +
                "position=<-10232,  31481> velocity=< 1, -3>\n" +
                "position=< 42012,  31481> velocity=<-4, -3>\n" +
                "position=<-31192,  31486> velocity=< 3, -3>\n" +
                "position=< 10685,  21029> velocity=<-1, -2>\n" +
                "position=< 31535, -41692> velocity=<-3,  4>\n" +
                "position=< 31561,  41942> velocity=<-3, -4>\n" +
                "position=<-20719,  31481> velocity=< 2, -3>\n" +
                "position=< 42007,  10581> velocity=<-4, -1>\n" +
                "position=<-20726,  21027> velocity=< 2, -2>\n" +
                "position=<-31136,  21034> velocity=< 3, -2>\n" +
                "position=< 10680, -31241> velocity=<-1,  3>\n" +
                "position=< 31559,  21027> velocity=<-3, -2>\n" +
                "position=< 21088, -20780> velocity=<-2,  2>\n" +
                "position=< 52472,  41939> velocity=<-5, -4>\n" +
                "position=< 21126, -41692> velocity=<-2,  4>\n" +
                "position=<-10268,  41937> velocity=< 1, -4>\n" +
                "position=< 31551,  52393> velocity=<-3, -5>\n" +
                "position=<-52097,  10578> velocity=< 5, -1>\n" +
                "position=<-52087, -52145> velocity=< 5,  5>\n" +
                "position=<-10223,  21034> velocity=< 1, -2>\n" +
                "position=< 52483, -20785> velocity=<-5,  2>\n" +
                "position=< 10660, -20780> velocity=<-1,  2>\n" +
                "position=< 10648, -41694> velocity=<-1,  4>\n" +
                "position=< 41988, -31239> velocity=<-4,  3>\n" +
                "position=< 42010, -52149> velocity=<-4,  5>\n" +
                "position=< 52440, -10327> velocity=<-5,  1>\n" +
                "position=< 41991,  41943> velocity=<-4, -4>\n" +
                "position=< 10636, -52142> velocity=<-1,  5>\n" +
                "position=<-52071, -52146> velocity=< 5,  5>\n" +
                "position=< 10672, -31237> velocity=<-1,  3>\n" +
                "position=<-52095,  31484> velocity=< 5, -3>\n" +
                "position=< 31568, -41688> velocity=<-3,  4>\n" +
                "position=<-10236, -10331> velocity=< 1,  1>\n" +
                "position=<-52095,  21031> velocity=< 5, -2>\n" +
                "position=<-31187,  21027> velocity=< 3, -2>\n" +
                "position=< 31577,  21036> velocity=<-3, -2>\n" +
                "position=<-10284, -20784> velocity=< 1,  2>\n" +
                "position=<-10271, -20783> velocity=< 1,  2>\n" +
                "position=< 10650, -10335> velocity=<-1,  1>\n" +
                "position=<-20706, -41694> velocity=< 2,  4>\n" +
                "position=< 10636,  31490> velocity=<-1, -3>\n" +
                "position=<-41590,  21028> velocity=< 4, -2>\n" +
                "position=< 52480, -52142> velocity=<-5,  5>\n" +
                "position=<-52050, -31239> velocity=< 5,  3>\n" +
                "position=<-31183, -10326> velocity=< 3,  1>\n" +
                "position=< 42038,  52393> velocity=<-4, -5>\n" +
                "position=<-31176,  31486> velocity=< 3, -3>\n" +
                "position=<-10276,  10581> velocity=< 1, -1>\n" +
                "position=<-31168, -31236> velocity=< 3,  3>\n" +
                "position=< 41986, -52151> velocity=<-4,  5>\n" +
                "position=< 10656,  52398> velocity=<-1, -5>\n" +
                "position=< 42046,  52393> velocity=<-4, -5>\n" +
                "position=<-31139,  41936> velocity=< 3, -4>\n" +
                "position=< 41991, -20786> velocity=<-4,  2>\n" +
                "position=<-10243,  21033> velocity=< 1, -2>\n" +
                "position=<-41641,  31488> velocity=< 4, -3>\n" +
                "position=<-52095,  21032> velocity=< 5, -2>\n" +
                "position=<-20728,  31490> velocity=< 2, -3>\n" +
                "position=<-31163, -31237> velocity=< 3,  3>\n" +
                "position=< 41999,  52392> velocity=<-4, -5>\n" +
                "position=<-10279,  31485> velocity=< 1, -3>\n" +
                "position=<-10275,  31481> velocity=< 1, -3>\n" +
                "position=< 52484,  21030> velocity=<-5, -2>\n" +
                "position=< 31537, -20785> velocity=<-3,  2>\n" +
                "position=< 52493, -52148> velocity=<-5,  5>\n" +
                "position=< 21129, -52147> velocity=<-2,  5>\n" +
                "position=<-10241,  52398> velocity=< 1, -5>\n" +
                "position=<-10279,  31489> velocity=< 1, -3>\n" +
                "position=< 52496, -10330> velocity=<-5,  1>\n" +
                "position=< 10651, -41692> velocity=<-1,  4>\n" +
                "position=< 52480, -10326> velocity=<-5,  1>\n" +
                "position=<-41596,  41939> velocity=< 4, -4>\n" +
                "position=<-31174, -52151> velocity=< 3,  5>\n" +
                "position=< 42014, -41692> velocity=<-4,  4>\n" +
                "position=< 41986, -10334> velocity=<-4,  1>\n" +
                "position=< 10656, -20781> velocity=<-1,  2>\n" +
                "position=< 31564,  41935> velocity=<-3, -4>\n" +
                "position=<-20717, -20787> velocity=< 2,  2>\n" +
                "position=< 31540, -20789> velocity=<-3,  2>\n" +
                "position=<-10265, -41692> velocity=< 1,  4>\n" +
                "position=<-10260,  41940> velocity=< 1, -4>\n" +
                "position=<-10247, -10326> velocity=< 1,  1>\n" +
                "position=< 21094, -10328> velocity=<-2,  1>\n" +
                "position=<-41646, -52142> velocity=< 4,  5>\n" +
                "position=<-10284,  52395> velocity=< 1, -5>\n" +
                "position=< 21086,  52394> velocity=<-2, -5>\n" +
                "position=< 52500, -31239> velocity=<-5,  3>\n" +
                "position=<-20689, -41697> velocity=< 2,  4>\n" +
                "position=<-41636,  52389> velocity=< 4, -5>\n" +
                "position=< 42026,  41943> velocity=<-4, -4>\n" +
                "position=< 31549, -31239> velocity=<-3,  3>\n" +
                "position=< 52488,  52398> velocity=<-5, -5>\n" +
                "position=< 21086, -52145> velocity=<-2,  5>\n" +
                "position=< 31573, -31237> velocity=<-3,  3>\n" +
                "position=< 21139,  10573> velocity=<-2, -1>\n" +
                "position=<-31188, -20781> velocity=< 3,  2>\n" +
                "position=< 52488,  21035> velocity=<-5, -2>\n" +
                "position=<-10273,  52398> velocity=< 1, -5>\n" +
                "position=<-41642,  10581> velocity=< 4, -1>\n" +
                "position=< 42034, -10328> velocity=<-4,  1>\n" +
                "position=<-31187,  31489> velocity=< 3, -3>\n" +
                "position=< 41994, -10328> velocity=<-4,  1>\n" +
                "position=< 21110, -41692> velocity=<-2,  4>\n" +
                "position=< 41994, -31236> velocity=<-4,  3>\n" +
                "position=< 31532, -41692> velocity=<-3,  4>\n" +
                "position=<-41645, -41696> velocity=< 4,  4>\n" +
                "position=<-41617, -52148> velocity=< 4,  5>\n" +
                "position=< 42027,  21036> velocity=<-4, -2>\n" +
                "position=<-10268,  21029> velocity=< 1, -2>\n" +
                "position=<-41614, -20785> velocity=< 4,  2>\n" +
                "position=< 21097, -31238> velocity=<-2,  3>\n" +
                "position=< 10645,  10575> velocity=<-1, -1>\n" +
                "position=<-10243,  41944> velocity=< 1, -4>\n" +
                "position=< 21118,  21034> velocity=<-2, -2>\n" +
                "position=< 41994, -41691> velocity=<-4,  4>\n" +
                "position=< 21083, -31240> velocity=<-2,  3>\n" +
                "position=<-41596,  52389> velocity=< 4, -5>\n" +
                "position=<-31172, -10328> velocity=< 3,  1>\n" +
                "position=< 52464,  41944> velocity=<-5, -4>\n" +
                "position=<-31176,  52398> velocity=< 3, -5>\n" +
                "position=< 10669, -10326> velocity=<-1,  1>\n" +
                "position=<-31172, -10328> velocity=< 3,  1>\n" +
                "position=< 10653,  41940> velocity=<-1, -4>\n" +
                "position=<-10242, -20784> velocity=< 1,  2>\n" +
                "position=<-10279, -31234> velocity=< 1,  3>\n" +
                "position=< 21134,  10573> velocity=<-2, -1>\n" +
                "position=<-31160, -31239> velocity=< 3,  3>\n" +
                "position=< 21126,  41935> velocity=<-2, -4>\n" +
                "position=<-41617,  31485> velocity=< 4, -3>\n" +
                "position=<-10279,  10574> velocity=< 1, -1>\n" +
                "position=< 10672,  21027> velocity=<-1, -2>\n" +
                "position=< 42022, -20780> velocity=<-4,  2>\n" +
                "position=<-52100,  10573> velocity=< 5, -1>\n" +
                "position=<-52052, -20788> velocity=< 5,  2>\n" +
                "position=< 52461,  31489> velocity=<-5, -3>\n" +
                "position=< 10672,  10577> velocity=<-1, -1>\n" +
                "position=< 21094, -10334> velocity=<-2,  1>\n" +
                "position=<-52074, -31238> velocity=< 5,  3>\n" +
                "position=<-10249,  10582> velocity=< 1, -1>\n" +
                "position=< 52480, -31235> velocity=<-5,  3>\n" +
                "position=< 42042,  10582> velocity=<-4, -1>\n" +
                "position=< 52496,  31481> velocity=<-5, -3>\n" +
                "position=<-31136,  10578> velocity=< 3, -1>\n" +
                "position=<-52095, -41695> velocity=< 5,  4>\n" +
                "position=< 52460,  21027> velocity=<-5, -2>\n" +
                "position=< 21107, -41695> velocity=<-2,  4>\n" +
                "position=<-52051, -52147> velocity=< 5,  5>\n" +
                "position=< 31564,  31487> velocity=<-3, -3>\n" +
                "position=< 52481, -31237> velocity=<-5,  3>\n" +
                "position=<-20722, -31241> velocity=< 2,  3>\n" +
                "position=<-20735, -41692> velocity=< 2,  4>\n" +
                "position=<-52079,  52390> velocity=< 5, -5>\n" +
                "position=< 41994, -52142> velocity=<-4,  5>\n" +
                "position=< 52497, -20785> velocity=<-5,  2>\n" +
                "position=<-41638,  10577> velocity=< 4, -1>\n" +
                "position=<-31175, -20789> velocity=< 3,  2>\n" +
                "position=<-20719,  21031> velocity=< 2, -2>\n" +
                "position=< 52460,  52389> velocity=<-5, -5>\n" +
                "position=<-31136, -31237> velocity=< 3,  3>\n" +
                "position=< 21086,  52397> velocity=<-2, -5>\n" +
                "position=<-52084,  21027> velocity=< 5, -2>\n" +
                "position=< 41994, -41694> velocity=<-4,  4>\n" +
                "position=<-20706,  31486> velocity=< 2, -3>\n" +
                "position=<-20682, -52147> velocity=< 2,  5>\n" +
                "position=< 41999,  41942> velocity=<-4, -4>\n" +
                "position=< 41994, -52151> velocity=<-4,  5>\n" +
                "position=< 41986,  41943> velocity=<-4, -4>\n" +
                "position=<-20738, -20788> velocity=< 2,  2>\n" +
                "position=< 52464, -20780> velocity=<-5,  2>\n" +
                "position=< 31543,  31485> velocity=<-3, -3>\n" +
                "position=< 52448, -10334> velocity=<-5,  1>\n" +
                "position=<-20713,  31486> velocity=< 2, -3>\n" +
                "position=< 21099,  10576> velocity=<-2, -1>\n" +
                "position=< 52440,  31490> velocity=<-5, -3>\n" +
                "position=< 52441, -31241> velocity=<-5,  3>\n" +
                "position=< 42002, -52147> velocity=<-4,  5>\n" +
                "position=< 52469,  31483> velocity=<-5, -3>\n" +
                "position=< 10658, -41688> velocity=<-1,  4>\n" +
                "position=<-10273,  21031> velocity=< 1, -2>\n" +
                "position=<-52083, -10331> velocity=< 5,  1>\n" +
                "position=<-52044, -31234> velocity=< 5,  3>\n" +
                "position=< 21110,  31482> velocity=<-2, -3>\n" +
                "position=<-41590, -52145> velocity=< 4,  5>\n" +
                "position=<-20689,  10577> velocity=< 2, -1>\n" +
                "position=< 31593, -41697> velocity=<-3,  4>\n" +
                "position=< 10673,  41935> velocity=<-1, -4>\n" +
                "position=<-20677, -10331> velocity=< 2,  1>\n" +
                "position=< 52469,  41940> velocity=<-5, -4>\n" +
                "position=< 31593, -31242> velocity=<-3,  3>\n" +
                "position=< 52467, -41697> velocity=<-5,  4>\n" +
                "position=< 42007,  10582> velocity=<-4, -1>\n" +
                "position=<-31173, -41692> velocity=< 3,  4>\n" +
                "position=< 21083,  21032> velocity=<-2, -2>\n" +
                "position=<-20730,  41939> velocity=< 2, -4>\n" +
                "position=< 31574, -10335> velocity=<-3,  1>\n" +
                "position=< 21139, -52143> velocity=<-2,  5>\n" +
                "position=<-52099, -52150> velocity=< 5,  5>\n" +
                "position=<-10252,  52398> velocity=< 1, -5>\n" +
                "position=< 42047,  21029> velocity=<-4, -2>\n" +
                "position=< 42030,  31484> velocity=<-4, -3>\n" +
                "position=<-10268, -41697> velocity=< 1,  4>\n" +
                "position=< 21080,  31484> velocity=<-2, -3>\n" +
                "position=< 41997,  41935> velocity=<-4, -4>\n" +
                "position=< 10653, -41693> velocity=<-1,  4>\n" +
                "position=< 21089, -52142> velocity=<-2,  5>\n" +
                "position=< 10652,  31486> velocity=<-1, -3>\n" +
                "position=< 21107, -52145> velocity=<-2,  5>\n" +
                "position=<-20718, -10335> velocity=< 2,  1>\n" +
                "position=< 21094,  41941> velocity=<-2, -4>\n" +
                "position=< 21097,  41935> velocity=<-2, -4>\n" +
                "position=< 10624, -20785> velocity=<-1,  2>\n" +
                "position=< 21078, -10328> velocity=<-2,  1>\n" +
                "position=< 52464,  41938> velocity=<-5, -4>\n" +
                "position=< 42006,  21031> velocity=<-4, -2>\n" +
                "position=< 10675, -20789> velocity=<-1,  2>\n" +
                "position=<-20677,  52396> velocity=< 2, -5>\n" +
                "position=<-52095,  52396> velocity=< 5, -5>\n" +
                "position=< 21079, -10333> velocity=<-2,  1>\n" +
                "position=<-41589,  10577> velocity=< 4, -1>\n" +
                "position=< 31556, -41691> velocity=<-3,  4>\n" +
                "position=< 31545,  31482> velocity=<-3, -3>\n" +
                "position=< 10644,  31487> velocity=<-1, -3>\n" +
                "position=<-20706, -41690> velocity=< 2,  4>\n" +
                "position=<-10266,  31481> velocity=< 1, -3>\n" +
                "position=< 21087, -41693> velocity=<-2,  4>\n" +
                "position=<-10239, -41695> velocity=< 1,  4>\n" +
                "position=<-52090,  21031> velocity=< 5, -2>\n" +
                "position=<-10236,  10578> velocity=< 1, -1>\n" +
                "position=<-10236,  41942> velocity=< 1, -4>\n" +
                "position=< 21086,  31483> velocity=<-2, -3>\n" +
                "position=<-31176, -10330> velocity=< 3,  1>\n" +
                "position=< 31574, -10330> velocity=<-3,  1>\n" +
                "position=<-41598,  31482> velocity=< 4, -3>\n" +
                "position=<-52087, -52144> velocity=< 5,  5>\n" +
                "position=< 21090, -31243> velocity=<-2,  3>\n" +
                "position=<-20695, -41693> velocity=< 2,  4>\n" +
                "position=< 31574, -41692> velocity=<-3,  4>\n" +
                "position=<-10240, -52148> velocity=< 1,  5>\n" +
                "position=< 42042,  31481> velocity=<-4, -3>\n" +
                "position=< 41986,  31481> velocity=<-4, -3>\n" +
                "position=< 52484, -10326> velocity=<-5,  1>\n" +
                "position=< 31593, -10330> velocity=<-3,  1>\n" +
                "position=< 31548,  52398> velocity=<-3, -5>\n" +
                "position=<-20719,  21027> velocity=< 2, -2>\n" +
                "position=<-20697, -31243> velocity=< 2,  3>\n" +
                "position=< 10680, -20781> velocity=<-1,  2>\n" +
                "position=<-52088,  21031> velocity=< 5, -2>\n" +
                "position=<-31176,  41943> velocity=< 3, -4>\n" +
                "position=< 41996, -52147> velocity=<-4,  5>\n" +
                "position=<-31176,  41944> velocity=< 3, -4>\n" +
                "position=<-52056, -41697> velocity=< 5,  4>\n" +
                "position=< 31593,  41944> velocity=<-3, -4>\n" +
                "position=< 21099, -41695> velocity=<-2,  4>\n" +
                "position=<-20697, -31243> velocity=< 2,  3>\n" +
                "position=< 31588,  41938> velocity=<-3, -4>\n" +
                "position=<-20728,  21031> velocity=< 2, -2>\n" +
                "position=<-31149,  21027> velocity=< 3, -2>\n" +
                "position=<-10223, -10329> velocity=< 1,  1>\n" +
                "position=<-10236,  21034> velocity=< 1, -2>\n" +
                "position=< 10632, -10333> velocity=<-1,  1>\n" +
                "position=< 10680,  10581> velocity=<-1, -1>\n" +
                "position=<-41641, -41688> velocity=< 4,  4>\n" +
                "position=< 31545, -41696> velocity=<-3,  4>\n" +
                "position=<-31139,  41937> velocity=< 3, -4>\n" +
                "position=<-31189,  52395> velocity=< 3, -5>\n" +
                "position=< 42036, -10335> velocity=<-4,  1>\n" +
                "position=< 41998,  31485> velocity=<-4, -3>\n" +
                "position=<-41637, -10326> velocity=< 4,  1>\n" +
                "position=<-20682, -20787> velocity=< 2,  2>\n" +
                "position=<-10241,  31490> velocity=< 1, -3>\n" +
                "position=< 21135, -31239> velocity=<-2,  3>\n" +
                "position=< 31561, -31240> velocity=<-3,  3>\n" +
                "position=<-31192, -20786> velocity=< 3,  2>\n" +
                "position=<-10236,  41944> velocity=< 1, -4>\n" +
                "position=<-52059, -41697> velocity=< 5,  4>\n" +
                "position=<-20733, -20787> velocity=< 2,  2>\n" +
                "position=< 31540, -20781> velocity=<-3,  2>\n" +
                "position=<-52055,  10573> velocity=< 5, -1>\n" +
                "position=<-31152, -31236> velocity=< 3,  3>\n" +
                "position=< 52496, -31240> velocity=<-5,  3>\n" +
                "position=<-52052,  31484> velocity=< 5, -3>\n" +
                "position=< 52453,  41940> velocity=<-5, -4>\n" +
                "position=<-41646, -10333> velocity=< 4,  1>\n" +
                "position=< 42042,  41941> velocity=<-4, -4>\n" +
                "position=<-31131,  21036> velocity=< 3, -2>\n" +
                "position=<-10281, -52145> velocity=< 1,  5>\n" +
                "position=<-41598,  31485> velocity=< 4, -3>\n" +
                "position=<-31179, -10327> velocity=< 3,  1>\n" +
                "position=< 41988, -10332> velocity=<-4,  1>\n" +
                "position=< 52456,  41936> velocity=<-5, -4>\n" +
                "position=<-41595, -10335> velocity=< 4,  1>\n" +
                "position=< 52445,  52390> velocity=<-5, -5>\n" +
                "position=<-20693,  31483> velocity=< 2, -3>\n" +
                "position=<-41630,  31484> velocity=< 4, -3>\n" +
                "position=< 41986,  10581> velocity=<-4, -1>\n" +
                "position=<-20734,  21035> velocity=< 2, -2>\n" +
                "position=<-10223,  52395> velocity=< 1, -5>\n" +
                "position=< 42012, -31238> velocity=<-4,  3>\n" +
                "position=< 52445, -31237> velocity=<-5,  3>\n" +
                "position=< 21110, -20784> velocity=<-2,  2>\n" +
                "position=<-31179, -10328> velocity=< 3,  1>\n" +
                "position=<-10251,  41944> velocity=< 1, -4>\n" +
                "position=< 31593,  21028> velocity=<-3, -2>\n" +
                "position=<-31167, -52150> velocity=< 3,  5>\n" +
                "position=< 42003, -52151> velocity=<-4,  5>\n" +
                "position=< 52485, -10334> velocity=<-5,  1>\n" +
                "position=<-20690, -20786> velocity=< 2,  2>\n" +
                "position=< 10625, -31242> velocity=<-1,  3>\n" +
                "position=<-52087, -10332> velocity=< 5,  1>\n" +
                "position=< 10672, -20783> velocity=<-1,  2>\n" +
                "position=< 42026,  31489> velocity=<-4, -3>\n" +
                "position=< 10672,  41937> velocity=<-1, -4>\n" +
                "position=< 41995, -41697> velocity=<-4,  4>\n" +
                "position=< 31572,  31481> velocity=<-3, -3>\n" +
                "position=<-20688,  52389> velocity=< 2, -5>\n" +
                "position=<-20725,  10574> velocity=< 2, -1>\n" +
                "position=<-10260, -10328> velocity=< 1,  1>\n" +
                "position=< 10685,  21034> velocity=<-1, -2>\n" +
                "position=< 52499,  10577> velocity=<-5, -1>\n" +
                "position=< 31536,  31488> velocity=<-3, -3>\n" +
                "position=<-10260,  41941> velocity=< 1, -4>\n" +
                "position=<-52089, -20789> velocity=< 5,  2>\n" +
                "position=< 41994,  21034> velocity=<-4, -2>\n" +
                "position=< 31549, -52147> velocity=<-3,  5>\n" +
                "position=< 31564, -10328> velocity=<-3,  1>\n" +
                "position=< 10645,  41943> velocity=<-1, -4>\n" +
                "position=<-31168, -52147> velocity=< 3,  5>\n" +
                "position=<-31187,  21034> velocity=< 3, -2>\n" +
                "position=<-41598, -31241> velocity=< 4,  3>\n" +
                "position=< 10653,  21035> velocity=<-1, -2>\n" +
                "position=< 31576,  52398> velocity=<-3, -5>\n" +
                "position=<-10249,  10582> velocity=< 1, -1>\n" +
                "position=<-31136, -31240> velocity=< 3,  3>\n" +
                "position=<-20712, -52151> velocity=< 2,  5>\n" +
                "position=<-10279,  10579> velocity=< 1, -1>\n" +
                "position=< 52469, -10326> velocity=<-5,  1>\n" +
                "position=< 21103, -20784> velocity=<-2,  2>\n" +
                "position=< 21136, -20785> velocity=<-2,  2>\n" +
                "position=<-41605, -52142> velocity=< 4,  5>\n" +
                "position=< 31551, -52147> velocity=<-3,  5>");
        assert result == 10454 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        List<Position> positions;

        positions = read(s);
        int iterationCount = 0;
        int globalMinX = Integer.MAX_VALUE, globalMinY = Integer.MAX_VALUE, globalMaxX = 0, globalMaxY = 0;
        for (int second = 0; second < 15000; ++second) {
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
            for (Position position : positions) {
                position.position.x += position.velocity.x;
                position.position.y += position.velocity.y;
                minX = Math.min(minX, position.position.x);
                minY = Math.min(minY, position.position.y);
                maxX = Math.max(maxX, position.position.x);
                maxY = Math.max(maxY, position.position.y);
            }
            long area1 = area(minX, minY, maxX, maxY);
            long area2 = area(globalMinX, globalMinY, globalMaxX, globalMaxY);
            if (area1 < area2) {
                globalMinX = minX;
                globalMinY = minY;
                globalMaxX = maxX;
                globalMaxY = maxY;
                iterationCount = second;
                System.out.println("min area " + area1 + ", iteration count " + iterationCount);
            } else {
                break;
            }
        }

        positions = read(s);
        for (int second = 0; second <= iterationCount; ++second) {
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
            for (Position position : positions) {
                position.position.x += position.velocity.x;
                position.position.y += position.velocity.y;
                minX = Math.min(minX, position.position.x);
                minY = Math.min(minY, position.position.y);
                maxX = Math.max(maxX, position.position.x);
                maxY = Math.max(maxY, position.position.y);
            }
            if (second == iterationCount) {
                Set<Point> points = new HashSet<>();
                for (Position position : positions) {
                    points.add(position.position);
                }
                print(points, minX, minY, maxX, maxY);
            }
        }

        return iterationCount + 1;
    }

    private static List<Position> read(String s) {
        Pattern pattern = Pattern.compile("position=<(-?\\d+),(-?\\d+)>velocity=<(-?\\d+),(-?\\d+)>");
        String[] tokens = s.split("\n");
        List<Position> positions = new ArrayList<>();
        for (String token : tokens) {
            token = token.replace(" ", "");
            Matcher matcher = pattern.matcher(token);
            assert matcher.matches() : "not matches " + token;
            Position position = new Position();
            position.position.x = Integer.parseInt(matcher.group(1));
            position.position.y = Integer.parseInt(matcher.group(2));
            position.velocity.x = Integer.parseInt(matcher.group(3));
            position.velocity.y = Integer.parseInt(matcher.group(4));
            positions.add(position);
        }
        return positions;
    }

    private static long area(long x1, long y1, long x2, long y2) {
        return Math.abs(x2 - x1) * Math.abs(y2 - y1);
    }

    private static void print(Set<Point> points, int minX, int minY, int maxX, int maxY) {
        for (int y = minY; y <= maxY; ++y) {
            StringBuilder sb = new StringBuilder();
            for (int x = minX; x <= maxX; ++x) {
                Point point = new Point(x, y);
                System.out.print(points.contains(point) ? "#" : ".");
            }
            System.out.println();
            sb.append("\n");
        }
    }

    private static class Position {
        Point position = new Point();
        Point velocity = new Point();
    }
}
