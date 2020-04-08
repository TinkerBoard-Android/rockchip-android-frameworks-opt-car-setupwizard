/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.car.setupwizardlib.util;

import static com.google.common.truth.Truth.assertThat;

import android.app.Activity;
import android.view.View;

import com.android.car.setupwizardlib.BaseDesignActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class CarSetupWizardUiUtilsTest {

    private static final int IMMERSIVE_MODE_FLAGS =
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;

    private Activity mActivity;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(BaseDesignActivity.class).create().get();
    }

    @Test
    public void maybeHideSystemUI() {
        CarSetupWizardUiUtils.maybeHideSystemUI(mActivity);
        assertThat(mActivity.getWindow().getDecorView().getSystemUiVisibility())
                .isEqualTo(IMMERSIVE_MODE_FLAGS);
    }

    @Test
    public void enableImmersiveMode() {
        CarSetupWizardUiUtils.enableImmersiveMode(mActivity.getWindow());
        assertThat(mActivity.getWindow().getDecorView().getSystemUiVisibility())
                .isEqualTo(IMMERSIVE_MODE_FLAGS);
    }
}