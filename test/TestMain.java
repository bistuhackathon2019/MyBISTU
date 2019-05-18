package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class TestMain 
{
	public static String doPost(String url, Map<String, String> param) {  
        // ����Httpclient����  
        CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpResponse response = null;  
        String resultString = "";  
        try {  
            // ����Http Post����  
            HttpPost httpPost = new HttpPost(url); 
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(60000)
                    .setConnectTimeout(60000)
                    .setConnectionRequestTimeout(60000)
                    .build();
            httpPost.setConfig(requestConfig);
            // ���������б�  
            if (param != null) {  
                List<NameValuePair> paramList = new ArrayList<>();  
                for (String key : param.keySet()) {  
                    paramList.add(new BasicNameValuePair(key, param.get(key)));  
                }  
                // ģ���  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);  
                httpPost.setEntity(entity);  
            }  
            // ִ��http����  
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(resultString);
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                response.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        // System.out.println(resultString);
        return resultString;  
    }  
	public static void main(String[] args) throws FileNotFoundException 
	{
		
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("xh", "2017011402");
//		param.put("password", "2017011402");
//		String str = doPost("https://www.bistu520.cn:8080", param);
//		Data data = JSONObject.parseObject("{\"grade\": [[\"������ƻ���(C����)\", \"4.00\", \"99\", \"5.0\"], [\"��ѧ����ȫ֪ʶ����\", \"4.00\", \"����\", \"1\"], [\"��ѧ��������\", \"4.00\", \"95\", \"2.0\"], [\"��ѧ����(1)\", \"3.00\", \"82\", \"1.0\"], [\"��ѧӢ��(1)\", \"2.00\", \"79\", \"4.0\"], [\"��ѧӢ����˵ʵ���\", \"3.00\", \"88\", \"2.0\"], [\"�ߵ���ѧA(1)\", \"4.00\", \"97\", \"6.0\"], [\"���������\", \"3.00\", \"85\", \"2.0\"], [\"������Դ����\", \"3.00\", \"82\", \"2.0\"], [\"˼����������뷨�ɻ���\", \"4.00\", \"90\", \"3.0\"], [\"���Դ���A\", \"4.00\", \"94\", \"3.0\"], [\"Python���\", \"3.00\", \"83\", \"2.0\"], [\"�������ʵ����C++��\", \"3.00\", \"88\", \"2.0\"], [\"���´�ҵ��ͨʶ�Σ�\", \"4.00\", \"97\", \"3.0\"], [\"�����ݸ���\", \"2.00\", \"76\", \"2.0\"], [\"��ѧ��ְҵ�滮\", \"4.00\", \"96\", \"1.0\"], [\"��ѧ����(2)\", \"3.00\", \"87\", \"1.0\"], [\"��ѧ����A(1)\", \"2.00\", \"71\", \"3.5\"], [\"��ѧӢ��(2)\", \"2.00\", \"75\", \"4.0\"], [\"�ߵ���ѧA(2)\", \"1.00\", \"68\", \"5.0\"], [\"����ѧϰ\", \"3.00\", \"80\", \"2.0\"], [\"��ѵ\", \"4.00\", \"����\", \"2\"], [\"��ɢ��ѧ��1��\", \"3.00\", \"88\", \"4.0\"], [\"���������(C++)\", \"4.00\", \"91\", \"3.5\"], [\"�˻��������\", \"4.00\", \"91\", \"1.0\"], [\"����ʵ��A��1��\", \"3.00\", \"����\", \"2.0\"], [\"����ѧʷ\", \"4.00\", \"98\", \"2.0\"], [\"Ӣ���Ļ����ۣ�Ӣ���ڿΣ���ͨʶ�Σ�\", \"4.00\", \"92\", \"1.5\"], [\"Ӱ����������\", \"3.00\", \"85\", \"1.5\"], [\"Java�������\", \"4.00\", \"97\", \"2.0\"], [\"��ҵ������ͨʶ�Σ�\", \"4.00\", \"93\", \"3.0\"], [\"������ƽ̨����ʵ��\", \"4.00\", \"96\", \"1.5\"], [\"��ѧ������3��\", \"4.00\", \"92\", \"1.0\"], [\"��ѧ����A(2)\", \"4.00\", \"100\", \"3.0\"], [\"��ѧӢ��(3)\", \"3.00\", \"80\", \"4.0\"], [\"������������ͳ��A\", \"4.00\", \"91\", \"3.0\"], [\"�������·����\", \"3.00\", \"84\", \"4.0\"], [\"��������\", \"4.00\", \"98\", \"2.0\"], [\"���˼�������ԭ�����\", \"3.00\", \"84\", \"3.0\"], [\"���ݲɼ�\", \"3.00\", \"88\", \"1.5\"], [\"���ݽṹ��JAVA��\", \"4.00\", \"91\", \"4.5\"], [\"����ʵ��A��2��\", \"3.00\", \"����\", \"1.5\"], [\"���������߿�(1)\", \"3.00\", \"88\", \"1.0\"], [\"�Ƽ��㵼��\", \"4.00\", \"91\", \"2\"], [\"�����Ļ��Ƚ�(ͨʶ��)\", \"4.00\", \"97\", \"2.0\"], [\"רҵ��չ����\", \"3.00\", \"80\", \"1.0\"]], \"credit\": 1, \"GPA\": \"3.30\", \"user_token\": [\"2017011398\", \"mcy200091\"], \"timetable\": [[[], [{\"name\": \"�й����ִ�ʷ��Ҫ\", \"teacher\": \"ʯ��\", \"room\": \"2-2-111(ԭ103)\", \"begin\": \"1\", \"end\": \"11\", \"isDan\": 1, \"length\": 2}], [{\"name\": \"��������ԭ��\", \"teacher\": \"������\", \"room\": \"2-3-������\", \"begin\": \"1\", \"end\": \"9\", \"isDan\": 0, \"length\": 2}, {\"name\": \"��������ԭ��\", \"teacher\": \"������\", \"room\": \"2-3-������\", \"begin\": \"11\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"���������\", \"teacher\": \"���\", \"room\": \"2-1-������\", \"begin\": \"6\", \"end\": \"6\", \"isDan\": 2, \"length\": 2}, {\"name\": \"���������\", \"teacher\": \"���\", \"room\": \"2-1-������\", \"begin\": \"8\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}, {\"name\": \"���������\", \"teacher\": \"���\", \"room\": \"2-1-������\", \"begin\": \"1\", \"end\": \"4\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"��������ԭ��\", \"teacher\": \"������\", \"room\": \"2-3-�߽���\", \"begin\": \"7\", \"end\": \"8\", \"isDan\": 0, \"length\": 2}, {\"name\": \"���������\", \"teacher\": \"���\", \"room\": \"2-1-������\", \"begin\": \"13\", \"end\": \"14\", \"isDan\": 0, \"length\": 2}, {\"name\": \"��������ԭ��\", \"teacher\": \"������\", \"room\": \"2-3-�߽���\", \"begin\": \"1\", \"end\": \"5\", \"isDan\": 0, \"length\": 2}, {\"name\": \"���������\", \"teacher\": \"���\", \"room\": \"2-1-������\", \"begin\": \"16\", \"end\": \"17\", \"isDan\": 0, \"length\": 2}], [], []], [[{\"name\": \"Linuxϵͳʵ��\", \"teacher\": \"·��ǿ\", \"room\": \"2-����-C\", \"begin\": \"1\", \"end\": \"10\", \"isDan\": 0, \"length\": 3}, {\"name\": \"Linuxϵͳʵ��\", \"teacher\": \"·��ǿ\", \"room\": \"2-����-C\", \"begin\": \"11\", \"end\": \"11\", \"isDan\": 1, \"length\": 2}], [{\"name\": \"���ݿ�ԭ����Ӧ��\", \"teacher\": \"�����\", \"room\": \"2-����-C\", \"begin\": \"1\", \"end\": \"12\", \"isDan\": 0, \"length\": 3}, {\"name\": \"���ݿ�ԭ����Ӧ��\", \"teacher\": \"�����\", \"room\": \"2-����-C\", \"begin\": \"13\", \"end\": \"14\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"����ý�������뼼��\", \"teacher\": \"����\", \"room\": \"2-1-һ����\", \"begin\": \"1\", \"end\": \"8\", \"isDan\": 0, \"length\": 3}], [], [], [], []], [[], [{\"name\": \"ƹ����(����4)\", \"teacher\": \"����Ƽ\", \"room\": \"2-�ٳ�2\", \"begin\": \"1\", \"end\": \"16\", \"isDan\": 0, \"length\": 2}], [], [{\"name\": \"�й����ִ�ʷ��Ҫ\", \"teacher\": \"ʯ��\", \"room\": \"2-2-411(ԭ405)\", \"begin\": \"1\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}], [], [], []], [[], [{\"name\": \"���������߿�(2)\", \"teacher\": \"������\", \"room\": \"2-2-411(ԭ405)\", \"begin\": \"3\", \"end\": \"10\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"רҵӢ��\", \"teacher\": \"��ѩ\", \"room\": \"2-3-�����\", \"begin\": \"11\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}, {\"name\": \"רҵӢ��\", \"teacher\": \"��ѩ\", \"room\": \"2-3-�����\", \"begin\": \"1\", \"end\": \"8\", \"isDan\": 0, \"length\": 2}], [\"�㷨��������\", \"רҵ����\", \"���ĵ�8,9��{��1-12��}\", \"���޷�\", \"2-2-411(ԭ405)\", \"2019��06��03��(09:50-11:50)\", \"2-3-������\"], [], [], []], [[], [{\"name\": \"�߼�JAVA�������\", \"teacher\": \"����\", \"room\": \"2-2-407\", \"begin\": \"1\", \"end\": \"8\", \"isDan\": 0, \"length\": 2}], [], [], [], [], []]], \"name\": \"����\", \"major\": \"�������ѧ�뼼��\", \"State_Code\": \"200\"}", Data.class);
//		String[][] arr = data.getGrade();
//		for(int a=0; a < arr.length; a++)
//		{
//			for(int b=0; b < arr[a].length; b++)
//			{
//				System.out.print(arr[a][b]+" ");
//			}
//			System.out.println();
//		}
//		
//		
//		PrintWriter w = new PrintWriter(new File("./test.txt"));
//		w.write(str);
//		w.close();
	}
}
