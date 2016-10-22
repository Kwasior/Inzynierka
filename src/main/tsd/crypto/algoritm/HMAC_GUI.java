package main.tsd.crypto.algoritm;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;
import java.math.BigInteger;


public class HMAC_GUI extends HorizontalLayout implements View

{
    private Label key = new Label();
    private Label i_pad = new Label();
    private Label o_pad = new Label();
    private Label i_key_pad = new Label();
    private Label o_key_pad = new Label();
    private Label message = new Label();
    private Label hash11 = new Label();
    private Label hash12 = new Label();
    private Label hash2 = new Label();
    private Label keyHex = new Label();

    private Panel keyPanel = new Panel("Key");
    private Panel i_padPanel = new Panel("i_pad");
    private Panel o_padPanel = new Panel("o_pad");
    private Panel i_key_padPanel = new Panel("i_key_pad");
    private Panel o_key_padPanel = new Panel("o_key_pad");
    private Panel messagePanel = new Panel("message");
    private Panel hash1Panel1 = new Panel("hash1");
    private Panel hash1Panel2 = new Panel("hash1");
    private Panel hash2Panel = new Panel("hash2");

    private final TextField tekstPole = new TextField();
    private final TextField tekstPole2 = new TextField();

    public String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
    public FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/xorHMAC.png"));
    public FileResource resource2 = new FileResource(new File(basepath + "/WEB-INF/images/equalsHMAC.png"));
    public FileResource resource3 = new FileResource(new File(basepath + "/WEB-INF/images/hashHMAC.png"));

    VerticalLayout vertical = new VerticalLayout();
    VerticalLayout vertical2 = new VerticalLayout();
    VerticalLayout vertical3 = new VerticalLayout();
    VerticalLayout vertical4 = new VerticalLayout();
    HorizontalLayout horizontal = new HorizontalLayout();
    HorizontalLayout horizontal2 = new HorizontalLayout();
    HorizontalLayout horizontal3 = new HorizontalLayout();
    Image image = new Image("", resource);
    Image image2 = new Image("", resource2);
    Image image3 = new Image("", resource3);
    int step = 1;


    public HMAC_GUI() {


        message.addStyleName("Hmac");
        i_pad.addStyleName("Hmac");
        o_pad.addStyleName("Hmac");
        o_key_pad.addStyleName("Hmac");
        i_key_pad.addStyleName("Hmac");
        hash11.addStyleName("Hmac");
        hash12.addStyleName("Hmac");
        hash2.addStyleName("Hmac");
        keyHex.addStyleName("Hmac");

        keyPanel.setContent(keyHex);


        i_padPanel.setContent(i_pad);
        i_padPanel.setWidth("300px");
        o_padPanel.setContent(o_pad);
        o_padPanel.setWidth("300px");
        i_key_padPanel.setContent(i_key_pad);
        i_key_padPanel.setWidth("300px");
        o_key_padPanel.setContent(o_key_pad);
        o_key_padPanel.setWidth("300px");
        messagePanel.setContent(message);
        hash1Panel1.setContent(hash11);
        hash1Panel1.setWidth("180px");
        hash1Panel2.setContent(hash12);
        hash1Panel2.setWidth("180px");
        hash2Panel.setContent(hash2);
        hash2Panel.setWidth("180px");

        horizontal.addStyleName("CBC_VSPACING");
        horizontal.setSpacing(true);
        horizontal2.addComponents(b, b3, b2);
        vertical.addComponents(tekstPole, tekstPole2, horizontal2, bAES, bCBC, bCFB, bOFB, bCTR);


        vertical4.addComponents(vertical, horizontal, vertical2);
        addComponent(vertical4);


    }

