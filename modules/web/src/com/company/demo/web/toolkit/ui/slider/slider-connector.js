com_company_demo_web_toolkit_ui_slider_SliderServerComponent = function() {
    var connector = this;
    var element = connector.getElement();
    $(element).html("<div/>");
    $(element).css("padding", "5px 10px");

    var slider = $("div", element).slider({
        range: true,
        slide: function(event, ui) {
            connector.valueChanged(ui.values);
        }
    });

    // Here we receive data from Server
    connector.onStateChange = function() {
        var state = connector.getState();
        slider.slider("values", state.values);
        slider.slider("option", "min", state.minValue);
        slider.slider("option", "max", state.maxValue);
        $(element).width(state.width);
    };

    // Here we receive call from Server
    connector.showNotification = function (greeting) {
        window.alert(greeting + connector.getState().values);
    }
};