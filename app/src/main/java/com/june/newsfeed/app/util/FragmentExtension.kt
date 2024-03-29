package com.june.newsfeed.app.util

import android.os.Bundle
import android.support.v4.app.Fragment


fun Fragment.withArgs(
    argsBuilder: Bundle.() -> Unit
): Fragment = this.apply {
    arguments = Bundle().apply(argsBuilder)
}