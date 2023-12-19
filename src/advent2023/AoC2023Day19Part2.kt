package advent2023

import utils.Point4D

private var result = 0L

fun main() {
    result = test(
        """
            px{a<2006:qkq,m>2090:A,rfg}
            pv{a>1716:R,A}
            lnx{m>1548:A,A}
            rfg{s<537:gd,x>2440:R,A}
            qs{s>3448:A,lnx}
            qkq{x<1416:A,crn}
            crn{x>2662:A,R}
            in{s<1351:px,qqz}
            qqz{s>2770:qs,m<1801:hdj,R}
            gd{a>3333:R,R}
            hdj{m>838:A,pv}

            {x=787,m=2655,a=1222,s=2876}
            {x=1679,m=44,a=2067,s=496}
            {x=2036,m=264,a=79,s=2244}
            {x=2461,m=1339,a=466,s=291}
            {x=2127,m=1623,a=2188,s=1013}
    """.trimIndent()
    )
    check(167409079868000, result)

    result = test(
        """
            fxg{x<2288:tn,m<3059:mlg,xl}
            fdl{m>3467:A,s<1414:A,s>2068:A,A}
            fzv{m<82:R,m>134:A,s>1033:R,A}
            fmd{a>3959:A,R}
            xx{s>1478:shz,s>972:tfm,a>3810:jvb,lfb}
            cjj{m<2288:R,a>3822:A,A}
            qht{a<2481:vk,m>987:thk,s>2051:xkl,mz}
            ds{a>2589:A,R}
            ts{s<1928:A,A}
            cb{s<3311:R,s<3404:R,R}
            qcm{s>838:A,R}
            xxz{m>2772:dpn,A}
            zbx{s<2149:R,m>1885:R,s<3157:A,R}
            mdq{m>2002:sg,a>3908:gz,m<1702:np,gxm}
            rlm{m<2733:R,m>2925:lhf,s<2207:msh,gjh}
            zlx{m>2987:R,s>1645:R,R}
            ngc{m<3821:A,A}
            mjq{s>1671:A,s<1484:A,A}
            bk{a<3273:A,m>3695:pkb,m<3584:R,dzk}
            mvc{m>3223:R,A}
            xl{s>677:A,m>3381:A,A}
            pm{s>2238:srn,dxg}
            szv{a<1654:krs,a<3133:fnm,m<3024:gpl,lh}
            tdp{m<3483:mnh,a<3418:xrv,sf}
            kgk{x<1234:fbd,pjk}
            xkl{a>2755:kd,x>1913:vv,R}
            jx{a>3102:rzg,gsm}
            pz{x<1357:R,s<338:R,R}
            ztx{m>3558:kfs,s<1441:chq,x>2307:A,A}
            jp{m<1022:R,a<401:hrk,x<2481:A,lfr}
            nbp{x>3585:A,A}
            lqv{x<1820:A,A}
            hbd{a<387:hgd,nt}
            hh{s<760:R,s>1049:A,A}
            hbv{s>2416:A,m<1490:A,m<1526:R,R}
            fq{s<490:R,R}
            kql{s>1995:A,a<3405:R,A}
            bhl{s>3286:dzj,m<3238:csn,vn}
            nfs{m>454:A,x>2121:R,A}
            vvd{m<45:A,s>2313:rr,m>86:A,vdx}
            msm{m>410:hfx,m>213:qdk,a<3545:bd,xp}
            zpt{s<393:fj,a<3968:R,x<989:R,vgm}
            qc{x<1556:A,R}
            tm{a>3874:R,s<3072:A,s<3430:A,A}
            hxg{a>459:A,m<3846:A,A}
            vrh{s>513:fxg,m>3140:mhj,a<2061:bv,zk}
            pn{x>221:R,m>2805:A,R}
            pb{x>2748:R,x>2190:A,m>343:R,ln}
            zn{x>2133:xm,x<813:tb,s>252:pz,R}
            jls{x<2268:A,m<422:R,a<2257:R,A}
            pl{s>2588:A,s<975:smm,jlr}
            kt{s<2491:R,s<2547:A,x<2548:A,A}
            xrv{s>1456:bk,fq}
            cs{x<1649:R,A}
            hq{m>3164:rv,x>594:R,sjl}
            qvr{s>457:R,a<1922:R,R}
            cz{m>2163:R,m<1830:lqv,tbg}
            mnm{x<2059:R,A}
            msh{a>3672:A,x>2294:R,A}
            jh{a>447:A,m>3125:R,R}
            btl{s<1969:rmb,A}
            nxj{a>1150:R,x<1570:A,A}
            hcc{s>3619:R,m<3681:A,s<3546:R,A}
            jnt{s>3000:ksn,a>3744:A,xlp}
            ck{m>3636:hxg,a>265:R,a>134:R,mt}
            kr{s>591:R,s<285:gj,x<1120:R,mnm}
            jtl{m<2676:ljt,a>3746:R,pn}
            tdj{x<3002:R,R}
            pf{s<3426:qjt,s>3624:nsl,xjk}
            pj{s>1859:R,R}
            xz{s>2322:pf,m>2095:pvb,ss}
            bl{x>1072:R,vrf}
            hrk{a>204:R,R}
            vv{s>2378:A,A}
            px{a<3676:R,R}
            cth{s>1089:R,x<1723:A,A}
            vd{s>670:A,m<2596:A,x>1199:R,A}
            hvb{x>1121:A,x<581:znp,A}
            gn{m<920:gml,x<2325:kgk,rlx}
            csn{x>893:R,s<2824:mnv,qn}
            scs{m<3673:R,x<1134:A,a<3671:A,A}
            ss{s<1302:zfx,x>815:hf,btl}
            sjl{x>263:R,A}
            tfm{a<3703:A,s<1173:R,dxt}
            hfx{s>1106:A,s<547:bx,dj}
            qt{a>3806:xlm,s>1595:bj,a<3717:xs,mmf}
            mlg{x>3146:R,s>721:A,A}
            gkm{a>660:R,A}
            txg{s>810:R,m<3165:R,a<3430:R,R}
            pvb{s<1031:qql,a>3301:jln,vf}
            fxb{a<3859:pkq,mdq}
            ljt{x>237:A,a>3840:R,R}
            jcm{x>3322:A,A}
            mqs{a<3643:pqp,a<3769:tbm,s<2584:fxb,tbs}
            lxk{a>2753:qdm,a>2621:tlp,cq}
            tbg{m<1957:A,m>2053:R,m>1999:R,R}
            gdk{s<1637:A,A}
            bv{s<197:xjx,a>1986:zp,R}
            xnj{m<3359:R,m>3463:R,m<3428:R,A}
            gv{s>1869:zqk,txp}
            jln{x>679:gp,s<1624:R,s<2011:crb,xqx}
            ft{s<1931:A,m>277:A,A}
            fxr{m<2870:cgn,x>961:vm,m<3322:R,A}
            jrb{s<3400:R,x>1684:R,x>1454:R,A}
            dsd{a>3907:A,mf}
            rp{s>3309:R,x<1004:A,jbs}
            jlr{x>3494:A,m<3218:A,R}
            lhd{x<814:R,x<1071:R,R}
            thl{a<3885:R,s<3770:A,R}
            qp{a<1700:A,m<1132:R,s<962:A,A}
            xmg{m>3765:kb,s>2035:msf,s<1048:fx,lj}
            sg{x>2270:A,R}
            vtr{s>473:A,x>460:R,R}
            zk{a<2113:bhg,m<2164:A,R}
            gml{a<2183:jz,x>2629:fh,a>2379:kr,vl}
            phl{a>1213:xnk,x>2508:lq,dsp}
            grr{a>3924:zvv,a<3874:bmb,xv}
            mz{s>1916:A,m<924:dtb,a<2668:A,zv}
            dr{a>830:R,m>2354:R,lr}
            mmp{m>3723:zqr,m<3706:R,s<580:R,A}
            srn{m>1115:A,s>2393:R,A}
            mhj{x>2438:A,dl}
            mq{m<204:lc,x>1107:cc,A}
            tbs{s>3146:mjl,dsd}
            mmf{x>1280:R,s<937:R,A}
            ksn{a>3701:R,m>3252:A,R}
            spn{x>1838:R,x<1168:dzc,s>1037:A,qc}
            vbf{a<3249:R,s<2020:R,R}
            gt{s<2374:A,s<2461:A,R}
            lg{m>867:A,x<1356:R,s>3363:R,R}
            hr{a>3739:A,x>339:R,R}
            fh{a<2473:A,a>2541:A,x>3430:cr,A}
            tk{m>2064:R,m<1828:R,A}
            mmc{s<3055:R,R}
            flh{s>2954:A,x>3012:A,x<2516:R,A}
            stn{s>1855:zl,a<3682:A,tk}
            lt{a<2953:sm,m>140:tdj,kql}
            pjh{s<3223:R,s>3319:R,x<1248:A,R}
            cd{m<3499:pl,gb}
            zfx{x<859:vtr,x<1065:R,lqm}
            kbx{x>2196:tst,ctc}
            ktq{s<1368:A,R}
            spg{a<2022:A,m<2383:R,x<852:kxh,A}
            kb{a>3815:grr,s>2167:rp,hbm}
            vnh{x>2559:qvh,rb}
            xk{s<973:A,s>1418:R,A}
            zz{m<3797:pbt,R}
            nrs{m<2763:R,a>2242:R,s>2010:A,A}
            xqr{a<1948:bts,s>995:fpx,vrh}
            tb{s<238:R,R}
            qdx{x<582:csj,xx}
            vts{a<3055:R,a>3208:A,a<3112:A,A}
            fbd{a<1902:qp,nn}
            smm{a<3598:A,x>3526:R,m<3214:R,R}
            xs{s<1042:R,a>3659:A,A}
            zc{a>2724:R,m<951:R,x>2100:R,R}
            csj{m<2472:tq,s<2587:jtl,a>3749:fd,bbd}
            rq{m>3626:A,a>2389:A,R}
            ckk{s<721:qvr,a>2023:R,x>3096:R,A}
            znp{x<195:R,x>385:A,a>3930:A,R}
            hz{m<565:A,a>732:A,m>770:A,R}
            zv{x>1524:R,x>740:A,s>1835:R,R}
            zp{x<2081:R,A}
            qgf{s<801:A,a<3653:A,s>1342:A,R}
            tp{a>3371:zrk,R}
            gm{a>937:mmc,x<833:fp,jh}
            msf{s<2813:hnx,m<3701:jj,s<3492:ls,xt}
            dxt{x>924:A,m<2200:A,A}
            gpl{x>1337:mqs,a<3544:xz,qdx}
            kjr{x<2252:A,m<2340:R,R}
            xqx{x>414:A,m<2609:R,s<2216:A,A}
            fn{x<1666:tzd,m<1371:pq,ph}
            lqm{a>3330:A,m>1880:R,x<1195:R,A}
            ssj{m>1131:cxm,m<992:A,x>2550:txx,R}
            gxm{a<3878:A,s<1216:A,A}
            pgk{x>1554:R,m>2073:A,m>1777:A,A}
            cf{s>3103:A,R}
            bnq{m<2544:R,m<3510:R,R}
            sx{s<1453:dnl,m<1270:clq,zd}
            nc{m>1030:A,a>3768:R,R}
            flx{x<2558:A,m<1299:R,A}
            rh{m<1142:rcq,a>3251:qpc,x<1463:rd,A}
            vm{a>1836:R,s>1532:R,R}
            qfc{x>1563:A,x>1412:R,A}
            pkb{a>3343:A,R}
            qn{m<3164:A,x<359:A,m<3195:A,A}
            hpk{a<3860:A,m>2285:A,x<982:A,A}
            vdx{s>2213:A,s>2184:A,x>2983:R,A}
            nkm{m<3672:A,a<3571:R,m<3811:A,A}
            rx{x<2190:fxx,dx}
            hgd{m<981:A,A}
            szs{m<2528:fv,m>3232:pj,zlx}
            vz{x>1069:R,x<426:R,zg}
            vk{m<1038:A,shc}
            kk{m>2465:R,s>2032:R,A}
            rk{s<3088:kmf,x<2955:pqk,s<3479:th,zb}
            pkq{s<1716:cjj,s>2162:A,s<1905:vc,R}
            bsx{x<370:R,m>2899:R,A}
            qpm{s>3450:pp,bl}
            pp{x<955:mh,x>1395:R,R}
            tst{x>2877:bnq,R}
            dhm{m<3479:xsg,mv}
            fpx{x<1855:spg,szs}
            mdh{a>3390:A,m<2131:A,s<3506:A,R}
            phj{a>2554:lxk,s<2157:nj,s>3251:kbx,vnh}
            hn{x>557:R,m<152:A,A}
            fnm{a>2161:phj,s<2559:xqr,vs}
            xzp{a>3400:A,a<3357:A,R}
            dm{x>971:A,s<1707:A,s>1743:R,A}
            fmt{x>3561:A,A}
            tc{m<3759:R,m<3761:R,A}
            zcq{s>953:gl,A}
            qvh{m>3005:rq,a>2368:skg,qq}
            xbg{a<2362:rkm,a<2427:A,A}
            bgs{s>3730:A,x>2093:A,A}
            vt{m<287:R,R}
            vzs{x>2122:mdc,R}
            dt{a<322:A,a<494:R,A}
            kcd{m<2490:R,R}
            bhg{a<2083:A,x>2127:R,A}
            lc{x>1216:A,A}
            lz{x>2398:A,m>1162:R,R}
            mnh{m>3327:vz,x>1160:vtx,hq}
            htm{x>2296:zkf,s>2077:jth,hnc}
            tn{a<2020:R,R}
            jzm{x>3227:A,R}
            tj{a>3813:A,A}
            fp{m>3076:A,a>493:R,m>2934:A,R}
            rts{a<3848:nc,m<1013:bs,m<1078:tpk,lvh}
            kl{m>767:R,s<2165:R,s<2258:R,A}
            xr{x>1462:pb,x>820:mq,fdr}
            sm{x>3094:A,A}
            lr{m>1863:A,R}
            dzj{x>1287:qfc,s<3612:lhd,thl}
            bd{m>83:cth,s<970:jfs,db}
            fdr{a<520:qd,s<892:A,R}
            kfs{s>1567:R,a>3288:R,A}
            gl{s>1251:R,m>949:R,R}
            gx{a>3225:A,x>524:A,m>2467:R,A}
            bs{x<1767:R,m>949:R,s>2069:R,R}
            gmn{m>3647:R,a>3720:A,s<2882:R,R}
            nh{m>538:A,A}
            nv{m<3608:dt,m>3822:rhv,a<376:jtn,R}
            xnk{a>1282:zhs,m>1091:flx,lg}
            sl{x<943:hr,x<1538:hs,R}
            pbz{s>2319:rct,a>750:R,kl}
            xjx{x>1490:R,x>948:R,x<374:R,R}
            hf{s>1961:A,mjq}
            fr{x<2009:pbz,m<909:zjk,a<1227:tt,pm}
            qpc{x>1774:R,x<1034:A,A}
            nx{s>3695:A,a<458:R,A}
            xlp{s>2692:R,x>1500:R,a<3692:A,A}
            vrf{a>1813:A,x<675:A,m>2397:A,R}
            fx{a<3858:dq,m<3684:hvb,a>3947:zpt,mmp}
            dvz{s<2448:R,x<1803:nkm,a>3561:hfg,A}
            nt{s<3265:R,s>3609:R,A}
            lk{x>1092:R,A}
            gb{m<3766:px,jcm}
            tzd{x>643:R,m>1402:R,A}
            gj{s<181:R,s>242:A,R}
            lst{x>2139:hbd,x<1078:npf,lpq}
            kf{s<1698:tf,ftj}
            fd{x<225:A,x<444:R,tm}
            gp{x<944:A,x<1151:A,A}
            djs{x<1630:A,s<1045:A,A}
            vc{m<2251:R,m>2675:A,s<1784:A,R}
            mcv{x<1158:R,A}
            sr{s>637:R,A}
            xp{a<3809:qgf,a>3876:cs,fzv}
            zq{a<2371:R,R}
            sn{a<574:R,s<3238:A,s>3608:A,R}
            prx{s>3406:R,A}
            gsm{a<2825:zc,s<779:xb,m<880:A,bm}
            qns{a>3713:R,A}
            jth{m<3374:gm,a>776:nxg,x<1068:nv,ck}
            qqn{s>2266:lqh,jf}
            nsl{s>3816:A,a<3396:A,R}
            tt{x>3233:nbp,A}
            jbs{x<1614:A,A}
            xj{s>2368:R,a>2424:R,s>2314:R,A}
            xv{s<1349:A,R}
            qqf{x>1015:jnt,qmk}
            ztb{x<772:R,A}
            qnr{m<3763:A,m<3892:R,R}
            nn{s>775:A,x<470:R,R}
            bbd{m<2836:R,bsx}
            nj{s<1347:xbg,a<2328:bcz,cx}
            lrg{a>3925:R,A}
            jd{x<3255:R,a>1048:A,a<984:A,A}
            qql{x<857:A,R}
            hfg{a>3587:R,s>3271:R,R}
            spc{a>3762:R,a<3682:R,s>1915:A,A}
            skg{s>2718:A,m<2395:A,s>2452:A,A}
            mzg{s>258:R,x<1217:R,A}
            bx{m<551:A,R}
            lfb{x<1060:R,s<416:mzg,m<2306:sr,vd}
            pv{a<3182:R,m<600:R,R}
            fv{a>2031:A,a<1998:R,x<3117:R,R}
            lqb{x<937:A,a<2879:R,m>152:A,A}
            shz{a>3752:hpk,a<3647:R,A}
            cxc{a<1094:R,a<1220:A,R}
            th{m>2853:R,a>1789:cb,hgq}
            thk{m<1092:A,a>2706:vq,A}
            fj{x<730:A,s>180:R,m<3718:A,R}
            gjh{s<3014:R,A}
            bts{x>1336:dv,x<614:fpm,fxr}
            bpc{m>2876:frp,cz}
            fxx{x>1291:sv,a>821:cxc,jg}
            kdt{x>1408:A,x<526:A,a>2495:A,R}
            xnx{s<2569:tz,s<3106:gmn,A}
            bnt{s>3072:kh,x>1617:A,s<2861:A,A}
            nqb{m>787:bnt,mtl}
            fgj{x<982:pld,m<3732:mkh,R}
            vmp{a>377:A,s>3562:A,A}
            mt{x<1659:R,x>1949:R,a<86:A,A}
            jjr{a<3524:md,pk}
            nf{a>3693:A,m>3721:A,x<1258:R,A}
            kmf{m>2616:A,ch}
            qqm{m<759:msm,m<1066:jx,s<1072:mbx,sx}
            npf{s>3135:nx,a<607:A,a<735:A,R}
            zfz{a<593:R,m<1173:R,m<1287:R,A}
            qd{x>400:R,a>333:A,s<926:A,A}
            md{m>3814:A,A}
            dl{s>329:A,R}
            xns{s<1829:A,spc}
            mf{x>2942:R,x<1923:R,A}
            pc{x>578:R,s<1159:R,s<1501:A,R}
            js{x<1654:A,A}
            ph{x<2673:A,a<3382:A,R}
            mdc{x>3156:A,A}
            kd{s>2236:A,a<2877:A,s>2169:A,A}
            stv{x<1621:A,A}
            ttf{s<2002:gv,fr}
            fc{a>2299:R,x>1400:A,R}
            llx{m<1282:hvf,R}
            txx{m<1072:R,m>1107:R,A}
            tpk{m>1055:A,a<3918:R,s<2145:R,R}
            gz{s<1406:A,s>2050:R,A}
            clq{s<1549:lz,R}
            vtz{a>1307:R,R}
            xh{x>1990:R,s>2577:A,R}
            dxg{s<2121:R,m>1223:A,s>2179:A,R}
            jj{m<3671:lk,s<3497:R,s>3723:xdd,hcc}
            dlh{m>2519:R,a>2691:R,R}
            zkf{m>3525:fmm,s>1899:jzm,fkp}
            bcz{s<1775:R,nrs}
            hnx{m>3695:R,qk}
            frp{s<3328:A,bgs}
            jb{x>3417:R,m<3694:R,R}
            htj{s<903:dr,jvf}
            qdm{x<2036:vj,s<1607:hh,flh}
            xn{a<561:R,m<3597:A,m<3806:stv,R}
            tlp{x<2194:dlh,A}
            bm{m>977:R,s<1159:A,a>2980:A,R}
            cr{m<444:R,a<2515:R,a<2529:R,A}
            cq{s<1598:kx,x>2199:ds,a>2582:R,mcv}
            jg{x>719:R,a<322:A,m>425:R,R}
            kx{a<2578:R,m<2783:R,R}
            rmb{m>1701:R,s>1741:R,R}
            cx{s<1842:kjr,a<2456:A,s<2046:ts,kdt}
            dh{a>1396:nqb,m<707:rx,a<911:lst,phl}
            rkm{s>624:A,m<2304:R,a>2285:R,A}
            dj{s<896:R,s>1021:A,A}
            jfs{m>50:A,m<30:A,A}
            bj{s>1901:xnj,s<1781:dm,R}
            sdm{s<2101:A,s<2351:R,A}
            cnb{a>669:gfj,xh}
            jvb{x<1067:nnl,a<3877:R,x>1216:R,A}
            td{x<1697:pv,m>565:st,bzm}
            bzm{m<433:sdm,a<3012:R,A}
            jtn{a<200:R,x>576:A,x>340:A,R}
            rct{x>835:R,a>1372:A,A}
            pbt{m>3727:R,a<3631:A,x<2581:R,R}
            vtx{s<2246:txg,x>1434:cf,rrx}
            hfs{m<3564:mvc,x>2387:xzp,s<1647:qcm,A}
            ctc{s<3638:fc,R}
            lvh{m>1112:A,m<1095:R,x<1917:A,R}
            km{a>3774:A,m>3368:A,s<2096:R,A}
            hg{s<2175:A,s>2402:lqb,hn}
            mv{a<3791:A,a>3912:prx,R}
            pq{s<395:R,s>768:A,m<1330:R,R}
            mnv{a>3937:R,R}
            cgn{s>1534:A,a<1782:A,A}
            hfj{a<1252:A,m<3238:A,s>1189:R,A}
            vgm{x>1551:A,s>726:A,A}
            xdd{a>3845:A,m>3687:R,R}
            mjl{s>3637:R,s<3353:nz,A}
            kdd{x<3760:fmt,x<3872:A,m<1006:A,R}
            sz{s<2416:A,a<3004:kt,R}
            xjk{a<3328:R,a>3466:R,mdh}
            tf{a<1495:lsl,a>2641:qqm,gn}
            rcq{s<784:R,x<1815:A,A}
            pqk{m<2915:vfv,m>3530:R,R}
            lj{m<3698:sl,s<1487:fgj,xns}
            bt{m>3937:A,R}
            mjn{a<3737:A,a<3910:R,fmd}
            bzn{m>1148:tg,a>2948:cvg,qht}
            vj{s<2479:R,m>2514:R,s>3114:A,A}
            pk{m<3785:R,m<3925:A,A}
            rd{s<770:R,x<757:A,s<872:A,A}
            hnc{x>1219:xn,gkm}
            qk{x<894:R,m<3674:R,R}
            nnl{s>432:A,R}
            lhf{s>1783:A,m>2962:A,R}
            rtk{x<590:R,x<975:R,a>3259:R,A}
            zd{m<1376:zh,s<1580:R,lxg}
            hs{s<1492:R,m>3665:R,A}
            tg{s<2247:llx,zj}
            rrx{m<3208:R,x>1262:R,x>1206:R,R}
            fkp{a<1091:R,a>1372:A,hfj}
            qq{s>2866:A,R}
            txp{s<1757:nh,lnz}
            qcf{s>3084:R,A}
            chq{x<2326:A,s>790:A,x<2514:R,R}
            zrk{x>2475:R,m<2352:R,A}
            hc{s<3171:cnb,vzs}
            pdv{s>1694:hc,htj}
            mtl{a>2562:A,s<3387:nfs,a<1966:R,R}
            sv{s<3288:R,x<1848:A,R}
            cj{m>522:A,R}
            nz{x<3106:R,a>3915:R,A}
            vgd{x<207:R,m>2937:R,a<1846:A,A}
            rzg{a>3598:hts,R}
            dzk{s>2875:R,a<3368:A,R}
            fmm{s>1385:A,a>817:A,jb}
            kxh{x<512:A,x>704:R,A}
            xm{x>3079:R,R}
            rlx{x<2946:ssj,x<3395:ckk,m<1126:kdd,qsz}
            cxm{m<1297:R,A}
            xlm{m<3363:lrg,fdl}
            qsz{a>2068:zq,R}
            gh{x<2722:km,x>2801:R,m<3266:R,R}
            vs{a>1978:bpc,x<2043:qpm,rk}
            fpm{s>1180:vgd,x<258:R,A}
            zb{s>3696:R,xg}
            vfv{x>2448:R,m<1999:R,R}
            jvf{a>1057:pgk,R}
            zj{a<2790:xj,a>3352:A,x<1345:tqd,vts}
            hkr{a>3732:A,x>711:R,A}
            dsp{a>1078:nxj,m>975:A,A}
            dx{x>2822:R,sn}
            hd{s<2428:qt,m>3374:dhm,a<3823:qqf,bhl}
            ftj{s>2579:dh,a<2113:ttf,m<892:mx,bzn}
            mkh{m<3720:A,s>1274:A,R}
            vl{x>1641:jls,x<807:A,s>913:ktq,cj}
            crb{a<3406:A,R}
            dq{m>3694:A,x<678:R,a>3755:A,scs}
            qjt{a<3401:rtk,a>3454:ztb,A}
            np{x<2860:A,R}
            rv{x<763:A,A}
            bf{s<1946:A,R}
            pjk{s>618:djs,R}
            vx{x>1751:A,R}
            gfj{x>2306:R,R}
            cvg{a<3628:qqn,rts}
            dhg{m>1688:zbx,m>1551:A,hbv}
            zqr{m<3749:A,x<987:R,a>3895:A,A}
            sf{x<1168:qnr,x<1554:jjr,a>3519:dvz,ngc}
            blz{x<2324:xnx,m>3634:zz,x>2570:gh,mjn}
            zg{a>3363:A,m>3389:A,R}
            lxg{s>1646:R,s<1608:A,s>1631:A,R}
            vn{s<2757:zr,a<3910:A,a>3961:A,A}
            dnl{s>1311:vx,a<3248:A,qm}
            qm{a>3722:A,R}
            jf{m<994:A,R}
            lq{s<3179:A,jd}
            lpq{s>3282:vmp,s>2926:A,s<2718:zfz,A}
            ls{m<3734:pjh,m>3754:tc,s<3231:R,R}
            zh{a<3367:A,s<1566:A,s<1637:A,A}
            vf{s>1463:kk,s>1304:A,gx}
            kh{x<1450:A,A}
            rhv{s>3306:R,A}
            pld{s>1209:A,a<3823:A,x<409:R,A}
            lfr{x<3457:A,a<669:R,A}
            zhs{s<3266:A,a>1355:A,x>2573:R,R}
            dpn{m<2862:R,x>2400:A,R}
            zl{x>2727:A,x>2192:A,A}
            tz{s>1150:R,s>426:R,s<176:A,R}
            krs{m<2856:pdv,htm}
            tqd{a<2979:A,x<502:A,m<1339:A,A}
            ch{x<2847:A,m>1957:R,R}
            pqp{m<2055:dhg,m<2603:tp,xxz}
            lh{x>1949:gf,a<3601:tdp,m<3635:hd,xmg}
            hvf{a>2819:A,x<1830:R,R}
            zvv{a<3953:R,R}
            dzc{m>950:A,R}
            mx{m>308:td,tvp}
            xt{m>3743:R,a<3740:nf,R}
            zqk{m<516:ft,m<883:bf,x<1639:R,R}
            vq{s<2233:A,s<2350:A,A}
            xb{m<903:R,R}
            lqh{x<2091:R,A}
            zr{a>3919:A,x>1276:A,x<690:A,R}
            in{m<1457:kf,szv}
            xg{m>2358:A,A}
            rb{x>1307:R,s>2733:R,hv}
            st{a<2850:A,vbf}
            tbm{a>3715:kcd,m>2410:rlm,stn}
            zjk{s<2242:hz,x<2870:gt,vtz}
            shc{a<2332:R,A}
            drb{a>3328:hfs,a<3240:jsr,ztx}
            tq{m>2044:A,s>1419:R,m>1835:tj,R}
            tvp{x<1506:hg,s<2159:lt,m<126:vvd,sz}
            dtb{a>2641:R,A}
            mbx{m>1293:fn,s<417:zn,rh}
            ln{m>136:R,m<83:A,m<110:A,R}
            gf{x>2871:cd,a>3436:blz,drb}
            hbm{x<756:qns,x<1386:R,m<3894:R,bt}
            jsr{m<3426:A,A}
            bmb{m>3851:R,A}
            nxg{x>1128:qcf,R}
            dnz{s>3099:A,R}
            qdk{x>1536:R,a<3185:R,xk}
            jz{m>573:js,s<809:A,x>1381:vt,pc}
            hgq{x>3568:A,A}
            db{m<34:A,s<1263:A,A}
            hts{a>3856:A,a<3741:A,A}
            lsl{m<587:xr,zpx}
            dv{a<1753:gdk,R}
            mh{x>365:R,m<2574:R,s>3648:R,R}
            cc{m<367:A,R}
            zpx{a<835:jp,a>1137:spn,zcq}
            hv{s<2493:A,s>2632:R,s<2564:A,R}
            lnz{s>1813:R,s>1793:A,R}
            xsg{x<1276:R,m<3419:jrb,A}
            qmk{x<446:R,m<3220:hkr,dnz}
            rr{a>3328:A,A}

            {x=555,m=85,a=257,s=1864}
            {x=561,m=159,a=473,s=524}
            {x=1,m=1419,a=1233,s=675}
            {x=1089,m=766,a=1101,s=2378}
            {x=1010,m=662,a=1172,s=2016}
            {x=2979,m=1043,a=169,s=1191}
            {x=100,m=379,a=1959,s=1262}
            {x=1782,m=2770,a=3430,s=344}
            {x=3185,m=1618,a=156,s=13}
            {x=834,m=666,a=1565,s=1106}
            {x=2134,m=2304,a=222,s=2574}
            {x=1138,m=953,a=296,s=1331}
            {x=973,m=84,a=1449,s=1053}
            {x=872,m=810,a=918,s=77}
            {x=1796,m=994,a=441,s=3453}
            {x=2566,m=1336,a=1625,s=72}
            {x=596,m=208,a=380,s=1858}
            {x=838,m=217,a=620,s=595}
            {x=404,m=238,a=2051,s=62}
            {x=1150,m=1729,a=227,s=1352}
            {x=652,m=255,a=257,s=115}
            {x=1,m=632,a=554,s=2230}
            {x=1116,m=1646,a=2196,s=691}
            {x=1498,m=59,a=503,s=546}
            {x=1471,m=3369,a=692,s=190}
            {x=1026,m=1795,a=593,s=549}
            {x=50,m=1170,a=2057,s=751}
            {x=74,m=562,a=926,s=348}
            {x=2649,m=597,a=117,s=1675}
            {x=651,m=1092,a=395,s=1332}
            {x=56,m=1418,a=866,s=1866}
            {x=232,m=1836,a=163,s=546}
            {x=699,m=472,a=423,s=2767}
            {x=150,m=2686,a=637,s=281}
            {x=99,m=1703,a=237,s=74}
            {x=136,m=3409,a=1103,s=1570}
            {x=1409,m=185,a=2260,s=610}
            {x=1637,m=2277,a=150,s=27}
            {x=515,m=1482,a=298,s=3343}
            {x=710,m=820,a=459,s=508}
            {x=1337,m=776,a=67,s=607}
            {x=1987,m=565,a=2309,s=1127}
            {x=724,m=243,a=330,s=863}
            {x=73,m=1092,a=790,s=523}
            {x=2645,m=3064,a=866,s=389}
            {x=895,m=2653,a=419,s=3558}
            {x=2098,m=518,a=1856,s=3256}
            {x=655,m=194,a=1988,s=1864}
            {x=1433,m=1887,a=1790,s=1238}
            {x=2053,m=535,a=337,s=958}
            {x=244,m=1087,a=2686,s=901}
            {x=1170,m=1684,a=411,s=1889}
            {x=726,m=1934,a=1618,s=443}
            {x=1332,m=1810,a=380,s=422}
            {x=649,m=1852,a=1,s=2544}
            {x=3146,m=437,a=2784,s=10}
            {x=596,m=491,a=2173,s=327}
            {x=88,m=207,a=48,s=444}
            {x=452,m=40,a=39,s=2294}
            {x=99,m=499,a=1671,s=101}
            {x=1220,m=1274,a=376,s=297}
            {x=2330,m=137,a=100,s=923}
            {x=1581,m=687,a=2567,s=317}
            {x=429,m=186,a=163,s=1936}
            {x=797,m=2500,a=1780,s=2179}
            {x=186,m=2375,a=2173,s=363}
            {x=320,m=48,a=1853,s=982}
            {x=1055,m=2256,a=41,s=914}
            {x=527,m=1721,a=119,s=2447}
            {x=75,m=126,a=1660,s=393}
            {x=18,m=1989,a=10,s=129}
            {x=1552,m=142,a=599,s=453}
            {x=735,m=1193,a=365,s=2696}
            {x=1489,m=6,a=932,s=92}
            {x=212,m=2273,a=145,s=1142}
            {x=1237,m=200,a=712,s=61}
            {x=117,m=1395,a=3696,s=3625}
            {x=1004,m=1531,a=1623,s=44}
            {x=935,m=1000,a=1599,s=261}
            {x=12,m=2868,a=43,s=803}
            {x=1335,m=1559,a=2373,s=334}
            {x=278,m=409,a=1180,s=948}
            {x=1190,m=804,a=267,s=53}
            {x=800,m=1523,a=866,s=286}
            {x=160,m=3245,a=1135,s=477}
            {x=1299,m=2492,a=970,s=105}
            {x=2643,m=928,a=56,s=1661}
            {x=214,m=2863,a=2692,s=348}
            {x=178,m=1747,a=916,s=126}
            {x=12,m=302,a=857,s=302}
            {x=433,m=120,a=1018,s=3452}
            {x=461,m=1048,a=196,s=1933}
            {x=665,m=594,a=2435,s=8}
            {x=1135,m=2290,a=259,s=741}
            {x=886,m=560,a=881,s=278}
            {x=1429,m=1225,a=245,s=269}
            {x=3164,m=346,a=1088,s=3245}
            {x=137,m=248,a=2201,s=451}
            {x=190,m=175,a=1798,s=86}
            {x=2769,m=2152,a=2079,s=960}
            {x=932,m=184,a=52,s=131}
            {x=815,m=2580,a=1474,s=3349}
            {x=1257,m=1833,a=974,s=16}
            {x=593,m=685,a=649,s=1583}
            {x=756,m=2884,a=602,s=438}
            {x=221,m=399,a=579,s=68}
            {x=1368,m=1064,a=110,s=144}
            {x=14,m=576,a=1284,s=1241}
            {x=2791,m=689,a=76,s=171}
            {x=281,m=216,a=264,s=635}
            {x=270,m=235,a=1566,s=226}
            {x=740,m=1145,a=111,s=415}
            {x=194,m=2410,a=272,s=176}
            {x=3068,m=259,a=164,s=222}
            {x=594,m=191,a=439,s=12}
            {x=26,m=256,a=278,s=1457}
            {x=276,m=489,a=1479,s=2972}
            {x=601,m=216,a=1040,s=1666}
            {x=765,m=1805,a=485,s=304}
            {x=1533,m=1953,a=658,s=10}
            {x=4,m=11,a=766,s=89}
            {x=483,m=1013,a=1281,s=1708}
            {x=2284,m=49,a=55,s=150}
            {x=558,m=254,a=20,s=22}
            {x=441,m=330,a=148,s=1761}
            {x=1956,m=422,a=2927,s=324}
            {x=387,m=1026,a=568,s=3575}
            {x=703,m=852,a=293,s=341}
            {x=2347,m=258,a=1681,s=3083}
            {x=142,m=451,a=450,s=228}
            {x=83,m=2112,a=1696,s=60}
            {x=2408,m=1812,a=228,s=815}
            {x=31,m=952,a=125,s=550}
            {x=55,m=2535,a=10,s=3172}
            {x=303,m=264,a=161,s=525}
            {x=140,m=979,a=548,s=2664}
            {x=107,m=1615,a=111,s=2000}
            {x=812,m=600,a=349,s=950}
            {x=1900,m=724,a=1278,s=1492}
            {x=370,m=1483,a=636,s=2186}
            {x=314,m=711,a=548,s=1023}
            {x=615,m=2745,a=1560,s=1901}
            {x=875,m=1076,a=1257,s=129}
            {x=1918,m=935,a=250,s=372}
            {x=2814,m=894,a=397,s=619}
            {x=1894,m=1200,a=1263,s=163}
            {x=361,m=2982,a=1094,s=552}
            {x=376,m=764,a=3825,s=1272}
            {x=197,m=6,a=431,s=2883}
            {x=916,m=258,a=1016,s=13}
            {x=1550,m=255,a=420,s=193}
            {x=2448,m=646,a=951,s=3294}
            {x=51,m=47,a=1154,s=1582}
            {x=780,m=1994,a=190,s=613}
            {x=2125,m=2036,a=419,s=370}
            {x=3530,m=653,a=112,s=2043}
            {x=830,m=1481,a=1151,s=826}
            {x=39,m=605,a=58,s=1708}
            {x=605,m=918,a=2267,s=77}
            {x=2308,m=436,a=753,s=820}
            {x=2078,m=2190,a=460,s=2282}
            {x=165,m=2188,a=460,s=416}
            {x=2343,m=2285,a=718,s=478}
            {x=139,m=578,a=867,s=3364}
            {x=212,m=26,a=1613,s=393}
            {x=134,m=318,a=237,s=1171}
            {x=23,m=233,a=85,s=876}
            {x=89,m=157,a=2290,s=1932}
            {x=96,m=377,a=49,s=1760}
            {x=1064,m=78,a=798,s=160}
            {x=1983,m=800,a=19,s=1766}
            {x=1157,m=1617,a=1270,s=425}
            {x=145,m=1754,a=517,s=915}
            {x=98,m=46,a=1762,s=1202}
            {x=13,m=359,a=3358,s=348}
            {x=1221,m=231,a=81,s=1975}
            {x=1523,m=385,a=1671,s=1234}
            {x=279,m=96,a=27,s=743}
            {x=1718,m=1694,a=886,s=1199}
            {x=1640,m=77,a=879,s=925}
            {x=239,m=73,a=2374,s=349}
            {x=1774,m=319,a=212,s=379}
            {x=2525,m=693,a=1126,s=1932}
            {x=1842,m=1318,a=714,s=2978}
            {x=286,m=1087,a=916,s=70}
            {x=61,m=205,a=15,s=2176}
            {x=804,m=1845,a=2665,s=664}
            {x=79,m=16,a=1376,s=2558}
            {x=1018,m=1624,a=1798,s=150}
            {x=2670,m=615,a=733,s=229}
            {x=1221,m=2070,a=238,s=201}
            {x=465,m=947,a=1251,s=1679}
            {x=1161,m=1334,a=57,s=1731}
            {x=239,m=388,a=42,s=2493}
            {x=1540,m=3200,a=849,s=89}
            {x=179,m=2098,a=724,s=144}
            {x=1605,m=636,a=3162,s=247}
            {x=1128,m=145,a=988,s=662}
            {x=1716,m=1127,a=1354,s=1470}
            {x=2411,m=92,a=482,s=1395}
    """.trimIndent()
    )
    check(116606738659695, result)
}

