package com.company.demo.web.product;

import com.company.demo.entity.Product;
import com.company.demo.web.toolkit.ui.slider.SliderServerComponent;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.vaadin.ui.Button;
import com.vaadin.ui.Layout;

import javax.inject.Inject;

public class ProductEdit extends AbstractEditor<Product> {
    @Inject
    private ComponentsFactory componentsFactory;

    private SliderServerComponent slider;

    public Component createSlider(Datasource datasource, String fieldId) {
        Component box = componentsFactory.createComponent(VBoxLayout.class);

        slider = new SliderServerComponent();
        slider.setMinValue(0);
        slider.setMaxValue(100);
        slider.setWidth("240px");
        slider.setListener(newValue -> {
            getItem().setMinDiscount(newValue[0]);
            getItem().setMaxDiscount(newValue[1]);
        });

        // Add Vaadin Component to CUBA Container
        Layout layout = box.unwrap(Layout.class);
        layout.addComponent(slider);
        layout.addComponent(new Button("Show value", event -> {
            slider.showNotification("Value is: ");
        }));

        return box;
    }

    @Override
    protected void postInit() {
        super.postInit();

        slider.setValue(new double[]{
                getItem().getMinDiscount(),
                getItem().getMaxDiscount()
        });
    }

    @Override
    protected void initNewItem(Product item) {
        super.initNewItem(item);
        item.setMinDiscount(15.0);
        item.setMaxDiscount(70.0);
    }
}