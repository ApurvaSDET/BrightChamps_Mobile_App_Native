package pCloudy_APIs;

import Base.BaseUtil;
import org.apache.commons.lang.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class pCloudy_APIs_Utility extends BaseUtil {


    public String _get_token() throws IOException {

        URL url = new URL("https://device.pcloudy.com/api/access");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Authorization", "Basic YXB1cnZhLmt1c2h3YWhhQGJyaWdodGNoYW1wcy5jb206dDM2NTJ5Ym5zcXpwNjRnNTl6N3FmcWtm");

        InputStream inputstream = http.getInputStream();

        Scanner s = new Scanner(inputstream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";


        //Token after Splitting
        String Token = StringUtils.substringBefore(StringUtils.substringAfter(result, "token\":\""), "\"");


        http.disconnect();

        if(http.getResponseCode() == 200)
            return Token;

        else
            return "Something Went Wrong in getting Token from pCloudy";

    }

    public String _get_active_device_list() throws IOException {

        URL url = new URL("https://device.pcloudy.com/api/devices");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");

        String data = "{\n\"token\":\""+_get_token()+"\",\n\"duration\":10, \n\"platform\":\""+Platform+"\", \n\"available_now\":\"true\"\n}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        InputStream inputstream = http.getInputStream();

        Scanner s = new Scanner(inputstream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        http.disconnect();

        if(http.getResponseCode() == 200)
            return result;

        else
            return "Something Went Wrong in getting Response from pCloudy";


    }




}
