package uk.co.mali.pagesuitetest.utils.ui;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;


/**
 * Created by alig2 on 26/06/2017.
 */

public class UIUtils {

    private static final String TAG= UIUtils.class.getSimpleName();

public static void showSnackBar(View view, String message, int length){
    Snackbar.make(view, message, length).setAction("Action", null).show();

}

    public static void handleThrowable(Throwable throwable) {
        Log.e(TAG," Error Message: "+throwable.getMessage());
    }
}
