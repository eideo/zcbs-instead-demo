package com.zcbspay.platform.demo.constant;

public class Constants {

    private Constants() {
    }

    /**
     * 编码常量
     * @author: zhangshd
     * @date:   2017年6月5日 上午9:11:23   
     * @version :v1.0
     */
    public static class Encoding {
        public static final String UTF_8 = "UTF-8";
        private Encoding() {
        }
    }
    
    /**
     * 公钥私钥常量
     * @author: zhangshd
     * @date:   2017年6月5日 上午9:11:07   
     * @version :v1.0
     */
    public static class RsaKey {
    	
    	//平台公钥
    	public static final String localPubKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDA9jmU2olTAgRXQhtFK1YvazJV6ngHVXCcLCLbF0PN+cjaUF/srn470igCd9Kc3TSvaMBRVNce8H+uFhk7aGeRbUuE/tDNGfu8zjnzD91J0tJ4oGQpXocJU3QWvyZbyPO4LBsXZzMBTqS+ZzGj0U6tfqk+IfV/XbYbpCpzwwSuyQIDAQAB";//平台公钥
    	//合作机构公钥
    	public static final String memberPubKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCHGBEJkFWHR4curkx7rzOopnK1CaCjUxmw86x4Fb4soNvNynHN1jAY6+0I0AVWNUCulhCpqT2OQYrb8sZLMLTTzJxFxyOidLRJqQcMfd93oJQSvbryhzcDklV0t1Fto4G7/vEl9JGofYB3tiUpeMXStesPJgHV2VT6SXpTQq8shwIDAQAB";//合作机构公钥
    	//合作机构私钥
    	public static final String memberPriKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIcYEQmQVYdHhy6uTHuvM6imcrUJoKNTGbDzrHgVviyg283Kcc3WMBjr7QjQBVY1QK6WEKmpPY5BitvyxkswtNPMnEXHI6J0tEmpBwx933eglBK9uvKHNwOSVXS3UW2jgbv+8SX0kah9gHe2JSl4xdK16w8mAdXZVPpJelNCryyHAgMBAAECgYAr6i7fpQOojh/rlM1YB4QLdtAi+ZY2gXUAiLWv86F2cHQDWaPU/aN09nx/OOADPhxgpHeWL2XLMJMrHKhJGPQuy/s3Zzs3nNb4MZ38JL0Zp5WwLZlGQiTZpQJx3hxWAZeZUgJmlS5dj7Ip9YBbUwLaozrMDZ0qbE06FNntmiR2AQJBAM1tA0urfOY0smtxpuzVb+raJZvxrffm2/0H7z0pT6S43mvMrUtXs+PvHjcjDwbA+oRCq6mTPoRSSbG+kOhT0WcCQQCoWmHjW1IpScrbQyJu/lJAjI4Ei2iRfJ5Iu4KWJxs7eQpy/VaioUO9baonsT8IAcvpfkqVOC4MuSsKRloxYTfhAkB3YKNqpPSHPxZ0U+6icQKB41W5wv/LMXCkIalIzKoI2pn+4UnPn97dVcckWY5Q6XJry+bAO943vS4wScMiEBt/AkBmUaBCxSLXUzEGN/Q6jzlAX+yEmJHyMlIlFEmWpqfnanZOUuiPqQF5pKgQvan4XNcozwfXTzC1rOiasw1oC5UhAkEAp4Jfwwe0WVNpFkPQk6Y8bQh41/XVVB5BP/tDkx8znoru7BRQKo/ZHQ2xzigYEZZj0p2klJcsDk4YlA9Q+EQAkQ==";//合作机构私钥

    	private RsaKey() {
        }
    }
    
    /**
     * 合作机构信息
     * @author: zhangshd
     * @date:   2017年6月5日 上午9:11:32   
     * @version :v1.0
     */
    public static class MemberInfo{
    	//合作机构号
    	public static final String merid="200000000001588";
    	
    	private MemberInfo(){}
    }
    /**
     * 请求地址
     * @author: zhangshd
     * @date:   2017年6月5日 上午9:11:43   
     * @version :v1.0
     */
    public static class ApiUrl{
    	//实时业务网址
    	public static final String realtimeUrl ="http://192.168.2.17/instead-realtime/realtime/payAndCollectApi";
    	
    	//批量业务网址
    	public static final String batchUrl ="http://192.168.2.17/instead-batch/batch/payAndCollectApi";
    	
    	private ApiUrl(){}
    }
    /**
     * 附加信息
     * @author: zhangshd
     * @date:   2017年6月5日 上午9:12:06   
     * @version :v1.0
     */
    public static class AdditInfo{
    	public static final String accessType="1";
    	public static final String encryMethod="01";
    	private AdditInfo(){}
    }
    
}
