/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.components.ui;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class DynamicViewportTest extends SingleBrowserTest {

    @Test
    public void testGeneratedViewport() {
        openTestURL();

        WebElement viewportElement = findElement(
                By.cssSelector("meta[name=viewport]"));

        assertTrue(viewportElement.getAttribute("content").contains("Chrome"));
    }

    @Test
    public void testGeneratedEmptyViewport() {
        openTestURL(DynamicViewport.VIEWPORT_DISABLE_PARAMETER);

        List<WebElement> viewportElements = findElements(
                By.cssSelector("meta[name=viewport]"));

        assertTrue("There should be no viewport tags",
                viewportElements.isEmpty());
    }
}
