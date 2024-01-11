package advent2015;

public class AoC2015Day6Part2 {
    public static void main(String[] args) {
        int result;

        result = test("turn on 0,0 through 999,999");
        assert result == 1000000;
        System.out.println(result);

        result = test("toggle 0,0 through 999,0");
        assert result == 2000;
        System.out.println(result);

        result = test("turn off 499,499 through 500,500");
        assert result == 0;
        System.out.println(result);

        result = test("turn on 0,0 through 999,999\r\ntoggle 0,0 through 999,0\r\nturn off 499,499 through 500,500");
        assert result == 1001996;
        System.out.println(result);

        result = test("toggle 461,550 through 564,900\r\nturn off 370,39 through 425,839\r\nturn off 464,858 through 833,915\r\nturn off 812,389 through 865,874\r\nturn on 599,989 through 806,993\r\nturn on 376,415 through 768,548\r\nturn on 606,361 through 892,600\r\nturn off 448,208 through 645,684\r\ntoggle 50,472 through 452,788\r\ntoggle 205,417 through 703,826\r\ntoggle 533,331 through 906,873\r\ntoggle 857,493 through 989,970\r\nturn off 631,950 through 894,975\r\nturn off 387,19 through 720,700\r\nturn off 511,843 through 581,945\r\ntoggle 514,557 through 662,883\r\nturn off 269,809 through 876,847\r\nturn off 149,517 through 716,777\r\nturn off 994,939 through 998,988\r\ntoggle 467,662 through 555,957\r\nturn on 952,417 through 954,845\r\nturn on 565,226 through 944,880\r\nturn on 214,319 through 805,722\r\ntoggle 532,276 through 636,847\r\ntoggle 619,80 through 689,507\r\nturn on 390,706 through 884,722\r\ntoggle 17,634 through 537,766\r\ntoggle 706,440 through 834,441\r\ntoggle 318,207 through 499,530\r\ntoggle 698,185 through 830,343\r\ntoggle 566,679 through 744,716\r\ntoggle 347,482 through 959,482\r\ntoggle 39,799 through 981,872\r\nturn on 583,543 through 846,710\r\nturn off 367,664 through 595,872\r\nturn on 805,439 through 964,995\r\ntoggle 209,584 through 513,802\r\nturn off 106,497 through 266,770\r\nturn on 975,2 through 984,623\r\nturn off 316,684 through 369,876\r\nturn off 30,309 through 259,554\r\nturn off 399,680 through 861,942\r\ntoggle 227,740 through 850,829\r\nturn on 386,603 through 552,879\r\nturn off 703,795 through 791,963\r\nturn off 573,803 through 996,878\r\nturn off 993,939 through 997,951\r\nturn on 809,221 through 869,723\r\nturn off 38,720 through 682,751\r\nturn off 318,732 through 720,976\r\ntoggle 88,459 through 392,654\r\nturn off 865,654 through 911,956\r\ntoggle 264,284 through 857,956\r\nturn off 281,776 through 610,797\r\ntoggle 492,660 through 647,910\r\nturn off 879,703 through 925,981\r\nturn off 772,414 through 974,518\r\nturn on 694,41 through 755,96\r\nturn on 452,406 through 885,881\r\nturn off 107,905 through 497,910\r\nturn off 647,222 through 910,532\r\nturn on 679,40 through 845,358\r\nturn off 144,205 through 556,362\r\nturn on 871,804 through 962,878\r\nturn on 545,676 through 545,929\r\nturn off 316,716 through 413,941\r\ntoggle 488,826 through 755,971\r\ntoggle 957,832 through 976,992\r\ntoggle 857,770 through 905,964\r\ntoggle 319,198 through 787,673\r\nturn on 832,813 through 863,844\r\nturn on 818,296 through 818,681\r\nturn on 71,699 through 91,960\r\nturn off 838,578 through 967,928\r\ntoggle 440,856 through 507,942\r\ntoggle 121,970 through 151,974\r\ntoggle 391,192 through 659,751\r\nturn on 78,210 through 681,419\r\nturn on 324,591 through 593,939\r\ntoggle 159,366 through 249,760\r\nturn off 617,167 through 954,601\r\ntoggle 484,607 through 733,657\r\nturn on 587,96 through 888,819\r\nturn off 680,984 through 941,991\r\nturn on 800,512 through 968,691\r\nturn off 123,588 through 853,603\r\nturn on 1,862 through 507,912\r\nturn on 699,839 through 973,878\r\nturn off 848,89 through 887,893\r\ntoggle 344,353 through 462,403\r\nturn on 780,731 through 841,760\r\ntoggle 693,973 through 847,984\r\ntoggle 989,936 through 996,958\r\ntoggle 168,475 through 206,963\r\nturn on 742,683 through 769,845\r\ntoggle 768,116 through 987,396\r\nturn on 190,364 through 617,526\r\nturn off 470,266 through 530,839\r\ntoggle 122,497 through 969,645\r\nturn off 492,432 through 827,790\r\nturn on 505,636 through 957,820\r\nturn on 295,476 through 698,958\r\ntoggle 63,298 through 202,396\r\nturn on 157,315 through 412,939\r\nturn off 69,789 through 134,837\r\nturn off 678,335 through 896,541\r\ntoggle 140,516 through 842,668\r\nturn off 697,585 through 712,668\r\ntoggle 507,832 through 578,949\r\nturn on 678,279 through 886,621\r\ntoggle 449,744 through 826,910\r\nturn off 835,354 through 921,741\r\ntoggle 924,878 through 985,952\r\nturn on 666,503 through 922,905\r\nturn on 947,453 through 961,587\r\ntoggle 525,190 through 795,654\r\nturn off 62,320 through 896,362\r\nturn on 21,458 through 972,536\r\nturn on 446,429 through 821,970\r\ntoggle 376,423 through 805,455\r\ntoggle 494,896 through 715,937\r\nturn on 583,270 through 667,482\r\nturn off 183,468 through 280,548\r\ntoggle 623,289 through 750,524\r\nturn on 836,706 through 967,768\r\nturn on 419,569 through 912,908\r\nturn on 428,260 through 660,433\r\nturn off 683,627 through 916,816\r\nturn on 447,973 through 866,980\r\nturn on 688,607 through 938,990\r\nturn on 245,187 through 597,405\r\nturn off 558,843 through 841,942\r\nturn off 325,666 through 713,834\r\ntoggle 672,606 through 814,935\r\nturn off 161,812 through 490,954\r\nturn on 950,362 through 985,898\r\nturn on 143,22 through 205,821\r\nturn on 89,762 through 607,790\r\ntoggle 234,245 through 827,303\r\nturn on 65,599 through 764,997\r\nturn on 232,466 through 965,695\r\nturn on 739,122 through 975,590\r\nturn off 206,112 through 940,558\r\ntoggle 690,365 through 988,552\r\nturn on 907,438 through 977,691\r\nturn off 838,809 through 944,869\r\nturn on 222,12 through 541,832\r\ntoggle 337,66 through 669,812\r\nturn on 732,821 through 897,912\r\ntoggle 182,862 through 638,996\r\nturn on 955,808 through 983,847\r\ntoggle 346,227 through 841,696\r\nturn on 983,270 through 989,756\r\nturn off 874,849 through 876,905\r\nturn off 7,760 through 678,795\r\ntoggle 973,977 through 995,983\r\nturn off 911,961 through 914,976\r\nturn on 913,557 through 952,722\r\nturn off 607,933 through 939,999\r\nturn on 226,604 through 517,622\r\nturn off 3,564 through 344,842\r\ntoggle 340,578 through 428,610\r\nturn on 248,916 through 687,925\r\ntoggle 650,185 through 955,965\r\ntoggle 831,359 through 933,536\r\nturn off 544,614 through 896,953\r\ntoggle 648,939 through 975,997\r\nturn on 464,269 through 710,521\r\nturn off 643,149 through 791,320\r\nturn off 875,549 through 972,643\r\nturn off 953,969 through 971,972\r\nturn off 236,474 through 772,591\r\ntoggle 313,212 through 489,723\r\ntoggle 896,829 through 897,837\r\ntoggle 544,449 through 995,905\r\nturn off 278,645 through 977,876\r\nturn off 887,947 through 946,977\r\nturn on 342,861 through 725,935\r\nturn on 636,316 through 692,513\r\ntoggle 857,470 through 950,528\r\nturn off 736,196 through 826,889\r\nturn on 17,878 through 850,987\r\nturn on 142,968 through 169,987\r\nturn on 46,470 through 912,853\r\nturn on 182,252 through 279,941\r\ntoggle 261,143 through 969,657\r\nturn off 69,600 through 518,710\r\nturn on 372,379 through 779,386\r\ntoggle 867,391 through 911,601\r\nturn off 174,287 through 900,536\r\ntoggle 951,842 through 993,963\r\nturn off 626,733 through 985,827\r\ntoggle 622,70 through 666,291\r\nturn off 980,671 through 985,835\r\nturn off 477,63 through 910,72\r\nturn off 779,39 through 940,142\r\nturn on 986,570 through 997,638\r\ntoggle 842,805 through 943,985\r\nturn off 890,886 through 976,927\r\nturn off 893,172 through 897,619\r\nturn off 198,780 through 835,826\r\ntoggle 202,209 through 219,291\r\nturn off 193,52 through 833,283\r\ntoggle 414,427 through 987,972\r\nturn on 375,231 through 668,236\r\nturn off 646,598 through 869,663\r\ntoggle 271,462 through 414,650\r\nturn off 679,121 through 845,467\r\ntoggle 76,847 through 504,904\r\nturn off 15,617 through 509,810\r\ntoggle 248,105 through 312,451\r\nturn off 126,546 through 922,879\r\nturn on 531,831 through 903,872\r\ntoggle 602,431 through 892,792\r\nturn off 795,223 through 892,623\r\ntoggle 167,721 through 533,929\r\ntoggle 813,251 through 998,484\r\ntoggle 64,640 through 752,942\r\nturn on 155,955 through 892,985\r\nturn on 251,329 through 996,497\r\nturn off 341,716 through 462,994\r\ntoggle 760,127 through 829,189\r\nturn on 86,413 through 408,518\r\ntoggle 340,102 through 918,558\r\nturn off 441,642 through 751,889\r\nturn on 785,292 through 845,325\r\nturn off 123,389 through 725,828\r\nturn on 905,73 through 983,270\r\nturn off 807,86 through 879,276\r\ntoggle 500,866 through 864,916\r\nturn on 809,366 through 828,534\r\ntoggle 219,356 through 720,617\r\nturn off 320,964 through 769,990\r\nturn off 903,167 through 936,631\r\ntoggle 300,137 through 333,693\r\ntoggle 5,675 through 755,848\r\nturn off 852,235 through 946,783\r\ntoggle 355,556 through 941,664\r\nturn on 810,830 through 867,891\r\nturn off 509,869 through 667,903\r\ntoggle 769,400 through 873,892\r\nturn on 553,614 through 810,729\r\nturn on 179,873 through 589,962\r\nturn off 466,866 through 768,926\r\ntoggle 143,943 through 465,984\r\ntoggle 182,380 through 569,552\r\nturn off 735,808 through 917,910\r\nturn on 731,802 through 910,847\r\nturn off 522,74 through 731,485\r\nturn on 444,127 through 566,996\r\nturn off 232,962 through 893,979\r\nturn off 231,492 through 790,976\r\nturn on 874,567 through 943,684\r\ntoggle 911,840 through 990,932\r\ntoggle 547,895 through 667,935\r\nturn off 93,294 through 648,636\r\nturn off 190,902 through 532,970\r\nturn off 451,530 through 704,613\r\ntoggle 936,774 through 937,775\r\nturn off 116,843 through 533,934\r\nturn on 950,906 through 986,993\r\nturn on 910,51 through 945,989\r\nturn on 986,498 through 994,945\r\nturn off 125,324 through 433,704\r\nturn off 60,313 through 75,728\r\nturn on 899,494 through 940,947\r\ntoggle 832,316 through 971,817\r\ntoggle 994,983 through 998,984\r\ntoggle 23,353 through 917,845\r\ntoggle 174,799 through 658,859\r\nturn off 490,878 through 534,887\r\nturn off 623,963 through 917,975\r\ntoggle 721,333 through 816,975\r\ntoggle 589,687 through 890,921\r\nturn on 936,388 through 948,560\r\nturn off 485,17 through 655,610\r\nturn on 435,158 through 689,495\r\nturn on 192,934 through 734,936\r\nturn off 299,723 through 622,847\r\ntoggle 484,160 through 812,942\r\nturn off 245,754 through 818,851\r\nturn on 298,419 through 824,634\r\ntoggle 868,687 through 969,760\r\ntoggle 131,250 through 685,426\r\nturn off 201,954 through 997,983\r\nturn on 353,910 through 832,961\r\nturn off 518,781 through 645,875\r\nturn off 866,97 through 924,784\r\ntoggle 836,599 through 857,767\r\nturn on 80,957 through 776,968\r\ntoggle 277,130 through 513,244\r\nturn off 62,266 through 854,434\r\nturn on 792,764 through 872,842\r\nturn off 160,949 through 273,989\r\nturn off 664,203 through 694,754\r\ntoggle 491,615 through 998,836\r\nturn off 210,146 through 221,482\r\nturn off 209,780 through 572,894\r\nturn on 766,112 through 792,868\r\nturn on 222,12 through 856,241");
        System.out.println(result);
    }

