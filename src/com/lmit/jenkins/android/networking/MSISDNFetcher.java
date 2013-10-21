package com.lmit.jenkins.android.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.lmit.jenkins.android.configuration.Configuration;
import com.lmit.jenkins.android.logger.Logger;

public class MSISDNFetcher {

  public void getMSISDN(Context ctx) {

    String result = null;

    Logger.getInstance().debug("Getting MSISDN");
    try {
      result = requestMyNumber();
    } catch (Exception e) {
      Logger.getInstance().error("Error during MSISDN fetching ", e);
      result = "no-msisdn-supplied";
    }

    Logger.getInstance().debug("MSISDN=" + result);
    Configuration.getInstance().setMsisdn(result);
    Configuration.getInstance().save();
  }

  private String requestMyNumber() throws ClientProtocolException, IOException {

    String result = "no-msisdn-supplied";

//    String url = "http://smhs.sp.vodafone.com/headers";
//
//    DefaultHttpClient client = new DefaultHttpClient();
//    client.getCredentialsProvider().setCredentials(
//        new AuthScope("smhs.sp.vodafone.com", 80),
//        new UsernamePasswordCredentials("headers", "headers"));
//    HttpGet get = new HttpGet(url);
//    HttpResponse response = client.execute(get);
//
//    InputStream in = response.getEntity().getContent();
//
//    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//    String line = null;
//    StringBuffer htmlBuffer = new StringBuffer();
//    while ((line = reader.readLine()) != null) {
//      htmlBuffer.append(line);
//    }
//
//    Document html = Jsoup.parse(htmlBuffer.toString());
//    Elements elems = html.getElementsByTag("td");
//    for (int i = 0; i < elems.size(); i++) {
//      Element e = elems.get(i);
//      if (e.text().contains("x-sdp-msisdn")) {
//        Logger.getInstance().debug("Found x-sdp-msisdn tag");
//        i++;
//        result = elems.get(i).text();
//        break;
//      }
//    }

    return result;
  }
}
