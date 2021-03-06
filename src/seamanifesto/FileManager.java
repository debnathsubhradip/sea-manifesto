/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;

import java.io.File;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author alex
 */
public class FileManager {

//    String jsondata = "{\"name\": \"Sam Smith\", \"technology\": \"Python\"}";
//    String messagetype = "MESSAGE TYPE", messageid = "MESSAGE ID", reportingevent = "REPORTING EVENT", senderid = "SENDERID", jobid = "JOBID", date = "DATE", declaration = "DECLARATION";
//    Form samobj = new Form(jsondata, messagetype, messageid, reportingevent, senderid, jobid, date, declaration);

    public static void main(String[] args) {
        FileManager fm = new FileManager();
        fm.init();
    }

    public void init() {
//        System.out.println(samobj.getFileName());
//        System.out.println(samobj.getData());
//        System.out.println("\n============================================\n");
//        this.exportfile(samobj, null);
    }

    public void exportfile(Form obj, String path) {
        String jsonstring = obj.getData();
//String jsonstring="";
        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        if ((jsonstring != null) && !(jsonstring.isEmpty())) {
            try {
                jsonObject = (JSONObject) jsonParser.parse(jsonstring);
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }

        }
        try {
            
            if (path == null) {
                path = "jsonfiles";
            }
            System.out.println("./" + path + "/" + obj.getFileName() + ".json");
            File file = new File("./" + path + "/" + obj.getFileName() + ".json");
            FileWriter writer = new FileWriter(file);
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();
            System.out.println("File Written");
        } catch (Exception e) {
            System.out.println("Error Occurred");
        }
//    System.out.println(jsonObject.toJSONString());

    }
}
