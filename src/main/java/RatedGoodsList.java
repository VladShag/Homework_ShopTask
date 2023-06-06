import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RatedGoodsList {
    private ArrayList<RatedGood> pricelist = new ArrayList<>();

    public RatedGoodsList(String filename) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filename));
        JSONArray array = (JSONArray) parser.parse(new FileReader(filename));
        for (Object o : array) {
            JSONObject jsonObject = (JSONObject) o;
            this.pricelist.add(new RatedGood((String) jsonObject.get("name"), Integer.parseInt((String) jsonObject.get("price")), Double.parseDouble((String) jsonObject.get("rate"))));
        }


    }

    public ArrayList<RatedGood> getPricelist() {
        return pricelist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pricelist.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(pricelist.get(i));
            sb.append("\n");

        }
        return sb.toString();
    }
}