private fun test(input: String): Long {
    val (token1, _) = input.split("\n\n")

    val rules = mutableMapOf<String, Rule192>()

    for (line in token1.split("\n")) {
        val (ruleName, token) = line.split("{")
        val tokens = token.removePrefix("}").split(",")
        val conditions = mutableListOf<Condition192>()
        for (conditionToken in tokens.subList(0, tokens.lastIndex)) {
            if (conditionToken.contains(">")) {
                val (operandName, t) = conditionToken.split(">")
                val (numberString, result) = t.split(":")
                val condition = Condition192(operandName, Operation192.G, numberString.toInt(), result)
                conditions += condition
            } else if (conditionToken.contains("<")) {
                val (operandName, t) = conditionToken.split("<")
                val (numberString, result) = t.split(":")
                val condition = Condition192(operandName, Operation192.L, numberString.toInt(), result)
                conditions += condition
            } else throw IllegalStateException("impossible $conditionToken")
        }
        val further = tokens[tokens.lastIndex].removeSuffix("}")
        val rule = Rule192(ruleName, conditions, further)
        rules[ruleName] = rule
    }

    data class Cube(val from: Point4D, val to: Point4D) {
        val volume: Long =
            (to.x - from.x + 1).toLong() * (to.y - from.y + 1) * (to.z - from.z + 1) * (to.t - from.t + 1)
    }

    fun Point4D.variable(operandName: String): Int {
        return when (operandName) {
            "x" -> x
            "m" -> y
            "a" -> z
            "s" -> t
            else -> throw IllegalStateException("impossible $operandName")
        }
    }

    fun Point4D.check(condition: Condition192): Boolean {
        when (condition.operation) {
            Operation192.G ->
                if (variable(condition.operandName) > condition.number) {
                    return true
                }

            Operation192.L ->
                if (variable(condition.operandName) < condition.number) {
                    return true
                }
        }
        return false
    }

    fun Point4D.setVariable(operandName: String, number: Int): Point4D {
        return when (operandName) {
            "x" -> Point4D(number, y, z, t)
            "m" -> Point4D(x, number, z, t)
            "a" -> Point4D(x, y, number, t)
            "s" -> Point4D(x, y, z, number)
            else -> throw IllegalStateException("impossible $operandName")
        }
    }

    fun Cube.setFrom(point: Point4D) = Cube(point, to)
    fun Cube.setTo(point: Point4D) = Cube(from, point)

    fun cut(cubes: List<Cube>, condition: Condition192): Pair<List<Cube>, List<Cube>> {
        val passed = mutableListOf<Cube>()
        val failed = mutableListOf<Cube>()
        for (cube in cubes) {
            if (cube.from.check(condition) && cube.to.check(condition)) {
                passed += cube
            } else if (!cube.from.check(condition) && !cube.to.check(condition)) {
                failed += cube
            } else {
                when (condition.operation) {
                    Operation192.G -> {
                        // x > condition.number
                        val middle1 = cube.to.setVariable(condition.operandName, condition.number)
                        val middle2 = cube.from.setVariable(condition.operandName, condition.number + 1)
                        failed += cube.setTo(middle1)
                        passed += cube.setFrom(middle2)
                    }

                    Operation192.L -> {
                        // x < condition.number
                        val middle1 = cube.to.setVariable(condition.operandName, condition.number - 1)
                        val middle2 = cube.from.setVariable(condition.operandName, condition.number)
                        passed += cube.setTo(middle1)
                        failed += cube.setFrom(middle2)
                    }
                }
            }
        }
        return passed to failed
    }

    fun solve(cubes: List<Cube>, ruleName: String): List<Cube> {
        if (ruleName == "A") {
            return cubes
        }
        if (ruleName == "R") {
            return emptyList()
        }
        val acceptedCubes = mutableListOf<Cube>()
        var unknownCubes: List<Cube> = cubes
        val rule = rules[ruleName]!!
        for (condition in rule.conditions) {
            val (passed, failed) = cut(unknownCubes, condition)
            acceptedCubes += solve(passed, condition.result)
            unknownCubes = failed
        }
        acceptedCubes += solve(unknownCubes, rule.further)
        return acceptedCubes
    }

    val cube = Cube(Point4D(1, 1, 1, 1), Point4D(4000, 4000, 4000, 4000))
    val accepted = solve(listOf(cube), "in")
    return accepted.map { it.volume }.sum()
}

private enum class Operation192 { G, L }

private data class Condition192(
    val operandName: String,
    val operation: Operation192,
    val number: Int,
    val result: String
)

private data class Rule192(
    val name: String,
    val conditions: List<Condition192>,
    val further: String
)
