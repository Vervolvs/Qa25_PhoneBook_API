package okhttp;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteContactByidOkhttp {


    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibWFyYUBnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTcyMDk3ODQ2NCwiaWF0IjoxNzIwMzc4NDY0fQ.yhWWbSRPgl6oIx2chzbx-EwYmJHGmhBgIFCqkmBevKU" ;
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();


    @Test

    public void deleteContactsByIdSuccess() throws IOException {

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/80c083e9-7c1d-42ee-aed6-3aecfc56ac51")
                .delete()
                .addHeader("Authorization", token)
                .build();

        client.newCall(request).execute();
        Assert.assertEquals(200),200;


    }






}
