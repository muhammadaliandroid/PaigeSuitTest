package uk.co.mali.pagesuitetest.network.apis;

import retrofit2.http.GET;
import rx.Observable;
import uk.co.mali.pagesuitetest.model.pojos.Data;
import uk.co.mali.pagesuitetest.network.constants.Constants;

/**
 * Created by alig2 on 23/06/2017.
 */

public interface RestApi {

    @GET(Constants.URL_BUSINESS_PAGE)
    Observable<Data> getRestApiData();


}
