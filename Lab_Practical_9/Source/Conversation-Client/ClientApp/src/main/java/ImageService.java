import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.input.image.ClarifaiImage;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Naga on 13-03-2017.
 */
@WebServlet(name = "ImageService", urlPatterns = "/ImageService")
public class ImageService extends HttpServlet {
    public static String recognize(String imageUrl) {
        // Provide your Client ID
        String CLIENT_ID = "xWYtMJCOmaQdKArGG_RNR4H-aSIFTbiJOEzdVXk0";
        // Provider Your Client Secret Key
        String CLIENT_SECRET_KEY = "m1hmDizMgcxk-Co4WRP7RaMYoMWkQKRP5HSAXYlF";
        // Defining List Object
        List<String> resultList = new ArrayList<String>();

        if(imageUrl != null) {

            final ClarifaiClient client = new ClarifaiBuilder(CLIENT_ID, CLIENT_SECRET_KEY).buildSync();

            final List<ClarifaiOutput<Concept>> predictionResults =
                    client.getDefaultModels().generalModel() // You can also do client.getModelByID("id") to get custom models
                            .predict()
                            .withInputs(
                                    ClarifaiInput.forImage(ClarifaiImage.of(imageUrl))
                            )
                            .executeSync()
                            .get();

            if (predictionResults != null && predictionResults.size() > 0) {

                // Prediction List Iteration
                for (int i = 0; i < predictionResults.size(); i++) {

                    ClarifaiOutput<Concept> clarifaiOutput = predictionResults.get(i);

                    List<Concept> concepts = clarifaiOutput.data();

                    if(concepts != null && concepts.size() > 0) {
                        for (int j = 0; j < concepts.size(); j++) {

                            resultList.add(concepts.get(j).name());
                        }
                    }
                }
            }

        }
        String annotations="";
        // Iteration of Result
        for(String result : resultList) {

            //System.out.println(result);
            annotations+=result+", ";
        }
        return annotations;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String response="";
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();
        System.out.println(data);
        String output = "";
        JSONObject params = new JSONObject(data);
        JSONObject result = params.getJSONObject("result");
        JSONObject parameters = result.getJSONObject("parameters");
        if (parameters.get("climate").toString().equals("climate change pictures")) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("http://i.huffpost.com/gen/1378315/images/o-CLIMATE-CHANGE-facebook.jpg");
            jsonArray.put("https://www.wwf.org.uk/sites/default/files/styles/square_xs/public/2016-09/Large_WW210255.jpg?itok=Hc7876O8");
            jsonArray.put("https://www.canada.ca/content/dam/themes/environment/images/weather/climate-change/20170301-1.jpg");
            jsonArray.put("http://fivestaradk.com/wp-content/uploads/2011/08/Peak-in-middle-of-a-storm.jpg");
            jsonArray.put("https://files.foreignaffairs.com/styles/large-crop-landscape/s3/taxonomy-images/topic-climate-change.jpg?itok=sGWYdI33");
            jsonArray.put("http://socialistparty.ie/wp-content/uploads/2016/09/Climate-chang-e.jpg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "climate change pictures are displayed");
            js.put("displayText", "climate change pictures are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("climate").toString().equals("acid rain")) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("http://www.isustainableearth.com/wp-content/uploads/2015/10/acid-rain-facts.jpg");
            jsonArray.put("http://thephotographersgallery.org.uk/images/Acid_Pollution_in_the_streets_of_Mandoli__India__2006_4fd317cda3c19.jpg");
            jsonArray.put("https://joshthedad.files.wordpress.com/2016/08/wp-1472066407467.jpg");
            jsonArray.put("http://www.protectadks.org/wp-content/uploads/2012/10/Irene-d.gif");
            jsonArray.put("https://aos.iacpublishinglabs.com/question/aq/700px-394px/countries-affected-acid-rain_c1e3dfa94375b3f8.jpg?domain=cx.aos.ask.com");
            jsonArray.put("http://fivestaradk.com/wp-content/uploads/2011/08/Peak-in-middle-of-a-storm.jpg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "acid rain pictures are displayed");
            js.put("displayText", "acid rain pictures are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("climate").toString().equals("ice sheet melting")){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("http://i.huffpost.com/gen/1378315/images/o-CLIMATE-CHANGE-facebook.jpg");
            jsonArray.put("http://images.sciencetimes.com/data/images/full/3124/climate-change.jpg");
            jsonArray.put("http://s.newsweek.com/sites/www.newsweek.com/files/2014/08/26/melting-ice-climate-change-reaching-irreversible-levels.jpg");
            jsonArray.put("https://cdn.theconversation.com/files/115014/width926/image-20160314-11267-w4g81t.jpg");
            jsonArray.put("http://www.environmental-auditing.org/Portals/0/climate%20change%20ice%20berg_web.jpg");
            jsonArray.put("https://svs.gsfc.nasa.gov/vis/a010000/a010900/a010982/still3_columbia_icebergs_2008_1080.jpg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "ice sheet melting pictures are displayed");
            js.put("displayText", "ice sheet melting pictures are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("climate").toString().equals("warming oceans")){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("http://www.oeschger.unibe.ch/unibe/portal/fak_naturwis/g_dept_kzen/d_c_oeschger/content/e65551/e387548/Eisberg_1_eng.jpeg");
            jsonArray.put("http://s3.reutersmedia.net/resources/r/?m=02&d=20160801&t=2&i=1147908926&w=780&fh=&fw=&ll=&pl=&sq=&r=LYNXNPEC701L5");
            jsonArray.put("http://www.climatechangenews.com/files/2014/11/hot-weather-578x337.jpg");
            jsonArray.put("http://c8.alamy.com/comp/BMNCPY/coral-reef-damage-due-to-global-warming-fiji-pacific-ocean-BMNCPY.jpg");
            jsonArray.put("http://resize.indiatvnews.com/en/centered/newbucket/750_533/2016/09/global-warming-threatens-to-turns-oceans-into-major-carbon-emitters-445805-2-1473661671.jpg");
            jsonArray.put("https://www.peacepalacelibrary.nl/wp-content/uploads/2016/04/blogcoralbleachwwf.jpg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "warming ocean pictures are displayed");
            js.put("displayText", "warming ocean pictures are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("climate").toString().equals("clarifai api")){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("https://assets.rbl.ms/6472563/980x.jpg");
            jsonArray.put("http://www.thisisclimatechange.org/wp-content/uploads/2012/09/AP-police-officer-and-drought-texas1.jpg");
            jsonArray.put("http://www.oeschger.unibe.ch/unibe/portal/fak_naturwis/g_dept_kzen/d_c_oeschger/content/e65551/e387548/Eisberg_1_eng.jpeg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "redirecting to clarifai api page");
            js.put("displayText", "redirecting to clarifai api page");
            js.put("source", "image database");
            response = js.toString();
        }

        else if (parameters.get("null").toString().equals("clear")){
            Data data_ob = Data.getInstance();
            JSONObject js1 = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(" ");
            js1.put("data", jsonArray);
            data_ob.setData(js1.toString());
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "screen is cleared");
            js.put("displayText", "screen is cleared");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("image").toString().equals("one")){
            Data data_ob = Data.getInstance();
            JSONObject js1 = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("https://assets.rbl.ms/6472563/980x.jpg");
            jsonArray.put("http://www.thisisclimatechange.org/wp-content/uploads/2012/09/AP-police-officer-and-drought-texas1.jpg");
            jsonArray.put("http://www.oeschger.unibe.ch/unibe/portal/fak_naturwis/g_dept_kzen/d_c_oeschger/content/e65551/e387548/Eisberg_1_eng.jpeg");
            js1.put("data", jsonArray);
            data_ob.setData(js1.toString());
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            String imageUrl = "https://assets.rbl.ms/6472563/980x.jpg";
            String words=recognize(imageUrl);
            js.put("speech", "From image one we can see "+words );
            js.put("displayText", "From image one we can see "+words );
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("image").toString().equals("two")){
            Data data_ob = Data.getInstance();
            JSONObject js1 = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("https://assets.rbl.ms/6472563/980x.jpg");
            jsonArray.put("http://www.thisisclimatechange.org/wp-content/uploads/2012/09/AP-police-officer-and-drought-texas1.jpg");
            jsonArray.put("http://www.oeschger.unibe.ch/unibe/portal/fak_naturwis/g_dept_kzen/d_c_oeschger/content/e65551/e387548/Eisberg_1_eng.jpeg");
            js1.put("data", jsonArray);
            data_ob.setData(js1.toString());
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            String imageUrl = "http://www.thisisclimatechange.org/wp-content/uploads/2012/09/AP-police-officer-and-drought-texas1.jpg";
            String words=recognize(imageUrl);
            js.put("speech", "From image two we can see "+words );
            js.put("displayText", "From image two we can see "+words );
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("image").toString().equals("three")){
            Data data_ob = Data.getInstance();
            JSONObject js1 = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("https://assets.rbl.ms/6472563/980x.jpg");
            jsonArray.put("http://www.thisisclimatechange.org/wp-content/uploads/2012/09/AP-police-officer-and-drought-texas1.jpg");
            jsonArray.put("http://www.oeschger.unibe.ch/unibe/portal/fak_naturwis/g_dept_kzen/d_c_oeschger/content/e65551/e387548/Eisberg_1_eng.jpeg");
            js1.put("data", jsonArray);
            data_ob.setData(js1.toString());
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            String imageUrl = "http://www.oeschger.unibe.ch/unibe/portal/fak_naturwis/g_dept_kzen/d_c_oeschger/content/e65551/e387548/Eisberg_1_eng.jpeg";
            String words=recognize(imageUrl);
            js.put("speech","From image three we can see "+words );
            js.put("displayText", "From image three we can see "+words);
            js.put("source", "image database");
            response = js.toString();
        }
        resp.setHeader("Content-type", "application/json");
        resp.getWriter().write(response);
    }
}

