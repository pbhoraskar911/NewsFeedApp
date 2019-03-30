package com.app.newsapp.utils

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.app.newsapp.view.activities.MainActivity


/**
 * @author Pranav Bhoraskar
 */

object AlertDialogHelper {

    fun noInternetConnection(context: Context, title: Int, content: Int) {
        MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText(android.R.string.ok)
                .neutralText(android.R.string.cancel)
                .onPositive { dialog, which ->
                    dialog.dismiss()
                    if (context is MainActivity) {
                        context.finish()
                    }
                }
                .onNeutral { dialog, which ->
                    dialog.dismiss()
                    if (context is MainActivity) {
                        context.finish()
                    }
                }
                .show()
    }
}