
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.util.List;

public class CurrencyCheckAPI {

    @Test
    public void coinDeskCurrencyCheck() {
        Response response = CommonUtils.callRestInterfaceGet(CommonUtils.getProperty("bpiendpoint"));
        List<String> BPIs = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.bpi.*.code");
        Assert.assertEquals(BPIs.size(), 3, "Available BPIs should be 3");
        String[] expectedBPIs = {"USD","GBP","EUR"};
        Assert.assertEquals(BPIs.toArray(), expectedBPIs, "Expected BPIs are not same as Actual");
        JsonPath responseJPath = response.jsonPath();
        String gbpDescription = responseJPath.get("bpi.GBP.description");
        Assert.assertEquals(gbpDescription, "British Pound Sterling", "GBP description is not showing as British Pound Sterling");
    }
}
