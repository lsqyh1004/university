package com.qf.pojo;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600703806";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCLJGjNfsN4iWB8WUYB9nU5/FPcdi7FDOaCuCtpqlcp4ouygDQkPAPVbtcl7l9zBlGF+uvFCKMV3Nn/QSNrT7mLUeQ5Jm0IoVXqhp4x6G6+T+mThPze9AQ98nROJ80VBfNph8EQcOOHimDzGIqT3Q22bQsCIeszJJIg8/VXG2LYgTaOHy1TQkxpQRpvBNnn+4rJmK70t+VbMs5bnSSdS4BBc1GBzAOyv1DGShjyWmK1G2hBeBv0Peypt2/zsCg5pAtwvG6grVv70oyvlrr3kwNo2MdUzFXR9RyUeX9kvQcgYB16cnLu7Ty7HimLSy7p2B81zLPgWFIb5NmziTXWEfPvAgMBAAECggEAD949HYJhZHO2TzgXJc4nnE9MeQ35U3ufJjU+rjRA8IPnjpnUWHWHsmWLn8XJmOKVlYQCM1xCzRF8wwF4uppC/MKAFoxtTtinZbGohOSPDKEscChwdjS57x6haPBdERK2qchTmj5llGWRnOellitVjwJsiPe5TQHUsHFh/2ceJLacp1Q51bb707nsLKlTbi4Lf+P/p/sJcl3rtzGJNOWBtt+pPsxoZIBJJi1SJu95Ryf2aK6hhjbuBuU8HjMfoVGFtJVO4shTYFv2DkogIrseJkR9o9hlN4AdFPsXA4YIc+K8eVVzaFSpYN1oE7nhQYDRvD6HhH9g0Lt8DdzJ9KXQEQKBgQC+mnQWhU3ncYcJ38c/kWL+n0ae015X8GRwFgkUwtUJH1CxkpIOMKIUPqh0Tu5jNhf8XCgACt915ZfMwA8PV24pDK7qs5SakRIoZd3nYfPPbFAlhXDu4Cogsxv5/rCvkub7Oy4TVqv4t9+m+sp5Tw/9B1gjNjyB402nVMTU7zqMAwKBgQC64eVHGhpuDe5Eq9LwU/Ez7yZw/u/ewIbHUaklwofGp1QmL9ZzQDCilcuxgiREUjzXxIhGfgHoE/TJpuEV/cc3Du+Y4qR/oSqgoazS3r3LVUsMzUz62TkM1PXOVaPONGCHSdG9lwT98vtX/A5GGdq5ZvZR8rE+k9Pu2PMaxdSSpQKBgAsBUAKc38qlO27OhOqesmCRQbqZ6bCaKLJwE0YnmbVVIYufMt+u3yzcEU3l4M3JqcjgaU7XUd+0yfcAf94a5jloihDzHXlvNuUuPInHlhQ75MTF16dzOft5W/wrQHhiuwN2f0qOjo9lznwNrvMiJYIukmA2GXhGb41hz5ub1H2RAoGAAna37xgJASpt2bnqLgDtTSH5/8NcpjMjk70f3b+SyquqEFbRHPPbsEkJRm3QzJXI948/vK4smEKrF317ui5+UduAjSNvx774MOXwwVbuaZ/WPXT3btcuSV0FYJMAddd67k2q1jUHe9GYPrCz/3iXyZnx5WKts4V/Zca2bcPt6YECgYB0xkCvNRuB+sVA1IbO0pdNuK4Ce211fQvlZVaDWW+Rs7eXK4LWjwXon/9M993Y1KyV0Fda+kfMn05cPQedMN88vy7YpwGf8nSdefNZtxTluV864AbFIgPAHEKkaJRu+LHlWm+vDVOZa0eSsBMI8eUN9UJM/FvJ2S2wvvnNRuDoqA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnLizIij5pkK5rrIXYn+gVz5JwFncIso3H6yq5/+d3KUPdLpD3OneAPIutSD/huQt069vOvzWxwE+KIqIvVCSJJ9teS4y2f30kmTcodfXUJZpslSxUHJhLtQ4vu/M4ZnTuW+zZ1HPf6wvU6VNtCoJxAdp8wdN5wq1Y4gajhyl9j5MHDRpg6kBz1oawm/dMIcpzEU1eR0UBNcYavTAS1hR93j8NeTBo9cyiDGCBuQPtNXHYDdC9maZhuLEHjBkY6F41uSz3boU01IB5E6zwqqMuN/LPqmHN3xmibdmuWhKxQ+KnFiUygI/BsKu+vf++Qt0DJcl5t1+iymlJ3a6yAD3ZwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://tmefy9.natappfree.cc/order";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://tmefy9.natappfree.cc/order";
    //public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "UTF-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
