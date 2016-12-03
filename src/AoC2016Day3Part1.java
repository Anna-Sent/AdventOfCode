import java.util.Scanner;

public class AoC2016Day3Part1 {
	public static void main(String[] args) {
		int result;

		result = test("5 10 25");
		assert (result == 0);
		System.out.println(result);

		result = test("  775  785  361\r\n  622  375  125\r\n  297  839  375\r\n  245   38  891\r\n  503  463  849\r\n  731  482  759\r\n   29  734  734\r\n  245  771  269\r\n  261  315  904\r\n  669   96  581\r\n  570  745  156\r\n  124  678  684\r\n  472  360   73\r\n  174  251  926\r\n  406  408  976\r\n  413  238  571\r\n  375  554   22\r\n  211  379  590\r\n  271  821  847\r\n  696  253  116\r\n  513  972  959\r\n  539  557  752\r\n  168  362  550\r\n  690  236  284\r\n  434   91  818\r\n  859  393  779\r\n  620  313   56\r\n  188  983  783\r\n  799  900  573\r\n  932  359  565\r\n  357  670   69\r\n  525   71   52\r\n  640  654   43\r\n  695  781  907\r\n  676  680  938\r\n   63  507  570\r\n  985  492  587\r\n  984   34  333\r\n   25  489  399\r\n  470  158   43\r\n  715  491  617\r\n  508  412  607\r\n  365  446  743\r\n  504  189  378\r\n  225  424  517\r\n  473   45  649\r\n  847  927  424\r\n  455  889  697\r\n   64  230  846\r\n  579  368  881\r\n  639  536   74\r\n  433  803  943\r\n   14  629  963\r\n  432  481  136\r\n  781  625  323\r\n  836  215  201\r\n  620  614  366\r\n  801  679  673\r\n  745  376  326\r\n  891  957  751\r\n   64  430  347\r\n  784  534  237\r\n  740  485  470\r\n  570  894  790\r\n  905  979   90\r\n  571  526  716\r\n  810  602  259\r\n   20   41  648\r\n  816  566  848\r\n  891  883  616\r\n  801  797  341\r\n   99  119  584\r\n  175   40  994\r\n    8  234  831\r\n  184  254  958\r\n  625  999  945\r\n  326  385  266\r\n  475  644  785\r\n  345  769  650\r\n  427  410  680\r\n  689  887   40\r\n  380  109  842\r\n  342  640  785\r\n  164  546  554\r\n  843  871  419\r\n  873  687   74\r\n   84  192  465\r\n  186  777   83\r\n  180  130  726\r\n  315  860  652\r\n   88  273  735\r\n  859  684  791\r\n  806  655  299\r\n  763  409  636\r\n  310  532  897\r\n  891  163  855\r\n  631  200  986\r\n  104  559  294\r\n  555  679  989\r\n  770  437  935\r\n  997  189  711\r\n  830  300  983\r\n  566  325  793\r\n    7  694  911\r\n  574  490  138\r\n  596  230  973\r\n  855  377  552\r\n  969  150  518\r\n  453  653  525\r\n  753  556   47\r\n  858  509  551\r\n  103  545  325\r\n  660  215  284\r\n  566  509  591\r\n  647   97  650\r\n  993  597  775\r\n  970  566  802\r\n  242  922  349\r\n  693  932  502\r\n  872  267  657\r\n  526   87  944\r\n  395   85  188\r\n  134  129  901\r\n   56  244  785\r\n    1  733  300\r\n   55  698  552\r\n  372  933  480\r\n  548  459  792\r\n  631  653  983\r\n  443  320   23\r\n  555  117  715\r\n  665  268  704\r\n  804  899  736\r\n  654  823   13\r\n  441  250  736\r\n  229  324  580\r\n   41  389  857\r\n  215  103  753\r\n  933  311  835\r\n  955  234  744\r\n  113  141  315\r\n  790  130  235\r\n  464  464  129\r\n  328  386  315\r\n  787  735  301\r\n  839  744  299\r\n   77  119   23\r\n  407  321  190\r\n  968  962  904\r\n  653  752  732\r\n  962  145  723\r\n  175  452  717\r\n  868  474  195\r\n   10  273  943\r\n  308  388  626\r\n  296  133  647\r\n  851  474  336\r\n  839  777  975\r\n  514  651  867\r\n  949  947  886\r\n  802   92  113\r\n  167  938  941\r\n  840  627  166\r\n  825   72  754\r\n  166  661  677\r\n  759   71  279\r\n  705   70  113\r\n  849    4  295\r\n  563  679  588\r\n  343   76  636\r\n  842  669   45\r\n  892  597  431\r\n   26  864  580\r\n  889  509  641\r\n  696  267  506\r\n  608  778  297\r\n  293  867  667\r\n  662  469   97\r\n  243  184  809\r\n  785  434  715\r\n  691  568  759\r\n  599    4  164\r\n  444  566  816\r\n  486  145  595\r\n  787   41  538\r\n  953  151  842\r\n  861  877  759\r\n  228  972  678\r\n  846  114  915\r\n  253   41  621\r\n   59  989  405\r\n  222  948  665\r\n  478  631  364\r\n  524  717  175\r\n  752   94  474\r\n   47  421  419\r\n  113  510  343\r\n   99  733  667\r\n  787  651  708\r\n  703  557  486\r\n  489  637  702\r\n  510  287  529\r\n  483  308  545\r\n  454  177   87\r\n  433  735  242\r\n  638  734  172\r\n  208  702  285\r\n  999  157  251\r\n  776   76  341\r\n  689  164  553\r\n  477  938  456\r\n   45  848  863\r\n  466  255  644\r\n  578  396   93\r\n  471  419  368\r\n  411   27  320\r\n  317  291  732\r\n  303   42  605\r\n  597  313  473\r\n   70  419  120\r\n  101  440  745\r\n   35  176  656\r\n  236  329  198\r\n   74  296   40\r\n  272   78  233\r\n  864  404  510\r\n   37  368  531\r\n  828   35   50\r\n  191  272  396\r\n  238  548  387\r\n  129  527   13\r\n  464  600  194\r\n  385   42  341\r\n   81  596  432\r\n  589  663  943\r\n  256  704  723\r\n  671  152  505\r\n  873  532  364\r\n  758  755  202\r\n  378  621  563\r\n  735  463  555\r\n  806  910  409\r\n  809  897  276\r\n  546  755  608\r\n  609  852   79\r\n  279  133  527\r\n  106  696  980\r\n   63  981  360\r\n   90  440  832\r\n  127  860  495\r\n  714  395  480\r\n  815  485   59\r\n  792   91  507\r\n  249  524  138\r\n  567  452  486\r\n  923  544  768\r\n  913  253  767\r\n  456  582  293\r\n  706  507  577\r\n  187  619  644\r\n  569  978  602\r\n   88  886  291\r\n  448  712  211\r\n  517  815  258\r\n  743  397  816\r\n  977  793  795\r\n  847  905  668\r\n  690  869  162\r\n  426  541  257\r\n  637  586  272\r\n   82  950  821\r\n  785  936  350\r\n  812   31  490\r\n  318  253  159\r\n  515  688  479\r\n  423  855  407\r\n  931  830  651\r\n  496  241   28\r\n  491  924  624\r\n  864  966  133\r\n  171  438  712\r\n  736  867  734\r\n  551  548  267\r\n  288  455  474\r\n  557  622  273\r\n  494   74  507\r\n  541  628  390\r\n  288  583  310\r\n  411   63  353\r\n  487  527  295\r\n  520  567  536\r\n  739  816  848\r\n  349  681  269\r\n  898  902  676\r\n  647  759  892\r\n  573  512   75\r\n  186  252  895\r\n  804  320  772\r\n  730  934  107\r\n  198  651  774\r\n  625  535  985\r\n  568  499  235\r\n  159   42  837\r\n  854  617  695\r\n   34  299  670\r\n  823  733   41\r\n  830  615  789\r\n  825  652  562\r\n  697  105  504\r\n  114  103  540\r\n   18  141  106\r\n   94  121  479\r\n  859  774  177\r\n  464  873  208\r\n  790  125  305\r\n  982  586  811\r\n  521  386  478\r\n  916  329  620\r\n  764   91  351\r\n  526  684  103\r\n  314  749  283\r\n  510  226  378\r\n  160  269  278\r\n  638  368  120\r\n  616  540  475\r\n  863  637   89\r\n  744  172  445\r\n  856  391  269\r\n  768  276  634\r\n  940  610  820\r\n  289  254  649\r\n  254  364   98\r\n  304  613  620\r\n  164  652  257\r\n  890   74  483\r\n  813  640  710\r\n  884   99  735\r\n  707  881  380\r\n  954  983  971\r\n  487  911  275\r\n  256  920   43\r\n  384  772  313\r\n  863  120  903\r\n  703  821   82\r\n  765  731  957\r\n   55  935  516\r\n  162  785  801\r\n  140  161  927\r\n  460  139   84\r\n  926  139  965\r\n  764    3  976\r\n  765  487   42\r\n  377  835  277\r\n  897  734  256\r\n  345  320   55\r\n  515  755  504\r\n  615  623  562\r\n  412  280    6\r\n  382  392  468\r\n  365  625  461\r\n  542  406  610\r\n  360  200  801\r\n  562  221  627\r\n  556  557  141\r\n  372  231  212\r\n  523  457  272\r\n   80  701  676\r\n  940   59  871\r\n  906  695  987\r\n  715  922  573\r\n  618  446  552\r\n  196  849   62\r\n  772  867  608\r\n  735  377  418\r\n  676  607  236\r\n   25  447  830\r\n  187  270  738\r\n  214  175  990\r\n  438  790  816\r\n  456  396  534\r\n  220  628  356\r\n  384  935  215\r\n  377  593  802\r\n  566  651  650\r\n  648  529  999\r\n  128  884  472\r\n  688  951  661\r\n  312  722  722\r\n   48  526  696\r\n  266  347  903\r\n  698   21  354\r\n  933  404  570\r\n  303  417  685\r\n   46  562  897\r\n  566  931   14\r\n  539  747  911\r\n  374  623  743\r\n  868  353  513\r\n  927  903  481\r\n  207  765  560\r\n  351  956  215\r\n  540  945  512\r\n  362  322  651\r\n  820  555  190\r\n  548  301  467\r\n  405  931  842\r\n  598  347  150\r\n  276  971  814\r\n  450  480  361\r\n  577  538  493\r\n  139  104  181\r\n  716  233  697\r\n  494  647  287\r\n  511  782  575\r\n  809  728  107\r\n  895  167   85\r\n  741  746  141\r\n   23  115   83\r\n  173  147  549\r\n  191  208  581\r\n  313  356  284\r\n  357  393  123\r\n   60  322  363\r\n  830   87  661\r\n  403  711  713\r\n  433  651  101\r\n  783  738  792\r\n  574  821  764\r\n  705  214  263\r\n  256  243  334\r\n  341  152  444\r\n  520  140  131\r\n  975  461  313\r\n  319  441  161\r\n  791   47  309\r\n  228  973  235\r\n  583  305  398\r\n  389  876  277\r\n  551  974  351\r\n  822  786  876\r\n  364  347  874\r\n  523  130  173\r\n  806   90  462\r\n  304  146  402\r\n  748  760  239\r\n  164  345  704\r\n  833  817  628\r\n  239  739  640\r\n  284  296  234\r\n  127  711  415\r\n  435  590  402\r\n  480  250  914\r\n  282  379  914\r\n  547  845  267\r\n  922  795  324\r\n  600  500  447\r\n  342  464   53\r\n  404  341  143\r\n  641  129   90\r\n  375  730  138\r\n  263   32  124\r\n  450  749  251\r\n  588  697   89\r\n  688  431  603\r\n  156  614  617\r\n  604  259  349\r\n  475  282   45\r\n  572  197  308\r\n  743  749  686\r\n  770  811  907\r\n  117  543  845\r\n   41  179  766\r\n  147  555  742\r\n  130  410  169\r\n  476   62  627\r\n  652  879  240\r\n  678  852  508\r\n  953  795  413\r\n  699  597  444\r\n  324  577  846\r\n  919   79  727\r\n  908  719  125\r\n  128  776  714\r\n  299  256  118\r\n  513  222  115\r\n  624   75  181\r\n    1  605  162\r\n   55  106  230\r\n   58  672  286\r\n  639  558  549\r\n  150  662  435\r\n  662  695  222\r\n  461  173  344\r\n  428  354  647\r\n   56  405  653\r\n  699  631  995\r\n  967  608  269\r\n  365  853  794\r\n  768  606  943\r\n  413  601  128\r\n  362  427  919\r\n  735  448  566\r\n  276  354  377\r\n  604  657  544\r\n  913  192  592\r\n  811  762   62\r\n  120  720  606\r\n  618  232  392\r\n   85   19  764\r\n  603  241  541\r\n  993  997  840\r\n  818  894  266\r\n  247  305  682\r\n  280  964  511\r\n  559  967  455\r\n  531   38  674\r\n  878  731  684\r\n  783  156  390\r\n  617  742  604\r\n  370  770  896\r\n  592  667  353\r\n  222  921  736\r\n  741  508  285\r\n  759  395  156\r\n   37  128  254\r\n  209  631  716\r\n  237  423  613\r\n   65  856  439\r\n  942  526  288\r\n  862  811  341\r\n  753  840   59\r\n  369   67  907\r\n  817  947  802\r\n  768  945  137\r\n  356  557  207\r\n  716    9  205\r\n  361  558    1\r\n  310  889  719\r\n   97  128  887\r\n  361  776  873\r\n   86  181  892\r\n  284  865  808\r\n  218  859  279\r\n  299  649  624\r\n  542  583  624\r\n  617   66   48\r\n  921  459   75\r\n  921  672  759\r\n  800  345  814\r\n  572  975  685\r\n  720  980  867\r\n  522  135  267\r\n  139  376   86\r\n  362  399  585\r\n  330  206  511\r\n  419  194  679\r\n  293  374    3\r\n  560  272  676\r\n  224  926  717\r\n  685  927  347\r\n  555  786  943\r\n  591  776  538\r\n  326  835  471\r\n  635   67  464\r\n  276  916  913\r\n  304  965    2\r\n   50  110  912\r\n  893  200  307\r\n  445  248  596\r\n  725  128  681\r\n  279  602  888\r\n    7  204  766\r\n  284  429  191\r\n  264  503  351\r\n  531  335  140\r\n  381  220  292\r\n  518  905  824\r\n  416  477  600\r\n  405  663  511\r\n  531   92  321\r\n  824  131  534\r\n  409  113  431\r\n   12  192  485\r\n  864  557  391\r\n  858  390  756\r\n   28  465  231\r\n  188  216  825\r\n  177  316  910\r\n  766   41  329\r\n  202  105  219\r\n  787  125  542\r\n  639  108    5\r\n  639   10  525\r\n   17  105  532\r\n  586  498  918\r\n  630  389   19\r\n  317  361  903\r\n  185  575  708\r\n  679  532  355\r\n  851  367  844\r\n  775   68  120\r\n  644   45  194\r\n  802   44  242\r\n  852  214  601\r\n  595  525  281\r\n  258  450  415\r\n  534  121  561\r\n  117   33  620\r\n  576  147  318\r\n  217  953  365\r\n  863  686  803\r\n  751  694  680\r\n  502  669  546\r\n  385  204  399\r\n  740  760  650\r\n  105  567  227\r\n  526  574  378\r\n  496  858  216\r\n  248  475   19\r\n  790  358  887\r\n  556  713  866\r\n  348  334  937\r\n  364  364   88\r\n  396   58  915\r\n  871  418  645\r\n  438  507  449\r\n  967  924  960\r\n  435  153   47\r\n  831  861  835\r\n  787  958  832\r\n  376  231  602\r\n  487  528  782\r\n  485  532  607\r\n  820   96  256\r\n  856  177  549\r\n  302  240  751\r\n  146  412  332\r\n  268  715  463\r\n  309  584  399\r\n  939  548  465\r\n  966  854  412\r\n  517  385  574\r\n  425  809  919\r\n   88  796  924\r\n  468  317  287\r\n  195  131  961\r\n   10  485  229\r\n  190  374  827\r\n  573  178  842\r\n  575  255  358\r\n  220  359  713\r\n  401  853  206\r\n  736  904  667\r\n  450  209  798\r\n  865   42  300\r\n  806  373  182\r\n  383  403  258\r\n  397   51  691\r\n  492  146  568\r\n  814  179  584\r\n  545  851  182\r\n  606  135  208\r\n  135  934  183\r\n  733  365  561\r\n  215   97  642\r\n  617  418  209\r\n  641  297  106\r\n  400  876  246\r\n  399  665  156\r\n  424   20  222\r\n  954  860  194\r\n  930  875   34\r\n  883  469  376\r\n  111  576  753\r\n  995  515  461\r\n  535  380  786\r\n  117  578  780\r\n  646  803  965\r\n  243  951  886\r\n  563  935  879\r\n  520   91  879\r\n  390  332  402\r\n  955  471  221\r\n  810  398  527\r\n  312  876  131\r\n  256  371  527\r\n  293  945  501\r\n  724  900  650\r\n  798  526  908\r\n  199  510  377\r\n  285  338  780\r\n  729  157  584\r\n  866  259  438\r\n   91  680  717\r\n  982  618  786\r\n  918  255  178\r\n   66  257  416\r\n  288  223   81\r\n  237  405  404\r\n  597  762  518\r\n  671  661   39\r\n  976  431  502\r\n  524  337  919\r\n  524  194  343\r\n   23  167  623\r\n  882  993  129\r\n  741  572  465\r\n  694  830  394\r\n  353  846  895\r\n  312  254  903\r\n   52  614  101\r\n  300  513  706\r\n  976  310  698\r\n  929  736   22\r\n  732  248  113\r\n  816  471  405\r\n  230  466  355\r\n  749  854  492\r\n  956  286  554\r\n  833  928  239\r\n  334  883  528\r\n  782  968  977\r\n  715  608  898\r\n  264  576  100\r\n  530  705  344\r\n  779  189  245\r\n  560  692  658\r\n  550  325  931\r\n   22  757  277\r\n  860  962  567\r\n  695  542  611\r\n  227  936  116\r\n  812  696  604\r\n  889  520  282\r\n  512  180  350\r\n  735  582  392\r\n  511  400  667\r\n  754  871  309\r\n  899  133  582\r\n  986   66  309\r\n  186  183  367\r\n  543  242  522\r\n  132  255  887\r\n  538  225  934\r\n   57  276  438\r\n  452  396  382\r\n  501  608  195\r\n  292  741  619\r\n   69  671  801\r\n  331  731  279\r\n  485  350  380\r\n   81  926  182\r\n  513  834  298\r\n  165  801  799\r\n  204  426  521\r\n  245  650  330\r\n  716  716  155\r\n  693  699  658\r\n  305   69  710\r\n  661  744  698\r\n  599  327  957\r\n  577  593  903\r\n  924  117  176\r\n  949  808  323\r\n  267  710  257\r\n   91  683  927\r\n  404  262  918\r\n  347  716  109\r\n  155  266  483\r\n  142  676  512\r\n  216  501  103\r\n  923  110  424\r\n  856  329  617\r\n  229  332  231\r\n  466  803  573\r\n  498  388  827\r\n   38  788  587\r\n  770  367  435\r\n  736  584  445\r\n   93  569  834\r\n   65  948  479\r\n  172  630  581\r\n  239  369  396\r\n  820  270  656\r\n   32  515  348\r\n  803  324  969\r\n   70  188  635\r\n  219  766  279\r\n  166  736  640\r\n  257  604  851\r\n  555  616  822\r\n  589  345  165\r\n  166  196   64\r\n  909  185  700\r\n  870  119  693\r\n   20  565  737\r\n  680  198  244\r\n  700  486  825\r\n  194  812   67\r\n  236  756  407\r\n   64  905  344\r\n   92  755  905\r\n  748  349  681\r\n  707  781  811\r\n  505   50  456\r\n  471  889  672\r\n   35  891  334\r\n  899  411  164\r\n  663  459  232\r\n  539  446  322\r\n   57  785  718\r\n  273  421  308\r\n  308  744  501\r\n   45  819  416\r\n  936  258  466\r\n  980  825  841\r\n  100   33  345\r\n  898  904  750\r\n  920  903  453\r\n  947    9  765\r\n  580  979  375\r\n  753  977  844\r\n  402  174  156\r\n  573  827  782\r\n  975  663  644\r\n  179  358  353\r\n   55  777  834\r\n  221  871  631\r\n  120  714  199\r\n  663  369  217\r\n  599  713  135\r\n   11  472  765\r\n  803  445  746\r\n  797   30  284\r\n  259  776  677\r\n  598  707  675\r\n  484  339    3\r\n  298  750  162\r\n  119  820  168\r\n  180   69    9\r\n  433  332  676\r\n  142  164  343\r\n  435  233  414\r\n  153  977  263\r\n  532   54  244\r\n  600  999   25\r\n  394  756  311\r\n  354  196  703\r\n  666  858  760\r\n  227  312  525\r\n  389  419  436\r\n  218  311  744\r\n  318  531  245\r\n  324  939  509\r\n  183  997  543\r\n  944  598   70\r\n  790  486  828\r\n  710  745  880\r\n  546  368  219\r\n  316  668   29\r\n  398  360  218\r\n  702  453  987\r\n  774  462  373\r\n  722  829  947\r\n  541  732   44\r\n  310  494  582\r\n  239  596  548\r\n  579  810  907\r\n  490  169   62\r\n  926  883  915\r\n  281  414  595\r\n  845  412  609\r\n  632  106  618\r\n  112  404  492\r\n  864  460  314\r\n  842   93  436\r\n  412  805  874\r\n  353  686  465\r\n  240  393  800\r\n  788  654  346\r\n  666   78  185\r\n  418  608  404\r\n  658  537  960\r\n  794  449  680\r\n  711  324  489\r\n   59  525  330\r\n  323  259  544\r\n  359  745  542\r\n  877  701  403\r\n  119  897  533\r\n  977  392  227\r\n  528  340  194\r\n  398  180  283\r\n  538  301  123\r\n  775  263  195\r\n   53  385  630\r\n  749  253  686\r\n  533   30  624\r\n  678  187  590\r\n  937  218   50\r\n  205  466  918\r\n  796  672   47\r\n  818  203  963\r\n  461  953  881\r\n  739  457  696\r\n  661  711  220\r\n  624  121  663\r\n  908  173  644\r\n  602  185   70\r\n  168  957  159\r\n  283  341  934\r\n  196  845  939\r\n  494  354  543\r\n  796  422   87\r\n  430  762  478\r\n  526  762  859\r\n  535  600  926\r\n   28  555  651\r\n  170  748  379\r\n  117  745   33\r\n   52    1  351\r\n  946  796  446\r\n  148  844  920\r\n  950  131  740\r\n  392  490  118\r\n  286  465  667\r\n  202  101  662\r\n  326  629  556\r\n  773  661  219\r\n  540  683  613\r\n  406  314  525\r\n  154  947  451\r\n  401  661  186\r\n  574  690  796\r\n  558  730  855\r\n  153  244  156\r\n  618   37   10\r\n  856  991  363\r\n  820  959  370\r\n  644  700  800\r\n  421  469  908\r\n  422  233  288\r\n  416  281  707\r\n  370  430  487\r\n  284  525  916\r\n  535  713  354\r\n  210  576  524\r\n  432  930  215\r\n  712  374  612\r\n  686  508  102\r\n   40  141  616\r\n  979  525  663\r\n  838  696  326\r\n  472  261  357\r\n  321  910  663\r\n  228  153  536\r\n  223  940  896\r\n  137   39  506\r\n  139  706  187\r\n    4  666  483\r\n  944  856  119\r\n  720  602   93\r\n  410  260   85\r\n  601  647  520\r\n  162  474  317\r\n  599  742  313\r\n  242  886  381\r\n  250   78  353\r\n  109  916  117\r\n  597  926  673\r\n  318  114  309\r\n  892  819  424\r\n  491  682   85\r\n  765  657  682\r\n  558   60  721\r\n  990  634  160\r\n  640  461  410\r\n  430  839  535\r\n   42  961  686\r\n  752  251  690\r\n  747  931    3\r\n  439  930   85\r\n   44  628  953\r\n  465  961  874\r\n  313  447  913\r\n  249  600  859\r\n  359  896  472\r\n  698  187  657\r\n   57  957  805\r\n  721  977  239\r\n  782   93   96\r\n  860  159  250\r\n  368  142  218\r\n  565  157   46\r\n  622  403  383\r\n   63  546  382\r\n   63  774  308\r\n  446  495  475\r\n  467  831  310\r\n  448   77  798\r\n  930  281  189\r\n  767  289  644\r\n  514  765  524\r\n  330  827  992\r\n  340  284  964\r\n  600   97  785\r\n  418  432  755\r\n  983  442   58\r\n  872  435  725\r\n  107  344  315\r\n  917  682  547\r\n   24  613  561\r\n  665  448  238\r\n  680  872  737\r\n  108  180  449\r\n  220  545  583\r\n  268  676  863\r\n  796  791    2\r\n  694  992   39\r\n  788  767   41\r\n  235  572  377\r\n  975  864  883\r\n  953  448  608\r\n  909  888  452\r\n   93  850  414\r\n  852   48   49\r\n  136  558  842\r\n  300  428  776\r\n  427  814   64\r\n  223   45  283\r\n  100  562  659\r\n  290  519  828\r\n  678  786  346\r\n  371  711  934\r\n  686  276  826\r\n  808  208  669\r\n  832  198    6\r\n  317   11  675\r\n  504  182  448\r\n  162  745  642\r\n  623  791  687\r\n  408  947  693\r\n  247  267  641\r\n  328  693  758\r\n  773  411  149\r\n   66    2  589\r\n  786  407  527\r\n   81  760  803\r\n  946  696  552\r\n  878  698  994\r\n  190  203  649\r\n  548  713  634\r\n  657  724  676\r\n  195  397  887\r\n  175  346  118\r\n  356  264  981\r\n  191  919  468\r\n  490  470  570\r\n  583  740  151\r\n  340  773  889\r\n  176  446  314\r\n  206  384  935\r\n  172  996  620\r\n  362  842  497\r\n  208  786  731\r\n  207  395  750\r\n  368  819   87\r\n  524  524  702\r\n  609  761  554\r\n  753  975  290\r\n  559  932  731\r\n  584  203  140\r\n  477  100  982\r\n  784  162  876\r\n  371  209   67\r\n  236  754  108\r\n  439  633  163\r\n  734  717  626\r\n  808  216  639\r\n  133  521   94\r\n  180  813  208\r\n  136  770  844\r\n   57  867  871\r\n  700  900  740\r\n   96   75  662\r\n  628  893  284\r\n  843  851  196\r\n  546  427  607\r\n  797  471  664\r\n  180  363  117\r\n  961  775   95\r\n  846  969  210\r\n  535  269  666\r\n  216  585  490\r\n  736  521  335\r\n  489  493  602\r\n  627  574  723\r\n  857  217  629\r\n  385  808  433\r\n  615  115  361\r\n  687  705  455\r\n  898  390  177\r\n  737  393  476\r\n  355  727  371\r\n  533  526   69\r\n  615  467  157\r\n  614  683  202\r\n  876  892  581\r\n  949  165  357\r\n   86  766  432\r\n  233   47  702\r\n  448  407  821\r\n  227  364  424\r\n  158  372  933\r\n  966  405  365\r\n  913  512  813\r\n  585  698  482\r\n  720  171  716\r\n  172  868  740\r\n   96  489   33\r\n  531  882  552\r\n  618  949  523\r\n  425  860  424\r\n  909  676  116\r\n  806  770  430\r\n  836  868  355\r\n  640  561  523\r\n  858  353  411\r\n  400  149  612\r\n  872  364  491\r\n  940  469  870\r\n  127  256   47\r\n  561  306  322\r\n  626  147  276\r\n   13  547  289\r\n  218  561  705\r\n  234   16  842\r\n  301  663  261\r\n   81  415  368\r\n  301  945  593\r\n  232  855  760\r\n  522  649  929\r\n  401  847  376\r\n  764  542  452\r\n  774  536  929\r\n   10  935  499\r\n  710  262   94\r\n   72  475  524\r\n  722  618  481\r\n  515  135  637\r\n  962  115  303\r\n  665   88  416\r\n  544  303  735\r\n  828  488  680\r\n  827  575  354\r\n   44  999  437\r\n  232  985  128\r\n  226   36  346\r\n  310  325  307\r\n  473  809  315\r\n  184  487   91\r\n  778  310  926\r\n  749  260  988\r\n  869  216  878\r\n  663  790  458\r\n  914  237  476\r\n  258  935  201\r\n  956  796  313\r\n  888  105  282\r\n  160  874   42\r\n  715  524  451\r\n  477  604  886\r\n  596  111  554\r\n  524  510  388\r\n  778  878  320\r\n  894  453  574\r\n  210  808  633\r\n  340   77  956\r\n  159  872  426\r\n    4  756  333\r\n  528  697  677\r\n  530  474  442\r\n   75  427  536\r\n  874  706  437\r\n  944  536  357\r\n  726  919  349\r\n  911  791  637\r\n  447  224  483\r\n  742  941  693\r\n  632   42  918\r\n  302  907  547\r\n  204  618  927\r\n   86  765   15\r\n  280  396  926\r\n  857  422  560\r\n  801  355  368\r\n   53  718  577\r\n  613  946  933\r\n  641  378  563\r\n   39  928  423\r\n  252  906  454\r\n  626  318   81\r\n  477  838  407\r\n   85  531  475\r\n  129  622  419\r\n  184  372  147\r\n  364  805  559\r\n  445  128  302\r\n  656  813  724\r\n  485  140  509\r\n  537  267  549\r\n  164  184   89\r\n  464  231  881\r\n  111   63  706\r\n  383  283  567\r\n  408   31  455\r\n  698  864  501\r\n  692  887  753\r\n  573  681  783\r\n  453  393  338\r\n  171  707  850\r\n   68  663  190\r\n  342  588  284\r\n  309  218  102\r\n  121  743   56\r\n  321  722  379\r\n  307   99  357\r\n  444  485  636\r\n  548  419  517\r\n  407  101  714\r\n  168  496  140\r\n  111  520  594\r\n   55  129  476\r\n  706  849   93\r\n  529  200  416\r\n  848  680  470\r\n  731  189   61\r\n  591  689   20\r\n  801  777   52\r\n  395  449  821\r\n  337  421  292\r\n  618  208  674\r\n  116   13   66\r\n  459  790  615\r\n  429  796  565\r\n  891  795  903\r\n  929  443  263\r\n   49  694  890\r\n  708  929  577\r\n  764  786  554\r\n  971  473  236\r\n  271  483  440\r\n  666  506  858\r\n  582  959  594\r\n  470  918  457\r\n  583  662  551\r\n  777  446  214\r\n  609  503  929\r\n  861  691  766\r\n  256  201  940\r\n  894  386  172\r\n  624  397   17\r\n  615    9  159\r\n  454  494  344\r\n  606  717  995\r\n  251  333  688\r\n  714  910  670\r\n  531  346  227\r\n  693  754  745\r\n  947    8  411\r\n    9  862  598\r\n  937  858  601\r\n  309  977   18\r\n  731  684  943\r\n  579  384  958\r\n  359  647  495\r\n    8  355  476\r\n  363  459   21\r\n  712  383  997\r\n  892   71  981\r\n  374  433  156\r\n   86  194  341\r\n   60  298  385\r\n   31  110  452\r\n  813  501  635\r\n  249   82  215\r\n  895  585  456\r\n  571  961  784\r\n  734  746  854\r\n  742  268   73\r\n  575    7  583\r\n  660  643  908\r\n  559  643  336\r\n  222  725  935\r\n  660   82  939\r\n  709  745   41\r\n  277  504  918\r\n  604  679  913\r\n  717  419  183\r\n  613  306  732\r\n  491  694  742\r\n  628  707  108\r\n  885  867  527\r\n  970  740  567\r\n  147  267  119\r\n  288  766  969\r\n  132  190  372\r\n  175  862  992\r\n  942  468  639\r\n   63  908  581\r\n  939  703  830\r\n  328  186  554\r\n  936  130  355\r\n  865  270  479\r\n  253  104  444\r\n   99  378  107\r\n  342  385  340\r\n  651  480  324\r\n   14  841  249\r\n  635  538   79\r\n  229  415  530\r\n  489  931  329\r\n  654  828  719\r\n  911  703  693\r\n  202  425  201\r\n  897  314  745\r\n  126  606  323\r\n  201  459  307\r\n   79  719   51\r\n  595  913  432\r\n  261  980  554\r\n  708  272  591\r\n  423  754   58\r\n  175  538  449\r\n  552  671  418\r\n  871   86  809\r\n    5  579  309\r\n  877  635  850\r\n  607  621  470\r\n  584  166  732\r\n  443  666  887\r\n  305  612  454\r\n  547  252   90\r\n  324  431  510\r\n  827  912  501\r\n  329  868  593\r\n  524  944  461\r\n   10  709  299\r\n  902   76  539\r\n  894  783  448\r\n  304  883  270\r\n  358  716  346\r\n  626  192  530\r\n  900   47  880\r\n  807  796  757\r\n  672  774  885\r\n  596  391  358\r\n  300  355  318\r\n  617   44  310\r\n  363   51  907\r\n  138  183  704\r\n  243  184  234\r\n  977  406  460\r\n  811  692  579\r\n  412  459  196\r\n  509  346  366\r\n  697  646  777\r\n  247  930  583\r\n  383  268   54\r\n  387   11  471\r\n  434  273  444\r\n  462  191  917\r\n  474  236  605\r\n  924  192  348\r\n  515   15  128\r\n  398  609  300\r\n  608  627  296\r\n  289  624  427\r\n   16  448   70\r\n  280  329  492\r\n  186  448  444\r\n  709   27  239\r\n  566  472  535\r\n  395  737  535\r\n  666  108  512\r\n  398  788  762\r\n  187   46  733\r\n  689  389  690\r\n  717  350  106\r\n  243  988  623\r\n   13  950  830\r\n  247  379  679\r\n  654  150  272\r\n  157  229  213\r\n  710  232  314\r\n  585  591  948\r\n  193  624  781\r\n  504  553  685\r\n  135   76  444\r\n  998  845  416\r\n  901  917   69\r\n  885  266  328\r\n   32  236  487\r\n  877  223  312\r\n  602  264  297\r\n  429  852  180\r\n  558  833  380\r\n  579  341  829\r\n  708  823  603\r\n  480  625  551\r\n  168  995  465\r\n   24  236  898\r\n  180  770  985\r\n  827  126  352\r\n  790  491  324\r\n  198  379  105\r\n  953  609  224\r\n  793  519  389\r\n  988  303  169\r\n  636  575  937\r\n  460  869  500\r\n  859  552  819\r\n  647  650  366\r\n  838  643  233\r\n  223  170  244\r\n  689  381  542\r\n   15  293  371\r\n  696  443  796\r\n  549  128  525\r\n  919  719  231\r\n  651  599  417\r\n  413   80  413\r\n  864  940  344\r\n  753  989  342\r\n  583  816   28\r\n  399  818  894\r\n  522    1  884\r\n  105  122  148\r\n    2  868  301\r\n  100  945  306\r\n  990  516  458\r\n  604  484   27\r\n  587   36  468\r\n  774  726  241\r\n  931  993  277\r\n  908  406  352\r\n  783  586  706\r\n  760   27  469\r\n   42  611  958\r\n   72  118  399\r\n  526  638   55\r\n  598  737  392\r\n  134   84  825\r\n  734  804  273\r\n  600  778  888\r\n  788  539  691\r\n   57  854  592\r\n  824  629  286\r\n  359   24  824\r\n  548  857  646\r\n  820  831  194\r\n   29  842  939\r\n  966  133  201\r\n  992  709  970\r\n  357   44   29\r\n  320  649  356\r\n   35  611  379\r\n  407  894  581\r\n  408  940  680\r\n  652  367  124\r\n  630  200  182\r\n  652  271  828\r\n   65  296  786\r\n  821   42  341\r\n   84   24  562\r\n  894   29  500\r\n  739  799  310\r\n  289  461  385\r\n  540  731  430\r\n  393  303  389\r\n  756  560  731\r\n  637  470  761\r\n  105  314  202\r\n  339  437  717\r\n  256  526  810\r\n  639  382  381\r\n   11  289  290\r\n  638  450  336\r\n  602  415  901\r\n  671  494  718\r\n  460  507  186\r\n  596  160  528\r\n  766  811  389\r\n  319  955  281\r\n   24  317  562\r\n  489  870  295\r\n  514  924  477\r\n  386  887   49\r\n  479  940  432\r\n  558  523  416\r\n  343   53   46\r\n  542  803  597\r\n  696  784  565\r\n  474  495  650\r\n  613  692  465\r\n  352  841  199\r\n  911  927  640\r\n  273  693  512\r\n  701  468  597\r\n  144  915  630\r\n  949  967  185\r\n  952  293  538\r\n  642  426  249\r\n  788  408  678\r\n  457   32  579\r\n  571  462  686\r\n  650  752  651\r\n  260  681  182\r\n  158   89  312\r\n  693  336  517\r\n  812  355  634\r\n  216  507  591\r\n  643  520  310\r\n  769   18  896\r\n  630  852  677\r\n  566  912  185\r\n  643  621  739\r\n  433  347   52\r\n  691  413  758\r\n  262  458  761\r\n  882  877  576\r\n  914  254  194\r\n  407  919  511\r\n  826  345  490\r\n  551  187  611\r\n  501  163  507\r\n   59  749  708\r\n  364  502  718\r\n  390  317   38\r\n  316   77  424\r\n  400  834  339\r\n  296  868  102\r\n  360  533   38\r\n  326  607  529\r\n  442  962  544\r\n  773  371  300\r\n   22    6  300\r\n  789  378  386\r\n  643  461   14\r\n  486  312   75\r\n  901  428   73\r\n  275  734  871\r\n  384  793  475\r\n  197   59  798\r\n  662  682  342\r\n  812  638  459\r\n  461   59  642\r\n  895  253  990\r\n  693  128  596\r\n  415  270  537\r\n  587  193  575\r\n  265  644  638\r\n  745  661   61\r\n  465  712  251\r\n  269  617  285\r\n  257  958  442\r\n  387  120  612\r\n  776  833  198\r\n  734  948  726\r\n  946  539  878\r\n   58  776  787\r\n  970  235  143\r\n  129  875  350\r\n  561  999  180\r\n  496  609  390\r\n  460  184  184\r\n  618  137   25\r\n  866  189  170\r\n  959  997  911\r\n  631  636  728\r\n  466  947  468\r\n   76  708  913\r\n   70   15  811\r\n   65  713  307\r\n  110  503  597\r\n  776  808  944\r\n  854  330  755\r\n  978  207  896\r\n  850  835  978\r\n  378  937  657\r\n  403  421  492\r\n  716  530   63\r\n  854  249  518\r\n  657  998  958\r\n  355  921  346\r\n  761  267  642\r\n  980   83  943\r\n  691  726  115\r\n  342  724  842\r\n  859  144  504\r\n  978  822  631\r\n  198  929  453\r\n  657  423  603\r\n  687  450  417\r\n  297   44  260\r\n  158  460  781\r\n   29  108  744\r\n  136  486  409\r\n  941  659  831\r\n   71  606  640\r\n  908  251  372\r\n  403  180  857\r\n  458  598   52\r\n  184  594  880\r\n   38  861  395\r\n  302  850  883\r\n  262  580  667\r\n    2  905  843\r\n  474  825  794\r\n  473  209   96\r\n  926  833  585\r\n  903  119  532\r\n   23  712  831\r\n  875  558  406\r\n  146  635  851\r\n  844  703  511\r\n  900  530  612\r\n  824   21  356\r\n  746  511  721\r\n  737  445  326\r\n  644  162  309\r\n  892  291   17\r\n  105  581  795\r\n  318  869  402\r\n  408  289  535\r\n  656  444   83\r\n  647  754  133\r\n   43  901  205\r\n  386  420  766\r\n  549   90  859\r\n  756  436  188\r\n  664  491  753\r\n  700  402  573\r\n  403  590  189\r\n  258  982   20\r\n    4  553  529\r\n  264  718  538\r\n  206  647  136\r\n  257  860  279\r\n  338  449  249\r\n  421  569  865\r\n  188  640  124\r\n  487  538  796\r\n  276  358  748\r\n  269  260  625\r\n   83  106  309\r\n  496  340  467\r\n  456  953  179\r\n  461  643  367\r\n  411  722  222\r\n  519  763  677\r\n  550   39  539\r\n  135  828  760\r\n  979  742  988\r\n  868  428  315\r\n  423  535  869\r\n  677  757  875\r\n  853  415  618\r\n  591  425  937\r\n  585  896  318\r\n  207  695  782\r\n  200  904  131\r\n   95  563  623\r\n  176  675  532\r\n  493  704  628\r\n  707  685  521\r\n  690  484  543\r\n  584  766  673\r\n  667  933  617\r\n  276  416  577\r\n  808  966  321\r\n  327  875  145\r\n  660  722  453\r\n  769  544  355\r\n   83  391  382\r\n  837  184  553\r\n  111  352  193\r\n   67  385  397\r\n  127  100  475\r\n  167  121   87\r\n  621   84  120\r\n  592  110  124\r\n  476  484  664\r\n  646  435  664\r\n  929  385  129\r\n  371   31  282\r\n  570  442  547\r\n  298  433  796\r\n  682  807  556\r\n  629  869  112\r\n  141  661  444\r\n  246  498  865\r\n  605  545  105\r\n  618  524  898\r\n  728  826  402\r\n  976  826  883\r\n  304    8  714\r\n  211  644  195\r\n  752  978  580\r\n  556  493  603\r\n  517  486   92\r\n   77  111  153\r\n  518  506  227\r\n   72  281  637\r\n  764  717  633\r\n  696  727  639\r\n  463  375   93\r\n  258  772  590\r\n  266  460  593\r\n  886  950   90\r\n  699  747  433\r\n  950  411  516\r\n  372  990  673\r\n   69  319  843\r\n  333  679  523\r\n  394  606  175\r\n  640  923  772\r\n  893  657  638\r\n  563  285  244\r\n  874  579  433\r\n  387  758  253\r\n  389  114  809\r\n  736  269  738\r\n  345  173  126\r\n  248  793  502\r\n  422  271  583\r\n  399  528  654\r\n  825  956  348\r\n  822  378   52\r\n    7  658  313\r\n  729  371  395\r\n  553  267  475\r\n  624  287  671\r\n  806   34  693\r\n  254  201  711\r\n  667  234  785\r\n  875  934  782\r\n  107   45  809\r\n  967  946   30\r\n  443  882  753\r\n  554  808  536\r\n  876  672  580\r\n  482   72  824\r\n  559  645  766\r\n  784  597   76\r\n  495  619  558\r\n  323  879  460\r\n  178  829  454\r\n   12  230  592\r\n   90  283  832\r\n   81  203  452\r\n  201  978  785\r\n  643  869  591\r\n  647  180  854\r\n  343  624  137\r\n  744  771  278\r\n  717  272  303\r\n  304  298  799\r\n  107  418  960\r\n  353  378  798\r\n  544  642  606\r\n  475  300  383\r\n  445  801  935\r\n  778  582  638\r\n  938  608  375\r\n  342  481  512\r\n  666   72  708\r\n  349  725  780\r\n  368  797  163\r\n  342  815  441\r\n  167  959  681\r\n  499  199  813\r\n  475  461  495\r\n  354  462  532\r\n  390  730  369\r\n  202  623  877\r\n  656  139  883\r\n  495  666    8\r\n  348  955  976\r\n  998  356  906\r\n  725  645  938\r\n  353  539  438\r\n  982  470  636\r\n  651  140  906\r\n  895  706  538\r\n  895  721  203\r\n  158   26  649\r\n  489  249  520\r\n  320  157  751\r\n  810  274  812\r\n  327  315  921\r\n  639   56  738\r\n  941  360  442\r\n  117  419  127\r\n  167  535  403\r\n  118  834  388\r\n   97  644  669\r\n  390  330  691\r\n  339  469  119\r\n  164  434  309\r\n  777  876  305\r\n  668  893  507\r\n  946  326  440\r\n  822  645  197\r\n  339  480  252\r\n   75  569  274\r\n  548  378  698\r\n  617  548  817\r\n  725  752  282\r\n  850  763  510\r\n  167    9  642\r\n  641  927  895\r\n  201  870  909\r\n  744  614  678\r\n   44   16  322\r\n  127  164  930\r\n  163  163  672\r\n  945  865  251\r\n  647  817  352\r\n  315   69  100\r\n   66  973  330\r\n  450  972  211\r\n  401   38  225\r\n  561  765  753\r\n  554  753  193\r\n  222   13  800\r\n  124  178  456\r\n  475  703  602\r\n  420  659  990\r\n  487   94  748\r\n  578  284  577\r\n  776  355  190\r\n  194  801  566\r\n   42  124  401\r\n  179  871  669\r\n  303  123  957\r\n  596  503  820\r\n  846  424  985\r\n  522  882  254\r\n  835  811  405\r\n  796   94  209\r\n  185  355  394\r\n  387  145  223\r\n  300  240  395\r\n  381  826  899\r\n  503  868  606\r\n  121  675  467\r\n  159  456  724\r\n   28  477  233\r\n  165   43  566\r\n  159  404   26\r\n  969  413  725\r\n  927  389  733\r\n  720  345   38\r\n  752  197  879\r\n  219  196  866\r\n  583  195   84\r\n  654  996  364\r\n  234  941  298\r\n  136  890  732\r\n  147  296  874\r\n  245  948  627\r\n  633  404  794\r\n  443  689  477\r\n  819  923  324\r\n  391  821  683\r\n  774  255  339\r\n  684  856  391\r\n  751  420  608\r\n  594  884  207\r\n  280  903  472\r\n  365  916  620\r\n  421    1  760\r\n   66  913  227\r\n   73  631  787\r\n  471  266  393\r\n  469  629  525\r\n  534  210  781\r\n  765  198  630\r\n  654  236  771\r\n  939  865  265\r\n  362  849  243\r\n  670   22  225\r\n  269  644  843\r\n   30  586   15\r\n  266  178  849\r\n  237  547  926\r\n  908   33  574\r\n  788  525  895\r\n  717  448  413\r\n  951    4  254\r\n  931  447  158\r\n  254  856  371\r\n  941  803  322\r\n  697  678   99\r\n  339  508  155\r\n  958  608  661\r\n  639  356  692\r\n  121  320  969\r\n  222   47   76\r\n  130  273  957\r\n  243   85  734\r\n  696  302  809\r\n  665  375  287");
		System.out.println(result);
	}

	public static int test(String s) {
		int result = 0;

		String[] parts = s.split("\r\n");
		for (int i = 0; i < parts.length; ++i) {
			Scanner scanner = new Scanner(parts[i]);
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			boolean isPossible = a + b > c && a + c > b && b + c > a;
			if (isPossible) {
				++result;
			}
			scanner.close();
		}

		return result;
	}
}