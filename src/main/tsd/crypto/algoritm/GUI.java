package main.tsd.crypto.algoritm;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.UI;

import java.io.File;


@Theme("mytheme")

public class GUI extends UI {
    Navigator navigator;
    protected static final String MAINVIEW = "main";


    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Aplikacja");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        // navigator.addView("start", new StartView());

        navigator.addView("AES", new AES_GUI());
        navigator.addView("StartView", new StartView());
        navigator.addView("CBC", new CBC_GUI());
        navigator.addView("CFB", new CFB_GUI());
        navigator.addView("OFB", new OFB_GUI());
        navigator.addView("CTR", new CTR_GUI());
        navigator.addView("HMAC", new HMAC_GUI());
        getUI().getNavigator().navigateTo("StartView");


    }
}
