package me.chanjar.weixin.mp.util.http.okhttp;

import me.chanjar.weixin.common.bean.result.WxError;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestHttp;
import me.chanjar.weixin.common.util.http.okhttp.OkHttpProxyInfo;
import me.chanjar.weixin.mp.bean.material.WxMediaImgUploadResult;
import me.chanjar.weixin.mp.util.http.MediaImgUploadRequestExecutor;
import okhttp3.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class OkhttpMediaImgUploadRequestExecutor extends MediaImgUploadRequestExecutor<OkHttpClient, OkHttpProxyInfo> {

  public OkhttpMediaImgUploadRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public WxMediaImgUploadResult execute(String uri, File data) throws WxErrorException, IOException {

    //得到httpClient
    OkHttpClient client = requestHttp.getRequestHttpClient();

    RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), data);
    RequestBody body = new MultipartBody.Builder().addFormDataPart("media", null, fileBody).build();
    Request request = new Request.Builder().url(uri).post(body).build();

    Response response = client.newCall(request).execute();
    String responseContent = response.body().string();
    WxError error = WxError.fromJson(responseContent);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    }

    return WxMediaImgUploadResult.fromJson(responseContent);
  }
}
