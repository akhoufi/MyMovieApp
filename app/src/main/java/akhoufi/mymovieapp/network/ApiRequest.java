package akhoufi.mymovieapp.network;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by akhou on 16/12/2015.
 */
public class ApiRequest extends JsonObjectRequest {


    public ApiRequest(int method, String url, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }


}
