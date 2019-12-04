package com.qf.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600696494";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCXbJhL6ZD/pwi7qubbE/q/h8JcEzl4F9BbnpeCZYOu9W2C+/k/gfxfD6DsJLKG7c47LlloX0o3X4vfj6AInW8Wzi46q5PH2Ot0FvpzfsR2QogIZu1JVBES2RgLdJ5mQ2n5E7vR8zObC1LkJKplkiMvNJ/micESTmKNTNn+k7RY1SA6s1q0gb01J2+mUJSbadxa8UnHgZvGruXs25cFpktrE+l6J37Jz91unWhhToDYwlimAyMOWf8IJw/5A7KjTtvfklDOZvMWL6pN2Z6KeEbgd6hZOwgYSijGWGBDaHd0wVSwpEYS/k+sX/EuVKPj7IH8ZXrREOhgDOxh3r0y+w8tAgMBAAECggEAKWp9WT3/97yy6cl7rO4RBjPWmCJ19H/m8Dg3TmX/l2nvUwUiDhm6cjGvHQeIgNkoMA2kTKTLgsuyUSpSZijRSpaIFGn7WIzfEXh7df11NLdLx6iHPCgvJ02TgwaZkHTd1k9sbqcrNTvqpxXUOUW4M+Ab4A1Lbntb/zPG6Bd0G1t6ynOXuS1mvgX4Ji1MAXTd4rt7YZHqneaNeqSo3RkZQ4CZ7OK49yfZUff8dgEazc9umEYfJ+jbRs240laJBo7ywfN4exsdCtlS4MFpG4QlkhElu5+cIrPnb4rV+T//nN9zfo3hYqZHmbn6Wa864WO17RrRtx11gaJTs41p4nzrIQKBgQDjd2fgowYe9e9WHC0r63LbXvuV/jMcG5RjIg1GjDt8CcXx4B1MGRWhwRlxQwa0rXKmcFh49P6/HEN+B6PVfnkYtpbf/v4XyRu6DW/mu+qTNtQ/jFmmF3EwcE4ILFKEh9yhMxi5P7LFF/oXB+oNauD+0+SauZwhVgRMej6u5qF16QKBgQCqa0G79ASUwgBFIBcRIS2OHzr7OQrqNnKuTku6sONUE8yu0Kh/svyUSMSOMMgQgitfNVtEJC6Lk50UsPVyCzpuA4vokYwEIhIDrHM7SRZOKMrmthidHGV8a+M4FWag3UhTQpIMlQgSJErUfCt7qDzWQIAXqauGV3UTRjnK3H+QpQKBgBjKv+is/BLNzVs+UPIThH5CePtdLGbo3qB7aqUAzc70Jb36JldP+JqbuFEu9AEnUnKvlgUA9u8Pfo+y93ligoJeDE23tiwTgFEj+8lTO/r1o+aVPoQq0+xqoSak5g2J3VM4hX5TYgG3Xku6UhlKR+GeaLEwf8LmZCuNu11Gx9xZAoGAaf7QIdECUGvhsxzke/kA1pbCHqM6ELbQ2W1FWNbQbejqtAh/5P00cB5acn4Q0YPE6jDLlTRT5uhnGQl/f/FP5EE8ceilB6URQ0utWEB7KR3iJWE5Ke8RiDOqXaWh8YfwhiivojfHj1EXYdXhTcY0IKZ5hT44uxQGc3iIVY6ToSkCgYBcqXREE+15chldpHNtcrxe/stPOrPr6/znVb2IqlFP/H7CObLL/FHzhDnCrFed1Urb3Gjk4eipycAqAnYYoB5ZYknBGUh61JUusTSnq07x2gWP5uZrGT5vJniiyO6/syKUxn0fSaKRC50Cgrn3qsawE4qSfuEPFK7zn6jtfD5weA==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl2yYS+mQ/6cIu6rm2xP6v4fCXBM5eBfQW56XgmWDrvVtgvv5P4H8Xw+g7CSyhu3OOy5ZaF9KN1+L34+gCJ1vFs4uOquTx9jrdBb6c37EdkKICGbtSVQREtkYC3SeZkNp+RO70fMzmwtS5CSqZZIjLzSf5onBEk5ijUzZ/pO0WNUgOrNatIG9NSdvplCUm2ncWvFJx4Gbxq7l7NuXBaZLaxPpeid+yc/dbp1oYU6A2MJYpgMjDln/CCcP+QOyo07b35JQzmbzFi+qTdmeinhG4HeoWTsIGEooxlhgQ2h3dMFUsKRGEv5PrF/xLlSj4+yB/GV60RDoYAzsYd69MvsPLQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8081/#/person";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

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