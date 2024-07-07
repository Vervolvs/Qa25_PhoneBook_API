package okhttp;

import com.google.gson.Gson;
import dto.ContactDTO;
import dto.ErrorDTO;
import dto.GetAllContactsDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;

public class GetAllContactsTestsOkttp {


   String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibWFyYUBnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTcyMDk3ODQ2NCwiaWF0IjoxNzIwMzc4NDY0fQ.yhWWbSRPgl6oIx2chzbx-EwYmJHGmhBgIFCqkmBevKU" ;
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

@Test
    public void getAllContactsSuccess() throws IOException {

    Request request = new Request.Builder()
            .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
            .get()
            .addHeader("Authorization",token)
            .build();

  Response response = client.newCall(request).execute();
    Assert.assertTrue(response.isSuccessful());
    Assert.assertEquals(response.code(),200);
    GetAllContactsDTO contactsDTO = gson.fromJson(response.body().string(), GetAllContactsDTO.class);
    List<ContactDTO> contacts =contactsDTO.getContacts();
    for (ContactDTO c:contacts){
        System.out.println(c.getId());
        System.out.println(c.getEmail());
        System.out.println("====================================");
    }

}


    @Test
    public void getAllContactsWrongToken() throws IOException {

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                .get()
                .addHeader("Authorization","sfdgr5557")
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertFalse(response.isSuccessful());
        Assert.assertEquals(response.code(),401);
        ErrorDTO errorDTO = gson.fromJson(response.body().string(),ErrorDTO.class);
        Assert.assertEquals(errorDTO.getError(),"Unauthorized");

    }




}
