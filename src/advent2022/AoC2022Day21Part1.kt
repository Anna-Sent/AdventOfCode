package advent2022

private var result = 0L

fun main() {
    result = test("""
        root: pppw + sjmn
        dbpl: 5
        cczh: sllz + lgvd
        zczc: 2
        ptdq: humn - dvpt
        dvpt: 3
        lfqf: 4
        humn: 5
        ljgn: 2
        sjmn: drzm * dbpl
        sllz: 4
        pppw: cczh / lfqf
        lgvd: ljgn * ptdq
        drzm: hmdt - zczc
        hmdt: 32
    """.trimIndent())
    check(152, result)

    result = test("""
        qpmq: nzhs / wdmm
        fzwd: 2
        nttb: 14
        zhjs: 2
        fcqq: 4
        bppv: 8
        jdjd: lzrs * trhh
        nzbm: 13
        jcrh: fbwj - qtdr
        sfvv: cgsf + rsqw
        hgsw: 2
        mpdg: qtlt + bjmq
        mzbz: 2
        ljnn: 12
        hdpr: 5
        ffwh: 8
        tbtb: mppc * qwrz
        fzvs: fbcm * qqnh
        prml: 2
        hbdt: lgcb + hjfg
        rtqd: dnsr + tbhf
        bbhz: 7
        hfld: 2
        fqzb: 7
        pflq: 3
        zfdv: qlnc + gvdd
        lcvz: 3
        nmnl: 2
        gmcs: lphf * ttnh
        wnhv: gcgv + pzqh
        ccqd: cpnc / hjzw
        zflw: 20
        hqqz: 10
        hqdm: 2
        mqmj: bzbv * ljgs
        mpdb: rqjt * fvtd
        gfbw: 5
        swjs: 2
        pjff: wmvm * zcgl
        lpfw: fjbf / nvzv
        sllm: hbmv + mnrm
        qwsw: lhjc * vrmr
        wcrw: 2
        lrfj: 20
        jztb: 10
        lfzm: qpnf + jptm
        vcdq: 3
        lnsl: bfsh * rpbw
        mnvr: 2
        zfgj: hlbc + sdvs
        vjsj: lcfv * ptsq
        pvmp: fddz / lnbf
        ngbf: jbwf * wthl
        gmsj: vzpl + rdwf
        cmtr: 3
        hdrs: 2
        wrzn: ptcg + qhhg
        qvsl: cbff + nrzf
        pljf: 2
        tgtj: 3
        wgcv: pljf * dbfp
        nfct: cgvw * smlc
        nghf: pgsp + tgzr
        cvgj: 2
        fvwv: 2
        nqlb: 2
        ctqb: 1
        vrgv: slqf + whhh
        cjrf: 2
        tqvc: vcgv * pqrp
        qtdr: 14
        wfcj: nmpb * bvhb
        lvtc: 3
        njtd: vmql + vnst
        tcjs: 5
        cwrs: 3
        dgpp: sgls + ddqc
        ggnh: lcpj * wdvf
        mwnm: 2
        lwnv: lcvz * nvct
        vvzm: gngc + thqv
        zhwt: rvjs - brqs
        snsv: bvbw + qltc
        mjnq: lpgb + pvmz
        cqbv: 2
        gsrb: pzdw - gfhg
        gblt: hcjs + vvdj
        sffq: vczm - fzhp
        jssb: bsrv / znwb
        dnrm: npcj - tqmv
        bhbq: lmcq + dlfz
        znhg: 3
        lwsj: vrsw * bmhc
        mzvh: jvqd * nhlt
        rsfq: mvfn * hhrc
        hrrs: snsv + fzvs
        qcrr: rpjr * ffhn
        lqvm: jhld + lqns
        rzmr: 3
        ptgb: bvzp + vzsl
        pbfz: 5
        pqzl: smmz / fvjn
        wwzt: 3
        stcs: mbhw * rndj
        wczb: 3
        qmwp: dwsl / ffps
        crwm: dvth + qvtm
        lmrt: tgjr * crbm
        fpnz: 1
        gchb: dlwj * gnhq
        wqsd: rltw + nchd
        rdsp: 12
        tcsj: 2
        hzff: gfvq + jgwv
        dzhv: tjsg * ghfn
        wnbn: 2
        gffd: hrcq * jfbs
        mvdd: 2
        ldqh: gfzc * gtcn
        zjzn: bzcv * hfgr
        sgcd: lmlr * mtnq
        vrsw: 4
        nzdb: 16
        ngjr: cjrf * gbww
        pqfs: nfjb + lfln
        stlc: 3
        cmfq: 2
        cdsn: vpvw + gztw
        wwqm: 4
        phgw: tqhj + jwjs
        htbr: 4
        wzlp: 4
        btsw: jmqs * btsn
        sndd: 3
        nzcb: 3
        qwnv: tcnb + lzvh
        qtgz: 3
        slrt: jtls + vbjq
        qbhm: pgfd * tmcg
        dbmf: tqzm * mzth
        hlbc: vlpj * mdnw
        djlp: lzmn * bthb
        mlrq: 3
        bhhm: 2
        dtvz: 14
        znhv: wdqc * wbgj
        hmcj: 1
        wdjw: fqzb * cptp
        fdvn: shqh + vjts
        dpmq: 8
        wdsj: bnpc + jnnf
        pdcp: 3
        hcms: pzlp + mgrm
        qpvc: 1
        mnvc: 6
        smnr: wrrq * vtrg
        lbwv: 14
        tqmz: 4
        jgjh: fsnh + tvhn
        flbs: nlnc + mzbq
        rdwf: 7
        bnqv: 4
        znpp: 2
        ctlj: dpfw * wctf
        wzzp: 3
        fsmd: mzqt * ncnb
        whqz: fpcq + rcnp
        pbrm: 3
        bcbc: 8
        vhpc: wwvv / nvzw
        dhcp: vccd * wcbt
        wmvm: bgcb + sbdd
        wrmq: qrnp + dztg
        wppf: 4
        msmp: frqt + smbh
        tjwl: 5
        sjqj: ftdt * bmfj
        rctn: 2
        jprt: 2
        dlrw: 7
        zhvh: 10
        zbjq: 5
        qvbs: 5
        cgfw: 3
        jrgw: mwnm * psmp
        ggvv: cctz + fgvl
        fvnm: 3
        hzcs: djfg * rpcc
        zppw: 6
        pvmz: lwnv + bgwf
        prsv: 16
        wshz: mvht * tdgh
        zpzc: 9
        htpv: vtdn + vdfl
        pvvr: 2
        clgl: jvrb + fhgd
        rtpr: fnql + nmtz
        cbzt: wvbh * fgsz
        bbfr: cbzt + dsbd
        gvlz: 6
        mgzw: bjlg * nvcp
        hptb: lhjj / gmwh
        wzpz: hdmj + qtrq
        spgh: 19
        pzlp: 6
        zzwp: pfsq + svdq
        cjbt: 13
        rzsh: 4
        nvcs: qrzm + slcn
        gsvz: 4
        jjhn: fsfv * jcnl
        lgrs: jlsr * lbwz
        dpjb: rpwc * ctrf
        hqbt: grvh + wzrm
        fjbf: qvgl * sfdf
        bzbs: 2
        jbmw: whrp * pfqc
        cjrc: glnh / qpml
        tmcg: 3
        jgwf: 2
        dwsl: wshv * mtwv
        sprd: hrdg + mrzc
        nzhs: vbbs + bwth
        drpv: 13
        gvvf: 10
        sjzw: 2
        hffd: 1
        nfjs: dgnt + jphq
        bvcz: 5
        jhzl: 4
        dsgz: jlrb * dzmh
        mzmb: 4
        gbwj: dwdj + vrfh
        mgrm: 7
        jrjb: 4
        sclr: 2
        qhhg: 10
        humn: 4468
        lmjj: lnsl / vnwf
        rphd: 2
        pfhh: cvfh * hfjn
        ddqc: nczj * rlfc
        nmcn: qscl + lsmn
        dfmc: rpbl * tjrc
        pzvw: csns * jqnc
        fnql: 12
        sdmg: 3
        rgwv: 4
        djbd: 2
        jsmn: 3
        thqm: zlvl - fqqb
        mtvb: pnzm / bfps
        njdv: 2
        tzpd: zsgz + wbln
        bsft: tmvp / hdrs
        hstz: 5
        szbt: 12
        drpw: 3
        pfjr: 4
        hswr: 11
        ttzt: 1
        tmhl: 3
        lbjb: 3
        lzrs: 4
        rvpn: ljdv + zjbd
        htqm: dbst / fcnz
        qfqs: vvgb * nsnc
        jzmf: zsjf + pjvc
        tsft: gnrt + dwgw
        vrbw: gddl + hqpg
        gtgz: 3
        tfhd: nmpp * qbvr
        rfzg: 3
        lppf: 3
        bqjs: cdsn - lddc
        wqwr: jvzt + zfdv
        mctz: 3
        bdph: 5
        nswl: nhvw * pnfd
        ncqc: 5
        tqwp: 15
        lfhp: wcqc + bcgp
        rqlf: 1
        lddc: 11
        qltl: 5
        jwcw: hjcv * lppf
        hcpc: 3
        bmjd: tqmz + lbjb
        bcgp: 5
        bwvd: pnnb + zjzn
        pzcl: pqzn * tshj
        nzlg: vjnb * plgm
        hqgd: 8
        zjhm: 8
        tzln: 18
        hfgr: 5
        wjlt: cznc + rzrj
        wlmw: bqdv + fsqc
        msgm: 3
        fjpq: zvbj * rchn
        pmps: 3
        rthm: 2
        qrnp: 8
        wdjf: 6
        tqmt: fgnl - vsrc
        shtv: 5
        ppvn: 4
        dgnt: 5
        qprr: 11
        rznv: bwmw * fnnr
        wpzj: tjpj + jddl
        czfh: dtvl + nsrp
        qdhb: hthz + pmjv
        hndn: 4
        blrv: 2
        bddh: qntq * snhh
        dvpf: ftmv - sqfg
        bscg: 2
        szfq: 4
        rtvn: qdvf + qfwj
        gmhn: mgjc * jgds
        lmqr: 2
        gsmd: twjm + hqqz
        hznd: lhpm * vppp
        jlbq: 3
        fqcg: 1
        qqps: flnv * pggf
        wvzm: 2
        vhts: wgbj * gnvd
        vzsl: 1
        mnvs: fvdb * wgmg
        qrpq: 5
        fpwg: hstz * wpfc
        dnhs: dvdq - fjrr
        cpqz: 2
        ldqd: 3
        fmpp: 12
        dlfz: whcm + wmmh
        lgcb: mpbm + hqzf
        twql: fbdp + bvqq
        qhsf: 4
        vnpd: 4
        mjtd: 4
        tchw: ctrw * pzcl
        wvgr: 7
        wjmg: 3
        bzwp: ctbl * fqpb
        lfhm: mbqc + pmng
        hrgm: 2
        wmnq: 4
        fqls: 10
        tswj: 2
        smmz: hjzm + csbp
        pmtq: 4
        jwzg: btsm + bchj
        bhqj: 2
        lzvh: smfd + mdnl
        pzqh: 5
        lwrr: gvgb + lwnq
        nsjz: fbvv + cgrc
        sppz: hfwq * smwq
        zhld: rbll * tjfp
        gddl: 8
        lhfg: 1
        swmc: 2
        bdtg: 5
        vmtw: 1
        pqwm: htbr + bjhd
        fzvc: 3
        pfhp: tlls * rgrj
        cnnf: pmtq + whlj
        whdp: 2
        lcfv: 3
        whpj: 9
        fnlm: 13
        vvhn: vqsg * rszn
        dfgd: 2
        svdq: 20
        fjmt: fvmm - vfrr
        mqtl: gvch + wtsl
        ndpn: gtgz * tbzw
        tvhn: 19
        dhfw: fvpg * qpcv
        cgrc: qzsq * whdp
        lwnq: 9
        plsl: rbjl - nvzs
        tpsd: 3
        wjts: 5
        grjc: 11
        cdqb: hgtd - hmlc
        hdrz: ngfg / gpqd
        glnh: lwfj * rphd
        vfmp: hjzh + rsfq
        pzrd: 3
        ptcg: sgcd - hcts
        fhdd: 3
        vjnb: tclr - vmtw
        pwfl: vttr - sjdt
        nvmg: 2
        ddqj: 2
        cngv: 3
        bdgs: 2
        mgzn: hqbt * dqrd
        btjz: hnbh + qrjc
        bfsh: wjbp * bpfn
        pzlc: dhbc + lhzf
        lsnd: mplj * jsdv
        wqhw: pbgw * nvhg
        lmpv: hvmq * nfjs
        dqrq: hncr * sjfw
        znbb: jpmd + jrjb
        zmbz: 2
        qtlt: 8
        vtwv: vnbj + bfft
        gcgv: zbcf * qpbh
        bdqv: 2
        pdwz: dssp * hfbc
        rpcc: ghfp * nqjb
        ddmq: 3
        gbsr: crql * pqwm
        rnqj: 5
        mpfl: gdjl + ngbf
        qbff: 2
        pqzn: 2
        ptzd: bstz * pmnw
        mcrh: 3
        hmdj: 3
        pcmd: 3
        dpbv: 3
        vrzg: 3
        fths: fmnt + wdjw
        fvqv: 17
        bgbf: 7
        pbdm: sfwt + mcsq
        lcpf: 6
        fcgl: 8
        qjfm: jbgd + nvln
        qbfm: 3
        tpnw: 3
        pbjs: 3
        psgw: hzbt - fbjp
        sbhp: 4
        jtjr: 2
        nsmq: stjz + nfdm
        jjgl: 11
        qwtc: qtjg * lbmj
        pzdb: wjbh + tsft
        tdsv: zstr + mrzw
        jsfp: tjbj - mjjv
        vwqm: 11
        dfvp: 5
        sblt: ncdm * jdmg
        hhdg: nhcs + nttb
        whhh: 1
        zhtv: 2
        ntlq: 2
        jmbg: frcj + whmc
        gvch: 6
        ncnb: sfvv - hzrm
        trqm: 2
        bvgn: 2
        ffbl: jbmw + lcft
        wrqv: 4
        dhbc: 12
        szgh: btpd * llmp
        vccd: pgtq + gpsz
        blrn: 1
        znwb: 2
        mqzf: 5
        lhjc: fbgg + vjsj
        jhrz: wmgg * wptr
        nvdr: 2
        bnjq: vwqm * pmbq
        hdmj: hdlc + rnnf
        bcts: 15
        nbqt: jnzl * mcrh
        rqgt: 15
        whdw: 2
        dtrv: hhrz * plsl
        ptrp: jjfd + tlvw
        rlsz: 3
        wgpj: bnfp + wpzn
        vcfh: dpgt * jlbq
        dzbt: 2
        wplq: vjzl + nlmg
        jwfm: 2
        fnsw: 3
        hzbt: sbvd * sgjj
        ffpp: tccp * msmp
        ghhh: rpjm + lcbh
        fcbl: 2
        wwmg: tcgh + mtwm
        qzfb: zdbz * sffq
        njdh: vbhq - tqrw
        fbqq: hfrr + lwsj
        sgjj: 19
        fptm: msgm * tbss
        njjz: cdrt * sgzd
        pgsp: bvgn * jtfh
        ptgt: 2
        rprb: dcjf * jbzz
        nvcb: qmgz * hrwh
        hltv: fntd + gzmp
        hcts: 8
        whcm: 12
        dpfw: 2
        jpfn: 5
        ljdq: hwdb * jmfl
        fntd: wgsg * ndnl
        cznc: tvhp * zrdb
        rcnp: 12
        gpsz: 2
        vcgv: hqwt * shrn
        cdrt: 5
        lghf: 5
        zdnf: trvv + ljsd
        zvgv: 6
        pjvc: gvvf * fhtr
        smwq: ptgb * bfjs
        ljgs: 2
        hbrd: sjgw * dbmf
        hgdp: snmj * bzhn
        sjmf: qdhb / rzdq
        vjzl: bndh + bpcr
        vvdj: 15
        pqlq: 5
        cjfv: 2
        bzjp: vwpj + wsnn
        pfwb: 5
        fmhh: bzjp - lvjr
        gngc: jtgc / wndc
        wgwp: plql + pfwb
        zmqc: spsc * tzfm
        dwrz: 2
        vcmg: 3
        jlgp: rvjr + chdc
        bzhn: hrnj * hmtb
        vnst: gdtc * znhg
        sgph: 17
        jdwr: hrdr + gsmd
        mnbn: jpcg + fjmt
        zrdb: 12
        dqpb: tcwv + jdjg
        vhsr: 7
        wctf: 3
        pqrc: 5
        jcqj: jssb * qzhb
        tlfb: rnfn * rvcg
        nprh: 2
        nqwr: npvt + tlfb
        qtjg: 2
        bthb: 2
        chdc: 3
        vflc: lrrc - hpng
        bjgt: crzc * qtvz
        gtrf: fwgg + zlpm
        zdbz: 2
        tqhj: 8
        shrn: 5
        mzcd: 2
        bgcb: qjmq + pppm
        lrqm: 3
        fqbp: dsgz * wswc
        cjwv: gwwm + gpvj
        drnv: mvdd * cgfc
        wzqm: rqzj * fswf
        vrdb: cggh * vpwf
        rwsl: ljgn + rrvd
        fcrp: 1
        ntjz: 13
        mqbt: 11
        vpqp: csfj * dfvp
        gtch: 3
        hcww: 2
        sjdt: gmcs * mzhg
        ljgn: cmlr * vjvn
        zrjm: nnrh + zdqt
        tbzw: 2
        fvdb: 3
        nsst: lfds + zmgm
        drbb: jpfn * rqsv
        nfjb: frfg + cjrc
        bnjc: 9
        lprh: 10
        hbmv: srch * gvwf
        wmhr: 8
        szjt: tzpd + rqlb
        fptp: llnm / mbdl
        qdsb: lrqm * hmsz
        crql: 8
        mlhv: rbmr + tqvs
        mmhc: blrv * fzsw
        cjng: 3
        dwwm: 4
        hlhc: 2
        lhzf: 2
        nrcz: mpmb * mqjn
        scrm: 16
        rnpl: 16
        hgnq: wnpp + fwds
        nwvd: 9
        zcsc: 8
        zwhq: 1
        jrgq: zfgj * whzp
        cwrn: wvgm * hrst
        fqqb: 3
        bmng: 3
        wdvm: 5
        ljsd: 12
        bdvg: qjjs * pmpn
        brqs: bzwp + rgbr
        sjfb: cdqb / twrd
        mhmd: hvmv + wzzp
        crdg: wcjq + znhv
        cgvw: 2
        jcnl: 17
        bdcf: mnfb - njtl
        crbm: 12
        shld: 3
        sbdd: nvtc * wpzj
        gnrw: 12
        bfhj: jzzg + njjz
        tnqv: bqlq + fdwj
        zssw: ljnn + sqvv
        sttc: 2
        hvmv: zrjm + rnhf
        dlwj: 8
        jpcg: wzqj * bhjq
        lmql: 3
        dwhb: qvbj - lfhp
        bggc: 2
        cqjq: 5
        rglf: nzcb * nbzg
        nnhn: 6
        hjqc: 20
        pzcq: 3
        zvmn: bcmh + ncmq
        qlzg: fgqf * zwrz
        sbvd: 3
        nrrp: 3
        wchb: 1
        gfvq: clns * smfb
        tlgl: 5
        vmhb: tpgj * bcts
        hwns: 15
        bnqr: 3
        zrtj: 6
        cqvf: wtcc * vcmg
        pmgz: 4
        jwrh: 11
        cbsn: 18
        qpbh: 3
        pqjw: 6
        ctrw: 3
        jcjq: 19
        mdnw: 3
        pmbq: 2
        wbln: qjfm * zhjs
        gbww: mtnp * fptp
        gdwj: btms * vqgh
        dssp: jcsm + tlgl
        ztnr: ntdv * nvmg
        dhpw: fdqn + glnm
        fzsw: 4
        jbzz: 3
        zfcd: gsrb * fcnv
        ftfh: wrzn + lftv
        vshd: mbmb - gnrw
        bvhb: 3
        vzpl: 4
        zmgm: vcfh - qmsp
        jtls: 19
        cpbd: 1
        cqsd: 2
        wrtl: gvnc * hmdj
        gfnw: mnqt * zptj
        vsns: 3
        lqnt: nhfb + zpfj
        hjzw: 2
        tvhp: 3
        gnjp: 3
        zwlg: 5
        csfj: 5
        pnpw: 9
        vwwb: 3
        szvz: 14
        mldq: zjft + rvpn
        ppgd: 6
        qtsv: 3
        ptvf: 3
        fqrq: 4
        mzdh: pvqp * rfps
        grsp: 2
        bfvq: dwzn * mtvb
        bvmz: 8
        nrcj: lpqh * mngt
        hfrr: ldqd * mnqb
        hsmb: 3
        ptrw: 3
        dmcg: 2
        wwqh: mmhw * jrvz
        srwp: 2
        psvr: cccz * jprp
        qnrz: 5
        tnfp: bwvd * lvgn
        tqmv: 4
        fgnl: 20
        rwjq: 3
        wvst: 3
        nhzc: 7
        mzqt: 2
        djvm: 3
        fnlh: 9
        cqrv: 18
        gfnb: jcrh * vngz
        lrvv: ssqw * cpqz
        fzmq: 13
        rpjm: lpmt + zdgc
        mngw: pzcq * bdbn
        cfjj: 3
        vrfh: 5
        bjbs: fzvc * pcmd
        tnvr: 2
        vrwc: zgwj - hdrw
        bnfp: zmlj + fpnz
        tjfp: tbtb + fcgl
        dwgf: wtjm + rqgt
        snmj: 2
        lmcz: shtv * ndvd
        rdvd: vmfb + fmcb
        vpwf: 5
        rpbl: 2
        pztw: mzmb * qcms
        scds: 5
        bjlg: 11
        swbl: 2
        qwjs: bbdr * jrst
        pjqc: 3
        rtcv: 3
        gvwf: 2
        psqq: 6
        hnbh: fths + cpfn
        ssqq: 5
        rrwv: stsq * fvfg
        tgwf: mlpv * qclt
        pwzv: grjw + hrbz
        slqf: wcrw * wmbb
        sfpj: 2
        vjqr: vfmp * hrgm
        ndzf: rdvd * zfjd
        rvln: 2
        chnh: srpq * jptr
        bvqq: 7
        zqtd: 7
        nmdw: fbnq * ngnv
        bmfj: pmps * pqgr
        cctj: 7
        njtl: hfnd + ptjq
        cdct: wppf + gnqd
        hggw: 16
        jmdb: 2
        gwnb: zqzv + wlrw
        grjw: bhhm * sbhp
        jjqj: 4
        tnrg: pbdf * bjbh
        pmrt: rvrs * hsnd
        plql: 2
        ghrd: bflv * pmgz
        dstf: qmtd * cwrs
        ltdf: 7
        vppp: njdv + hwhv
        qrzm: zdpb * wzqm
        bqfb: lfbs - sfvn
        hvmq: 2
        qmql: 7
        hmrt: 2
        fhth: sqng * rhtc
        hwgj: 2
        hgrz: hhwr * fvqv
        qgcs: jrgw + sllm
        gqdf: stcs + jwhz
        jdmg: gqnh / dvsf
        nndr: slcg * ghrd
        cpcd: fsfq * cncj
        slcg: 10
        cqvz: mlrq * lghf
        bjbh: 4
        smfd: lfhm + bsft
        jsls: 2
        hjzm: grjc * fqgv
        rswv: ntlq * llgg
        vvpf: gsjg - fqrq
        whlt: sscf * bggc
        cggh: 4
        nczj: pbjs * fzcj
        hmrb: 3
        pnzm: vcgq * gdqf
        pmjv: rrwv + sfpj
        vsbh: 2
        tbss: 9
        hhrc: bldd - dpqt
        hffw: tgbq + fdgf
        dhbr: 8
        fjrr: wgtw + bptm
        sdvd: 2
        whmc: hbwn / mtdl
        qbvr: htvb * jhzl
        jtfh: cqbv * wcdr
        tpgj: 3
        dsbd: rwjh + sqdl
        mmln: rvrw + nzlg
        sbmm: fwfp - mwsm
        lphf: mrzb / fmtb
        hszt: 4
        gnvd: mwvh * hmrb
        tnnr: 5
        qcms: 5
        wwwd: lfzm * tswj
        hgtd: wrwp * rcwm
        mtqd: ddtq - qvbs
        rrrr: hmbn + wrpm
        jcsm: 2
        wpwh: 16
        stsn: 2
        ggcm: sjqj + bfpt
        mcml: 3
        ndhv: 2
        gsnm: 3
        lptl: 2
        lhsw: wgwp * bbhz
        rjfh: 3
        zdsc: 4
        qssw: jrgq + szgh
        gztw: pdwz + wddb
        jgwv: 2
        nvrs: snff * lzcb
        rvrs: 8
        lzfc: ntsr / cdvb
        slpd: 2
        rtzz: nsvs + ftnh
        mrzc: gvhz / hrfb
        qrgn: zfcd * wshz
        qvbj: wgpj * jwgh
        qdfc: hptb * tcgr
        mnrm: 2
        dpgt: 4
        mblc: 3
        nvzs: 1
        wnpg: 8
        nzfd: 7
        hzrm: 3
        cvfh: 9
        cctz: 20
        zhfc: 3
        mdhp: zwrt + cpzn
        bgjt: mzbz * nqsc
        qwdz: dwlm * jztb
        lwsn: 2
        zjnd: dccj + nsjz
        ldww: 19
        rhtq: fctn + dlcr
        lftv: bhvv + gqdf
        hpcg: 2
        htvc: 3
        cmpj: 4
        ffhn: zstp - phgw
        tslj: wsjd - gjzb
        wshv: sprd + jsmn
        rmls: 3
        wpgj: 5
        llsg: brwr + npnq
        czvl: lgds + nrmj
        gtgn: 20
        wthl: 9
        tlmw: 2
        zjmr: pczn - gfhp
        fdgf: qlvs * sgtv
        lqtq: wwqm + wftg
        hfgh: 2
        zptj: 5
        lpqh: 2
        rbll: 3
        cccz: fmhh + dstf
        nvln: gfbw * tjth
        lhjj: mpdb * jdrv
        sqng: 3
        bbpr: 8
        gvnc: 2
        szfh: 1
        mnfb: mhvn * qfsn
        wdvf: 2
        gqnb: jgjc * zrtj
        sqgn: dfgj * ppqj
        mngt: szfh + mdhp
        lsmn: hbrd + dznj
        gvhz: 14
        fjvg: 10
        bdtv: 2
        qwqh: vmhb - wgbh
        lmlr: 3
        hdwj: mwjj * wvgr
        rnnf: 19
        sphq: qbsn / pcwc
        rfnp: 2
        vsrc: 1
        jvtr: 2
        ntch: 2
        nzlp: hwgj + bpwt
        dwzt: zfcc * ffqn
        hzgn: 17
        tlcs: jzpw + wshq
        gbdt: cbsf + qvcf
        mqjn: 7
        bqlq: 4
        nnqf: 2
        qfsn: 6
        rqsv: 5
        sztz: 7
        jnnf: qwnv / wfnl
        vmql: 1
        ngpl: 4
        wchr: hqpz + rprb
        chlt: 4
        rsrm: 4
        qvcf: mrlw * fqhz
        bzbv: vbsc + tzbl
        jnzl: 3
        wshq: lhsc + slpd
        zqvz: ljdq + ngjr
        fjrf: 8
        wwqr: 2
        dwgm: dlpf / lmqr
        zstr: pbtq * mdng
        ggwz: 7
        jfnm: 1
        qbbf: 3
        zpfj: cqsd * lwrr
        llgg: gchb + sspj
        fdwj: 3
        twjm: qcns * ddgh
        wrwh: 2
        wzhl: vsbh * jnzc
        hwdb: 3
        bmbp: 17
        jrvz: 7
        wqlr: 17
        gdvs: hqgd + dwgm
        jgjc: lqlm + sblt
        nnbm: cvnl + mgzw
        vrdg: 7
        mwjv: 8
        vrcc: 5
        sdmq: 3
        root: lzfc + qrgn
        jwhz: 3
        hjzh: pfhh + czvl
        cbsf: rswv * htpv
        rhtc: gmhn + pmqj
        nncn: qmzz * stsn
        bldd: tgwf - drbb
        tdgh: smnr + sbtc
        cgfc: htqm - vvzm
        hjqv: 2
        bbfq: cdhn * tnvr
        fqqw: cfgc + qlmj
        tngq: 4
        htvb: 8
        nsmm: bnjc + psmv
        hngs: wrwh * whqz
        cvnl: ddmq * frms
        tzcr: 5
        rszd: 6
        rnhf: 5
        bvfd: vrcc * nfwb
        dnsr: bnjq * zdsn
        glbh: 4
        dvth: jshs * rvwf
        chtf: 19
        ftnh: mwnq * vrdb
        bvbq: dzhv / dwln
        vjvn: fsmj + mqds
        sscf: vmhg + zmqc
        rtzs: rznv + hmln
        tjpc: 2
        lmsm: 4
        pmqj: 5
        nrmj: htts * chtf
        wdbv: 4
        hvgz: 2
        hrdg: 12
        vfgh: stgh - vcrs
        rqjt: 3
        hmsz: 2
        nmpn: hndn * whdw
        nbzg: 2
        lhrf: dvpf + nflg
        gchc: 4
        wnfv: 17
        nsrp: 11
        cbbd: qprr * tnwv
        rgwd: 18
        nfnp: 11
        zwrt: hdwj + gwnb
        mzct: 4
        rgbb: qbfm * nnhn
        sdzz: 5
        wrlb: jcvr + nzfd
        gqnh: nnfm * zmcf
        nlpf: wwwd / rctn
        mmhw: 2
        vcqq: rtcc * gtgn
        djnr: 3
        mbqc: bmvf - qbnq
        hqfs: mmhc - zzfz
        rzlz: 3
        jzpw: 8
        ccfm: 2
        lcqd: jwrh * jbvs
        gcdq: 2
        zrlh: gmgg / cvgj
        wzqj: lrfj + zrfn
        hfnd: qfqs + cvhn
        fswf: 3
        wpzn: ndhv * mqww
        rcwh: 13
        ncmq: smdh + lwlq
        fqpb: 6
        rbrb: 3
        zqlt: mrvz * fwst
        hrwh: 2
        gwgn: trnq + fqvq
        stbr: 6
        blwr: 2
        twrd: 3
        bsbn: 2
        gdtc: 2
        wwpl: jsrg / ndpt
        tcgh: 9
        flnv: 2
        vdqw: tpnw * jjgl
        chns: 1
        dvzl: vvpf * btjz
        dtqf: 16
        hpdn: 3
        spmh: fflc / fhdd
        wndc: 2
        mdnl: bszv * brwc
        qrmj: rtqm + fvwv
        sfdf: 2
        tmbv: sjfb + bbfr
        czjl: bvfd + dtvz
        fdzq: bdcf / mqzf
        fcnv: 3
        hlzz: qpvc + ngsj
        spsc: 2
        wqqg: 1
        gjtp: 3
        dfgj: 6
        dwlm: 13
        fhgd: 5
        dpqt: rqbv / wwqr
        rvrw: zrlh + htzb
        slgm: dqpb + lsfj
        cdvb: 3
        wvbh: snjq * lmjj
        gtwg: 19
        njdw: djvm * bmng
        tlls: 13
        vnfw: 2
        hrst: 4
        fpcq: wcbb + jdgj
        ddgh: 5
        lzbb: 2
        wcsz: hsmb + clst
        tcww: cdpp / gvrj
        hjgs: qbhm + vbng
        nmfb: rvln * plsc
        qcns: 3
        sjrv: 3
        hmbn: znvd * fqbd
        jgds: 2
        bmhc: 2
        pgfd: fhcd + pdcg
        cvhg: 3
        ctmz: jgff * nmpn
        qvpp: 3
        rcwm: czmz - ndzf
        crzc: cvhg * bgbf
        bjqb: 5
        vcrs: 11
        wcqc: 14
        qgrt: 17
        dlhv: tnrg + qcwp
        bhjj: lfjs - cfjj
        gmhf: 4
        zvhz: 7
        rmpv: 5
        fjfn: hrrc - hbfh
        fwrj: wbmp + rcwh
        lhsc: tmtp * whpj
        wqmv: grsp * qggt
        hrcq: 3
        mtnq: hpdn * zsfd
        pvwm: qrgs * nnmf
        zlvl: bvfz * vrgv
        fbvv: 5
        hqzf: fsvr / znbb
        mpmb: 2
        dbst: tshc + mldq
        njpp: wlwb + vpqp
        zbbf: 5
        cfpl: bhbq + vnwv
        pbgw: 5
        jdgj: tqnl + wrmq
        cfmc: blwr * tnnr
        lclm: cjwv + bqzv
        npvt: rfnp * pwhj
        hdzb: 19
        vdjl: gggd * dlhv
        vtdn: pfvc * vsns
        jvrb: cqzs * bdph
        jbbn: 2
        mgjs: 14
        bgwj: 19
        cljf: 3
        grvh: hddl * nzbm
        qsfd: 5
        wgmg: ghlw * bsth
        tdnt: wvbz + nndr
        fsqc: dbgz + phcg
        gdwg: lpfw * wnbn
        rnzc: jjhn + zflw
        zdpb: 3
        btps: 2
        nrzf: gcpv * zvds
        gqgr: wzlp * hjqv
        gggd: 2
        snjq: 5
        tjsg: 3
        ztcg: 2
        btsm: 9
        hmln: 3
        lzmn: zzwp + ndpl
        tccp: 2
        hsgc: mtml + gfnw
        ffql: 2
        jbdc: pqlq * sdzz
        bpfn: nbqt - sclr
        pbdf: 5
        pczn: cfbs + wzcd
        zjbd: ppgh * wmhq
        tjpj: 1
        lbwz: jnfl * rqjz
        grrj: wrcj * fsfz
        zwmd: 10
        ntdv: qrmj + rhlp
        dwln: 3
        wlrw: 2
        bjmq: cjng * npsc
        jprq: 2
        tqzp: qwdz + dhlm
        dmvz: 3
        nchd: vwwb * gdwj
        wzrm: wgtr + hjqc
        mrvz: 13
        htzb: fcqq * nqns
        lwlf: 3
        wvpr: qchb * wbcg
        sgdl: 13
        hcwf: 7
        rchn: 5
        jlrb: 4
        bjpr: 2
        wfnf: 10
        fmcf: lwsn * lqcm
        whlj: 9
        pcwc: 5
        fspf: gqrb + qctj
        qmtd: wmdp + fmnv
        dprw: 1
        bndh: qwtc * qwqh
        sbtr: sggt * hcpc
        vndb: snpp / hztf
        lvjr: 2
        vghc: 11
        pppm: zmbz * cmtr
        vjcb: lmpv * mvzm
        npcj: scgz * frgz
        mnqb: qpcr / tzcr
        qncv: bscg * hngs
        qmsp: 1
        gdqf: 12
        zsnf: drpv * qfms
        frmf: ggmn * rnzc
        hncr: lbnd + hcms
        mtwm: 10
        jpmd: 3
        chjj: 12
        clns: 5
        brwr: fmnr * tgtj
        jmqs: 3
        ptcb: 3
        qntq: bjbs + bfws
        qltc: 3
        frms: vflc / mvgr
        pfsq: dvmd * mwfg
        smbh: scrm / sdvd
        hdrw: jtjr * cjbt
        gmgg: dtbq * bnqv
        hfjn: zppw * qdsb
        ffrt: pncl + bchf
        lgds: sztz * dhfw
        ctbn: 2
        fvtd: lhtd + wvst
        qfwj: gvlz + zfdw
        lqwf: 5
        jlsr: 2
        smlc: sllf / gdrr
        rrtr: sbtr / mcml
        jpbr: rgwd * dfmc
        ffjt: 2
        lqns: nrcj * dpbv
        rqlb: vghc * sqvb
        zqhd: 1
        bnpc: bnpm * hgdp
        jzzg: 14
        lvnj: zqvz + zhwt
        bsrv: qdtb * jlbz
        rvjr: 4
        gvgb: qgrt + tvwc
        mgjc: 3
        mvzm: 5
        btms: 3
        psrn: 10
        cfbs: zqhp * djnr
        hcrd: dshf + fqqw
        hdlc: 3
        cccg: ddqj * bbcw
        tqrw: 3
        jprp: 12
        lhpm: 2
        lpwd: hfgh + gtth
        zvbv: nvtp * pdrn
        cqrt: 3
        rfps: 9
        wbbm: bthp * chnh
        swlp: twql + cqvf
        wbcg: zrqd + cmpj
        whtm: ffrt * pnpw
        zfcc: spbg + nsst
        vnfb: 20
        nqns: 8
        ppgh: lcwr * jwzg
        rfqd: 17
        pqgr: 2
        ggjh: 4
        cjmp: 17
        fwfp: pbrm * zjmr
        dtbq: rzlz * rwjq
        qzsn: 7
        cqvt: jwfm * czjl
        rstz: mhqg * tbcl
        vngz: 2
        pvqp: jmlz + rqjf
        crfv: 2
        qdqb: 11
        pfqc: 3
        hztf: 2
        ljdv: zwlg * fvfh
        tgjr: 6
        nvzv: 3
        bmvf: ssfs + hzff
        fmtb: 3
        bptm: 19
        pncl: mpfl / dzbt
        hfwq: jgjh + zftg
        dtvl: 18
        gjvf: 2
        btpd: 2
        qjtf: mjnq / rrzj
        zcbb: fsmd + pmrt
        zzcz: ftfh + vcqq
        vnwf: ffql + pzqz
        gvrj: 6
        nlsd: gbdt + mmln
        gzsj: 3
        sdvs: jwcw + djqf
        rtsl: tslf * rmls
        tcnb: qltr * spgh
        lqwr: szfq * clgl
        vmwr: 14
        mqds: hljh + rdsp
        nqjb: 3
        zpms: 5
        mzhg: 2
        nnrh: ngpl * hdbw
        fqbd: 8
        dcjf: 7
        bzwb: vvzn * hvcf
        dbgz: mdnc * fnch
        gtth: fqmg * gwjt
        wmmh: 3
        tcdd: 5
        fglw: zcsc * vnpd
        pqrp: 2
        mrzw: bvcz * dtrv
        frqt: 3
        lvgn: 2
        rqjz: 13
        fctn: jrdv * sltz
        ctgl: thlp + zwmd
        bpsh: 2
        pmnw: qqps + bpdj
        fsfv: fzvf + zpms
        jptm: 8
        qpcs: 7
        bfws: 20
        ngsj: 11
        jbvs: 3
        rjdb: fpwg + jdjd
        fqhq: tlmw * rtqd
        jvqd: 5
        zddb: 3
        gpvj: dhzm * nrcz
        sqfg: whlt + sqzc
        tflc: 3
        wcdr: bsdz - cngv
        rssj: 4
        mvwh: 4
        gfzc: fjvg + vdqw
        gjjn: tlcs * btps
        llld: bfhj * fvnm
        nglf: 11
        bzth: 1
        qflc: lthr + ndpn
        zvds: 7
        psrs: bdqv * pflq
        zsgz: 9
        wrrq: 2
        whzp: wfnf - jfnm
        gvdd: 4
        mpbm: spnr + zcbb
        qjpf: rtcv + dwwm
        tvwc: lmql * qsfd
        vczf: psrn + zsql
        gpss: 2
        wnpp: 18
        cvcn: 5
        qfth: jbbn * hdrz
        rgrj: 3
        wzcd: 15
        hjfg: qwsw + lvnj
        fshs: 3
        gtcn: 2
        fzvf: 2
        ngnv: wvpr - whcf
        mwzv: 2
        sddf: qtsv + pjpq
        fzcj: 3
        gpcq: psvr - dstn
        fwdq: 2
        jnzc: ntch * nzdb
        flnd: 3
        wgcp: mgcb + wchb
        qpcr: vfgh / swtg
        djgj: lbwv + mqtl
        pbcn: hzqv * rjld
        shqh: 3
        rvwf: 13
        wtpp: 2
        cpzn: rzmr * twtp
        bwth: lfnc * nbws
        jjfd: pqrc * tjwl
        cdwz: 17
        vnbj: qvsl / dmcg
        srfh: trhd + lmcz
        mvht: wsdr + wplq
        pmmw: 5
        fvpg: 3
        sqzc: wwnn + mrmz
        fbjp: tcdd + zjhm
        dzvw: vnfb + rfzg
        frrg: wmqc * htsz
        lmcq: qdqb * ffpp
        dhms: zznd * qbff
        mwnq: 2
        mwjj: 2
        hqpg: 5
        sbtc: fsvw * hsgc
        dlcr: wdvm + chjj
        mqzl: zvmn * vrzg
        hmtb: 7
        zrfn: 11
        rnfn: 13
        bfhl: tslj - ccfm
        mvgr: 3
        grfm: 2
        pjpq: 6
        hfbc: 5
        hqtw: gjtp * mwzv
        hjcv: 7
        lwfj: 11
        wtcc: 2
        hrnj: 2
        btzt: tmbv * mlhv
        fcnz: 2
        nmpp: cfmc * rrrn
        pjqj: ggjh + vgcb
        hpng: rszd * fnsw
        wldm: fqrl + sgph
        fmnt: jjqw * ctsl
        ndrc: pfjr * wnhv
        wsnn: 5
        fssp: qcpl * zvcm
        hcjs: ffwh * lzbb
        lrlq: vshd + nsmq
        hdbw: 4
        bgrn: 3
        cltt: 9
        qpml: 2
        zcmr: 3
        lwvd: 2
        mdng: dlsg * nprh
        ngfg: 14
        mplj: 2
        jqnc: ggwz * djbd
        ttnh: 3
        gqwq: wchr + bmbp
        cmng: 3
        lcbh: wzhl * mtqd
        mdrb: nrrp * gtch
        gjpt: 4
        tpjs: 2
        bcmh: 9
        rmwg: 2
        tlnb: 19
        tgln: 7
        plzp: nlff * hlhc
        whvt: 3
        bszv: 2
        mbhw: nwvd + hqdm
        bfpt: cbpp + nvcs
        jrdv: 3
        zlpm: lqvm * sdmg
        hhrz: 2
        mnqt: 5
        dpmw: 11
        mtwv: lcpf * lfgl
        rvcg: rssj + dwzt
        fbwj: gjpm * gdvs
        hrfb: 2
        zwqh: 3
        vsqm: 5
        hwhv: bgrn * jtzd
        shnq: hpcg + sljf
        bdbn: fspf / jcmr
        vrmr: psgw + tqqw
        wmqc: 2
        fsgw: cqvz + fnlt
        bvfz: vczf - rjfh
        wsjd: ctbn + bpss
        bwmw: 3
        pdrn: 3
        nzwt: 2
        csbp: mgjs + tpjs
        gtss: 7
        htts: 4
        scqm: 6
        hqpz: 3
        fmqv: hcww * mdrb
        rbjl: lvtc * gdgm
        bqdq: rqlf + ctlj
        thlp: 8
        ddtq: vdtj + fmpp
        gfhp: 5
        fgvl: zpzc + ndrc
        pnfd: 5
        hthz: qflc + pbcz
        fhtr: 15
        ffzq: fpfr + nghf
        bhjq: 3
        dcpd: nmdw + zpqz
        qvtm: bpsh * rtpr
        wdqc: 3
        tjrc: 11
        jzgf: qpmq + jjjw
        ctsl: fnhp * rtzz
        sqvv: 5
        fhcd: zcfg / whvt
        jtbh: cjmp * bpsq
        gzmp: rvrt + rnpl
        pbfs: rgvc * wwmg
        dccj: 2
        fwst: 7
        lcwr: 2
        mppc: 7
        pnnb: 12
        szfl: pbdm * qbbf
        hzbq: mwjv * ffnc
        sfvn: 6
        csns: 9
        fnch: ndlz - plnv
        wpfc: 3
        zpbr: crdg * jbjg
        nqsc: swlp * znhm
        bhrc: 12
        ndpt: 4
        djqf: 5
        rszn: 12
        vtwz: 10
        ptsq: 3
        bzcv: 5
        thqv: rglf + rrtr
        bstz: 2
        bvzp: 6
        tqms: 4
        sllf: gbwj * bzbs
        brwc: 5
        nfwb: 3
        cdgf: 2
        jtbg: jdcf - sqgn
        whrp: lpzz + szvz
        hvjr: wpwh / wtgj
        wgbh: 5
        lltw: 2
        qjjs: 15
        lcpj: dwgf + qmwp
        nvct: lzzv + zdsc
        vnvj: hgnq / bspr
        mfbd: 12
        rwbv: zzcz + qssw
        ltjl: 7
        nwnv: 3
        tzfm: 4
        jcvr: 5
        bqzv: zstb * wwzt
        nzjs: gnmb + nvcb
        gqrb: tlvc * zhtv
        frcj: 6
        nzwd: gjjn - fwrj
        qzsq: 5
        tmtp: 3
        vmcp: djjz / bcbc
        fsvw: gtss + frrg
        lfln: cccg + hmcj
        jvlq: cqrv + sgnc
        jhdq: vrbw + qlzg
        jtgc: mgzn + whtm
        tgbq: drnv - dpjb
        pwhj: fdzq + pwfl
        spnr: fjpq + sppz
        mctq: gblt * ntpf
        qjth: 3
        ppqj: 2
        qmzz: lsnd + wmsb
        bpwt: cbsl * zddb
        hrbz: 3
        jvbt: 4
        qdtb: 2
        cptp: rnqj * ncqc
        rwjh: bwqp + nmfb
        rgvc: 3
        nbws: 3
        lzzv: 9
        lhtd: 4
        fnhp: 3
        tlvc: btsw - shjt
        jcmr: 3
        spbg: 2
        wbgj: 3
        dstn: lqtq * bqdq
        tnwv: 5
        rpwc: slrt + dpmq
        frfg: jqbv + chlt
        slfp: 2
        zcfg: nzlp * flnd
        ptjq: hqtw * fhth
        fqhz: sdmb * tqmt
        zmlj: lpht * hgsw
        lbdc: stlc * nnbm
        lhdh: qmql * wpgj
        zwhm: 19
        rhlp: 17
        qdcw: lcqd * pvdn
        nppj: 2
        zgrb: 3
        gwjg: tpld + hdzb
        tzbl: 11
        dztg: 3
        ffdm: 2
        ffnc: qwrq + lgrs
        vpvw: pjqj + qvcg
        fnlt: nlpf * bhqj
        ghfn: dlfm - dgtt
        nllf: 4
        czmz: nqwr / nnqf
        mtnh: 2
        dsnr: 5
        nhvw: 5
        jtzd: grrj + qrtz
        cqzs: 3
        lfzd: zqlt + vjcb
        spqm: 3
        stgh: bqjs * rbrb
        nhcs: vrdg + tqvc
        stsq: 3
        vczm: rtzs + dhpw
        tngn: qwjs + blrn
        rncq: 3
        zcgl: 3
        vmfb: rtsl + rstz
        tjth: 2
        smdh: psrs + dhbr
        pdcg: nzwt + vtwv
        wvgm: 4
        ndlz: sjfr * gjng
        wptr: 2
        fmwm: lbtd * ndcz
        sjfw: 2
        wcbb: 4
        pzqz: 5
        shjt: bbbv + fsjm
        lbnd: 4
        jwtg: 2
        rngn: qdms * tflc
        qzhb: 2
        lmnq: bjgn - fmqv
        gnqd: zbjq + brfp
        pfvc: 7
        sgtv: jvlq + zvgv
        pbcz: 17
        vbng: vjqr / mzct
        lqcm: 17
        wjqd: bfhl / sllh
        dvmc: ffbl + tdsv
        psmv: lpbf * swjs
        stjz: hhqz * gnjp
        tqmc: ggnh / ptgt
        lhmt: 20
        lfgl: vqcl * lwvd
        fzhp: 11
        nhhd: wrlb + zhld
        vbsc: mqbt + rjbl
        btsn: fssp + pmtn
        nrcb: rngn * vjwh
        jlbz: mzvh + jsfp
        fqvq: slgm / jmdb
        bfjs: 2
        dzmh: 2
        qfdt: sbmm + mrzj
        dqrd: 3
        cfgc: nfct * wtpp
        jjjw: bgwj * hzgn
        snwr: nglf * cvcn
        rrrn: 2
        qchb: 2
        svsc: hjgs + tsbd
        fvjn: 2
        zfvf: 2
        rrvd: vbnc * pzdb
        plgm: 3
        bjhd: 3
        pmng: swmc * wqwr
        jjpz: zfvf + bvmz
        wtsl: 3
        pmtn: 1
        hsnd: bpsp * ggcm
        rjbl: 1
        frgz: bzth + shnq
        fgsz: 2
        lpbf: zhvh + fcrp
        qwrq: wwgd * swbl
        qfpw: 7
        bsdz: 14
        tjpw: 7
        rgbr: pbfs + mqzl
        bjgn: gtwg + lgbt
        jrzv: 14
        mrlw: cltt * wrtl
        fbdp: dcts * nwnv
        tlfn: gjvf * hrrs
        zqzv: 5
        vqsg: 5
        vjts: zwhq + mngw
        tqdn: 11
        fvfg: 3
        gjzb: 11
        vlpj: pbcn / wjmg
        rpbw: 5
        trnq: hzbq - jcqj
        lpht: 3
        pqzh: zssw * fzwd
        dvmd: tlnb * htvc
        hqwt: 2
        trvv: cqrt * lrlq
        ztsq: 15
        wrpm: hmbr + nvbp
        jmfl: mnvs + fjfn
        bhvv: wqlr * lcdm
        bthp: 7
        jbgd: 1
        zjfq: mtnh * dvmc
        ljnr: 4
        jnfl: 3
        fgjn: 3
        mbmb: fptm + jrzv
        gbmp: tmhl * wnfv
        vrwl: gbdr + fnlh
        zfdw: 1
        hdjg: zgrb * rhtq
        mfpj: 2
        rpjr: 10
        cbsl: 3
        qdvf: 3
        plnv: 5
        nnfm: 2
        mrmz: pzvw + bdvg
        pvdn: wjlt / vhsr
        zbcf: 2
        gnrt: rlsz * pqzh
        tlvw: vnfw * dmvz
        tbcl: 3
        fwds: wqmv + dfps
        sggt: drpw * czfh
        lqlm: 20
        qltr: pqlh + srfh
        fmnv: 3
        jsrv: 1
        djjz: dtqf * lfzd
        jsgw: nvrs + dpmw
        ndnl: 14
        nvhg: 2
        vjll: bvfn + lhrf
        zfjd: 3
        lsfj: gwpm * bqfb
        jsmr: 2
        dlpf: djgj * dhpr
        lfbs: gqgr + fqpz
        wgsg: nwvt * pqfs
        rlfc: 5
        wbmp: mfbd - lmsm
        nvbp: hcrd + qdcw
        vfrr: jvbt * rtvn
        fqrl: 2
        mbdl: 5
        zdgc: mjvp + qcrr
        fqmg: 3
        qqrq: ztcg * ldww
        tcwv: bdtv * ddht
        cdhn: 9
        qvgl: 15
        fmcb: gqwq * nppj
        fvmm: lmrt + bpmw
        bsth: cdwz + szbt
        qctj: 5
        gnnz: qgnt * zhfc
        nqtl: 10
        wmhq: sphq + llsg
        ndcz: spqm * wldm
        qjmq: 7
        gdrr: 2
        zqhp: 3
        jqbv: qfth / pvvr
        qttw: 13
        dbfp: vlnp + hsgt
        plgd: vdjl + jpbr
        gnhq: grfm * vcdq
        jphq: jtbh - bjpr
        mtnp: 2
        bflv: 2
        llmp: dvzl - nncn
        zdsn: 3
        wdmf: 13
        hmlc: tdnt + lqnt
        dgtt: hszt * cdct
        vjwh: 9
        zgwj: fgfw * ltdf
        dwgw: dgpp * qnrz
        brfp: 2
        gwjt: 5
        gdjl: 17
        rtcc: gffd + jjpz
        hsvp: hggw * zvbv
        cbff: ffjt * cgfw
        mhqg: hlzz + zqhd
        gfhg: nlsd * hvgz
        hzqv: rgbb + scds
        nlnc: tcsj * hhdg
        fmnr: wqhw + pmmw
        ggmn: 2
        vtrg: fdvn + bzwb
        wlwb: ljnr * gpss
        hbwn: fqbp + cfpl
        fsfq: qtgz * qjth
        tlhw: vvhn - zwhm
        jbwf: 9
        rqjf: mmrw * gfnb
        vqcl: 3
        pggf: zpbt - jzgf
        jsdv: gmsj * cdgf
        fwgg: dfgd * bvbq
        cpfn: snwr - cbsn
        wwgd: srwp * vmwr
        sjgw: qzfb / crfv
        hsgt: 6
        nmtz: 17
        cgsf: 5
        sqdl: pztw * wgcv
        zznd: njdh + cmng
        wjbp: 5
        jmlz: qqrq + cnnf
        wdmm: 2
        fgfw: tzln + jdwr
        wwnn: frmf / tdtg
        fftm: slfp * gzsj
        sljf: rlml + rjnp
        lwlq: hvjr * wnpg
        sgls: 8
        dppw: fmcf / tjpc
        dzsz: 5
        rqzj: 19
        wwvv: ldqh * gsnm
        lthr: 1
        rjld: 3
        ftmv: bmwm * btzl
        sgbn: 3
        hbfh: pzrd * cwlj
        ghfp: pbfz + dwrz
        zstb: lmnq / psqq
        wmbb: 3
        sjfr: 2
        mwfg: 3
        wcjq: qhsf * mblc
        hrdr: gqfm - ptcb
        bspr: 2
        ffqn: 2
        rtqm: 4
        nflg: pqtb * thqm
        lfds: gcdq * bdtg
        trhd: 3
        hljh: qjpf * sjmf
        lfjs: hffd + wdmf
        wgtr: lqwr + ztnr
        gmwh: cmfq * ptrw
        zsql: 1
        dhlm: qdfc * ltjl
        ftdt: 9
        ssqw: dltn - bjgt
        gdgm: cqjq + nvdr
        qrtz: 1
        mwvh: flbs * rrrr
        hpch: wcsz * nllf
        fbcm: 3
        vwpj: 5
        nhfb: hfld * pqzl
        fsmj: gdwg + wvzm
        lgbt: njtd * bhjj
        bvfn: rfpz * ghhh
        smfb: 5
        jwgh: 2
        rvrt: pjqc * lpwd
        mmrw: 2
        wcbt: 5
        sspj: vhpc * tqdn
        zjft: tnfp * cjlf
        wjbh: nmcn / fvdp
        ctbl: hcwf * fcbl
        ntsr: ctmz + jmbg
        jzcj: dprw + ppgd
        dlsg: 3
        srpq: 7
        dgcn: 14
        wmsb: jvrj + dhms
        mcsq: 9
        dlfm: mhmd * hwns
        mvfn: gchc + zwqh
        htsz: 4
        vbnc: 2
        rvjs: jsgw * cbbd
        qpcv: 3
        hhwr: hznd / lptl
        plsc: nmnl * fmfp
        wftg: vndb + chns
        pgtq: 6
        fbgg: lltw * zvhz
        fpfr: mctq - dwhb
        mwhg: 4
        qcpl: 2
        vmhg: zchv * cctj
        jwjs: pzlc - ctqb
        wfpg: 3
        qvcg: 8
        ssfs: njpp + fzmq
        jdjg: wdsj + vcws
        lzcb: nqtl + qpcs
        twtp: 7
        fmfp: 4
        tcgr: 5
        bbbv: 4
        npnq: wmhr * fnlm
        bpsp: 4
        fddz: vmcp + rwbv
        tsbd: bhrc * dppw
        zsjf: ptzd - qfdt
        bqdv: qjtj / sddf
        wrcj: 4
        bvsj: mlqz * tnqv
        tqqw: 3
        bqft: wdbv * ppvn
        bbdr: dzsz * rthm
        rfpz: 4
        nsvs: jsrv + stbr
        vdtj: ttzt + qwjl
        cdpp: pvmp + hltv
        ntpf: 5
        gsjg: lhmt + gnnz
        lnbf: 3
        fnnr: 3
        cjlf: 3
        pzdw: crwm * mzdh
        qwjl: jsls * hdpr
        gwwm: jhrz - plzp
        qrgs: tlhw + jprq
        mdnc: rngm * ssqq
        zpqz: 2
        djfg: humn - zjfq
        qcwp: wwqh + csqt
        mrzj: ptrp * rmpv
        jqtf: dqrq / sjzw
        vdfl: 2
        sdmb: fqcg + pqjw
        gjng: 8
        mtdl: 4
        rngm: 5
        jsrg: plgd + hzcs
        ctrf: 3
        zrqd: 2
        qdms: lprh + lhfg
        hrrc: lclm + hpch
        pqtb: wjts * jqtf
        tpld: zbbf * bmjd
        fgqf: 19
        vqgh: 3
        lpmt: mnbn + nrcb
        tqnl: 10
        jddl: 5
        dznj: ctgl * wgcp
        wrwp: 2
        vcgq: 10
        mlqz: 2
        scgz: 5
        mqww: jlgp + rsrm
        gwpm: 3
        ghlw: 3
        qbsn: wwpl - pjff
        wgtw: 7
        qqnh: 2
        nnqm: 7
        fqpz: nswl + szjt
        tbhf: jtbg + cwrn
        vjfg: wzpz + mpdg
        qjtj: hffw + bddh
        rbmr: 3
        fbnq: cpbd + hqfs
        bpmw: tgln * hswr
        ddht: gvdl - tfhd
        mhvn: tcww - hsvp
        mzth: 3
        jrst: 4
        bfps: hmrt * wmnq
        nwvt: 2
        lbmj: tchw + lhsw
        nmpb: jbdc - rgwv
        bpsq: 2
        bbcw: 4
        jgff: vhts - lrvv
        ffps: 2
        ndvd: 5
        dhzm: 2
        pbtq: 11
        zvcm: 3
        bgwf: 2
        fsvr: fshs * hwvr
        lfnc: gbmp + fqhq
        gtfn: bvsj / nqlb
        ndpl: vrwc * gmhf
        vnwv: djlp / bsbn
        zzfz: 2
        dcts: tngq + mnvc
        lbtd: 2
        cvhn: wpbs + nsmm
        zwrz: 3
        sfwt: 1
        cncj: 11
        dfps: 2
        nnmf: 3
        cbpp: vjfg + bqft
        fsfz: 2
        lrrc: shld * jcjq
        bfft: 3
        nlff: 16
        nvtc: jjqj * prml
        gwft: 2
        qbnq: rjdb - wdjf
        qggt: 3
        bpcr: tqmc * vsqm
        nhpc: 2
        trhh: 2
        dwdj: sdff * wjqd
        sqvb: 3
        zchv: 15
        jptr: 3
        nvzw: bnqr + pdcp
        bnpm: 5
        fvfh: 5
        rltw: 4
        glnm: wfpg * fjrf
        qclt: 6
        qcsf: 12
        gbdr: 10
        snff: 2
        tclr: 8
        zmcf: sftn + tqms
        qfms: 2
        npsc: 13
        nhlt: 5
        nvcp: 2
        jbjg: 14
        llnm: zsnf + pfhp
        phcg: bbfq * scqm
        fsnh: 12
        bpss: dhcp - zcmr
        dltn: gwgn / rncq
        cmlr: 2
        mgcb: nnqm + rfqd
        slcn: 20
        qlvs: nhzc * ffdm
        snpp: mwhg * mctz
        cnrv: gqnb / jvtr
        ncdm: 11
        vvgb: glbh * njdw
        dshf: zdnf + bfvq
        tqzm: 5
        tdtg: 2
        wswc: 11
        zpbt: rwsl / rmwg
        zdqt: 7
        mlpv: bppv * znpp
        csqt: 3
        tqvs: 4
        whcf: 1
        gqfm: 9
        psmp: dgcn + lgvb
        gnmb: 1
        tshj: prsv + pjwm
        vbhq: 10
        tjbj: jsmr * cqvt
        qgnt: 2
        tgzr: 3
        snhh: 2
        vlnp: 1
        fqgv: 2
        lcdm: 2
        fvdp: 2
        dvdq: wlmw * qvpp
        jdrv: 2
        rjnp: 5
        qlmj: dsnr * dcpd
        jfbs: 11
        mzbq: nzwd * lwlf
        wtlw: 3
        qpnf: 3
        lgvb: 5
        lcft: vtwz * zfpn
        swtg: 2
        sftn: dzvw * tpsd
        tmvp: wqsd + cpcd
        pmpn: 2
        vvzn: bbpr * bdgs
        qmgz: 13
        fflc: ffzq * sjrv
        znvd: spmh + fmwm
        btzl: jzcj + mvwh
        wpqs: 7
        vttr: hgrz * cjfv
        lrcq: vmpb * zjnd
        mjjv: jgwf * vrwl
        mjvp: qttw * gwjg
        qtrq: 1
        rzdq: 5
        vmpb: rzsh * mnvr
        pjwm: 11
        pqlh: 3
        rsqw: tqwp * qzsn
        zvbj: qgcs + pvwm
        fdqn: 6
        hhqz: 9
        jjqw: 2
        clst: 4
        hmbr: gtrf * cljf
        lpzz: 15
        bmwm: ztsq + lrcq
        bqnc: jprt * qjtf
        wgbj: fsgw * hbdt
        gpqd: 2
        jvrj: 9
        tslf: 15
        cjpn: 9
        zsfd: 3
        rzrj: wfcj + ntjz
        vcws: tqzp + ggvv
        vbjq: 10
        wtjm: wbbm + gpcq
        bchj: 8
        bwqp: qncv + lbdc
        qlnc: 8
        fsjm: 3
        znhm: 2
        nvtp: fftm + pwzv
        qrqh: 10
        gjpm: 3
        tslv: bgjt / nhpc
        dhpr: 2
        dvsf: 2
        sllh: 2
        qtvz: qrqh * sdmq
        bchf: znmn + fglw
        zstp: mjtd * bqnc
        jvzt: 11
        sltz: nfnp * sttc
        bphq: 3
        nlmg: fgjn * cnrv
        mtml: 6
        mwsm: ccqd - wpqs
        qwrz: 5
        cwlj: 3
        wvbz: sndd * cjpn
        vbbs: lhdh * vnvj
        hwvr: vjll * zqtd
        nsnc: wqqg + fqls
        hvcf: wczb * wtlw
        wfnl: 2
        cpnc: gjpt * sgdl
        qrjc: dnhs / dlrw
        qscl: btzt - nhhd
        nfdm: 15
        gcpv: trqm * lqwf
        srch: pdpd + qcsf
        wmgg: nzjs + jhdq
        jshs: 3
        bpdj: mzcd * llld
        dwzn: fbqq - qltl
        hddl: 5
        wddb: 6
        tshc: hdjg * ptvf
        zftg: qfpw * mqmj
        rlml: 1
        gvdl: jzmf / gtfn
        zfpn: wrqv * mfpj
        rqbv: gbsr / gwft
        wtgj: 2
        jhld: tngn + zpbr
        sdff: 2
        wmdp: 4
        sgnc: 5
        wsdr: tjpw * svsc
        znmn: 10
        wpbs: bphq * tlfn
        vgcb: 5
        rndj: 2
        rrzj: szfl / bjqb
        pdpd: 5
        bvbw: gsvz * fwdq
        jdcf: tslv / jwtg
        lpgb: qrpq * tcjs
        sgzd: 19
        mrzb: dnrm * sgbn
    """.trimIndent())
    check(85616733059734, result)
}

