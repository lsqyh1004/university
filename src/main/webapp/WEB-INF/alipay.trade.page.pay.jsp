<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>付款</title>
</head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%--<%@ page import="com.alipay.config.*"%>--%>
<%@ page import="com.alipay.api.*"%>
<%@ page import="com.alipay.api.request.*"%>
<%--<%@ page import="com.qf.bean.AlipayConfig" %>--%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.qf.pojo.AlipayConfig" %>
<%
    //获得初始化的AlipayClient
    AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

    //设置请求参数
    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
    alipayRequest.setReturnUrl(AlipayConfig.return_url);
    alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

    //商户订单号，商户网站订单系统中唯一订单号，必填
    //new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
    //生成三个随机数
    String s="";
    for (int i=1;i<=6;i++){
        int a=(int)Math.floor(Math.random()*10+1);
        s=a+s;
    }
    //根据时间生成订单号
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    String strDate = simpleDateFormat.format(new Date());
    s=strDate+s;
    session.setAttribute("s",s);
    String out_trade_no = s;


    //付款金额，必填
    //new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
    //Double goodsPrice = (Double)session.getAttribute("goodsPrice");
    Double total_amount = 100000.00;
    //订单名称，必填
    //new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
    //String goodsName = (String)session.getAttribute("goodsName");
    String subject = "会员购买";
    //商品描述，可空
    //new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
    String body = "买货";

    alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
            + "\"total_amount\":\""+ total_amount +"\","
            + "\"subject\":\""+ subject +"\","
            + "\"body\":\""+ body +"\","
            + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

    //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
    //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
    //		+ "\"total_amount\":\""+ total_amount +"\","
    //		+ "\"subject\":\""+ subject +"\","
    //		+ "\"body\":\""+ body +"\","
    //		+ "\"timeout_express\":\"10m\","
    //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
    //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

    //请求
    String result = alipayClient.pageExecute(alipayRequest).getBody();

    //输出
    out.println(result);
%>
<body>
</body>
</html>