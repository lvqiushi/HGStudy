package cn.lv.hgstudy.util;

import cn.lv.hgstudy.enums.EmailTypeEnum;
import cn.lv.hgstudy.model.UserMailInfo;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/10 19:43   
 * @since V1.0
 */
public class SendMailUtil {
	// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
	// PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
	//     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
	private static final String myEmailAccount = "578915614@qq.com";
	//private static final String myEmailAccount = "18360348583@163.com";

	//private static final String myEmailPassword = "A3205468";
	private static final String myEmailPassword = "ylclnsmmuwmybfce";

	// 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
	// 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
	//public static String myEmailSMTPHost = "smtp.exmail.qq.com";
	private static final String myEmailSMTPHost = "smtp.qq.com";

	public static MimeMessage createMimeMessage(Session session, String sendMail, List<UserMailInfo> userList,String title,String content) throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人
		message.setFrom(new InternetAddress(sendMail, "淮工网教平台", "UTF-8"));

		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		for (UserMailInfo user:userList) {
			InternetAddress address = new InternetAddress(user.getUserMailAdress(), user.getUserName(), "UTF-8");
			message.addRecipient(MimeMessage.RecipientType.TO,address);
		}

		//message.setRecipients(MimeMessage.RecipientType.TO, (InternetAddress[])addresses.toArray());

		// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
		message.setSubject(title, "UTF-8");

		// 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
		message.setContent(content, "text/html;charset=UTF-8");

		// 6. 设置发件时间
		message.setSentDate(new Date());

		// 7. 保存设置
		message.saveChanges();

		return message;
	}

	private static Session getMailSession() throws Exception{
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties();                    // 参数配置
		props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址ַ
		props.setProperty("mail.smtp.auth", "true");            // 需要请求认证֤
		props.put("mail.smtp.username", myEmailAccount);
		props.put("mail.smtp.password", myEmailPassword);

		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.put("mail.smtp.ssl.enable", "true");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		props.put("mail.smtp.ssl.socketFactory", sf);
//		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.setProperty("mail.smtp.socketFactory.fallback", "false");
//		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		Session session = Session.getDefaultInstance(props,  new Authenticator() {
			//�����֤
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmailAccount, myEmailPassword);
			}
		});
		session.setDebug(true);
		return session;
	}

	public static void sendMail(Integer type,String content,List<UserMailInfo> userList) throws Exception{

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		//Session session = Session.getDefaultInstance(props);
		Session session = getMailSession();
		MimeMessage message ;
		// 3. 创建一封邮件
		if(EmailTypeEnum.EDIT_PASSWORD.getType().equals(type)) {
			message = createMimeMessage(session, myEmailAccount, userList, EmailTypeEnum.EDIT_PASSWORD.getTitle(), EmailTypeEnum.EDIT_PASSWORD.getContent());
		}
		else {
			message = createMimeMessage(session, myEmailAccount, userList, EmailTypeEnum.PUB_MESSAGE.getTitle(), content);
		}
		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();

		// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		//
		//    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
		//           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
		//           类型到对应邮件服务器的帮助网站上查看具体失败原因。
		//
		//    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
		//           (1) 邮箱没有开启 SMTP 服务;
		//           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
		//           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
		//           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
		//           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
		//
		//    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
		transport.connect(myEmailAccount, myEmailPassword);

		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对
		transport.sendMessage(message, message.getAllRecipients());

		// 7. 关闭连接
		transport.close();
	}

}
