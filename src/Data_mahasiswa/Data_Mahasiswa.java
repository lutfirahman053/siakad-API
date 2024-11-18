/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_mahasiswa;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;

/**
 *
 * @author hp
 */
public class Data_Mahasiswa {
public static void main(String[] args) {
        
    HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
            .header("Content-Type", "application/json")
            .header("Cookie", "siakaditm1=vdea4s94ht0q3r931qsvgj762l")
            .body("{\"token\":\"ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49\",\r\n\"query\":\"select * from t_mhs where angkatan = 2023  and deleted = 0 limit 200\"}")
            .asString();

    
       String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if(rows!=0);{
        for (int i = 0; i < results.length(); i++) {
            JSONObject item = results.getJSONObject(i);
            String nama = item.getString("mhs_nama");
            System.out.println(nama);
        }
    }
    }
    
}