private fun test(input: String): Long {

    abstract class Monkey(val name: String) {
        abstract fun count(monkeys: Map<String, Monkey>): Long
    }

    class NumMonkey(name: String, val number: Long) : Monkey(name) {
        override fun count(monkeys: Map<String, Monkey>): Long {
            return number
        }
    }

    class OpMonkey(name: String, val op: String, val first: String, val second: String) : Monkey(name) {
        override fun count(monkeys: Map<String, Monkey>): Long {
            val monkey1 = monkeys[first]!!.count(monkeys)
            val monkey2 = monkeys[second]!!.count(monkeys)
            return when (op) {
                "+" -> monkey1 + monkey2
                "-" -> monkey1 - monkey2
                "/" -> monkey1 / monkey2
                "*" -> monkey1 * monkey2
                else -> {
                    assert(false) { "unknown op" }
                    -1
                }
            }
        }
    }

    val monkeys = mutableMapOf<String, Monkey>()
    val regexNum = """([a-z]{4}): (\d+)""".toRegex()
    val regexOp = """([a-z]{4}): ([a-z]{4}) ([+-/*]) ([a-z]{4})""".toRegex()
    for (line in input.split("\n")) {
        val resultNum = regexNum.find(line)
        if (resultNum != null) {
            val (name, numberStr) = resultNum.destructured
            monkeys[name] = NumMonkey(name, numberStr.toLong())
        } else {
            val resultOp = regexOp.find(line)
            if (resultOp != null) {
                val (name, first, op, second) = resultOp.destructured
                monkeys[name] = OpMonkey(name, op, first, second)
            } else {
                println("regex error")
                return -1
            }
        }
    }

    return monkeys["root"]!!.count(monkeys)
}
