package org.storm.uset.http;


import java.net.InetAddress;


public class HttpTest {
public static void main(String[] args) throws Exception {
	
	 HttpRequester request = new HttpRequester();  
	    String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println(ip);
//	 Map<String,String> map = new HashMap<String,String>();
//	 map.put("userid", userid);
//	 map.put("password", upassword);
	HttpRespons respons   =request.sendPost("http://twxks-api.dinp.91baofeng.com");
	String jsonStr =  respons.getContent();
	System.out.println(jsonStr);
	
//	List<String> listString = JSON.parseArray(jsonStr, String.class);  
//	System.out.println(jsonStr);
//
//	List<Map<String, Object>> listMap =    JSON.parseObject(jsonStr, new TypeReference<List<Map<String,Object>>>(){});
//	System.out.println(listMap.get(0).get("id"));
	
}
}
