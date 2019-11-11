package ken.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ken.app.service.WeChatLogin;
import net.sf.json.JSONObject;
@Controller
public class Login {
	@Autowired
	private WeChatLogin weChatLogin;

	@RequestMapping("weChatLogin")
	@ResponseBody
	public JSONObject weChatLogin(String code){	
		System.out.println("aaaa");
		return weChatLogin.ResolvingWeChatCode(code);
	}
	
	@RequestMapping("weChatLoginTel")
	@ResponseBody
	public JSONObject weChatLoginTel(String encryptedData,String sessionKey,String iv){	
		return weChatLogin.ResolvingWeChatTel(encryptedData, sessionKey, iv);
	}
	
	
}
