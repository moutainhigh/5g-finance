package cn.fate.ssm.commons;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 百度文字识别
 *
 * @author fate
 * @date 2019-06-16 10:44
 */
public class BaiduOcr {
    /**
     * 获取权限token
     * @return 返回示例：
     * {
     * "access_token": "24.c9303e47f0729c40f2bc2be6f8f3d589.2592000.1530936208.282335-
    1234567",
     * "expires_in":2592000
     * }
     */
    public static String getAuth() {
// 官网获取的 API Key
        String clientId = "ZZctB5izVbFPNgV75Ffwi7Oe";
// 官网获取的 Secret Key
        String clientSecret = "EQGhbR5GHGIRfmsON0GN90K8QnAOv8OR";
        return getAuth(clientId, clientSecret);
    }
    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云的 API Key
     * @param sk - 百度云的 Securet Key
     * @return assess_token 示例：
     * "24.c9303e47f0729c40f2bc2be6f8f3d589.2592000.1530936208.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
     // 1. grant_type为固定参数
                + "grant_type=client_credentials"
// 2. 官网获取的 API Key
                + "&client_id=" + ak
// 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
// 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
// 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
// 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String accessToken = jsonObject.getString("access_token");
            return accessToken;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

}
