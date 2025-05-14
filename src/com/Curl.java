package com;

public class Curl {


    public static void main(String[] args) {
        //

//        "curl 'https://alibole.alibaba-inc.com/OnlineAssessment' \\\n" +
//                "  -H 'accept: */*' \\\n" +
//                "  -H 'accept-language: zh-CN,zh;q=0.9,en;q=0.8' \\\n" +
//                "  -H 'content-type: application/json' \\\n" +
//                "  -b 'ck2=7aa70afb59774f61f340bdcec0fc6e43; lg=true; bs_n_lang=zh_CN; SSO_EMPID_HASH_V2=885cfcbf556ba8e1d7513832a3c7a80d; SSO_BU_HASH_V2=688aa1a074c47ffc3641150634c56bcf; an=hanshunli.hsl; sg=l38; ALIPAYCHAIRBUCJSESSIONID=b6096b5e-5762-462a-a82d-d090b209f971; ordv=A0tnTX08Bw..; cna=u5fQHz5xhSACAQAAAABZx7PW; _ga=GA1.2.780824789.1737459777; _ga_QFWN0KYHTY=GS1.1.1737459776.1.1.1737459788.48.0.0; emplId=391578; SSO_LANG_V2=ZH-CN; c_token=bfc61b126c773d0e3e58c5723ce04346; sgcookie=E1001Ae3QHUgENCFZVqO1iegySpn5Agkwg1XO5OlF8VwvDbNBP4ZZo/xpcxZfZ2FYjDDwv3SoCwBQV//PEAJ+ExOUkz9gC0Uc7tso3izn9KiD10=; _CHIPS-ALIPAYCHAIRBUCJSESSIONID=b6096b5e-5762-462a-a82d-d090b209f971; x_umt=P1gAJcQQakUOb2LahepznpfwJ0svoiLLlWMnnLyGm4L91zW_ZePcnQx3nB3FmBx2WjyjthYFzCOeGrBMpJju8TCW; yuque_ctoken=dakwa4nt9xhphqwdfcu676pm16vpp225; rtk=HXmzqWunGNdb+huYzGlHUjQWtQUPhNMLCLpFBQJgLXFYhNqhzGT; xlly_s=1; SSO_REFRESH_TOKEN=buccaa8fd15c10645f490067c04888002d068100; x_mini_wua=A3pg7bPVuyCVaZvbrLBl2+gdQWxgckCn85yMpWjwvyQxfqojwBm1gIeTLLX1sMrMDBXoBQn+2U82ZgdwBQB12seEEv0tjwMn+TkxKYTD/wnn9Z/2KXKcgsxG4619x4ZinA6nE5w0e9qD0afmRB47L+LEeyawWNuuf8AXpSLMoIM4fM42zkXwwFx63Ku9y5yWC6i6LulL+YuxF059YgwJoqB9LssjLDBtXUiyWe8/vx9ljYmMgOAJvfMjmnuoI0V4fMZJ59FB2KW4RgPjzhB0UUhmZDL1w2nB6HvaKaarVEARrmlnlduWLFB8UHCBRQgNSdrUxw3oyZKENBMxfb4bdHhltJm2jEPe/Vl5K2p7eV3K; x_sign=mb0001001043ed3bdf7ae121e05b903bad513b1b2dceda8483; alibole_USER_COOKIE_V3=ST180.Anp_P6GvrRDfeAm1H24yMoys2pnAxn0--77c-6MFk1weXvw9i8MNTAuV2jp15M1gT9ys9-niD1V3ZFY-7Qdaqjofcru2KsPjssV5G81g97udsAvo__b815yCBg8L_1XwmywU8GZJNa9zMbtJjhe5IbYcyETQZ_3_dXEXkJptP98sYFS8U2-hXx7FYNmZlLH_YOHhoCrpYDBLpe08UmtUUNl4j528BeBQhavS_rEpx1X00r7TNDAy0OL2jVh08XLRjTrFrD3EbzigrHbekPm8OS_EgZNUTXFiTdw1u7vU2YLL6Wn8lNanJJfdOIldvL_WYPDyAIKoifRKFmGS86_VmcCe47orlkUj4-eVUGlWagTmkikfJJMcMtNNGMa7oZiimRTSRkt9uZGL-8NHDQ3tIZu39ZoiGb4gQ4JV0YDAAsoCaClb2hxR_mUFXjPY6pK1X25YkiWBzkzNy1YXqmq7rm79CKJ6fE06laM4GIiJJzrOhWXSVsXRQv20Hs70urutalYceQ9QVf1uNJSldAeTXPsYCIoYUikU11eRWNx3scRet8lOgqIbPdBgxqKEdKKW0duJehxy35CeCDi8DFB1HG_AZPaP4zU9RhN2PW9yi8mh3nGh1nATlBqL48YrFFwNpiK8nPVRjPL6t2qZqnHRMy1XdotHBOrnVf3kF0UvxiOg4Gl4vG4R4h8TxcncDsQbj9WSTTFtxFjcqS5n2xILPZLUk0iJorpkJtkTic3N2YwV2aYtFJvyRanTYyuPx77dOEMvfHvDmf7wr0rilhV7HW7Sd-GsG9V70DwXtYvuX25CV0XVTjJFoAgxFORtquAL0PbdzUFi4ZwnsIHNiIw5-yVLHUnO8p0yXlVL9yYodGc.Xtshk-ux8Qgu5j1hJl2IVoT0nUs_otg25pJ4euctY-Iy-34g51dNWJJG5E4QvuKa-xQgSJzMi62A07_KzXeg3mgTyoiHDM-fjOTVta0l7UCBHqPbKof4tIQUMJYcpayO5eabuZ2gIIEUfz_YPiq80xMzTXIOeUDzSl4m_ZDEOjtvmE0XHp30dw_D1RiD0i3Ifkht8R-MNUjiFWhp6OvzLqRBka5lmK7jbIjOldPxFwKeEzP5-PD8VnRcIF63-2DE5pfsB0UF8PMYp6BUyyy2VXM0W6FgWq-3myRTWOR7aA67xQ9rCP-WKulH5XTuChbpn4Dly8Er_H2B6oMHYFMp3Q; alibole_SSO_TOKEN_V3=ST180.eyJ0aW1lIjoxNzQwNjYwMTcxNjI0LCJ0b2tlbiI6ImJ1YzAxNmMxMDFjZjg2MTRhOTA4NDA2N2MwNWJkZDAwMmQwNjgxMDAifQ.hi56RNaLiIfvaaqSsqE5yr7iUUtUDL05jmG1dMtJmcvehN_J5oUZufquppLsqX_m-sSYGr6nmX6-p6cc2Bj7aqoZe0TlTc8oO9KSXKm6UGBNJZi4wz_at_i_tSaESd1039MZnBIaAXLp8UWokghoShg_iDw1RAcxgu-FQM772-0q46Jt5yb3kK3NoChHSSLsv1PoHVXgoQzgCOEAxpcMs_RJBBEfDqLMFlaIhIRFOJKPsglOFkH_ZCnVXuVabGciCJQyBGkgTC4E-HvnPhBulmnowYSyDBLni51J8cUBLhX40UY27DAKtFwe0hNmy-0lBTEkqKSfbjWtqxGKbPpWgw; isg=BFBQD8cBAxNbJt-eU6ZoDzLNIZiiGTRjmlXNw0ohXKt-hfAv8imQ8672XU1lVew7; tfstk=gb1-0Fterr38z3OgZ7wmtmSzc540s6QPug7stHxodiIAxi_u8Qjn9tIhca4UUJRdMgjcZpZyZ6IARNartTqPDBIV2y-lxz5A9Mj0zg4yNH9CAn-HVkzyRBdPiTcHquRdRGALjlVgsa7ywBZgjhMhdXRBRWxQnLMJApR3jlVgia7yTBZGq5gzbxLecUTBFBavGFKXRUsBVKiXWFRBAMsIlxTw84TBAYaAln8BOHsBFf4uvngWxXB6Z9UtFmhKIAfvyLKKtnhKlyYJeLQWDlZ1MX9JfatxOl8eQn-XWsZEqH5Al_TGcScJ9ZTdXQ6YcbIdPOSe5gNxVUB5WNvATlGputsynUBYRxt553_6Z6mbyH5l26pP1lc2VtCV9QX02fxedtfyQ_qjwC6NrQXCcyGBvtTC4zCG6OLojhLnFrUxLvJWu2FmPts8sJuWkh489vke3rlne1qZdviNhEKgylDELKzV.' \\\n" +
//                "  -H 'origin: https://alibole.alibaba-inc.com' \\\n" +
//                "  -H 'priority: u=1, i' \\\n" +
//                "  -H 'referer: https://alibole.alibaba-inc.com/static/alibole-manage/src/p/detail/index.html?codeId=7000014027' \\\n" +
//                "  -H 'sec-ch-ua: \"Not(A:Brand\";v=\"99\", \"Google Chrome\";v=\"133\", \"Chromium\";v=\"133\"' \\\n" +
//                "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
//                "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
//                "  -H 'sec-fetch-dest: empty' \\\n" +
//                "  -H 'sec-fetch-mode: cors' \\\n" +
//                "  -H 'sec-fetch-site: same-origin' \\\n" +
//                "  -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/133.0.0.0 Safari/537.36' \\\n" +
//                "  -H 'x-requested-with: XMLHttpRequest' \\\n" +
//                "  --data-raw '{\"operation\":\"getCode\",\"argument\":{\"codeId\":\"7000014027\"}}'"
    }
}