    public static int test(String s) {
        final int[][] lights = new int[1000][1000];
        final String TURN_ON = "turn on ";
        final String TURN_OFF = "turn off ";
        final String TOGGLE = "toggle ";
        String[] commands = s.split("\r\n");
        for (int i = 0; i < commands.length; ++i) {
            int commandLen = 0;
            boolean turnOn = false;
            boolean turnOff = false;
            boolean toggle = false;
            if (commands[i].startsWith(TURN_ON)) {
                commandLen = TURN_ON.length();
                turnOn = true;
            } else if (commands[i].startsWith("turn off ")) {
                commandLen = TURN_OFF.length();
                turnOff = true;
            } else if (commands[i].startsWith("toggle ")) {
                commandLen = TOGGLE.length();
                toggle = true;
            }
            String sub = commands[i].substring(commandLen);
            String[] coords = sub.split(" through ");
            String[] coord0 = coords[0].split(",");
            int x0 = Integer.parseInt(coord0[0]);
            int y0 = Integer.parseInt(coord0[1]);
            String[] coord1 = coords[1].split(",");
            int x1 = Integer.parseInt(coord1[0]);
            int y1 = Integer.parseInt(coord1[1]);
            for (int x = x0; x <= x1; ++x) {
                for (int y = y0; y <= y1; ++y) {
                    if (turnOn) {
                        ++lights[x][y];
                    } else if (turnOff) {
                        --lights[x][y];
                        if (lights[x][y] < 0) {
                            lights[x][y] = 0;
                        }
                    } else if (toggle) {
                        lights[x][y] += 2;
                    }
                }
            }
        }
        int totalBrightness = 0;
        for (int i = 0; i < 1000; ++i) {
            for (int j = 0; j < 1000; ++j) {
                totalBrightness += lights[i][j];
            }
        }
        return totalBrightness;
    }
}