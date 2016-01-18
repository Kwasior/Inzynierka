package main.tsd.crypto.algoritm;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.navigator.Navigator;

public class StartView extends VerticalLayout implements View {

    public StartView() {
        //setSizeFull();
        addStyleName("CBC_VSPACING");
        Button button = new Button("AES",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        getUI().getNavigator().navigateTo("AES");

                    }
                });
        Button button2 = new Button("CBC",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        getUI().getNavigator().navigateTo("CBC");

                    }
                });
        Button button3 = new Button("CFB",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        getUI().getNavigator().navigateTo("CFB");

                    }
                });
        Button button4 = new Button("OFB",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        getUI().getNavigator().navigateTo("OFB");

                    }
                });
        Button button5 = new Button("CTR",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        getUI().getNavigator().navigateTo("CTR");

                    }
                });
        Button button6 = new Button("HMAC",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        getUI().getNavigator().navigateTo("HMAC");

                    }
                });
        addComponents(button,button2,button3,button4,button5,button6);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
        setComponentAlignment(button2, Alignment.MIDDLE_CENTER);
        setComponentAlignment(button3, Alignment.MIDDLE_CENTER);
        setComponentAlignment(button4, Alignment.MIDDLE_CENTER);
        setComponentAlignment(button5, Alignment.MIDDLE_CENTER);
        setComponentAlignment(button6, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}