    Button b = new Button("Licz",
            new Button.ClickListener() {
                @Override

                public void buttonClick(Button.ClickEvent event) {

                    StringBuilder sb = new StringBuilder();


                    message.setValue(tekstPole.getValue());
                    key.setValue(tekstPole2.getValue());

                    for (byte b : HMAC.generate(message.getValue().getBytes(), key.getValue().getBytes())) {
                        sb.append(String.format("%02X ", b));
                    }
                    hash2.setValue(sb.toString());
                    sb.delete(0, sb.length());


                    for (byte b : HMAC.o_key_pad) {
                        sb.append(String.format("%02X ", b));
                    }
                    o_key_pad.setValue(sb.toString());
                    sb.delete(0, sb.length());

                    for (byte b : HMAC.o_pad) {
                        sb.append(String.format("%02X ", b));
                    }
                    o_pad.setValue(sb.toString());
                    sb.delete(0, sb.length());

                    for (byte b : HMAC.i_pad) {
                        sb.append(String.format("%02X ", b));
                    }
                    i_pad.setValue(sb.toString());
                    sb.delete(0, sb.length());

                    for (byte b : HMAC.i_key_pad) {
                        sb.append(String.format("%02X ", b));
                    }
                    i_key_pad.setValue(sb.toString());
                    sb.delete(0, sb.length());


                    for (byte b : HMAC.resultTmp) {
                        sb.append(String.format("%02X ", b));
                    }
                    hash11.setValue(sb.toString());
                    sb.delete(0, sb.length());

                    for (byte b : HMAC.resultTmp) {
                        sb.append(String.format("%02X ", b));
                    }
                    hash12.setValue(sb.toString());
                    sb.delete(0, sb.length());

                    keyHex.setValue(toHex(tekstPole2.getValue()));

                    display(1);
                }
            });
    Button b2 = new Button(">",
            new Button.ClickListener() {
                @Override

                public void buttonClick(Button.ClickEvent event) {
                    step++;
                    if (step > 4)
                        step = 4;
                    display(step);
                }

            });
    Button b3 = new Button("<",
            new Button.ClickListener() {
                @Override

                public void buttonClick(Button.ClickEvent event) {
                    step--;
                    if (step < 1)
                        step = 1;
                    display(step);
                }

            });

    Button bAES = new Button("AES",
            new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {



                    getUI().getNavigator().removeView("HMAC");
                    getUI().getNavigator().addView("HMAC", new HMAC_GUI());
                    getUI().getNavigator().navigateTo("AES");

                }
            });

    Button bCBC = new Button("CBC",
            new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {



                    getUI().getNavigator().removeView("HMAC");
                    getUI().getNavigator().addView("HMAC", new HMAC_GUI());
                    getUI().getNavigator().navigateTo("CBC");

                }
            });

    Button bCFB = new Button("CFB",
            new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {



                    getUI().getNavigator().removeView("HMAC");
                    getUI().getNavigator().addView("HMAC", new HMAC_GUI());
                    getUI().getNavigator().navigateTo("CFB");

                }
            });
    Button bOFB = new Button("OFB",
            new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {



                    getUI().getNavigator().removeView("HMAC");
                    getUI().getNavigator().addView("HMAC", new HMAC_GUI());
                    getUI().getNavigator().navigateTo("OFB");

                }
            });
    Button bCTR = new Button("CTR",
            new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {



                    getUI().getNavigator().removeView("HMAC");
                    getUI().getNavigator().addView("HMAC", new HMAC_GUI());
                    getUI().getNavigator().navigateTo("CTR");

                }
            });


    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private void display(int step) {


        if (step == 1) {
            horizontal.removeAllComponents();
            horizontal.addComponents(keyPanel, image, i_padPanel, image2, i_key_padPanel);
            horizontal.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
            horizontal.setComponentAlignment(image2, Alignment.MIDDLE_CENTER);
        }

        if (step == 2) {
            horizontal.removeAllComponents();
            horizontal.addComponents(keyPanel, image, o_padPanel, image2, o_key_padPanel);
            horizontal.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
            horizontal.setComponentAlignment(image2, Alignment.MIDDLE_CENTER);
        }

        if (step == 3) {
            horizontal.removeAllComponents();
            horizontal.removeAllComponents();
            horizontal.addComponents(i_key_padPanel, messagePanel, image3, hash1Panel1);

        }

        if (step == 4) {
            horizontal.removeAllComponents();
            horizontal.removeAllComponents();
            horizontal.addComponents(o_key_padPanel, hash1Panel1, image3, hash2Panel);

        }
    }

    public String toHex(String arg) {

        return spacing(String.format("%02X ", new BigInteger(1, arg.getBytes())));
    }

    private String spacing(String in) {

        int interval = 2;
        char separator = ' ';

        StringBuilder sb = new StringBuilder(in);

        for (int i = 0; i < in.length() / interval; i++) {
            sb.insert(((i + 1) * interval) + i, separator);
        }

        String withDashes = sb.toString();
        return withDashes;
    }
}
