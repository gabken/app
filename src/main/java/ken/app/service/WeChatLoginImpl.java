package ken.app.service;

import org.springframework.stereotype.Service;

import ken.app.pojo.Status;
import ken.app.utils.AesCbcUtil;
import ken.app.utils.UrlRequest;
import net.sf.json.JSONObject;

@Service
public class WeChatLoginImpl implements WeChatLogin {

	public JSONObject ResolvingWeChatCode(String code) {
		JSONObject answer = new JSONObject();
		String wxspAppid = "wx942a0dab22f5d96b";
		String wxspSecret = "1c4644e6df9c58722ba3d16a0e3feca8";
		String grant_type = "authorization_code";
		String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
				+ grant_type;
		try {
	        String result = UrlRequest.sendGet(params);;
	        if (null != result && result.length() > 0) {
	        	answer.put("status", Status.ok);
	        	answer.put("msg", "初始化openid成功");
	        	answer.put("result", result);
	        }
	    } catch (Exception e) {
	    	answer.put("status", Status.wrong);
	    	answer.put("msg", "初始化openid失败");
	        e.printStackTrace();
	    }

		return answer;
	}

	public JSONObject ResolvingWeChatTel(String encryptedData, String sessionKey, String iv) {
		JSONObject answer = new JSONObject();
		try {
	        String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
	        if (null != result && result.length() > 0) {
	        	answer.put("status", Status.ok);
	        	answer.put("msg", "信息解密成功");
	        	answer.put("result", result);
	        }
	    } catch (Exception e) {
	    	answer.put("status", Status.wrong);
	    	answer.put("msg", "信息解密失败");
	        e.printStackTrace();
	    }
		return answer;
	}

}
