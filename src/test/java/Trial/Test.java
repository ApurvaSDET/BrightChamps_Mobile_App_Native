package Trial;

import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.dto.access.UserDetailResult;
import com.ssts.pcloudy.dto.device.MobileDevice;
import com.ssts.pcloudy.dto.file.PDriveFileDTO;
import com.ssts.pcloudy.exception.ConnectError;
import org.apache.commons.lang.StringUtils;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException, ConnectError, InterruptedException {


        Connector con = new Connector("https://device.pcloudy.com");
        String authToken = con.authenticateUser("apurva.kushwaha@brightchamps.com", "t3652ybnsqzp64g59z7qfqkf");

        //PDriveFileDTO uploadedApp = con.uploadApp(authToken, new File("/Users//apurvakushwaha/Desktop/app-arm64-v8a-release.apk"));

        //con.deleteFileFromCloud(authToken, "app-arm64-v8a-release.apk", "data");

        MobileDevice selectedDevice = con.chooseSingleDevice(authToken, "Android");


        //List<MobileDevice> selectedDevices = con.chooseMultipleDevices(authToken, "Android");


    }

}
