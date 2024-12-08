package advent.advent2022

private var result = 0

fun main() {
    result = test("""
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent())
    check(157, result)

    result = test("""
        mmbclcsDHCflDDlCrzzrDWjPJvjPvqJPjfpqZQdfWd
        NNFLnFRNhgNQtMLSFSgwSwGJPZWLPvjpjjJGZJPvWPvJ
        BnwFNgVVhwNwVQrmzbrrCHVTmDsm
        CTsVssjPTWPbzhfbfqqpbqJq
        RRttdQlRdnNpdmwBnBDhFrGrqDGBqJJfJD
        HttgcggdNwQtgcpTsvjVPTcssjsv
        bWrpnrpPcFNbfPtwVPddVVDw
        jLgqqJgjZLhHjRqLHLjqHgftpmJVtTmwQmtGddwwDVJm
        HhzgshZLpHLjqhLLZRZpLRbbrlBNsrrNsFWcCvvFCcNN
        PCJJfJhjhzjjdBVBcd
        RnNnMHnRNtWnBSQHVbqSzFcq
        ZlnZZZNmLrNrgZmmccGJwGwmGPJs
        hFZLsjjjMzwPPjqw
        SQtTcpWWcpMSDlQpDCQJqbHzdSzPzJvPPwqqvH
        tVfpGWGDVlCGGDCpVWppVcrZFMrnmnLfsrBrnngLmMBh
        PFPhCmpfhSMWnmgrtgMW
        RRQdGQvTQRzQDGQTQcRqTTQLvsntnltvrWZlsWlZftntrMtt
        NQTzfGfzcdTBhPJSNJbCCVhJ
        sbtqfrqNfcdqsJrfhzQmzhpvzvpQmpNG
        SHsSDsZVHBHnRZDBZRWSVDnwFhzvphggwGhQzQhgwzmmPzmg
        jjHVHBlHljMsJjbbCcdttc
        NccBbvbNZbbvBGPVTGhhlCZCPg
        tdWHQtLLMrrdWQRqWrMrMrMPsTPThDlTssFFCFCVTDtCDC
        zzWmMQQLVQrWrbBczNnwNbnpnN
        THGhBHgHThvnHRrQRpMNSwZSMrwD
        szsCzWljNfVFFVllPPzzVWJMJZQMJbpSrwQCCJMDZbbb
        WzlfFlflfcmfsFPVfWVVhnNgchHndHgdTnqdNHTh
        zPhDwsWgszftMNfPjjLL
        RTRbbJFHSrqRRrHRrjGQBnfjQQMjLnmNnF
        ddpNSNNpSdWsvpllWzsl
        FgDgbSMnhhntCLCC
        HlqzJgPfJJgmrthhrtTLqL
        fjfQgJPGVjwGJcFMcSvdScWjMD
        pnFwRPlVVlLSwpGbvSmZHmbbdbHm
        sCzTQtzrrQMzpthTdvbGHdvdHNsZqqqZ
        ChTTWhWBWCDrrTrjCrhtLwwLFgfLFgjnpfpwLnVg
        MRDfBDMJsQdmGWsM
        pFPqwswhGzWSCwGN
        jphpbgbqgFnqjjnthLtJsZfJRHfllfTllDLflJ
        sdbLCqnbllplrdrsqbZHRPRBcBcBZBcHcZrM
        JJFwDDQmzfmhmWhJhwFWbMbcNBNRBBzbNPHcMHPj
        DFWVQVGGGbpGClllqLSl
        mRmFhZRsmFJfFRzwRrFrqmRFtNLLDTPccVqVtGTLDnPccPDN
        SBddBlZMjpQvvBbZvVDTtDTDDVGnLTMPVT
        dCHWlbHbdbllsRCCgFwrrZCJ
        hwvwFHhlTLwpLDQhpHwTwBLSfvzSZZsvVsqCGqzZSfCvVG
        WNdtmjPjcWdWJWntcWbjzmFzrrVrzsGzsVsSVrZZ
        PbJPntMRbbdJbcNPcNFjnhlwwgpDHRBpggTlQThhpQ
        mJvRGHfWmvWJJVmZZnZVffpglGggrTLNzLwNLrszzNpz
        FqFMMShqjcMcqPbbjPthNgRggPgLwPsgLgszwNpl
        DFQqQMhRhDRmWndDnJvmWW
        jVzfvzSVpnnNSGjjVpNlSNDzqBBmWCBtWWtfFFCCmPmJCCJW
        HLrRLhwrMZbHrWqWBhGPCGBFJW
        wHHMRMQRQrcQRTTcHrwwRcQbDnpvnppzGSnvnSNzDSNTpjnS
        qzrgfppGzPDJHfbZbHZn
        vTsMvMTclhNlFlFhdhdqHHmHJSJDVJnJFFwJHHDn
        slccWTTTcdCcCqRQPrzgBWPPRz
        thfHHdDwbnVzwwdthZlqjZmmTmjfZcfMQl
        sGFGJFFvGpFPCJvLPGPgZlpmlTMcmlmZrmMjcr
        sJGLSWRSPBBCCPRFWPsNBNwMNNVMNwBzzMDhnh
        RwJMwdbzMGWbLtLVQpPl
        gqNfBmBjNmcCqjqjQllWhhQlgDQtpWlh
        cfccjmcNmHrHBmCBcTMGtTJtZzrTvddRGR
        vbbvqMhcrqMQQLHHvFvHHvpPlnPLfVfPnfmwsNwwwlnVls
        ZdBZZgDRDzBRJWBzzDZjDDNWNnNnPfwNPwmSwlnCnfCW
        JgRggTDtZmmbbFqrvT
        lSgzfSzgGcNfDPsbMpspbPnnrrVV
        FmWFBFQHBJJBmmWJFHWFrwtsVrMbnrVVwwwpWMMp
        FFmmJmvZjQBRQRRQZQBvNNglRhDNDffDSDSMGlDD
        VQPBCZVfHQZGRVVpmzPFmgSgbSPTFb
        NcwLjcWnFhCpLvCF
        tNCDtsqltDwtWdncJZVJVRMGdBQffHZH
        pTzgPsLQfMLqTVFLGbVbbFVJVF
        ZnjgjvSwNNbFJVwN
        jWcCnWHWRvWRHHnWRWjvdZnZtspMqfzrMqfQtTPQgfPzfzcM
        CTqHMNSSVnpjNSTFzMwPdslwnlPccbblgcbd
        WDLqvLQRfLBgbJPwlWgdPd
        QRBqqDmZZRBGGfCTpCCSMSmzjSpz
        bPlRhmnPhTwhrvrlRrjgLjgsLpszFldgFlgF
        tGHWfcQHWfLZnsLQnjpn
        cVGtCtGGcNWcWtBStqnWrwmvmbmJwJPwbRBhRRMb
        BjVTVfBsLlLjLcBcZDRJpnJRDPRJqlPRqJ
        SzbQMQzFgfFzmMSrbzGpqqRDtqmnvDHtvppHDm
        CrSQSdgrWdbFQCWggjWZTfBWcwBcTVBjTs
        RtqdCqCTbRfRbbHR
        FhwWWqgGJJgJHLHPFFsDbsFP
        MrpmmwqhMmJMwpvlNvtlTrvtZSSr
        VscvcmcmbhDrRMCCJlqnSlJnSljR
        FWdwWgpZgdBLTgTWFwZBgWpjbCNqPptCSlNCStnSJJNPPJ
        FdFWGgWTQGGbGvvDHDHzMD
        WhhBJrBqBchcQBBqcqqGRZRlrtStlSlRszlzSSRl
        fHdwgdjbNCbCCHNgPgHNPNplSRtQtltlRDZsQfZsZMRQMR
        jQbQNwVNvWFJvqcV
        bjbmmgSjwTWqWwWqcw
        sQGfPZQDPqMMWWWd
        fqBDfqqZZGHGDsNLjtmlttpgBllpJt
        ZDmCWtftfWBLfRDWwbhqcNNtqwjtjwqt
        SnTTsnlPMTlSSsGMMSddSbHjhwJwwjPbcvHwLwcqjj
        GrFGzSgnTzLgDVfQfQrrDDfm
        PngprCCmcBDssRFBSbFRRs
        fjwHtjfNWfGwHfdtjGMdWSSdQTsQRLFSSslPSFTRlS
        jGjMwMffWHNZfhwnDzqCpZDgrqCcPr
        qzGPbzbDZGSPvpvrTvQsQwLWWNLj
        tFddBhgnVnMMhBhLJWLwjQMwMrMLwT
        BHFtVHgtmlhRRZmSTDTpSq
        ZwzLWWWvWdSJdJQwQLzBqqbbhhCcNzchqCNPhb
        rHfDRfHGfHsGTPPmhmrrNhjmNg
        GlfsfRTfsfRtsstfDVHpGsPSFQJSWQMJwdSLwQWpZZLd
        vnvJvpJtQwDBTljHlLHhDL
        zzGqMwqMqbfRfVGzFmLmLTLddjmTSRLBBB
        zGfrbqzwNvPPcCtr
        jwCwSgvPSmCwSqwgbCRQGvsRVnddGZdflsfB
        MhzHLWpMWHHzNzMccDHdnZVZRZRGQnGlGRGLsZ
        nccNHTzWHDcMWHcphpptDrcDJmSgFTPjgPFjTjgSbqJSJqbg
        bVhPWqBBbdbdPqVVqhSfpcmFsfwLnmmjnfBFmn
        TDWDGzgRvrNJJJrzzzGspwpjncsncFmwFmsNfw
        vMDgDJRWgDJtHDJMMPQQMdQlqdlhZZQbbC
        SpdpQqLwrDcmPhggcS
        ZHCZstHMhjGmtPDc
        NNnnRHMZNzTMHZZTTsZMvvRhJJwWzBVLVQJJqWwVhwJpdJ
        mrlMQlQPPPhhCbZRNpRZcffmFmgc
        VvJVJqDqvqjDqvtVttVSHTTHLLcggBNBBSRRFfRLncfFLpBB
        jHVHvdDHtJjtDWjwMhWwhwwwlNswPr
        MJvzvFLhbTnJCvRwWSTmSWWWmRpc
        tlVlNqBsVNNBQPrWgqmcgfwpcWpdcg
        ZBjHPsttQrPrrVsBQpVJzhZhvnnbMMLvFJJZMJ
        hBfJffJJNhnDlmQdnmSGcd
        sQrCpRsPCrwFZQprpQCzljdjMMjMGGdGSmgSFFDS
        zZpzQpwzHRPPTrQwCpRzWZHqLVvtBJvbBtVJhJLhHtLbVv
        DsPnQGnnwlVJbSsb
        HCfCfTDMTfHvCWMZDcRVVSwpbtlhVZbhhpVllp
        TmCMTvfjRCCvcrgNNPQDmNzrLF
        ghwNtnMMRTZtwTphjjBQfLJjfJFdSBTL
        lldzbqzrCrfLJJBBbSWj
        DCvlvqvshNhRndGs
        rWwWWDJWWrFLdRWtRhFZTCbCSqThFTCbmm
        BgMvSzvMpVpBlQNQVgfqhhGCbGbThQZTcbZTCs
        nMpfjVMnzlgRSrnHnwdSDH
        blFhFgFgPLvjDwNvWPnD
        qMBzMCCzZMzJHRrzMFZsnFjQdZnvvNvvWQ
        FzpMpGMRrlSSghLhtG
        hDlVfDdSTjTJwjMTZT
        HgnqtGgQRgRHGtrgqgSZJCrwBZZCrZwWJWjMWZ
        zqRbGNSbbGRRQGRQFzddfVDLVhhfhddV
        JwhLdLNLbwmJggCbbbhjHnDQNZWQWQjWZZPlHQ
        GStzfBFzBMGMftpGcFFQDDjDQfZPfnnmDPfZZj
        FqMBtFstpcTMBMSBGSBtqMhrwJLLTCbLhJbrhTCmrChv
        WwWnTNVBNvWwBngdSqdRJJzncLSLpc
        HPMZlGZQGtQjPdpqScpdjP
        GltlGDDCMMplHCDphtbCHDwmWNBgVgvWhrmWssTBwWWV
        clNNclslcLVWBNlGcVvdSHQvTMHZZSdsdQHM
        gGhfpRwRZHMdJgZJ
        fnDrpDtDrrWGcWVW
        zdVzgdPSWRsHVzPsRRPHRHRRntnQrbDmfDfwfQwwZwfnbgMD
        qNCJvjNLqjNhBBGjBvchhBCqffbffDGMnbwtfnbmQwQnZQMt
        jccqJBvCjqvLTLJhJZpsPdSVdPszPRFssT
        lDLvltDpvSpqGjVVMljGjW
        zrdnswzcSzCgrdnBBjVcBBcjWTVTGb
        PZgFdgHHnrdNDPvvtfNQSJ
        GlLFbFNFtzcvddVpJVfGsCCC
        PWhhMgWTTnhQrqMHTWqwddCVjSwQJddpBdQffp
        WqJZDHPWgJrHnPqhnnqLbzzcLmbFDNmcbRzbbN
        vtDcSfcWfmfTSGwvGDwTvFZVppsszCsVVVFjVzSVSM
        NrrLPhdBRJLbPhrrRJwhBFZsFVzQzszsZzMCZjsJQF
        glgwPqPhrRqPqBdNLwBrLRtnGHnDGmDqHWfGWfGcncHH
        BtSfgpgvQhlSlwzZ
        VHRmVzMPdPVRmcdhQwQwhClNNNCb
        PcPMRWrVRRHTMDRVLPVzBnnJprjppBJtJftvpBfp
        RpgBRVpLgBpDFCCPPVGvPSVVvb
        dHrMdlWwwljjrlHrqmWjmWlGNvNSBBNhhSCSbSvNtNvQGd
        TfmjqrwqHmqHrqlHwHpgfZFBzJgpZnpDcDBZ
        NWTdFWlSMMMWTzVzdQfVpVDwwf
        RHrrGrLqJLBqgpDgQfwfffHz
        cssRRsBjvrGRjLBLrZcBvBqWPQNnlWTmSnjFllWMnCTFll
        DCCDbHDhgbtCLHFHCQdQdSVfbNMdnfcSMS
        ZZjPsqRZJlJlGZPTTqqRwJjZQVnMszVfzdSVScQQSQcNQNfM
        mlGJJqmZjBZPhLBrgrWHFnDL
        wLpCpDmmLwplgwVLwLwVgLLbWWJvJRTsRvbbJWCRsfbssv
        FHHPFZnnhZQrqTTlSJRSrlfvrv
        llZlPQFcZZHchjhjPqnjNFqNwggmDDwVNBBDwtpGMVDwDwVp
        CctttjCrftNrBZpPgpgbNqdq
        JhMwhMTGhMVhwDDMJJHGJJJBldWggWglddlbqlbPHbfqgf
        DvJRMJVVJMTfJtnrnRjCSRFnrL
        snDPGSQPnSSQQFwFFdzWFvmCVmmnjmCJjHjbZZhHZp
        clgrgrMrRfqRlNggmhmHrhvVbpCjCVvV
        fNgcBgqqLMqRqgLggtcTftBFdDFWQzDSQWPPGwWpwtGGsP
        wSJWDCbwVdQfbffHfZZr
        glgTBzzPSFhLFRvRQnZspZQpnvRp
        qTLqglLNFqBqVMJqwwMVcS
        rCWNCsrGrGGHrwQQHrfNDfvgLmmvMmLLMpmLvLPpPgww
        djcdVdqJJcqqBstdBczbStThPPMPghvSpRgmlvghlmLpLp
        qtjdBqzbTTtzTJTzVnbBdsNfDHZGGGDDnGfNDHDHFZFD
        mlzzVHZmzvHflTJHqlJcZTvdcdCCPnddFGhPdBGhMFGCGc
        QDRrWSprdqqCqDhF
        NWtQNRrgWjpLjLsrRrQpfwVVqvwHzvvmVszlvlvm
        DmDDtBDStSLcjLBDhhhmfnNFNlJJMFWFHSMWFpJNHp
        PgMCgVgsCvVwRVRCwvgTzCMRWWwdnWHpNHFwWJJnHdHpprnp
        RgZvvMbsbPCRGRTVPGmfBqDDqmthDQcmcZDc
        WrfWpwwCwpdWCMBzqbtpjVbqzVqp
        RvQQSFJNFZNNLPGbMMPqGtGPzF
        DRvmNhZvJZmNmLcDZQcQNRfnnTMwrMHnfTrTCslsclCn
        httbcnSsgtVMsnssnzghmmHvNmlHVLBHBLrVGGLN
        QFpjZqpqWddZjjDWPWPwjFpfGLBfBBrrNLlBBgGrLCLmrfBB
        QRjRjwjwDhbRTJnhgR
        FTBTZqFVJnVTTPBTVmFbNjRffzrRrNQrPNQbzh
        tCWwHMLCLDstlzdjwbzbQhRl
        GvtChDChvtGSnZqnTVvBVF
        spnFVspFPScprWrGvTpTWpvW
        CgMqCqPLfqBBJGHlMrrJrWWl
        ChjqhCtgdLPSQhQsRnVQ
        bCQVZCJcrSSStrWTdhQqhzzMdhMz
        lPDwNfgpDfBNgfnlDPRDpLWRhLbMjzWqMqWsMLLhLz
        wpNPgPwwBDfvBnfgBfwglHDCJmtFGFmGSmCVrVCGbrCcFv
        zNMJCHVJQmNLQFhZ
        PPRPdGcRdPPjfjflqdjPDPTZQrhTFZFrmQZQBGZCFmLL
        CcWfjjgWtjtMJWzVnSJVzJ
        LjhDjVCVsjNfMsMQ
        SdRpGSndZnlgpdSFtrQMtqNZJtwrMfQQ
        cdRpcpnggRSmWpcLDHCCHfhBmPHTCV
        zpmsJlptmfNwwFswGHThRcTqqHqhhWCWzh
        SLgLMMgnPbSLPbPMDqZZcTWCnZWtRcWCZC
        MbbvQtMVSLVrDMvSMSvSlwNsFNJspJFfNNmJrGGf
        wvcQjfjQvQDJvwNwRdpRScCHbpdMbSpl
        rfrZzrzWWmzlRpMMdpzd
        LqrmFrVhFJjNfFfw
        fVflVfmjQtZhzdrdlN
        HwLLJvCcpcbRvDwpDvDCpqtTPPMNWTzTrHZTMPzPMPdH
        LbvbJqgcqbpJLwvbbbmsmgVGmQmnjdSfSVjV
        FngtfmfTTSFjFDnfjDbwnGzzGBGzbVRwVcwz
        WWMrLLZLvZMWsrCcjzBGcpzLcGcVcB
        NhMWllrsNZNrWZWhjCmmSmfgSTFDHTJfFSNq
        lpqpqlhTSZqfZlwthPHsHcdHPhsCHLrP
        zVDTjMgFbscczPbz
        jRRmvmngNngqTZBqNlftTJ
        wrMrJZPPrNZPZzhzMFPlDqSllsLSbWDWlWqNbb
        VpGftgghtgQfVBgdnpBBngtWDSRbbSqltbRblDDDtqSlqS
        gVggVgpVHTpmndffdVQVTVggjMwwjjMCjJFhPvZMwHvzMzjC
        CtQPCFVlljWrNhTmCgLL
        zsZbsnsqbMznDGNrrTqTLqWRHghN
        zsMMGMSssSSzMGGMcvDGJFphFwPPvPvQfJppwQfj
        njfVlRDDfDwHSfwVwSLnQZqGBbGsnZBnbGqZMbbpGG
        zvddNNdWFgTPFgWNvNgcZqZbbqMMgBpsZrRZpgGG
        CPchdcRTcNvvTWcmTNDSSfjwSDHCfQwlJLHl
        LPmccvvFzzLvvQSzlFvFSSQDDtDfdDVdnDTBDsVTjDndlV
        CbgNZWgZrbbqhrgTnVjjCsGdBfCfTs
        BhwRrNrpQvLzvJSw
        DpGFVsprFpTBJjsnJnnhdjWh
        fbHCcbVHCgfMLwcqfLwgNdqhjRhnJQQdtQWnnSSJJj
        gCZNVNzbHbfNHcHNgfCMLHHzPBDPvPDrlvDrDlvpmFTFBF
        tsBQFgFpFBfsmtLjtgmtrQvCddSwSCwwbRvbwdLvwvRG
        nqPZnMznTZHZlZPfGCHfbHwNVwdRwC
        MPWqqzhZmBWFQfFW
        FNMTTwqwNpVWPgZFFQ
        crScdztJtcccSzWtzzzbStZQRZVVVHZVRgRQPHQhhjSZ
        lCDCCdJJdbCdbcJzrcnrJWbnLLlvMMTLNwwMvfvwvMmNBNMG
        WHsJMlBHCscDPDPtPBRDrL
        jmTvgnqdsbPmSrrPVrwL
        pdTgjgqbTqQFdjjQdqTZzCcJsZzQzcfsCCHMMl
        QqMQGbMGGGzSsQSqCPcCPrCRNNlSZllc
        vDHdmDWTdmwphhDdJwWvHdDCZPZVllPVRPRZNPVcZbTBZN
        pmWHDmpmLgJvhvLpmvdvLWbsMgfsQGjqjtsnGfGqzGzzzQ
        tFvMtFtFMvDDtMvLTpffQWWSGTsDTlSS
        jqVnBjHqhPHbnhqPqWllfpfSTplQPQPGff
        bbjHVHdjzqBznqVHBHzzqVFMJNMvmJtvtmcQFMZQFdJL
        dcldCJQnldtTMdsccThhDDDDFhwTqDRwHR
        ZbGzmgZSBpPPmmbNbZmgmNPPRqFzzVVhrwVHwRVHrVRHRRrR
        bSSNmhPGWWZgQtLWtlCdJCMd
        ttGBGNNgBgVBltlTJGJZpZlHSHCHfDSWpRWWpS
        LhcLrcFFqdhLFLqvwMdhcPWpHHSSZWjjjCDwSSSfpWpD
        fPMrqMMnqMFMbqcfnPMMBsgNttgggBmzJzbmGtbb
        fjFhHHHmfjtLjrFmPhLbCdzBCpPCJQpJJGzJCp
        RcDTnvlVqRnvnvRNcSzCJGJGCSJJCCdQqw
        NTlMZVVlVVVlRTDTNjgGLfhrmgLFfZFGhr
        GmbVGWttmpmbbqDWgVGGGtWNvNCCsHLLFsvHMHHLFnFn
        wQQSdDTfSTsLCNnFwvFv
        dPDBTBjzDftcBqBVbGBg
        LmsfRLwCfZslcjljcjDjwN
        gdRSrHHrSbdrggBzHBShHlqVvVDvcNvlcccjGlGjqB
        zgTnSFFJdngddTZTPTWmspWQWWPR
        RMZMtdsVCsRdddbsVcfcqgNfNDqGqGfzPzmf
        BpwQrJvrjnSnQpBBBJCJjBBQlzvmDPzmDmglPzPgDNfNmNgz
        LjLTnSpwjQTrnnLCBJLQjhstbMhsRtTdtMHMtbtsZd
        PfrPHmrCRmRhcHCcmCfhhmWMLVpwVqFvvGGLVpQSwwSvSFFP
        sJnjsgsDDdjjjdTglTgDBsBnSLdvwSqpQQbwQSLLLFSpQpbL
        tBlngnqgqZggTZWfCRZmMCHHmM
        LGGPQLDLPWmQLVdVdLLGbdvMNjfvHNFNNBbZnNMlHlBf
        CshzsJBqTTwhttzCJzRtcNcMljnnnMjHlFnMcvnHfM
        gqJsCwzBrQWDSgGmSS
        FWVzVJjmbbJVpPwjjJDQsQNDgtcrWtddDQMg
        TqRqCfGGBTzgTzDNNs
        qRffnhhGvvvpwbvFzp
        gLmMTpTCmRhgTLhCCZBSScJFQQQclWWMQJSJQW
        rvfbDGjGssqbbrRSJJWclqcSwzwScc
        PsDfGfVRjfTTTZNBPTZT
        hWqrPzzMhrfmfdNtdZLNrnGndn
        SwvwSFslbbjRsspQwsRwzcnbnNdTnZDbGctZdTNtNt
        wvJJFsvpSSvJFjlHjzplQwJhCfVVhmBmVWhHWmWVWqBqMW
        GjQtgjhPhGgsQjgtthrrvBlvljCrpCdlqBMb
        RFDHDRFRczzlbqlbvqvHdb
        DDFcRWTWFbSwRWbGtSGtgPfGGSPPtg
    """.trimIndent())
    check(8088, result)
}

private fun test(input: String): Int {
    var sum = 0
    for (s in input.split("\n")) {
        val count = s.length / 2
        val s1 = mutableSetOf<Char>()
        val s2 = mutableSetOf<Char>()
        for (i in 0 until count) {
            s1 += s[i]
        }
        for (i in count until count * 2) {
            s2 += s[i]
        }
        val intersect = s1.intersect(s2)
        assert(intersect.size == 1)
        for (ch in intersect) {
            sum += if (ch.isUpperCase()) {
                ch - 'A' + 27
            } else {
                ch - 'a' + 1
            }
        }
    }
    return sum
}