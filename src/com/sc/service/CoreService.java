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
 * ���ķ�����
 * @author ʩ����
 *
 */
public class CoreService {

	 /** 
     * ����΢�ŷ��������� 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // Ĭ�Ϸ��ص��ı���Ϣ����  
            String respContent = "�������쳣�����Ժ��ԣ�";  
  
            // xml�������  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // ���ͷ��ʺţ�open_id��  
            String fromUserName = requestMap.get("FromUserName");  
            // �����ʺ�  
            String toUserName = requestMap.get("ToUserName");  
            // ��Ϣ����  
            String msgType = requestMap.get("MsgType");  
  
            String content = requestMap.get("Content");
//            respContent=content;
          /*  Xuezi xuezi =new Xuezi();
            System.out.println("1111");
            System.out.println(content);
            if(content.startsWith("��ѯ+")){
            	String studentId = content.substring(3);
            	xuezi = QueryXuezi.QueryById(studentId);
            	
            }
            */
            
            List<Kaoshi> kaoshi=new ArrayList<Kaoshi>();
            StringBuffer sb =new StringBuffer();
            if(content.startsWith("����ѯ+")) {
            	String major =content.substring(5);
            	kaoshi =KaoshiImpl.QueryKaoshi(major);
            	if(!kaoshi.isEmpty()) {
            	sb.append("��Ĳ�ѯ�������:\n");
            	for(int i=0;i<kaoshi.size();i++) {
            		Kaoshi k=kaoshi.get(i);
            		sb.append("\n\n����").append(k.getDirection()).append("\n��Ŀ��").append(k.getCourse()).append("\nʱ�䣺").append(k.getTime())
            		.append("\n������").append(k.getPlace());
            	}
            	}else {
            		sb.append("�������רҵ������~~\n\n").append("��ȷ��ʽΪ��\n")
            		.append("����ѯ+2013��ҽѧ#������\n\n").append("����ѯ+2015�ٴ�ҽѧ\n\n")
            		.append("����ѯ+2015����ѧ#��\n\n")
            		.append("����ѯ+2016��ҽѧ#��˶����\n\n").append("����ѯ+2017���г�Ӫ��#ר����\n\n")
            		.append("����ѯ+2017�ٴ�ҽѧ#����\n\n").append("����ѯ+2017�ٴ�ҽѧ#����\n\n")
            		.append("����������~~");
            		
            	}
            }
//            System.out.println(sb.toString());
            
            // �ظ��ı���Ϣ  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
  
            // �ı���Ϣ  
          /* if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                respContent = "�����͵����ı���Ϣ��";  
            }  
            // ͼƬ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "�����͵���ͼƬ��Ϣ��";  
            }  
            // ����λ����Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "�����͵��ǵ���λ����Ϣ��";  
            }  
            // ������Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "�����͵���������Ϣ��";  
            }  
            // ��Ƶ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "�����͵�����Ƶ��Ϣ��";  
            }  
            // �¼�����  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // �¼�����  
                String eventType = requestMap.get("Event");  
                // ����  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "лл���Ĺ�ע��";  
                }  
                // ȡ������  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ  
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
