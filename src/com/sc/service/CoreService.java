package com.sc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sc.db.Kaoshi;
import com.sc.db.KaoshiImpl;

import com.sc.message.resp.TextMessage;
import com.sc.util.MessageUtil;  

/**
 * 核心服务类
 * @author 施冲冲冲
 *
 */
public class CoreService {

	 /** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            String content = requestMap.get("Content");
//            respContent=content;
          /*  Xuezi xuezi =new Xuezi();
            System.out.println("1111");
            System.out.println(content);
            if(content.startsWith("查询+")){
            	String studentId = content.substring(3);
            	xuezi = QueryXuezi.QueryById(studentId);
            	
            }
            */
            
            List<Kaoshi> kaoshi=new ArrayList<Kaoshi>();
            StringBuffer sb =new StringBuffer();
            if(content.startsWith("点点查询+")) {
            	String major =content.substring(5);
            	kaoshi =KaoshiImpl.QueryKaoshi(major);
            	if(!kaoshi.isEmpty()) {
            	sb.append("你的查询结果如下:\n");
            	for(int i=0;i<kaoshi.size();i++) {
            		Kaoshi k=kaoshi.get(i);
            		sb.append("\n\n方向：").append(k.getDirection()).append("\n科目：").append(k.getCourse()).append("\n时间：").append(k.getTime())
            		.append("\n考场：").append(k.getPlace());
            	}
            	}else {
            		sb.append("您输入的专业有误噢~~\n\n").append("正确格式为：\n")
            		.append("点点查询+2013中医学#七年制\n\n").append("点点查询+2015临床医学\n\n")
            		.append("点点查询+2015护理学#滨\n\n")
            		.append("点点查询+2016中医学#本硕连读\n\n").append("点点查询+2017滨市场营销#专升本\n\n")
            		.append("点点查询+2017临床医学#二临\n\n").append("点点查询+2017临床医学#四临\n\n")
            		.append("请重新输入~~");
            		
            	}
            }
//            System.out.println(sb.toString());
            
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
  
            // 文本消息  
          /* if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                respContent = "您发送的是文本消息！";  
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "谢谢您的关注！";  
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                }  
            }  */
  
//            textMessage.setContent(respContent);
            textMessage.setContent(sb.toString());
//            textMessage.setContent(xuezi.toString()); 
            respMessage = MessageUtil.textMessageToXml(textMessage);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
}
