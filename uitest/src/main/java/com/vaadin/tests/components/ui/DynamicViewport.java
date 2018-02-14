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

import com.vaadin.annotations.ViewportGeneratorClass;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.ViewportGenerator;
import com.vaadin.tests.components.AbstractReindeerTestUI;
import com.vaadin.tests.components.ui.DynamicViewport.MyViewportGenerator;
import com.vaadin.ui.Label;

@ViewportGeneratorClass(MyViewportGenerator.class)
public class DynamicViewport extends AbstractReindeerTestUI {

    public static final String VIEWPORT_DISABLE_PARAMETER = "noViewport";

    public static class MyViewportGenerator implements ViewportGenerator {
        @Override
        public String getViewport(VaadinRequest request) {
            if (request.getParameterMap()
                    .containsKey(VIEWPORT_DISABLE_PARAMETER)) {
                return null;
            }
            return request.getHeader("User-Agent");
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        String negation = request.getParameterMap()
                .containsKey(VIEWPORT_DISABLE_PARAMETER) ? "not " : "";
        addComponent(new Label(
                "I should " + negation + "have a dynamic viewport tag"));
    }
}
