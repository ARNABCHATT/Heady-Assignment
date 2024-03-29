package com.arnabchatterjee.newsdemo.utilites;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;

import com.arnabchatterjee.newsdemo.BuildConfig;

import java.util.Date;

import androidx.annotation.Nullable;

import static android.text.format.DateUtils.DAY_IN_MILLIS;
import static android.text.format.DateUtils.FORMAT_ABBREV_RELATIVE;
import static android.text.format.DateUtils.HOUR_IN_MILLIS;

import io.reactivex.disposables.Disposable;

public final class Utils {
    public static CharSequence formatDateTime(Context context, Date dateTime) {
        return DateUtils.getRelativeDateTimeString(
                context,
                dateTime.getTime(),
                HOUR_IN_MILLIS,
                5 * DAY_IN_MILLIS,
                FORMAT_ABBREV_RELATIVE
        );
    }

    public static void disposeSafe(@Nullable Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public static void setVisible(@Nullable View view, boolean show) {
        if (view == null) return;

        int visibility = show ? View.VISIBLE : View.GONE;
        view.setVisibility(visibility);
    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    private Utils() {
        throw new AssertionError("No instances");
    }
}
