package com.example.admin.quickmaths;

import com.example.admin.quickmaths.utils.SignedRequestsHelper;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/*
 * This class shows how to make a simple authenticated call to the
 * Amazon Product Advertising API.
 *
 * See the README.html that came with this sample for instructions on
 * configuring and running the sample.
 */
public class AmazonItemSearch {

    /*
     * Your Access Key ID, as taken from the Your Account page.
     */
    private static final String ACCESS_KEY_ID = "AKIAJS3W7HDOJLZ7XYTQ";

    /*
     * Your Secret Key corresponding to the above ID, as taken from the
     * Your Account page.
     */
    private static final String SECRET_KEY = "r+5MFsqqibtppRBe9ZMfg7OUm0C+JmFbW8uh12j3";

    /*
     * Use the end-point according to the region you are interested in.
     */
    private static final String ENDPOINT = "webservices.amazon.com";

    public static void main(String[] args) {

        /*
         * Set up the signed requests helper.
         */
        SignedRequestsHelper helper;

        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, ACCESS_KEY_ID, SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String requestUrl = null;

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", "AKIAIPMMFX7EQOUDNL5A");
        params.put("AssociateTag", "myers831-20 ");
        params.put("SearchIndex", "All");
        params.put("Keywords", "coke");
        params.put("ResponseGroup", "Images,ItemAttributes,Offers");

        requestUrl = helper.sign(params);

        System.out.println("Signed URL: \"" + requestUrl + "\"");

        fetchTitle(requestUrl);

    }

    private static String fetchTitle(String requestUrl) {
        String title = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);

            NodeList list = doc.getElementsByTagName("Item");

            for(int i = 0; i < list.getLength(); i++){
                System.out.println(i);
                Node lItem2 = doc.getElementsByTagName("FormattedPrice").item(i);
                System.out.println("Price: " + lItem2.getTextContent());
                Node titleNode = doc.getElementsByTagName("Title").item(i);
                System.out.println("Signed Title is \"" + titleNode.getTextContent() + "\"");
                System.out.println("");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return title;
    }
}
